package br.net.proex.persistence.jpa;

import br.net.proex.entity.DenunciaEntity;
import br.net.proex.entity.SugestaoEntity;

import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import java.util.Date;

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

@PlcAggregationDAOIoC(DenunciaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class DenunciaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<DenunciaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="titulo", expression="titulo like :titulo || '%' ") String titulo,
			@PlcQueryParameter(name="endereco", expression="endereco like :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="dataDenuncia", expression="dataDenuncia >= :dataDenuncia  ") Date dataDenuncia,
			@PlcQueryParameter(name="protocolo", expression="protocolo like :protocolo || '%' ") String protocolo
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="titulo", expression="titulo like :titulo || '%' ") String titulo,
			@PlcQueryParameter(name="endereco", expression="endereco like :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="dataDenuncia", expression="dataDenuncia >= :dataDenuncia  ") Date dataDenuncia,
			@PlcQueryParameter(name="protocolo", expression="protocolo like :protocolo || '%' ") String protocolo
	);

	/**
	 * 
	 * @param context
	 * @param protocolo
	 * @return
	 */
	public List<DenunciaEntity> buscarDenunciaPorProtocolo(PlcBaseContextVO context, String protocolo) {
		try { 
			EntityManager em = this.getEntityManager(context); 			
			Query query = em.createNamedQuery("DenunciaEntity.querySelBuscaPorProtocolo");
			query.setParameter("protocolo", protocolo);
			return  (List<DenunciaEntity>) query.getResultList();
		} catch (Exception e) {
			return null;
		}	
	}
	
}
