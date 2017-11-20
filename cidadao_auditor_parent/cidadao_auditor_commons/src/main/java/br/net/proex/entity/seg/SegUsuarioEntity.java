package br.net.proex.entity.seg;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "seg_usuario")
@SequenceGenerator(name = "se_seg_usuario", sequenceName = "se_seg_usuario")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="SegUsuarioEntity.naoDeveExistir", query="select count(*) " +
            "from SegUsuarioEntity obj " +
            "where obj.loginUsuario = :loginUsuario "),		
		@NamedQuery(name = "SegUsuarioEntity.queryMan", query = "from SegUsuarioEntity"),
		@NamedQuery(name = "SegUsuarioEntity.querySel", query = "select obj.id as id, obj.loginUsuario as loginUsuario, obj.senhaUsuario as senhaUsuario from SegUsuarioEntity obj order by obj.loginUsuario asc"),
		@NamedQuery(name = "SegUsuarioEntity.querySelLookup", query = "select obj.id as id, obj.loginUsuario as loginUsuario, obj.senhaUsuario as senhaUsuario from SegUsuarioEntity obj where obj.id = ? order by obj.id asc"),							
		@NamedQuery(name = "SegUsuarioEntity.findByLogin", 
			query="select " +
					"obj.id as id, " +					
					"obj.loginUsuario as loginUsuario, " +
					"obj.senhaUsuario as senhaUsuario, " +
					"obj.bloqueado as bloqueado, " +
					"obj.perfil as perfil, " +
					"obj.versao as versao, " +
					"obj2.id as pessoa_id, " +
					"obj2.nome as pessoa_nome " +
					"from " +
					"SegUsuarioEntity obj " +
					" left outer join obj.pessoa obj2 " +				
					"where " +
					"obj.loginUsuario = :loginUsuario")				
})

public class SegUsuarioEntity extends SegUsuario {
	
	@Transient
	@Size(max = 50, min=6)
	private String senhaAtual;
	
	@Transient
	@Size(max = 50, min=6)
	private String senhaNova;
	
	@Transient
	@Size(max = 50, min=6)
	private String senhaNovaRepete;
	
	@Transient
	private Boolean trocouSenha;		

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegUsuarioEntity() {
	}

	@Override
	public String toString() {
		return getLoginUsuario();
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

	public String getSenhaNovaRepete() {
		return senhaNovaRepete;
	}

	public void setSenhaNovaRepete(String senhaNovaRepete) {
		this.senhaNovaRepete = senhaNovaRepete;
	}

	public Boolean getTrocouSenha() {
		return trocouSenha;
	}

	public void setTrocouSenha(Boolean trocouSenha) {
		this.trocouSenha = trocouSenha;
	}

}
