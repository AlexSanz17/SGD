package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtmDocExterno;

public interface DocExternoVirtualService {
	public IotdtmDocExterno registrarDocumento(IotdtmDocExterno docExterno);
	public List<IotdtmDocExterno> getAll();
}
