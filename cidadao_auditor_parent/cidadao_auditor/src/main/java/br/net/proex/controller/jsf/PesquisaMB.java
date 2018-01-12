package br.net.proex.controller.jsf;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.net.proex.entity.PesquisaEntity;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.net.proex.entity.PesquisaEntity.class

		,details = { 		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.net.proex.entity.PesquisaOpcaoEntity.class,
								collectionName = "pesquisaOpcao", numNew = 1,onDemand = false)
			

		}
	)
	



@PlcConfigForm (
	
	formPattern=FormPattern.Mdt,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/pesquisa")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("pesquisa")
@PlcHandleException
public class PesquisaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("pesquisa")
	public PesquisaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new PesquisaEntity();
              this.newEntity();
        }
        return (PesquisaEntity)this.entityPlc;     	
	}
		
}
