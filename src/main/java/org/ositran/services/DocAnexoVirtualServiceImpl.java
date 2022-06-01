package org.ositran.services;

import java.util.List;

import org.ositran.daos.DocAnexoVirtualDAO;

import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;

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
	public List<IotdtdAnexo> getAll(){
        return docAnexoVirtualDAO.findAll();
	}
}
