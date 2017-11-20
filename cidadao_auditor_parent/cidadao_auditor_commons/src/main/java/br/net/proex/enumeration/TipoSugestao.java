package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum TipoSugestao {
    
	EDUC("{tipoSugestao.EDUC}"),
	TRAN("{tipoSugestao.TRAN}"),
	SAUD("{tipoSugestao.SAUD}"),
	ESPO("{tipoSugestao.ESPO}"),
	TURI("{tipoSugestao.TURI}"),
	MEIO("{tipoSugestao.MEIO}"),
	OUTR("{tipoSugestao.OUTR}"),
	INFR("{tipoSugestao.INFR}");

	
    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private TipoSugestao(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
