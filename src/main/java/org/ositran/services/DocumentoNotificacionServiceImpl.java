package org.ositran.services;

import org.ositran.daos.DocumentoNotificacionDAO;

import com.btg.ositran.siged.domain.DocumentoNotificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentoNotificacionServiceImpl implements DocumentoNotificacionService{
	@Autowired(required=false)
	private DocumentoNotificacionDAO documentoNotificacionDAO;
	
	public DocumentoNotificacionDAO getDocumentoNotificacionDAO() {
		return documentoNotificacionDAO;
	}

	public void setDocumentoNotificacionDAO(DocumentoNotificacionDAO documentoNotificacionDAO) {
		this.documentoNotificacionDAO = documentoNotificacionDAO;
	}

	@Override
	@Transactional
	public void create(DocumentoNotificacion documentoNotificacion) {
		documentoNotificacionDAO.create(documentoNotificacion);
		
	}

	@Override
	@Transactional
	public DocumentoNotificacion read(Integer idNotificacion) {
		return documentoNotificacionDAO.read(idNotificacion);
	}

	@Override
	@Transactional
	public void update(DocumentoNotificacion documentoNotificacion) {
		documentoNotificacionDAO.update(documentoNotificacion);
		
	}

	@Override
	@Transactional
	public void delete(Integer idNotificacion) {
		documentoNotificacionDAO.delete(idNotificacion);
		
	}

}
