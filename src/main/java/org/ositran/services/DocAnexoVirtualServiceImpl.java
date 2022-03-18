package org.ositran.services;

import org.ositran.daos.DocAnexoVirtualDAO;

import com.btg.ositran.siged.domain.IotdtdAnexo;

public class DocAnexoVirtualServiceImpl implements DocAnexoVirtualService {
	DocAnexoVirtualDAO docAnexoVirtualDAO;
	
	public DocAnexoVirtualDAO getDocAnexoVirtualDAO() {
		return docAnexoVirtualDAO;
	}

	public void setDocAnexoVirtualDAO(DocAnexoVirtualDAO docAnexoVirtualDAO) {
		this.docAnexoVirtualDAO = docAnexoVirtualDAO;
	}

	@Override
	public IotdtdAnexo registrarAnexo(IotdtdAnexo anexo) {
		return docAnexoVirtualDAO.registrarAnexo(anexo);
	}
}
