package br.net.proex.persistence.jpa;

import br.net.proex.entity.TipoOcorrenciaEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.net.proex.enumeration.TipoSecretario;

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

@PlcAggregationDAOIoC(TipoOcorrenciaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class TipoOcorrenciaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<TipoOcorrenciaEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="descricao", expression="descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="secretariaResponsavel", expression="secretariaResponsavel = :secretariaResponsavel") TipoSecretario secretariaResponsavel
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="descricao", expression="descricao like :descricao || '%' ") String descricao,
			@PlcQueryParameter(name="secretariaResponsavel", expression="secretariaResponsavel = :secretariaResponsavel") TipoSecretario secretariaResponsavel
	);
	
	/**
	 * 
	 * @param context
	 * @param secretaria
	 * @return
	 */
	public List<TipoOcorrenciaEntity> buscaTipoPorSecretaria(PlcBaseContextVO context, TipoSecretario secretaria){
		TipoOcorrenciaEntity tipoOcorrencia = new TipoOcorrenciaEntity();
		tipoOcorrencia.setSecretariaResponsavel(secretaria);
		return (List<TipoOcorrenciaEntity>)this.findList(context, tipoOcorrencia, "", 0, 0);
	}
}
