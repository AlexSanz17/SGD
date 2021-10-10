/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.ositran.utils.Constantes;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Distrito;

@Repository
public class DistritoDAOImpl implements DistritoDAO {

   private EntityManager em;

   public List<Distrito> buscarTodo() {
      return em.createNamedQuery("Distrito.findAll")
               .getResultList();
   }

   public List<Distrito> findByProvincia(Integer iIdProvincia) {
      String sQuery = "SELECT NEW Distrito(" +
                      "d.iddistrito," +
                      "d.nombre" +
                      ") ";
      sQuery += "FROM Distrito d ";
      sQuery += "LEFT JOIN d.provincia p ";
      sQuery += "WHERE p.idprovincia = :idprovincia ";
      sQuery += "ORDER BY d.nombre ASC";

      Query qQuery = em.createQuery(sQuery)
                       .setParameter("idprovincia", iIdProvincia);

      return qQuery.getResultList();
   }

   public Distrito findById(Integer idDistrito) {
      return em.find(Distrito.class, idDistrito);
   }

   public Distrito guardarObj(Distrito objDistrito, char cMode) {
      if (cMode == Constantes.OPERACION_CREATE) {
         em.persist(objDistrito);
         em.flush();
         em.refresh(objDistrito);
      } else if (cMode == Constantes.OPERACION_UPDATE) {
         em.merge(objDistrito);
         em.flush();
      }

      return objDistrito;
   }

   public EntityManager getEm() {
      return em;
   }

   @PersistenceContext(unitName = "sigedPU")
   public void setEm(EntityManager em) {
      this.em = em;
   }
}
