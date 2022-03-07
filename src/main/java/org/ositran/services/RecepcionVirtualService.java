package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public interface RecepcionVirtualService {
	public List<IotdtcRecepcion> getAll();		
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);    
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV);
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV();
}
