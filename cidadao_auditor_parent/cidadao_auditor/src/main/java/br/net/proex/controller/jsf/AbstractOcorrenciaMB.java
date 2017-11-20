package br.net.proex.controller.jsf;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.inject.Inject;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.entity.SecretariadoEntity;
import br.net.proex.utils.GeraPdfUtil;
import br.net.proex.utils.SendEmailUtils;

@PlcHandleException
@SPlcMB
public class AbstractOcorrenciaMB extends AppMB{

	
	@Inject @QPlcDefault
	protected GeraPdfUtil geraPdfUtil;	
	
	
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
	public void sendEmailResponsavel(OcorrenciaEntity ocorrencia, String subject) {
		
		String mensagem = alimentaDadosDocumento(ocorrencia, parametros.getModeloMensagemResponsavel());
				
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
	public void sendEmailCidadao(OcorrenciaEntity ocorrencia, String subject) {
		
		String mensagem = alimentaDadosDocumento(ocorrencia, parametros.getModeloMensagemCidadao());
				
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
	public String alimentaDadosDocumento(OcorrenciaEntity ocorrencia, String documento) {
		// substituindo os tokens
		if (null != ocorrencia.getPessoa().getNome()){
			documento = documento.replaceAll(AppConstants.NOME_CIDADAO, ocorrencia.getPessoa().getNome());
		} else {
			documento = documento.replaceAll(AppConstants.NOME_CIDADAO, "");
		}
		
		if (null != ocorrencia.getId()){
			documento = documento.replaceAll(AppConstants.COD_OCORRENCIA, ocorrencia.getId().toString());
		} else {
			documento = documento.replaceAll(AppConstants.COD_OCORRENCIA, "");
		}
		
		if (null !=  ocorrencia.getTipoOcorrencia().getDescricao()){
			documento = documento.replaceAll(AppConstants.TIPO_OCORRENCIA, ocorrencia.getTipoOcorrencia().getDescricao());
		} else {
			documento = documento.replaceAll(AppConstants.TIPO_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getDataFormatada()){
			documento = documento.replaceAll(AppConstants.DATA_OCORRENCIA, ocorrencia.getDataFormatada());
		} else {
			documento = documento.replaceAll(AppConstants.DATA_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getEndereco()){
			documento = documento.replaceAll(AppConstants.ENDERECO_OCORRENCIA, ocorrencia.getEndereco());
		} else {
			documento = documento.replaceAll(AppConstants.ENDERECO_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getProtocolo()){
			documento = documento.replaceAll(AppConstants.PROTOCOLO_OCORRENCIA, ocorrencia.getProtocolo());
		} else {
			documento = documento.replaceAll(AppConstants.PROTOCOLO_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getDescricaoStatus()){
			documento = documento.replaceAll(AppConstants.STATUS_OCORRENCIA, ocorrencia.getDescricaoStatus());
		} else {
			documento = documento.replaceAll(AppConstants.STATUS_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getObservacao()){
			documento = documento.replaceAll(AppConstants.OBSERVACAO_CIDADAO, ocorrencia.getObservacao());
		} else {
			documento = documento.replaceAll(AppConstants.OBSERVACAO_CIDADAO, "");
		}
		
		if (null != ocorrencia.getObservacaoHistorico()){
			documento = documento.replaceAll(AppConstants.OBSERVACAO_RESPONSAVEL, ocorrencia.getObservacaoConclusao());
		} else {
			documento = documento.replaceAll(AppConstants.OBSERVACAO_RESPONSAVEL, "");
		}
		
		if (null != ocorrencia.getDataConclusao()){
			documento = documento.replaceAll(AppConstants.DATA_CONCLUSAO, ocorrencia.getDataConclusaoFormatada());
		} else {
			documento = documento.replaceAll(AppConstants.DATA_CONCLUSAO, "");
		}
		
		if (null != ocorrencia.getResponsavelConclusao()){
			documento = documento.replaceAll(AppConstants.RESPONSAVEL_CONCLUSAO, ocorrencia.getResponsavelConclusao());
		} else {
			documento = documento.replaceAll(AppConstants.RESPONSAVEL_CONCLUSAO, "");
		}
				
		// verificando se é a foto da ocorrencia
		if (null != ocorrencia.getFotoOcorrencia()){
			documento = documento.replaceAll(AppConstants.FOTO_OCORRENCIA, insereValorImagem(ocorrencia));
		} else {
			documento = documento.replaceAll(AppConstants.FOTO_OCORRENCIA, "");
		}
										
		return documento;
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
					if (secretariado.getTipo().equals(ocorrencia.getTipoOcorrencia().getSecretariaResponsavel())){
						if (destinatarios.isEmpty()){
							destinatarios = secretariado.getPessoa().getEmail();
						} else {
							destinatarios = destinatarios + "," + secretariado.getPessoa().getEmail();
						}
					}
				}								
			}			
		} else {
			destinatarios = ocorrencia.getPessoa().getEmail();
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
		ocorrencia.setTextoDocumento(alimentaDadosDocumento(ocorrencia, parametros.getModeloDocumentoOcorrencia()));
		
		// alimentando o token do brasao da prefeitura caso tenha
		if (null != prefeitura.getBrasao()){
			parametros.setCabecalhoDocumentoOcorrencia(parametros.getCabecalhoDocumentoOcorrencia().replaceAll(
					"#BRASAO_PREFEITURA#", alimentaBrasaoPrfeitura(ocorrencia.getTextoDocumento(), prefeitura)));
		} else {
			parametros.setCabecalhoDocumentoOcorrencia(parametros.getCabecalhoDocumentoOcorrencia().replaceAll(
					"#BRASAO_PREFEITURA#", ""));
		}
		
		ocorrencia.setTextoDocumento(geraPdfUtil.gerarHtmlPdf(ocorrencia.getTextoDocumento(), 
				parametros.getCabecalhoDocumentoOcorrencia(), parametros.getRodapeDocumentoOcorrencia()));			
		
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
		
		String enderecoFisico = getEnderecoFisicoAplicacao()
				+ AppConstants.PASTA_ARQUIVOS_TEMPORARIOS;

		geraPdfUtil.criarPdf(ocorrencia.getTextoDocumento(),
				enderecoFisico + ocorrencia.getProtocolo() + ".pdf");

		geraPdfUtil.retornarPdf(enderecoFisico + ocorrencia.getProtocolo() + ".pdf");

	}
	
	
	
	/**
	 * 
	 * @param textoDocumento
	 * @param prefeitura
	 * @return
	 */
	private String alimentaBrasaoPrfeitura(String textoDocumento, PrefeituraEntity prefeitura) {
		try {							
			String nomeImagem = "";
						
			// nome da imagem com a pasta temporaria 
			nomeImagem = AppConstants.PASTA_ARQUIVOS_TEMPORARIOS + 
					prefeitura.getBrasao().getNome() + "." + 
					prefeitura.getBrasao().getType().substring(6); 
												
		    File file = new File(getEnderecoFisicoAplicacao() + nomeImagem);  
		    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		    bos.write(prefeitura.getBrasao().getBinaryContent().getBinaryContent());  
		    bos.close();
					    	
		    return "<img src=\"" + getEnderecoLogicoAplicacao() 
		    	+ nomeImagem + "\" style=\"height:70px; width:70px\" />";
		    						
		} catch (Exception e) {
			return null;
		} 
	}


	/**
	 * 
	 * @param ocorrencia
	 * @return
	 */
	private static String insereValorImagem(OcorrenciaEntity ocorrencia) {
		try {	
			String nomeImagem = "";
						
			// nome da imagem com a pasta temporaria 
			nomeImagem = AppConstants.PASTA_ARQUIVOS_TEMPORARIOS + 
					ocorrencia.getFotoOcorrencia().getNome() + "." + 
					ocorrencia.getFotoOcorrencia().getType().substring(6); 
												
		    File file = new File(getEnderecoFisicoAplicacao() + nomeImagem);  
		    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		    bos.write(ocorrencia.getFotoOcorrencia().getBinaryContent().getBinaryContent());  
		    bos.close();
					    	
		    return "<img src=\"" + getEnderecoLogicoAplicacao() 
		    	+ nomeImagem + "\" style=\"height:200px; width:200px\" />";
		    						
		} catch (Exception e) {
			return null;
		}  		
	}		
	
	
}
