package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

public interface DocExternoVirtualService {
	public IotdtmDocExterno registrarDocumento(IotdtmDocExterno docExterno);
	public List<IotdtmDocExterno> getAll();
	public List<IotdtmDocExterno> findSiddocextToMigrate(Integer sidreccext);
	public List<IotdtcDespacho> findVcuoRefObs(Integer iddocumento);
}
