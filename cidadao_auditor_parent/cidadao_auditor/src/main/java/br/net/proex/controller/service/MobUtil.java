package br.net.proex.controller.service;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcUtil;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;

import br.net.proex.entity.Pessoa;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.facade.IAppFacade;


/**
 * 
 * @author rafael
 *
 */
@SPlcUtil
@QPlcDefault
public class MobUtil implements Serializable {

	/** atributo facade */
	@Inject @QPlcDefault
	private IAppFacade facade;

	/** atributo contextMontaUtil */
	@Inject	@QPlcDefault
	protected PlcCreateContextUtil contextMontaUtil;

	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public String getToken(Pessoa pessoa) {
		Calendar data = Calendar.getInstance();
		return gerarMD(pessoa.getEmail()
				+ pessoa.getSenha().toUpperCase()
				+ formataData(data.getTime(), "yyyyMMdd"))
				+ "("+pessoa.getEmail()+")";
	}

	/**
	 * 
	 * @param usuario
	 * @param horas
	 * @return
	 */
	public String getToken(Pessoa pessoa, Integer horas) {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.HOUR_OF_DAY, horas);
		return gerarMD(pessoa.getEmail()
				+ pessoa.getSenha()
				+ formataData(data.getTime(), "yyyyMMdd"))
				+ "("+pessoa.getEmail()+")";
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public boolean validaToken(String token) {
 		if (token == null || token.length() < 3) {
			return false;
		}

		try {
			// login para busca do usuário logado
			String email = token.substring(token.indexOf("(") + 1, token.lastIndexOf(")"));  
									
			// buscando a pessoa no banco para retorno/validação
			PessoaEntity pessoa = new PessoaEntity();
			pessoa.setEmail(email);
			pessoa = facade.findPessoaByEmail(contextMontaUtil.createContextParamMinimum(), email);
			
			// verificando se o token informado é um token válido
			return (null != pessoa && token.equals(getToken(pessoa)));
			
			//return true;

		} catch (Exception e) {
			return false;
		} 
		 	
	}

	/**
	 * 
	 * @param md5
	 * @return
	 */
	public String gerarMD(String md5) {
		MessageDigest md;
		StringBuffer sb = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}

	/**
	 * 
	 * @param data
	 * @param formato
	 * @return
	 */
	public String formataData(Object data, String formato) {
		SimpleDateFormat sfd = new SimpleDateFormat(formato);
		try {
			if (data instanceof Date) {
				return data == null ? null : sfd.format(data);
			} else {
				Throwable e = new Throwable("Conversão para o tipo de objeto passado não implementado, informe ao adminstrador do sistema.");
				throw new Exception("Util : formataData ", e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
