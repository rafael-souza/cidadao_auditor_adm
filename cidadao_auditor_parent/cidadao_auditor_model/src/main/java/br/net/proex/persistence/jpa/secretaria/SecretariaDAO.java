package br.net.proex.persistence.jpa.secretaria;

import br.net.proex.persistence.jpa.AppJpaDAO;
import br.net.proex.entity.SecretariaEntity;


import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;

/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(SecretariaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class SecretariaDAO extends AppJpaDAO  {

	
}
