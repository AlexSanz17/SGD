/**
 * PcmIMgdTramitePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramiteprod.ws;

public interface PcmIMgdTramitePortType extends java.rmi.Remote {
    public pe.gob.segdi.wsiopidetramiteprod.ws.RespuestaCargoTramite cargoResponse(pe.gob.segdi.wsiopidetramiteprod.ws.CargoTramite request) throws java.rmi.RemoteException;
    public pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite consultarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws java.rmi.RemoteException;
    public pe.gob.segdi.wsiopidetramiteprod.ws.IoTipoDocumentoTramite[] getTipoDocumento() throws java.rmi.RemoteException;
    public pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite recepcionarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite request) throws java.rmi.RemoteException;
}
