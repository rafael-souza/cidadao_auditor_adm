package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoGrafico {
    
	BAR("{tipoGrafico.BAR}"),
	PIZ("{tipoGrafico.PIZ}"),
	LIN("{tipoGrafico.LIN}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoGrafico(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
