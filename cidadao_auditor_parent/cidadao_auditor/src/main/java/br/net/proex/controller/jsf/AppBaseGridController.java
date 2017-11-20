package br.net.proex.controller.jsf;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.controller.rest.api.qualifiers.QPlcControllerName;
import com.powerlogic.jcompany.controller.rest.api.qualifiers.QPlcControllerQualifier;
import com.powerlogic.jcompany.controller.rest.api.stereotypes.SPlcController;
import com.powerlogic.jcompany.controller.rest.controllers.PlcBaseGridController;
import com.powerlogic.jcompany.controller.util.PlcCacheUtil;

import br.net.proex.commons.AppConstants;

/**
 * Nome: EmpBaseGridController.
 * 
 * @author rafael
 * @version
 * @param <E>
 * @param <I>
 * @comments
 * @see
 */
@SPlcController
@QPlcControllerName("gridnavigation")
//@Specializes
@QPlcControllerQualifier("*")
public class AppBaseGridController<E, I> extends PlcBaseGridController<E, I> {

	/** Cache Util - utilizado para armazenar a lista de id	 */
	@Inject @QPlcDefault
	private PlcCacheUtil cacheUtil;
	
	@Inject @QPlcDefault
	protected HttpServletRequest request;
	
	
	/**
	 * Sobrescrevendo o retrieveCollection para armazenar os id´s para o recurso de navegação
	 */
	public void retrieveCollection() {		
		
		super.retrieveCollection();
		
		try {
			recuperaListaIdParaNavegacao();
		} catch (InstantiationException e) {
			handleExceptions(e);
		} catch (IllegalAccessException e) {
			handleExceptions(e);
		}									
		
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	public void recuperaListaIdParaNavegacao() throws InstantiationException, IllegalAccessException {
		String orderByDinamico = "";
		if (StringUtils.isNotEmpty(getOrderBy())) {
			orderByDinamico = getOrderBy() + " " + StringUtils.defaultIfEmpty(getOrder(), "asc");
		}		
		
		List<Object> lista = findListId(orderByDinamico);
		//List<Object> lista = empJpaDao.findListId(getContext(), getEntity(), orderByDinamico);
		// transformando a lista de object em lista de Long		
		if (null != lista && lista.size() > 0) {
			List<Long> listaId = new ArrayList<Long>();
			
			for (Object obj : lista){
				try {															                                	            	            			
					listaId.add((Long) PropertyUtils.getProperty(obj, AppConstants.ID));
													
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}		
			
			String action = request.getRequestURI().substring(request.getRequestURI().lastIndexOf(".") + 1);
			// colocando a lista na seção
			cacheUtil.putObject(AppConstants.SESSION_LIST_ID + "_" + action, listaId);	
		}			
	}

	/**
	 * 
	 * @param orderByDinamico
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private List<Object> findListId(String orderByDinamico) throws InstantiationException, IllegalAccessException {

		if (null == getEntity()) {
			setEntity(getEntityType().newInstance());
		}
		
		return (List<Object>) getFacade().findList(getContext(), getEntity(), orderByDinamico, 0, 0);					

	}

}
