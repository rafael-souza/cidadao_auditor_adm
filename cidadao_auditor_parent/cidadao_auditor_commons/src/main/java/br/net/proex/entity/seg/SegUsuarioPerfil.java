package br.net.proex.entity.seg;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.net.proex.utils.DateTimeUtils;

@MappedSuperclass
@Audited
public abstract class SegUsuarioPerfil extends SegBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "se_seg_usuario_perfil")
	private Long id;

	@ManyToOne(targetEntity = SegUsuarioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEGUSUARIOPERFIL_USUARIO")
	@NotNull
	private SegUsuarioEntity usuario;

	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="dataInicial",targetField="perfil")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicial;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;

	@ManyToOne(targetEntity = SegPerfilEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_SEGUSUARIOPERFIL_PERFIL")
	@NotNull(groups = PlcValGroupEntityList.class)
	@PlcValRequiredIf(dependentfield="perfil",targetField="id")
	private SegPerfilEntity perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public SegPerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(SegPerfilEntity perfil) {
		this.perfil = perfil;
	}

	public SegUsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(SegUsuarioEntity usuario) {
		this.usuario = usuario;
	}	
	
    /**
     * Retorna falso se a data final for igual ou menor que a data inicial
     */
    @AssertTrue(message = "A data final deve ser maior que a data inicial")
    public boolean getValidaDatas() {    	
    	if (this.getDataInicial() != null && this.getDataFinal() != null){
    		return !(DateTimeUtils.isDataFinalAnteriorDataInicial(this.getDataInicial(), this.getDataFinal()));
    	}    	
    	return Boolean.TRUE;
    }		

}
