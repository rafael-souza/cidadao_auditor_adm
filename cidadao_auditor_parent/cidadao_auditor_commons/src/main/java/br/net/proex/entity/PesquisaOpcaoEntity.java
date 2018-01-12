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
@Table(name="pesquisa_opcao")
@SequenceGenerator(name="se_pesquisa_opcao", sequenceName="se_pesquisa_opcao")
@Access(AccessType.FIELD)

@Audited
@NamedQueries({
	@NamedQuery(name="PesquisaOpcaoEntity.querySelLookup", query="select id as id, descricao as descricao, votos as votos from PesquisaOpcaoEntity where id = ? order by id asc")
})
public class PesquisaOpcaoEntity extends PesquisaOpcao {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public PesquisaOpcaoEntity() {
    }
	@Override
	public String toString() {
		return getDescricao();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PesquisaOpcao other = (PesquisaOpcao) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
