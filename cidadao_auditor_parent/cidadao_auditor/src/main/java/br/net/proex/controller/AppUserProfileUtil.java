/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.net.proex.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.net.proex.commons.AppUserProfileVO;
import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegPerfilMenu;
import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.entity.seg.SegUsuarioPerfilEntity;
import br.net.proex.enumeration.SegTipoAcesso;
import br.net.proex.facade.IAppFacade;
import br.net.proex.utils.DateTimeUtils;

import com.powerlogic.jcompany.commons.PlcBaseUserProfileVO;
import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcContextUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.controller.util.PlcBaseUserProfileUtil;

/**
 * cidadao_auditor . Implementar aqui lógicas de perfil do usuário da aplicação (user profiling)
 */
@SPlcUtil
@QPlcDefault
public class AppUserProfileUtil extends PlcBaseUserProfileUtil {

	@Inject @QPlcDefault
	private IAppFacade facade;

	@Inject @QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;	

	@Inject @QPlcDefault
	protected PlcContextUtil contextUtil;

	@Override
	public PlcBaseUserProfileVO registrySpecificProfile(HttpServletRequest request, HttpServletResponse response,
			PlcBaseUserProfileVO plcPerfilVO) throws Exception {
		
		// Importante transformar o valor de String para Object
		// Map<String,Object> filtro = new HashMap<String,Object>();
		List<String> filtro = new ArrayList<String>();
		Map<String, Object> recurso = new HashMap<String, Object>();
		SegPerfilEntity perfil = new SegPerfilEntity();
		List<SegMenuEntity> menuNegado = new ArrayList<SegMenuEntity>();
		
		AppUserProfileVO userProfileVO = (AppUserProfileVO) plcPerfilVO;
		
		try {
			
			SegUsuarioEntity usuario = facade.findUsuarioByLogin(contextMontaUtil.createContextParamMinimum(), userProfileVO.getLogin());
			// negando o acesso a todos os menus do sistema para posterior liberação.
			List<SegMenuEntity> menus = (List<SegMenuEntity>)facade.findMenus(contextMontaUtil.createContextParamMinimum());
			if (menus != null && menus.size() > 0){
				for (SegMenuEntity menu : menus){				
					recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() : "/f/n/" + menu.getUrl(), "eventosNegados");
					recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "sel?evento=y" : "/f/n/" + menu.getUrl() + "sel?evento=y", "eventosNegados");
					recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "sel" : "/f/n/" + menu.getUrl() + "sel", "eventosNegados");
					recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "mdt" : "/f/n/" + menu.getUrl() + "mdt", "eventosNegados");
					recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "man" : "/f/n/" + menu.getUrl() + "man", "eventosNegados");				
				}												
			} else {		
				desconecta(response, userProfileVO);
				return null;
			}
			
					
			if (usuario != null && !usuario.getBloqueado()) {
											
					filtro.add("idUsuario#" + usuario.getId());				
					for (SegUsuarioPerfilEntity usuarioPerfil : usuario.getUsuarioPerfil()) {
						// verifica se o perfil ainda é válido pela data
						if (usuarioPerfil.getDataFinal() != null && DateTimeUtils.isDataInicialMaiorDataFinal(new Date(), usuarioPerfil.getDataFinal())
								|| usuarioPerfil.getDataFinal() == null && DateTimeUtils.isDataInicialMaiorDataFinal(usuarioPerfil.getDataInicial(), new Date())){
							
							perfil = usuarioPerfil.getPerfil(); //facade.findByPerfil(contextMontaUtil.createContextParamMinimum(), usuarioPerfil.getPerfil());					
							for (SegPerfilMenu menu : perfil.getPerfilMenu()) {
								String urlUser = menu.getMenu().getUrl();
								Boolean tipoAcessoNegado = Boolean.FALSE;
								// se é temporário e a data final e maior que a data atual é negado o acesso
								if (menu.getTipoAcesso().equals(SegTipoAcesso.TEM) && 
										menu.getDataFinal() != null && 
										DateTimeUtils.isDataInicialMaiorDataFinal(new Date(), menu.getDataFinal())){
											tipoAcessoNegado = Boolean.TRUE;																																							
								} else {
									tipoAcessoNegado =  menu.getTipoAcesso().equals(SegTipoAcesso.NEG) ? Boolean.TRUE : Boolean.FALSE;								
								}
								
								if (!tipoAcessoNegado){
									if (recurso.containsKey(urlUser.startsWith("/f/n/") ? urlUser : "/f/n/" + urlUser)){
										// removendo o acesso negado
										recurso.remove(urlUser.contains("/f/n/") ? urlUser : "/f/n/" + urlUser);
										recurso.remove(urlUser.contains("/f/n/") ? urlUser + "sel?evento=y" : "/f/n/" + urlUser+ "sel?evento=y");
										recurso.remove(urlUser.contains("/f/n/") ? urlUser + "sel" : "/f/n/" + urlUser + "sel");
										recurso.remove(urlUser.contains("/f/n/") ? urlUser + "mdt" : "/f/n/" + urlUser + "mdt");
										recurso.remove(urlUser.contains("/f/n/") ? urlUser + "man" : "/f/n/" + urlUser + "man");
										// inserindo o acesso permitido
										recurso.put(urlUser.startsWith("/f/n/") ? urlUser : "/f/n/" + urlUser, SegTipoAcesso.PER);									
									}								
								} else {
									menuNegado.add(menu.getMenu());
								}
							}
							usuarioPerfil.setPerfil(perfil);
						}
					}
					
					// verifica se tem algum menu negado que esta duplicado em algum perfil como permitido
					if (menuNegado != null && menuNegado.size() > 0){
						for (SegMenuEntity menu : menuNegado){
							// verificando se o acesso ao menu esta como permitido
							if (recurso.get(menu.getUrl().startsWith("/f/n/") ? menu.getUrl() : "/f/n/" + menu.getUrl()).toString().equals("PER")){
								// remove o acesso permitido
								recurso.remove(menu.getUrl().startsWith("/f/n/") ? menu.getUrl() : "/f/n/" + menu.getUrl());
								// insere o acesso negado
								// removendo o acesso negado
								recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() : "/f/n/" + menu.getUrl(), "eventosNegados");
								recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "sel?evento=y" : "/f/n/" + menu.getUrl() + "sel?evento=y", "eventosNegados");
								recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "sel" : "/f/n/" + menu.getUrl() + "sel", "eventosNegados");
								recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "mdt" : "/f/n/" + menu.getUrl() + "mdt", "eventosNegados");
								recurso.put(menu.getUrl().contains("/f/n/") ? menu.getUrl() + "man" : "/f/n/" + menu.getUrl() + "man", "eventosNegados");													
							}											
						}
					}
					
					userProfileVO.setUsuario(usuario);
	
				} else {
					desconecta(response, userProfileVO);
					return null;
			}
	
			// Deve estar ao final da montagem do Map
			// userProfileVO.getPlcVerticalSecurity().putAll(filtro);
			userProfileVO.setFilters(filtro);
			userProfileVO.setResources(recurso);
			userProfileVO.setProfileLoaded(Boolean.TRUE);
			
							
			// se usuário for Administrador Geral, adicionar essa role no perfil
			if (request.isUserInRole("Administrador Geral Plc")) {
				List<String> grupos = new ArrayList<String>(1);
				grupos.add("Administrador Geral");
				plcPerfilVO.setGroups(grupos);
			}
			
			// Retorna objeto modificado
			return plcPerfilVO;
		
    	} catch (Exception e) {
    		userProfileVO.setProfileLoaded(Boolean.FALSE);
    		desconecta(response, userProfileVO);    		
    		return null;
    	}

	}

	/**
	 * 
	 * @param response
	 * @param userProfileVO 
	 * @throws Exception
	 */
	public void desconecta(HttpServletResponse response, AppUserProfileVO userProfileVO) throws Exception {
		logout(userProfileVO);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		response.flushBuffer();					
	}

	/**
	 * 
	 * @param userProfileVO 
	 * @return
	 * @throws Exception
	 */
	public String logout(AppUserProfileVO userProfileVO) throws Exception {
		HttpServletRequest request = contextUtil.getRequest();

		if (request.getAttribute(PlcConstants.ACAO.EVENTO) == null)
			request.setAttribute(PlcConstants.ACAO.EVENTO,
			PlcConstants.ACAO.EVT_DESCONECTAR);

		if (request.getAttribute(PlcConstants.WORKFLOW.IND_ACAO_ORIGINAL) == null) 
			request.setAttribute(PlcConstants.WORKFLOW.IND_ACAO_ORIGINAL,
			PlcConstants.EVENTOS.DESCONECTA);

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie != null && cookie.getName() != null && cookie.getName().equals("JSESSIONID")) {
				cookie = null;
			}
		}
		
		request.getSession().removeAttribute(PlcConstants.USER_INFO_KEY);
		request.getSession().invalidate();
		return "logoutErro";
	}
}
