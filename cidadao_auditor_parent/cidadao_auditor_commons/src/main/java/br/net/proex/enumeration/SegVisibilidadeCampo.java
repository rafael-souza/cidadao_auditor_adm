package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum SegVisibilidadeCampo {
    
	SOL("{segVisibilidadeCampo.SOL}"),	
	INV("{segVisibilidadeCampo.INV}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private SegVisibilidadeCampo(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
