package br.net.proex.persistence.jpa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
import br.net.proex.entity.seg.SegBaseEntityRevision;
import br.net.proex.enumeration.SegAcaoRealizada;
import br.net.proex.utils.DateTimeUtils;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(SegBaseEntityRevision.class)
@SPlcDataAccessObject
@PlcQueryService
public class SegBaseRevisionDAO extends AppJpaDAO  {

	@Inject
	protected  DateTimeUtils dateTimeUtils;
	
	@Inject
	private SegMenuDAO menuDAO;
	
	@PlcQuery("querySel")
	public native List<SegBaseEntityRevision> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="acaoRealizada", expression="acaoRealizada = :acaoRealizada") SegAcaoRealizada acaoRealizada,
			@PlcQueryParameter(name="descricao", expression="descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="usuarioUltAlteracao", expression="usuarioUltAlteracao like :usuarioUltAlteracao || '%' ") String usuarioUltAlteracao,			
			@PlcQueryParameter(name="dataAux", expression="cast (dataUltAlteracao as date) = :dataAux  ") Date dataAux
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="acaoRealizada", expression="acaoRealizada = :acaoRealizada") SegAcaoRealizada acaoRealizada,
			@PlcQueryParameter(name="descricao", expression="descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="usuarioUltAlteracao", expression="usuarioUltAlteracao like :usuarioUltAlteracao || '%' ") String usuarioUltAlteracao,
			@PlcQueryParameter(name="dataAux", expression="cast (dataUltAlteracao as date) = :dataAux  ") Date dataAux
	);
	
	
	public List<SegBaseEntityRevision> getListaBaseEntityRevision(PlcBaseContextVO context, SegBaseEntityRevision segBaseEntityRevision) {
		
		EntityManager em = getEntityManager(context);
		
		String sqlQuery = "select obj.revision as rev ,obj.dataUltAlteracao as dataUltAlteracao ,obj.usuarioUltAlteracao as usuarioUltAlteracao ," +
				" obj.acaoRealizada as acaoRealizada, obj.casoDeUso as casoDeUso, obj.descricao as descricao from vw_aud_"+ segBaseEntityRevision.getMenu().getUrl() + " obj ";
		String sql = "";		
		
		if (segBaseEntityRevision.getUsuarioAux()!=null){
			if (sql.equals(""))
				sql = sql + " where  obj.usuarioUltAlteracao like '"+segBaseEntityRevision.getUsuarioAux()+"' ";
			else
				sql = sql + " and  obj.usuarioUltAlteracao like '"+segBaseEntityRevision.getUsuarioAux()+"' ";
		}
		if (segBaseEntityRevision.getDataAux()!=null){
			if (sql.equals(""))
				sql = sql + "  where CAST(obj.dataUltAlteracao as DATE) =  '"+ dateTimeUtils.formataData(segBaseEntityRevision.getDataAux(), AppConstants.formatoUSA)+"'";
			else
				sql = sql + "  and CAST(obj.dataUltAlteraca oas DATE) =  '"+ dateTimeUtils.formataData(segBaseEntityRevision.getDataAux(), AppConstants.formatoUSA)+"'";
		}
		if (segBaseEntityRevision.getAcaoRealizada() !=null){
			if (sql.equals(""))
				sql = sql + " where  obj.acaoRealizada = '"+segBaseEntityRevision.getAcaoRealizada()+"'";
			else
				sql = sql + " and  obj.acaoRealizada = '"+segBaseEntityRevision.getAcaoRealizada()+"'";
		} 	
		if (segBaseEntityRevision.getDescricao() !=null){
			if (sql.equals(""))
				sql = sql + " where  obj.descricao = '%' || '"+segBaseEntityRevision.getDescricao()+"' || '%' ";
			else
				sql = sql + " and  obj.descricao = '%' || '"+segBaseEntityRevision.getDescricao()+"' || '%' ";
		}
		sqlQuery = sqlQuery + sql + " order by rev" ;
		
		List<SegBaseEntityRevision> listaBaseEntityRevision = new ArrayList<SegBaseEntityRevision>();
		
		List<Object[]> lista = em.createNativeQuery(sqlQuery).getResultList();
		
		for (Object[] objeto : lista) {
			listaBaseEntityRevision.add(new SegBaseEntityRevision(objeto));
		}
					
		return listaBaseEntityRevision;		
	}
	

	public Long getCountListaBaseEntityRevision(PlcBaseContextVO context, SegBaseEntityRevision segBaseEntityRevision) {
		
		EntityManager em = getEntityManager(context);		
		
		String sqlQuery = "select count(*) as col_0_0_ from vw_aud_"+ segBaseEntityRevision.getMenu().getUrl() + " obj ";
		String sql = "";		
		
		if (segBaseEntityRevision.getUsuarioAux()!=null){
			if (sql.equals(""))
				sql = sql + " where  obj.usuarioUltAlteracao like '"+segBaseEntityRevision.getUsuarioAux()+"' ";
			else
				sql = sql + " and  obj.usuarioUltAlteracao like '"+segBaseEntityRevision.getUsuarioAux()+"' ";
		}
		if (segBaseEntityRevision.getDataAux()!=null){
			if (sql.equals(""))
				sql = sql + "  where CAST(obj.dataUltAlteracao as DATE) =  '"+dateTimeUtils.formataData(segBaseEntityRevision.getDataAux(), AppConstants.formatoUSA)+"'";
			else
				sql = sql + "  and CAST(obj.dataUltAlteracao as DATE) =  '"+dateTimeUtils.formataData(segBaseEntityRevision.getDataAux(), AppConstants.formatoUSA)+"'";
		}
		if (segBaseEntityRevision.getAcaoRealizada() !=null){
			if (sql.equals(""))
				sql = sql + " where  obj.acaoRealizada = '"+segBaseEntityRevision.getAcaoRealizada()+"'";
			else
				sql = sql + " and  obj.acaoRealizada = '"+segBaseEntityRevision.getAcaoRealizada()+"'";
		} 	
		if (segBaseEntityRevision.getDescricao() !=null){
			if (sql.equals(""))
				sql = sql + " where  obj.descricao = '%' || '"+segBaseEntityRevision.getDescricao()+"' || '%' ";
			else
				sql = sql + " and  obj.descricao = '%' || '"+segBaseEntityRevision.getDescricao()+"' || '%' ";
		}
		sqlQuery = sqlQuery + sql;
		
		Object objeto = em.createNativeQuery(sqlQuery).getSingleResult();
		
		return  new BigInteger(String.valueOf(objeto == null ? 0 : objeto)).longValue();
	}
		
}
