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
@Table(name = "seg_perfil_menu")
@SequenceGenerator(name = "se_seg_perfil_menu", sequenceName = "se_seg_perfil_menu")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
		@NamedQuery(name = "SegPerfilMenuEntity.queryMan", query = "from SegPerfilMenuEntity"),
		@NamedQuery(name = "SegPerfilMenuEntity.querySel", 
			query = "select " +
					"obj.id as id, " +
					"obj.dataInicial as dataInicial, " +
					"obj.dataFinal as dataFinal, " +
					"obj.tipoAcesso as tipoAcesso, " +					
					"obj1.id as perfil_id , " +
					"obj1.nome as perfil_nome, " +
					"obj1.descricao as perfil_descricao, " +					
					"obj2.id as menu_id , " +
					"obj2.nome as menu_nome, " +
					"obj2.url as menu_url " +					
					"from " +
					"SegPerfilMenuEntity obj " +
					"left outer join obj.perfil as obj1 " +
					"left outer join obj.menu as obj2 " +
					"order by obj.id asc"),
		@NamedQuery(name = "SegPerfilMenuEntity.querySelLookup", query = "select id as id from SegPerfilMenuEntity where id = ? order by id asc")
})
public class SegPerfilMenuEntity extends SegPerfilMenu {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public SegPerfilMenuEntity() {
	}

	@Override
	public String toString() {
		return getMenu().toString();
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
