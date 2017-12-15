package br.net.proex.controller.jsf;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.entity.vo.RelTotalizadorTipoVO;
import br.net.proex.utils.DateTimeUtils;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.net.proex.entity.vo.RelTotalizadorTipoVO.class)
@PlcConfigForm (
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/reltotalizadortipo"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
				pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=500000))
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("reltotalizadortipo")
@PlcHandleException
public class RelTotalizadorTipoMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("reltotalizadortipo")
	public RelTotalizadorTipoVO createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new RelTotalizadorTipoVO();
              this.newEntity();
         }

        return (RelTotalizadorTipoVO) this.entityPlc;   
        
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("reltotalizadortipoLista")
	public PlcEntityList createEntityListPlc() {
		
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}
	
	/**
	 * 
	 */
	@Override
	public String search() {
		String retorno = "";
		RelTotalizadorTipoVO totalizadorTipo = (RelTotalizadorTipoVO)this.getEntityPlc();
		
		// verificando se a data final é maior que a inicial
		if (null != totalizadorTipo.getDataInicial() && null != totalizadorTipo.getDataFinal()
				&& DateTimeUtils.isDataFinalAnteriorDataInicial(totalizadorTipo.getDataInicial(), totalizadorTipo.getDataFinal())){
			msgUtil.msg(AppBeanMessages.REL_TOTALIZADOR_TIPO_DATAS, PlcMessage.Cor.msgVermelhoPlc.toString());	
			return retorno;
		}
		
		List<RelTotalizadorTipoVO> listaRetorno = facade.relTotalizadorTipo(contextMontaUtil.createContextParamMinimum(), totalizadorTipo);
		
		this.getEntityListPlc().setItensPlc((List<Object>) (Object) listaRetorno);
		
		if (null == listaRetorno || null != listaRetorno && listaRetorno.size() < 1){
			msgUtil.msg(AppBeanMessages.NENHUM_RESULTADO, PlcMessage.Cor.msgVermelhoPlc.toString());	
		}
		
		
		return retorno;
	}
	
}
