package br.net.proex.controller.jsf;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import br.net.proex.commons.AppBeanMessages;
import br.net.proex.entity.PesquisaEntity;
import br.net.proex.entity.PesquisaOpcaoEntity;
import br.net.proex.entity.vo.RelChartModelTipoStatusVO;
import br.net.proex.entity.vo.RelPesquisaVO;
import br.net.proex.entity.vo.RelTipoStatusVO;
import br.net.proex.enumeration.TipoGrafico;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.domain.validation.PlcMessage;
import com.powerlogic.jcompany.controller.jsf.PlcEntityList;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(entity = br.net.proex.entity.vo.RelPesquisaVO.class)
@PlcConfigForm (
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/relpesquisa"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
			pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=50))
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("relpesquisa")
@PlcHandleException
public class RelPesquisaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	private LineChartModel lineChartModel;
	
    private HorizontalBarChartModel horizontalBarChartModel ;
    
    private PieChartModel pieChartModel;
    
    private Boolean exibeGraficoBarras;
    
    private Boolean exibeGraficoPizza;
    
    private Boolean exibeGraficoLinha;
	
	
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("relpesquisa")
	public RelPesquisaVO createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new RelPesquisaVO();
              this.newEntity();
              
              // inicializando as variveis gráficas
              inicializaVariaveis();
         }

        return (RelPesquisaVO) this.entityPlc;   
        
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("relpesquisaLista")
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
		RelPesquisaVO relPesquisa = (RelPesquisaVO) this.getEntityPlc();
		
		// verificando se informou os dados para o filtro
		Boolean situacaoValida = Boolean.TRUE;
		
		if (null == relPesquisa.getPesquisa()){
			msgUtil.msg(AppBeanMessages.REL_PESQUISA,
					PlcMessage.Cor.msgVermelhoPlc.toString());
			situacaoValida = Boolean.FALSE;
		}
		
		if (null == relPesquisa.getTipoGrafico()){
			msgUtil.msg(AppBeanMessages.REL_TIPO_GRAFICO,
					PlcMessage.Cor.msgVermelhoPlc.toString());	
			situacaoValida = Boolean.FALSE;
		}
		
		// verificando se passou pela validação
		if (situacaoValida){
			// realizando a busca dos dados de acordo com o filtro realizado
			List<PesquisaOpcaoEntity> listaRetorno = facade.findPesquisaOpcaoByPesquisa(contextMontaUtil.createContextParamMinimum(), 
					relPesquisa.getPesquisa().getId());
			 
			// criando o gráfico de acordo com o tipo escolhdido pelo usuario
			switch (relPesquisa.getTipoGrafico()) {
			case BAR:
				criaGraficoBarra(listaRetorno, relPesquisa);
				exibeGraficoBarras = Boolean.TRUE;
				exibeGraficoPizza = Boolean.FALSE;
				exibeGraficoLinha = Boolean.FALSE;
				break;
			case PIZ:
				criaGraficoPizza(listaRetorno, relPesquisa);
				exibeGraficoBarras = Boolean.FALSE;
				exibeGraficoPizza = Boolean.TRUE;
				exibeGraficoLinha = Boolean.FALSE;
				break;
			case LIN:
				criaGraficoLinha(listaRetorno, relPesquisa);
				exibeGraficoBarras = Boolean.FALSE;
				exibeGraficoPizza = Boolean.FALSE;
				exibeGraficoLinha = Boolean.TRUE;
				break;
			}
		} 
		
		return retorno;
	}
	
	
	/**
	 * Realiza a montagem do gráfico de barras
	 * @param listaRetorno
	 * @param relPesquisa 
	 */
	private void criaGraficoBarra(List<PesquisaOpcaoEntity> listaRetorno, RelPesquisaVO relPesquisa) {
		horizontalBarChartModel = initBarModel(listaRetorno, relPesquisa);
		horizontalBarChartModel.setTitle(relPesquisa.getPesquisa().getDescricao());
		horizontalBarChartModel.setAnimate(true);
		horizontalBarChartModel.setLegendPosition("ne");
		
		Axis xAxis = horizontalBarChartModel.getAxis(AxisType.X);
        xAxis.setLabel("Votos");
        xAxis.setMin(0);
         
        Axis yAxis = horizontalBarChartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Opções");
		
	}

	/**
	 * Inserindo os dados no model
	 * @param listaRetorno
	 * @param relPesquisa 
	 * @return
	 */
	private HorizontalBarChartModel initBarModel(List<PesquisaOpcaoEntity> listaRetorno, RelPesquisaVO relPesquisa) {
		HorizontalBarChartModel model = new HorizontalBarChartModel();
		// criando a serie do grafico
		ChartSeries serie = new ChartSeries();
		serie.setLabel("Votos");
		// percorrendo a listagem dos resultados		
		for (PesquisaOpcaoEntity pesquisaOpcao : listaRetorno){
			// inserindo a quantidade de votos para cada opção
			serie.set(pesquisaOpcao.getDescricao(), pesquisaOpcao.getVotos());
		}
		// inserindo no modelo do gráfico
		model.addSeries(serie);	        
        return model;
	}
	
	
	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 */
	private void criaGraficoPizza(List<PesquisaOpcaoEntity> listaRetorno, RelPesquisaVO relPesquisa) {
		pieChartModel = initPieModel(listaRetorno, relPesquisa);	
		pieChartModel.setTitle(relPesquisa.getPesquisa().getDescricao());
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
	private PieChartModel initPieModel(List<PesquisaOpcaoEntity> listaRetorno, RelPesquisaVO relPesquisa) {
		PieChartModel model = new PieChartModel();
		for (PesquisaOpcaoEntity pesquisaOpcao : listaRetorno){
			// inserindo a quantidade de votos para cada opção
			model.set(pesquisaOpcao.getDescricao(), pesquisaOpcao.getVotos());
		}
   
		return model;
	}
	
	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 */
	private void criaGraficoLinha(List<PesquisaOpcaoEntity> listaRetorno, RelPesquisaVO relPesquisa) {
		lineChartModel = initLineModel(listaRetorno, relPesquisa);     
        lineChartModel.setTitle(relPesquisa.getPesquisa().getDescricao());
        lineChartModel.setLegendPosition("e");
        lineChartModel.setShowPointLabels(true);
        lineChartModel.getAxes().put(AxisType.X, new CategoryAxis("Opções"));
        Axis yAxis = lineChartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Votos");
        yAxis.setMin(0);
        //yAxis.setMax(200);

	}
	
	/**
	 * 
	 * @param listaRetorno
	 * @param relTipoStatus
	 * @return
	 */
	private LineChartModel initLineModel(List<PesquisaOpcaoEntity> listaRetorno, RelPesquisaVO relPesquisa) {
		LineChartModel model = new LineChartModel();
		// criando a serie
		ChartSeries  serie = new ChartSeries ();
		serie.setLabel(relPesquisa.getPesquisa().getDescricao());
		
		// percorrendo a listagem dos resultados		
		for (PesquisaOpcaoEntity pesquisaOpcao : listaRetorno){
			serie.set(pesquisaOpcao.getDescricao(), pesquisaOpcao.getVotos() );
		}
		
		// inserindo no modelo do gráfico
		model.addSeries(serie);
				        
        return model;
	}
	
	
	/**
	 * 
	 */
	private void inicializaVariaveis() {
        lineChartModel = new LineChartModel();
        horizontalBarChartModel = new HorizontalBarChartModel();
        pieChartModel = new PieChartModel();
        
        exibeGraficoBarras = Boolean.FALSE;
        exibeGraficoPizza = Boolean.FALSE;
        exibeGraficoLinha = Boolean.FALSE;
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

	/**
	 * @return the horizontalBarChartModel
	 */
	public HorizontalBarChartModel getHorizontalBarChartModel() {
		return horizontalBarChartModel;
	}

	/**
	 * @param horizontalBarChartModel the horizontalBarChartModel to set
	 */
	public void setHorizontalBarChartModel(HorizontalBarChartModel horizontalBarChartModel) {
		this.horizontalBarChartModel = horizontalBarChartModel;
	}		
	
}
