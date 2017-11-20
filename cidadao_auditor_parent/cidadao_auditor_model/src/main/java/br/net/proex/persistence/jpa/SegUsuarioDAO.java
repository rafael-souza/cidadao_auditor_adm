package br.net.proex.persistence.jpa;

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

import br.net.proex.entity.seg.SegPerfilMenuAcaoNegadoEntity;
import br.net.proex.entity.seg.SegPerfilMenuCampoEntity;
import br.net.proex.entity.seg.SegPerfilMenuEntity;
import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.entity.seg.SegUsuarioPerfilEntity;

/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(SegUsuarioEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class SegUsuarioDAO extends AppJpaDAO {	

	@PlcQuery("querySel")
	public native List<SegUsuarioEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc,
			@PlcQueryLineAmount Integer numeroLinhasPlc,

			@PlcQueryParameter(name = "id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name = "loginUsuario", expression = "obj.loginUsuario like '%' || :loginUsuario || '%' ") String loginUsuario);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,

			@PlcQueryParameter(name = "id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name = "loginUsuario", expression = "obj.loginUsuario like '%' || :loginUsuario || '%' ") String loginUsuario);
	
	
	/**
	 * 
	 * @param context
	 * @param loginUsuario
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SegUsuarioEntity findByLogin(PlcBaseContextVO context, String loginUsuario) {
		List<SegUsuarioEntity> lista = executeQueryWithParams(context, SegUsuarioEntity.class, "findByLogin", new String[] {"loginUsuario"}, new Object[] {loginUsuario}, 0, 0);
		if (lista != null && lista.size() > 0) {
			SegUsuarioEntity usuario = (SegUsuarioEntity) lista.get(0);
			
			SegUsuarioPerfilEntity usuarioPerfilFiltro = new SegUsuarioPerfilEntity();
			usuarioPerfilFiltro.setUsuario(usuario);
			
			context.setApiQuerySel("querySelLoad");			
			usuario.setUsuarioPerfil((List<SegUsuarioPerfilEntity>) this.findList(context, usuarioPerfilFiltro, "", 0, 0));
			context.setApiQuerySel(null);
			
			if (usuario.getUsuarioPerfil() != null && usuario.getUsuarioPerfil().size() > 0){
				for(SegUsuarioPerfilEntity usuarioPerfil : usuario.getUsuarioPerfil()){
					SegPerfilMenuEntity perfilMenuFiltro = new SegPerfilMenuEntity();
					perfilMenuFiltro.setPerfil(usuarioPerfil.getPerfil());					
					usuarioPerfil.getPerfil().setPerfilMenu(((List<SegPerfilMenuEntity>) this.findList(context, perfilMenuFiltro, "", 0, 0)));
					
					if (usuarioPerfil.getPerfil().getPerfilMenu() != null && usuarioPerfil.getPerfil().getPerfilMenu().size() > 0){
						for (SegPerfilMenuEntity perfilMenu : usuarioPerfil.getPerfil().getPerfilMenu()){
							// buscando as ações negadas do perfil
							SegPerfilMenuAcaoNegadoEntity perfilMenuAcaoNegado = new SegPerfilMenuAcaoNegadoEntity();
							perfilMenuAcaoNegado.setPerfilMenu(perfilMenu);							
							perfilMenu.setPerfilMenuAcaoNegado(((List<SegPerfilMenuAcaoNegadoEntity>) this.findList(context, perfilMenuAcaoNegado, "", 0, 0)));
																			
							// buscando os campos negados do perfil
							SegPerfilMenuCampoEntity perfilMenuCampo = new SegPerfilMenuCampoEntity();
							perfilMenuCampo.setPerfilMenu(perfilMenu);
							perfilMenu.setPerfilMenuCampo(((List<SegPerfilMenuCampoEntity>) this.findList(context, perfilMenuCampo, "", 0, 0)));																											
						}
						
					}										
				}									
			}
			
			return usuario;
		}				
		return null;
	}
}
