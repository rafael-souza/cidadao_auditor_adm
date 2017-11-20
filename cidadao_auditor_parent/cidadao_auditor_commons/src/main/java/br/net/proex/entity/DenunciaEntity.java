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
@Table(name="denuncia")
@SequenceGenerator(name="se_denuncia", sequenceName="se_denuncia")
@Access(AccessType.FIELD)

@Audited
@NamedQueries({
	@NamedQuery(name="DenunciaEntity.queryMan", query="from DenunciaEntity"),
	@NamedQuery(name="DenunciaEntity.querySelBuscaPorProtocolo", query="select obj from DenunciaEntity obj where obj.protocolo like :protocolo "),
	@NamedQuery(name="DenunciaEntity.querySel", query="select id as id, titulo as titulo, endereco as endereco, dataDenuncia as dataDenuncia, protocolo as protocolo from DenunciaEntity order by titulo asc"),
	@NamedQuery(name="DenunciaEntity.querySelLookup", query="select id as id, titulo as titulo from DenunciaEntity where id = ? order by id asc")
})
public class DenunciaEntity extends Denuncia {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public DenunciaEntity() {
    }
	@Override
	public String toString() {
		return getTitulo();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denuncia other = (Denuncia) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
