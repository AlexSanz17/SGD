/**
 * EntidadServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsentidad.ws;

public class EntidadServiceLocator extends org.apache.axis.client.Service implements pe.gob.segdi.wsentidad.ws.EntidadService {

    public EntidadServiceLocator() {
    }


    public EntidadServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EntidadServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EntidadPort
    //private java.lang.String EntidadPort_address = "http://192.168.21.11:8080/wsentidad/Entidad";
	private java.lang.String EntidadPort_address = "http://200.48.76.125/wsentidad/Entidad";

    public java.lang.String getEntidadPortAddress() {
        return EntidadPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EntidadPortWSDDServiceName = "EntidadPort";

    public java.lang.String getEntidadPortWSDDServiceName() {
        return EntidadPortWSDDServiceName;
    }

    public void setEntidadPortWSDDServiceName(java.lang.String name) {
        EntidadPortWSDDServiceName = name;
    }

    public pe.gob.segdi.wsentidad.ws.Entidad getEntidadPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EntidadPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEntidadPort(endpoint);
    }

    public pe.gob.segdi.wsentidad.ws.Entidad getEntidadPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.segdi.wsentidad.ws.EntidadServiceSoapBindingStub _stub = new pe.gob.segdi.wsentidad.ws.EntidadServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEntidadPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEntidadPortEndpointAddress(java.lang.String address) {
        EntidadPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.segdi.wsentidad.ws.Entidad.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.segdi.wsentidad.ws.EntidadServiceSoapBindingStub _stub = new pe.gob.segdi.wsentidad.ws.EntidadServiceSoapBindingStub(new java.net.URL(EntidadPort_address), this);
                _stub.setPortName(getEntidadPortWSDDServiceName());
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
        if ("EntidadPort".equals(inputPortName)) {
            return getEntidadPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.wsentidad.segdi.gob.pe/", "EntidadService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.wsentidad.segdi.gob.pe/", "EntidadPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EntidadPort".equals(portName)) {
            setEntidadPortEndpointAddress(address);
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
