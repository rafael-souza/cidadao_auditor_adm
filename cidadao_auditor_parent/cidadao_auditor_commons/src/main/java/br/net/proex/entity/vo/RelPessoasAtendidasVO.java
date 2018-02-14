package br.net.proex.entity.vo;

import java.util.Date;

import br.net.proex.enumeration.StatusOcorrencia;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="RelPessoasAtendidasVO.querySel", query="select status as status, nomePessoa as nomePessoa, enderecoPessoa as enderecoPessoa, quantidade as quantidade from RelPessoasAtendidasVO order by nomePessoa asc")
})
public class RelPessoasAtendidasVO {
	
	// dados para realização do filtro
	private Date dataInicial;
	
	private Date dataFinal;
	
	private String endereco;
	
	private StatusOcorrencia status;
	
	// dados para exibição dos resultados
	private String nomePessoa;
	
	private String enderecoPessoa;
	
	private Long quantidade;

	/**
	 * @return the dataInicial
	 */
	public Date getDataInicial() {
		return dataInicial;
	}

	/**
	 * @param dataInicial the dataInicial to set
	 */
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * @return the dataFinal
	 */
	public Date getDataFinal() {
		return dataFinal;
	}

	/**
	 * @param dataFinal the dataFinal to set
	 */
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
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

	/**
	 * @return the status
	 */
	public StatusOcorrencia getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusOcorrencia status) {
		this.status = status;
	}

	/**
	 * @return the nomePessoa
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}

	/**
	 * @param nomePessoa the nomePessoa to set
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return the quantidade
	 */
	public Long getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the enderecoPessoa
	 */
	public String getEnderecoPessoa() {
		return enderecoPessoa;
	}

	/**
	 * @param enderecoPessoa the enderecoPessoa to set
	 */
	public void setEnderecoPessoa(String enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

}
