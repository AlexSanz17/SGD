package org.ositran.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.ositran.daos.TipoprocesoDAO;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Tipoproceso;

public class TipoprocesoServiceImpl implements TipoprocesoService {

   private TipoprocesoDAO dao;

   //////////////////////////////////
   // Constructors                 //
   //////////////////////////////////
   public TipoprocesoServiceImpl(TipoprocesoDAO dao) {
      setDao(dao);
   }

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
   public Map<Integer, String> getTipoProcesoMap() {
      Map<Integer, String> mapAux = new LinkedHashMap<Integer, String>();
      List<Tipoproceso> lstTP = getDao().findAll();

      for (Tipoproceso objTP : lstTP) {
         mapAux.put(objTP.getIdtipoproceso(), objTP.getNombre());
      }

      return mapAux;
   }

   public Tipoproceso buscarObjPor(String sNombre) {
      return dao.buscarObjPor(sNombre);
   }

   public Tipoproceso findById(Integer iIdTipoProceso) {
      return dao.findById(iIdTipoProceso);
   }

   //////////////////////////////////
   // Getters and Setters          //
   //////////////////////////////////
   public TipoprocesoDAO getDao() {
      return dao;
   }

   public void setDao(TipoprocesoDAO dao) {
      this.dao = dao;
   }
}
