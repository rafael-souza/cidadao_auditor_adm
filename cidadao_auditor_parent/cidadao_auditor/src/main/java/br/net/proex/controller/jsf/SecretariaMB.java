package br.net.proex.controller.jsf;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigTabular;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
	
@PlcConfigAggregation(entity = br.net.proex.entity.SecretariaEntity.class)

@PlcConfigForm(
	formPattern=FormPattern.Tab,
	tabular = @PlcConfigTabular(numNew = 1), formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/secretaria")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("secretaria")	
@PlcHandleException
public class SecretariaMB extends AppMB  {

	private static final long serialVersionUID = 1L;

	

	/**
	 * Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("secretariaLista") 
	public PlcEntityList createEntityListPlc() {
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}	
	
	
}
