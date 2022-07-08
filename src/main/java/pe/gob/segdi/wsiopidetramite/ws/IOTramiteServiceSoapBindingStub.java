/**
 * IOTramiteServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiopidetramite.ws;

import org.apache.axis.AxisProperties;

import gob.ositran.siged.config.SigedProperties;

public class IOTramiteServiceSoapBindingStub extends org.apache.axis.client.Stub implements pe.gob.segdi.wsiopidetramite.ws.IOTramite {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cargoResponse");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "CargoTramite"), pe.gob.segdi.wsiopidetramite.ws.CargoTramite.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaCargoTramite"));
        oper.setReturnClass(pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTramiteResponse");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "ConsultaTramite"), pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaConsultaTramite"));
        oper.setReturnClass(pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOException"),
                      "pe.gob.segdi.wsiopidetramite.ws.IOException",
                      new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTipoDocumento");
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "ioTipoDocumentoTramite"));
        oper.setReturnClass(pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("recepcionarTramiteResponse");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RecepcionTramite"), pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaTramite"));
        oper.setReturnClass(pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

    }

    public IOTramiteServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public IOTramiteServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public IOTramiteServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "CargoTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.CargoTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "ConsultaTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "DocumentoAnexo");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.DocumentoAnexo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "IOException");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.IOException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "ioTipoDocumentoTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RecepcionTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaCargoTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaConsultaTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "RespuestaTramite");
            cachedSerQNames.add(qName);
            cls = pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite cargoResponse(pe.gob.segdi.wsiopidetramite.ws.CargoTramite request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        // Asignar variables de proxy
  		AxisProperties.getProperties().put("proxySet","true");
  	    AxisProperties.setProperty("http.proxyHost", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST)); 
  	    AxisProperties.setProperty("http.proxyPort", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT)); 
      	    
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "cargoResponse"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite) _resp;
            } catch (java.lang.Exception _exception) {
                return (pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite) org.apache.axis.utils.JavaUtils.convert(_resp, pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite consultarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws java.rmi.RemoteException, pe.gob.segdi.wsiopidetramite.ws.IOException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        
     // Asignar variables de proxy
 		AxisProperties.getProperties().put("proxySet","true");
 	    AxisProperties.setProperty("http.proxyHost", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST)); 
 	    AxisProperties.setProperty("http.proxyPort", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT)); 
        
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "consultarTramiteResponse"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite) _resp;
            } catch (java.lang.Exception _exception) {
                return (pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite) org.apache.axis.utils.JavaUtils.convert(_resp, pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof pe.gob.segdi.wsiopidetramite.ws.IOException) {
              throw (pe.gob.segdi.wsiopidetramite.ws.IOException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite[] getTipoDocumento() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "getTipoDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite[]) org.apache.axis.utils.JavaUtils.convert(_resp, pe.gob.segdi.wsiopidetramite.ws.IoTipoDocumentoTramite[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite recepcionarTramiteResponse(pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
     // Asignar variables de proxy
      		AxisProperties.getProperties().put("proxySet","true");
      	    AxisProperties.setProperty("http.proxyHost", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST)); 
      	    AxisProperties.setProperty("http.proxyPort", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT)); 
        
        
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.wsiopidetramite.segdi.gob.pe/", "recepcionarTramiteResponse"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite) _resp;
            } catch (java.lang.Exception _exception) {
                return (pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite) org.apache.axis.utils.JavaUtils.convert(_resp, pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
