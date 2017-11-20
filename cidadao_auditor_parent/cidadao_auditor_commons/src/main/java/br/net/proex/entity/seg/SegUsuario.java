package br.net.proex.entity.seg;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;

import br.net.proex.entity.PessoaEntity;

/**
 *  @ Project : Padrão
 *  @ File Name : Usuario.java
 *  @ Date :  31/03/2017
 *  @ Author : Rafael Souza  
 **/
@MappedSuperclass
@Audited
public abstract class SegUsuario extends SegBaseEntity {

	@OneToMany(targetEntity = br.net.proex.entity.seg.SegUsuarioPerfilEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	@ForeignKey(name = "FK_SEGUSUARIOPERFIL_SEGUSUARIO")
	@PlcValDuplicity(property = "perfil")
	@PlcValMultiplicity(referenceProperty = "perfil", message = "{jcompany.aplicacao.mestredetalhe.multiplicidade.SegUsuarioPerfilEntity}")
	@Valid
	private List<SegUsuarioPerfilEntity> usuarioPerfil;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_usuario")
	private Long id;

	@NotNull
	@Size(max = 50, min=3)
	private String loginUsuario;

	@NotNull
	@Size(max = 50, min=6)
	private String senhaUsuario;

	private Boolean bloqueado;
	
	private Boolean visualizaTodasOcorrencias;
	
	@ManyToOne (targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_USUARIO_PESSOA")
	@NotNull	
	private PessoaEntity pessoa;
	
	@NotNull
	@Size(max = 7)
	private String perfil = "Membros";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public List<SegUsuarioPerfilEntity> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(List<SegUsuarioPerfilEntity> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Boolean getVisualizaTodasOcorrencias() {
		return visualizaTodasOcorrencias;
	}

	public void setVisualizaTodasOcorrencias(Boolean visualizaTodasOcorrencias) {
		this.visualizaTodasOcorrencias = visualizaTodasOcorrencias;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}
}
