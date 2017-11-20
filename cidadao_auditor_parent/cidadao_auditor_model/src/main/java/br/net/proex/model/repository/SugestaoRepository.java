package br.net.proex.model.repository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcException;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcRepository;
import com.powerlogic.jcompany.model.PlcBaseRepository;

import br.net.proex.entity.SugestaoEntity;
import br.net.proex.entity.OcorrenciaEntity;

/**
 * Classe de Modelo gerada pelo assistente
 */

@SPlcRepository
@PlcAggregationIoC(clazz = SugestaoEntity.class)
public class SugestaoRepository extends PlcBaseRepository {

	/**
	 * 
	 */
	@Override
	public Object insert(PlcBaseContextVO context, Object entidade) throws PlcException, Exception {
		SugestaoEntity sugestao = (SugestaoEntity) entidade;	
		// gerando o nº do protocolo da sugestao
		sugestao.setProtocolo(gerarProtocolo(sugestao.getPessoa().getNome() + new Date()));
		// realiza a inserção do registro
		return super.insert(context, entidade);
	}
	
	public static String gerarProtocolo(String valor) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte messageDigest[] = digest.digest(valor.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
			return valor;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return valor;
		}
	}	

}
