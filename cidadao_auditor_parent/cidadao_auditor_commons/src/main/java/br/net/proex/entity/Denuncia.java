package br.net.proex.entity;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey; 
import org.hibernate.envers.Audited; 

@Audited
@MappedSuperclass
public abstract class Denuncia extends AppBaseEntity {

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_denuncia")
	private Long id;

	@NotNull(message = "O campo Título é de preenchimento obrigatório.")
	@Size(max = 200)
	private String titulo;
	
	@Size(max = 200)  
	private String endereco; 
	
	@Size(max = 5000)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDenuncia;
	
	@Size(max = 100)
	private String protocolo;
	
	@ManyToOne (targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_DENUNCIA_PESSOA")
	private PessoaEntity pessoa;
	
	private Boolean denunciaAnonima;
	
	@Size(max = 5000)
	private String observacao;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}

	public Date getDataDenuncia() {
		return dataDenuncia;
	}

	public void setDataDenuncia(Date dataDenuncia) {
		this.dataDenuncia=dataDenuncia;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo=protocolo;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa=pessoa;
	}

	public Boolean getDenunciaAnonima() {
		return denunciaAnonima;
	}

	public void setDenunciaAnonima(Boolean denunciaAnonima) {
		this.denunciaAnonima=denunciaAnonima;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao=observacao;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
