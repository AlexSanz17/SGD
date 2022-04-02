package org.ositran.services;

import com.btg.ositran.siged.domain.FirmaArchivo;
import com.btg.ositran.siged.domain.Usuario;
import java.util.List;
import org.ositran.daos.FirmaArchivoDAO;
import org.springframework.transaction.annotation.Transactional;

public class FirmaArchivoServiceImpl implements FirmaArchivoService{
    private FirmaArchivoDAO firmaArchivoDAO;

    public FirmaArchivoDAO getFirmaArchivoDAO() {
        return firmaArchivoDAO;
    }

    public void setFirmaArchivoDAO(FirmaArchivoDAO firmaArchivoDAO) {
        this.firmaArchivoDAO = firmaArchivoDAO;
    }
    
    @Transactional
    public void saveFirmaArchivo(FirmaArchivo firmaArchivo){
        firmaArchivoDAO.saveFirmaArchivo(firmaArchivo);
    }
    
    public List<Usuario> findUltimaFirma(Integer idDocumento , String tipo){
        return firmaArchivoDAO.findUltimaFirma(idDocumento, tipo);
    }
    
    @Override
    public List<FirmaArchivo> findFirmaArchivo(Integer idArchivo , Integer idUsuario){
        return firmaArchivoDAO.findFirmaArchivo(idArchivo, idUsuario);
    }
    
    @Override
    public void deleteFirmaArchivo(Integer idFirmaArchivo){
        firmaArchivoDAO.deleteFirmaArchivo(idFirmaArchivo);
    }
}