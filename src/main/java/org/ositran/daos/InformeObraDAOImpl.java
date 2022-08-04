package org.ositran.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.InformeObra;
@Repository
public class InformeObraDAOImpl implements InformeObraDAO{
	@PersistenceContext(unitName = "sigedPU")
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

    @Override
    public void create(InformeObra informeObra) {
        entityManager.persist(informeObra);
    }

    @Override
    public InformeObra read(Integer idInformeObra) {
        return entityManager.find(InformeObra.class, idInformeObra);
    }
    
    @Override
    public void update(InformeObra informeObra) {
        entityManager.merge(informeObra);
    }

    @Override
    public void delete(Integer idInformeObra) {
    	entityManager.remove(idInformeObra);
    }	

}
