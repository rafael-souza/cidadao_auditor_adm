package br.net.proex.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.config.domain.PlcFileAttach;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;

import br.net.proex.enumeration.StatusOcorrencia;

@Audited
@MappedSuperclass
public abstract class Ocorrencia extends AppBaseEntity {

	
	@OneToMany (targetEntity = br.net.proex.entity.HistoricoOcorrenciaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="ocorrencia")
	@ForeignKey(name="FK_HISTORICOOCORRENCIA_OCORRENCIA")
	@PlcValDuplicity(property="observacao")
	@PlcValMultiplicity(referenceProperty="observacao",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.HistoricoOcorrenciaEntity}")
	@Valid
	private List<HistoricoOcorrenciaEntity> historicoOcorrencia;
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_ocorrencia")
	private Long id;
	
	@ManyToOne (targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_OCORRENCIA_PESSOA")
//	@NotNull(message="O campo Pessoa é de preenchimento obrigatório")
	private PessoaEntity pessoa;
	
	@ManyToOne (targetEntity = TipoOcorrenciaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_OCORRENCIA_TIPOOCORRENCIA")
//	@NotNull(message="O campo Tipo é de preenchimento obrigatório")
	private TipoOcorrenciaEntity tipoOcorrencia;
	
//	@NotNull(message="O campo Data é de preenchimento obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOcorrencia;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConclusao;
	
	@Size(max = 120)
	private String responsavelConclusao;
	
//	@NotNull(message="O campo Latitude é de preenchimento obrigatório")
	@Size(max = 30)
	private String latitude;
	
//	@NotNull(message="O campo Longitude é de preenchimento obrigatório")
	@Size(max = 30)
	private String longitude;
	
	@Enumerated(EnumType.STRING)
//	@NotNull(message="O campo Status é de preenchimento obrigatório")
	@Column(length=3)
	private StatusOcorrencia statusOcorrencia;
	
	@OneToOne(targetEntity = FotoOcorrencia.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@ForeignKey(name = "FK_OCORRENCIA_FOTO_OCORRENCIA")
	@PlcFileAttach(extension = { "gif", "jpg", "png", "bmp" }, image = true, showImageHeight = 200, showImageWidth = 200)
	private FotoOcorrencia fotoOcorrencia;	
	
	@Size(max = 300)
	private String endereco;	
	
	@Size(max = 500)
	private String observacao;
	
	@Size(max = 100)
	private String protocolo;	
	
	@Size(max = 500)
	private String observacaoConclusao;	
	

	public Long getId() {
		return id;
		
	}

	public void setId(Long id) {
		this.id=id;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa=pessoa;
	}

	public TipoOcorrenciaEntity getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrenciaEntity tipoOcorrencia) {
		this.tipoOcorrencia=tipoOcorrencia;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia=dataOcorrencia;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude=latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude=longitude;
	}

	public StatusOcorrencia getStatusOcorrencia() {
		return statusOcorrencia;
	}

	public void setStatusOcorrencia(StatusOcorrencia statusOcorrencia) {
		this.statusOcorrencia=statusOcorrencia;
	}

	/**
	 * @return the dataConclusao
	 */
	public Date getDataConclusao() {
		return dataConclusao;
	}

	/**
	 * @param dataConclusao the dataConclusao to set
	 */
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	/**
	 * @return the responsavelConclusao
	 */
	public String getResponsavelConclusao() {
		return responsavelConclusao;
	}

	/**
	 * @param responsavelConclusao the responsavelConclusao to set
	 */
	public void setResponsavelConclusao(String responsavelConclusao) {
		this.responsavelConclusao = responsavelConclusao;
	}

	/**
	 * @return the fotoOcorrencia
	 */
	public FotoOcorrencia getFotoOcorrencia() {
		return fotoOcorrencia;
	}

	/**
	 * @param fotoOcorrencia the fotoOcorrencia to set
	 */
	public void setFotoOcorrencia(FotoOcorrencia fotoOcorrencia) {
		this.fotoOcorrencia = fotoOcorrencia;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the protocolo
	 */
	public String getProtocolo() {
		return protocolo;
	}

	/**
	 * @param protocolo the protocolo to set
	 */
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public List<HistoricoOcorrenciaEntity> getHistoricoOcorrencia() {
		return historicoOcorrencia;
	}

	public void setHistoricoOcorrencia(List<HistoricoOcorrenciaEntity> historicoOcorrencia) {
		this.historicoOcorrencia=historicoOcorrencia;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the observacaoConclusao
	 */
	public String getObservacaoConclusao() {
		return observacaoConclusao;
	}

	/**
	 * @param observacaoConclusao the observacaoConclusao to set
	 */
	public void setObservacaoConclusao(String observacaoConclusao) {
		this.observacaoConclusao = observacaoConclusao;
	}

}
