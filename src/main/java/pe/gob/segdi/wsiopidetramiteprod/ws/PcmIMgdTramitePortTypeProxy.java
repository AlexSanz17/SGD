package pe.gob.segdi.wsiopidetramiteprod.ws;

public class PcmIMgdTramitePortTypeProxy implements pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType {
  private String _endpoint = null;
  private pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType pcmIMgdTramitePortType = null;
  
  public PcmIMgdTramitePortTypeProxy() {
    _initPcmIMgdTramitePortTypeProxy();
  }
  
  public PcmIMgdTramitePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPcmIMgdTramitePortTypeProxy();
  }
  
  private void _initPcmIMgdTramitePortTypeProxy() {
    try {
      pcmIMgdTramitePortType = (new pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteLocator()).getPcmIMgdTramiteHttpsSoap11Endpoint();
      if (pcmIMgdTramitePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pcmIMgdTramitePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pcmIMgdTramitePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pcmIMgdTramitePortType != null)
      ((javax.xml.rpc.Stub)pcmIMgdTramitePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType getPcmIMgdTramitePortType() {
    if (pcmIMgdTramitePortType == null)
      _initPcmIMgdTramitePortTypeProxy();
    return pcmIMgdTramitePortType;
  }
  
  public pe.gob.segdi.wsiopidetramiteprod.ws.RespuestaCargoTramite cargoResponse(pe.gob.segdi.wsiopidetramiteprod.ws.CargoTramite request) throws java.rmi.RemoteException{
    if (pcmIMgdTramitePortType == null)
      _initPcmIMgdTramitePortTypeProxy();
    return pcmIMgdTramitePortType.cargoResponse(request);
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite consultarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws java.rmi.RemoteException{
    if (pcmIMgdTramitePortType == null)
      _initPcmIMgdTramitePortTypeProxy();
    return pcmIMgdTramitePortType.consultarTramiteResponse(request);
  }
  
  public pe.gob.segdi.wsiopidetramiteprod.ws.IoTipoDocumentoTramite[] getTipoDocumento() throws java.rmi.RemoteException{
    if (pcmIMgdTramitePortType == null)
      _initPcmIMgdTramitePortTypeProxy();
    return pcmIMgdTramitePortType.getTipoDocumento();
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite recepcionarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite request) throws java.rmi.RemoteException{
    if (pcmIMgdTramitePortType == null)
      _initPcmIMgdTramitePortTypeProxy();
    return pcmIMgdTramitePortType.recepcionarTramiteResponse(request);
  }
  
  
}