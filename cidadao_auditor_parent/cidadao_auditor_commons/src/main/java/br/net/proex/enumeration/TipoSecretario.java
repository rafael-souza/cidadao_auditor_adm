package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoSecretario {
    
	OBR("{tipoSecretario.OBR}"),
	PRE("{tipoSecretario.PRE}"),
	VIC("{tipoSecretario.VIC}"),
	ADM("{tipoSecretario.ADM}"),
	ESP("{tipoSecretario.ESP}"),
	TUR("{tipoSecretario.TUR}"),
	CUL("{tipoSecretario.CUL}"),
	DES("{tipoSecretario.DES}"),
	MEI("{tipoSecretario.MEI}"),
	SOC("{tipoSecretario.SOC}"),
	EDU("{tipoSecretario.EDU}"),
	FIN("{tipoSecretario.FIN}"),
	PLA("{tipoSecretario.PLA}"),
	SAU("{tipoSecretario.SAU}"),
	JUR("{tipoSecretario.JUR}"),
	FAZ("{tipoSecretario.FAZ}"),
	CON("{tipoSecretario.CON}"),
	GAB("{tipoSecretario.GAB}"),
	PRO("{tipoSecretario.PRO}"),
	OUV("{tipoSecretario.OUV}"),
	PRF("{tipoSecretario.PRF}"),
	SAA("{tipoSecretario.SAA}");
	
	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoSecretario(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
