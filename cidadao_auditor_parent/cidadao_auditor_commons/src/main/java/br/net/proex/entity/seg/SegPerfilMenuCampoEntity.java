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
//@PlcDbFactory(nome = "seg")
@SPlcEntity
@Entity
@Table(name = "seg_perfil_menu_campo")
@SequenceGenerator(name = "seg_perfil_menu_campo", sequenceName = "seg_perfil_menu_campo")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({ @NamedQuery(name = "SegPerfilMenuCampoEntity.querySelLookup", 
	query = "select id as id, menuCampo as menuCampo from SegPerfilMenuCampoEntity where id = ? order by id asc") })
public class SegPerfilMenuCampoEntity extends SegPerfilMenuCampo {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegPerfilMenuCampoEntity() {
	}

	@Override
	public String toString() {
		return getMenuCampo().toString();
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
