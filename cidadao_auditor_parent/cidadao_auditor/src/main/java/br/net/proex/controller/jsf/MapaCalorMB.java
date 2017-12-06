package br.net.proex.controller.jsf;

import java.util.Base64;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.controller.jsf.util.PlcCreateContextUtil;

import br.net.proex.entity.FotoOcorrencia;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.PrefeituraEntity;

@PlcConfigAggregation(
		entity = br.net.proex.entity.OcorrenciaEntity.class)
@PlcConfigForm (	
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/mapacalor"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(			
			pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=50))
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("mapacalor")
@PlcHandleException
@SessionScoped
public class MapaCalorMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	private String latitude;
	
	private String longitude;	
	
	private Boolean listagemOcorrencia;
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("mapacalor")
	public OcorrenciaEntity createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new OcorrenciaEntity();
              this.newEntity();
              // criando os marcadores
              alimentaMarcadoresMapa();
              
              // pegando a latitude e longitude da cidade
              PrefeituraEntity prefeitura = new PrefeituraEntity();
              prefeitura.setId(1L);
              List<PrefeituraEntity> lista = (List<PrefeituraEntity>)facade.findList(contextMontaUtil.createContextParamMinimum(), prefeitura, "", 0, 0);
              if (null != lista && lista.size() > 0){
            	  setLatitude(lista.get(0).getLatitude());
            	  setLongitude(lista.get(0).getLongitude());
              }                                         
         }

        return (OcorrenciaEntity) this.entityPlc;   
        
	}

	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("mapacalorLista")
	public PlcEntityList createEntityListPlc() {
		
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}		
	
	/**
	 * 
	 */
	@Override
	public String search() {		
		String retorno = super.search();
		alimentaMarcadoresMapa();		
		return retorno;
	}
	
	/**
	 * 
	 */
	private void alimentaMarcadoresMapa() {
		if (null != this.entityListPlc && null != this.entityListPlc.getItensPlc()){
			// recuperando a lista com os resultados
			List<OcorrenciaEntity> listaOcorrencia = (List<OcorrenciaEntity>)(Object) this.entityListPlc.getItensPlc();
			// verificando se tem algum resultado
//			if (null != listaOcorrencia && listaOcorrencia.size() > 0){
//						
//				// percorre a lista para a montagem da lista dos pontos do mapa
//				for (OcorrenciaEntity ocorrencia : listaOcorrencia){
//			        
//					if (null != ocorrencia.getFotoOcorrencia() && null != ocorrencia.getFotoOcorrencia().getId()){
//						ocorrencia.setFotoOcorrencia((FotoOcorrencia) facade.downloadFile(contextMontaUtil.createContextParamMinimum(),
//								FotoOcorrencia.class, ocorrencia.getFotoOcorrencia().getId()));
//																
//						StringBuilder sb = new StringBuilder();
//						sb.append("data:image/png;base64,");
//						sb.append(Base64.getEncoder().encodeToString(ocorrencia.getFotoOcorrencia().getBinaryContent().getBinaryContent()));
//						ocorrencia.setConteudoBinarioFoto(sb.toString());											
//					} 
//			        
//				}
//			}
		}		
	}	
	
	
	@Override
	public String clearArgs() {
		String retorno = super.clearArgs();
		
		return retorno;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the listagemOcorrencia
	 */
	public Boolean getListagemOcorrencia() {
		return listagemOcorrencia;
	}

	/**
	 * @param listagemOcorrencia the listagemOcorrencia to set
	 */
	public void setListagemOcorrencia(Boolean listagemOcorrencia) {
		this.listagemOcorrencia = listagemOcorrencia;
	}
	
}
