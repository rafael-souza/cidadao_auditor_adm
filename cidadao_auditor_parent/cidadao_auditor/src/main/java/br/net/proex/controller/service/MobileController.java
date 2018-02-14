package br.net.proex.controller.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.log4j.Logger;

import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.util.metamodel.PlcMetamodelUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.controller.rest.api.qualifiers.QPlcControllerName;
import com.powerlogic.jcompany.controller.rest.api.qualifiers.QPlcControllerQualifier;
import com.powerlogic.jcompany.controller.rest.api.stereotypes.SPlcController;
import com.powerlogic.jcompany.controller.rest.controllers.PlcBaseDynamicController;
import com.powerlogic.jcompany.controller.util.PlcBeanPopulateUtil;

import br.net.proex.commons.AppConstants;
import br.net.proex.entity.DenunciaEntity;
import br.net.proex.entity.FotoConteudoOcorrencia;
import br.net.proex.entity.FotoOcorrencia;
import br.net.proex.entity.HistoricoOcorrenciaEntity;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.ParametrosAplicacaoEntity;
import br.net.proex.entity.PesquisaEntity;
import br.net.proex.entity.PesquisaOpcaoEntity;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.entity.SecretariadoEntity;
import br.net.proex.entity.SugestaoEntity;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.enumeration.StatusSugestao;
import br.net.proex.enumeration.TipoModeloDocumento;
import br.net.proex.enumeration.TipoSugestao;
import br.net.proex.facade.IAppFacade;
import br.net.proex.utils.DateTimeUtils;
import br.net.proex.utils.ModeloDocumentoUtils;
import br.net.proex.utils.SendEmailUtils;

/**
 * Atende a /rest/mobile.<caso_de_uso>
 */
@SPlcController
@QPlcControllerName("mobile")
@QPlcControllerQualifier("*")
public class MobileController<E, I> extends PlcBaseDynamicController<E, I> {
	
	/** atributo meta model util */
	@Inject @QPlcDefault 
	protected PlcMetamodelUtil metamodelUtil;		
		
	/**  atributo bena populate util */
	@Inject @QPlcDefault
	protected PlcBeanPopulateUtil beanPopulateUtil;

	/** atributo context monta util */
	@Inject @QPlcDefault
	private PlcCreateContextUtil contextMontaUtil;
	
	/** atributo log  */
	@Inject
	protected transient Logger log;
	
	/** atributo request */
	private HttpServletRequest request;

	/** atributo token  */
	private String token;
	
	@Inject @QPlcDefault
	private IAppFacade facade;
	
	private String novaSenha;
	
	protected ParametrosAplicacaoEntity parametros;
	

	//cria instancia do propertyUtilsBean para evitar diversas chamadas a metodo syncronized
	private static PropertyUtilsBean propertyUtilsBean = BeanUtilsBean.getInstance().getPropertyUtils();
	
	/**
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	
	/**
	 * 
	 */
	protected void retrieveBefore(I identificadorEntidade) {
		System.out.println(identificadorEntidade);		
	};
		
	
	/**
	 * 
	 * @param request
	 */
	@Inject
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 
	 * @param token
	 */
	@Inject
	public void setToken(@QueryParam("token") String token) {
		this.token = token;
	}
	
	
	/**
	 * Método para atualização da senha da pessoa
	 */
	@Override
	protected void updateBefore() {
		// verificando se é uma atualização da pessoa
		if (getEntity() instanceof PessoaEntity){
			// buscando a pessoa pelo seu e-mail
			PessoaEntity pessoa = facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), getUsuarioToken());
			// gerando a nova senha para o cadastro da pessoa
			setNovaSenha(gerarSenhaAleatoria());
			// realiza a encriptação da senha
			pessoa.setSenha(gerarMD(getNovaSenha()));
			pessoa.setAlterouSenha(Boolean.TRUE);
			// setando a pessoa com os dados alterados no entity
			setEntity((E) pessoa);
		}
		
		// verificando se é uma votação de pesquisa
		if (getEntity() instanceof PesquisaOpcaoEntity){
			PesquisaOpcaoEntity pesquisaOpcao = facade.findPesquisaOpcaoById(contextMontaUtil.createContextParamMinimum(), getIdPesquisaOpcao());
			if (null == pesquisaOpcao.getVotos()){
				pesquisaOpcao.setVotos(0L);
			}
			pesquisaOpcao.setVotos(pesquisaOpcao.getVotos() + 1);
			// setando a pesquisa opção com o voto a mais no entity
			setEntity((E) pesquisaOpcao);
		}
		
		super.updateBefore();
	}
	
	/**
	 * Após a troca da senha deve ser enviado um e-mail para o usuario informando a nova senha
	 */
	@Override
	protected void updateAfter() {
		// verificando se é uma atualização de pessoa
		if (getEntity() instanceof PessoaEntity){
			PessoaEntity pessoa = (PessoaEntity) getEntity();
			// verificando se trocou a senha
			if (null != pessoa.getAlterouSenha() && pessoa.getAlterouSenha()){
				// carregando os parâmetros da aplicação
				carregaParametrosAplicacao();
				String mensagem = facade.findModeloDocumentoPorTipo(
						contextMontaUtil.createContextParamMinimum(), TipoModeloDocumento.CALT).replaceAll(AppConstants.NOVA_SENHA, getNovaSenha());
				// realizando o envio do e-mail com a nova senha
				SendEmailUtils.SendEmail(parametros, mensagem, "Cidadão Auditor - Nova Senha", pessoa.getEmail());
			}
		}
		super.updateAfter();
	}
	
	/**
	 * 
	 */
	@Override
	protected void insertBefore() {
		
	 if (getEntity() instanceof PessoaEntity){
			PessoaEntity pessoa = (PessoaEntity) this.getEntity();
			// ajustando a data de nascimento da pessoa caso ela tenha informado
			if (null != pessoa.getDataCadastro() && !pessoa.getDataCadastro().isEmpty()){ 
				pessoa.setDataNascimento(DateTimeUtils.string2Date(pessoa.getDataCadastro()));
			}
			
		} else 	if (getEntity() instanceof OcorrenciaEntity) {
			OcorrenciaEntity ocorrencia = (OcorrenciaEntity) getEntity();
			// informando a data
			ocorrencia.setDataOcorrencia(new Date());
			// informando o status em aberto
			ocorrencia.setStatusOcorrencia(StatusOcorrencia.ABE);
			// buscando a pessoa
			ocorrencia.setPessoa(facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), ocorrencia.getPessoa().getEmail()));
			// informando o tipo da ocorrencia
			ocorrencia.setTipoOcorrencia(facade.findTipoOcorrenciaById(contextMontaUtil.createContextParamMinimum(), ocorrencia.getIdTipo()));
			
			// verificando se as fotos foram tiradas
			if(null != ocorrencia.getFotoApp() && ocorrencia.getFotoApp().contains(",")){
				try {
					String base64Image = ocorrencia.getFotoApp().replace(" ", "+").split(",")[1];
					byte[] fotoFachada = Base64.getDecoder().decode(base64Image.getBytes());
					//byte[] fotoFachada = Base64.decode(base64Image);														
					// criand o objeto de conteudo
					FotoConteudoOcorrencia fotoConteudo = new FotoConteudoOcorrencia();
					fotoConteudo.setBinaryContent(fotoFachada);
					// criando o objeto da foto
					FotoOcorrencia foto = new FotoOcorrencia();							
					foto.setBinaryContent(fotoConteudo);
					foto.setNome(gerarMD(ocorrencia.getDataOcorrencia().toString()));
					foto.setType("image/jpg");	
					foto.setDataUltAlteracao(new Date());
					foto.setLength(fotoConteudo.getBinaryContent().length);					
					
					ocorrencia.setFotoOcorrencia(foto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		} else if (getEntity() instanceof SugestaoEntity) {
			SugestaoEntity sugestao = (SugestaoEntity) getEntity();
			sugestao.setDataSugestao(new Date());
			sugestao.setTipoSugestao(getTipoSugestao(sugestao.getDescTipo()));
			sugestao.setStatus(StatusSugestao.ENV);
			sugestao.setPessoa(facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), sugestao.getPessoa().getEmail()));
		} else if (getEntity() instanceof DenunciaEntity) {
			DenunciaEntity denuncia = (DenunciaEntity) getEntity();
			denuncia.setDataDenuncia(new Date());
			// caso não seja uma denuncia anonima busca a pessoa que esta criando
			if (null != denuncia.getPessoa() && null != denuncia.getPessoa().getEmail()){
				denuncia.setPessoa(facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), denuncia.getPessoa().getEmail()));
				denuncia.setDenunciaAnonima(Boolean.FALSE);
			} else {
				denuncia.setDenunciaAnonima(Boolean.TRUE);
			}
		} else if (getEntity() instanceof HistoricoOcorrenciaEntity) {
			HistoricoOcorrenciaEntity historicoOcorrencia = (HistoricoOcorrenciaEntity) getEntity();
			historicoOcorrencia.setOcorrencia(facade.findOcorrenciaById(contextMontaUtil.createContextParamMinimum(), historicoOcorrencia.getIdOcorrencia()));
			historicoOcorrencia.setDataHistorico(new Date());
		}
		
		super.insertBefore();
	}
	
	/**
	 * 
	 */
	@Override
	protected void insertAfter() {
		
		// carregando os parâmetros da aplicação para enviar um e-mail
		carregaParametrosAplicacao();
		
		String mensagem = "";
		String subject = "";
		String destinatarios = "";
		
		// verificando se é um histórico de ocorrencia (comentario do usuário)
		if (getEntity() instanceof HistoricoOcorrenciaEntity){
			HistoricoOcorrenciaEntity historico = (HistoricoOcorrenciaEntity) getEntity();
			// carregando os parâmetros da aplicação para enviar um e-mail
			OcorrenciaEntity ocorrencia = facade.findOcorrenciaById(contextMontaUtil.createContextParamMinimum(), historico.getOcorrencia().getId());

			// alimentando os dados do modelo de documento
			mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(ocorrencia, facade.findModeloDocumentoPorTipo(
					contextMontaUtil.createContextParamMinimum(), TipoModeloDocumento.CCOM));
			
			// titulo do e-mail
			subject = "Novo comentário na Ocorrência Protocolo: " + ocorrencia.getProtocolo();
			
			// coletando os destinatarios do e-mail
			destinatarios = getDestinatariosEmail(Boolean.TRUE, ocorrencia); 
			
		} else if (getEntity() instanceof OcorrenciaEntity){
			// se está inserindo uma nova ocorrencia realiza o envio do e-mail ao cidadão
			OcorrenciaEntity ocorrencia = (OcorrenciaEntity)getEntity();
			
			// alimentando os dados do modelo de documento
			mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(ocorrencia, facade.findModeloDocumentoPorTipo(
					contextMontaUtil.createContextParamMinimum(), TipoModeloDocumento.CNEW));
			// titulo do e-mail
			subject = "Recebemos sua Ocorrência";
			// coletando os destinatarios do email
			destinatarios = getDestinatariosEmail(Boolean.TRUE, ocorrencia);
		} else if (getEntity() instanceof SugestaoEntity){
			SugestaoEntity sugestao = (SugestaoEntity) this.getEntity();
			// alimentando os dados do modelo de documento
			mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(sugestao, facade.findModeloDocumentoPorTipo(
					contextMontaUtil.createContextParamMinimum(), TipoModeloDocumento.CSUG));
			// titulo do e-mail
			subject = "Recebemos sua Sugestão";
			// coletando os destinatarios do email
			destinatarios = getDestinatariosEmail(sugestao);	
		} else if (getEntity() instanceof DenunciaEntity){
			DenunciaEntity denuncia = (DenunciaEntity) this.getEntity();
			// alimentando os dados do modelo de documento
			mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(denuncia, facade.findModeloDocumentoPorTipo(
					contextMontaUtil.createContextParamMinimum(), TipoModeloDocumento.CDEN));
			// titulo do e-mail
			subject = "Recebemos sua Denuncia";
			// coletando os destinatarios do email
			destinatarios = getDestinatariosEmail(denuncia);	
		} else if (getEntity() instanceof PessoaEntity){
			PessoaEntity pessoa = (PessoaEntity) this.getEntity();
			// alimentando os dados do modelo de documento
			mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(pessoa, facade.findModeloDocumentoPorTipo(
					contextMontaUtil.createContextParamMinimum(), TipoModeloDocumento.CCRI));
			// titulo do e-mail
			subject = "Recebemos seu cadastro, mãos a obra!";
			// coletando os destinatarios do email
			destinatarios = pessoa.getEmail();	
		}
			
		
		// se tem algum texto na mensagem
		if (null != mensagem && !mensagem.isEmpty()){
			// enviando um e-mail aoo secretário responsável pela ocorrência
			SendEmailUtils.SendEmail(parametros, mensagem, subject, destinatarios);
		}
		
		super.insertAfter();
	}

	/**
	 * retorna o tipo da descrição em forma de enum
	 * @param descTipo
	 * @return
	 */
	private TipoSugestao getTipoSugestao(String descTipo) {
		// verificando o tipo da sugestao
		if (descTipo.equals("EDUC")){
			return TipoSugestao.EDUC;
		} else if (descTipo.equals("SAUD")){
			return TipoSugestao.SAUD;
		} else if (descTipo.equals("ESPO")){
			return TipoSugestao.ESPO;
		} else if (descTipo.equals("TURI")){
			return TipoSugestao.TURI;
		} else if (descTipo.equals("MEIO")){
			return TipoSugestao.MEIO;
		} else if (descTipo.equals("INFR")){
			return TipoSugestao.INFR;
		} else {
			return TipoSugestao.OUTR;
		}	
	}

	/**
	 * 
	 */
	@Override
	public void retrieveCollection() {
		try {

			// A entidade é utilizada como filtro.
			if (getEntity() == null) {
				E instancia = getEntityType().newInstance();
				beanPopulateUtil.transferMapToBean(request.getParameterMap(), instancia);
				
				setEntity(instancia);
			}
			
			// verificando se é para buscar os usuários
			if (getEntity() instanceof PessoaEntity){
				PessoaEntity pessoa = facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), getUsuarioToken());
				// setando o usuario que está sincronizado os dados
				this.setEntity((E) pessoa);	
				
				if (getAlterarSenhaToken()){
					// realiza a atualização do registro com a nova senha
					super.update();
				}
			}
			
			// quando e para buscar por ocorrencias faz o filtro por pessoas
			if (getEntity() instanceof OcorrenciaEntity){
				PessoaEntity pessoa = facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), getUsuarioToken());
				((OcorrenciaEntity) this.getEntity()).setPessoa(pessoa);
			}
			
			// verificando se e uma consulta de sugestão
			if (getEntity() instanceof SugestaoEntity){
				((SugestaoEntity) this.getEntity()).setProtocolo(getProtocoloToken());
			}
			
			// verificando se é uma consulta de denuncia
			if (getEntity() instanceof DenunciaEntity){
				((DenunciaEntity) this.getEntity()).setProtocolo(getProtocoloToken());
			}
			
			// verificando se é para buscar o histórico da ocorrencia
			if (getEntity() instanceof HistoricoOcorrenciaEntity){
				OcorrenciaEntity ocorrencia = new OcorrenciaEntity();
				ocorrencia.setId(getIdOcorrencia());
				((HistoricoOcorrenciaEntity) this.getEntity()).setOcorrencia(ocorrencia);
			}
			
			// verificando se é para buscar as opções de uma pesquisa
			if (getEntity() instanceof PesquisaOpcaoEntity){
				
				// se é para atualizar a pesquisa
				if (getAtualizarPesquisaOpcao()){
					super.update();
				} else {
					PesquisaEntity pesquisa = new PesquisaEntity();
					pesquisa.setId(getIdPesquisa());
					((PesquisaOpcaoEntity)this.getEntity()).setPesquisa(pesquisa);
				}
				
			}
			
			
			// recupera coleção sem paginação
			retrieveCollectionBefore();						
						
			try {
				if (getCollectionPage() != null && getCollectionPageRecords() != null) {
					retrievePagedCollection();
				} else {					
					
					if (getEntity() instanceof OcorrenciaEntity){
						//define quantidade de linhas para retornar na busca ao BD - 0 ilimitado
						setEntityCollection(ajustarFoto(facade.findOcorrenciaPorPessoa(contextMontaUtil.createContextParamMinimum(), ((OcorrenciaEntity)getEntity()).getPessoa().getId())));
					} else if (getEntity() instanceof SugestaoEntity) {
						SugestaoEntity sugestao = (SugestaoEntity) getEntity();
						setEntityCollection((Collection<E>)facade.buscarSugestaoPorProtocolo(getContext(), sugestao.getProtocolo()));
					} else if (getEntity() instanceof DenunciaEntity) {
						DenunciaEntity denuncia = (DenunciaEntity) getEntity();
						setEntityCollection((Collection<E>)facade.buscarDenunciaPorProtocolo(getContext(), denuncia.getProtocolo()));
					} else {
						setEntityCollection(facade.findList(getContext(), getEntity(), getCollectionOrder(), -1, 0));
					}
					 
				}
			} catch (Exception e) {
				handleExceptions(e);
			}
			
			retrieveCollectionAfter();
		} catch(PlcException plcE){
			throw plcE;	
		} catch (Exception e) {
			throw new PlcException("MobileController", "retrieveCollection", e, null, "");
		}
	}

	/**
	 * 
	 * @param listaOcorrencias
	 * @return
	 */
	private Collection<E> ajustarFoto(Collection listaOcorrencias) {
		List<OcorrenciaEntity> lista = (List<OcorrenciaEntity>) listaOcorrencias;
		List<OcorrenciaEntity> listaRetorno = new ArrayList<OcorrenciaEntity>();
		// verificando se a lista possui algum registro
		if (null != lista && lista.size() > 0){		
			// percorrendo a lista para ajustar as atividades
			for (OcorrenciaEntity ocorrencia : lista){
								
				ocorrencia = facade.findOcorrenciaById(contextMontaUtil.createContextParamMinimum(), ocorrencia.getId());
				if (null != ocorrencia.getFotoOcorrencia() && null != ocorrencia.getFotoOcorrencia().getId()){
					ocorrencia.setFotoOcorrencia((FotoOcorrencia) facade.downloadFile(contextMontaUtil.createContextParamMinimum(),
							FotoOcorrencia.class, ocorrencia.getFotoOcorrencia().getId()));
															
					StringBuilder sb = new StringBuilder();
					sb.append("data:image/png;base64,");
					sb.append(Base64.getEncoder().encodeToString(ocorrencia.getFotoOcorrencia().getBinaryContent().getBinaryContent()));
					ocorrencia.setConteudoBinarioFoto(sb.toString());
										
				}
				
				if (null != ocorrencia.getTipoOcorrencia() && null != ocorrencia.getTipoOcorrencia().getDescricao()){
					ocorrencia.setDescricaoTipo(ocorrencia.getTipoOcorrencia().getDescricao());
				}
				
				listaRetorno.add(ocorrencia);

			}
		}
				
		return (Collection<E>)listaRetorno;
	}
	
	/**
	 * Retorna se é para alterar a senha ou nao
	 * @return
	 */
	private Boolean getAlterarSenhaToken(){
		return (token.indexOf("alterarSenha")) == -1 ? Boolean.FALSE : Boolean.TRUE ;
	}
	
	/**
	 * Retorna se é para alterar a senha ou nao
	 * @return
	 */
	private Boolean getAtualizarPesquisaOpcao(){
		return (token.indexOf("votar")) == -1 ? Boolean.FALSE : Boolean.TRUE ;
	}

	/**
	 * Retorna o usuário que está acessando o sistema
	 * @return
	 */
	private String getUsuarioToken() {
		return token.substring(token.indexOf("(") + 1, token.lastIndexOf(")"));
	}
	
	/**
	 * Retorna o id da pesquisa desejada
	 * @return
	 */
	private Long getIdPesquisa() {
		return Long.valueOf(token.substring(token.indexOf("pesquisa=") + 9));
	}
	
	/**
	 * Retorna o id da pesquisa opcao desejada
	 * @return
	 */
	private Long getIdPesquisaOpcao() {
		return Long.valueOf(token.substring(token.indexOf("votar=") + 6));
	}
	
	/**
	 * Returna o conteudo do protocolo colocado após o ?
	 */
	private String getProtocoloToken() {
		return token.substring(token.indexOf("protocolo=") + 10);
	}
	
	/**
	 * Retora o id da ocorrencia em questao
	 * @return
	 */
	private Long getIdOcorrencia() {
		return Long.valueOf(token.substring(token.indexOf("ocorrencia=") + 11));
	}

	/**
	 * 
	 * @return
	 */
	public String getToken() {
		return token;
	}
	
	
	public String gerarMD(String md5) {
		MessageDigest md;
		StringBuffer sb = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}
	
	/**
	 * Realiza a geração de uma nova senha aleatória para a pessoa
	 * @return
	 */
	private String gerarSenhaAleatoria() {
        int qtdeMaximaCaracteres = 6;
        String[] caracteres = { "a", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z" };
       
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();
    }
	
	/**
	 * 
	 * @param denuncia
	 * @return
	 */
	public String getDestinatariosEmail(DenunciaEntity denuncia){
		String destinatarios = "";
		if (null != denuncia.getPessoa()){
			PessoaEntity pessoa = facade.findPessoaById(contextMontaUtil.createContextParamMinimum(), denuncia.getPessoa().getId());
			destinatarios = pessoa.getEmail();
		} 
		
		return destinatarios;
	}
	
	/**
	 * 
	 * @param sugestao
	 * @return
	 */
	public String getDestinatariosEmail(SugestaoEntity sugestao){
		String destinatarios;
		if (null == sugestao.getPessoa().getEmail()){
			PessoaEntity pessoa = facade.findPessoaById(contextMontaUtil.createContextParamMinimum(), sugestao.getPessoa().getId());
			destinatarios = pessoa.getEmail();
		} else {
			destinatarios = sugestao.getPessoa().getEmail();
		}
		
		return destinatarios;
	}
	
	/**
	 * 
	 * @param responsavel 
	 * @param ocorrencia
	 * @return
	 */
	public String getDestinatariosEmail(Boolean responsavel, OcorrenciaEntity ocorrencia) {
		String destinatarios = "";
		if (responsavel){
			// verificando qual o tipo da ocorrencia e quais as pessoas responsaveis pela mesma
			PrefeituraEntity prefeitura = facade.findPrefeituraById(contextMontaUtil.createContextParamMinimum(), 1L);
			
			if (null!= prefeitura && null != prefeitura.getSecretariado() && prefeitura.getSecretariado().size() > 0){
				for (SecretariadoEntity secretariado : prefeitura.getSecretariado()){				
					if (secretariado.getSecretaria().equals(ocorrencia.getTipoOcorrencia().getSecretaria())){
						if (destinatarios.isEmpty()){
							destinatarios = secretariado.getPessoa().getEmail();
						} else {
							destinatarios = destinatarios + "," + secretariado.getPessoa().getEmail();
						}
					}
				}								
			}			
		} else {
			if (null == ocorrencia.getPessoa().getEmail()){
				PessoaEntity pessoa = facade.findPessoaById(contextMontaUtil.createContextParamMinimum(), ocorrencia.getPessoa().getId());
				destinatarios = pessoa.getEmail();
			} else {
				destinatarios = ocorrencia.getPessoa().getEmail();
			}
		}
						
		return destinatarios;
	}	

	/**
	 * @return the novaSenha
	 */
	public String getNovaSenha() {
		return novaSenha;
	}

	/**
	 * @param novaSenha the novaSenha to set
	 */
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	
	/**
	 * 
	 */	
	public void carregaParametrosAplicacao(){
		  // se ainda não carregou os parametros da aplicação
        if (null == parametros){            
			List<ParametrosAplicacaoEntity> listaParametros = (List<ParametrosAplicacaoEntity>) facade.findList(
          		  contextMontaUtil.createContextParamMinimum(), new ParametrosAplicacaoEntity(), "", 0, 0);
            if (null != listaParametros && listaParametros.size() > 0){
          	  parametros = listaParametros.get(0);
            }
        }
	}
	

}
