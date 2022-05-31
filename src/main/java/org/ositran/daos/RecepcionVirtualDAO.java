package org.ositran.daos;

import java.util.Date;
import java.util.List;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public interface RecepcionVirtualDAO {
     public String findByCantidadesDocumentosVirtuales();
     public List<IotdtcRecepcion> findAll();     
     public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);
     public IotdtcRecepcion findByIdDoc(Integer iddocumento);
     public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV);
     public void rechazarDocumentoMPV(Integer idDocumento, String observacion, String estado, Date fecha, String usuario);
     public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV();
}