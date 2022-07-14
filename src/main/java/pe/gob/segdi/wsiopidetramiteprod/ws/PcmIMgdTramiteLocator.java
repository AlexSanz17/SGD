/**
 * PcmIMgdTramiteLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramiteprod.ws;

public class PcmIMgdTramiteLocator extends org.apache.axis.client.Service implements pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramite {

    public PcmIMgdTramiteLocator() {
    }


    public PcmIMgdTramiteLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PcmIMgdTramiteLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PcmIMgdTramiteHttpsSoap11Endpoint
    private java.lang.String PcmIMgdTramiteHttpsSoap11Endpoint_address = "https://ws3.pide.gob.pe/services/PcmIMgdTramite.PcmIMgdTramiteHttpsSoap11Endpoint";

    public java.lang.String getPcmIMgdTramiteHttpsSoap11EndpointAddress() {
        return PcmIMgdTramiteHttpsSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName = "PcmIMgdTramiteHttpsSoap11Endpoint";

    public java.lang.String getPcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName() {
        return PcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName;
    }

    public void setPcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName(java.lang.String name) {
        PcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName = name;
    }

    public pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType getPcmIMgdTramiteHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PcmIMgdTramiteHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPcmIMgdTramiteHttpsSoap11Endpoint(endpoint);
    }

    public pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType getPcmIMgdTramiteHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteSoap11BindingStub _stub = new pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPcmIMgdTramiteHttpsSoap11EndpointEndpointAddress(java.lang.String address) {
        PcmIMgdTramiteHttpsSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteSoap11BindingStub _stub = new pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteSoap11BindingStub(new java.net.URL(PcmIMgdTramiteHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getPcmIMgdTramiteHttpsSoap11EndpointWSDDServiceName());
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
        if ("PcmIMgdTramiteHttpsSoap11Endpoint".equals(inputPortName)) {
            return getPcmIMgdTramiteHttpsSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "PcmIMgdTramite");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "PcmIMgdTramiteHttpsSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PcmIMgdTramiteHttpsSoap11Endpoint".equals(portName)) {
            setPcmIMgdTramiteHttpsSoap11EndpointEndpointAddress(address);
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
