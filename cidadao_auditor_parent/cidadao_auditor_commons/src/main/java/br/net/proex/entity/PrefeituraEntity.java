package br.net.proex.entity;


import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import javax.persistence.SequenceGenerator;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Access;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="prefeitura")
@SequenceGenerator(name="se_prefeitura", sequenceName="se_prefeitura")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="PrefeituraEntity.queryMan", query="from PrefeituraEntity"),
	@NamedQuery(name="PrefeituraEntity.querySel", query="select obj from PrefeituraEntity obj order by obj.id asc"),
	@NamedQuery(name="PrefeituraEntity.querySelLookup", query="select id as id, nome as nome from PrefeituraEntity where id = ? order by id asc")
})
public class PrefeituraEntity extends Prefeitura {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public PrefeituraEntity() {
    }
	@Override
	public String toString() {
		return getNome();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prefeitura other = (Prefeitura) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
