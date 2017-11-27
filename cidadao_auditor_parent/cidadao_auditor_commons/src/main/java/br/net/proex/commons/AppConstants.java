/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.net.proex.commons;

import com.powerlogic.jcompany.commons.PlcConstants;

/**
 * Implementar aqui constantes específicas da Aplicação
 * 
 */
public interface AppConstants extends PlcConstants {
    
    String NOME_CONSTANTE = "valorConstante";	
    
    String AUD_CASO_DE_USO = "casoDeUso";
    
    String AUD_ACAO_REALIZADA = "acaoRealizada";    
    
    String formatoUSA = "yyyy-MM-dd";
    
	/** atributo que armazena a lista de id´s na seção para navegação */
	String SESSION_LIST_ID = "listaId";
	
	/** atributo para pegar o id por reflexão */
	String ID = "id";
	
	/**  pasta para armazenar arquivos temporarios */
	String PASTA_ARQUIVOS_TEMPORARIOS = "/temp/";
	
	/** tokens para o envio de e-mails */
	String NOME_CIDADAO = "#NOME_CIDADAO#";
	
	String COD_OCORRENCIA = "#COD_OCORRENCIA#";
	
	String TIPO_OCORRENCIA = "#TIPO_OCORRENCIA#";
	
	String DATA_OCORRENCIA = "#DATA_OCORRENCIA#";
	
	String ENDERECO_OCORRENCIA = "#ENDERECO_OCORRENCIA#";
	
	String PROTOCOLO_OCORRENCIA = "#PROTOCOLO_OCORRENCIA#";
	
	String STATUS_OCORRENCIA = "#STATUS_OCORRENCIA#";
	
	String OBSERVACAO_CIDADAO = "#OBSERVACAO_CIDADAO#";
	
	String DATA_CONCLUSAO = "#DATA_CONCLUSAO#";	
	
	String RESPONSAVEL_CONCLUSAO = "#RESPONSAVEL_CONCLUSAO#";
	
	String OBSERVACAO_RESPONSAVEL = "#OBSERVACAO_RESPONSAVEL#";
	
	String FOTO_OCORRENCIA = "#FOTO_OCORRENCIA#";
	
	String BRASAO_PREFEITURA = "#BRASAO_PREFEITURA#";
	
	String PROTOCOLO_SUGESTAO = "#PROTOCOLO_SUGESTAO#";
	
	String PROTOCOLO_DENUNCIA = "#PROTOCOLO_DENUNCIA#";
	
	String NOVA_SENHA = "#NOVA_SENHA#";
		
    	
}
