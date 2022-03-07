package org.ositran.siged.jobs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;

@Repository
public class RecepcionPideDaoForJob {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext(unitName = "sigedPU")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("rawtypes")
	public IotdtcRecepcion getAllt() {
		Query query = em.createNamedQuery("IotdtcRecepcion.findAll");

		List results = query.getResultList();

		System.out.println("OBTENER RECEPCION");
		System.out.println(results.size());

		if (!results.isEmpty()) {
			System.out.println(results.get(0));

			return (IotdtcRecepcion) results.get(0);
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	public IotdtcRecepcionPIDE getAllSchemaIdosgd() {
		Query query = em.createNamedQuery("IotdtcRecepcionPIDE.findAll");

		List results = query.getResultList();

		System.out.println("OBTENER RECEPCION");
		System.out.println(results.size());

		if (!results.isEmpty()) {
			System.out.println(results.get(0));

			return (IotdtcRecepcionPIDE) results.get(0);
		}

		return null;
	}

}
