package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.DocumentoRechazado;

public interface DocumentoRechazadoDAO {
	public void registrar(DocumentoRechazado documentoRechazado);
	public List<DocumentoRechazado> buscarTodos();
	public DocumentoRechazado buscarPorIdDocumentoRechazado(Integer idDocumentoRechazado);
}