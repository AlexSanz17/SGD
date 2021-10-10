
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
@WebServiceClient(name = "PcmIMgdEntidad", targetNamespace = "http://ws.wsentidad.segdi.gob.pe/", wsdlLocation = "https://ws3.pide.gob.pe/services/PcmIMgdEntidad?wsdl")
public class PcmIMgdEntidad
    extends Service
{

    private final static URL PCMIMGDENTIDAD_WSDL_LOCATION;
    private final static WebServiceException PCMIMGDENTIDAD_EXCEPTION;
    private final static QName PCMIMGDENTIDAD_QNAME = new QName("http://ws.wsentidad.segdi.gob.pe/", "PcmIMgdEntidad");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ws3.pide.gob.pe/services/PcmIMgdEntidad?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PCMIMGDENTIDAD_WSDL_LOCATION = url;
        PCMIMGDENTIDAD_EXCEPTION = e;
    }

    public PcmIMgdEntidad() {
        super(__getWsdlLocation(), PCMIMGDENTIDAD_QNAME);
    }

    public PcmIMgdEntidad(WebServiceFeature... features) {
        super(__getWsdlLocation(), PCMIMGDENTIDAD_QNAME, features);
    }

    public PcmIMgdEntidad(URL wsdlLocation) {
        super(wsdlLocation, PCMIMGDENTIDAD_QNAME);
    }

    public PcmIMgdEntidad(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PCMIMGDENTIDAD_QNAME, features);
    }

    public PcmIMgdEntidad(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PcmIMgdEntidad(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PcmIMgdEntidadPortType
     */
    @WebEndpoint(name = "PcmIMgdEntidadHttpsSoap11Endpoint")
    public PcmIMgdEntidadPortType getPcmIMgdEntidadHttpsSoap11Endpoint() {
        return super.getPort(new QName("http://ws.wsentidad.segdi.gob.pe/", "PcmIMgdEntidadHttpsSoap11Endpoint"), PcmIMgdEntidadPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PcmIMgdEntidadPortType
     */
    @WebEndpoint(name = "PcmIMgdEntidadHttpsSoap11Endpoint")
    public PcmIMgdEntidadPortType getPcmIMgdEntidadHttpsSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.wsentidad.segdi.gob.pe/", "PcmIMgdEntidadHttpsSoap11Endpoint"), PcmIMgdEntidadPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PCMIMGDENTIDAD_EXCEPTION!= null) {
            throw PCMIMGDENTIDAD_EXCEPTION;
        }
        return PCMIMGDENTIDAD_WSDL_LOCATION;
    }

}
