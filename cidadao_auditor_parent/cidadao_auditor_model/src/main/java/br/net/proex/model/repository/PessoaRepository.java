package br.net.proex.model.repository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcRepository;
import com.powerlogic.jcompany.model.PlcBaseRepository;

import br.net.proex.entity.PessoaEntity;
import br.net.proex.utils.DateTimeUtils;

/**
 * Classe de Modelo gerada pelo assistente
 */

@SPlcRepository
@PlcAggregationIoC(clazz = PessoaEntity.class)
public class PessoaRepository extends PlcBaseRepository {

	/**
	 * 
	 */
	@Override
	public Object insert(PlcBaseContextVO context, Object entidade) throws PlcException, Exception {
		PessoaEntity pessoa = (PessoaEntity) entidade;
		if (null != pessoa.getSenha()){
			pessoa.setSenha(gerarMd5Senha(pessoa.getSenha()));
		}
		
		// ajustando a data de nascimento da pessoa caso ela tenha informado
		if (null != pessoa.getDataCadastro() && !pessoa.getDataCadastro().isEmpty()){ 
			pessoa.setDataNascimento(DateTimeUtils.string2Date(pessoa.getDataCadastro()));
		}
		
		// realiza a inserção do registro
		return super.insert(context, entidade);
	}
	
	
	/**
	 * 
	@Override
	public Object update(PlcBaseContextVO context, Object entidade) {
		PessoaEntity pessoa = (PessoaEntity) entidade;
		if (null != pessoa.getSenha()){
			pessoa.setSenha(gerarMd5Senha(pessoa.getSenha()));
		}
		return super.update(context, entidade);
	}*/
	
	/**
	 * 
	 * @param senha
	 * @return
	 */
	public static String gerarMd5Senha(String senha) {
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
