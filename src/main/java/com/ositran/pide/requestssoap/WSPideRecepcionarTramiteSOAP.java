package com.ositran.pide.requestssoap;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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


import com.ositran.ws.ConsultaTramite;
import com.ositran.ws.RecepcionTramite;
import com.ositran.ws.RespuestaCargoTramite;
import com.ositran.ws.RespuestaConsultaTramite;
import com.ositran.ws.RespuestaTramite;

public class WSPideRecepcionarTramiteSOAP {

	
	public RespuestaTramite recepcionarTramiteSOAP(RecepcionTramite request, String co_par) throws  Exception
	  {
		RespuestaTramite respuestaConsultaTramiteSOAP = new RespuestaTramite();
	    System.out.println("========proceso consultar tramite ");
	    System.out.println("co_par" + co_par);
	    try{
	     if (co_par.equals("D")) {
	    	System.out.println("========Obtener IOTramite===== ");
	        System.out.println("=======Consultar tramite ===========");
	        System.out.println(request.getVcuo());
	        System.out.println(request.getVrucentrec());
	        System.out.println(request.getVrucentrem());
	        
	        
	        String soapEndpointUrl = "http://200.48.76.125/wsiopidetramite/IOTramite";
	        String soapAction = "";

	        //callSoapWebService(soapEndpointUrl, soapAction);
	        
	        try {
	        	 String PROXY_ADDRESS = "proxy1";
	             int PROXY_PORT = 8080;
	        	
	             ///Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(socket.getInetAddress(), PROXY_PORT));
	             Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDRESS, PROXY_PORT));
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
	        
	        
	     }else if (co_par.equals("P")) {
	        //respuestaConsultaTramite = getIOTramiteProduccion().consultarTramiteResponse(request);
	     }else if (co_par.equals("O")) {
	        //respuestaConsultaTramite = getIOTramiteOsitran().consultarTramiteResponse(request.getVcuo());
	     }
	    }
	    catch (Exception e){
	        throw e;
	    }
	    return respuestaConsultaTramiteSOAP;
	  }
	 
		public SOAPMessage sendSOAPMessage(String url, final Proxy p, String soapAction,RecepcionTramite request) throws Exception {
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
	 
	 private SOAPMessage createSOAPRequest(String soapAction, RecepcionTramite request) throws Exception {
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
	 
	 private void createSoapEnvelope(SOAPMessage soapMessage, RecepcionTramite request) throws SOAPException, IOException {
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
	       SOAPElement soapBodyElemSgd = soapBodySgd.addChildElement("recepcionarTramiteResponse", myNamespaceSgd);
	       SOAPElement soapBodyElem1Sgd = soapBodyElemSgd.addChildElement("request");
	       
	       
	       SOAPElement soapBodyElem1SgdRequest = soapBodyElem1Sgd.addChildElement("vrucentrem");   
	       soapBodyElem1SgdRequest.addTextNode(request.getVrucentrem());
	       
	       SOAPElement soapBodyElem1SgdRequestvrucentrec = soapBodyElem1Sgd.addChildElement("vrucentrec");   
	       soapBodyElem1SgdRequestvrucentrec.addTextNode(request.getVrucentrec());
	       
	       SOAPElement soapBodyElem1SgdRequestvnomentemi = soapBodyElem1Sgd.addChildElement("vnomentemi");   
	       soapBodyElem1SgdRequestvnomentemi.addTextNode(request.getVnomentemi());
	       
	       SOAPElement soapBodyElem1SgdRequestvuniorgrem = soapBodyElem1Sgd.addChildElement("vuniorgrem");   
	       soapBodyElem1SgdRequestvuniorgrem.addTextNode(request.getVuniorgrem());
	       
	       SOAPElement soapBodyElem1SgdRequestvcuo = soapBodyElem1Sgd.addChildElement("vcuo");   
	       soapBodyElem1SgdRequestvcuo.addTextNode(request.getVcuo());
	       
	       SOAPElement soapBodyElem1SgdRequestccodtipdoc = soapBodyElem1Sgd.addChildElement("ccodtipdoc");   
	       soapBodyElem1SgdRequestccodtipdoc.addTextNode(request.getCcodtipdoc());
	       
	       SOAPElement soapBodyElem1SgdRequestvnumdoc = soapBodyElem1Sgd.addChildElement("vnumdoc");   
	       soapBodyElem1SgdRequestvnumdoc.addTextNode(request.getVnumdoc());
	       
	       //XMLGregorianCalendar to  String?
	       Calendar calendar = request.getDfecdoc().toGregorianCalendar();
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyyy-MM-dd'T'HH:mm:ss");
	       
	       formatter.setTimeZone(calendar.getTimeZone());
	       String dateString = formatter.format(calendar.getTime());
	       
	       SOAPElement soapBodyElem1SgdRequestdfecdoc = soapBodyElem1Sgd.addChildElement("dfecdoc");   
	       soapBodyElem1SgdRequestdfecdoc.addTextNode(dateString);
	       
	       SOAPElement soapBodyElem1SgdRequestvuniorgdst = soapBodyElem1Sgd.addChildElement("vuniorgdst");   
	       soapBodyElem1SgdRequestvuniorgdst.addTextNode(request.getVuniorgdst());
	       
	       SOAPElement soapBodyElem1SgdRequestvnomdst = soapBodyElem1Sgd.addChildElement("vnomdst");   
	       soapBodyElem1SgdRequestvnomdst.addTextNode(request.getVnomdst());
	       
	       SOAPElement soapBodyElem1SgdRequestvnomcardst = soapBodyElem1Sgd.addChildElement("vnomcardst");   
	       soapBodyElem1SgdRequestvnomcardst.addTextNode(request.getVnomcardst());
	       
	       SOAPElement soapBodyElem1SgdRequestvasu = soapBodyElem1Sgd.addChildElement("vasu");   
	       soapBodyElem1SgdRequestvasu.addTextNode(request.getVasu());
	       
	       SOAPElement soapBodyElem1SgdRequestsnumanx = soapBodyElem1Sgd.addChildElement("snumanx");   
	       soapBodyElem1SgdRequestsnumanx.addTextNode(request.getSnumanx()+"");
	       
	       SOAPElement soapBodyElem1SgdRequestsnumfol = soapBodyElem1Sgd.addChildElement("snumfol");   
	       soapBodyElem1SgdRequestsnumfol.addTextNode(request.getSnumfol()+"");
	       
	       //Byte a string
	       String stringBpdfdoc = new String(request.getBpdfdoc());
	       
	       SOAPElement soapBodyElem1SgdRequestbpdfdoc = soapBodyElem1Sgd.addChildElement("bpdfdoc");   
	       soapBodyElem1SgdRequestbpdfdoc.addTextNode(stringBpdfdoc);
	       
	       SOAPElement soapBodyElem1SgdRequestvnomdoc = soapBodyElem1Sgd.addChildElement("vnomdoc");   
	       soapBodyElem1SgdRequestvnomdoc.addTextNode(request.getVnomdoc());
	       
	       SOAPElement soapBodyElem1SgdRequestctipdociderem = soapBodyElem1Sgd.addChildElement("ctipdociderem");   
	       soapBodyElem1SgdRequestctipdociderem.addTextNode(request.getCtipdociderem());
	       
	       SOAPElement soapBodyElem1SgdRequestvnumdociderem = soapBodyElem1Sgd.addChildElement("vnumdociderem");   
	       soapBodyElem1SgdRequestvnumdociderem.addTextNode(request.getVnumdociderem());
	       
	       
	       
	    }
	 
	
}
