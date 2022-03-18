package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public interface RecepcionVirtualDAO {
     public String findByCantidadesDocumentosVirtuales();
     public List<IotdtcRecepcion> findAll();     
     public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);
     public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV);
     public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV();
}
