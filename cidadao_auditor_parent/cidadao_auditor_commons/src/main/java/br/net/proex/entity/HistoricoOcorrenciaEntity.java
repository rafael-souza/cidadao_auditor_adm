package br.net.proex.entity;


import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name="historico_ocorrencia")
@SequenceGenerator(name="se_historico_ocorrencia", sequenceName="se_historico_ocorrencia")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="HistoricoOcorrenciaEntity.querySelLookup", query="select id as id, observacao as observacao from HistoricoOcorrenciaEntity where id = ? order by id asc")
})
public class HistoricoOcorrenciaEntity extends HistoricoOcorrencia {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public HistoricoOcorrenciaEntity() {
    }
    
    @Transient
    private Long idOcorrencia;
    
    
	@Override
	public String toString() {
		return getObservacao();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoOcorrencia other = (HistoricoOcorrencia) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/**
	 * @return the idOcorrencia
	 */
	public Long getIdOcorrencia() {
		return idOcorrencia;
	}

	/**
	 * @param idOcorrencia the idOcorrencia to set
	 */
	public void setIdOcorrencia(Long idOcorrencia) {
		this.idOcorrencia = idOcorrencia;
	}

}
