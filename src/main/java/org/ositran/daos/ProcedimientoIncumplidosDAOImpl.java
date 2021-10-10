/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Procedimientoincumplido;

@Repository
public class ProcedimientoIncumplidosDAOImpl implements ProcedimientoIncumplidosDAO{
	
	@PersistenceContext(unitName="sigedPU")
	private EntityManager em;
	private static Logger log = Logger.getLogger(ProcedimientoIncumplidosDAOImpl.class);
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public List<Procedimientoincumplido> findAll() {
		return getEm().createNamedQuery("Procedimientoincumplido.findAll").getResultList();
	}

	public void saveObject(Procedimientoincumplido procedimientoincumplido) {
		try {
			em.persist(procedimientoincumplido);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	public List<Procedimientoincumplido> getProcedimientoIncByFiltro(String nombre, String descripcion, Character estado) {
		
		StringBuffer jql = new StringBuffer();
		
		jql.append("select a from Procedimientoincumplido a where 1=1 \n");
		
		if(nombre != null && StringUtils.isNotBlank(nombre)){
			jql.append("and UPPER(a.nombre) LIKE :nombreP \n");
		}
		
		if(descripcion != null && StringUtils.isNotBlank(descripcion)){
			jql.append("and UPPER(a.descripcion) LIKE :descripcionP \n");
		}
		
		if(estado != null){
			jql.append("and a.estado = :estadoP \n");
		}
		
		Query query = em.createQuery(jql.toString());
		
		if(nombre != null && StringUtils.isNotBlank(nombre)){
			query.setParameter("nombreP","%"+nombre.toUpperCase()+"%");
		}
		
		if(descripcion != null && StringUtils.isNotBlank(descripcion)){
			query.setParameter("descripcionP","%"+descripcion.toUpperCase()+"%");
		}
		
		if(estado != null){
			query.setParameter("estadoP", estado);
		}
	
		List list = query.getResultList();
		
		log.debug("list: "+list);
		
		return list;
	}

	public Procedimientoincumplido getProcedimientoById(String idP) {
		return em.find(Procedimientoincumplido.class, new Integer(idP));
	}

	public void updateObject(Procedimientoincumplido procedimientoincumplido) {
		try {
			em.merge(procedimientoincumplido);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	public void deleteObject(Procedimientoincumplido procedimientoincumplido) {
		
		try {
			em.remove(procedimientoincumplido);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}
}