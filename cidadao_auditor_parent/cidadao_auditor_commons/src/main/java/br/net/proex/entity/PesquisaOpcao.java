package br.net.proex.entity;

import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.validation.constraints.Digits;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class PesquisaOpcao extends AppBaseEntity {
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_pesquisa_opcao")
	private Long id;
	
	@ManyToOne (targetEntity = PesquisaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_PESQUISAOPCAO_PESQUISA")
	@NotNull
	private Pesquisa pesquisa;

	@NotNull(message="O campo Descrição é de preenchimento obrigatório nas opções da pesquisa.")
	@Size(max = 200)
	private String descricao;
	
	@Digits(integer=10, fraction=0)
	private Long votos;

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

	public Long getVotos() {
		return votos;
	}

	public void setVotos(Long votos) {
		this.votos=votos;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa=pesquisa;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
