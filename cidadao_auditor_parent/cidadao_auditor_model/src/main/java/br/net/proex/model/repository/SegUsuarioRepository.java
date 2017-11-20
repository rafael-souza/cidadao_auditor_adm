package br.net.proex.model.repository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcRepository;
import com.powerlogic.jcompany.model.PlcBaseRepository;

import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.persistence.jpa.SegUsuarioDAO;

/**
 * Classe de Modelo gerada pelo assistente
 */

@SPlcRepository
@PlcAggregationIoC(clazz = SegUsuarioEntity.class)
public class SegUsuarioRepository extends PlcBaseRepository {
	
	
	/**
	 * 
	 */
	@Override
	public Object insert(PlcBaseContextVO context, Object entidade)	throws PlcException, Exception {
		((SegUsuarioEntity) entidade).setSenhaUsuario(encriptaSenha(((SegUsuarioEntity) entidade).getSenhaUsuario()));
		SegUsuarioEntity usuario = (SegUsuarioEntity) super.insert(context, entidade);
		return usuario;
	}

	/**
	 * 
	 */
	@Override
	public Object update(PlcBaseContextVO context, Object entidade) {
		SegUsuarioEntity usuario = (SegUsuarioEntity) entidade;
		if (((SegUsuarioEntity) entidade).getTrocouSenha()){
			((SegUsuarioEntity) entidade).setSenhaUsuario(encriptaSenha(((SegUsuarioEntity) entidade).getSenhaUsuario()));
		}
		usuario = (SegUsuarioEntity) super.update(context, usuario);
		return usuario;
	}

	/**
	 * 
	 * @param senha
	 * @return
	 */
	public static String encriptaSenha(String senha) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte messageDigest[] = digest.digest(senha.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
			return senha;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return senha;
		}
	}
}
