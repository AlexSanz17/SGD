package pe.gob.segdi.wsentidad.ws;

public class EntidadProxy implements pe.gob.segdi.wsentidad.ws.Entidad {
  private String _endpoint = null;
  private pe.gob.segdi.wsentidad.ws.Entidad entidad = null;
  
  public EntidadProxy() {
    _initEntidadProxy();
  }
  
  public EntidadProxy(String endpoint) {
    _endpoint = endpoint;
    _initEntidadProxy();
  }
  
  private void _initEntidadProxy() {
    try {
      entidad = (new pe.gob.segdi.wsentidad.ws.EntidadServiceLocator()).getEntidadPort();
      if (entidad != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)entidad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)entidad)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (entidad != null)
      ((javax.xml.rpc.Stub)entidad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.segdi.wsentidad.ws.Entidad getEntidad() {
    if (entidad == null)
      _initEntidadProxy();
    return entidad;
  }
  
  public pe.gob.segdi.wsentidad.ws.EntidadBean[] getListaEntidad(int sidcatent) throws java.rmi.RemoteException{
    if (entidad == null)
      _initEntidadProxy();
    return entidad.getListaEntidad(sidcatent);
  }
  
  public java.lang.String validarEntidad(java.lang.String vrucent) throws java.rmi.RemoteException{
    if (entidad == null)
      _initEntidadProxy();
    return entidad.validarEntidad(vrucent);
  }
  
  public pe.gob.segdi.wsentidad.ws.EntidadBean2[] getListaEntidad2() throws java.rmi.RemoteException{
    if (entidad == null)
      _initEntidadProxy();
    return entidad.getListaEntidad2();
  }
  
  
}