package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

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
import br.net.proex.entity.HistoricoOcorrenciaEntity;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.enumeration.StatusOcorrencia;
import br.net.proex.enumeration.TipoModeloDocumento;

@PlcConfigAggregation(entity = br.net.proex.entity.OcorrenciaEntity.class)
@PlcConfigForm (	
	formPattern=FormPattern.Con,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/encaminhar"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
			pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=500))
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("encaminhar")
@PlcHandleException
public class EncaminharMB extends AbstractOcorrenciaMB  {

	private static final long serialVersionUID = 1L;
	

	
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("encaminhar")
	public OcorrenciaEntity createEntityPlc() {

         if (this.entityPlc==null) {
              this.entityPlc = new OcorrenciaEntity();
              this.newEntity();
              inicializaObjetos();
         }

        return (OcorrenciaEntity) this.entityPlc;   
        
	}
	
	/**
	 * Lista de entidades da ação injetado pela CDI
	*/
	@Produces  @Named("encaminharLista")
	public PlcEntityList createEntityListPlc() {
		
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}		
	
	/**
	 * Realiza o encaminhamento dos registros selecionados
	 */
	public void encaminhar(){
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) this.getEntityPlc();
		
		// inicializando a lista dos itens selecionados
		setListaSelecionados(new ArrayList<OcorrenciaEntity>());
		
		// verificando se informou observação
		if (null == ocorrencia.getObservacaoHistorico() || (null != ocorrencia.getObservacaoHistorico() 
				&& ocorrencia.getObservacaoHistorico().isEmpty())){
			msgUtil.msg(AppBeanMessages.OBSERVACAO_OBRIGATORIO,
					PlcMessage.Cor.msgVermelhoPlc.toString());			
			return;
		}
		
		// pegando a lista das ocorrencias
		List<OcorrenciaEntity> listaOcorrencias = (List<OcorrenciaEntity>) (Object) this.entityListPlc.getItensPlc();
		// verificando se marcou algum imóvel para exportação
		if (verificaMarcados(listaOcorrencias)) {
			
			// carregando os parametros da aplicação para o envio de email
			carregaParametrosAplicacao();
			
			// percorrendo a lista dos registros para realizar o encaminhamento dos que foram selecionados
			for(OcorrenciaEntity ocorrenciaSel : getListaSelecionados()){
				
				ocorrenciaSel = facade.findOcorrenciaById(contextMontaUtil.createContextParamMinimum(), ocorrenciaSel.getId());
				// criando o objeto do historico
				HistoricoOcorrenciaEntity historico = criaObjetoHistorico(ocorrenciaSel);		
				// marcando a ocorrencia como encaminhada
				ocorrenciaSel.setStatusOcorrencia(StatusOcorrencia.ENC);
				historico.setObservacao(ocorrencia.getObservacaoHistorico());
				// verificando se já possui algum registro de historico 
				if (null == ocorrenciaSel.getHistoricoOcorrencia()){
					ocorrenciaSel.setHistoricoOcorrencia(new ArrayList<HistoricoOcorrenciaEntity>());
				}		
				// inserindo o registro no histórico da ocorrência		
				ocorrenciaSel.getHistoricoOcorrencia().add(historico);
				
				this.setEntityPlc(ocorrenciaSel);
				// salvando as alterações
				save();		
				
				// setando a mensagem para enviar no email
				ocorrenciaSel.setObservacaoHistorico(historico.getObservacao());
				
				// enviando o e-mail ao responsável pela ocorrencia
				sendEmailResponsavel(ocorrenciaSel, "Ocorrência Protocolo: "  + ocorrenciaSel.getProtocolo() + " encaminhada para resolução.", TipoModeloDocumento.RENC);
				
				// enviando o e-mail ao cidadão
				sendEmailCidadao(ocorrenciaSel,  "Ocorrência Protocolo: "  + ocorrenciaSel.getProtocolo() + " encaminhada ao responsável", TipoModeloDocumento.CENC);	
				
			}
			
			clearArgs();
			
		} else {
			this.setEntityPlc(ocorrencia);
			msgUtil.msg(AppBeanMessages.SELECIONE_PARA_ENCAMINHAR, PlcMessage.Cor.msgVermelhoPlc.toString());
		}
	}

	/**
	 * Realiza a limpeza dos dados
	 */
	@Override
	public String clearArgs() {
		String retorno = super.clearArgs();
		inicializaObjetos();
		return retorno;
	}

	/**
	 * inicializando os objetos
	 */
	private void inicializaObjetos() {
        ((OcorrenciaEntity)this.getEntityPlc()).setStatusOcorrencia(StatusOcorrencia.ABE);
        setListaSelecionados(new ArrayList<OcorrenciaEntity>());
	}

	/**
	 * Verificando se o usuario marcou alguma ocorrencia
	 * @param listaOcorrencias
	 * @return
	 */
	private Boolean verificaMarcados(List<OcorrenciaEntity> listaOcorrencias) {
		// variavel que indica se foi selecionado algo
		Boolean selecionado = Boolean.FALSE;
		// verificando se clicou no botão pesquisar
		if (null != listaOcorrencias && listaOcorrencias.size() > 0) {
			// percorrendo a lista para armazenar os marcados
			for (OcorrenciaEntity ocorrencia : listaOcorrencias) {
				if (null != ocorrencia.getSelecionado() && ocorrencia.getSelecionado()) {
					selecionado = Boolean.TRUE;
					getListaSelecionados().add(ocorrencia);
				}
			}
		} 
		// retorna se selecionou algum imóvel
		return selecionado;
	}

}
