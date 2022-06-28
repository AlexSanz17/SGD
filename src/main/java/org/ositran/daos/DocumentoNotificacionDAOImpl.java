package org.ositran.daos;

import javax.persistence.PersistenceContext;

import com.btg.ositran.siged.domain.DocumentoNotificacion;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentoNotificacionDAOImpl implements DocumentoNotificacionDAO{
	@PersistenceContext(unitName="sigedPU")
	
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public void create(DocumentoNotificacion documentoNotificacion) {
		try {
			entityManager.persist(documentoNotificacion);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public DocumentoNotificacion read(Integer idNotificacion) {
		return entityManager.find(DocumentoNotificacion.class,idNotificacion);
	}
	
	@Override
	public void update(DocumentoNotificacion documentoNotificacion) {
		entityManager.merge(documentoNotificacion);
		
	}

	@Override
	public void delete(Integer idNotificacion) {
		entityManager.remove(idNotificacion);
		
	}

}
