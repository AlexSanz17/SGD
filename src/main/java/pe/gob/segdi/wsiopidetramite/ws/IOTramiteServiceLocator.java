/**
 * IOTramiteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramite.ws;

import gob.ositran.siged.config.SigedProperties;

public class IOTramiteServiceLocator extends org.apache.axis.client.Service implements pe.gob.segdi.wsiopidetramite.ws.IOTramiteService {

    public IOTramiteServiceLocator() {
    }


    public IOTramiteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IOTramiteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IOTramitePort
    
    // cambiar para el mapeo
    
    //private java.lang.String IOTramitePort_address = "http://192.168.21.11:8080/wsiopidetramite/IOTramite";
    
    
    private java.lang.String IOTramitePort_address = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_TRAMITE_DESARROLLO);
    private java.lang.String IOTramitePort_address_Produccion = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_TRAMITE_PRODUCCION);

    
    
    public java.lang.String getIOTramitePortAddressProduccion() {
		return IOTramitePort_address_Produccion;
	}


	public java.lang.String getIOTramitePortAddress() {
        return IOTramitePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IOTramitePortWSDDServiceName = "IOTramitePort";

    public java.lang.String getIOTramitePortWSDDServiceName() {
        return IOTramitePortWSDDServiceName;
    }

    public void setIOTramitePortWSDDServiceName(java.lang.String name) {
        IOTramitePortWSDDServiceName = name;
    }

    public pe.gob.segdi.wsiopidetramite.ws.IOTramite getIOTramitePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IOTramitePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIOTramitePort(endpoint);
    }

    public pe.gob.segdi.wsiopidetramite.ws.IOTramite getIOTramitePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceSoapBindingStub _stub = new pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIOTramitePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIOTramitePortEndpointAddress(java.lang.String address) {
        IOTramitePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.segdi.wsiopidetramite.ws.IOTramite.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceSoapBindingStub _stub = new pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceSoapBindingStub(new java.net.URL(IOTramitePort_address), this);
                _stub.setPortName(getIOTramitePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IOTramitePort".equals(inputPortName)) {
            return getIOTramitePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOTramiteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOTramitePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IOTramitePort".equals(portName)) {
            setIOTramitePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
