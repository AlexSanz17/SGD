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

public class WSPideValidarEntidad {
	private String PROXY_HOST = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST);
	private String PROXY_ACTIVE = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_ACTIVE);
	private String PROXY_PORT = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT);
	
	
	public String validarEntidadSOAP(String request) throws  Exception
	  {
		
	    String response = "";
	    String soapEndpointUrl = "";
	    try{
	    
	        System.out.println("=======Consultar tramite ===========");
	        soapEndpointUrl = SigedProperties
	    			.getProperty(SigedProperties.SigedPropertyEnum.URL_PIDE_ENTIDAD_DESARROLLO);
	        
	        String soapAction = "";

	        //callSoapWebService(soapEndpointUrl, soapAction);
	        
	        try {
	        	String proxy_address = PROXY_HOST;
        		int proxy_port = Integer.parseInt(PROXY_PORT);
	        	
	             ///Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(socket.getInetAddress(), PROXY_PORT));
	             Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy_address, proxy_port));
	             SOAPMessage message =  sendSOAPMessage(soapEndpointUrl,proxy , soapAction, request);
	             // get the body
	             SOAPBody soapBody = message.getSOAPBody();
	             // find your node based on tag name
	             NodeList nodes = soapBody.getChildNodes();

	             // check if the node exists and get the value
	            
	             Node node = nodes.item(0);
	             response = node != null ? node.getTextContent() : "";

	             System.out.println(response);
				
				
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
	    return response;
	  }
	 
		public SOAPMessage sendSOAPMessage(String url, final Proxy p, String soapAction,String request) throws Exception {
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
	 
	 private SOAPMessage createSOAPRequest(String soapAction, String request) throws Exception {
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
	 
	 private void createSoapEnvelope(SOAPMessage soapMessage, String request) throws SOAPException, IOException {
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	       
	       String myNamespaceSgd = "ws";
	       String myNamespaceURISgd = "http://ws.wsentidad.segdi.gob.pe/";
	       
	       SOAPEnvelope envelopeSgd = soapPart.getEnvelope();
	       
	       envelopeSgd.removeNamespaceDeclaration("SOAP-ENV");
	       envelopeSgd.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
	       envelopeSgd.setPrefix("soapenv");
	       soapMessage.getSOAPHeader().setPrefix("soapenv");
	       soapMessage.getSOAPBody().setPrefix("soapenv");
	       
	       
	       envelopeSgd.addNamespaceDeclaration(myNamespaceSgd, myNamespaceURISgd);
	       
	       // SOAP Body
	       SOAPBody soapBodySgd = envelopeSgd.getBody();
	       SOAPElement soapBodyElemSgd = soapBodySgd.addChildElement("validarEntidad", myNamespaceSgd);
	       
	       SOAPElement soapBodyElem1SgdRequest = soapBodyElemSgd.addChildElement("vrucent");   
	       soapBodyElem1SgdRequest.addTextNode(request);
	       
	       
	       
	       
	    }
	 
	
}