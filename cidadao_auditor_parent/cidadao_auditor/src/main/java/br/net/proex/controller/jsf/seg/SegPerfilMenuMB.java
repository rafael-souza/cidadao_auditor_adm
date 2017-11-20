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
import br.net.proex.entity.seg.SegPerfilMenuAcaoNegadoEntity;
import br.net.proex.entity.seg.SegPerfilMenuCampoEntity;
import br.net.proex.entity.seg.SegPerfilMenuEntity;
import br.net.proex.enumeration.SegTipoAcesso;

@PlcConfigAggregation(entity = SegPerfilMenuEntity.class, 
	details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
				clazz = SegPerfilMenuAcaoNegadoEntity.class, collectionName = "perfilMenuAcaoNegado", numNew = 1, onDemand = false),
			@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
				clazz =SegPerfilMenuCampoEntity.class, collectionName = "perfilMenuCampo", numNew = 10, onDemand = false)})
@PlcConfigForm(

formPattern = FormPattern.Mad, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/perfilmenu")

)
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("segperfilmenu")
@PlcHandleException
public class SegPerfilMenuMB extends AppMB {

	private static final long serialVersionUID = 1L;

	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("segperfilmenu")
	public SegPerfilMenuEntity createEntityPlc() {
		if (this.entityPlc == null) {
			this.entityPlc = new SegPerfilMenuEntity();
			this.newEntity();
		}
		return (SegPerfilMenuEntity) this.entityPlc;
	}
	
	/**
	 * Esconde os botões que não são utilizados nesse caso de uso 
	 * @see com.powerlogic.jcompany.controller.jsf.PlcBaseMB#handleButtonsAccordingUseCase()
	*/ 
	@Override
	public void handleButtonsAccordingFormPattern() {
		SegPerfilMenuEntity perfilMenu = (SegPerfilMenuEntity) this.entityPlc;
		super.handleButtonsAccordingFormPattern();
		Map<String, Object> requestMap = contextUtil.getRequestMap();						
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_INCLUIR,PlcConstants.NAO_EXIBIR);
		if (perfilMenu.getTipoAcesso() != null && perfilMenu.getTipoAcesso().equals(SegTipoAcesso.NEG)){
			requestMap.put(PlcConstants.ACAO.EXIBE_JCOMPANY_EVT_INCLUIR_DETALHE,PlcConstants.NAO_EXIBIR);
		}
	}		

}
