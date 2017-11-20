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

import br.net.proex.entity.PessoaEntity;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(PessoaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class PessoaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<PessoaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like :nome || '%' ") String nome
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like :nome || '%' ") String nome
	);

	/**
	 * 
	 * @param context
	 * @param email
	 * @return
	 */
	public PessoaEntity findPessoaByEmail(PlcBaseContextVO context, String email) {
		try { 
			EntityManager em = this.getEntityManager(context); 			
			Query query = em.createNamedQuery("PessoaEntity.querySelEmail");
			query.setParameter("email", email);
			return (PessoaEntity) query.getSingleResult();			
		} catch (Exception e) {
			return null;
		}		
		
	}
	
}
