package com.ositran.pide.requestssoap;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import com.ositran.pide.ConsultaTramiteSOAP;
import com.ositran.ws.ConsultaTramite;
import com.ositran.ws.RespuestaConsultaTramite;

import gob.ositran.siged.config.SigedProperties;

public class WSPideConsultarTramiteSOAP {
	private String PROXY_HOST = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST);
	private String PROXY_ACTIVE = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_ACTIVE);
	private String PROXY_PORT = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT);
	
	public pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite consultarTramiteSOAP(pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws  Exception
	  {
		pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite respuestaConsultaTramiteSOAP = new pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite();
	    System.out.println("========proceso consultar tramite ");
	  
	    try{
	   
	    	System.out.println("========Obtener IOTramite===== ");
	        System.out.println("=======Consultar tramite ===========");
	        System.out.println(request.getVcuo());
	        System.out.println(request.getVrucentrec());
	        System.out.println(request.getVrucentrem());
	        
	        
	        String soapEndpointUrl = "http://200.48.76.125/wsiopidetramite/IOTramite";
	        String soapAction = "";

	        //callSoapWebService(soapEndpointUrl, soapAction);
	        
	        try {
	        	 String proxy_address = PROXY_HOST;
	             int proxy_port = Integer.parseInt(PROXY_PORT);
	        	
	             ///Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(socket.getInetAddress(), PROXY_PORT));
	             Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy_address, proxy_port));
				 //sendSOAPMessage(soapEndpointUrl,proxy , soapAction);
				
				SOAPMessage message =  sendSOAPMessage(soapEndpointUrl,proxy , soapAction,request);
	             // get the body
	             SOAPBody soapBody = message.getSOAPBody();
	             // find your node based on tag name
	             NodeList nodes = soapBody.getElementsByTagName("vcodres");

	             // check if the node exists and get the value
	             String someMsgContent = null;
	             Node node = nodes.item(0);
	             someMsgContent = node != null ? node.getTextContent() : "";

	             respuestaConsultaTramiteSOAP.setVcodres(someMsgContent); 
	             
	             System.out.println(someMsgContent);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	    }
	    catch (Exception e){
	        throw e;
	    }
	    return respuestaConsultaTramiteSOAP;
	  }
	 
		public SOAPMessage sendSOAPMessage(String url, final Proxy p, String soapAction,pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws Exception {
	        SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
	        SOAPConnection connection = factory.createConnection();

	     // Send SOAP Message to SOAP Server
	        
	        //SOAPMessage message = connection.call(createSOAPRequest(soapAction), url);
	        
	        URL endpoint = new URL(null, url, new URLStreamHandler() {
	            protected URLConnection openConnection(URL url) throws IOException {
	                // The url is the parent of this stream handler, so must
	                // create clone
	                URL clone = new URL(url.toString());

	                URLConnection connection = null;
	                if (p.address().toString().equals("0.0.0.0/0.0.0.0:80")) {
	                    connection = clone.openConnection();
	                } else
	                    connection = clone.openConnection(p);
	                connection.setConnectTimeout(5 * 1000); // 5 sec
	                connection.setReadTimeout(5 * 1000); // 5 sec
	                // Custom header
	                connection.addRequestProperty("Developer-Mood", "Happy");
	                return connection;
	            }
	        });

	        try {
	            SOAPMessage response = connection.call(createSOAPRequest(soapAction, request), endpoint);
	            
	            // Print the SOAP Response
	            System.out.println("Response SOAP Message:");
	            response.writeTo(System.out);
	            System.out.println();
	            connection.close();
	            return response;
	        } catch (Exception e) {
	            // Re-try if the connection failed
	            SOAPMessage response = connection.call(createSOAPRequest(soapAction, request), endpoint);
	            // Print the SOAP Response
	            System.out.println("Response SOAP Message:");
	            response.writeTo(System.out);
	            System.out.println();
	            connection.close();
	            return response;
	        }
	    }
	 
	 private SOAPMessage createSOAPRequest(String soapAction, pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();

	        createSoapEnvelope(soapMessage, request);

	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        headers.addHeader("SOAPAction", soapAction);

	        soapMessage.saveChanges();

	        /* Print the request message, just for debugging purposes */
	        System.out.println("Request SOAP Message:");
	        soapMessage.writeTo(System.out);
	        System.out.println("soapMessage: "+soapMessage );

	        return soapMessage;
	    }
	 
	 private void createSoapEnvelope(SOAPMessage soapMessage, pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) throws SOAPException, IOException {
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	       
	       String myNamespaceSgd = "ws";
	       String myNamespaceURISgd = "http://ws.wsiopidetramite.segdi.gob.pe/";
	       
	       SOAPEnvelope envelopeSgd = soapPart.getEnvelope();
	       
	       envelopeSgd.removeNamespaceDeclaration("SOAP-ENV");
	       envelopeSgd.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
	       envelopeSgd.setPrefix("soapenv");
	       soapMessage.getSOAPHeader().setPrefix("soapenv");
	       soapMessage.getSOAPBody().setPrefix("soapenv");
	       
	       
	       envelopeSgd.addNamespaceDeclaration(myNamespaceSgd, myNamespaceURISgd);
	       
	       // SOAP Body
	       SOAPBody soapBodySgd = envelopeSgd.getBody();
	       SOAPElement soapBodyElemSgd = soapBodySgd.addChildElement("consultarTramiteResponse", myNamespaceSgd);
	       SOAPElement soapBodyElem1Sgd = soapBodyElemSgd.addChildElement("request");
	       
	       SOAPElement soapBodyElem1SgdRequest = soapBodyElem1Sgd.addChildElement("vrucentrem");   
	       soapBodyElem1SgdRequest.addTextNode(request.getVrucentrem());
	       
	       SOAPElement soapBodyElem1SgdRequestvrucentrec = soapBodyElem1Sgd.addChildElement("vrucentrec");   
	       soapBodyElem1SgdRequestvrucentrec.addTextNode(request.getVrucentrec());
	       
	       SOAPElement soapBodyElem1SgdRequestvnomentemi = soapBodyElem1Sgd.addChildElement("vcuo");   
	       soapBodyElem1SgdRequestvnomentemi.addTextNode(request.getVcuo());
	       
	       
	    }
	 
	
}
