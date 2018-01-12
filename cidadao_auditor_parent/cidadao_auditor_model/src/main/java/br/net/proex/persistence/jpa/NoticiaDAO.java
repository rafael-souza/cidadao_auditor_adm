package br.net.proex.persistence.jpa;

import br.net.proex.entity.NoticiaEntity;
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

@PlcAggregationDAOIoC(NoticiaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class NoticiaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<NoticiaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="titulo", expression="titulo like :titulo || '%' ") String titulo,
			@PlcQueryParameter(name="autor", expression="autor like :autor || '%' ") String autor,
			@PlcQueryParameter(name="dataNoticia", expression="dataNoticia >= :dataNoticia  ") Date dataNoticia
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="titulo", expression="titulo like :titulo || '%' ") String titulo,
			@PlcQueryParameter(name="autor", expression="autor like :autor || '%' ") String autor,
			@PlcQueryParameter(name="dataNoticia", expression="dataNoticia >= :dataNoticia  ") Date dataNoticia
	);
	
}
