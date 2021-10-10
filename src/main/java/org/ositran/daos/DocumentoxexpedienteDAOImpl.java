/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Documentoxexpediente;

@Repository
public class DocumentoxexpedienteDAOImpl implements DocumentoxexpedienteDAO {

   private EntityManager em;

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
   public Documentoxexpediente guardarObj(Documentoxexpediente objDocXExp) {
      if (objDocXExp.getDocumentoxexpedientePK() == null) {
         em.persist(objDocXExp);
         em.flush();
         em.refresh(objDocXExp);
      } else {
         em.merge(objDocXExp);
         em.flush();
      }

      return objDocXExp;
   }

   //////////////////////////////////
   // Getters and Setters          //
   //////////////////////////////////
   public EntityManager getEm() {
      return em;
   }

   @PersistenceContext(unitName="sigedPU")
   public void setEm(EntityManager em) {
      this.em = em;
   }
}
