package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum SegTipoAcesso {
    
	NEG("{segTipoAcesso.NEG}"),
	PER("{segTipoAcesso.PER}"),
	TEM("{segTipoAcesso.TEM}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private SegTipoAcesso(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }  
	
}
