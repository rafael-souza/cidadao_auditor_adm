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
@Table(name="secretariado")
@SequenceGenerator(name="se_secretariado", sequenceName="se_secretariado")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="SecretariadoEntity.querySelLookup", query="select id as id, pessoa as pessoa from SecretariadoEntity where id = ? order by id asc")
})
public class SecretariadoEntity extends Secretariado {

	private transient String pessoaAuxLookup;


	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public SecretariadoEntity() {
    }
	@Override
	public String toString() {
		return getPessoa().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secretariado other = (Secretariado) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}


	public void setPessoaAuxLookup(String pessoaAuxLookup) {
		this.pessoaAuxLookup=pessoaAuxLookup;
	}

}
