package org.ositran.services;

import java.util.List;

import org.ositran.daos.DocPrincipalVirtualDAO;

import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

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
	public List<IotdtdDocPrincipal> getAll(){
        return docPrincipalVirtualDAO.findAll();
	}
}
