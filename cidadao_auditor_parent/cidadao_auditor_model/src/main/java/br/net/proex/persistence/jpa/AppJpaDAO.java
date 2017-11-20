/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.net.proex.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcBeanMessages;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcBaseJpaDAO;

@SPlcDataAccessObject
@QPlcDefault
public class AppJpaDAO extends PlcBaseJpaDAO {
		
	/**
	 *  Realiza o insert sem fazer o flush para inserções em lote
	 * 
	 */
	public void insertWithoutFlush(PlcBaseContextVO context, Object entity) {

		try {

			EntityManager em = getEntityManager(context, dBFactoryUtil.getDBFactoryName(null, entity.getClass(), context));
			em.persist(entity);

		} catch (PlcException plcE) {
			throw plcE;
		} catch (Exception e) {
			Object[] handledException = findExceptionMessage(e);
			if (handledException[0] != null && !handledException[0].equals("")) {
				throw new PlcException((PlcBeanMessages) handledException[0], e.getCause(), log);
			} else {
				throw new PlcException(PlcBeanMessages.JCOMPANY_ERROR_INSERT, new Object[] { "insertWithoutFlush", e }, e, log);
			}
		}
	}
	
	
	/**
	 *  Realiza o flush para as operações de inserção em lote do método insertWithoutFlush
	 */
	public void flush(PlcBaseContextVO context) {
		try {

			EntityManager em = getEntityManager(context);
			em.flush();

		} catch (PlcException plcE) {
			throw plcE;
		} catch (Exception e) {
			Object[] handledException = findExceptionMessage(e);
			if (handledException[0] != null && !handledException[0].equals("")) {
				throw new PlcException((PlcBeanMessages) handledException[0], e.getCause(), log);
			} else {
				throw new PlcException(PlcBeanMessages.JCOMPANY_ERROR_INSERT, new Object[] { "flush", e }, e, log);
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void merge(PlcBaseContextVO context, Object entity ) {
		try {

			EntityManager em = getEntityManager(context, dBFactoryUtil.getDBFactoryName(null, entity.getClass(), context));
			em.merge(entity);

		} catch (PlcException plcE) {
			throw plcE;
		} catch (Exception e) {
			Object[] handledException = findExceptionMessage(e);
			if (handledException[0] != null && !handledException[0].equals("")) {
				throw new PlcException((PlcBeanMessages) handledException[0], e.getCause(), log);
			} else {
				throw new PlcException(PlcBeanMessages.JCOMPANY_ERROR_INSERT, new Object[] { "flush", e }, e, log);
			}
		}
	}
	
	/**
	 * 
	 * @param context
	 */
	public void verificaTransacao(PlcBaseContextVO context){
		EntityManager em = getEntityManager(context);
		
		if (!em.isOpen()){
			em.getTransaction().begin();
		}
		
	}
	
	/**
	 * 
	 * @param contexto
	 * @param classe
	 * @param namedQuery
	 * @param parametros
	 * @param valores
	 * @return
	 */
	public List findListByParams(PlcBaseContextVO contexto, Class classe, String namedQuery, String[] parametros, Object[] valores) {
		Query query = getNamedQueryWithParams(contexto, classe, namedQuery, parametros, valores);
		return query.getResultList();
	}

	/**
	 * 
	 * @param contexto
	 * @param classe
	 * @param namedQuery
	 * @param parametros
	 * @param valores
	 * @return
	 */
	public Object findObjectByParams(PlcBaseContextVO contexto, Class classe, String namedQuery, String[] parametros, Object[] valores) {
		Object objeto = null;
		Query query = getNamedQueryWithParams(contexto, classe, namedQuery, parametros, valores);
		try {
			objeto = query.getSingleResult();
		} catch (NoResultException e) {
			throw new PlcException("EmpJpaDAO", "findObjectByParams", e, log, "");
		}
		return objeto;
	}
	
	/**
	 * 
	 */
	public Query getNamedQueryWithParams(PlcBaseContextVO contexto, Class classe, String namedQuery,
			String[] parametros, Object[] valores) {
		namedQuery = annotationPersistenceUtil.getNamedQueryByName(classe, namedQuery).query();
		Query query = apiCreateQuery(contexto, classe, namedQuery);
		for (int i = 0; i < parametros.length; i++) {
			query.setParameter(parametros[i], valores[i]);
		}
		return query;
	}
	
	/**
	 * 
	 * @param contexto
	 * @param classe
	 * @param namedQuery
	 * @param parametros
	 * @param valores
	 * @param primeiraLinha
	 * @param numeroLinhas
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List executeQueryWithParams(PlcBaseContextVO contexto, Class classe, String namedQuery,
			String[] parametros, Object[] valores, int primeiraLinha, int numeroLinhas) {
		namedQuery = annotationPersistenceUtil.getNamedQueryByName(classe, namedQuery).query();
		Query query = apiCreateQuery(contexto, classe, namedQuery);
		for (int i = 0; i < parametros.length; i++) {
			query.setParameter(parametros[i], valores[i]);
		}
		if (primeiraLinha != 0) {
			query.setFirstResult(primeiraLinha);
		}
		if (primeiraLinha != 0) {
			query.setMaxResults(numeroLinhas);
		}
		return query.getResultList();
	}

}
