package br.net.proex.persistence.jpa;

import br.net.proex.entity.ModeloDocumentoEntity;
import br.net.proex.entity.OcorrenciaEntity;

import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.net.proex.enumeration.TipoModeloDocumento;

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

@PlcAggregationDAOIoC(ModeloDocumentoEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class ModeloDocumentoDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<ModeloDocumentoEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="tipo", expression="tipo = :tipo") TipoModeloDocumento tipo
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="tipo", expression="tipo = :tipo") TipoModeloDocumento tipo
	);

	/**
	 * 
	 * @param context
	 * @param modelo
	 * @return
	 */
	public String findModeloDocumentoPorTipo(PlcBaseContextVO context, TipoModeloDocumento modelo) {
		try { 
			EntityManager em = this.getEntityManager(context); 			
			Query query = em.createNamedQuery("ModeloDocumentoEntity.querySelPorTipo");
			query.setParameter("tipo", modelo);
			
			ModeloDocumentoEntity modeloDocumento = (ModeloDocumentoEntity) query.getSingleResult();
			return modeloDocumento.getTexto();
			
		} catch (Exception e) {
			return "";
		}
	}
	
}
