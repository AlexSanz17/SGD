package org.ositran.services;

import com.btg.ositran.siged.domain.DocumentoNotificacion;

public interface DocumentoNotificacionService {
	public void create(DocumentoNotificacion documentoNotificacion) ;
	public DocumentoNotificacion read(Integer idNotificacion) ;
	public void update(DocumentoNotificacion documentoNotificacion) ;
	public void delete(Integer idNotificacion) ;
}
