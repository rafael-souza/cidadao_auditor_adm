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

import br.net.proex.entity.PessoaEntity;

@PlcConfigAggregation(entity = br.net.proex.entity.PessoaEntity.class)
@PlcConfigForm (
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/pessoa")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("pessoa")
@PlcHandleException
public class PessoaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("pessoa")
	public PessoaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new PessoaEntity();
              this.newEntity();
        }
        return (PessoaEntity)this.entityPlc;     	
	}
		
}
