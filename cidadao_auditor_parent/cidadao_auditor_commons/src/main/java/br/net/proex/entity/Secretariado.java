package br.net.proex.entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

@Audited
@MappedSuperclass
public abstract class Secretariado extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_secretariado")
	private Long id;
	
	@ManyToOne (targetEntity = PrefeituraEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_SECRETARIADO_PREFEITURA")
	@NotNull
	private Prefeitura prefeitura;
		
	@PlcValRequiredIf(dependentfield="tipo",targetField="pessoa")
	@ManyToOne(targetEntity = SecretariaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_TIPO_OCORRENCIA_SECRETARIA")
	@NotNull(message="O campo Secretaria é de preenchimento obrigatório")
	private SecretariaEntity secretaria;
	
	@ManyToOne (targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_SECRETARIADO_PESSOA")
	@NotNull(message="O campo Pessoa é de preenchimento obrigatório")
	private PessoaEntity pessoa;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa=pessoa;
	}

	public Prefeitura getPrefeitura() {
		return prefeitura;
	}

	public void setPrefeitura(Prefeitura prefeitura) {
		this.prefeitura=prefeitura;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

	/**
	 * @return the secretaria
	 */
	public SecretariaEntity getSecretaria() {
		return secretaria;
	}

	/**
	 * @param secretaria the secretaria to set
	 */
	public void setSecretaria(SecretariaEntity secretaria) {
		this.secretaria = secretaria;
	}

}
