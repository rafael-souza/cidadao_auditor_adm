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
@Table(name="pesquisa")
@SequenceGenerator(name="se_pesquisa", sequenceName="se_pesquisa")
@Access(AccessType.FIELD)

@Audited
@NamedQueries({
	@NamedQuery(name="PesquisaEntity.queryMan", query="from PesquisaEntity"),
	@NamedQuery(name="PesquisaEntity.querySel", query="select id as id, descricao as descricao, dataPesquisa as dataPesquisa, encerrada as encerrada from PesquisaEntity order by descricao asc"),
	@NamedQuery(name="PesquisaEntity.querySelLookup", query="select id as id, descricao as descricao from PesquisaEntity where id = ? order by id asc")
})
public class PesquisaEntity extends Pesquisa {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public PesquisaEntity() {
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
		Pesquisa other = (Pesquisa) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
