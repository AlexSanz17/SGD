package org.ositran.daos;

import com.btg.ositran.siged.domain.FirmaArchivo;
import com.btg.ositran.siged.domain.Usuario;

import java.util.List;

public interface FirmaArchivoDAO {
    public void saveFirmaArchivo(FirmaArchivo firmaArchivo);
    public List<FirmaArchivo> findFirmas(Integer idDocumento , Usuario usuario);
    public List<FirmaArchivo> findFirmado(Integer idArchivo);
    public List<FirmaArchivo> findFirmadoUsuario(Integer idUsuario);
    public List<Usuario> findUltimaFirma(Integer idDocumento , String tipo);
    public List<FirmaArchivo> findFirmaArchivo(Integer idArchivo, Integer idUsuario, String estado);
    public void deleteFirmaArchivo(Integer idFirmaArchivo);
}