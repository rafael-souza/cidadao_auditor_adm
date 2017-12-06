package br.net.proex.controller.jsf;

import java.util.ArrayList;
import java.util.Date;
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
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/finalizar"),
	selection = @com.powerlogic.jcompany.config.collaboration.PlcConfigSelection(
			pagination = @com.powerlogic.jcompany.config.collaboration.PlcConfigPagination(numberByPage=500))
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("finalizar")
@PlcHandleException
public class FinalizarMB extends AbstractOcorrenciaMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("finalizar")
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
	@Produces  @Named("finalizarLista")
	public PlcEntityList createEntityListPlc() {
		
		if (this.entityListPlc==null) {
			this.entityListPlc = new PlcEntityList();
			this.newObjectList();
		}
		return this.entityListPlc;
	}		
	
	/**
	 * Aqui somente pode ser listado as ocorrências que são de responsabilidade do usuário
	 */
	@Override
	public String search() {
		OcorrenciaEntity ocorrencia = (OcorrenciaEntity) this.getEntityPlc();
		String retorno = "";
		// verificando se possui alguma secretaria associada
		if (getListaIdSecretaria().size() > 0) {
			ocorrencia.setListaSecretaria(getListaIdSecretaria());		
			retorno = super.search();
		}
		
		return retorno;
	}
	
	/**
	 * 
	 */
	public void concluir(){
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
				
				ocorrenciaSel.setObservacaoConclusao(ocorrencia.getObservacaoHistorico());
				ocorrenciaSel.setStatusOcorrencia(StatusOcorrencia.CON);
				ocorrenciaSel.setDataConclusao(new Date());
				ocorrenciaSel.setResponsavelConclusao(userProfileVO.getUsuario().getPessoa().getNome());
				
				// criando o objeto do historico
				HistoricoOcorrenciaEntity historico = criaObjetoHistorico(ocorrenciaSel);		
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
				
				// enviando o e-mail ao cidadão
				sendEmailCidadao(ocorrenciaSel,  "Ocorrência Protocolo: "  + ocorrenciaSel.getProtocolo() + " concluída.", TipoModeloDocumento.CCON);	
				
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
        ((OcorrenciaEntity)this.getEntityPlc()).setStatusOcorrencia(StatusOcorrencia.ENC);
        setListaSelecionados(new ArrayList<OcorrenciaEntity>());
        alimentaListaIdSecretaria();
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
