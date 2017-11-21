package br.net.proex.entity.vo;

import java.util.Date;

import br.net.proex.entity.TipoOcorrencia;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.enumeration.TipoGrafico;
import br.net.proex.enumeration.TipoSecretario;

import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="RelTipoStatusVO.querySel", query="select tipoOcorrenciaFiltro as tipoOcorrenciaFiltro, enderecoFiltro as enderecoFiltro, protocoloFiltro as protocoloFiltro, dataFiltro as dataFiltro, tipoGrafico as tipoGrafico from RelTipoStatusVO order by enderecoFiltro asc")
})
public class RelTipoStatusVO {
	
	// campos do filtro
	private TipoSecretario secretariaResponsavel;
	
	private TipoOcorrencia tipoOcorrenciaFiltro;
	
	private Date dataFiltro;
	
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
	public TipoSecretario getSecretariaResponsavel() {
		return secretariaResponsavel;
	}

	/**
	 * @param secretariaResponsavel the secretariaResponsavel to set
	 */
	public void setSecretariaResponsavel(TipoSecretario secretariaResponsavel) {
		this.secretariaResponsavel = secretariaResponsavel;
	}

}
