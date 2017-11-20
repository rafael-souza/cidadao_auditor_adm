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
@Table(name = "seg_perfil_menu_acao_negado")
@SequenceGenerator(name = "se_seg_perfil_menu_acao_negado", sequenceName = "se_seg_perfil_menu_acao_negado")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({ @NamedQuery(name = "SegPerfilMenuAcaoNegadoEntity.querySelLookup", 
	query = "select id as id, nome as nome from SegPerfilMenuAcaoNegadoEntity where id = ? order by id asc") })
public class SegPerfilMenuAcaoNegadoEntity extends SegPerfilMenuAcaoNegado {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegPerfilMenuAcaoNegadoEntity() {
	}

	@Override
	public String toString() {
		return getNome();
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
