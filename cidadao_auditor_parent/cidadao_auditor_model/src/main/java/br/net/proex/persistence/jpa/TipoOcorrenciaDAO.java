package br.net.proex.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;

import br.net.proex.entity.SecretariaEntity;
import br.net.proex.entity.TipoOcorrenciaEntity;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(TipoOcorrenciaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class TipoOcorrenciaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<TipoOcorrenciaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="descricao", expression="obj.descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="secretaria", expression="obj.secretaria = :secretaria") SecretariaEntity secretaria
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="descricao", expression="obj.descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="secretaria", expression="obj.secretaria = :secretaria") SecretariaEntity secretaria
	);
	
	/**
	 * 
	 * @param context
	 * @param secretaria
	 * @return
	 */
	public List<TipoOcorrenciaEntity> buscaTipoPorSecretaria(PlcBaseContextVO context, SecretariaEntity secretaria){
		try { 
			EntityManager em = this.getEntityManager(context); 	
			Query query;
			if (null != secretaria){
				query = em.createNamedQuery("TipoOcorrenciaEntity.querySelPorSecretaria");
				query.setParameter("idSecretaria", secretaria.getId());
			} else {
				query = em.createNamedQuery("TipoOcorrenciaEntity.querySelBuscaTodas");
			}
			
			return (List<TipoOcorrenciaEntity>)query.getResultList();
			
		} catch (Exception e) {
			return null;
		}
		
	}

}
