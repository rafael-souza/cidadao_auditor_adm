package br.net.proex.entity;



import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import com.powerlogic.jcompany.config.domain.PlcReference;
import javax.persistence.Id;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class Secretaria extends AppBaseEntity {

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "secretaria")
	private Long id;


	@NotNull(message="O campo nome é de preenchimento obrigatório")
	@Size(max = 100)
	@PlcReference(testDuplicity=true)
	private String nome;
	
	@Size(max = 100)
	private String email;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
