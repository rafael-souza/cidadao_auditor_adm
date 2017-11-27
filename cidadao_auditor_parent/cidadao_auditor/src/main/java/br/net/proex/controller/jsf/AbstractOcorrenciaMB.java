package br.net.proex.controller.jsf;

import java.util.Date;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.commons.AppConstants;
import br.net.proex.entity.FotoOcorrencia;
import br.net.proex.entity.FotoPrefeitura;
import br.net.proex.entity.HistoricoOcorrenciaEntity;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.entity.SecretariadoEntity;
import br.net.proex.enumeration.TipoModeloDocumento;
import br.net.proex.utils.GeraPdfUtils;
import br.net.proex.utils.ModeloDocumentoUtils;
import br.net.proex.utils.SendEmailUtils;

@PlcHandleException
@SPlcMB
public class AbstractOcorrenciaMB extends AppMB{

	
	@Inject @QPlcDefault
	protected GeraPdfUtils geraPdfUtil;	
	
	
	/**
	 * 
	 * @param enc
	 * @param ocorrencia
	 */
	public HistoricoOcorrenciaEntity criaObjetoHistorico(OcorrenciaEntity ocorrencia) {
		// criando os dados do histórico
		HistoricoOcorrenciaEntity historico = new HistoricoOcorrenciaEntity();
		historico.setDataHistorico(new Date());
		historico.setObservacao(ocorrencia.getObservacaoHistorico());
		historico.setResponsavel(userProfileVO.getUsuario().getPessoa().getNome());
		historico.setOcorrencia(ocorrencia);
		
		return historico;
		
	}
	
	
	/**
	 * 
	 * @param ocorrencia
	 */
	public void sendEmailResponsavel(OcorrenciaEntity ocorrencia, String subject, TipoModeloDocumento modelo) {
		
		String mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(ocorrencia, facade.findModeloDocumentoPorTipo(
				contextMontaUtil.createContextParamMinimum(), modelo));
				
		String destinatarios = getDestinatariosEmail(Boolean.TRUE, ocorrencia); 					
		
		if (SendEmailUtils.SendEmail(parametros, mensagem, subject, destinatarios)){
			msgUtil.msg(AppBeanMessages.EMAIL_ENVIADO_RESPONSAVEL,
					PlcMessage.Cor.msgAzulPlc.toString());		
		} else {
			msgUtil.msg(AppBeanMessages.EMAIL_ERRO_RESPONSAVEL,
					PlcMessage.Cor.msgVermelhoPlc.toString());
		}
		
	}
	
	
	/**
	 * 
	 * @param ocorrencia
	 */
	public void sendEmailCidadao(OcorrenciaEntity ocorrencia, String subject, TipoModeloDocumento modelo) {
		
		String mensagem = "";
		
		mensagem = ModeloDocumentoUtils.alimentaDadosDocumento(ocorrencia, facade.findModeloDocumentoPorTipo(
				contextMontaUtil.createContextParamMinimum(), modelo));
				
		String destinatarios = getDestinatariosEmail(Boolean.FALSE, ocorrencia); 
				
		if (SendEmailUtils.SendEmail(parametros, mensagem, subject, destinatarios)){
			msgUtil.msg(AppBeanMessages.EMAIL_ENVIADO_CIDADAO,
					PlcMessage.Cor.msgAzulPlc.toString());		
		} else {
			msgUtil.msg(AppBeanMessages.EMAIL_ERRO_CIDADAO,
					PlcMessage.Cor.msgVermelhoPlc.toString());
		}
		
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
	 * 
	 * @return
	 */
	public void emitirDocumento() {
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity)this.entityPlc;
		
		PlcBaseContextVO context = contextMontaUtil.createContextParamMinimum();
		
		// realizando o download da foto da ocorrencia se tiver 
		if (null != ocorrencia.getFotoOcorrencia()) {
			ocorrencia.setFotoOcorrencia((FotoOcorrencia) facade.downloadFile(context, FotoOcorrencia.class,
					ocorrencia.getFotoOcorrencia().getId()));
		}

		// fazendo download da foto do brasão da prefeitura
		PrefeituraEntity prefeitura = facade.findPrefeituraById(contextMontaUtil.createContextParamMinimum(), 1L);
		if (null != prefeitura.getBrasao()) {
			prefeitura.setBrasao((FotoPrefeitura) facade.downloadFile(context, FotoPrefeitura.class,
					prefeitura.getBrasao().getId()));
		}
				
		// substituindo os tokens
		ocorrencia.setTextoDocumento(ModeloDocumentoUtils.alimentaDadosDocumento(ocorrencia, facade.findModeloDocumentoPorTipo(context, 
				TipoModeloDocumento.OIMP)));
		
		// variaveis para alimentar o cabeçalho e rodape se tiver
		String cabecalho = facade.findModeloDocumentoPorTipo(context, TipoModeloDocumento.OCAB);
		String rodape = facade.findModeloDocumentoPorTipo(context, TipoModeloDocumento.OROD);
		
		// alimentando o token do brasao da prefeitura caso tenha
		if (null != prefeitura.getBrasao()){
			cabecalho.replaceAll(
					"#BRASAO_PREFEITURA#", ModeloDocumentoUtils.alimentaBrasaoPrfeitura(ocorrencia.getTextoDocumento(), prefeitura));
		} else {
			cabecalho.replaceAll("#BRASAO_PREFEITURA#", "");
		}
		
		ocorrencia.setTextoDocumento(geraPdfUtil.gerarHtmlPdf(ocorrencia.getTextoDocumento(), cabecalho, rodape));			
		
	}
	
	
	/**
	 * 
	 * @param inscricaoImobiliariaProcessoFiscal
	 * @param textoRodapeFormatado
	 * @param textoCabecalhoFormatado
	 * @return
	 */	
	private void realizaImpressaoDocumento() {
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) this.entityPlc;
		
		String enderecoFisico = ModeloDocumentoUtils.getEnderecoFisicoAplicacao()
				+ AppConstants.PASTA_ARQUIVOS_TEMPORARIOS;

		geraPdfUtil.criarPdf(ocorrencia.getTextoDocumento(),
				enderecoFisico + ocorrencia.getProtocolo() + ".pdf");

		geraPdfUtil.retornarPdf(enderecoFisico + ocorrencia.getProtocolo() + ".pdf");

	}

	
}
