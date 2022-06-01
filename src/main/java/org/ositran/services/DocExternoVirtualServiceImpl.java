package org.ositran.services;

import java.util.List;

import javax.persistence.Query;

import org.ositran.daos.DocumentoExternoVirtualDAO;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

public class DocExternoVirtualServiceImpl implements DocExternoVirtualService{
	DocumentoExternoVirtualDAO docExternoVirtualDAO;
	
	public DocumentoExternoVirtualDAO getDocExternoVirtualDAO() {
		return docExternoVirtualDAO;
	}

	public void setDocExternoVirtualDAO(DocumentoExternoVirtualDAO docExternoVirtualDAO) {
		this.docExternoVirtualDAO = docExternoVirtualDAO;
	}

	@Override
	public IotdtmDocExterno registrarDocumento(IotdtmDocExterno docExterno) {
		return docExternoVirtualDAO.registrarDocumento(docExterno);
	}
	
	public List<IotdtmDocExterno> getAll(){
	        return docExternoVirtualDAO.findAll();
    }
	
}
