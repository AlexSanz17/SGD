/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Tipoacceso;

@Repository
public class TipoaccesoDAOImpl implements TipoaccesoDAO {

   private EntityManager em;

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
   public List<Tipoacceso> findAll() {
      return getEm().createNamedQuery("Tipoacceso.findAll")
             .getResultList();
   }

   public Tipoacceso buscarObjPor(String sCodigo) {
      return (Tipoacceso) em.createNamedQuery("Tipoacceso.findByCodigo")
             .setParameter("codigo", sCodigo)
             .getSingleResult();
   }

   public Tipoacceso buscarObjPorID(Integer iIdTipoAcceso) {
      return em.find(Tipoacceso.class, iIdTipoAcceso);
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
