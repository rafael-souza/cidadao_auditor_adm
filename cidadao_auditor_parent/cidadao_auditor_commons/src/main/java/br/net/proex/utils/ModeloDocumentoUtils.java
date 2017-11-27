package br.net.proex.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.net.proex.commons.AppConstants;
import br.net.proex.entity.DenunciaEntity;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.entity.SecretariadoEntity;
import br.net.proex.entity.SugestaoEntity;

public final class ModeloDocumentoUtils {
	
	/**
	 * 
	 * @param responsavel
	 * @param ocorrencia
	 * @return
	 */
	public static String alimentaDadosDocumento(OcorrenciaEntity ocorrencia, String documento) {
		// substituindo os tokens
		if (null != ocorrencia.getPessoa().getNome()){
			documento = documento.replaceAll(AppConstants.NOME_CIDADAO, ocorrencia.getPessoa().getNome());
		} else {
			documento = documento.replaceAll(AppConstants.NOME_CIDADAO, "");
		}
		
		if (null != ocorrencia.getId()){
			documento = documento.replaceAll(AppConstants.COD_OCORRENCIA, ocorrencia.getId().toString());
		} else {
			documento = documento.replaceAll(AppConstants.COD_OCORRENCIA, "");
		}
		
		if (null !=  ocorrencia.getTipoOcorrencia().getDescricao()){
			documento = documento.replaceAll(AppConstants.TIPO_OCORRENCIA, ocorrencia.getTipoOcorrencia().getDescricao());
		} else {
			documento = documento.replaceAll(AppConstants.TIPO_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getDataFormatada()){
			documento = documento.replaceAll(AppConstants.DATA_OCORRENCIA, ocorrencia.getDataFormatada());
		} else {
			documento = documento.replaceAll(AppConstants.DATA_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getEndereco()){
			documento = documento.replaceAll(AppConstants.ENDERECO_OCORRENCIA, ocorrencia.getEndereco());
		} else {
			documento = documento.replaceAll(AppConstants.ENDERECO_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getProtocolo()){
			documento = documento.replaceAll(AppConstants.PROTOCOLO_OCORRENCIA, ocorrencia.getProtocolo());
		} else {
			documento = documento.replaceAll(AppConstants.PROTOCOLO_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getDescricaoStatus()){
			documento = documento.replaceAll(AppConstants.STATUS_OCORRENCIA, ocorrencia.getDescricaoStatus());
		} else {
			documento = documento.replaceAll(AppConstants.STATUS_OCORRENCIA, "");
		}
		
		if (null != ocorrencia.getObservacao()){
			documento = documento.replaceAll(AppConstants.OBSERVACAO_CIDADAO, ocorrencia.getObservacao());
		} else {
			documento = documento.replaceAll(AppConstants.OBSERVACAO_CIDADAO, "");
		}
		
		if (null != ocorrencia.getObservacaoHistorico()){
			documento = documento.replaceAll(AppConstants.OBSERVACAO_RESPONSAVEL, ocorrencia.getObservacaoHistorico());
		} else {
			documento = documento.replaceAll(AppConstants.OBSERVACAO_RESPONSAVEL, "");
		}
		
		if (null != ocorrencia.getDataConclusao()){
			documento = documento.replaceAll(AppConstants.DATA_CONCLUSAO, ocorrencia.getDataConclusaoFormatada());
		} else {
			documento = documento.replaceAll(AppConstants.DATA_CONCLUSAO, "");
		}
		
		if (null != ocorrencia.getResponsavelConclusao()){
			documento = documento.replaceAll(AppConstants.RESPONSAVEL_CONCLUSAO, ocorrencia.getResponsavelConclusao());
		} else {
			documento = documento.replaceAll(AppConstants.RESPONSAVEL_CONCLUSAO, "");
		}
				
		// verificando se é a foto da ocorrencia
		if (null != ocorrencia.getFotoOcorrencia()){
			documento = documento.replaceAll(AppConstants.FOTO_OCORRENCIA, insereValorImagem(ocorrencia));
		} else {
			documento = documento.replaceAll(AppConstants.FOTO_OCORRENCIA, "");
		}
										
		return documento;
	}


	/**
	 * 
	 * @param ocorrencia
	 * @return
	 */
	private static String insereValorImagem(OcorrenciaEntity ocorrencia) {
		try {	
			String nomeImagem = "";
						
			// nome da imagem com a pasta temporaria 
			nomeImagem = AppConstants.PASTA_ARQUIVOS_TEMPORARIOS + 
					ocorrencia.getFotoOcorrencia().getNome() + "." + 
					ocorrencia.getFotoOcorrencia().getType().substring(6); 
												
		    File file = new File(getEnderecoFisicoAplicacao() + nomeImagem);  
		    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		    bos.write(ocorrencia.getFotoOcorrencia().getBinaryContent().getBinaryContent());  
		    bos.close();
					    	
		    return "<img src=\"" + getEnderecoLogicoAplicacao() 
		    	+ nomeImagem + "\" style=\"height:200px; width:200px\" />";
		    						
		} catch (Exception e) {
			return null;
		}  		
	}	
	
	

	
	/**
	 * 
	 * @param textoDocumento
	 * @param prefeitura
	 * @return
	 */
	public static String alimentaBrasaoPrfeitura(String textoDocumento, PrefeituraEntity prefeitura) {
		try {							
			String nomeImagem = "";
						
			// nome da imagem com a pasta temporaria 
			nomeImagem = AppConstants.PASTA_ARQUIVOS_TEMPORARIOS + 
					prefeitura.getBrasao().getNome() + "." + 
					prefeitura.getBrasao().getType().substring(6); 
												
		    File file = new File(getEnderecoFisicoAplicacao() + nomeImagem);  
		    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		    bos.write(prefeitura.getBrasao().getBinaryContent().getBinaryContent());  
		    bos.close();
					    	
		    return "<img src=\"" + getEnderecoLogicoAplicacao() 
		    	+ nomeImagem + "\" style=\"height:70px; width:70px\" />";
		    						
		} catch (Exception e) {
			return null;
		} 
	}
	
	
	
	/**
	 * Retorno ao endereço fisico da aplicação para geração de arquivos 
	 * @return
	 */
	public static String getEnderecoFisicoAplicacao(){
		// criando o endereco fisico para armazenar a imagem
		String aplicacao = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();		
		return System.getProperty("catalina.home") + "/" +"webapps" + aplicacao;
		
	}
	
	
	/**
	 * Retorna o endereço logico da aplicação para referenciar arquivos
	 * @return
	 */
	public static String getEnderecoLogicoAplicacao(){
		 // criando o endereço logico para referenciar a imagem
		String aplicacao = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();		
		StringBuffer enderecoLogico = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURL();				
		return enderecoLogico.substring(0, enderecoLogico.indexOf(aplicacao)) + aplicacao;		
	}


	/**
	 * 
	 * @param sugestao
	 * @param documento
	 * @return
	 */
	public static String alimentaDadosDocumento(SugestaoEntity sugestao, String documento) {
		if (null != sugestao.getProtocolo()){
			documento = documento.replace(AppConstants.PROTOCOLO_SUGESTAO, sugestao.getProtocolo());
		}
		
		if (null != sugestao.getPessoa() && null != sugestao.getPessoa().getNome()){
			documento = documento.replace(AppConstants.NOME_CIDADAO, sugestao.getPessoa().getNome());
		}
		return documento;
	}	
	
	
	/**
	 * 
	 * @param sugestao
	 * @param documento
	 * @return
	 */
	public static String alimentaDadosDocumento(DenunciaEntity denuncia, String documento) {
		if (null != denuncia.getProtocolo()){
			documento = documento.replace(AppConstants.PROTOCOLO_DENUNCIA, denuncia.getProtocolo());
		}
		
		if (null != denuncia.getPessoa() && null != denuncia.getPessoa().getNome()){
			documento = documento.replace(AppConstants.NOME_CIDADAO, denuncia.getPessoa().getNome());
		}
		return documento;
	}

	/**
	 * 
	 * @param pessoa
	 * @param findModeloDocumentoPorTipo
	 * @return
	 */
	public static String alimentaDadosDocumento(PessoaEntity pessoa, String documento) {
		if (null != pessoa.getNome()){
			documento = documento.replace(AppConstants.NOME_CIDADAO, pessoa.getNome());
		}
		return documento;
	}	


	

}
