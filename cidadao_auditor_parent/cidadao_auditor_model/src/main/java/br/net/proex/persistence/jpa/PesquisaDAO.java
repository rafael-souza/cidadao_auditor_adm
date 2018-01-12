package br.net.proex.persistence.jpa;

import br.net.proex.entity.PesquisaEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import java.util.Date;

import java.util.List;

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

@PlcAggregationDAOIoC(PesquisaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class PesquisaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<PesquisaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="descricao", expression="descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="dataPesquisa", expression="dataPesquisa >= :dataPesquisa  ") Date dataPesquisa,
			@PlcQueryParameter(name="encerrada", expression="encerrada = :encerrada") Boolean encerrada
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="descricao", expression="descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="dataPesquisa", expression="dataPesquisa >= :dataPesquisa  ") Date dataPesquisa,
			@PlcQueryParameter(name="encerrada", expression="encerrada = :encerrada") Boolean encerrada
	);
	
}
