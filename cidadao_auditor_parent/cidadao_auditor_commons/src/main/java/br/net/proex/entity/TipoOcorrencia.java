package br.net.proex.entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

@Audited
@MappedSuperclass
public abstract class TipoOcorrencia extends AppBaseEntity {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_tipo_ocorrencia")
	private Long id;
	
	@NotNull(message="O campo Descrição é de preenchimento obrigatório")
	@Size(max = 60)
	private String descricao;
	
	@ManyToOne(targetEntity = SecretariaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_TIPO_OCORRENCIA_SECRETARIA")
	@NotNull(message="O campo Secretaria é de preenchimento obrigatório")
	private SecretariaEntity secretaria;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao=descricao;
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
