package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.entity.TipoOcorrenciaEntity;
import br.net.proex.entity.vo.RelTipoStatusVO;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.facade.IAppFacade;

import com.powerlogic.jcompany.commons.PlcBeanMessages;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigNestedCombo;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.net.proex.entity.vo.RelTipoStatusVO.class)
@PlcConfigForm (
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/reltipostatus"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
			pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=50)),
	nestedCombo=@PlcConfigNestedCombo(origemProp="secretariaResponsavel", destinyProp="tipoOcorrenciaFiltro")
)


/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("reltipostatus")
@PlcHandleException
public class RelTipoStatusMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	private LineChartModel lineChartModel;
	
    private BarChartModel barChartModel;
    
    private PieChartModel pieChartModel;
    
    private Boolean exibeGraficoBarras;
    
    private List<TipoOcorrenciaEntity> listaTipoOcorrencia;
 	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("reltipostatus")
	public RelTipoStatusVO createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new RelTipoStatusVO();
              this.newEntity();
              // inicializando as variveis gráficas
              lineChartModel = new LineChartModel();
              barChartModel = new BarChartModel();
              pieChartModel = new PieChartModel();
              
              exibeGraficoBarras = Boolean.FALSE;
              
              setListaTipoOcorrencia(new ArrayList<TipoOcorrenciaEntity>());
         }

        return (RelTipoStatusVO) this.entityPlc;   
        
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("reltipostatusLista")
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
		String retorno = "";
		
		// verificando se o usuário informou o tipo de gráfico
		RelTipoStatusVO relTipoStatus = (RelTipoStatusVO) this.getEntityPlc();
		
		// verificando se informou os dados para o filtro
		Boolean situacaoValida = Boolean.TRUE;
		
		if (null == relTipoStatus.getSecretariaResponsavel()){
			msgUtil.msg(AppBeanMessages.REL_SECRETARIA,
					PlcMessage.Cor.msgVermelhoPlc.toString());
			situacaoValida = Boolean.FALSE;
		}
		
		if (null == relTipoStatus.getTipoGrafico()){
			msgUtil.msg(AppBeanMessages.REL_TIPO_GRAFICO,
					PlcMessage.Cor.msgVermelhoPlc.toString());	
			situacaoValida = Boolean.FALSE;
		}
		
		// verificando se passou pela validação
		if (situacaoValida){
			// realizando a busca dos dados de acordo com o filtro realizado
			List<RelTipoStatusVO> listaRetorno = facade.relTipoStatus(contextMontaUtil.createContextParamMinimum(), relTipoStatus);
			
			if (null != listaRetorno && listaRetorno.size() > 0){
			// criando o gráfico de acordo com o tipo escolhdido pelo usuario
				switch (relTipoStatus.getTipoGrafico()) {
				case BAR:
					criaGraficoBarra(listaRetorno, relTipoStatus);
					exibeGraficoBarras = Boolean.TRUE;
					break;
				case PIZ:
					criaGraficoPizza(listaRetorno, relTipoStatus);
					break;
				case LIN:
					criaGraficoLinha(listaRetorno, relTipoStatus);
					break;
				}
			}
		} else {
			msgUtil.msg(AppBeanMessages.NENHUM_RESULTADO,
					PlcMessage.Cor.msgVermelhoPlc.toString());
		}
		
		return retorno;
	}

	/**
	 * Realiza a montagem do gráfico de barras
	 * @param listaRetorno
	 * @param relTipoStatus 
	 */
	private void criaGraficoBarra(List<RelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		barChartModel = initBarModel(listaRetorno, relTipoStatus);
		barChartModel.setTitle("Tipo Ocorrêcia X Status");
		barChartModel.setAnimate(true);
		barChartModel.setLegendPosition("ne");
		Axis yAxis = barChartModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
		
	}
	
	/**
	 * Inserindo os dados no model
	 * @param listaRetorno
	 * @param relTipoStatus 
	 * @return
	 */
	private BarChartModel initBarModel(List<RelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		BarChartModel model = new BarChartModel();
		
		// se encontrou algum tipo
		if (null != getListaTipoOcorrencia() && getListaTipoOcorrencia().size() > 0){
			// percorre os tipos 
			for (TipoOcorrenciaEntity tipo : getListaTipoOcorrencia()){
				
				if (null != relTipoStatus.getTipoOcorrenciaFiltro() && relTipoStatus.getTipoOcorrenciaFiltro().getId() == tipo.getId() || 
						null == relTipoStatus.getTipoOcorrenciaFiltro()){
					
					// criando a serie
					ChartSeries serie = new ChartSeries();
	
					// informa o seu label
					serie.setLabel(tipo.getDescricao());
					
					// variaveis para controle do status da ocorrencia
					Boolean temAberto = Boolean.FALSE;
					Boolean temAnalise = Boolean.FALSE;
					Boolean temEncaminhado = Boolean.FALSE;
					Boolean temConcluido = Boolean.FALSE;
					
					// percorre a lista de retorno para comparação dos tipos encontrados
					for (RelTipoStatusVO tipoStatus : listaRetorno){
						
						if (tipoStatus.getTipoOcorrencia().equals(tipo.getDescricao())){
							// verificando se o status do tipo é em aberto
							if (null != tipoStatus.getStatusOcorrencia() && 
									tipoStatus.getStatusOcorrencia().equals("Em Aberto")){
								// inserindo a serie no modelo e infomando que possui ocorrencias em aberto
								serie.set(tipoStatus.getStatusOcorrencia(), tipoStatus.getTotal());
								temAberto = Boolean.TRUE;
							} else if (null != tipoStatus.getStatusOcorrencia() && 
									tipoStatus.getStatusOcorrencia().equals("Em Análise")){
								// inserindo a serie no modelo e infomando que possui ocorrencias em analise
								serie.set(tipoStatus.getStatusOcorrencia(), tipoStatus.getTotal());
								temAnalise = Boolean.TRUE;
							} else if (null != tipoStatus.getStatusOcorrencia() && 
									tipoStatus.getStatusOcorrencia().equals("Encaminhada")){
								// inserindo a serie no modelo e infomando que possui ocorrencias encaminhadas
								serie.set(tipoStatus.getStatusOcorrencia(), tipoStatus.getTotal());
								temEncaminhado = Boolean.TRUE;
							} else if (null != tipoStatus.getStatusOcorrencia() && 
									tipoStatus.getStatusOcorrencia().equals("Concluída")){
								// inserindo a serie no modelo e infomando que possui ocorrencias concluidas
								serie.set(tipoStatus.getStatusOcorrencia(), tipoStatus.getTotal());
								temConcluido = Boolean.TRUE;
							}	
						}	
					}
					
					// verifica se tem alguma ocorrencia em aberto
					if (!temAberto){
						serie.set(StatusOcorrencia.ABE.getLabel(), 0);
					}
					
					// verifica se tem alguma ocorrencia em analise
					if (!temAnalise){
						serie.set(StatusOcorrencia.ANA.getLabel(), 0);
					}
					
					// verifica se tem alguma ocorrencia encmainhada
					if (!temEncaminhado){
						serie.set(StatusOcorrencia.ENC.getLabel(), 0);
					}
					
					// verifica se tem alguma ocorrencia concluida
					if (!temConcluido){
						serie.set(StatusOcorrencia.CON.getLabel(), 0);
					}
					
					// inserindo no modelo do gráfico
					model.addSeries(serie);
				}
			}
			
		}
				        
        return model;
	}

	private void criaGraficoPizza(List<RelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		// TODO Auto-generated method stub
		
	}

	private void criaGraficoLinha(List<RelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * realiza a busca dos tipos de ocorrência da secretaria responsável
	 */
	public void buscaTipoOcorrenciaSecretaria(){
		RelTipoStatusVO tipoStatus = (RelTipoStatusVO) this.getEntityPlc();
		if (null != tipoStatus.getSecretariaResponsavel()){
			setListaTipoOcorrencia(facade.buscaTipoPorSecretaria(contextMontaUtil.createContextParamMinimum(), 
					tipoStatus.getSecretariaResponsavel()));
		}
		
	}

	/**
	 * @return the lineChartModel
	 */
	public LineChartModel getLineChartModel() {
		return lineChartModel;
	}

	/**
	 * @param lineChartModel the lineChartModel to set
	 */
	public void setLineChartModel(LineChartModel lineChartModel) {
		this.lineChartModel = lineChartModel;
	}

	/**
	 * @return the barChartModel
	 */
	public BarChartModel getBarChartModel() {
		return barChartModel;
	}

	/**
	 * @param barChartModel the barChartModel to set
	 */
	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}

	/**
	 * @return the pieChartModel
	 */
	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	/**
	 * @param pieChartModel the pieChartModel to set
	 */
	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}

	/**
	 * @return the exibeGraficoBarras
	 */
	public Boolean getExibeGraficoBarras() {
		return exibeGraficoBarras;
	}

	/**
	 * @param exibeGraficoBarras the exibeGraficoBarras to set
	 */
	public void setExibeGraficoBarras(Boolean exibeGraficoBarras) {
		this.exibeGraficoBarras = exibeGraficoBarras;
	}

	/**
	 * @return the listaTipoOcorrencia
	 */
	public List<TipoOcorrenciaEntity> getListaTipoOcorrencia() {
		return listaTipoOcorrencia;
	}

	/**
	 * @param listaTipoOcorrencia the listaTipoOcorrencia to set
	 */
	public void setListaTipoOcorrencia(List<TipoOcorrenciaEntity> listaTipoOcorrencia) {
		this.listaTipoOcorrencia = listaTipoOcorrencia;
	}
	
}
