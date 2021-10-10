package org.ositran.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.util.Logger;
import org.ositran.daos.GrupoprocesoDAO;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Grupoproceso;

public class GrupoprocesoServiceImpl implements GrupoprocesoService {

   private GrupoprocesoDAO dao;
   private static Logger _log = Logger.getLogger(GrupoprocesoServiceImpl.class);
   //////////////////////////////////
   // Constructors                 //
   //////////////////////////////////

   public GrupoprocesoServiceImpl(GrupoprocesoDAO dao) {
      this.dao = dao;
   }

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
   public Grupoproceso buscarObjPor(String sCodigo) {
      return dao.buscarObjPor(sCodigo);
   }

   public Grupoproceso buscarObjPorId(Integer iIdGrupoproceso) {
      return dao.buscarObjPorId(iIdGrupoproceso);
   }

   @Transactional
   public Grupoproceso guardarObj(Grupoproceso objGrupoProceso) {
      return dao.guardarObj(objGrupoProceso);
   }

   public List<Grupoproceso> findAll() {
      return dao.findAll();
   }

   public Map<Integer, String> getMapAll() {
      Map<Integer, String> mapGrupoproceso = new HashMap<Integer, String>();

      List<Grupoproceso> lstGrupoproceso = this.findAll();
      _log.debug("listaaaaaaaaa2: " + (lstGrupoproceso != null ? lstGrupoproceso.size() : "nulll"));

      for (Grupoproceso objGrupoproceso : lstGrupoproceso) {
         mapGrupoproceso.put(objGrupoproceso.getIdgrupoproceso(), objGrupoproceso.getNombre());
         _log.debug("putting  in map:" + objGrupoproceso.getIdgrupoproceso() + " , " + objGrupoproceso.getNombre());

      }

      _log.debug("listaaaaaaaaa3: " + mapGrupoproceso.size());

      return mapGrupoproceso;
   }

   //////////////////////////////////
   // Getters and Setters          //
   //////////////////////////////////
   public GrupoprocesoDAO getDao() {
      return dao;
   }

   public void setDao(GrupoprocesoDAO dao) {
      this.dao = dao;
   }
}
