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
@Table(name="modelo_documento")
@SequenceGenerator(name="se_modelo_documento", sequenceName="se_modelo_documento")
@Access(AccessType.FIELD)
@Audited

@NamedQueries({
	@NamedQuery(name="ModeloDocumentoEntity.queryMan", query="from ModeloDocumentoEntity"),
	@NamedQuery(name="ModeloDocumentoEntity.naoDeveExistir", query="select count(*) from ModeloDocumentoEntity obj where obj.tipo = :tipo " ),
	@NamedQuery(name="ModeloDocumentoEntity.querySelPorTipo", query="select obj from ModeloDocumentoEntity obj where obj.tipo = :tipo "),
	@NamedQuery(name="ModeloDocumentoEntity.querySel", query="select id as id, tipo as tipo from ModeloDocumentoEntity order by id asc"),
	@NamedQuery(name="ModeloDocumentoEntity.querySelLookup", query="select id as id, texto as texto from ModeloDocumentoEntity where id = ? order by id asc")
})
public class ModeloDocumentoEntity extends ModeloDocumento {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public ModeloDocumentoEntity() {
    }
	@Override
	public String toString() {
		return getTexto();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloDocumento other = (ModeloDocumento) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
