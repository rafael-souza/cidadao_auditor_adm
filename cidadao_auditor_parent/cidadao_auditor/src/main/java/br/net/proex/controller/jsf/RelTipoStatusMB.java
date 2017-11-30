package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.entity.TipoOcorrenciaEntity;
import br.net.proex.entity.vo.RelChartModelTipoStatusVO;
import br.net.proex.entity.vo.RelTipoStatusVO;
import br.net.proex.enumeration.TipoGrafico;

@PlcConfigAggregation(
		entity = br.net.proex.entity.vo.RelTipoStatusVO.class)
@PlcConfigForm (
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/reltipostatus"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
			pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=50))
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
    
    private Boolean exibeGraficoPizza;
    
    private Boolean exibeGraficoLinha;
    
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
              inicializaVariaveis();
              
              setListaTipoOcorrencia(new ArrayList<TipoOcorrenciaEntity>());
         }

        return (RelTipoStatusVO) this.entityPlc;   
        
	}
	
	/**
	 * 
	 */
	private void inicializaVariaveis() {
        lineChartModel = new LineChartModel();
        barChartModel = new BarChartModel();
        pieChartModel = new PieChartModel();
        
        exibeGraficoBarras = Boolean.FALSE;
        exibeGraficoPizza = Boolean.FALSE;
        exibeGraficoLinha = Boolean.FALSE;
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
		inicializaVariaveis();
		
		// verificando se o usuário informou o tipo de gráfico
		RelTipoStatusVO relTipoStatus = (RelTipoStatusVO) this.getEntityPlc();
		
		// verificando se informou os dados para o filtro
		Boolean situacaoValida = Boolean.TRUE;
		
		if (null == relTipoStatus.getSecretaria()){
			msgUtil.msg(AppBeanMessages.REL_SECRETARIA,
					PlcMessage.Cor.msgVermelhoPlc.toString());
			situacaoValida = Boolean.FALSE;
		}
		
		if (null == relTipoStatus.getTipoGrafico()){
			msgUtil.msg(AppBeanMessages.REL_TIPO_GRAFICO,
					PlcMessage.Cor.msgVermelhoPlc.toString());	
			situacaoValida = Boolean.FALSE;
		}
		
		// verficando se o tipo de grafico e pizza, se for é obrigatorio o tipo da ocorrencia
		if (null != relTipoStatus.getTipoGrafico() && relTipoStatus.getTipoGrafico().equals(TipoGrafico.PIZ) && 
				null == relTipoStatus.getTipoOcorrenciaFiltro()){
			msgUtil.msg(AppBeanMessages.REL_TIPO_OCORRENCIA,
					PlcMessage.Cor.msgVermelhoPlc.toString());	
			situacaoValida = Boolean.FALSE;
		}
		
		// verificando se passou pela validação
		if (situacaoValida){
			// realizando a busca dos dados de acordo com o filtro realizado
			List<RelChartModelTipoStatusVO> listaRetorno = facade.relTipoStatus(contextMontaUtil.createContextParamMinimum(), relTipoStatus);
			
			if (null != listaRetorno && listaRetorno.size() > 0){
				// criando o gráfico de acordo com o tipo escolhdido pelo usuario
				switch (relTipoStatus.getTipoGrafico()) {
				case BAR:
					criaGraficoBarra(listaRetorno, relTipoStatus);
					exibeGraficoBarras = Boolean.TRUE;
					exibeGraficoPizza = Boolean.FALSE;
					exibeGraficoLinha = Boolean.FALSE;
					break;
				case PIZ:
					criaGraficoPizza(listaRetorno, relTipoStatus);
					exibeGraficoBarras = Boolean.FALSE;
					exibeGraficoPizza = Boolean.TRUE;
					exibeGraficoLinha = Boolean.FALSE;
					break;
				case LIN:
					criaGraficoLinha(listaRetorno, relTipoStatus);
					exibeGraficoBarras = Boolean.FALSE;
					exibeGraficoPizza = Boolean.FALSE;
					exibeGraficoLinha = Boolean.TRUE;
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
	private void criaGraficoBarra(List<RelChartModelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		barChartModel = initBarModel(listaRetorno, relTipoStatus);
		barChartModel.setTitle("Tipo Ocorrêcia X Status");
		barChartModel.setAnimate(true);
		barChartModel.setLegendPosition("ne");
		Axis yAxis = barChartModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        //yAxis.setMax(0);
		
	}

	/**
	 * Inserindo os dados no model
	 * @param listaRetorno
	 * @param relTipoStatus 
	 * @return
	 */
	private BarChartModel initBarModel(List<RelChartModelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		BarChartModel model = new BarChartModel();
		// percorrendo a listagem dos resultados		
		for (RelChartModelTipoStatusVO tipoStatus : listaRetorno){
			// criando a serie
			ChartSeries serie = new ChartSeries();
			// informa o seu label
			serie.setLabel(tipoStatus.getLabel());
			// inserindo a serie no modelo e infomando que possui ocorrencias em aberto
			serie.set("Em Aberto", tipoStatus.getEmAberto());
			serie.set("Em Análise", tipoStatus.getEmAnalise());
			serie.set("Encaminhada", tipoStatus.getEncaminhada());
			serie.set("Concluída", tipoStatus.getConcluida());
			// inserindo no modelo do gráfico
			model.addSeries(serie);
		}
				        
        return model;
	}

	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 */
	private void criaGraficoPizza(List<RelChartModelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		pieChartModel = initPieModel(listaRetorno, relTipoStatus);
		
		pieChartModel.setTitle(relTipoStatus.getTipoOcorrenciaFiltro().getDescricao());
		pieChartModel.setLegendPosition("e");
		pieChartModel.setFill(false);
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setDiameter(350);
		
	}

	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 * @return
	 */
	private PieChartModel initPieModel(List<RelChartModelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		PieChartModel model = new PieChartModel();
     
		// percorrendo a listagem dos resultados		
		for (RelChartModelTipoStatusVO tipoStatus : listaRetorno){
			// inserindo a serie no modelo e infomando que possui ocorrencias em aberto
			model.set("Em Aberto", tipoStatus.getEmAberto());
			model.set("Em Análise", tipoStatus.getEmAnalise());
			model.set("Encaminhada", tipoStatus.getEncaminhada());
			model.set("Concluída", tipoStatus.getConcluida());
		}

		return model;
        
	}

	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 */
	private void criaGraficoLinha(List<RelChartModelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		lineChartModel = initLineModel(listaRetorno, relTipoStatus);     
        lineChartModel.setTitle("Tipo Ocorrêcia X Status");
        lineChartModel.setLegendPosition("e");
        lineChartModel.setShowPointLabels(true);
        lineChartModel.getAxes().put(AxisType.X, new CategoryAxis("Status das Ocorrências"));
        Axis yAxis = lineChartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade de Ocorrências");
        yAxis.setMin(0);
        //yAxis.setMax(200);

	}
	
	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 * @return
	 */
	private LineChartModel initLineModel(List<RelChartModelTipoStatusVO> listaRetorno, RelTipoStatusVO relTipoStatus) {
		LineChartModel model = new LineChartModel();
		// percorrendo a listagem dos resultados		
		for (RelChartModelTipoStatusVO tipoStatus : listaRetorno){
			// criando a serie
			ChartSeries  serie = new ChartSeries ();
			// informa o seu label
			serie.setLabel(tipoStatus.getLabel());
			// inserindo a serie no modelo e infomando que possui ocorrencias em aberto
			serie.set("Em Aberto", tipoStatus.getEmAberto());
			serie.set("Em Análise", tipoStatus.getEmAnalise());
			serie.set("Encaminhada", tipoStatus.getEncaminhada());
			serie.set("Concluída", tipoStatus.getConcluida());
			// inserindo no modelo do gráfico
			model.addSeries(serie);
		}
				        
        return model;
	}

	/**
	 * realiza a busca dos tipos de ocorrência da secretaria responsável
	 */
	public void buscaTipoOcorrenciaSecretaria(){
//		RelTipoStatusVO tipoStatus = (RelTipoStatusVO) this.getEntityPlc();
//		if (null != tipoStatus.getSecretariaResponsavel()){
//			setListaTipoOcorrencia(facade.buscaTipoPorSecretaria(contextMontaUtil.createContextParamMinimum(), 
//					tipoStatus.getSecretariaResponsavel()));
//		}
		
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

	/**
	 * @return the exibeGraficoPizza
	 */
	public Boolean getExibeGraficoPizza() {
		return exibeGraficoPizza;
	}

	/**
	 * @param exibeGraficoPizza the exibeGraficoPizza to set
	 */
	public void setExibeGraficoPizza(Boolean exibeGraficoPizza) {
		this.exibeGraficoPizza = exibeGraficoPizza;
	}

	/**
	 * @return the exibeGraficoLinha
	 */
	public Boolean getExibeGraficoLinha() {
		return exibeGraficoLinha;
	}

	/**
	 * @param exibeGraficoLinha the exibeGraficoLinha to set
	 */
	public void setExibeGraficoLinha(Boolean exibeGraficoLinha) {
		this.exibeGraficoLinha = exibeGraficoLinha;
	}
	
}
