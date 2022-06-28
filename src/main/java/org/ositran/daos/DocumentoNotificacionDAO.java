package org.ositran.daos;

import com.btg.ositran.siged.domain.DocumentoNotificacion;

public interface DocumentoNotificacionDAO {
	public void create(DocumentoNotificacion documentoNotificacion) ;
	public DocumentoNotificacion read(Integer idNotificacion) ;
	public void update(DocumentoNotificacion documentoNotificacion) ;
	public void delete(Integer idNotificacion) ;
}
