package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.entity.FotoOcorrencia;
import br.net.proex.entity.HistoricoOcorrenciaEntity;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.enumeration.TipoModeloDocumento;

@PlcConfigAggregation(entity = br.net.proex.entity.OcorrenciaEntity.class,
details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
		clazz = br.net.proex.entity.HistoricoOcorrenciaEntity.class,
		collectionName = "historicoOcorrencia", numNew = 1,onDemand = false)			
})
@PlcConfigForm (
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/ocorrencia"))


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("ocorrencia")
@PlcHandleException
@SessionScoped
public class OcorrenciaMB extends AbstractOcorrenciaMB  {

	private static final long serialVersionUID = 1L;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("ocorrencia")
	public OcorrenciaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new OcorrenciaEntity();
              this.newEntity();
              
              carregaParametrosAplicacao();
        }
        return (OcorrenciaEntity)this.entityPlc;     	
	}
	
	/**
	 * 
	 */
	@Override
	public String edit() {	
		String retorno = super.edit();
		
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity)this.entityPlc;
		
		if (null != ocorrencia.getFotoOcorrencia()){
			ocorrencia.setFotoOcorrencia((FotoOcorrencia) facade.downloadFile(contextMontaUtil.createContextParamMinimum(),
					FotoOcorrencia.class, ocorrencia.getFotoOcorrencia().getId()));
		}
				
		
		return retorno;
	}
	
	/**
	 * 
	 */
	@Override
	public String save() {
		
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) this.getEntityPlc();
		
		if (null != ocorrencia.getStatusOcorrencia() && ocorrencia.getStatusOcorrencia().equals(StatusOcorrencia.ANA)){
			// enviando um e-mail ao cidadão para infomá-lo
			// enviando o e-mail ao cidadão
			sendEmailCidadao(ocorrencia,  "Ocorrência Protocolo: "  + ocorrencia.getProtocolo() + " em análise", TipoModeloDocumento.CANA);	
		}
		
		return super.save();
		
		
	}
	
	
	/**
	 * Coloca a ocorrência na situação em análise e encaminha ao resposável
	 */
	public void encaminhar(){
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) this.entityPlc;
		
		// verificando se a ocorrencia ja foi encaminhada
		if (ocorrencia.getStatusOcorrencia().equals(StatusOcorrencia.ENC)){
			msgUtil.msg(AppBeanMessages.OCORRENCIA_ENCAMINHADA,
					PlcMessage.Cor.msgVermelhoPlc.toString());			
			return;
		}
		
		// verificando se informou observação
		if (null == ocorrencia.getObservacaoHistorico() || (null != ocorrencia.getObservacaoHistorico() 
				&& ocorrencia.getObservacaoHistorico().isEmpty())){
			msgUtil.msg(AppBeanMessages.OBSERVACAO_OBRIGATORIO,
					PlcMessage.Cor.msgVermelhoPlc.toString());			
			return;
		}
		
		// criando o objeto do historico
		HistoricoOcorrenciaEntity historico = criaObjetoHistorico(ocorrencia);		
		// marcando a ocorrencia como encaminhada
		ocorrencia.setStatusOcorrencia(StatusOcorrencia.ENC);		
		// verificando se já possui algum registro de historico 
		if (null == ocorrencia.getHistoricoOcorrencia()){
			ocorrencia.setHistoricoOcorrencia(new ArrayList<HistoricoOcorrenciaEntity>());
		}		
		// inserindo o registro no histórico da ocorrência		
		ocorrencia.getHistoricoOcorrencia().add(historico);
		
		// salvando as alterações
		save();		
		
		// setando a mensagem para enviar no email
		ocorrencia.setObservacaoHistorico(historico.getObservacao());
		
		// enviando o e-mail ao responsável pela ocorrencia
		sendEmailResponsavel(ocorrencia,"Ocorrência Protocolo: "  + ocorrencia.getProtocolo() + " encaminhada para resolução.", TipoModeloDocumento.RENC);
		
		// enviando o e-mail ao cidadão
		sendEmailCidadao(ocorrencia,  "Ocorrência Protocolo: "  + ocorrencia.getProtocolo() + " encaminhada ao responsável", TipoModeloDocumento.CENC);	
		
		ocorrencia.setObservacaoHistorico(null);
	}


	/**
	 * 
	 */
	@Override
	public void handleButtonsAccordingFormPattern() {	
		super.handleButtonsAccordingFormPattern();
		Map<String, Object> requestMap = contextUtil.getRequestMap();		
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_CLONAR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_VISUALIZA_DOCUMENTO, PlcConstants.NAO_EXIBIR);
	}
	
}
