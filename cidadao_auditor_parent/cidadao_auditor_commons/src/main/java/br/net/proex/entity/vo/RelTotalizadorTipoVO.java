package br.net.proex.entity.vo;

import java.util.Date;

import br.net.proex.entity.SecretariaEntity;
import br.net.proex.entity.TipoOcorrenciaEntity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="RelTotalizadorTipoVO.querySel", query="select secretaria as secretaria, tipoOcorrencia as tipoOcorrencia, dataInicial as dataInicial, dataFinal as dataFinal from RelTotalizadorTipoVO order by secretaria asc")
})
public class RelTotalizadorTipoVO {
	
	private SecretariaEntity secretaria;
	
	private TipoOcorrenciaEntity tipoOcorrencia;
	
	private Date dataInicial;
	
	private Date dataFinal;
	
	private String descricaoSecretaria;
	
	private String descricaoTipo;
	
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
	 * @return the tipoOcorrencia
	 */
	public TipoOcorrenciaEntity getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	/**
	 * @param tipoOcorrencia the tipoOcorrencia to set
	 */
	public void setTipoOcorrencia(TipoOcorrenciaEntity tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
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
	 * @return the descricaoTipo
	 */
	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	/**
	 * @param descricaoTipo the descricaoTipo to set
	 */
	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
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

}
