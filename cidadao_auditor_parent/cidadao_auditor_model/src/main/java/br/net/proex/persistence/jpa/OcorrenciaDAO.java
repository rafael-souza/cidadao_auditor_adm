package br.net.proex.persistence.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import br.net.proex.entity.TipoOcorrenciaEntity;
import br.net.proex.entity.vo.RelTipoStatusVO;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.enumeration.TipoSecretario;
import br.net.proex.utils.DateTimeUtils;
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

	/**
	 * 
	 * @param context
	 * @param relTipoStatus
	 * @return
	 */
	public List<RelTipoStatusVO> relTipoStatus(PlcBaseContextVO context, RelTipoStatusVO relTipoStatus) {
		try { 
			EntityManager em = this.getEntityManager(context);
	
			// criando a query de consulta dos dados
			StringBuilder sql = new StringBuilder();
			sql.append("select "); 
			sql.append("count(*) as total, "); 
			sql.append("tp.descricao, "); 
			sql.append("case status_ocorrencia "); 
			sql.append("when 'ABE' then 'Em Aberto' ");
			sql.append("when 'ENC' then 'Encaminhada' ");
			sql.append("when 'ANA' then 'Em Análise' ");
			sql.append("when 'CON' then 'Concluída' ");
			sql.append("end as status_ocorrencia ");
			sql.append("from "); 
			sql.append("ocorrencia oc left outer join tipo_ocorrencia tp on (tp.id = oc.tipo_ocorrencia) ");
			sql.append("where 1 = 1 ");
			
			// verificando se o usuário fez algum filtro de dados		
			if (null != relTipoStatus.getSecretariaResponsavel()){
				sql.append("and tp.secretaria_responsavel like '" + relTipoStatus.getSecretariaResponsavel() + "' ");
			}
			
			if (null != relTipoStatus.getTipoOcorrenciaFiltro()){
				sql.append("and oc.tipo_ocorrencia = " + relTipoStatus.getTipoOcorrenciaFiltro().getId() + " ");
			}
			
			if (null != relTipoStatus.getDataFiltro()){
				sql.append("and oc.data_ocorrencia >= '" + DateTimeUtils.date2String(relTipoStatus.getDataFiltro()) + "' ");
			}
			
			sql.append("group by "); 
			sql.append("tipo_ocorrencia, status_ocorrencia "); 
			sql.append("order by "); 
			sql.append("tipo_ocorrencia, status_ocorrencia; ");
			
			List<RelTipoStatusVO> listaRetorno = new ArrayList<RelTipoStatusVO>();
			List<Object[]> lista = em.createNativeQuery(sql.toString()).getResultList();
			
			// armazena o total de registros
			Long i = 0L;
			// percorrendo os resultados da busca
			Iterator<Object[]> ite = lista.iterator();
			while (ite.hasNext()) {
				Object[] result = (Object[]) ite.next();	
				
				RelTipoStatusVO tipoStatus = new RelTipoStatusVO();
				
				tipoStatus.setTotal(Long.valueOf(String.valueOf(result[0])));
				tipoStatus.setTipoOcorrencia(String.valueOf(result[1]));
				tipoStatus.setStatusOcorrencia(String.valueOf(result[2]));
				
				listaRetorno.add(tipoStatus);
			}
					
			return listaRetorno;
		
		} catch (Exception e) {
			return null;
		}
	}
		
	
}
