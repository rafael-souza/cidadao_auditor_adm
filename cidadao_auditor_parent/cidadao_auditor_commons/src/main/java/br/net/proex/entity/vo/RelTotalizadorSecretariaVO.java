package br.net.proex.entity.vo;

import java.util.Date;

import br.net.proex.entity.SecretariaEntity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="RelTotalizadorSecretariaVO.querySel", query="select descricaoSecretaria as descricaoSecretaria, status as status, total as total from RelTotalizadorSecretariaVO order by descricaoSecretaria asc")
})
public class RelTotalizadorSecretariaVO {
	
	private SecretariaEntity secretaria;
	
	private Date dataInicial;
	
	private Date dataFinal;
	
	private String descricaoSecretaria;
	
	private String status;
	
	private Long total;

	/**
	 * @return the secretaria
	 */
	public SecretariaEntity getSecretaria() {
		return secretaria;
	}

	/**
	 * @param secretaria the secretaria to set
	 */
	public void setSecretaria(SecretariaEntity secretaria) {
		this.secretaria = secretaria;
	}

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
	 * @return the descricaoSecretaria
	 */
	public String getDescricaoSecretaria() {
		return descricaoSecretaria;
	}

	/**
	 * @param descricaoSecretaria the descricaoSecretaria to set
	 */
	public void setDescricaoSecretaria(String descricaoSecretaria) {
		this.descricaoSecretaria = descricaoSecretaria;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

}
