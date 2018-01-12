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
@Table(name="noticia")
@SequenceGenerator(name="se_noticia", sequenceName="se_noticia")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="NoticiaEntity.queryMan", query="from NoticiaEntity"),
	@NamedQuery(name="NoticiaEntity.querySel", 
		query="select "
				+ "id as id, "
				+ "titulo as titulo, "
				+ "autor as autor, "
				+ "dataNoticia as dataNoticia, "
				+ "descricao as descricao,"
				+ "subtitulo as subtitulo from NoticiaEntity order by dataNoticia desc"),
	@NamedQuery(name="NoticiaEntity.querySelLookup", query="select id as id, titulo as titulo from NoticiaEntity where id = ? order by id asc")
})
public class NoticiaEntity extends Noticia {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public NoticiaEntity() {
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
		Noticia other = (Noticia) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
