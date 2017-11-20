package br.net.proex.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.net.proex.enumeration.StatusSugestao;
import br.net.proex.enumeration.TipoSugestao;

@MappedSuperclass
public abstract class Sugestao extends AppBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_sugestao")
	private Long id;

	@ManyToOne(targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_Sugestao_PESSOA")
	@NotNull
	private PessoaEntity pessoa;

	@Size(max = 200)
	private String titulo;

	@Size(max = 200)
	private String endereco;
	
	@Size(max = 5000)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=3)
	private StatusSugestao status;
	
	@Enumerated(EnumType.STRING)
	@Column(length=4)
	private TipoSugestao tipoSugestao;
	
	@Size(max = 1000)
	private String observacao;
	
	@Size(max = 100)
	private String protocolo;	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSugestao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the status
	 */
	public StatusSugestao getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusSugestao status) {
		this.status = status;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the protocolo
	 */
	public String getProtocolo() {
		return protocolo;
	}

	/**
	 * @param protocolo the protocolo to set
	 */
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	/**
	 * @return the dataSugestao
	 */
	public Date getDataSugestao() {
		return dataSugestao;
	}

	/**
	 * @param dataSugestao the dataSugestao to set
	 */
	public void setDataSugestao(Date dataSugestao) {
		this.dataSugestao = dataSugestao;
	}

	/**
	 * @return the tipoSugestao
	 */
	public TipoSugestao getTipoSugestao() {
		return tipoSugestao;
	}

	/**
	 * @param tipoSugestao the tipoSugestao to set
	 */
	public void setTipoSugestao(TipoSugestao tipoSugestao) {
		this.tipoSugestao = tipoSugestao;
	}

}
