package br.net.proex.entity.seg;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "seg_perfil")
@SequenceGenerator(name = "se_seg_perfil", sequenceName = "se_seg_perfil")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="SegPerfilEntity.naoDeveExistir", query="select count(*) " +
            "from SegPerfilEntity obj " +
            "where obj.nome = :nome "),		
	@NamedQuery(name="SegPerfilEntity.queryMan", query="from SegPerfilEntity"),
	@NamedQuery(name="SegPerfilEntity.querySel", query="select id as id, nome as nome, descricao as descricao from SegPerfilEntity order by nome asc"), @NamedQuery(name = "SegPerfilEntity.querySelLookup", 
	query = "select id as id, nome as nome from SegPerfilEntity where id = ? order by id asc") })
public class SegPerfilEntity extends SegPerfil {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegPerfilEntity() {
	}

	@Override
	public String toString() {
		return getNome();
	}

}
