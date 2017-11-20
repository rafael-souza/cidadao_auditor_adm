package br.net.proex.model.repository;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcRepository;
import com.powerlogic.jcompany.model.PlcBaseRepository;

import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.persistence.jpa.SegPerfilMenuDAO;

/**
 * Classe de Modelo gerada pelo assistente
 */
 
@SPlcRepository 
@PlcAggregationIoC(clazz=SegMenuEntity.class)
public class SegMenuRepository extends PlcBaseRepository {

	@Inject
	private SegPerfilMenuDAO perfilMenuDAO;	

	
	@Override
	public Object insert(PlcBaseContextVO context, Object entidade) throws PlcException, Exception {
		entidade = super.insert(context, entidade);
		perfilMenuDAO.inserirPorMenu(context, (SegMenuEntity) entidade);
		return entidade;
	}

	@Override
	public void delete(PlcBaseContextVO context, Object entidade) {
		perfilMenuDAO.excluirPorMenu(context, (SegMenuEntity) entidade);
		super.delete(context, entidade);		
	}
}
