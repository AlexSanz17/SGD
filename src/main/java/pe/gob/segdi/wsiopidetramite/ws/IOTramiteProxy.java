package pe.gob.segdi.wsiopidetramite.ws;

public class IOTramiteProxy implements pe.gob.segdi.wsiopidetramite.ws.IOTramite {
  private String _endpoint = null;
  private pe.gob.segdi.wsiopidetramite.ws.IOTramite iOTramite = null;
  
  public IOTramiteProxy() {
    _initIOTramiteProxy();
  }
  
  public IOTramiteProxy(String endpoint) {
    _endpoint = endpoint;
    _initIOTramiteProxy();
  }
  
  private void _initIOTramiteProxy() {
    try {
      iOTramite = (new pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceLocator()).getIOTramitePort();
      if (iOTramite != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iOTramite)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iOTramite)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iOTramite != null)
      ((javax.xml.rpc.Stub)iOTramite)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.IOTramite getIOTramite() {
    if (iOTramite == null)
      _initIOTramiteProxy();
    return iOTramite;
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite cargoResponse(pe.gob.segdi.wsiopidetramite.ws.CargoTramite request) throws java.rmi.RemoteException{
    if (iOTramite == null)
      _initIOTramiteProxy();
    return iOTramite.cargoResponse(request);
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite consultarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws java.rmi.RemoteException, pe.gob.segdi.wsiopidetramite.ws.IOException{
    if (iOTramite == null)
      _initIOTramiteProxy();
    return iOTramite.consultarTramiteResponse(request);
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite[] getTipoDocumento() throws java.rmi.RemoteException{
    if (iOTramite == null)
      _initIOTramiteProxy();
    return iOTramite.getTipoDocumento();
  }
  
  public pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite recepcionarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite request) throws java.rmi.RemoteException{
    if (iOTramite == null)
      _initIOTramiteProxy();
    return iOTramite.recepcionarTramiteResponse(request);
  }
  
  
}