package br.net.proex.entity;

import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Access;


@Embeddable
@Access(AccessType.FIELD)

@NamedQueries({
	@NamedQuery(name="Endereco.querySelLookup", query="select numero as numero from Endereco where id = ? order by numero asc")
})
public class Endereco  implements Serializable {
	
	
	@Size(max = 400)
	private String logradouro;
	
	@Size(max = 10)
	private String numero;

	@Size(max = 40)
	private String complemento;

	@Size(max=10)
	private String cep;
	
	@Size(max = 200)
	private String bairro;

	@Size(max = 120)
	private String cidade;

	
	public Endereco() {
	}
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro=logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero=numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento=complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep=cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro=bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade=cidade;
	}

	@Override
	public String toString() {
		return getNumero();
	}

}
