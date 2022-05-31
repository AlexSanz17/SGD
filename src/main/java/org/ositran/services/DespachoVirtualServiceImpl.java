/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.services;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcRecepcion;

import java.util.List;

import org.ositran.daos.DespachoVirtualDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author consultor_jti15
 */
public class DespachoVirtualServiceImpl implements  DespachoVirtualService{
     private DespachoVirtualDAO despachoVirtualDAO;

    public DespachoVirtualDAO getDespachoVirtualDAO() {
        return despachoVirtualDAO;
    }

    public void setDespachoVirtualDAO(DespachoVirtualDAO despachoVirtualDAO) {
        this.despachoVirtualDAO = despachoVirtualDAO;
    }
    public List<IotdtcDespacho> getAll(){
        return despachoVirtualDAO.findAll();
    }
        
    @Transactional
    public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho){
         return despachoVirtualDAO.registrarDocumento(despacho);
    }
     
}
