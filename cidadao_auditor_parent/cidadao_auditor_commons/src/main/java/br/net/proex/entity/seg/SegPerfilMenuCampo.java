package br.net.proex.entity.seg;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.net.proex.enumeration.SegVisibilidadeCampo;

@MappedSuperclass
@Audited
public abstract class SegPerfilMenuCampo extends SegBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seg_perfil_menu_campo")
	private Long id;

	@ManyToOne(targetEntity = SegPerfilMenuEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_CAMPO_PERFIL_MENU")
	@NotNull
	private SegPerfilMenuEntity perfilMenu;

	@ManyToOne(targetEntity = SegMenuCampoEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_CAMPO_MENU_CAMPO")
	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="menuCampo",targetField="id")
	private SegMenuCampoEntity menuCampo;

	@Enumerated(EnumType.STRING)
	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="visibilidadeCampo",targetField="menuCampo")
	@Column(length = 3)
	private SegVisibilidadeCampo visibilidadeCampo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SegMenuCampoEntity getMenuCampo() {
		return menuCampo;
	}

	public void setMenuCampo(SegMenuCampoEntity menuCampo) {
		this.menuCampo = menuCampo;
	}

	public SegVisibilidadeCampo getVisibilidadeCampo() {
		return visibilidadeCampo;
	}

	public void setVisibilidadeCampo(SegVisibilidadeCampo visibilidadeCampo) {
		this.visibilidadeCampo = visibilidadeCampo;
	}

	public SegPerfilMenuEntity getPerfilMenu() {
		return perfilMenu;
	}

	public void setPerfilMenu(SegPerfilMenuEntity perfilMenu) {
		this.perfilMenu = perfilMenu;
	}

}
