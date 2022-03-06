/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

//<<<<<<< HEAD
import org.ositran.ajax.beans.CargoRecepcionMPVRequest;
import org.ositran.ajax.beans.CargoRecepcionMPVResponse;
//=======
import java.util.List;
//>>>>>>> 70ff14af92bcff9a7a59d61735c56e9bbb862597

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtcRecepcionSchemaIdsgd;

public interface RecepcionVirtualService {
	
	List<IotdtcRecepcion> getAll();
	
	
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);
//<<<<<<< HEAD
    
    public CargoRecepcionMPVResponse enviarCargoRecepcion(CargoRecepcionMPVRequest cargoRecepcionVirtualRequest);
//=======
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV);
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV();
//>>>>>>> 70ff14af92bcff9a7a59d61735c56e9bbb862597
}
