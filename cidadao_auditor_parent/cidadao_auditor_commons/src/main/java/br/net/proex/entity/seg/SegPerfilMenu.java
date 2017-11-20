package br.net.proex.entity.seg;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.net.proex.enumeration.SegTipoAcesso;

@MappedSuperclass
@Audited
public abstract class SegPerfilMenu extends SegBaseEntity {

	@OneToMany(targetEntity = br.net.proex.entity.seg.SegPerfilMenuAcaoNegadoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "perfilMenu")
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_ACAO_NEGADO_PERFIL_MENU")
	@PlcValDuplicity(property = "nome")
	@PlcValMultiplicity(referenceProperty = "nome", message = "{jcompany.aplicacao.mestredetalhe.multiplicidade.SegPerfilMenuAcaoNegadoEntity}")
	@Valid
	private List<SegPerfilMenuAcaoNegadoEntity> perfilMenuAcaoNegado;

	@OneToMany(targetEntity = br.net.proex.entity.seg.SegPerfilMenuCampoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "perfilMenu")
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_CAMPO_PERFIL_MENU")
	@PlcValDuplicity(property = "menuCampo")
	@PlcValMultiplicity(referenceProperty = "menuCampo", message = "{jcompany.aplicacao.mestredetalhe.multiplicidade.SegPerfilMenuCampoEntity}")
	@Valid
	private List<SegPerfilMenuCampoEntity> perfilMenuCampo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_perfil_menu")
	private Long id;

	@ManyToOne(targetEntity = SegPerfilEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_SEG_PERFIL")
	@NotNull
	private SegPerfilEntity perfil;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicial;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;

	@ManyToOne(targetEntity = SegMenuEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_MENU")
	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="menu",targetField="id")
	private SegMenuEntity menu;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(length = 3)	
	private SegTipoAcesso tipoAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public SegMenuEntity getMenu() {
		return menu;
	}

	public void setMenu(SegMenuEntity menu) {
		this.menu = menu;
	}

	public SegPerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(SegPerfilEntity perfil) {
		this.perfil = perfil;
	}

	public List<SegPerfilMenuCampoEntity> getPerfilMenuCampo() {
		return perfilMenuCampo;
	}

	public void setPerfilMenuCampo(
			List<SegPerfilMenuCampoEntity> perfilMenuCampo) {
		this.perfilMenuCampo = perfilMenuCampo;
	}

	public List<SegPerfilMenuAcaoNegadoEntity> getPerfilMenuAcaoNegado() {
		return perfilMenuAcaoNegado;
	}

	public void setPerfilMenuAcaoNegado(
			List<SegPerfilMenuAcaoNegadoEntity> perfilMenuAcaoNegado) {
		this.perfilMenuAcaoNegado = perfilMenuAcaoNegado;
	}
	
	public SegTipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(SegTipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
}
