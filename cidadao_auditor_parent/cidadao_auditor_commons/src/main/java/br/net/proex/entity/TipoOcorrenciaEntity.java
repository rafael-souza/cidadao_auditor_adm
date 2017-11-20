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
@Table(name="tipo_ocorrencia")
@SequenceGenerator(name="se_tipo_ocorrencia", sequenceName="se_tipo_ocorrencia")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="TipoOcorrenciaEntity.queryMan", query="from TipoOcorrenciaEntity"),
	@NamedQuery(name="TipoOcorrenciaEntity.querySel", query="select id as id, descricao as descricao, secretariaResponsavel as secretariaResponsavel from TipoOcorrenciaEntity order by descricao asc"),
	@NamedQuery(name="TipoOcorrenciaEntity.querySelLookup", query="select id as id, descricao as descricao, secretariaResponsavel as secretariaResponsavel from TipoOcorrenciaEntity where id = ? order by id asc")
})
public class TipoOcorrenciaEntity extends TipoOcorrencia {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public TipoOcorrenciaEntity() {
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
		TipoOcorrencia other = (TipoOcorrencia) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
