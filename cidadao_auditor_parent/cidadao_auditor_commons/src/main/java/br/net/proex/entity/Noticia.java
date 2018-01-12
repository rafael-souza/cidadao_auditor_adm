package br.net.proex.entity;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.MappedSuperclass;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.Lob;

@Audited
@MappedSuperclass
public abstract class Noticia extends AppBaseEntity {

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_noticia")
	private Long id;
	
	@NotNull(message="O campo Título é de preenchimento obrigatório")
	@Size(max = 200)
	private String titulo;
	
	@NotNull(message="O campo Subtítulo é de preenchimento obrigatório")
	@Size(max = 500)
	private String subtitulo;
	
	@NotNull(message="O campo Descrição é de preenchimento obrigatório")
	@Lob	
	@Column(length = 2147483647)
	private String descricao;
	
	@Size(max = 100)
	private String autor;
	
	@NotNull(message="O campo Data é de preenchimento obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNoticia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao=descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor=autor;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia=dataNoticia;
	}

	/**
	 * @return the subtitulo
	 */
	public String getSubtitulo() {
		return subtitulo;
	}

	/**
	 * @param subtitulo the subtitulo to set
	 */
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

}
