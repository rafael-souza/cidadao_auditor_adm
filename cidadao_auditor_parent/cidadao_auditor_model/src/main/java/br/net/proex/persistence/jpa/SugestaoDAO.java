package br.net.proex.persistence.jpa;

import br.net.proex.entity.SugestaoEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.enumeration.StatusSugestao;
import br.net.proex.enumeration.TipoSugestao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(SugestaoEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class SugestaoDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<SugestaoEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") PessoaEntity pessoa,
			@PlcQueryParameter(name="titulo", expression="obj.titulo like :titulo || '%' ") String titulo,
			@PlcQueryParameter(name="endereco", expression="obj.endereco like :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="status", expression="obj.status = :status") StatusSugestao status,
			@PlcQueryParameter(name="tipoSugestao", expression="obj.tipoSugestao = :tipoSugestao") TipoSugestao tipoSugestao
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") PessoaEntity pessoa,
			@PlcQueryParameter(name="titulo", expression="obj.titulo like :titulo || '%' ") String titulo,
			@PlcQueryParameter(name="endereco", expression="obj.endereco like :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="status", expression="obj.status = :status") StatusSugestao status,
			@PlcQueryParameter(name="tipoSugestao", expression="obj.tipoSugestao = :tipoSugestao") TipoSugestao tipoSugestao
	);

	/**
	 * 
	 * @param protocolo
	 * @return
	 */
	public List<SugestaoEntity> buscarSugestaoPorProtocolo(PlcBaseContextVO context, String protocolo) {
		try { 
			EntityManager em = this.getEntityManager(context); 			
			Query query = em.createNamedQuery("SugestaoEntity.querySelBuscaPorProtocolo");
			query.setParameter("protocolo", protocolo);
			return  (List<SugestaoEntity>) query.getResultList();
		} catch (Exception e) {
			return null;
		}	
	}
	
}
