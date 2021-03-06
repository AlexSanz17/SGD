/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Gridcolumnaxusuario;

@Repository
public class GridcolumnaxusuarioDAOImpl implements GridcolumnaxusuarioDAO{
	
	private EntityManager em;
	private static Logger log=Logger.getLogger(GridcolumnaxusuarioDAOImpl.class);

	// ////////////////////////////////
	// Methods //
	// ////////////////////////////////
	@SuppressWarnings("unchecked")
	public List<Gridcolumnaxusuario> findByIdUsuario(Integer iIdUsuario){
		return em.createNamedQuery("Gridcolumnaxusuario.findByIdusuario").setParameter("idusuario",iIdUsuario).getResultList();
	}

	@PersistenceContext(unitName="sigedPU")
	public void setEm(EntityManager em){
		this.em=em;
	}

	@Override
	public void guardar(Gridcolumnaxusuario gridColumnaPorUsuario){
		if(gridColumnaPorUsuario.getGridcolumnaxusuarioPK()==null){
			em.persist(gridColumnaPorUsuario);
			em.flush();
			em.refresh(gridColumnaPorUsuario);
		}else{
			em.merge(gridColumnaPorUsuario);
			em.flush();
		}
	}

	@Override
	public Gridcolumnaxusuario find(int idUsuario,int idGridColumna){
		Gridcolumnaxusuario grid=null;
		try{
			grid=(Gridcolumnaxusuario) em.createNamedQuery("Gridcolumnaxusuario.find").setParameter("idUsuario",idUsuario).setParameter("idGridColumna",idGridColumna).getSingleResult();
		}catch(NoResultException e){
			log.warn("No se encontro informacion de columnas de grid para el usuario con id: "+idUsuario);
		}
		return grid;
	}

	@Override
	public Gridcolumnaxusuario findById(int idUsuario){
		Gridcolumnaxusuario grid=null;
		try{
			grid=(Gridcolumnaxusuario) em.createNamedQuery("Gridcolumnaxusuario.findByIdusuario").setParameter("idusuario",idUsuario).getSingleResult();
		}catch(NoResultException e){
			log.warn("No se encontro informacion de columnas de grid para el usuario con id: "+idUsuario);
		}
		return grid;
	}
}
