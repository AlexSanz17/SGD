package pe.gob.segdi.wsentidadprod.ws;

public class PcmIMgdEntidadPortTypeProxy implements pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType {
  private String _endpoint = null;
  private pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType pcmIMgdEntidadPortType = null;
  
  public PcmIMgdEntidadPortTypeProxy() {
    _initPcmIMgdEntidadPortTypeProxy();
  }
  
  public PcmIMgdEntidadPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPcmIMgdEntidadPortTypeProxy();
  }
  
  private void _initPcmIMgdEntidadPortTypeProxy() {
    try {
      pcmIMgdEntidadPortType = (new pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadLocator()).getPcmIMgdEntidadHttpsSoap11Endpoint();
      if (pcmIMgdEntidadPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pcmIMgdEntidadPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pcmIMgdEntidadPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pcmIMgdEntidadPortType != null)
      ((javax.xml.rpc.Stub)pcmIMgdEntidadPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType getPcmIMgdEntidadPortType() {
    if (pcmIMgdEntidadPortType == null)
      _initPcmIMgdEntidadPortTypeProxy();
    return pcmIMgdEntidadPortType;
  }
  
  public pe.gob.segdi.wsentidadprod.ws.EntidadBean[] getListaEntidad(int sidcatent) throws java.rmi.RemoteException{
    if (pcmIMgdEntidadPortType == null)
      _initPcmIMgdEntidadPortTypeProxy();
    return pcmIMgdEntidadPortType.getListaEntidad(sidcatent);
  }
  
  public java.lang.String validarEntidad(java.lang.String vrucent) throws java.rmi.RemoteException{
    if (pcmIMgdEntidadPortType == null)
      _initPcmIMgdEntidadPortTypeProxy();
    return pcmIMgdEntidadPortType.validarEntidad(vrucent);
  }
  
  
}