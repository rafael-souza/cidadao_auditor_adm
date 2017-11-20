package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum StatusSugestao {
    
	ENV("{statusSugestao.ENV}"),
	REC("{statusSugestao.REC}"),
	ANA("{statusSugestao.ANA}"),
	REP("{statusSugestao.REP}"),
	APR("{statusSugestao.APR}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private StatusSugestao(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
