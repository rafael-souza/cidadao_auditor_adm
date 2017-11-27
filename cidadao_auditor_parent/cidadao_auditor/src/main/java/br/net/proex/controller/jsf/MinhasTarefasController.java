package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.controller.rest.api.qualifiers.QPlcControllerName;
import com.powerlogic.jcompany.controller.rest.api.qualifiers.QPlcControllerQualifier;
import com.powerlogic.jcompany.controller.rest.api.stereotypes.SPlcController;

import br.net.proex.commons.AppUserProfileVO;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.entity.SecretariadoEntity;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.facade.IAppFacade;

@SPlcController
@QPlcControllerName("minhastarefas")
@QPlcControllerQualifier("minhastarefas")
public class MinhasTarefasController extends AppBaseGridController<OcorrenciaEntity, Long> {

	@Inject @QPlcDefault
	protected AppUserProfileVO userProfileVO;
	
	@Inject  @QPlcDefault
	private IAppFacade facade;	
	
	@Inject @QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;	
	
	
	/**
	 * 
	 */
	@Override
	public void retrieveCollection() {			
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) getEntity();
		List<Long> listaSecretaria = new ArrayList<Long>();
		// verificando quais as secretarias responsaveis pelo usuario			
		SecretariadoEntity sec = new SecretariadoEntity();
		sec.setPessoa(userProfileVO.getUsuario().getPessoa());
		
		PrefeituraEntity prefeitura = facade.findPrefeituraById(contextMontaUtil.createContextParamMinimum(), 1L);
		
		if (null!= prefeitura && null != prefeitura.getSecretariado() && prefeitura.getSecretariado().size() > 0){
			for (SecretariadoEntity secretariado : prefeitura.getSecretariado()){				
				if (secretariado.getPessoa().getId() == sec.getPessoa().getId()){
					listaSecretaria.add(secretariado.getSecretaria().getId());
				}
			}								
		}
		
		// verificando se possui alguma secretaria associada
		if (listaSecretaria.size() > 0) {
		
			ocorrencia.setListaSecretaria(listaSecretaria);		
			
			try {
	
				PlcBaseContextVO context = getContext();
				// neste ponto seto a query que faz filtro 
				//getContext().setApiQuerySel("queryMinhasTarefas");
	
				String orderByDinamico = "";
				if (StringUtils.isNotEmpty(getOrderBy())) {
					orderByDinamico = getOrderBy() + " " + StringUtils.defaultIfEmpty(getOrder(), "asc");
				}
	
				Object instancia = getEntityType().newInstance();
	
				this.beanPopulateUtil.transferMapToBean(request.getParameterMap(), instancia);
				 
				if (null == ((OcorrenciaEntity)instancia).getListaSecretaria()){
					((OcorrenciaEntity)instancia).setListaSecretaria(listaSecretaria);
				}
				
				((OcorrenciaEntity)instancia).setStatusDiferenteABE(StatusOcorrencia.ABE);
	
				this.retrieveCollectionBefore();
	
				this.setTotal(getFacade().findCount(context, instancia));
	
				List<OcorrenciaEntity> lista = (List<OcorrenciaEntity>) getFacade()
						.findList(context, instancia, orderByDinamico, ((getPage() - 1) * getRows()), (getRows()));
	
				while (lista.isEmpty() && getPage() > 1) {
					setPage(getPage() - 1);
					lista = (List<OcorrenciaEntity>) getFacade().findList(context, instancia, orderByDinamico,
							((getPage() - 1) * getRows()), (getRows()));
				}
	
				this.setEntityCollection(lista);
	
				this.retrieveCollectionAfter();
	
				// recuperando a lista dos id´s
				recuperaListaIdParaNavegacao();
	
				//getContext().setApiQuerySel(null);
	
			} catch (Exception e) {
				handleExceptions(e);
			}
		} else {
			// informando que não tem nenhum resultado de pesquisa a ser mostrado
			this.setTotal(0L);
			this.setEntityCollection(new ArrayList<OcorrenciaEntity>());
			this.retrieveCollectionAfter();
		}
		
	}	
	
}
