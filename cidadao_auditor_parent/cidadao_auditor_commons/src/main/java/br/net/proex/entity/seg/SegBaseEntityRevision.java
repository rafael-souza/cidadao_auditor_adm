package br.net.proex.entity.seg;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import br.net.proex.commons.audit.SegBaseEntityRevisionListener;
import br.net.proex.enumeration.SegAcaoRealizada;

/**
 * Entidade de revisão
 * 
 * @author Rafael Souza
 *
 */
@Entity
@RevisionEntity(SegBaseEntityRevisionListener.class)
@Table(name="REVISION")
@NamedQueries({
	@NamedQuery(name="SegBaseEntityRevision.querySel", query="select rev as rev, acaoRealizada as acaoRealizada, casoDeUso as casoDeUso, " +
			"usuarioUltAlteracao as usuarioUltAlteracao, dataUltAlteracao as dataUltAlteracao " +
			"from SegBaseEntityRevision order by casoDeUso asc")
})
public class SegBaseEntityRevision {

	@Id
    @GeneratedValue
    @RevisionNumber
    private Integer rev;

	@RevisionTimestamp  
	private Date dataUltAlteracao;
	
	private String usuarioUltAlteracao;
	
	private String casoDeUso;
	
	@Size(max=20)
	private String ip;
	
	@Enumerated(EnumType.STRING)
	@Column(length=4)
	private SegAcaoRealizada acaoRealizada;
	
	@Transient
	private String descricao;
	
	@Transient
	private SegUsuarioEntity usuario;
	
	@Transient
	//@Temporal(TemporalType.DATE)
	private Date dataAux;
	
	@Transient
	private String usuarioAux;
	
	@Transient
	private SegMenuEntity menu;	
	

	public SegBaseEntityRevision (Object[] objects){
		
		BigInteger rev = new BigInteger(String.valueOf(objects[0] == null ? 0 : objects[0]));
		
		this.rev = rev.intValue();
		dataUltAlteracao = new Date(((Timestamp)objects[1]).getTime());
		usuarioUltAlteracao = String.valueOf(objects[2]);
		acaoRealizada = objects[3] != null ? SegAcaoRealizada.valueOf((String) objects[3]) : null;
		casoDeUso = String.valueOf(objects[4]);		
		descricao = String.valueOf(objects[5]);
		
	}
	
	public SegBaseEntityRevision (Integer rev, Date dataUltAlteracao, String usuarioUltAlteracao, String acaoRealizada, String casoDeUso, String descricao){
		this.rev = rev;
		this.dataUltAlteracao = dataUltAlteracao; 
		this.usuarioUltAlteracao = usuarioUltAlteracao;
		this.acaoRealizada = SegAcaoRealizada.valueOf(acaoRealizada);
		this.casoDeUso = casoDeUso;
	}
	
	public SegBaseEntityRevision (){
	}
	
	public Integer getRev() {
		return rev;
	}

	public void setRev(Integer rev) {
		this.rev = rev;
	}

	public Date getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(Date dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public String getUsuarioUltAlteracao() {
		return usuarioUltAlteracao;
	}

	public void setUsuarioUltAlteracao(String usuarioUltAlteracao) {
		this.usuarioUltAlteracao = usuarioUltAlteracao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SegUsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(SegUsuarioEntity usuario) {
		this.usuario = usuario;		
	}

	public Date getDataAux() {
		return dataAux;
	}

	public void setDataAux(Date dataAux) {
		this.dataAux = dataAux;
	}

	public String getUsuarioAux() {
		return usuarioAux;
	}

	public void setUsuarioAux(String usuarioAux) {
		this.usuarioAux = usuarioAux;
	}

	public SegMenuEntity getMenu() {
		return menu;
	}

	public void setMenu(SegMenuEntity menu) {
		this.menu = menu;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}	
	
}
