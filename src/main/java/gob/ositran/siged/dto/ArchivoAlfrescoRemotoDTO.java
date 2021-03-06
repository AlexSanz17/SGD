/*LICENCIA DE USO DEL SGD .TXT*/package gob.ositran.siged.dto;

import java.util.Date;

/**
 *
 * @author diego.gil
 */
public class ArchivoAlfrescoRemotoDTO {

    private String ticket;
    private String nodeId;
    private Date fechaInicioEdicion;
    private String rutaWebdav;

    public ArchivoAlfrescoRemotoDTO(String ticket, String nodeId, Date fechaInicioEdicion, String rutaWebdav) {
        this.ticket = ticket;
        this.nodeId = nodeId;
        this.fechaInicioEdicion = new Date();
        this.rutaWebdav = rutaWebdav;
    }

    public Date getFechaInicioEdicion() {
        return fechaInicioEdicion;
    }

    public void setFechaInicioEdicion(Date fechaInicioEdicion) {
        this.fechaInicioEdicion = fechaInicioEdicion;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getRutaWebdav() {
        return rutaWebdav;
    }

    public void setRutaWebdav(String rutaWebdav) {
        this.rutaWebdav = rutaWebdav;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}