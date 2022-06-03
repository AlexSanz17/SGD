/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import java.util.List;

import org.ositran.daos.DocumentoPIDEDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

@Service
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
	public IotdtcRecepcionPIDE getRecepcionByVcuo(String vcuo) {
		return documentoPIDEDAO.findRecepcionByVcuo(vcuo);
	}
	public IotdtcRecepcionPIDE updateIotdtcRecepcionPIDE(IotdtcRecepcionPIDE objIotdtcRecepcionPIDE) {
		return documentoPIDEDAO.updateIotdtcRecepcionPIDE(objIotdtcRecepcionPIDE);
	}


	@Override
	public List<IotdtcDespachoPIDE> getAllDespacho() {
		return documentoPIDEDAO.findAllDespacho();
	}
	public IotdtcDespachoPIDE getDespachoByVcuo(String vcuo) {
		return documentoPIDEDAO.getDespachoByVcuo(vcuo);
	}
	@Override
	@Transactional
	public IotdtcDespachoPIDE updateIotdtcDespachoPIDE(IotdtcDespachoPIDE objIotdtcDespachoPIDE) {
		return documentoPIDEDAO.updateIotdtcDespachoPIDE(objIotdtcDespachoPIDE);
	}

	@Override
	public List<IotdtmDocExternoPIDE> getAllDocExterno() {
		return documentoPIDEDAO.findAllDocExterno();
	}
	
	public IotdtmDocExternoPIDE updateIotdtmDocExternoPIDE(IotdtmDocExternoPIDE objIotdtmDocExternoPIDE) {
		return documentoPIDEDAO.updateIotdtmDocExternoPIDE(objIotdtmDocExternoPIDE);
	}
	public IotdtmDocExternoPIDE getDocExternoByCuo(String vcuo) {
		return documentoPIDEDAO.getDocExternoByCuo(vcuo);
	}
	

	@Override
	public List<IotdtdDocPrincipalPIDE> getAllDocPrincipal() {
		return documentoPIDEDAO.findAllDocPrincipal();
	}
	public IotdtdDocPrincipalPIDE getDocPrincipalByCuo(String vcuo) {
		return documentoPIDEDAO.getDocPrincipalByCuo(vcuo);
	}
	public IotdtdDocPrincipalPIDE updateIotdtdDocPrincipalPIDE(IotdtdDocPrincipalPIDE objIotdtdDocPrincipalPIDE) {
		return documentoPIDEDAO.updateIotdtdDocPrincipalPIDE(objIotdtdDocPrincipalPIDE);
	}

	@Override
	public List<IotdtdAnexoPIDE> getAllAnexo() {
		return documentoPIDEDAO.findAllAnexo();
	}
	public IotdtdAnexoPIDE getAnexoByCuo(String vcuo) {
		return documentoPIDEDAO.getAnexoByCuo(vcuo);
	}
	public IotdtdAnexoPIDE updateIotdtdAnexoPIDE(IotdtdAnexoPIDE objIotdtdAnexoPIDE) {
		return documentoPIDEDAO.updateIotdtdAnexoPIDE(objIotdtdAnexoPIDE);
	}

}
