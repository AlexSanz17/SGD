package org.ositran.services;

import org.ositran.daos.DocPrincipalVirtualDAO;

import com.btg.ositran.siged.domain.IotdtdDocPrincipal;

public class DocPrincipalVirtualServiceImpl implements DocPrincipalVirtualService {
	DocPrincipalVirtualDAO docPrincipalVirtualDAO;
	
	public DocPrincipalVirtualDAO getDocPrincipalVirtualDAO() {
		return docPrincipalVirtualDAO;
	}
	
	public void setDocPrincipalVirtualDAO(DocPrincipalVirtualDAO docPrincipalVirtualDAO) {
		this.docPrincipalVirtualDAO = docPrincipalVirtualDAO;
	}

	@Override
	public IotdtdDocPrincipal registrarPrincipal(IotdtdDocPrincipal principal) {
		return docPrincipalVirtualDAO.registrarPrincipal(principal);
	}
}
