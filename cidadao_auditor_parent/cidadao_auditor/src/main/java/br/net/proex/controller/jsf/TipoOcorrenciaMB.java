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

import br.net.proex.entity.TipoOcorrenciaEntity;

@PlcConfigAggregation(entity = br.net.proex.entity.TipoOcorrenciaEntity.class)
@PlcConfigForm (
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/tipoocorrencia")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("tipoocorrencia")
@PlcHandleException
public class TipoOcorrenciaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("tipoocorrencia")
	public TipoOcorrenciaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new TipoOcorrenciaEntity();
              this.newEntity();
        }
        return (TipoOcorrenciaEntity)this.entityPlc;     	
	}
		
}
