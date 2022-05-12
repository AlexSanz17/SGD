package org.pide.pcm.client.webservice;

public class PcmCuoLocator extends org.apache.axis.client.Service implements org.pide.pcm.client.webservice.PcmCuo {

    public PcmCuoLocator() {
    }


    public PcmCuoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PcmCuoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PcmCuoHttpsSoap11Endpoint
    private java.lang.String PcmCuoHttpsSoap11Endpoint_address = "https://ws3.pide.gob.pe/services/PcmCuo.PcmCuoHttpsSoap11Endpoint";

    public java.lang.String getPcmCuoHttpsSoap11EndpointAddress() {
        return PcmCuoHttpsSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PcmCuoHttpsSoap11EndpointWSDDServiceName = "PcmCuoHttpsSoap11Endpoint";

    public java.lang.String getPcmCuoHttpsSoap11EndpointWSDDServiceName() {
        return PcmCuoHttpsSoap11EndpointWSDDServiceName;
    }

    public void setPcmCuoHttpsSoap11EndpointWSDDServiceName(java.lang.String name) {
        PcmCuoHttpsSoap11EndpointWSDDServiceName = name;
    }

    public org.pide.pcm.client.webservice.PcmCuoPortType getPcmCuoHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PcmCuoHttpsSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPcmCuoHttpsSoap11Endpoint(endpoint);
    }

    public org.pide.pcm.client.webservice.PcmCuoPortType getPcmCuoHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	org.pide.pcm.client.webservice.PcmCuoSoap11BindingStub _stub = new org.pide.pcm.client.webservice.PcmCuoSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPcmCuoHttpsSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPcmCuoHttpsSoap11EndpointEndpointAddress(java.lang.String address) {
        PcmCuoHttpsSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.pide.pcm.client.webservice.PcmCuoPortType.class.isAssignableFrom(serviceEndpointInterface)) {
            	org.pide.pcm.client.webservice.PcmCuoSoap11BindingStub _stub = new org.pide.pcm.client.webservice.PcmCuoSoap11BindingStub(new java.net.URL(PcmCuoHttpsSoap11Endpoint_address), this);
                _stub.setPortName(getPcmCuoHttpsSoap11EndpointWSDDServiceName());
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
        if ("PcmCuoHttpsSoap11Endpoint".equals(inputPortName)) {
            return getPcmCuoHttpsSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://pcm.pide.gob.pe/webservice", "PcmCuo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://pcm.pide.gob.pe/webservice", "PcmCuoHttpsSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PcmCuoHttpsSoap11Endpoint".equals(portName)) {
            setPcmCuoHttpsSoap11EndpointEndpointAddress(address);
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