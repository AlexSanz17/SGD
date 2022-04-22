package org.ositran.daos;

import java.util.Date;
import java.util.List;

import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public interface RecepcionMPVDAO {
	public IotdtcRecepcionMPV registrarDocumento(IotdtcRecepcionMPV recepcionMPV);
    public void rechazarDocumento(Integer idDocumento, String observacion, String estado, Date fecha, String usuario);
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV();
}