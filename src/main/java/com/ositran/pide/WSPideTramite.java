/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*LICENCIA DE USO DEL SGD .TXT*/package com.ositran.pide;


import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.URL;
import java.util.List;
import javax.xml.ws.BindingProvider;
import com.ositran.ws.RespuestaTramite;
import com.ositran.ws.RecepcionTramite;
import com.ositran.ws.RespuestaCargoTramite;
import com.ositran.ws.CargoTramite;
import com.ositran.ws.ConsultaTramite;
import com.ositran.ws.IOTramite;
import com.ositran.ws.IOTramiteService;
import com.ositran.ws.IoTipoDocumentoTramite;
import com.ositran.ws.MyProxySelector;
import com.ositran.ws.PcmIMgdTramite;
import com.ositran.ws.PcmIMgdTramitePortType;
import com.ositran.ws.RespuestaConsultaTramite;
import com.ositran.ws.Tramite;
import com.ositran.ws.Tramite_Service;

import gob.ositran.siged.config.SigedProperties;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.ositran.utils.Constantes;

public class WSPideTramite{
 
  public List<IoTipoDocumentoTramite> getTipoDocumento(String co_par) throws  Exception{
    List<IoTipoDocumentoTramite> lista = null;
    try
    {
      if (co_par.equals("D")) {
        lista = getIOTramiteDesarrollo().getTipoDocumento();
      } else if (co_par.equals("P")) {
        lista = getIOTramiteProduccion().getTipoDocumento();
      }
    }
    catch (Exception e){
       throw e;
    }
    return lista;
  }
  
  public RespuestaTramite recepcionarTramite(RecepcionTramite request, String co_par) throws  Exception{
    RespuestaTramite respuestaTramite = null;
    
    try{
      if (co_par.equals("D")) {
        respuestaTramite = getIOTramiteDesarrollo().recepcionarTramiteResponse(request);
      } else if (co_par.equals("P")) {
        respuestaTramite = getIOTramiteProduccion().recepcionarTramiteResponse(request);
      }else if (co_par.equals("O")) {
        respuestaTramite = getIOTramiteOsitran().recepcionarTramiteResponse(request);
      }
    }
    catch (Exception e){
        throw e; 
    }
    return respuestaTramite;
  }
  
  public RespuestaCargoTramite cargoTramite(CargoTramite request, String co_par) throws  Exception{
    RespuestaCargoTramite respuestaCargoTramite = null;
    try
    {
      if (co_par.equals("D")) {
        respuestaCargoTramite = getIOTramiteDesarrollo().cargoResponse(request);
      }else if (co_par.equals("P")) {
        respuestaCargoTramite = getIOTramiteProduccion().cargoResponse(request);
      }else if (co_par.equals("O")) {
        respuestaCargoTramite = getIOTramiteOsitran().cargoResponse(request);
      }
    }
    catch (Exception e){
       throw e;
    }
    return respuestaCargoTramite;
  }
  

  
  public RespuestaConsultaTramite consultarTramite(ConsultaTramite request, String co_par) throws  Exception
  {
    RespuestaConsultaTramite respuestaConsultaTramite = null;
    System.out.println("========proceso consultar tramite ");
    System.out.println("co_par" + co_par);
    try{
     if (co_par.equals("D")) {
    	System.out.println("========Obtener IOTramite===== ");
        IOTramite iotramite = getIOTramiteDesarrollo();
        System.out.println("=======Consultar tramite ===========");
        System.out.println(request.getVcuo());
        System.out.println(request.getVrucentrec());
        System.out.println(request.getVrucentrem());
        respuestaConsultaTramite = iotramite.consultarTramiteResponse(request);
//    	respuestaConsultaTramite = getIOTramiteDesarrollo().consultarTramiteResponse(request);
        System.out.println("======Respuesta consulta tramite=====");
        System.out.println(respuestaConsultaTramite.getVdesres());
        
        
     }else if (co_par.equals("P")) {
        respuestaConsultaTramite = getIOTramiteProduccion().consultarTramiteResponse(request);
     }else if (co_par.equals("O")) {
        respuestaConsultaTramite = getIOTramiteOsitran().consultarTramiteResponse(request.getVcuo());
     }
    }
    catch (Exception e){
        throw e;
    }
    return respuestaConsultaTramite;
  }
  
  
  private PcmIMgdTramitePortType getIOTramiteProduccion()
    throws MalformedURLException
  {
      PcmIMgdTramite service = new PcmIMgdTramite(new URL(SigedProperties
  			.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_TRAMITE_PRODUCCION)));
      PcmIMgdTramitePortType entidad = service.getPcmIMgdTramiteHttpsSoap11Endpoint();
    
     BindingProvider bindingProvider = (BindingProvider)entidad;
     bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address", SigedProperties
   			.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_TRAMITE_PRODUCCION));
    
    return entidad;
  }
  
  private IOTramite getIOTramiteDesarrollo() throws MalformedURLException{
	  
	ProxySelector.setDefault(new MyProxySelector());
	  
	 /* HelloService hello = new HelloService();
	  HelloPortType helloPort = cliente.getHelloPort();
	  org.apache.cxf.endpoint.Client client = ClientProxy.getClient(helloPort);
	  HTTPConduit http = (HTTPConduit) client.getConduit();
	  http.getClient().setProxyServer("proxy");
	  http.getClient().setProxyServerPort(8080);
	  http.getProxyAuthorization().setUserName("user proxy");
	  http.getProxyAuthorization().setPassword("password proxy");*/
	  
    IOTramiteService service = new IOTramiteService(new URL(SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_TRAMITE_DESARROLLO)));
    IOTramite entidad = service.getIOTramitePort();
   /* org.apache.cxf.endpoint.Client client = ClientProxy.getClient(entidad);
	 HTTPConduit http = (HTTPConduit) client.getConduit();
	  http.getClient().setProxyServer("proxy1");
	  http.getClient().setProxyServerPort(8080);*/
    
    BindingProvider bindingProvider = (BindingProvider)entidad;
    bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address", SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_TRAMITE_DESARROLLO));
    
    return entidad;
  }
  
  private Tramite getIOTramiteOsitran() throws MalformedURLException{
    Tramite_Service service = new Tramite_Service(new URL(Constantes.URL_PIDE_TRAMITE_OSITRAN));
    Tramite entidad = service.getTramitePort();
    BindingProvider bindingProvider = (BindingProvider)entidad;
    bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address", Constantes.URL_PIDE_TRAMITE_OSITRAN);
    return entidad;
  }
  
  
}
