package br.net.proex.controller.jsf;

import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.entity.FotoPrefeitura;
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.facade.IAppFacade;

@PlcConfigAggregation(
		entity = br.net.proex.entity.PrefeituraEntity.class,
		components = {@com.powerlogic.jcompany.config.aggregation.PlcConfigComponent(
				clazz=br.net.proex.entity.Endereco.class, property="endereco", separate=false)},
		details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
				clazz = br.net.proex.entity.SecretariadoEntity.class, collectionName = "secretariado", numNew = 1,onDemand = false)}
)	
@PlcConfigForm (	
	formPattern=FormPattern.Mdt,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/prefeitura")
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("prefeitura")
@PlcHandleException
public class PrefeituraMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	@Inject @QPlcDefault
	private IAppFacade facade;
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("prefeitura")
	public PrefeituraEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new PrefeituraEntity();
              this.newEntity();
        }
        return (PrefeituraEntity)this.entityPlc;     	
	}
	
	@Override
	public String edit() {	
		String retorno = super.edit();
		PrefeituraEntity prefeitura = (PrefeituraEntity)this.entityPlc;
		
		if (null != prefeitura.getBrasao()){
			prefeitura.setBrasao((FotoPrefeitura) facade.downloadFile(contextMontaUtil.createContextParamMinimum(),
					FotoPrefeitura.class, prefeitura.getBrasao().getId()));
		}		
		return retorno;
	}
	
	
	@Override
	public void handleButtonsAccordingFormPattern() {	
		super.handleButtonsAccordingFormPattern();
		Map<String, Object> requestMap = contextUtil.getRequestMap();
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_EXCLUIR, PlcConstants.NAO_EXIBIR);
		//requestMap.put(PlcConstants.ACAO.EXIBE_BT_INCLUIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_CLONAR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_ABRIR, PlcConstants.NAO_EXIBIR);
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_VISUALIZA_DOCUMENTO, PlcConstants.NAO_EXIBIR);
	}
		
}
