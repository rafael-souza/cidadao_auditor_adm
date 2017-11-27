package br.net.proex.entity.vo;

public class RelChartModelTipoStatusVO {
	
	private String label;
	
	private Long emAberto;
	
	private Long emAnalise;
	
	private Long encaminhada;
	
	private Long concluida;

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the emAberto
	 */
	public Long getEmAberto() {
		return emAberto;
	}

	/**
	 * @param emAberto the emAberto to set
	 */
	public void setEmAberto(Long emAberto) {
		this.emAberto = emAberto;
	}

	/**
	 * @return the emAnalise
	 */
	public Long getEmAnalise() {
		return emAnalise;
	}

	/**
	 * @param emAnalise the emAnalise to set
	 */
	public void setEmAnalise(Long emAnalise) {
		this.emAnalise = emAnalise;
	}

	/**
	 * @return the encaminhada
	 */
	public Long getEncaminhada() {
		return encaminhada;
	}

	/**
	 * @param encaminhada the encaminhada to set
	 */
	public void setEncaminhada(Long encaminhada) {
		this.encaminhada = encaminhada;
	}

	/**
	 * @return the concluida
	 */
	public Long getConcluida() {
		return concluida;
	}

	/**
	 * @param concluida the concluida to set
	 */
	public void setConcluida(Long concluida) {
		this.concluida = concluida;
	}

}
