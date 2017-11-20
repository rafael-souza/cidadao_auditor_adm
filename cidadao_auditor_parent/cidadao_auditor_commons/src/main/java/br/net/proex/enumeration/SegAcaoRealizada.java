package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum SegAcaoRealizada {
    
	INS("{acaoRealizada.INS}"),
	ALT("{acaoRealizada.ALT}"),
	EXC("{acaoRealizada.EXC}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private SegAcaoRealizada(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }

}
