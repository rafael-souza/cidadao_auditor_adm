package br.net.proex.entity;

import br.net.proex.enumeration.TipoSecretario;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.config.domain.PlcFileAttach;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Audited
@MappedSuperclass
public abstract class TipoOcorrencia extends AppBaseEntity {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_tipo_ocorrencia")
	private Long id;
	
	@NotNull
	@Size(max = 60)
	private String descricao;
		
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length=3)
	private TipoSecretario secretariaResponsavel;
	
	@OneToOne(targetEntity = FotoPrefeitura.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@ForeignKey(name = "FK_ICONE_TIPO_OCORRENCIA")
	@PlcFileAttach(extension = { "gif", "jpg", "png", "bmp" }, image = true, showImageHeight = 100, showImageWidth = 100)
	private FotoPrefeitura icone;	 	
	
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

	public TipoSecretario getSecretariaResponsavel() {
		return secretariaResponsavel;
	}

	public void setSecretariaResponsavel(TipoSecretario secretariaResponsavel) {
		this.secretariaResponsavel=secretariaResponsavel;
	}

	/**
	 * @return the icone
	 */
	public FotoPrefeitura getIcone() {
		return icone;
	}

	/**
	 * @param icone the icone to set
	 */
	public void setIcone(FotoPrefeitura icone) {
		this.icone = icone;
	}

}
