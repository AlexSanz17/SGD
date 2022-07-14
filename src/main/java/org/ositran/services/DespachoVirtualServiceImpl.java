package org.ositran.services;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcRecepcion;

import java.util.List;

import org.ositran.daos.DespachoVirtualDAO;
import org.springframework.transaction.annotation.Transactional;

public class DespachoVirtualServiceImpl implements  DespachoVirtualService{
     private DespachoVirtualDAO despachoVirtualDAO;

    public DespachoVirtualDAO getDespachoVirtualDAO() {
        return despachoVirtualDAO;
    }

    public void setDespachoVirtualDAO(DespachoVirtualDAO despachoVirtualDAO) {
        this.despachoVirtualDAO = despachoVirtualDAO;
    }
    
    @Transactional
    public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho){
         return despachoVirtualDAO.registrarDocumento(despacho);
    }
    @Transactional
    public IotdtcDespacho actualizarDespacho(IotdtcDespacho despacho){
        return despachoVirtualDAO.actualizarDespacho(despacho);
   }
    public IotdtcDespacho findByIdDocumento(Integer iddocumento){
        return despachoVirtualDAO.findByIdDocumento(iddocumento);
   }
    public List<IotdtcDespacho> findVcuoRefObs(Integer iddocumento){
        return despachoVirtualDAO.findVcuoRefObs(iddocumento);
   }
    
    
    public List<IotdtcDespacho> getAll(){
        return despachoVirtualDAO.findAll();
    }
}