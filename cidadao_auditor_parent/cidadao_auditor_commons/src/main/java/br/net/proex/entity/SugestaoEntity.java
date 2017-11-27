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
@Table(name="sugestao")
@SequenceGenerator(name="se_sugestao", sequenceName="se_sugestao")
@Access(AccessType.FIELD)
@Audited

@NamedQueries({
	@NamedQuery(name="SugestaoEntity.queryMan", query="from SugestaoEntity"),
	@NamedQuery(name="SugestaoEntity.querySelBuscaPorProtocolo", query="select obj from SugestaoEntity obj where obj.protocolo like :protocolo "),
	@NamedQuery(name="SugestaoEntity.querySel", query="select obj.id as id, obj1.id as pessoa_id , obj1.nome as pessoa_nome, obj.titulo as titulo, obj.endereco as endereco, obj.tipoSugestao as tipoSugestao, obj.status as status from SugestaoEntity obj left outer join obj.pessoa as obj1 order by obj.titulo asc"),
	@NamedQuery(name="SugestaoEntity.querySelLookup", query="select id as id, endereco as endereco from SugestaoEntity where id = ? order by id asc")
})
public class SugestaoEntity extends Sugestao {

	private static final long serialVersionUID = 1L;
	
	@Transient
	private String descTipo;
 	
    /*
     * Construtor padrao
     */
    public SugestaoEntity() {
    }
	@Override
	public String toString() {
		return getEndereco();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sugestao other = (Sugestao) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
	/**
	 * @return the descTipo
	 */
	public String getDescTipo() {
		return descTipo;
	}
	/**
	 * @param descTipo the descTipo to set
	 */
	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

}
