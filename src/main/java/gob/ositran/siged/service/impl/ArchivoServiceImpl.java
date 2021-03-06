/*LICENCIA DE USO DEL SGD .TXT*/package gob.ositran.siged.service.impl;

import gob.ositran.siged.service.CrudService;
import gob.ositran.siged.service.ArchivoService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.Usuario;

/**
 *
 * @author diego.gil
 */
public class ArchivoServiceImpl implements ArchivoService {

    private static final Logger log = LoggerFactory.getLogger(ArchivoServiceImpl.class);
    private CrudService crud;

    public CrudService getCrud() {
        return crud;
    }

    public void setCrud(CrudService crud) {
        this.crud = crud;
    }

    @Override
    @Transactional
    public void bloquearArchivo(Integer idArchivo, Usuario usuario, String nodeId) {
        try {
            log.info("bloqueando archivo " + idArchivo);
//            crud.executeNamedQuery("Archivo.bloquearArchivo", QueryParameter.with("usuario", usuario).and("fecha", new Date()).and("nodeId", nodeId).and("idArchivo", idArchivo).parameters());
            log.info("bloqueo de archivo " + idArchivo + " exitoso");
        } catch (RuntimeException ex) {
            log.error("bloqueo de archivo " + idArchivo + " fallo: ", ex);
            throw ex;
        }
    }

    @Override
    @Transactional
    public void desbloquearArchivo(String nodeId) {
        try {
            log.info("desbloqueando archivo con nodeId " + nodeId);
//            crud.executeNamedQuery("Archivo.desbloquearArchivo", QueryParameter.with("nodeId", nodeId).parameters());
            log.info("desbloqueo de con nodeId " + nodeId + " exitoso");
        } catch (RuntimeException ex) {
            log.error("desbloqueo de archivo con nodeId " + nodeId + " fallo: ", ex);
            throw ex;
        }
    }

    @Override
    @Transactional
    public List<Archivo> listarArchivosBloqueadosPorUsuario(Integer idUsuario) {
        try {
            log.info("listando archivos bloqueado por Usuario " + idUsuario);
//            List<Archivo> archivos = crud.findByNamedQuery("Archivo.listarArchivosBloqueadosPorUsuario", QueryParameter.with("idUsuario", idUsuario).parameters());
            List<Archivo> archivos = new ArrayList<Archivo>(); // implementacion temporal
            log.info("listado archivos bloqueado por Usuario " + idUsuario + " exitoso");
            return archivos;
        } catch (RuntimeException ex) {
            log.error("listado archivos bloqueado por Usuario " + idUsuario + " fallo", ex);
            throw ex;
        }
    }
}
