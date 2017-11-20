package br.net.proex.controller.jsf.seg;

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
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegPerfilMenuEntity;
import br.net.proex.enumeration.SegTipoAcesso;
import br.net.proex.utils.DateTimeUtils;

@PlcConfigAggregation(entity = SegPerfilEntity.class, 
	details = { @com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
			clazz = SegPerfilMenuEntity.class, collectionName = "perfilMenu", numNew = 0, onDemand = false)

})
@PlcConfigForm(

formPattern = FormPattern.Mdt, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/perfil")

)
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("segperfil")
@PlcHandleException
public class SegPerfilMB extends AppMB {

	private static final long serialVersionUID = 1L;
	
	@Inject	@QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;		

	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("segperfil")
	public SegPerfilEntity createEntityPlc() {
		if (this.entityPlc == null) {
			this.entityPlc = new SegPerfilEntity();
			this.newEntity();
		}
		return (SegPerfilEntity) this.entityPlc;
	}

	
	/**
	 * Esconde os botões que não são utilizados nesse caso de uso 
	 * @see com.powerlogic.jcompany.controller.jsf.PlcBaseMB#handleButtonsAccordingUseCase()
	 */
	@Override
	public void handleButtonsAccordingFormPattern() {
		super.handleButtonsAccordingFormPattern();		
		Map<String, Object> requestMap = contextUtil.getRequestMap();
		requestMap.put(PlcConstants.ACAO.EXIBE_JCOMPANY_EVT_INCLUIR_DETALHE,PlcConstants.NAO_EXIBIR);
	}		
	
	
	@Override
	public String save() {
		SegPerfilEntity perfil =  (SegPerfilEntity) this.entityPlc;
		Boolean temErro = Boolean.FALSE;
		if (perfil.getPerfilMenu() != null && perfil.getPerfilMenu().size() > 0){
			int i = 1;
			for (SegPerfilMenuEntity perfilMenu : perfil.getPerfilMenu()){				
				// verificando as datas para o tipo de acesso temporário
				if (perfilMenu.getTipoAcesso() != null && perfilMenu.getTipoAcesso().equals(SegTipoAcesso.TEM)){
					if (perfilMenu.getDataInicial() == null || perfilMenu.getDataFinal() == null){
						// mensagem informando que as datas inicial e final devem ser preenchidas
						msgUtil.msg(AppBeanMessages.SEG_DATA_INICIAL_DATA_FINAL_OBRIGATORIA, new Object[] {i}, PlcMessage.Cor.msgVermelhoPlc.toString());
						temErro = Boolean.TRUE;
					} else if (perfilMenu.getDataInicial() != null && perfilMenu.getDataFinal() != null){
						
						if (DateTimeUtils.isDataFinalAnteriorDataInicial(perfilMenu.getDataInicial(), perfilMenu.getDataFinal())){
							// mensagem informando que as datas final deve ser maior que a data inicial
							msgUtil.msg(AppBeanMessages.SEG_DATA_FINAL_MENOR_DATA_INICIAL, new Object[] {i}, PlcMessage.Cor.msgVermelhoPlc.toString());
							temErro = Boolean.TRUE;
						}
					}					
				} else if (perfilMenu.getTipoAcesso() != null && !perfilMenu.getTipoAcesso().equals(SegTipoAcesso.TEM)){ 				
					if (perfilMenu.getDataInicial() != null || perfilMenu.getDataFinal() != null){
						msgUtil.msg(AppBeanMessages.SEG_DATA_NAO_DEVE_INFORMAR, new Object[] {i}, PlcMessage.Cor.msgVermelhoPlc.toString());
						temErro = Boolean.TRUE;
					}
				}
								
				i++;
			}					
		}					
		
		if (temErro){
			return null;
		}
		
		return super.save();
	}
	

	
}
