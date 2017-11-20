package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum StatusOcorrencia {
    
	ABE("{statusOcorrencia.ABE}"),
	ENC("{statusOcorrencia.ENC}"),
	ANA("{statusOcorrencia.ANA}"),
	CON("{statusOcorrencia.CON}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private StatusOcorrencia(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
