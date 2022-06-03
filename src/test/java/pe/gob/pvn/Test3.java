package pe.gob.pvn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import org.jfree.util.Log;


public class Test3 {
	public static void main (String []args) throws IOException{
		try {
    		URL url = new URL("http://200.48.76.125/wsiopidetramite/IOTramite?wsdl");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//    		Log.info("conn estado................." + conn.getResponseCode());
    		conn.setDoOutput(true);
    		conn.setRequestMethod("POST");
    		conn.setRequestProperty("Content-Type", "application/xml");

    		String json = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.wsiopidetramite.segdi.gob.pe/\">\r\n"
    				+ "   <soapenv:Header/>\r\n"
    				+ "   <soapenv:Body>\r\n"
    				+ "      <ws:recepcionarTramiteResponse>\r\n"
    				+ "         <request>\r\n"
    				+ "            <vrucentrem>20503503639</vrucentrem>\r\n"
    				+ "            <vrucentrec>20168999926</vrucentrec>\r\n"
    				+ "            <vnomentemi>PROYECTO ESPECIAL DE INFRAESTRUCTURA DE TRANSPORTE NACIONAL - PROVIAS NACIONAL</vnomentemi>\r\n"
    				+ "            <vuniorgrem>ADMINISTRACION</vuniorgrem>\r\n"
    				+ "            <vcuo>0000000686</vcuo>\r\n"
    				+ "            <!--Optional:-->\r\n"
    				+ "            <vcuoref></vcuoref>\r\n"
    				+ "            <ccodtipdoc>01</ccodtipdoc>\r\n"
    				+ "            <vnumdoc>OFICIO - 14-00001-16700-2021-11-000038-5</vnumdoc>\r\n"
    				+ "            <dfecdoc>2021-03-04T13:31:00</dfecdoc>\r\n"
    				+ "            <vuniorgdst>OTI</vuniorgdst>\r\n"
    				+ "            <vnomdst>Miguel Coello</vnomdst>\r\n"
    				+ "            <vnomcardst>Jefe</vnomcardst>\r\n"
    				+ "            <vasu>Prueba</vasu>\r\n"
    				+ "            <snumanx>0</snumanx>\r\n"
    				+ "            <snumfol>1</snumfol>\r\n"
    				+ "            <bpdfdoc>Y1NwolJUVPRgo=</bpdfdoc>\r\n"
    				+ "            <vnomdoc>Prueba Oficio</vnomdoc>\r\n"
    				+ "            <!--Zero or more repetitions:-->\r\n"
    				+ "            <lstanexos>\r\n"
    				+ "               <!--Optional:-->\r\n"
    				+ "               <vnomdoc>?</vnomdoc>\r\n"
    				+ "            </lstanexos>\r\n"
    				+ "            <!--Optional:-->\r\n"
    				+ "            <vurldocanx>?</vurldocanx>\r\n"
    				+ "            <ctipdociderem>1</ctipdociderem>\r\n"
    				+ "            <vnumdociderem>01234567</vnumdociderem>\r\n"
    				+ "         </request>\r\n"
    				+ "      </ws:recepcionarTramiteResponse>\r\n"
    				+ "   </soapenv:Body>\r\n"
    				+ "</soapenv:Envelope>";

      		OutputStream os = conn.getOutputStream();
      		os.write(json.getBytes());
      		os.flush();

      		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	
      		String content = "";
      		StringBuilder stringBuilder = new StringBuilder();
      		String output = "";
      		
      		while ((output = br.readLine()) != null) {
      			stringBuilder.append(output);
      		}

      		content = stringBuilder.toString();
      		
      		if (content.length() > 0) {
      			System.out.println(content);
//				JSONObject jsonObject = (JSONObject) (new JSONParser()).parse(output);
//				cargoRecepcionMPVResponse.setbSuccess(jsonObject.get("bSuccess").toString());
//				cargoRecepcionMPVResponse.seteErrorCode(jsonObject.get("eErrorCode").toString());
//				cargoRecepcionMPVResponse.setcMessage(jsonObject.get("cMessage").toString());
//				cargoRecepcionMPVResponse.setcTraceError(jsonObject.get("cTraceError").toString());
//				cargoRecepcionMPVResponse.setcData(jsonObject.get("cData").toString());
      		}
      		
      		br.close();

      	  } catch (MalformedURLException e) {
      		e.printStackTrace();

      	  } catch (IOException e) {
      		e.printStackTrace();
      		
//      	  } catch (ParseException e) {
//			e.printStackTrace();
		}
	}
	
}