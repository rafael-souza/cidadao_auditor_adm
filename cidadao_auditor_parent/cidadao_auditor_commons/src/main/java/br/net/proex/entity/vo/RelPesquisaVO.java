package br.net.proex.entity.vo;

import br.net.proex.entity.PesquisaEntity;
import br.net.proex.enumeration.TipoGrafico;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="RelPesquisaVO.querySel", query="select pesquisa as pesquisa, tipoGrafico as tipoGrafico from RelPesquisaVO order by pesquisa asc")
})
public class RelPesquisaVO {
	
	private PesquisaEntity pesquisa;
	
	private TipoGrafico tipoGrafico;

	/**
	 * @return the pesquisa
	 */
	public PesquisaEntity getPesquisa() {
		return pesquisa;
	}

	/**
	 * @param pesquisa the pesquisa to set
	 */
	public void setPesquisa(PesquisaEntity pesquisa) {
		this.pesquisa = pesquisa;
	}

	/**
	 * @return the tipoGrafico
	 */
	public TipoGrafico getTipoGrafico() {
		return tipoGrafico;
	}

	/**
	 * @param tipoGrafico the tipoGrafico to set
	 */
	public void setTipoGrafico(TipoGrafico tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

}
