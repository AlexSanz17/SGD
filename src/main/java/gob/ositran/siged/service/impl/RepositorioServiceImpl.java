/*LICENCIA DE USO DEL SGD .TXT*/package gob.ositran.siged.service.impl;

import gob.ositran.siged.config.SigedProperties;
import gob.ositran.siged.dto.ArchivoAlfrescoRemotoDTO;
import gob.ositran.siged.service.AlfrescoWebscriptService;
import gob.ositran.siged.service.ArchivoService;
import gob.ositran.siged.service.RepositorioService;
import org.ositran.siged.service.AlfrescoWSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.Usuario;

/**
 *
 * @author diego.gil
 */
public class RepositorioServiceImpl implements RepositorioService {

    private static final Logger log = LoggerFactory.getLogger(RepositorioServiceImpl.class);
    private ArchivoService archivoService;
    private AlfrescoWSService alfrescoWebServiceClient;
    private AlfrescoWebscriptService alfrescoWebscriptService;

    /////////////////////////
    // Setters and Getters //
    /////////////////////////
    public AlfrescoWSService getAlfrescoWebServiceClient() {
        return alfrescoWebServiceClient;
    }

    public void setAlfrescoWebServiceClient(AlfrescoWSService alfrescoWebServiceClient) {
        this.alfrescoWebServiceClient = alfrescoWebServiceClient;
    }

    public AlfrescoWebscriptService getAlfrescoWebscriptService() {
        return alfrescoWebscriptService;
    }

    public void setAlfrescoWebscriptService(AlfrescoWebscriptService alfrescoWebscriptService) {
        this.alfrescoWebscriptService = alfrescoWebscriptService;
    }

    public ArchivoService getArchivoService() {
        return archivoService;
    }

    public void setArchivoService(ArchivoService archivoService) {
        this.archivoService = archivoService;
    }

    @Transactional
    @Override
    public ArchivoAlfrescoRemotoDTO comenzarEdicionRemota(Usuario usuario, Archivo archivo) {
        ArchivoAlfrescoRemotoDTO remote = null;
        try {
            remote = alfrescoWebscriptService.checkOutPostTicket(usuario.getUsuario(), usuario.getClave(), archivo.getRutaAlfresco());
        } catch (Exception ex) {
            throw new RuntimeException("Error al hacer CheckOut de archivo:" + archivo, ex);
        }

        try {
            archivoService.bloquearArchivo(archivo.getIdArchivo(), usuario, remote.getNodeId());
        } catch (Exception ex) {
            alfrescoWebscriptService.endCheckOutCancel(remote.getNodeId(), remote.getTicket());
            throw new RuntimeException("Error al bloquear Archivo " + archivo, ex);
        }
        return remote;
    }

    @Override
    public void finalizarEdicionRemotaConfirmar(String nodeId, String ticket) {
        finalizarEdicionRemota(nodeId, ticket, true);
    }

    @Override
    public void finalizarEdicionRemotaCancelar(String nodeId, String ticket) {
        finalizarEdicionRemota(nodeId, ticket, false);
    }

    @Transactional
    private void finalizarEdicionRemota(String nodeId, String ticket, boolean confirm) {
        try {
            archivoService.desbloquearArchivo(nodeId);
            log.info("finalizacion Edicion Remota de nodeId:" + nodeId);
        } catch (Exception ex) {
            throw new RuntimeException("Error al desbloquear Archivo con idnode " + nodeId, ex);
        }

        try {
            if (confirm) {
                alfrescoWebscriptService.endCheckOutConfirm(nodeId, ticket);
            } else {
                alfrescoWebscriptService.endCheckOutCancel(nodeId, ticket);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al finalizar de CheckOut nodeId:" + nodeId, ex);
        }
    }

    @Override
    public String descargarArchivo(String rutaAlfresco, String archivo, String rutaDestino) {
        if (!alfrescoWebServiceClient.descargarArchivo(rutaAlfresco, archivo, rutaDestino)) {
            throw new RuntimeException("error al descargar archivo:");
        }
        return rutaDestino + archivo;
    }

    @Override
    public String descargarArchivoTemporal(String rutaAlfresco, String archivo) {
        String rutaDestino = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.DIRECTORIO_TEMPORAL_ALFRESCO);
        if (!rutaDestino.endsWith("/")) {
            rutaDestino += "/";
        }
        return descargarArchivo(rutaAlfresco, archivo, rutaDestino);
    }
}
