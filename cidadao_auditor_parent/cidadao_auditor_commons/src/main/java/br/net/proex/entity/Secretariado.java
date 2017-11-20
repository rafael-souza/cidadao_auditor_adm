package br.net.proex.entity;

import br.net.proex.enumeration.TipoSecretario;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;

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
		
	@Enumerated(EnumType.STRING)
	@NotNull
	@PlcValRequiredIf(dependentfield="tipo",targetField="pessoa")
	@Column(length=3)
	private TipoSecretario tipo;
		
	@ManyToOne (targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_SECRETARIADO_PESSOA")
	@NotNull
	private PessoaEntity pessoa;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public TipoSecretario getTipo() {
		return tipo;
	}

	public void setTipo(TipoSecretario tipo) {
		this.tipo=tipo;
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

}
