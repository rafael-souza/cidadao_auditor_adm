package br.net.proex.controller.jsf.seg;

import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcConstants;
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
import br.net.proex.commons.AppUserProfileVO;
import br.net.proex.controller.jsf.AppMB;
import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.facade.IAppFacade;
import br.net.proex.model.repository.SegUsuarioRepository;

@PlcConfigAggregation(entity = SegUsuarioEntity.class)

@PlcConfigForm(formPattern = FormPattern.Ctl, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/trocarsenha"))

@SPlcMB
@PlcUriIoC("segtrocarsenha")
@PlcHandleException
public class SegTrocarSenhaMB extends AppMB {

	@Inject @QPlcDefault
	private IAppFacade facade;

	@Inject	@QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;

	@Inject @QPlcDefault
	protected AppUserProfileVO segUserProfileVO;	
	
	@Inject
	private SegUsuarioRepository usuarioRepository;
	
	private PlcBaseContextVO contexto;
	
	/**
	 * Entidade da acao injetado pela CDI
	 */
	@Produces
	@Named("segtrocarsenha")
	public SegUsuarioEntity createEntityPlc() {

		if (this.entityPlc == null) {
			if (contexto == null){
				contexto = contextMontaUtil.createContextParamMinimum();
			}
			this.entityPlc = facade.recuperaUsuario(contexto, segUserProfileVO.getUsuario()); 					
		}
		return (SegUsuarioEntity) this.entityPlc;
	}

	
	public String trocarSenha() throws Exception {

		SegUsuarioEntity usuario = (SegUsuarioEntity) this.entityPlc;
		
		if (valida(usuario)) {											
			contexto.setMode(PlcBaseContextVO.Mode.ALTERACAO);
			usuario.setSenhaUsuario(usuario.getSenhaNova());
			usuario.setTrocouSenha(Boolean.TRUE);			
			facade.saveObject(contexto, usuario);
			msgUtil.msg(AppBeanMessages.SEG_SENHA_ALTERADA_SUCESSO, PlcMessage.Cor.msgAzulPlc.toString());
			
		}
		return null;
	}
	
	public Boolean valida(SegUsuarioEntity usuario) {
		
		Boolean retorno = Boolean.TRUE;
		
		if (usuario.getSenhaAtual() == null) {			
			msgUtil.msg(AppBeanMessages.SEG_SENHA_ATUAL_VAZIA, PlcMessage.Cor.msgAmareloPlc.toString());			
			retorno = Boolean.FALSE;	
		}
		
		if (usuario.getSenhaNova() == null) {
			msgUtil.msg(AppBeanMessages.SEG_SENHA_NOVA_VAZIA, PlcMessage.Cor.msgAmareloPlc.toString());
			retorno = Boolean.FALSE;	
		}

		if (usuario.getSenhaNovaRepete() == null) {
			msgUtil.msg(AppBeanMessages.SEG_CONFIRMA_SENHA_NOVA_VAZIA, PlcMessage.Cor.msgAmareloPlc.toString());			
			retorno = Boolean.FALSE;	
		}

		if (!retorno) {
			return retorno;
		}
		
		if (!usuarioRepository.encriptaSenha(usuario.getSenhaAtual()).equals(usuario.getSenhaUsuario())) {
			msgUtil.msg(AppBeanMessages.SEG_SENHA_ATUAL_INCORRETA, PlcMessage.Cor.msgVermelhoPlc.toString());			
			retorno = Boolean.FALSE;	
		}
		
		if (!usuario.getSenhaNova().equals(usuario.getSenhaNovaRepete())) {
			msgUtil.msg(AppBeanMessages.SEG_SENHAS_DIFERENTES, PlcMessage.Cor.msgVermelhoPlc.toString());			
			retorno = Boolean.FALSE;	
		}

		return retorno;
	}
	

	@Override
	public void handleButtonsAccordingFormPattern() {
		super.handleButtonsAccordingFormPattern();
		Map<String, Object> requestMap = contextUtil.getRequestMap();
		requestMap.put(PlcConstants.ACAO.EXIBE_BT_GRAVAR, PlcConstants.NAO_EXIBIR);
	}
	
}
