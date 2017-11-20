package br.net.proex.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.config.domain.PlcFileAttach;
import com.powerlogic.jcompany.domain.validation.PlcValCnpj;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;

@Audited
@MappedSuperclass
public abstract class Prefeitura extends AppBaseEntity {

	
	@OneToMany (targetEntity = br.net.proex.entity.SecretariadoEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="prefeitura")
	@ForeignKey(name="FK_SECRETARIADO_PREFEITURA")	
	@Valid
	private List<SecretariadoEntity> secretariado;

	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_prefeitura")
	private Long id;

	@NotNull
	@Size(max = 200)
	private String nome;
		
	@Size(max = 100)
	private String nomeAbreviado;
	
	@Embedded	
	@Valid
	private Endereco endereco;
	
	@Size(max = 10)
	private String telefone;
	
	@Size(max = 10)
	private String fax;
	
	@Size(max = 200)
	private String email;
	
	@PlcValCnpj
	@Size(max = 14)
	private String cnpj;
	
	@Size(max = 200)
	private String site;	
	
	@OneToOne(targetEntity = FotoPrefeitura.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@ForeignKey(name = "FK_CAD_PREFEITURA_BRASAO")
	@PlcFileAttach(extension = { "gif", "jpg", "png", "bmp" }, image = true, showImageHeight = 100, showImageWidth = 100)
	private FotoPrefeitura brasao;	 	
	
	@Size(max = 20)
	private String latitude;
	
	@Size(max = 20)
	private String longitude;	
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado=nomeAbreviado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco=endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax=fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj=cnpj;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site=site;
	}

	public List<SecretariadoEntity> getSecretariado() {
		return secretariado;
	}

	public void setSecretariado(List<SecretariadoEntity> secretariado) {
		this.secretariado=secretariado;
	}


	/**
	 * @return the brasao
	 */
	public FotoPrefeitura getBrasao() {
		return brasao;
	}

	/**
	 * @param brasao the brasao to set
	 */
	public void setBrasao(FotoPrefeitura brasao) {
		this.brasao = brasao;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
