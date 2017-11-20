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
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.net.proex.enumeration.SegAcao;

@MappedSuperclass
@Audited
public abstract class SegPerfilMenuAcaoNegado extends SegBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_perfil_menu_acao_negado")
	private Long id;

	@ManyToOne(targetEntity = SegPerfilMenuEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEG_PERFIL_MENU_ACAO_NEGADO_PERFIL_MENU")
	@NotNull
	private SegPerfilMenuEntity perfilMenu;

	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="nome",targetField="id")
	@Size(max = 60, min=3)
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="acao",targetField="nome")
	@Column(length = 3)
	private SegAcao acao;

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

	public SegAcao getAcao() {
		return acao;
	}

	public void setAcao(SegAcao acao) {
		this.acao = acao;
	}

	public SegPerfilMenuEntity getPerfilMenu() {
		return perfilMenu;
	}

	public void setPerfilMenu(SegPerfilMenuEntity perfilMenu) {
		this.perfilMenu = perfilMenu;
	}

}
