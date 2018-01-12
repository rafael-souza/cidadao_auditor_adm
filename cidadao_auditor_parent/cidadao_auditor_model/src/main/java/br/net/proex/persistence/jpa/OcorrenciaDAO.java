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

import br.net.proex.commons.AppConstants;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.SecretariaEntity;
import br.net.proex.entity.TipoOcorrenciaEntity;
import br.net.proex.entity.vo.RelChartModelTipoStatusVO;
import br.net.proex.entity.vo.RelTipoStatusVO;
import br.net.proex.entity.vo.RelTotalizadorSecretariaVO;
import br.net.proex.entity.vo.RelTotalizadorTipoVO;
import br.net.proex.enumeration.StatusOcorrencia;
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
			@PlcQueryParameter(name="dataOcorrencia", expression="obj.dataOcorrencia >= :dataOcorrencia  ") Date dataOcorrencia,
			@PlcQueryParameter(name="dataFinal", expression="obj.dataOcorrencia <= :dataFinal  ") Date dataFinal,
			@PlcQueryParameter(name="dataConclusao", expression="obj.dataConclusao >= :dataConclusao  ") Date dataConclusao,
			@PlcQueryParameter(name="endereco", expression="obj.endereco like '%' || :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="statusOcorrencia", expression="obj.statusOcorrencia = :statusOcorrencia") StatusOcorrencia statusOcorrencia,
			@PlcQueryParameter(name="protocolo", expression="obj.protocolo like :protocolo || '%' ") String protocolo,
			@PlcQueryParameter(name="statusDiferenteABE", expression="obj.statusOcorrencia <> :statusDiferenteABE") StatusOcorrencia statusDiferenteABE,
			@PlcQueryParameter(name="listaSecretaria", expression="obj4.id in (:listaSecretaria) ") List<Long> listaSecretaria,
			@PlcQueryParameter(name="secretaria", expression="obj4 = :secretaria") SecretariaEntity secretaria
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="tipoOcorrencia", expression="obj1 = :tipoOcorrencia") TipoOcorrenciaEntity tipoOcorrencia,
			@PlcQueryParameter(name="dataOcorrencia", expression="obj.dataOcorrencia >= :dataOcorrencia  ") Date dataOcorrencia,
			@PlcQueryParameter(name="dataFinal", expression="obj.dataOcorrencia <= :dataFinal  ") Date dataFinal,
			@PlcQueryParameter(name="dataConclusao", expression="obj.dataConclusao = :dataConclusao  ") Date dataConclusao,
			@PlcQueryParameter(name="endereco", expression="obj.endereco like '%' || :endereco || '%' ") String endereco,
			@PlcQueryParameter(name="statusOcorrencia", expression="obj.statusOcorrencia = :statusOcorrencia") StatusOcorrencia statusOcorrencia,
			@PlcQueryParameter(name="protocolo", expression="obj.protocolo like :protocolo || '%' ") String protocolo,
			@PlcQueryParameter(name="statusDiferenteABE", expression="obj.statusOcorrencia <> :statusDiferenteABE") StatusOcorrencia statusDiferenteABE,			
			@PlcQueryParameter(name="listaSecretaria", expression="obj4.id in (:listaSecretaria) ") List<Long> listaSecretaria,
			@PlcQueryParameter(name="secretaria", expression="obj4 = :secretaria") SecretariaEntity secretaria
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
	public List<RelChartModelTipoStatusVO> relTipoStatus(PlcBaseContextVO context, RelTipoStatusVO relTipoStatus) {
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
			sql.append("left outer join secretaria sec on (tp.secretaria = sec.id) ");
			sql.append("where 1 = 1 ");
			
			// verificando se o usuário fez algum filtro de dados		
			if (null != relTipoStatus.getSecretaria()){
				sql.append("and sec.id = " + relTipoStatus.getSecretaria().getId() + " ");
			}
			
			if (null != relTipoStatus.getTipoOcorrenciaFiltro()){
				sql.append("and oc.tipo_ocorrencia = " + relTipoStatus.getTipoOcorrenciaFiltro().getId() + " ");
			}
			
			if (null != relTipoStatus.getDataFiltro()){
				sql.append("and oc.data_ocorrencia >= '" + 
						DateTimeUtils.formataData(relTipoStatus.getDataFiltro(), AppConstants.formatoUSA)  + " 00:00:00' ");
			}
			
			if (null != relTipoStatus.getDataFinal()){
				sql.append("and oc.data_ocorrencia <= '" + 
						DateTimeUtils.formataData(relTipoStatus.getDataFinal(), AppConstants.formatoUSA)  + " 00:00:00' ");
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
			
			
			List<RelChartModelTipoStatusVO> listaCompleta = buscaDadosParaAlimentarLista(context, relTipoStatus);
			
			// realizando a comparação entre as listas para informar o valor para todos os status nos tipos encontrados
			for (RelChartModelTipoStatusVO item : listaCompleta){
				// percorre a lista com os valores
				for (RelTipoStatusVO tipoStatus : listaRetorno){
					// verificando se é o mesmo tipo e status
					if (item.getLabel().equals(tipoStatus.getTipoOcorrencia())){
						
						if (tipoStatus.getStatusOcorrencia().equals("Em Aberto")){
							item.setEmAberto(tipoStatus.getTotal());
						} else if (tipoStatus.getStatusOcorrencia().equals("Encaminhada")){
							item.setEncaminhada(tipoStatus.getTotal());
						} else if (tipoStatus.getStatusOcorrencia().equals("Em Análise")){
							item.setEmAnalise(tipoStatus.getTotal());
						} else if (tipoStatus.getStatusOcorrencia().equals("Concluída")){
							item.setConcluida(tipoStatus.getTotal());
						}
					}
				}
			}

			return listaCompleta;
		
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
	private List<RelChartModelTipoStatusVO> buscaDadosParaAlimentarLista(PlcBaseContextVO context,
			RelTipoStatusVO relTipoStatus) {
		EntityManager em = this.getEntityManager(context);
		
		// buscando os tipos encontrados no filtro realizado
		StringBuilder sql = new StringBuilder();
		sql.append("select ");  
		sql.append("tp.descricao ");
		sql.append("from ");
		sql.append("ocorrencia oc "); 
		sql.append("left outer join tipo_ocorrencia tp on (tp.id = oc.tipo_ocorrencia) "); 
		sql.append("left outer join secretaria sec on (tp.secretaria = sec.id) ");
		sql.append("where 1 = 1 ");
	
		// verificando se o usuário fez algum filtro de dados		
		if (null != relTipoStatus.getSecretaria()){
			sql.append("and sec.id = " + relTipoStatus.getSecretaria().getId() + " ");
		}
		
		if (null != relTipoStatus.getTipoOcorrenciaFiltro()){
			sql.append("and oc.tipo_ocorrencia = " + relTipoStatus.getTipoOcorrenciaFiltro().getId() + " ");
		}
		
		if (null != relTipoStatus.getDataFiltro()){
			sql.append("and oc.data_ocorrencia >= '" + 
					DateTimeUtils.formataData(relTipoStatus.getDataFiltro(), AppConstants.formatoUSA)  + " 00:00:00' ");
		}
		
		if (null != relTipoStatus.getDataFinal()){
			sql.append("and oc.data_ocorrencia <= '" + 
					DateTimeUtils.formataData(relTipoStatus.getDataFinal(), AppConstants.formatoUSA)  + " 00:00:00' ");
		}
		
		sql.append("group by tipo_ocorrencia order by tipo_ocorrencia ");
		
		List<RelChartModelTipoStatusVO> listaRetorno = new ArrayList<RelChartModelTipoStatusVO>();
		List<Object[]> lista = em.createNativeQuery(sql.toString()).getResultList();
		
		// armazena o total de registros
		Long i = 0L;
		// percorrendo os resultados da busca
		Iterator<Object[]> ite = lista.iterator();
		while (ite.hasNext()) {
			RelChartModelTipoStatusVO tipoStatus = new RelChartModelTipoStatusVO();
			tipoStatus.setLabel(String.valueOf(ite.next()));
			tipoStatus.setConcluida(0L);
			tipoStatus.setEmAberto(0L);
			tipoStatus.setEmAnalise(0L);
			tipoStatus.setEncaminhada(0L);
			listaRetorno.add(tipoStatus);
		}

		return listaRetorno;
		
	}

	/**
	 * Retorna uma lista com as ocorrencias que foram criadadas da secretaria selecionada
	 * @param context
	 * @param secretaria
	 * @return
	 */
	public List<TipoOcorrenciaEntity> findOcorrenciaPorSecretaria(PlcBaseContextVO context,
			SecretariaEntity secretaria) {
		try { 
			EntityManager em = this.getEntityManager(context);
	
			// criando a query de consulta dos dados
			StringBuilder sql = new StringBuilder();
			sql.append("select "); 
			sql.append("tp.id, ");
			sql.append("tp.descricao ");
			sql.append("FROM ocorrencia oc "); 
			sql.append("left outer join tipo_ocorrencia tp on (oc.tipo_ocorrencia = tp.id) ");
			sql.append("left outer join secretaria sc on (tp.secretaria = sc.id) ");
			sql.append("where sc.id = " + secretaria.getId() + " "); 
			
			List<TipoOcorrenciaEntity> listaRetorno = new ArrayList<TipoOcorrenciaEntity>();
			List<Object[]> lista = em.createNativeQuery(sql.toString()).getResultList();
			
			// armazena o total de registros
			Long i = 0L;
			// percorrendo os resultados da busca
			Iterator<Object[]> ite = lista.iterator();
			while (ite.hasNext()) {
				Object[] result = (Object[]) ite.next();	
				
				TipoOcorrenciaEntity tipoOcorrencia = new TipoOcorrenciaEntity();
				
				tipoOcorrencia.setId(Long.valueOf(String.valueOf(result[0])));
				tipoOcorrencia.setDescricao(String.valueOf(result[1]));
				
				listaRetorno.add(tipoOcorrencia);
			}
					
			return listaRetorno;
		
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param totalizadorTipo
	 * @return
	 */
	public List<RelTotalizadorTipoVO> relTotalizadorTipo(PlcBaseContextVO context, RelTotalizadorTipoVO totalizadorTipo) {
		EntityManager em = this.getEntityManager(context);
		
		// Criando a sql de consulta dos dados
		StringBuilder sql = new StringBuilder();
		sql.append("select "); 
		sql.append("sc.nome, ");
		sql.append("tp.descricao, ");
		sql.append("case oc.status_ocorrencia "); 
		sql.append("when 'ABE' then 'Em Aberto' ");
		sql.append("when 'ENC' then 'Encaminhada' ");
		sql.append("when 'ANA' then 'Em Análise' ");
		sql.append("when 'CON' then 'Concluída' ");
		sql.append("end as status_ocorrencia, ");
		sql.append("count(oc.id) as total ");
		sql.append("from "); 
		sql.append("ocorrencia oc ");
		sql.append("left join tipo_ocorrencia tp on (oc.tipo_ocorrencia = tp.id) ");
		sql.append("left join secretaria sc on (tp.secretaria = sc.id) ");
		sql.append("where 1 = 1 ");
		
		// verificando se é para filtrar por secretaria
		if (null != totalizadorTipo.getSecretaria()){
			sql.append("and sc.id = " + totalizadorTipo.getSecretaria().getId() + " ");
		}
		
		// verificando se é para filtrar por tipo de ocorrencia
		if (null != totalizadorTipo.getTipoOcorrencia()){
			sql.append("and tp.id = " + totalizadorTipo.getTipoOcorrencia().getId() + " ");
		}
		
		// verificando se é para filtrar por data inicial
		if (null != totalizadorTipo.getDataInicial()){
			sql.append("and oc.data_ocorrencia >= '" + 
					DateTimeUtils.formataData(totalizadorTipo.getDataInicial(), AppConstants.formatoUSA)  + " 00:00:00' ");
		}
		
		// verificando se é para filtrar por data final
		if (null != totalizadorTipo.getDataFinal()){
			sql.append("and oc.data_ocorrencia <= '" + 
					DateTimeUtils.formataData(totalizadorTipo.getDataFinal(), AppConstants.formatoUSA)  + " 23:59:59' ");
		}
		
		sql.append("group by oc.tipo_ocorrencia, oc.status_ocorrencia ");
		sql.append("order by sc.nome, tp.descricao ");
			
		List<RelTotalizadorTipoVO> listaRetorno = new ArrayList<RelTotalizadorTipoVO>();
		List<Object[]> lista = em.createNativeQuery(sql.toString()).getResultList();
		
		// armazena o total de registros
		Long i = 0L;
		// percorrendo os resultados da busca
		Iterator<Object[]> ite = lista.iterator();
		
		String descricaoAnterior = "";
		while (ite.hasNext()) {
			Object[] result = (Object[]) ite.next();
			
			RelTotalizadorTipoVO totalTip = new RelTotalizadorTipoVO();
			if (descricaoAnterior.isEmpty() || !descricaoAnterior.equals(String.valueOf(result[0]))){
				totalTip.setDescricaoSecretaria(String.valueOf(result[0]));
				descricaoAnterior = totalTip.getDescricaoSecretaria(); 
			}
			totalTip.setDescricaoTipo(String.valueOf(result[1]));
			totalTip.setStatus(String.valueOf(result[2]));
			totalTip.setTotal(Long.valueOf(String.valueOf(result[3])));
			
			listaRetorno.add(totalTip);
		}

		return listaRetorno;		
		
	}

	public List<RelTotalizadorSecretariaVO> relTotalizadorSecretaria(PlcBaseContextVO context, RelTotalizadorSecretariaVO totalizadorSecretaria) {
		EntityManager em = this.getEntityManager(context);
		
		// Criando a sql de consulta dos dados
		StringBuilder sql = new StringBuilder();
		sql.append("select "); 
		sql.append("sc.nome, ");
		sql.append("case oc.status_ocorrencia "); 
		sql.append("when 'ABE' then 'Em Aberto' ");
		sql.append("when 'ENC' then 'Encaminhada' ");
		sql.append("when 'ANA' then 'Em Análise' ");
		sql.append("when 'CON' then 'Concluída' ");
		sql.append("end as status_ocorrencia, ");
		sql.append("count(oc.id) as total ");
		sql.append("from "); 
		sql.append("ocorrencia oc ");
		sql.append("left join tipo_ocorrencia tp on (oc.tipo_ocorrencia = tp.id) ");
		sql.append("left join secretaria sc on (tp.secretaria = sc.id) ");
		sql.append("where 1 = 1 ");
		
		// verificando se é para filtrar por secretaria
		if (null != totalizadorSecretaria.getSecretaria()){
			sql.append("and sc.id = " + totalizadorSecretaria.getSecretaria().getId() + " ");
		}
		
		// verificando se é para filtrar por data inicial
		if (null != totalizadorSecretaria.getDataInicial()){
			sql.append("and oc.data_ocorrencia >= '" + 
					DateTimeUtils.formataData(totalizadorSecretaria.getDataInicial(), AppConstants.formatoUSA)  + " 00:00:00' ");
		}
		
		// verificando se é para filtrar por data final
		if (null != totalizadorSecretaria.getDataFinal()){
			sql.append("and oc.data_ocorrencia <= '" + 
					DateTimeUtils.formataData(totalizadorSecretaria.getDataFinal(), AppConstants.formatoUSA)  + " 23:59:59' ");
		}
		
		sql.append("group by sc.id, oc.status_ocorrencia ");
		sql.append("order by sc.nome, tp.descricao ");
			
		List<RelTotalizadorSecretariaVO> listaRetorno = new ArrayList<RelTotalizadorSecretariaVO>();
		List<Object[]> lista = em.createNativeQuery(sql.toString()).getResultList();
		
		// armazena o total de registros
		Long i = 0L;
		// percorrendo os resultados da busca
		Iterator<Object[]> ite = lista.iterator();
		
		String descricaoAnterior = "";
		while (ite.hasNext()) {
			Object[] result = (Object[]) ite.next();
			
			RelTotalizadorSecretariaVO totalSec = new RelTotalizadorSecretariaVO();
			if (descricaoAnterior.isEmpty() || !descricaoAnterior.equals(String.valueOf(result[0]))){
				totalSec.setDescricaoSecretaria(String.valueOf(result[0]));
				descricaoAnterior = totalSec.getDescricaoSecretaria(); 
			}
			totalSec.setStatus(String.valueOf(result[1]));
			totalSec.setTotal(Long.valueOf(String.valueOf(result[2])));
			
			listaRetorno.add(totalSec);
		}

		return listaRetorno;
	}
	
}
