package br.net.proex.controller.jsf.seg;

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

import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.seg.SegMenuCampoEntity;

@PlcConfigAggregation(entity = SegMenuCampoEntity.class

)
@PlcConfigForm(

formPattern = FormPattern.Con, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/menucampo")

)
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("segmenucampo")
@PlcHandleException
public class SegMenuCampoMB extends AppMB {

	private static final long serialVersionUID = 1L;

	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("segmenucampo")
	public SegMenuCampoEntity createEntityPlc() {
		if (this.entityPlc == null) {
			this.entityPlc = new SegMenuCampoEntity();
			this.newEntity();
		}
		return (SegMenuCampoEntity) this.entityPlc;
	}
	
	
	
	/**
	 * Esconde os botões que não são utilizados nesse caso de uso 
	 * @see com.powerlogic.jcompany.controller.jsf.PlcBaseMB#handleButtonsAccordingUseCase()
	 */
	@Override
	public void handleButtonsAccordingFormPattern() {
		super.handleButtonsAccordingFormPattern();		
		Map<String, Object> requestMap = contextUtil.getRequestMap();				
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_INCLUIR,PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_LIMPAR,PlcConstants.NAO_EXIBIR);
	}		

}
