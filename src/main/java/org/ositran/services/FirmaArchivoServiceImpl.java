package org.ositran.services;

import com.btg.ositran.siged.domain.FirmaArchivo;
import com.btg.ositran.siged.domain.Usuario;

import java.util.List;

import org.ositran.daos.FirmaArchivoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FirmaArchivoServiceImpl implements FirmaArchivoService{
	@Autowired(required=false)
    private FirmaArchivoDAO firmaArchivoDAO;

    public FirmaArchivoDAO getFirmaArchivoDAO() {
        return firmaArchivoDAO;
    }

    public void setFirmaArchivoDAO(FirmaArchivoDAO firmaArchivoDAO) {
        this.firmaArchivoDAO = firmaArchivoDAO;
    }
    
    @Transactional
    @Override
    public void saveFirmaArchivo(FirmaArchivo firmaArchivo){
        firmaArchivoDAO.saveFirmaArchivo(firmaArchivo);
    }
    
    @Transactional
    @Override
    public List<Usuario> findUltimaFirma(Integer idDocumento , String estado){
        return firmaArchivoDAO.findUltimaFirma(idDocumento, estado);
    }
//    public List<Usuario> findUltimaFirma(Integer idDocumento , String tipo){
//        return firmaArchivoDAO.findUltimaFirma(idDocumento, tipo);
//    }
//    
    @Transactional
    @Override
    public List<FirmaArchivo> findFirmaArchivo(Integer idArchivo , Integer idUsuario, String estado){
        return firmaArchivoDAO.findFirmaArchivo(idArchivo, idUsuario, estado);
    }
    
    @Transactional
    @Override
    public void deleteFirmaArchivo(Integer idFirmaArchivo){
        firmaArchivoDAO.deleteFirmaArchivo(idFirmaArchivo);
    }
}