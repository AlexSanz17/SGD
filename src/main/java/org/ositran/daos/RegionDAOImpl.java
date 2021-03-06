/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Region;

@Repository
public class RegionDAOImpl implements RegionDAO {
   private static Logger log=Logger.getLogger(RegionDAOImpl.class);

   @PersistenceContext(unitName="sigedPU")
   private EntityManager em ;

    public List<Region> findAll() {
      return getEm().createNamedQuery("Region.findAll")
             .getResultList();
   }

   public Region lisNomdiafestivo(String Nombreregion){
	 
	

         //return getEm().find(Region.class, Nombreregion);
         return (Region) getEm().createNamedQuery("Region.findByNombreregion")
             .setParameter("nombreregion", Nombreregion)
             .getSingleResult();
         
	 
   }

   public Region saveRegion(Region objRegion) {
       if (objRegion.getIdregion() == null) {
         getEm().persist(objRegion); //Nuevo
         getEm().flush();
         getEm().refresh(objRegion);
      } else {
         getEm().merge(objRegion); //Actualizacion
         getEm().flush();
      }

      return objRegion;
   }

    ////////////////////////
    // Getters and Setters
    ////////////////////////
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

  
   
}
