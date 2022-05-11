package org.ositran.services;

import java.util.List;

import org.ositran.daos.DocumentoRechazadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.ositran.siged.domain.DocumentoRechazado;

@Service
public class DocumentoRechazadoServiceImpl implements DocumentoRechazadoService {
	@Autowired(required=false)
	DocumentoRechazadoDAO documentoRechazadoDAO;
	
	public DocumentoRechazadoDAO getDocumentoRechazadoDAO() {
		return documentoRechazadoDAO;
	}
	
	public void setDocumentoRechazadoDAO(DocumentoRechazadoDAO documentoRechazadoDAO) {
		this.documentoRechazadoDAO = documentoRechazadoDAO;
	}
	
	@Override
	public void registrar(DocumentoRechazado documentoRechazado) {
		documentoRechazadoDAO.registrar(documentoRechazado);
	}
	
	@Override
	public List<DocumentoRechazado> buscarTodos() {
		return documentoRechazadoDAO.buscarTodos();
	}
	
	@Override
	public DocumentoRechazado buscarPorIdDocumentoRechazado(Integer idDocumentoRechazado) {
		return documentoRechazadoDAO.buscarPorIdDocumentoRechazado(idDocumentoRechazado);
	}
}