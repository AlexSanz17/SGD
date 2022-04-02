package org.ositran.services;

import com.btg.ositran.siged.domain.FirmaArchivo;
import com.btg.ositran.siged.domain.Usuario;
import java.util.List;

public interface FirmaArchivoService {
    public void saveFirmaArchivo(FirmaArchivo firmaArchivo);
    public List<Usuario> findUltimaFirma(Integer idDocumento , String tipo);
    public List<FirmaArchivo> findFirmaArchivo(Integer idArchivo , Integer idUsuario);
	void deleteFirmaArchivo(Integer idFirmaArchivo);
}