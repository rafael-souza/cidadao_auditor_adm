package br.net.proex.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
}
