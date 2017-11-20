package br.net.proex.entity.seg;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "seg_usuario_perfil")
@SequenceGenerator(name = "se_seg_usuario_perfil", sequenceName = "se_seg_usuario_perfil")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({ 
		@NamedQuery(name = "SegUsuarioPerfilEntity.querySelLookup", 
				query = "select id as id, perfil as perfil from SegUsuarioPerfilEntity where id = ? order by id asc"), 		
		@NamedQuery(name = "SegUsuarioPerfilEntity.querySelLoad", 
		query = "select " +
				"obj.id as id, " +					
				"obj.dataInicial as dataInicial, " +
				"obj.dataFinal as dataFinal, " +													
				"obj1.id as usuario_id, " +
				"obj1.loginUsuario as usuario_loginUsuario, " +
				"obj2.id as perfil_id, " +
				"obj2.nome as perfil_nome " +			
				"from SegUsuarioPerfilEntity obj " +													
				"left outer join obj.usuario as obj1 " +
				"left outer join obj.perfil as obj2 " +
				"order by obj.id asc ")})
public class SegUsuarioPerfilEntity extends SegUsuarioPerfil {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegUsuarioPerfilEntity() {
	}

	@Override
	public String toString() {
		return getPerfil().toString();
	}

	@Transient
	private String indExcPlc = "N";

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
