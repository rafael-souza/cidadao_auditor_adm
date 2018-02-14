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
@Table(name="pessoa")
@SequenceGenerator(name="se_pessoa", sequenceName="se_pessoa")
@Access(AccessType.FIELD)
@Audited
@NamedQueries({
	@NamedQuery(name="PessoaEntity.naoDeveExistir", query="select count(*) " +
            "from PessoaEntity obj " +
            "where obj.email = :email "),		
	@NamedQuery(name="PessoaEntity.queryMan", query="from PessoaEntity"),	
	@NamedQuery(name="PessoaEntity.querySelEmail", query="Select obj from PessoaEntity obj where obj.email like :email "),
	@NamedQuery(name="PessoaEntity.querySel", query="select obj.id as id, obj.nome as nome,  obj.email as email, obj.endereco as endereco, obj.celular as celular, obj.senha as senha from PessoaEntity obj order by obj.nome asc"),
	@NamedQuery(name="PessoaEntity.querySelLookup", query="select id as id, nome as nome from PessoaEntity where id = ? order by id asc")
})
public class PessoaEntity extends Pessoa {

	private static final long serialVersionUID = 1L;
 	
	@Transient
	private Boolean alterouSenha;
	
	@Transient
	private String dataCadastro;

	
    /*
     * Construtor padrao
     */
    public PessoaEntity() {
    }
	@Override
	public String toString() {
		return getNome();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
	/**
	 * @return the alterouSenha
	 */
	public Boolean getAlterouSenha() {
		return alterouSenha;
	}
	/**
	 * @param alterouSenha the alterouSenha to set
	 */
	public void setAlterouSenha(Boolean alterouSenha) {
		this.alterouSenha = alterouSenha;
	}
	/**
	 * @return the dataCadastro
	 */
	public String getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
