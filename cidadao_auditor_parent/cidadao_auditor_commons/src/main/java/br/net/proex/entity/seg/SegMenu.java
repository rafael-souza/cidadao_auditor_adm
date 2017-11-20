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
public abstract class SegMenu extends SegBaseEntity {

	@OneToMany(targetEntity = br.net.proex.entity.seg.SegMenuCampoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menu")
	@ForeignKey(name = "FK_SEG_MENU_CAMPO_SEG_MENU")
	@PlcValDuplicity(property = "nome")
	@PlcValMultiplicity(referenceProperty = "nome", message = "{jcompany.aplicacao.mestredetalhe.multiplicidade.SegMenuCampoEntity}")
	@Valid
	private List<SegMenuCampoEntity> menuCampo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_menu")
	private Long id;

	@NotNull
	@Size(max = 60, min=3)
	private String url;

	@NotNull
	@Size(max = 60, min=3)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SegMenuCampoEntity> getMenuCampo() {
		return menuCampo;
	}

	public void setMenuCampo(List<SegMenuCampoEntity> menuCampo) {
		this.menuCampo = menuCampo;
	}

}
