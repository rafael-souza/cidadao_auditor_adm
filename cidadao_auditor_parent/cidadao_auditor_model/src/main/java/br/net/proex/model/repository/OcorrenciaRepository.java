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

import br.net.proex.entity.OcorrenciaEntity;

/**
 * Classe de Modelo gerada pelo assistente
 */

@SPlcRepository
@PlcAggregationIoC(clazz = OcorrenciaEntity.class)
public class OcorrenciaRepository extends PlcBaseRepository {

	/**
	 * 
	 */
	@Override
	public Object update(PlcBaseContextVO context, Object entidade) {
//		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) entidade;
//		if (null != ocorrencia.getLatitude() && null != ocorrencia.getLongitude()){
//			ocorrencia.setEndereco(getAddress(ocorrencia.getLatitude() + "," + ocorrencia.getLongitude()));
//		}				
		return super.update(context, entidade);
	}

	/**
	 * 
	 */
	@Override
	public Object insert(PlcBaseContextVO context, Object entidade) throws PlcException, Exception {
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) entidade;
//		if (null != ocorrencia.getLatitude() && null != ocorrencia.getLongitude()){
//			ocorrencia.setEndereco(getAddress(ocorrencia.getLatitude() + "," + ocorrencia.getLongitude()));
//		}	
		// gerando o nº do protocolo da ocorrencia
		ocorrencia.setProtocolo(gerarProtocolo(ocorrencia.getPessoa().getNome() + new Date()));
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
	
	
	

	/**
	 * 
	 * @param latlong
	 * @return
	 */
	public String getAddress(String latlong) {
		String address = null;
		String gURL = "http://maps.google.com/maps/api/geocode/xml?latlng=" + latlong + "&sensor=true";
		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			Document dom = db.parse(gURL);
			Element docEl = dom.getDocumentElement();
			NodeList nl = docEl.getElementsByTagName("result");
			if (nl != null && nl.getLength() > 0) {
				address = ((Element) nl.item(0)).getElementsByTagName("formatted_address").item(0).getTextContent();
				for (int i = 0; i < nl.getLength(); i++) {
					String temp = ((Element) nl.item(i)).getElementsByTagName("formatted_address").item(0)
							.getTextContent();
				}
			}
		} catch (Exception ex) {
			address = "Err";
		}
		
		return address;
	}
}
