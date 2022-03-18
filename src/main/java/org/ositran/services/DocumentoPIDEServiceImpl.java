/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import java.util.List;

import org.ositran.daos.DocumentoPIDEDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

public class DocumentoPIDEServiceImpl implements DocumentoPIDEService {
	@Autowired(required=false)
	DocumentoPIDEDAO documentoPIDEDAO;

	public DocumentoPIDEDAO getDocumentoPIDEDAO() {
		return documentoPIDEDAO;
	}

	public void setDocumentoPIDEDAO(DocumentoPIDEDAO documentoPIDEDAO) {
		this.documentoPIDEDAO = documentoPIDEDAO;
	}

	@Override
	public List<IotdtcRecepcionPIDE> getAllRecepcion() {
		return documentoPIDEDAO.findAllRecepcion();
	}

	@Override
	public List<IotdtcDespachoPIDE> getAllDespacho() {
		return documentoPIDEDAO.findAllDespacho();
	}

	@Override
	public List<IotdtmDocExternoPIDE> getAllDocExterno() {
		return documentoPIDEDAO.findAllDocExterno();
	}

	@Override
	public List<IotdtdDocPrincipalPIDE> getAllDocPrincipal() {
		return documentoPIDEDAO.findAllDocPrincipal();
	}

	@Override
	public List<IotdtdAnexoPIDE> getAllAnexo() {
		return documentoPIDEDAO.findAllAnexo();
	}

}
