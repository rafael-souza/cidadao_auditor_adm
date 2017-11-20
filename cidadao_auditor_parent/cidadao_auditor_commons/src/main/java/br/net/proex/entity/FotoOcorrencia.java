/*  																													
	    				   jCompany Developer Suite																		
			    		Copyright (C) 2008  Powerlogic																	
	 																													
	    Este programa � licenciado com todos os seus c�digos fontes. Voc� pode modific�-los e							
	    utiliz�-los livremente, inclusive distribu�-los para terceiros quando fizerem parte de algum aplicativo 		
	    sendo cedido, segundo os termos de licenciamento gerenciado de c�digo aberto da Powerlogic, definidos			
	    na licen�a 'Powerlogic Open-Source Licence 2.0 (POSL 2.0)'.    													
	  																													
	    A Powerlogic garante o acerto de erros eventualmente encontrados neste c�digo, para os clientes licenciados, 	
	    desde que todos os c�digos do programa sejam mantidos intactos, sem modifica��es por parte do licenciado. 		
	 																													
	    Voc� deve ter recebido uma c�pia da licen�a POSL 2.0 juntamente com este programa.								
	    Se n�o recebeu, veja em <http://www.powerlogic.com.br/licencas/posl20/>.										
	 																													
	    Contatos: plc@powerlogic.com.br - www.powerlogic.com.br 														
																														
 */
/*  																													
 Jaguar-jCompany Developer Suite.																		
 Powerlogic 2010-2014.

 Please read licensing information in your installation directory.Contact Powerlogic for more 
 information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br																								
 */
package br.net.proex.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.powerlogic.jcompany.commons.PlcFileContent;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import com.powerlogic.jcompany.commons.file.PlcBaseMapFile;

/**
 * Arquivo de Fotos da prefeitura
 */
@SPlcEntity
@Entity
@Audited
@Table(name = "foto_ocorrencia")
@SequenceGenerator(name = "SE_ARQUIVO_PLC", sequenceName = "SE_ARQUIVO_PLC")
public class FotoOcorrencia extends PlcBaseMapFile {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1651299733382108534L;	
	@NotAudited
	@OneToOne(targetEntity = FotoConteudoOcorrencia.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public PlcFileContent getBinaryContent() {
		return (conteudo);
	}

	
	
}
