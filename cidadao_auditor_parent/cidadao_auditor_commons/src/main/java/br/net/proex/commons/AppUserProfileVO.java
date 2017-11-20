/* Jaguar-jCompany Developer Suite. Powerlogic 2010-2014. Please read licensing information or contact Powerlogic 
 * for more information or contribute with this project: suporte@powerlogic.com.br - www.powerlogic.com.br        */ 
package br.net.proex.commons;

import javax.enterprise.inject.Specializes;

import com.powerlogic.jcompany.commons.PlcBaseUserProfileVO;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;

import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.enumeration.SegAcaoRealizada;

/**
* cidadao_auditor. Implementar aqui atributos de personalização
* específicos do usuario.
*/
@QPlcDefault
@Specializes
public class AppUserProfileVO extends PlcBaseUserProfileVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private SegUsuarioEntity usuario;
	    
	    private String casoDeUso;
	    private SegAcaoRealizada acaoRealizada;    
	    
	    public SegUsuarioEntity getUsuario() {
	          return usuario;
	    }

	    public void setUsuario(SegUsuarioEntity usuario) {
	          this.usuario = usuario;
	    }

		public String getCasoDeUso() {
			return casoDeUso;
		}

		public void setCasoDeUso(String casoDeUso) {
			this.casoDeUso = casoDeUso;
		}

		public SegAcaoRealizada getAcaoRealizada() {
			return acaoRealizada;
		}

		public void setAcaoRealizada(SegAcaoRealizada acaoRealizada) {
			this.acaoRealizada = acaoRealizada;
		}			
	
}
