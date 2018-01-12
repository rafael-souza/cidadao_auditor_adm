package br.net.proex.entity;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.MappedSuperclass;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import org.hibernate.annotations.ForeignKey;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@Audited
@MappedSuperclass
public abstract class Pesquisa extends AppBaseEntity {

	
	@OneToMany (targetEntity = br.net.proex.entity.PesquisaOpcaoEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="pesquisa")
	@ForeignKey(name="FK_PESQUISAOPCAO_PESQUISA")
	@PlcValDuplicity(property="descricao")
	@PlcValMultiplicity(referenceProperty="descricao",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.PesquisaOpcaoEntity}")
	@Valid
	private List<PesquisaOpcaoEntity> pesquisaOpcao;


	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_pesquisa")
	private Long id;
	
	@NotNull(message="O campo Descrição é de preenchimento obrigatório")
	@Size(max = 500)
	private String descricao;
	
	
	@NotNull(message="O campo Data é de preenchimento obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPesquisa;
	
	private Boolean encerrada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}

	public Date getDataPesquisa() {
		return dataPesquisa;
	}

	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa=dataPesquisa;
	}

	public Boolean getEncerrada() {
		return encerrada;
	}

	public void setEncerrada(Boolean encerrada) {
		this.encerrada=encerrada;
	}

	public List<PesquisaOpcaoEntity> getPesquisaOpcao() {
		return pesquisaOpcao;
	}

	public void setPesquisaOpcao(List<PesquisaOpcaoEntity> pesquisaOpcao) {
		this.pesquisaOpcao=pesquisaOpcao;
	}

}
