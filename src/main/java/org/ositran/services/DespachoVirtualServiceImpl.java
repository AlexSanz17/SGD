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
    
    public List<IotdtcDespacho> getAll(){
        return despachoVirtualDAO.findAll();
    }
}