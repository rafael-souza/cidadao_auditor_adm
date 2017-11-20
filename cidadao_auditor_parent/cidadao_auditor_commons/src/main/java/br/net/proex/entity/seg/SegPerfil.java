package br.net.proex.entity.seg;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;

@MappedSuperclass
@Audited
public abstract class SegPerfil extends SegBaseEntity {

	@OneToMany(targetEntity = br.net.proex.entity.seg.SegPerfilMenuEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "perfil")
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_SEG_PERFIL")
	@PlcValDuplicity(property = "menu")
	@PlcValMultiplicity(referenceProperty = "menu", message = "{jcompany.aplicacao.mestredetalhe.multiplicidade.SegPerfilMenuEntity}")
	@Valid
	private List<SegPerfilMenuEntity> perfilMenu;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_perfil")
	private Long id;

	@NotNull
	@Size(max = 60, min=3)
	private String nome;

	@NotNull
	@Size(max = 60, min=3)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<SegPerfilMenuEntity> getPerfilMenu() {
		return perfilMenu;
	}

	public void setPerfilMenu(List<SegPerfilMenuEntity> perfilMenu) {
		this.perfilMenu = perfilMenu;
	}

}
