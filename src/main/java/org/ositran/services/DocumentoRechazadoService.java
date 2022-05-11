package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.DocumentoRechazado;

public interface DocumentoRechazadoService {
	public void registrar(DocumentoRechazado documentoRechazado);
	public List<DocumentoRechazado> buscarTodos();
	public DocumentoRechazado buscarPorIdDocumentoRechazado(Integer idDocumentoRechazado);
}