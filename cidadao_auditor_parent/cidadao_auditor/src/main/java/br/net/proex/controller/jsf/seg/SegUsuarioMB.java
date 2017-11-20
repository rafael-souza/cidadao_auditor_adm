package br.net.proex.controller.jsf.seg;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.entity.seg.SegUsuarioPerfilEntity;
import br.net.proex.facade.IAppFacade;

@PlcConfigAggregation(entity = SegUsuarioEntity.class, 
	details = {@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(
		clazz = SegUsuarioPerfilEntity.class, collectionName = "usuarioPerfil", numNew = 1, onDemand = false)
})
@PlcConfigForm(

formPattern = FormPattern.Mdt, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/usuario")

)
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("segusuario")
@PlcHandleException
public class SegUsuarioMB extends AppMB {

	private static final long serialVersionUID = 1L;
    
    /** atributo context monta util */
	@Inject	@QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;    
	

	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("segusuario")
	public SegUsuarioEntity createEntityPlc() {
		if (this.entityPlc == null) {
			this.entityPlc = new SegUsuarioEntity();
			this.newEntity();
		}
		return (SegUsuarioEntity) this.entityPlc;
	}
	
	@Override
	public String save() {
		SegUsuarioEntity usuario = (SegUsuarioEntity) this.entityPlc;
		
		usuario.setTrocouSenha(Boolean.FALSE);
		Boolean trocouSenha = Boolean.FALSE;
		
		if (StringUtils.isNotBlank(usuario.getSenhaNova()) && StringUtils.isNotBlank(usuario.getSenhaNovaRepete())) { 
			if (!usuario.getSenhaNova().equals(usuario.getSenhaNovaRepete())) {
				msgUtil.msg(AppBeanMessages.SEG_SENHAS_DIFERENTES, PlcMessage.Cor.msgVermelhoPlc.toString());
				usuario.setSenhaNova(null);
				usuario.setSenhaNovaRepete(null);
				return null;
			} else {
				usuario.setSenhaUsuario(usuario.getSenhaNova());
				usuario.setTrocouSenha(Boolean.TRUE);
				trocouSenha = Boolean.TRUE;
			}
		}
									
		String retorno = super.save();
		if (trocouSenha) {
			msgUtil.msg(AppBeanMessages.SEG_SENHA_ALTERADA_SUCESSO, PlcMessage.Cor.msgAzulPlc.toString());
		}	
		
		return retorno;
	}	

}
