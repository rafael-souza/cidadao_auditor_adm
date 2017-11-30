package br.net.proex.facade;

import java.util.List;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.facade.IPlcFacade;

import br.net.proex.entity.DenunciaEntity;
import br.net.proex.entity.OcorrenciaEntity;
import br.net.proex.entity.PessoaEntity;
import br.net.proex.entity.PrefeituraEntity;
import br.net.proex.entity.SecretariaEntity;
import br.net.proex.entity.SugestaoEntity;
import br.net.proex.entity.TipoOcorrenciaEntity;
import br.net.proex.entity.seg.SegMenuEntity;
import br.net.proex.entity.seg.SegPerfilEntity;
import br.net.proex.entity.seg.SegUsuarioEntity;
import br.net.proex.entity.vo.RelChartModelTipoStatusVO;
import br.net.proex.entity.vo.RelTipoStatusVO;
import br.net.proex.enumeration.TipoModeloDocumento;

public interface IAppFacade extends IPlcFacade{
	
	SegUsuarioEntity findUsuarioByLogin(PlcBaseContextVO context, String login);
	
	SegPerfilEntity findByPerfil(PlcBaseContextVO context, SegPerfilEntity perfil);	
	
	List<SegMenuEntity> findMenus(PlcBaseContextVO context);
	
	SegUsuarioEntity recuperaUsuario(PlcBaseContextVO context, SegUsuarioEntity usuario);

	PrefeituraEntity findPrefeituraById(PlcBaseContextVO context, Long id);

	PessoaEntity findPessoaByEmail(PlcBaseContextVO context, String email);

	List<OcorrenciaEntity> findOcorrenciaPorPessoa(PlcBaseContextVO context, Long id);

	OcorrenciaEntity findOcorrenciaById(PlcBaseContextVO context, Long id);

	List<SugestaoEntity> buscarSugestaoPorProtocolo(PlcBaseContextVO context, String protocolo);

	List<DenunciaEntity> buscarDenunciaPorProtocolo(PlcBaseContextVO context,String protocolo);

	TipoOcorrenciaEntity findTipoOcorrenciaById(PlcBaseContextVO context, Long idTipo);

	List<RelChartModelTipoStatusVO> relTipoStatus(PlcBaseContextVO context, RelTipoStatusVO relTipoStatus);

	List<TipoOcorrenciaEntity> buscaTipoPorSecretaria(PlcBaseContextVO context, List<Long> listaIdSecretaria);

	PessoaEntity findPessoaById(PlcBaseContextVO context, Long id);

	List<TipoOcorrenciaEntity> findTipoOcorrenciaPorSecretaria(PlcBaseContextVO context, SecretariaEntity secretaria);

	String findModeloDocumentoPorTipo(PlcBaseContextVO context, TipoModeloDocumento modelo);
	
}
