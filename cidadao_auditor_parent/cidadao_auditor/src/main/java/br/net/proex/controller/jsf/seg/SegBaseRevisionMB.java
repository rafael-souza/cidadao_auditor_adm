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
import com.powerlogic.jcompany.config.collaboration.PlcConfigSelection;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.seg.SegBaseEntityRevision;

@PlcConfigAggregation(entity = SegBaseEntityRevision.class)


@PlcConfigForm (
	selection = @PlcConfigSelection(apiQuerySel = "querySel"),
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/auditoria")	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("segauditoria")
@PlcHandleException
public class SegBaseRevisionMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("segauditoria")
	public SegBaseEntityRevision createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new SegBaseEntityRevision();
              this.newEntity();
        }
        return (SegBaseEntityRevision)this.entityPlc;     	
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("segauditoriaLista")
	public PlcEntityList createEntityListPlc() {
		
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
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
	}			
	
	
	@Override
	public String search() {
		
		SegBaseEntityRevision auditoria = (SegBaseEntityRevision) this.entityPlc;
		
		if (auditoria.getMenu() == null){
			msgUtil.msg(AppBeanMessages.SEG_AUDITORIA_MENU, PlcMessage.Cor.msgAmareloPlc.toString());
			return null;
		}
		
		return super.search();
	}
		
	
	
}
