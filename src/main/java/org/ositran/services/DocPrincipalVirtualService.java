package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtdDocPrincipal;

public interface DocPrincipalVirtualService {
	public IotdtdDocPrincipal registrarPrincipal(IotdtdDocPrincipal principal);
	public List<IotdtdDocPrincipal> getAll();
}
