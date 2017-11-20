package br.net.proex.controller.jsf.seg;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.seg.SegMenuCampoEntity;
import br.net.proex.entity.seg.SegMenuEntity;

@PlcConfigAggregation(entity = SegMenuEntity.class, 
	details = { @com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
			clazz = SegMenuCampoEntity.class, collectionName = "menuCampo", numNew = 4, onDemand = false)

})
@PlcConfigForm(

formPattern = FormPattern.Mdt, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/menu")

)
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("segmenu")
@PlcHandleException
public class SegMenuMB extends AppMB {

	private static final long serialVersionUID = 1L;

	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("segmenu")
	public SegMenuEntity createEntityPlc() {
		if (this.entityPlc == null) {
			this.entityPlc = new SegMenuEntity();
			this.newEntity();
		}
		return (SegMenuEntity) this.entityPlc;
	}

}
