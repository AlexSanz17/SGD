package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

public class DocumentoPIDEDAOImpl implements DocumentoPIDEDAO {
	@PersistenceContext(unitName="pidePU")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<IotdtcRecepcionPIDE> findAllRecepcion() {
		Query query = entityManager.createNamedQuery("IotdtcRecepcionPIDE.findAll");
		return query.getResultList();
	}

	@Override
	public List<IotdtcDespachoPIDE> findAllDespacho() {
		Query query = entityManager.createNamedQuery("IotdtcDespachoPIDE.findAll");
		return query.getResultList();
	}

	@Override
	public List<IotdtmDocExternoPIDE> findAllDocExterno() {
		Query query = entityManager.createNamedQuery("IotdtmDocExternoPIDE.findAllRecepcion");
		return query.getResultList();
	}

	@Override
	public List<IotdtdDocPrincipalPIDE> findAllDocPrincipal() {
		Query query = entityManager.createNamedQuery("IotdtdDocPrincipalPIDE.findAllRecepcion");
		return query.getResultList();
	}

	@Override
	public List<IotdtdAnexoPIDE> findAllAnexo() {
		Query query = entityManager.createNamedQuery("IotdtdAnexoPIDE.findAllRecepcion");
		return query.getResultList();
	}

}
