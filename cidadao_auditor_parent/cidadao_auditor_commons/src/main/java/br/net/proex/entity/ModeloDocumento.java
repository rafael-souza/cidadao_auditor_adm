package br.net.proex.entity;

import br.net.proex.enumeration.TipoModeloDocumento;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.Lob;

@Audited
@MappedSuperclass
public abstract class ModeloDocumento extends AppBaseEntity {

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_modelo_documento")
	private Long id;
	
	@NotNull(message="O campo Texto é de preenchimento obrigatório")
	@Lob	
	@Column(length = 2147483647)
	private String texto;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="O campo Tipo é de preenchimento obrigatório")
	@Column(length=4)
	private TipoModeloDocumento tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto=texto;
	}

	public TipoModeloDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoModeloDocumento tipo) {
		this.tipo=tipo;
	}

}
