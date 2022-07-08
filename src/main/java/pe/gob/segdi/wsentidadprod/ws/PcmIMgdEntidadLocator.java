/**
 * PcmIMgdEntidadLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsentidadprod.ws;

public class PcmIMgdEntidadLocator extends org.apache.axis.client.Service implements pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidad {

    public PcmIMgdEntidadLocator() {
    }


    public PcmIMgdEntidadLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PcmIMgdEntidadLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PcmIMgdEntidadHttpsSoap11Endpoint
    private java.lang.String PcmIMgdEntidadHttpsSoap11Endpoint_address = "https://ws3.pide.gob.pe/services/PcmIMgdEntidad.PcmIMgdEntidadHttpsSoap11Endpoint";

    public java.lang.String getPcmIMgdEntidadHttpsSoap11EndpointAddress() {
        return PcmIMgdEntidadHttpsSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName = "PcmIMgdEntidadHttpsSoap11Endpoint";

    public java.lang.String getPcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName() {
        return PcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName;
    }

    public void setPcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName(java.lang.String name) {
        PcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName = name;
    }

    public pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType getPcmIMgdEntidadHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PcmIMgdEntidadHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPcmIMgdEntidadHttpsSoap11Endpoint(endpoint);
    }

    public pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType getPcmIMgdEntidadHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadSoap11BindingStub _stub = new pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPcmIMgdEntidadHttpsSoap11EndpointEndpointAddress(java.lang.String address) {
        PcmIMgdEntidadHttpsSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadSoap11BindingStub _stub = new pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadSoap11BindingStub(new java.net.URL(PcmIMgdEntidadHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getPcmIMgdEntidadHttpsSoap11EndpointWSDDServiceName());
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
        if ("PcmIMgdEntidadHttpsSoap11Endpoint".equals(inputPortName)) {
            return getPcmIMgdEntidadHttpsSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.wsentidad.segdi.gob.pe/", "PcmIMgdEntidad");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.wsentidad.segdi.gob.pe/", "PcmIMgdEntidadHttpsSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PcmIMgdEntidadHttpsSoap11Endpoint".equals(portName)) {
            setPcmIMgdEntidadHttpsSoap11EndpointEndpointAddress(address);
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
