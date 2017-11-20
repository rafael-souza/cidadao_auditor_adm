package br.net.proex.model.repository;

import java.util.List;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcRepository;
import com.powerlogic.jcompany.model.PlcBaseRepository;

import br.net.proex.entity.seg.SegBaseEntityRevision;
import br.net.proex.persistence.jpa.SegBaseRevisionDAO;

/**
 * Classe de Modelo gerada pelo assistente
 */
 
@SPlcRepository 
@PlcAggregationIoC(clazz=SegBaseEntityRevision.class)
public class SegBaseRevisionRepository extends PlcBaseRepository {

	@Inject
	private SegBaseRevisionDAO baseRevisionDAO;
	
	@Override
	public List findList(PlcBaseContextVO context, Object entidade,	String orderyByDinamico, int primeiraLinha, int maximoLinhas) {
		
		((SegBaseEntityRevision)entidade).setUsuarioUltAlteracao(((SegBaseEntityRevision)entidade).getUsuarioAux());
		((SegBaseEntityRevision)entidade).setDataUltAlteracao(((SegBaseEntityRevision)entidade).getDataAux());
		
		return baseRevisionDAO.getListaBaseEntityRevision(context, (SegBaseEntityRevision) entidade);
		
		
		//return super.findList(context, entidade, orderyByDinamico, primeiraLinha, maximoLinhas);
	}
	
	@Override
	public Long findCount(PlcBaseContextVO context, Object entidade) {
		
		((SegBaseEntityRevision)entidade).setUsuarioUltAlteracao(((SegBaseEntityRevision)entidade).getUsuarioAux());
		((SegBaseEntityRevision)entidade).setDataUltAlteracao(((SegBaseEntityRevision)entidade).getDataAux());
		
		return baseRevisionDAO.getCountListaBaseEntityRevision(context, (SegBaseEntityRevision)entidade);

		//return super.findCount(context, entidade);
	}
}
