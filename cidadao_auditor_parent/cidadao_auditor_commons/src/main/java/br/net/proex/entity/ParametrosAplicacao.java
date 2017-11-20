package br.net.proex.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@MappedSuperclass
public abstract class ParametrosAplicacao extends AppBaseEntity {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_parametros_aplicacao")
	private Long id;

	/** atributos que são para o envio de e-mail */
	@Size(max = 100)
	private String hostSmtp;
	
	@Size(max = 100)
	private String portaSmtp;
	
	@Size(max = 200)
	private String email;
	
	@Size(max = 100)
	private String senhaEmail;
	
	@Lob	
	@Column(length = 2147483647)
	private String modeloMensagemCidadao;
	
	@Lob	
	@Column(length = 2147483647)
	private String modeloMensagemResponsavel;
	
	@Lob	
	@Column(length = 2147483647)
	private String modeloDocumentoOcorrencia;
	
	@Lob	
	@Column(length = 2147483647)
	private String cabecalhoDocumentoOcorrencia;		
	
	@Lob	
	@Column(length = 2147483647)
	private String rodapeDocumentoOcorrencia;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getHostSmtp() {
		return hostSmtp;
	}

	public void setHostSmtp(String hostSmtp) {
		this.hostSmtp=hostSmtp;
	}

	public String getPortaSmtp() {
		return portaSmtp;
	}

	public void setPortaSmtp(String portaSmtp) {
		this.portaSmtp=portaSmtp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getSenhaEmail() {
		return senhaEmail;
	}

	public void setSenhaEmail(String senhaEmail) {
		this.senhaEmail=senhaEmail;
	}

	/**
	 * @return the modeloMensagemCidadao
	 */
	public String getModeloMensagemCidadao() {
		return modeloMensagemCidadao;
	}

	/**
	 * @param modeloMensagemCidadao the modeloMensagemCidadao to set
	 */
	public void setModeloMensagemCidadao(String modeloMensagemCidadao) {
		this.modeloMensagemCidadao = modeloMensagemCidadao;
	}

	/**
	 * @return the modeloMensagemResponsavel
	 */
	public String getModeloMensagemResponsavel() {
		return modeloMensagemResponsavel;
	}

	/**
	 * @param modeloMensagemResponsavel the modeloMensagemResponsavel to set
	 */
	public void setModeloMensagemResponsavel(String modeloMensagemResponsavel) {
		this.modeloMensagemResponsavel = modeloMensagemResponsavel;
	}

	/**
	 * @return the modeloDocumentoOcorrencia
	 */
	public String getModeloDocumentoOcorrencia() {
		return modeloDocumentoOcorrencia;
	}

	/**
	 * @param modeloDocumentoOcorrencia the modeloDocumentoOcorrencia to set
	 */
	public void setModeloDocumentoOcorrencia(String modeloDocumentoOcorrencia) {
		this.modeloDocumentoOcorrencia = modeloDocumentoOcorrencia;
	}

	/**
	 * @return the cabecalhoDocumentoOcorrencia
	 */
	public String getCabecalhoDocumentoOcorrencia() {
		return cabecalhoDocumentoOcorrencia;
	}

	/**
	 * @param cabecalhoDocumentoOcorrencia the cabecalhoDocumentoOcorrencia to set
	 */
	public void setCabecalhoDocumentoOcorrencia(String cabecalhoDocumentoOcorrencia) {
		this.cabecalhoDocumentoOcorrencia = cabecalhoDocumentoOcorrencia;
	}

	/**
	 * @return the rodapeDocumentoOcorrencia
	 */
	public String getRodapeDocumentoOcorrencia() {
		return rodapeDocumentoOcorrencia;
	}

	/**
	 * @param rodapeDocumentoOcorrencia the rodapeDocumentoOcorrencia to set
	 */
	public void setRodapeDocumentoOcorrencia(String rodapeDocumentoOcorrencia) {
		this.rodapeDocumentoOcorrencia = rodapeDocumentoOcorrencia;
	}

}
