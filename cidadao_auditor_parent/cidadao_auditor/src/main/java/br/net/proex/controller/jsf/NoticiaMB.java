package br.net.proex.controller.jsf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.net.proex.entity.NoticiaEntity;
import br.net.proex.utils.DateTimeUtils;

@PlcConfigAggregation(entity = br.net.proex.entity.NoticiaEntity.class)
@PlcConfigForm (	
	formPattern=FormPattern.Man,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/noticia")
)

/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("noticia")
@PlcHandleException
public class NoticiaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("noticia")
	public NoticiaEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new NoticiaEntity();
              this.newEntity();
        }
        return (NoticiaEntity)this.entityPlc;     	
	}
	
	
	/**
	 * 
	 */
	@Override
	public String save() {
		NoticiaEntity noticia = (NoticiaEntity)this.getEntityPlc();
		
		// verificando se informou a data da noticia para colocar a hora na mesma
		if (null == noticia.getId() && null != noticia.getDataNoticia()){
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date hora = Calendar.getInstance().getTime();
			String dataFormatada = sdf.format(hora);
			
			noticia.setDataNoticia(DateTimeUtils.setTimeInDate(noticia.getDataNoticia(), dataFormatada));
			
		}
		
		
		return super.save();
	}
		
}
