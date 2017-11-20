package br.net.proex.entity.seg;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.commons.annotation.PlcDbFactory;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="seg_menu")
@SequenceGenerator(name="se_seg_menu", sequenceName="se_seg_menu")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="SegMenuEntity.naoDeveExistir", query="select count(*) " +
            "from SegMenuEntity obj " +
            "where obj.nome = :nome  "),		
	@NamedQuery(name="SegMenuEntity.queryMan", query="from SegMenuEntity"),
	@NamedQuery(name="SegMenuEntity.querySel", query="select id as id, nome as nome, url as url from SegMenuEntity order by nome asc"),
	@NamedQuery(name="SegMenuEntity.querySelLookup", 
			query="select id as id, nome as nome, url as url from SegMenuEntity where id = ? order by id asc")
})
public class SegMenuEntity extends SegMenu {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public SegMenuEntity() {
    }
    
	@Override
	public String toString() {
		return getNome();
	}

}
