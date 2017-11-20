package br.net.proex.enumeration;

/**
 * Enum de domínio discreto gerada automaticamente pelo assistente do jCompany.
 */
public enum SegAcao {
    
	
	ABR("{segAcao.ABR}"), // ABRIR
	AJU("{segAcao.AJU}"), // AJUDA	
	APR("{segAcao.APR}"), // APROVAR	
	CAN("{segAcao.CAN}"), // CANCELAR
	CAP("{segAcao.CAP}"), // CANCELAR POPUP
	CLO("{segAcao.CLO}"), // CLONAR
	EDI("{segAcao.EDI}"), // EDITAR	
	EXC("{segAcao.EXC}"), // EXCLUIR
	EXD("{segAcao.EXD}"), // EXCLUIR DETALHE
	EXS("{segAcao.EXS}"), // EXCLUIR SUB-DETALHE
	EXP("{segAcao.EXP}"), // EXPORTAR	
	GRA("{segAcao.GRA}"), // GRAVAR
	GER("{segAcao.GER}"), // GERAR RELATORIO
	IMP("{segAcao.IMP}"), // IMPRIMIR
	INC("{segAcao.INC}"), // INCLUIR
	IND("{segAcao.IND}"), // INCLUIR DETALHE
	INS("{segAcao.INS}"), // INCLUIR SUB-DETALHE
	LIM("{segAcao.LIM}"), // LIMPAR		
	PES("{segAcao.PES}"), // PESQUISAR			
	PED("{segAcao.PED}"), // PESQUISAR DETALHE
	REP("{segAcao.REP}"), // REPROVAR	
	UPL("{segAcao.UPL}"); // UPLOAD	
	

    /**
     * @return Retorna o codigo.
     */
     
	private String label;
    
    private SegAcao(String label) {
    	this.label = label;
    }
     
    public String getLabel() {
        return label;
    }
	
}
