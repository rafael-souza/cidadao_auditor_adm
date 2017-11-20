package br.net.proex.entity;


import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Access;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="parametros_aplicacao")
@SequenceGenerator(name="se_parametros_aplicacao", sequenceName="se_parametros_aplicacao")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="ParametrosAplicacaoEntity.querySelLookup", query="select id as id, hostSmtp as hostSmtp from ParametrosAplicacaoEntity where id = ? order by id asc")
})
public class ParametrosAplicacaoEntity extends ParametrosAplicacao {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public ParametrosAplicacaoEntity() {
    }
	@Override
	public String toString() {
		return getHostSmtp();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParametrosAplicacao other = (ParametrosAplicacao) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
