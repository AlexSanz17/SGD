package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.ositran.utils.Constantes;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.IotdtdAdjuntoMPV;

@Repository
public class AdjuntoMPVDAOImpl implements AdjuntoMPVDAO {
	@PersistenceContext(unitName = "sigedPU")
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<IotdtdAdjuntoMPV> buscarTodos() {
		return entityManager.createNamedQuery("IotdtdAdjuntoMPV.buscarTodos")
			.getResultList();
	}
	
	@Override
	public IotdtdAdjuntoMPV buscarPorIdAdjunto(Integer idAdjunto) {
		return (IotdtdAdjuntoMPV) entityManager.createNamedQuery("IotdtdAdjuntoMPV.buscarPorIdAdjunto").setParameter("idAdjunto", idAdjunto)
			.getSingleResult();
	}
	
	@Override
	public Integer buscarNumFoliosPorIdRecepcion(Integer idRecepcion, Integer tipoArchivo) {
		Integer objArchivo = null;
		try {
			objArchivo = (Integer) entityManager.createNamedQuery("IotdtdAdjuntoMPV.buscarNumFoliosPorIdRecepcion")
					.setParameter("idRecepcion", idRecepcion).setParameter("tipoArchivo", tipoArchivo)
					.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
//			_log.error(e.getMessage());
		}
		return objArchivo;
	}
	private static Logger log = Logger.getLogger(AdjuntoMPVDAOImpl.class);
	@Override
	public Integer buscarNumFoliosTotalesPorIdRecepcion(Integer idRecepcion) {
		Integer objArchivo = null;
		try {
			log.info("buscarNumFoliosTotalesPorIdRecepcion.............." + entityManager.createNamedQuery("IotdtdAdjuntoMPV.buscarNumFoliosTotalesPorIdRecepcion")
			.setParameter("idRecepcion", idRecepcion)
			.getSingleResult() + " class........" + entityManager.createNamedQuery("IotdtdAdjuntoMPV.buscarNumFoliosTotalesPorIdRecepcion")
			.setParameter("idRecepcion", idRecepcion)
			.getSingleResult().getClass());
			objArchivo = Integer.valueOf(entityManager.createNamedQuery("IotdtdAdjuntoMPV.buscarNumFoliosTotalesPorIdRecepcion")
					.setParameter("idRecepcion", idRecepcion)
					.getSingleResult().toString());
		} catch (NoResultException e) {
			e.printStackTrace();
//			_log.error(e.getMessage());
		}
		return objArchivo;
	}
}