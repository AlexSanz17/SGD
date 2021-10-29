
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
@WebServiceClient(name = "EntidadService", targetNamespace = "http://ws.wsentidad.segdi.gob.pe/", wsdlLocation = "http://200.48.76.125/wsentidad/Entidad?wsdl")
public class EntidadService
    extends Service
{

    private final static URL ENTIDADSERVICE_WSDL_LOCATION;
    private final static WebServiceException ENTIDADSERVICE_EXCEPTION;
    private final static QName ENTIDADSERVICE_QNAME = new QName("http://ws.wsentidad.segdi.gob.pe/", "EntidadService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://200.48.76.125/wsentidad/Entidad?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ENTIDADSERVICE_WSDL_LOCATION = url;
        ENTIDADSERVICE_EXCEPTION = e;
    }

    public EntidadService() {
        super(__getWsdlLocation(), ENTIDADSERVICE_QNAME);
    }

    public EntidadService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ENTIDADSERVICE_QNAME, features);
    }

    public EntidadService(URL wsdlLocation) {
        super(wsdlLocation, ENTIDADSERVICE_QNAME);
    }

    public EntidadService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ENTIDADSERVICE_QNAME, features);
    }

    public EntidadService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EntidadService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Entidad
     */
    @WebEndpoint(name = "EntidadPort")
    public Entidad getEntidadPort() {
        return super.getPort(new QName("http://ws.wsentidad.segdi.gob.pe/", "EntidadPort"), Entidad.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Entidad
     */
    @WebEndpoint(name = "EntidadPort")
    public Entidad getEntidadPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.wsentidad.segdi.gob.pe/", "EntidadPort"), Entidad.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ENTIDADSERVICE_EXCEPTION!= null) {
            throw ENTIDADSERVICE_EXCEPTION;
        }
        return ENTIDADSERVICE_WSDL_LOCATION;
    }

}