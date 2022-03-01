/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import org.ositran.ajax.beans.CargoRecepcionMPVRequest;
import org.ositran.ajax.beans.CargoRecepcionMPVResponse;

import com.btg.ositran.siged.domain.IotdtcRecepcion;

public interface RecepcionVirtualService {
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);
    
    public CargoRecepcionMPVResponse enviarCargoRecepcion(CargoRecepcionMPVRequest cargoRecepcionVirtualRequest);
}
