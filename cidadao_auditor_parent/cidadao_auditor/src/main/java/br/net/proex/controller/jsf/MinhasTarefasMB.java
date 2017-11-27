package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.enterprise.inject.Produces;
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

@PlcConfigAggregation(
		entity = br.net.proex.entity.OcorrenciaEntity.class,
		details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
				clazz = br.net.proex.entity.HistoricoOcorrenciaEntity.class,
				collectionName = "historicoOcorrencia", numNew = 1,onDemand = false)			
		}
	)

@PlcConfigForm (
	formPattern=FormPattern.Mad,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/minhastarefas")	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("minhastarefas")
@PlcHandleException
public class MinhasTarefasMB extends AbstractOcorrenciaMB  {

	private static final long serialVersionUID = 1L;
		     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("minhastarefas")
	public OcorrenciaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new OcorrenciaEntity();
              this.newEntity();
              carregaParametrosAplicacao();
        }
        return (OcorrenciaEntity)this.entityPlc;     	
	}
	
	
	@Override
	public void handleButtonsAccordingFormPattern() {	
		super.handleButtonsAccordingFormPattern();
		Map<String, Object> requestMap = contextUtil.getRequestMap();
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_EXCLUIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_INCLUIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_CLONAR, PlcConstants.NAO_EXIBIR);		
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_VISUALIZA_DOCUMENTO, PlcConstants.NAO_EXIBIR);
	}	
	

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
	 * Coloca a ocorrência na situação em análise e encaminha ao resposável
	 */
	public void concluir(){
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) this.entityPlc;
		
		// verificando se a ocorrencia ja foi concluida
		if (ocorrencia.getStatusOcorrencia().equals(StatusOcorrencia.CON)){
			msgUtil.msg(AppBeanMessages.OCORRENCIA_CONCLUIDA,
					PlcMessage.Cor.msgVermelhoPlc.toString());			
			return;
		}
		
		// verificando se informou observação
		if (null == ocorrencia.getObservacaoHistorico() || (null != ocorrencia.getObservacaoHistorico() 
				&& ocorrencia.getObservacaoHistorico().isEmpty())){
			msgUtil.msg(AppBeanMessages.OCORRENCIA_OBRIGATORIO_CONCLUIR,
					PlcMessage.Cor.msgVermelhoPlc.toString());			
			return;
		}
		
		// marcando a ocorrencia como encaminhada
		ocorrencia.setObservacaoConclusao(ocorrencia.getObservacaoHistorico());
		ocorrencia.setStatusOcorrencia(StatusOcorrencia.CON);
		ocorrencia.setDataConclusao(new Date());
		ocorrencia.setResponsavelConclusao(userProfileVO.getUsuario().getPessoa().getNome());
		// criando os dados do histórico
		HistoricoOcorrenciaEntity historico = criaObjetoHistorico(ocorrencia);
		// verificando se já possui algum registro de historico
		if (null == ocorrencia.getHistoricoOcorrencia()){
			ocorrencia.setHistoricoOcorrencia(new ArrayList<HistoricoOcorrenciaEntity>());
		}		
		ocorrencia.getHistoricoOcorrencia().add(historico);
	
		// salvando as alterações
		save();		
		
		// setando a mensagem para enviar no email
		ocorrencia.setObservacaoHistorico(historico.getObservacao());
		
		// enviando o e-mail ao responsável pela ocorrencia
		//sendEmailResponsavel(ocorrencia, "Ocorrência Protocolo: "  + ocorrencia.getProtocolo() + " concluída.", );
		
		// enviando o e-mail ao cidadão
		sendEmailCidadao(ocorrencia,  "Ocorrência Protocolo: "  + ocorrencia.getProtocolo() + " concluída.", TipoModeloDocumento.CCON);
		
		ocorrencia.setObservacaoHistorico(null);
	}			
		
}
