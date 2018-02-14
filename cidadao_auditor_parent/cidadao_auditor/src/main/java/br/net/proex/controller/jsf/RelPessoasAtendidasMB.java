package br.net.proex.controller.jsf;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.entity.vo.RelPessoasAtendidasVO;
import br.net.proex.entity.vo.RelTotalizadorSecretariaVO;
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

@PlcConfigAggregation(entity = br.net.proex.entity.vo.RelPessoasAtendidasVO.class)
@PlcConfigForm (formPattern=FormPattern.Con,
				formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/relpessoasatendidas"),
				selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
						pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=500))
)

/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("relpessoasatendidas")
@PlcHandleException
public class RelPessoasAtendidasMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
   		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("relpessoasatendidas")
	public RelPessoasAtendidasVO createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new RelPessoasAtendidasVO();
              this.newEntity();
         }

        return (RelPessoasAtendidasVO) this.entityPlc;   
        
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("relpessoasatendidasLista")
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
		RelPessoasAtendidasVO pessoasAtendidas = (RelPessoasAtendidasVO)this.getEntityPlc();
		
		// verificando se a data final é maior que a inicial
		if (null != pessoasAtendidas.getDataInicial() && null != pessoasAtendidas.getDataFinal()
				&& DateTimeUtils.isDataFinalAnteriorDataInicial(pessoasAtendidas.getDataInicial(), pessoasAtendidas.getDataFinal())){
			msgUtil.msg(AppBeanMessages.REL_TOTALIZADOR_TIPO_DATAS, PlcMessage.Cor.msgVermelhoPlc.toString());	
			return retorno;
		}
		
		List<RelPessoasAtendidasVO> listaRetorno = facade.relPessoasAtendidas(contextMontaUtil.createContextParamMinimum(), pessoasAtendidas);
		
		this.getEntityListPlc().setItensPlc((List<Object>) (Object) listaRetorno);
		
		if (null == listaRetorno || null != listaRetorno && listaRetorno.size() < 1){
			msgUtil.msg(AppBeanMessages.NENHUM_RESULTADO, PlcMessage.Cor.msgVermelhoPlc.toString());	
		}
		
		
		return retorno;
	}
	
}
