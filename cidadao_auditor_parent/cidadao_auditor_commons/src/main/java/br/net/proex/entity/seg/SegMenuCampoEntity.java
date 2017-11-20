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
@Table(name = "seg_menu_campo")
@SequenceGenerator(name = "se_seg_menu_campo", sequenceName = "se_seg_menu_campo")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="SegMenuCampoEntity.querySel", 
			query="select id as id, nome as nome, idCampo as idCampo, parametro as parametro from SegMenuCampoEntity order by nome asc"), 
	@NamedQuery(name = "SegMenuCampoEntity.querySelLookup", 
			query = "select id as id, nome as nome from SegMenuCampoEntity where id = ? order by id asc") })
public class SegMenuCampoEntity extends SegMenuCampo {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegMenuCampoEntity() {
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
