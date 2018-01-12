package br.net.proex.entity.vo;

import java.util.Date;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.net.proex.entity.SecretariaEntity;
import br.net.proex.entity.TipoOcorrencia;
import br.net.proex.enumeration.TipoGrafico;

@NamedQueries({
	@NamedQuery(name="RelTipoStatusVO.querySel", query="select tipoOcorrenciaFiltro as tipoOcorrenciaFiltro, enderecoFiltro as enderecoFiltro, protocoloFiltro as protocoloFiltro, dataFiltro as dataFiltro, tipoGrafico as tipoGrafico from RelTipoStatusVO order by enderecoFiltro asc")
})

public class RelTipoStatusVO {
	
	// campos do filtro
	private SecretariaEntity secretaria;
	
	private TipoOcorrencia tipoOcorrenciaFiltro;
	
	private Date dataFiltro;
	
	private Date dataFinal;
	
	private TipoGrafico tipoGrafico;
	
	// dados referente ao gráfico
	private String tipoOcorrencia;
	
	private String statusOcorrencia;
	
	private Long total;

	/**
	 * @return the tipoOcorrenciaFiltro
	 */
	public TipoOcorrencia getTipoOcorrenciaFiltro() {
		return tipoOcorrenciaFiltro;
	}

	/**
	 * @param tipoOcorrenciaFiltro the tipoOcorrenciaFiltro to set
	 */
	public void setTipoOcorrenciaFiltro(TipoOcorrencia tipoOcorrenciaFiltro) {
		this.tipoOcorrenciaFiltro = tipoOcorrenciaFiltro;
	}

	/**
	 * @return the dataFiltro
	 */
	public Date getDataFiltro() {
		return dataFiltro;
	}

	/**
	 * @param dataFiltro the dataFiltro to set
	 */
	public void setDataFiltro(Date dataFiltro) {
		this.dataFiltro = dataFiltro;
	}

	/**
	 * @return the tipoOcorrencia
	 */
	public String getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	/**
	 * @param tipoOcorrencia the tipoOcorrencia to set
	 */
	public void setTipoOcorrencia(String tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	/**
	 * @return the statusOcorrencia
	 */
	public String getStatusOcorrencia() {
		return statusOcorrencia;
	}

	/**
	 * @param statusOcorrencia the statusOcorrencia to set
	 */
	public void setStatusOcorrencia(String statusOcorrencia) {
		this.statusOcorrencia = statusOcorrencia;
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
	 * @return the tipoGrafico
	 */
	public TipoGrafico getTipoGrafico() {
		return tipoGrafico;
	}

	/**
	 * @param tipoGrafico the tipoGrafico to set
	 */
	public void setTipoGrafico(TipoGrafico tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

	/**
	 * @return the secretariaResponsavel
	 */
	public SecretariaEntity getSecretaria() {
		return secretaria;
	}

	/**
	 * @param secretariaResponsavel the secretariaResponsavel to set
	 */
	public void setSecretaria(SecretariaEntity secretaria) {
		this.secretaria = secretaria;
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

}
