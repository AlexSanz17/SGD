/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*LICENCIA DE USO DEL SGD .TXT*/
package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.btg.ositran.siged.domain.IotdtcRecepcionSchemaIdsgd;

public class RecepcionVirtualMpvDAOImpl implements RecepcionVirtualMpvDAO {
	private EntityManager em;

	@PersistenceContext(unitName = "interoperabilidad")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<IotdtcRecepcionSchemaIdsgd> findAll() {

		Query query = em.createNamedQuery("IotdtcRecepcionSchemaIdsgd.findAll");
		return query.getResultList();

	}

}
