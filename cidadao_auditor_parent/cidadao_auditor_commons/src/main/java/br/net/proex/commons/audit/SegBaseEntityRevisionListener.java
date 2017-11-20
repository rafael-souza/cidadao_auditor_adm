package br.net.proex.commons.audit;

import org.apache.log4j.Logger;
import org.hibernate.envers.RevisionListener;
import org.jboss.weld.context.ContextNotActiveException;

import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefaultLiteral;
import com.powerlogic.jcompany.commons.util.cdi.PlcCDIUtil;

import br.net.proex.commons.AppUserProfileVO;
import br.net.proex.entity.seg.SegBaseEntityRevision;

/**
 * Listener que insere informações na entidade de revisão nas operaçõees de persistência
 * 
 * @author Rafael Souza
 *
 */
public class SegBaseEntityRevisionListener implements RevisionListener {
 
	protected static Logger log = Logger.getLogger(SegBaseEntityRevisionListener.class.getCanonicalName());
	
	public void newRevision(Object revisionEntity) {
 
        SegBaseEntityRevision baseEntityRevision = (SegBaseEntityRevision) revisionEntity;
       
        AppUserProfileVO profile = PlcCDIUtil.getInstance().getInstanceByType(AppUserProfileVO.class, QPlcDefaultLiteral.INSTANCE);      
        
        
        if (profile != null && profile.getLogin() != null){
			try {
				baseEntityRevision.setUsuarioUltAlteracao(profile.getLogin());
			} catch (ContextNotActiveException e) {
				//se deu erro é porque esta inicializando o banco
				baseEntityRevision.setUsuarioUltAlteracao("sistema");
			}
		}	
 
	}
 
}