/*  																													
	    				   jCompany Developer Suite																		
			    		Copyright (C) 2008  Powerlogic																	
	 																													
	    Este programa é licenciado com todos os seus códigos fontes. Você pode modificá-los e							
	    utilizá-los livremente, inclusive distribuí-los para terceiros quando fizerem parte de algum aplicativo 		
	    sendo cedido, segundo os termos de licenciamento gerenciado de código aberto da Powerlogic, definidos			
	    na licença 'Powerlogic Open-Source Licence 2.0 (POSL 2.0)'.    													
	  																													
	    A Powerlogic garante o acerto de erros eventualmente encontrados neste código, para os clientes licenciados, 	
	    desde que todos os códigos do programa sejam mantidos intactos, sem modificações por parte do licenciado. 		
	 																													
	    Você deve ter recebido uma cópia da licença POSL 2.0 juntamente com este programa.								
	    Se não recebeu, veja em <http://www.powerlogic.com.br/licencas/posl20/>.										
	 																													
	    Contatos: plc@powerlogic.com.br - www.powerlogic.com.br 														
																														
 */ 
package br.net.proex.controller.jsf;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.PlcConstants.MODOS;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefaultLiteral;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.commons.util.cdi.PlcCDIUtil;
import com.powerlogic.jcompany.commons.util.cdi.PlcNamedLiteral;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.controller.bindingtype.PlcHandleButtonsAccordingUseCaseAfter;
import com.powerlogic.jcompany.controller.jsf.PlcBaseMB;
import com.powerlogic.jcompany.controller.jsf.action.util.PlcRequestControl;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.controller.jsf.util.PlcContextUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcViewJsfUtil;
import com.powerlogic.jcompany.controller.util.PlcCacheUtil;
import com.powerlogic.jcompany.controller.util.PlcConfigUtil;
import com.powerlogic.jcompany.controller.util.PlcURLUtil;

import br.net.proex.commons.AppConstants;
import br.net.proex.commons.AppUserProfileVO;
import br.net.proex.entity.ParametrosAplicacaoEntity;
import br.net.proex.entity.seg.SegPerfil;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegPerfilMenu;
import br.net.proex.entity.seg.SegPerfilMenuAcaoNegadoEntity;
import br.net.proex.entity.seg.SegPerfilMenuCampoEntity;
import br.net.proex.entity.seg.SegUsuarioPerfilEntity;
import br.net.proex.enumeration.SegAcao;
import br.net.proex.enumeration.SegAcaoRealizada;
import br.net.proex.enumeration.SegVisibilidadeCampo;
import br.net.proex.facade.IAppFacade;

@PlcHandleException
@SPlcMB
public class AppMB extends PlcBaseMB {
	
	@Inject  @QPlcDefault
	protected IAppFacade facade;
	
    @Inject @QPlcDefault
    private PlcURLUtil urlUtil;
	
	@Inject @QPlcDefault
	protected AppUserProfileVO userProfileVO;		
	
	@Inject @QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;
	
	/** Serviço injetado e gerenciado pelo CDI */
	@Inject @QPlcDefault 
	protected PlcContextUtil contextUtil;	
	
	@Inject @QPlcDefault
	protected PlcViewJsfUtil viewJsfUtil;	
	
	/** Poisção atual do paginação de entidades */
	private int posAtual = 0;
	
	/** Numero total de registros de entidades */
	private Long numTotalRegistros = 0L;
	
	/** Lista com os id da seleção  */
	private List<Long> listaId;
	
	private Long nextId;
	
	private Long previousId;
	
	private Long firstId;
	
	private Long lastId;
	
	@Inject @QPlcDefault
	protected HttpServletRequest request;

	@Inject @QPlcDefault 
	protected PlcConfigUtil configUtil;	
	
	@Inject
	protected transient Logger log;
	
	@Inject @QPlcDefault
	private PlcCacheUtil cacheUtil;	
	
	protected ParametrosAplicacaoEntity parametros;
		
	
	/**
	 * Retorno ao endereço fisico da aplicação para geração de arquivos 
	 * @return
	 */
	public static String getEnderecoFisicoAplicacao(){
		// criando o endereco fisico para armazenar a imagem
		String aplicacao = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();		
		return System.getProperty("catalina.home") + "/" +"webapps" + aplicacao;
		
	}
	
	/**
	 * Retorna o endereço logico da aplicação para referenciar arquivos
	 * @return
	 */
	public static String getEnderecoLogicoAplicacao(){
		 // criando o endereço logico para referenciar a imagem
		String aplicacao = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();		
		StringBuffer enderecoLogico = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURL();				
		return enderecoLogico.substring(0, enderecoLogico.indexOf(aplicacao)) + aplicacao;		
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
	
		
	/**
	 * 
	 * @param plcBaseMB
	 */
	public void handleButtonsAccordingFormPattern(@Observes @PlcHandleButtonsAccordingUseCaseAfter PlcBaseMB plcBaseMB) {
		Map<String, Object> requestMap = contextUtil.getRequestMap();		
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_IMPRIMIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_VISUALIZA_DOCUMENTO, PlcConstants.NAO_EXIBIR);
		
		
		
		String uriPath = urlUtil.resolveCollaborationNameFromUrl(contextUtil.getRequest());
		HttpServletRequest request = contextUtil.getRequest();
		SegPerfil perfil = new SegPerfilEntity();		
				
		uriPath = "/f/n/" + uriPath;
		if (userProfileVO.getUsuario() != null){
			for (SegUsuarioPerfilEntity usuarioPerfil : userProfileVO.getUsuario().getUsuarioPerfil()){						
				perfil = usuarioPerfil.getPerfil();	
				//perfil = facade.findByPerfil(contextMontaUtil.createContextParamMinimum(), usuarioPerfil.getPerfil());
				for (SegPerfilMenu menu : perfil.getPerfilMenu()) {
					String urlMenu = menu.getMenu().getUrl().startsWith("/f/n/") ? menu.getMenu().getUrl()	: "/f/n/" + menu.getMenu().getUrl();
					
					if (uriPath.substring(0, uriPath.length() - 3).equals(urlMenu)){
						
						// criando regras para aplicar nos botões
						if (menu.getPerfilMenuAcaoNegado() != null && menu.getPerfilMenuAcaoNegado().size() > 0){
							for (SegPerfilMenuAcaoNegadoEntity menuAcao : menu.getPerfilMenuAcaoNegado()){
								if (menuAcao.getAcao().equals(SegAcao.CAN)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_CANCELAR);
								} else if (menuAcao.getAcao().equals(SegAcao.CAP)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_CANCELAR_POPUP);
								} else if (menuAcao.getAcao().equals(SegAcao.INC)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_INCLUIR);
								} else if (menuAcao.getAcao().equals(SegAcao.IND)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_JCOMPANY_EVT_INCLUIR_DETALHE);
								} else if (menuAcao.getAcao().equals(SegAcao.INS)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_JCOMPANY_EVT_INCLUIR_SUBDETALHE);
								} else if (menuAcao.getAcao().equals(SegAcao.GRA)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_GRAVAR);
								} else if (menuAcao.getAcao().equals(SegAcao.EXC)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_EXCLUIR);
								} else if (menuAcao.getAcao().equals(SegAcao.EXD)){
									visaoJsfUtil.hideWithLabel(request, "indExcPlc");							
								} else if (menuAcao.getAcao().equals(SegAcao.EXS)){
									visaoJsfUtil.hideWithLabel(request, "indExcPlc");									
								} else if (menuAcao.getAcao().equals(SegAcao.ABR)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_ABRIR);									
								} else if (menuAcao.getAcao().equals(SegAcao.PES)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_PESQUISAR);
								} else if (menuAcao.getAcao().equals(SegAcao.GER)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_GERAR_RELATORIO);
								} else if (menuAcao.getAcao().equals(SegAcao.IMP)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_IMPRIMIR);
								} else if (menuAcao.getAcao().equals(SegAcao.CLO)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_CLONAR);
								}  else if (menuAcao.getAcao().equals(SegAcao.PED)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_PESQUISAR_DETALHE);
								}  else if (menuAcao.getAcao().equals(SegAcao.EXP)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_EXPORTA);
								} else if (menuAcao.getAcao().equals(SegAcao.LIM)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_LIMPAR);
								} else if (menuAcao.getAcao().equals(SegAcao.UPL)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_UPLOAD);
								} else if (menuAcao.getAcao().equals(SegAcao.AJU)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_AJUDA);
								} else if (menuAcao.getAcao().equals(SegAcao.APR)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_APROVA);
								} else if (menuAcao.getAcao().equals(SegAcao.REP)){
									viewJsfUtil.hideAction(request, PlcConstants.ACAO.EXIBE_BT_REPROVA);
								}
							}
						}
						
						// criando o mapa de recursos para aplicar a regra dos campos
						if (menu.getPerfilMenuCampo() != null && menu.getPerfilMenuCampo().size() > 0){
							for (SegPerfilMenuCampoEntity menuCampo : menu.getPerfilMenuCampo()){								
								if (menuCampo.getVisibilidadeCampo().equals(SegVisibilidadeCampo.INV)){
									viewJsfUtil.hideWithLabel(request, menuCampo.getMenuCampo().getIdCampo()); 				
								} else if (menuCampo.getVisibilidadeCampo().equals(SegVisibilidadeCampo.SOL)){
									viewJsfUtil.registerReadonlyComponent(menuCampo.getMenuCampo().getIdCampo(), 
											menuCampo.getMenuCampo().getParametro(), Boolean.TRUE);									
									//requestMap.put("visualizaCampoPlc", "p");
								}																																				
							}
						}
						
						break;
					}														
				}
			}						 										
		}
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public String search() {
		log.info("Método pesquisa da bridge");
		return super.search();
	}
	
	@Override
	public String create() {
		
		String url = urlUtil.resolveCollaborationNameFromUrl(contextUtil.getRequest());
		FormPattern pattern = configUtil.getConfigAggregation(url).pattern().formPattern();
		if (FormPattern.Sel.equals(pattern)){
			limpaSessionObjects();
		}
//		String detCorrPlc = null;
//		if (getPlcRequestControl() != null){
//			detCorrPlc = getPlcRequestControl().getDetCorrPlc();
//		}
//	
//		if (StringUtils.isEmpty(detCorrPlc)){
//			limpaSessionObjects();	
//		}
			
		return super.create();
	}
	
	@Override
	public String delete() {
		registraDadosAuditoria(PlcCDIUtil.getInstance().getInstanceByType(PlcContextUtil.class, QPlcDefaultLiteral.INSTANCE), SegAcaoRealizada.EXC);
		limpaSessionObjects();
		return super.delete();
	}
	
	@Override
	public String cloneEntity() {
		limpaSessionObjects();
		return super.cloneEntity();
	}
	
	@Override @SuppressWarnings("unchecked") 
	public String edit() {
		String retorno = super.edit();		
		String action = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		action = action.substring(0,action.length()-3);
		// armazenando a lista de registros filtrados
         Object obj = cacheUtil.getObject(AppConstants.SESSION_LIST_ID + "_" + action);
         if (null != obj){
        	 setListaId((List<Long>) obj);
         }
		// verificando se passou pela seleção no grid
		if (null != getListaId()) {
			// armazenando a posição atual
			setPosAtual(getPosicaoAtual());			
			
			// armazenando o número total de registros
			if (0L == getNumTotalRegistros()){
				setNumTotalRegistros(getListaId().size());
			}
			
			// setando o primeiro registro
			if (null == getFirstId()){
				setFirstId(getListaId().get(0));
			}
			
			// setando o último registro
			if (null == getLastId()){
				setLastId(getListaId().get(getListaId().size() -1));
			}
			
			if (getIdAtual().equals(getLastId())){
				setNextId(null);
			} else { 
				// setando o próximo registro
				setNextId(pesquisaProximoAnterior(getListaId(), Boolean.TRUE));
			}
			
			if (getIdAtual().equals(getFirstId())){
				setPreviousId(null);
			} else {
				// setando o registro anterior
				setPreviousId(pesquisaProximoAnterior(getListaId(), Boolean.FALSE));
			}
						
		}
		
		return retorno; 
	}
	
	/**
	 * Limpa os objetos de controle de navegação entre as entidades
	 */
	private void limpaSessionObjects() {		
		String action = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		action = action.substring(0,action.length()-3);		
		cacheUtil.putObject(AppConstants.SESSION_LIST_ID + "_" + action, "");
		
		setListaId(null);
		setLastId(null);
		setFirstId(null);
		setNextId(null);		
	}
	

	
	/**
	 * Procura a posição atual do objeto na lista
	 * @return
	 */
	private int getPosicaoAtual() {
		// pegando o id atual para saber sua posição
		Long idAtual = getIdAtual();					
		// percorrendo a lista de id
		for (int i = 0; i < getListaId().size(); i++) {		
			// se é o id atual
			if (getListaId().get(i).equals(idAtual)){																						
				return i + 1;							
			}			
		}		
		return 0;		
	}


	/**
	 * Retorna o id do objeto atual
	 * @return
	 */
	private Long getIdAtual() {
		try {
			return (Long) PropertyUtils.getProperty(getEntityPlc(), AppConstants.ID);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}		
		return 0L;
	}

	/**
	 * Percorre a lista de id e devolve o proximo ou o anterior
	 * @param listaId
	 * @param proximo - TRUE, irá devolver o próximo registro - FALSE, irá devolver o registro anterior
	 * @return 
	 */
	private Long pesquisaProximoAnterior(List<Long> listaId, Boolean proximo) {
		Long idAtual = getIdAtual();	
		// percorrendo a lista de id
		for (int i = 0; i < listaId.size(); i++) {				
			// se é o id atual
			if (listaId.get(i).equals(idAtual)){
				// verifica se é o proximo
				if (proximo){															
					return listaId.get(i + 1);
				} else {
					return listaId.get(i - 1);
				}				
			}			
		}		
		return 0L;
	}

	/**
	 * @return the posAtual
	 */
	public int getPosAtual() {
		return posAtual;
	}


	/**
	 * @param posAtual the posAtual to set
	 */
	public void setPosAtual(int posAtual) {
		this.posAtual = posAtual;
	}

	/**
	 * @return the numTotalRegistros
	 */
	public long getNumTotalRegistros() {
		return numTotalRegistros;
	}


	/**
	 * @param numTotalRegistros the numTotalRegistros to set
	 */
	public void setNumTotalRegistros(long numTotalRegistros) {
		this.numTotalRegistros = numTotalRegistros;
	}

	/**
	 * @return the nextId
	 */
	public Long getNextId() {
		return nextId;
	}

	/**
	 * @param nextId the nextId to set
	 */
	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}

	/**
	 * @return the previousId
	 */
	public Long getPreviousId() {
		return previousId;
	}

	/**
	 * @param previousId the previousId to set
	 */
	public void setPreviousId(Long previousId) {
		this.previousId = previousId;
	}



	/**
	 * @return the lastId
	 */
	public Long getLastId() {
		return lastId;
	}

	/**
	 * @param lastId the lastId to set
	 */
	public void setLastId(Long lastId) {
		this.lastId = lastId;
	}

	/**
	 * @return the firstId
	 */
	public Long getFirstId() {
		return firstId;
	}

	/**
	 * @param firstId the firstId to set
	 */
	public void setFirstId(Long firstId) {
		this.firstId = firstId;
	}

	/**
	 * @return the listaId
	 */
	public List<Long> getListaId() {
		return listaId;
	}

	/**
	 * @param listaId the listaId to set
	 */
	public void setListaId(List<Long> listaId) {
		this.listaId = listaId;
	}
	
	/**
	 * 
	 * @return
	 */
	protected PlcRequestControl getPlcRequestControl() {
		return PlcCDIUtil.getInstance().getInstanceByType(PlcRequestControl.class, new PlcNamedLiteral(PlcConstants.PlcJsfConstantes.PLC_CONTROLE_REQUISICAO));
	}
	
	
	/**
	 * 
	 * @return
	 */
	public FormPattern getFormPattern() {
		String url = urlUtil.resolveCollaborationNameFromUrl(contextUtil.getRequest());
		return configUtil.getConfigAggregation(url).pattern().formPattern();
	}
	
	@Override
	public void newEntity() {		
		super.newEntity();	
	}		
	
	/**
	 * formatando a data para melhor visualização
	 * @param data
	 * @return
	 */
	public String formataData(Date data) {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return dataFormatada.format(data);
	}
	
	
	/**
	 * 
	 */
	@Override
	public String save() {
		registraDadosAuditoria(PlcCDIUtil.getInstance().getInstanceByType(PlcContextUtil.class, QPlcDefaultLiteral.INSTANCE), null);
		return super.save();
	}
	
	/**
	 * 
	 * @param contextUtil
	 * @param acaoRealizada
	 */
	private void registraDadosAuditoria(PlcContextUtil contextUtil, SegAcaoRealizada acaoRealizada) {		
		HttpServletRequest request = contextUtil.getRequest();		
   		userProfileVO.setCasoDeUso((String)request.getAttribute("plcManagedBeanKey"));
   		
   		if (acaoRealizada == null){
			String acaoRequest = (String) request.getAttribute(MODOS.MODO);
			if (acaoRequest.equals("alteracaoPlc")){
				userProfileVO.setAcaoRealizada(SegAcaoRealizada.ALT);
			} else if (acaoRequest.equals("inclusaoPlc")){
				userProfileVO.setAcaoRealizada(SegAcaoRealizada.INS);				
			}
   		} else {
   			userProfileVO.setAcaoRealizada(acaoRealizada);
   		}
	}	
	
	/**
	 * Registrando que o usuário saiu do sistema
	 */
	@Override
	public String logout() throws Exception {
		return super.logout();
	}
		
}
