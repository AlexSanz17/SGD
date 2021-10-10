
package com.ositran.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IOTramiteService", targetNamespace = "http://ws.wsiopidetramite.segdi.gob.pe/", wsdlLocation = "http://200.48.76.125/wsiopidetramite/IOTramite?wsdl")
public class IOTramiteService
    extends Service
{

    private final static URL IOTRAMITESERVICE_WSDL_LOCATION;
    private final static WebServiceException IOTRAMITESERVICE_EXCEPTION;
    private final static QName IOTRAMITESERVICE_QNAME = new QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOTramiteService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://200.48.76.125/wsiopidetramite/IOTramite?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IOTRAMITESERVICE_WSDL_LOCATION = url;
        IOTRAMITESERVICE_EXCEPTION = e;
    }

    public IOTramiteService() {
        super(__getWsdlLocation(), IOTRAMITESERVICE_QNAME);
    }

    public IOTramiteService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IOTRAMITESERVICE_QNAME, features);
    }

    public IOTramiteService(URL wsdlLocation) {
        super(wsdlLocation, IOTRAMITESERVICE_QNAME);
    }

    public IOTramiteService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IOTRAMITESERVICE_QNAME, features);
    }

    public IOTramiteService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IOTramiteService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IOTramite
     */
    @WebEndpoint(name = "IOTramitePort")
    public IOTramite getIOTramitePort() {
        return super.getPort(new QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOTramitePort"), IOTramite.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IOTramite
     */
    @WebEndpoint(name = "IOTramitePort")
    public IOTramite getIOTramitePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOTramitePort"), IOTramite.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IOTRAMITESERVICE_EXCEPTION!= null) {
            throw IOTRAMITESERVICE_EXCEPTION;
        }
        return IOTRAMITESERVICE_WSDL_LOCATION;
    }

}
