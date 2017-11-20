package br.net.proex.controller.jsf;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.entity.ParametrosAplicacaoEntity;


@PlcConfigAggregation(entity= br.net.proex.entity.ParametrosAplicacaoEntity.class)
@PlcConfigForm (	
	formPattern=FormPattern.Apl,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/parametrosaplicacao")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("parametrosaplicacao")
@PlcHandleException
public class ParametrosAplicacaoMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("parametrosaplicacao")
	public ParametrosAplicacaoEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new ParametrosAplicacaoEntity();
              this.newEntity();
        }
        return (ParametrosAplicacaoEntity)this.entityPlc;     	
	}
		
}
