package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoModeloDocumento {
    
	CCRI("{tipoModeloDocumento.CCRI}"),
	CALT("{tipoModeloDocumento.CALT}"),
	CNEW("{tipoModeloDocumento.CNEW}"),
	CANA("{tipoModeloDocumento.CANA}"),
	CENC("{tipoModeloDocumento.CENC}"),
	CCON("{tipoModeloDocumento.CCON}"),
	RENC("{tipoModeloDocumento.RENC}"),
	CSUG("{tipoModeloDocumento.CSUG}"),
	CDEN("{tipoModeloDocumento.CDEN}"),
	CCOM("{tipoModeloDocumento.CCOM}"),
	OIMP("{tipoModeloDocumento.OIMP}"),
	OCAB("{tipoModeloDocumento.OCAB}"),
	OROD("{tipoModeloDocumento.OROD}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoModeloDocumento(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
