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
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
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
	@SuppressWarnings("unchecked")
	@Override
	
	public List<IotdtdAdjuntoMPV> buscarAnexoPorIdRecepcion(Integer idRecepcion) {
		List<IotdtdAdjuntoMPV> iotdtdAdjuntoMPV = null;
		try {
			iotdtdAdjuntoMPV = entityManager.createQuery("select e from IotdtdAdjuntoMPV e,IotdtcRecepcionMPV f  where  e.recepcion.sidrecext = f.sidrecext and e.tipoArchivo = 2 and f.sidrecext = :idRecepcion")
					.setParameter("idRecepcion", idRecepcion)
				.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return iotdtdAdjuntoMPV;
	}
//	SELECT i FROM IotdtmDocExternoPIDE i, IotdtcDespachoPIDE j where i.sidemiext.sidemiext = j.sidemiext and j.sidemiext = :sidemiext
//	SELECT
//	TIPOARCHIVO,
//	IDRECEPCION
//	, RUTAARCHIVO
//	, NOMBREARCHIVO
//	FROM IOTDTD_ADJUNTO_MPV
//	WHERE IDRECEPCION = 15101
//	AND TIPOARCHIVO = 2
	
	
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