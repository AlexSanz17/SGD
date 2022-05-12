package org.pide.pcm.client.webservice;

public class PcmCuoPortTypeProxy implements org.pide.pcm.client.webservice.PcmCuoPortType {
	  private String _endpoint = null;
	  private org.pide.pcm.client.webservice.PcmCuoPortType pcmCuoPortType = null;
	  
	  public PcmCuoPortTypeProxy() {
	    _initPcmCuoPortTypeProxy();
	  }
	  
	  public PcmCuoPortTypeProxy(String endpoint) {
	    _endpoint = endpoint;
	    _initPcmCuoPortTypeProxy();
	  }
	  
	  private void _initPcmCuoPortTypeProxy() {
	    try {
	      pcmCuoPortType = (new org.pide.pcm.client.webservice.PcmCuoLocator()).getPcmCuoHttpsSoap11Endpoint();
	      if (pcmCuoPortType != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)pcmCuoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)pcmCuoPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
	  
	  public String getEndpoint() {
	    return _endpoint;
	  }
	  
	  public void setEndpoint(String endpoint) {
	    _endpoint = endpoint;
	    if (pcmCuoPortType != null)
	      ((javax.xml.rpc.Stub)pcmCuoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	    
	  }
	  
	  public org.pide.pcm.client.webservice.PcmCuoPortType getPcmCuoPortType() {
	    if (pcmCuoPortType == null)
	      _initPcmCuoPortTypeProxy();
	    return pcmCuoPortType;
	  }
	  
	  public java.lang.String getCUOEntidad(java.lang.String ruc, java.lang.String servicio) throws java.rmi.RemoteException{
	    if (pcmCuoPortType == null)
	      _initPcmCuoPortTypeProxy();
	    return pcmCuoPortType.getCUOEntidad(ruc, servicio);
	  }
	  
	  public java.lang.String getCUO(java.lang.String ip) throws java.rmi.RemoteException{
	    if (pcmCuoPortType == null)
	      _initPcmCuoPortTypeProxy();
	    return pcmCuoPortType.getCUO(ip);
	  }
	  
	  
	}