package br.net.proex.controller.jsf;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.net.proex.entity.ModeloDocumentoEntity;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



 
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.net.proex.entity.ModeloDocumentoEntity.class
		
	)
	


@PlcConfigForm (
	
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/modelodocumento")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("modelodocumento")
@PlcHandleException
public class ModeloDocumentoMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("modelodocumento")
	public ModeloDocumentoEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new ModeloDocumentoEntity();
              this.newEntity();
        }
        return (ModeloDocumentoEntity)this.entityPlc;     	
	}
		
}
