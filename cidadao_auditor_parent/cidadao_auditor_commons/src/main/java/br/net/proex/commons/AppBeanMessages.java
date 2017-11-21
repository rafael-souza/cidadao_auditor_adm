/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.net.proex.commons;

import ch.qos.cal10n.BaseName;
import ch.qos.cal10n.Locale;
import ch.qos.cal10n.LocaleData;


/**
* cidadao_auditor. Enum de mensagens personalizadas
*/

@BaseName("ApplicationResources")
@LocaleData( { @Locale("en_US"), @Locale("es_ES"), @Locale("pt_BR") })
public enum AppBeanMessages {
	

	SEG_SENHA_ATUAL_VAZIA,
	SEG_SENHA_NOVA_VAZIA,
	SEG_CONFIRMA_SENHA_NOVA_VAZIA,
	SEG_SENHA_ATUAL_INCORRETA,
	SEG_SENHAS_DIFERENTES,
	SEG_SENHA_ALTERADA_SUCESSO,
	SEG_AUDITORIA_MENU,
	SEG_DATA_INICIAL_DATA_FINAL_OBRIGATORIA,
	SEG_DATA_FINAL_MENOR_DATA_INICIAL,
	SEG_DATA_NAO_DEVE_INFORMAR,
	
	OCORRENCIA_ENCAMINHADA,
	OBSERVACAO_OBRIGATORIO,
	OCORRENCIA_OBRIGATORIO_CONCLUIR,
	OCORRENCIA_CONCLUIDA,	
	EMAIL_ENVIADO_CIDADAO,
	EMAIL_ENVIADO_RESPONSAVEL,
	EMAIL_ERRO_CIDADAO,
	EMAIL_ERRO_RESPONSAVEL,
	
	REL_TIPO_GRAFICO,
	REL_SECRETARIA,
	
	NENHUM_RESULTADO,
	TOKEN_INVALIDO,
	USUARIO_SENHA_INVALIDOS	

}


