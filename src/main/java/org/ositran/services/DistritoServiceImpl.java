/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.services;

import java.util.List;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import org.ositran.daos.DistritoDAO;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Distrito;

public class DistritoServiceImpl implements DistritoService {

   private static Logger log = Logger.getLogger(DistritoServiceImpl.class);
   private DistritoDAO dao;

   /*
    * Constructors
    */
   public DistritoServiceImpl(DistritoDAO dao) {
      this.dao = dao;
   }

   /*
    * Methods
    */
   public List<Distrito> findAll() {
      return dao.buscarTodo();
   }

   public Distrito findById(Integer iIdDistrito) {
      try {
         return dao.findById(iIdDistrito);
      } catch (NoResultException nre) {
         log.warn("No se encontro ningun distrito con ID [" + iIdDistrito + "]");

         return null;
      }

   }

   @Transactional
   public Distrito guardarObj(Distrito objDistrito, char cMode) {
      return dao.guardarObj(objDistrito, cMode);
   }

   public List<Distrito> findLstBy(Integer iIdProvincia) {
      return dao.findByProvincia(iIdProvincia);
   }

   /*
    * Getters & Setters
    */
   public DistritoDAO getDao() {
      return dao;
   }

   public void setDao(DistritoDAO dao) {
      this.dao = dao;
   }
}
