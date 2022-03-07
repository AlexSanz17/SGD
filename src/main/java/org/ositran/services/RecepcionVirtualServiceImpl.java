/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import java.util.List;

import org.ositran.daos.RecepcionVirtualDAO;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public class RecepcionVirtualServiceImpl implements RecepcionVirtualService {    
	RecepcionVirtualDAO recepcionVirtualDAO;

    public RecepcionVirtualDAO getRecepcionVirtualDAO() {
        return recepcionVirtualDAO;
    }

    public void setRecepcionVirtualDAO(RecepcionVirtualDAO recepcionVirtualDAO) {
        this.recepcionVirtualDAO = recepcionVirtualDAO;
    }

    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion){
       return recepcionVirtualDAO.registrarDocumento(recepcion);
    }
    
    public List<IotdtcRecepcion> getAll(){
        return recepcionVirtualDAO.findAll();
     }
    
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV){
        return recepcionVirtualDAO.registrarDocumentoMPV(recepcionMPV);
    }
    
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV(){
       return recepcionVirtualDAO.consultarDocPendientesAlfrescoMPV();
    }
}
