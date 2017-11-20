package br.net.proex.model.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcRepository;
import com.powerlogic.jcompany.model.PlcBaseRepository;

import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegPerfilMenuEntity;
import br.net.proex.enumeration.SegTipoAcesso;
import br.net.proex.persistence.jpa.SegMenuDAO;

/**
 * Classe de Modelo gerada pelo assistente
 */

@SPlcRepository
@PlcAggregationIoC(clazz = SegPerfilEntity.class)
public class SegPefilRepository extends PlcBaseRepository {
	
	@Inject
	private SegMenuDAO menuDAO;
	
	@Override
	public Object insert(PlcBaseContextVO context, Object entidade)	throws PlcException, Exception {
		SegPerfilEntity perfil = (SegPerfilEntity)entidade;
		List<SegPerfilMenuEntity> listaPerfilMenu = new ArrayList<SegPerfilMenuEntity>();
		
		// buscando os menus cadastrados		
		SegMenuEntity menuFiltro = new SegMenuEntity();
		List<SegMenuEntity> listaMenu = (List<SegMenuEntity>) menuDAO.findList(context, menuFiltro, "", 0, 0);		
		if (listaMenu != null && listaMenu.size() > 0){
			// inserindo os menus para o perfil
			for (SegMenuEntity menu : listaMenu){
				SegPerfilMenuEntity perfilMenu = new SegPerfilMenuEntity();
				perfilMenu.setPerfil(perfil);
				perfilMenu.setMenu(menu);
				perfilMenu.setTipoAcesso(SegTipoAcesso.PER);				
			
				listaPerfilMenu.add(perfilMenu);
			}
		}
		// setando a lista criada de menus no perfil
		perfil.setPerfilMenu(listaPerfilMenu);		
		return super.insert(context, perfil);
	}
}
