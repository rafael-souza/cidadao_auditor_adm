package br.net.proex.controller.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.powerlogic.jcompany.commons.PlcBaseUserProfileDTO;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefaultLiteral;
import com.powerlogic.jcompany.commons.integration.IPlcJSecurityApi;
import com.powerlogic.jcompany.commons.integration.impl.PlcJSecurityApiImpl;
import com.powerlogic.jcompany.commons.util.PlcIocFacadeUtil;
import com.powerlogic.jcompany.commons.util.cdi.PlcCDIUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;

import br.net.proex.commons.AppUserProfileVO;
import br.net.proex.controller.exception.AppAcessoNegadoException;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegPerfilMenu;
import br.net.proex.entity.seg.SegUsuarioPerfilEntity;
import br.net.proex.enumeration.SegTipoAcesso;
import br.net.proex.facade.IAppFacade;

@Specializes
public class AppSecurityApiImpl extends PlcJSecurityApiImpl implements IPlcJSecurityApi{
		
	@Inject @QPlcDefault
	protected AppUserProfileVO userProfileVO;

	@Inject @QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;
	
	
	
	@Override
	public PlcBaseUserProfileDTO carregaProfileJSecurity(
			HttpServletRequest request, HttpServletResponse response,
			PlcBaseUserProfileDTO usuario) {
	
		Map<String, Object> recursos = new HashMap<String, Object>();
		
		SegPerfilEntity perfil = new SegPerfilEntity();
		
		for (SegUsuarioPerfilEntity usuarioPerfil : userProfileVO.getUsuario().getUsuarioPerfil()){
			perfil = usuarioPerfil.getPerfil();	
			for (SegPerfilMenu menu : perfil.getPerfilMenu()) {	
				String urlUser = menu.getMenu().getUrl();	
				if (menu.getTipoAcesso() == null ? false : !menu.getTipoAcesso().equals(SegTipoAcesso.NEG)){
					recursos.put( urlUser.startsWith("/f/n/") ? urlUser : "/f/n/" + urlUser , true);
				}										
			}
		}
							
		usuario.setResources(recursos);		
		return super.carregaProfileJSecurity(request, response, usuario);
	}	
	
		
	/**
	 * 	
	 */
	@Override
	public void efetivaSeguranca(ServletRequest servletRequest, ServletResponse servletResponse) {
	    		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		SegPerfilEntity perfil = new SegPerfilEntity();
		
		if (userProfileVO.getUsuario() != null && userProfileVO.isProfileLoaded()){
			for (SegUsuarioPerfilEntity usuarioPerfil : userProfileVO.getUsuario().getUsuarioPerfil()){
				Map<String,Object> recurso = userProfileVO.getResources() != null ? userProfileVO.getResources() : new HashMap<String,Object>();
				perfil = usuarioPerfil.getPerfil();	
				for (SegPerfilMenu menu : perfil.getPerfilMenu()) {
					
					if (userProfileVO.isAccessDenied()) {
						try {
							((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath());
						} catch (IOException e) {
							e.printStackTrace();
						}
						return;
					}	
					
					String uriPath = request.getRequestURI().replace(request.getContextPath(), "");					 
					Boolean liberar = Boolean.FALSE;					
					
					if (uriPath.startsWith("/f/n/")) {	
						
						if (!menu.getTipoAcesso().equals(SegTipoAcesso.PER)) {
							liberar = Boolean.TRUE;
						} else {					
							for (Map.Entry<String,Object> entry : recurso.entrySet()) {						
								if (uriPath.startsWith(((String)entry.getKey())) && 
										!((entry.getValue() == null ? "eventosNegados" : entry.getValue()).equals("eventosNegados"))){
									liberar = Boolean.TRUE;
								}				    
							}		
						}
					} else {
						liberar = Boolean.TRUE;
					} 
					
					if (!liberar) {
						throw new AppAcessoNegadoException();
					}
					
				}
			}
 		} else {
			throw new AppAcessoNegadoException();
		}
	}	
		
	/**
	 * 
	 */
	@Override
	public boolean isAcessoNegado(String recurso, PlcBaseUserProfileDTO usuario) {
		return usuario.getResources().get(recurso).equals("eventosNegados")  ? Boolean.TRUE : Boolean.FALSE;
	}
}
