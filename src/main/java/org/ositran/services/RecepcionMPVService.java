package org.ositran.services;

import java.util.Date;
import java.util.List;

import org.ositran.ajax.beans.CargoRecepcionMPVRequest;
import org.ositran.ajax.beans.CargoRecepcionMPVResponse;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public interface RecepcionMPVService {
	public List<IotdtcRecepcion> getAll();		
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);    
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV);
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV();
    public void rechazarDocumentoMPV(Integer idDocumento, String observacion, String estado, Date fecha, String usuario);
    public CargoRecepcionMPVResponse enviarCargo(CargoRecepcionMPVRequest cargoRecepcionMPVRequest);
}