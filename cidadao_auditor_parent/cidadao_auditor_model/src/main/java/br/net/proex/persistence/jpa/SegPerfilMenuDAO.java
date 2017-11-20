package br.net.proex.persistence.jpa;

import java.util.Date;
import java.util.List;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;

import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.entity.seg.SegPerfil;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegPerfilMenuEntity;
import br.net.proex.enumeration.SegTipoAcesso;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(SegPerfilMenuEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class SegPerfilMenuDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<SegPerfilMenuEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="perfil", expression="obj1 = :perfil") SegPerfilEntity perfil,
			@PlcQueryParameter(name="dataInicial", expression="obj.dataInicial >= :dataInicial  ") Date dataInicial,
			@PlcQueryParameter(name="dataFinal", expression="obj.dataFinal >= :dataFinal  ") Date dataFinal,
			@PlcQueryParameter(name="menu", expression="obj2 = :menu") SegMenuEntity menu
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="perfil", expression="obj1 = :perfil") SegPerfilEntity perfil,
			@PlcQueryParameter(name="dataInicial", expression="obj.dataInicial >= :dataInicial  ") Date dataInicial,
			@PlcQueryParameter(name="dataFinal", expression="obj.dataFinal >= :dataFinal  ") Date dataFinal,
			@PlcQueryParameter(name="menu", expression="obj2 = :menu") SegMenuEntity menu
	);
	
	/**
	 * Insere perfilMenu com o novo menu para todos os perfis personalizados
	 *  
	 * @param context
	 * @param menu
	 */
	@SuppressWarnings("unchecked")
	public void inserirPorMenu(PlcBaseContextVO context, SegMenuEntity menu) {
		SegPerfilEntity perfilFiltro = new SegPerfilEntity();
		
		List<SegPerfilEntity> listaPerfil = (List<SegPerfilEntity>)findList(context, perfilFiltro, "", 0, 0);
		
		if (listaPerfil != null && listaPerfil.size() > 0) {
			
			SegPerfilMenuEntity perfilMenu;
			
			for (SegPerfilEntity perfil : listaPerfil) {
				perfilMenu = new SegPerfilMenuEntity();
				perfilMenu.setMenu(menu);
				perfilMenu.setPerfil(perfil);
				perfilMenu.setTipoAcesso(SegTipoAcesso.PER);
				
				insert(context, perfilMenu);
			}
		}
	}
	
	/**
	 * Excluir os perfilMenu do menu
	 *  
	 * @param context
	 * @param menu
	 */
	public void excluirPorMenu(PlcBaseContextVO context, SegMenuEntity menu) {
		String hql = " delete from SegPerfilMenuEntity where menu = " + menu.getId();
		apiCreateQuery(context, SegPerfil.class, hql).executeUpdate();
	}
}
