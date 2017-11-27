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
@Table(name="secretaria")
@SequenceGenerator(name="secretaria", sequenceName="secretaria")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="SecretariaEntity.queryMan", query="from SecretariaEntity"),
	@NamedQuery(name="SecretariaEntity.querySelLookup", query="select id as id, nome as nome from SecretariaEntity where id = ? order by id asc")
})
public class SecretariaEntity extends Secretaria {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public SecretariaEntity() {
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
		Secretaria other = (Secretaria) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
