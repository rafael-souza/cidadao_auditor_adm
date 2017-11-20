package br.net.proex.persistence.jpa;

import java.util.Collection;
import java.util.Date;
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

import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.entity.TipoOcorrenciaEntity;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.enumeration.TipoSecretario;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(OcorrenciaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class OcorrenciaDAO extends AppJpaDAO  {
		

	@PlcQuery("querySel")
	public native List<OcorrenciaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="tipoOcorrencia", expression="obj1 = :tipoOcorrencia") TipoOcorrenciaEntity tipoOcorrencia,
			@PlcQueryParameter(name="dataOcorrencia", expression="obj.dataOcorrencia = :dataOcorrencia  ") Date dataOcorrencia,
			@PlcQueryParameter(name="dataConclusao", expression="obj.dataConclusao = :dataConclusao  ") Date dataConclusao,
			@PlcQueryParameter(name="endereco", expression="obj.endereco like '%' || :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="statusOcorrencia", expression="obj.statusOcorrencia = :statusOcorrencia") StatusOcorrencia statusOcorrencia,
			@PlcQueryParameter(name="protocolo", expression="obj.protocolo like :protocolo || '%' ") String protocolo,
			@PlcQueryParameter(name="statusDiferenteABE", expression="obj.statusOcorrencia <> :statusDiferenteABE") StatusOcorrencia statusDiferenteABE,
			@PlcQueryParameter(name="listaSecretaria", expression="obj1.secretariaResponsavel in (:listaSecretaria) ") List<TipoSecretario> listaSecretaria
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="tipoOcorrencia", expression="obj1 = :tipoOcorrencia") TipoOcorrenciaEntity tipoOcorrencia,
			@PlcQueryParameter(name="dataOcorrencia", expression="obj.dataOcorrencia = :dataOcorrencia  ") Date dataOcorrencia,
			@PlcQueryParameter(name="dataConclusao", expression="obj.dataConclusao = :dataConclusao  ") Date dataConclusao,
			@PlcQueryParameter(name="endereco", expression="obj.endereco like '%' || :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="statusOcorrencia", expression="obj.statusOcorrencia = :statusOcorrencia") StatusOcorrencia statusOcorrencia,
			@PlcQueryParameter(name="protocolo", expression="obj.protocolo like :protocolo || '%' ") String protocolo,
			@PlcQueryParameter(name="statusDiferenteABE", expression="obj.statusOcorrencia <> :statusDiferenteABE") StatusOcorrencia statusDiferenteABE,			
			@PlcQueryParameter(name="listaSecretaria", expression="obj1.secretariaResponsavel in (:listaSecretaria) ") List<TipoSecretario> listaSecretaria
	);
	

	/**
	 * 
	 * @param context
	 * @param idPessoa
	 * @return
	 */
	public List<OcorrenciaEntity> findOcorrenciaPorPessoa(PlcBaseContextVO context, Long idPessoa) {
		try { 
			EntityManager em = this.getEntityManager(context); 			
			Query query = em.createNamedQuery("OcorrenciaEntity.querySelPorPessoa");
			query.setParameter("idPessoa", idPessoa);
			
			List<OcorrenciaEntity> lista = (List<OcorrenciaEntity>)query.getResultList();
			
			if (null != lista && lista.size() > 0){
				// percorrendo a lista para buscar os detalhes
				for (OcorrenciaEntity ocorrencia : lista){
					ocorrencia = (OcorrenciaEntity)findById(context, OcorrenciaEntity.class, ocorrencia.getId());
				}
			}
			
			return lista;
		} catch (Exception e) {
			return null;
		}
	}
		
	
}
