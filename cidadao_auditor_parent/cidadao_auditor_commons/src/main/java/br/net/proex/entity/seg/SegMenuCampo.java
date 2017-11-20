package br.net.proex.entity.seg;

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

import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

@MappedSuperclass
@Audited
public abstract class SegMenuCampo extends SegBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_menu_campo")
	private Long id;

	@ManyToOne(targetEntity = SegMenuEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEG_MENU_CAMPO_SEG_MENU")
	@NotNull
	private SegMenuEntity menu;

	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="idCmapo",targetField="nome")
	@Size(max = 60, min=2)
	private String idCampo;

	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="nome",targetField="id")
	@Size(max = 60, min=3)
	private String nome;

	@NotNull(groups = PlcValGroupEntityList.class)
	@Size(max = 60)
	private String parametro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public SegMenuEntity getMenu() {
		return menu;
	}

	public void setMenu(SegMenuEntity menu) {
		this.menu = menu;
	}

}
