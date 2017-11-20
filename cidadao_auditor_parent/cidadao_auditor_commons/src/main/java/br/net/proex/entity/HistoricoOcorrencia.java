package br.net.proex.entity;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.MappedSuperclass;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;

@Audited
@MappedSuperclass
public abstract class HistoricoOcorrencia extends AppBaseEntity {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "se_historico_ocorrencia")
	private Long id;
	
	@ManyToOne (targetEntity = OcorrenciaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_HISTORICOOCORRENCIA_OCORRENCIA")
	@NotNull
	private OcorrenciaEntity ocorrencia;

	
	@NotNull
	@PlcValRequiredIf(dependentfield="dataHistorico",targetField="observacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHistorico;
	
	@NotNull
	@Size(max = 500)
	private String observacao;
	
	@NotNull
	@PlcValRequiredIf(dependentfield="responsavel",targetField="observacao")
	@Size(max = 100)
	private String responsavel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public Date getDataHistorico() {
		return dataHistorico;
	}

	public void setDataHistorico(Date dataHistorico) {
		this.dataHistorico=dataHistorico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao=observacao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel=responsavel;
	}

	public OcorrenciaEntity getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(OcorrenciaEntity ocorrencia) {
		this.ocorrencia=ocorrencia;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
