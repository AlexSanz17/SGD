package pe.gob.pvn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test2 {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		Test2 http = new Test2();
	
		// Sending post request
		http.sendingPostRequest();

	}


	// HTTP Post request
	private void sendingPostRequest() throws Exception {
	 
	  String url = "http://172.27.0.98:8090/api/WebApiExpediente/ActualizarRecepcionMPV";
	  URL obj = new URL(url);
	  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
	        // Setting basic post request
	  con.setRequestMethod("POST");
	  con.setRequestProperty("User-Agent", USER_AGENT);
	  
//	  con.setRequestProperty("Content-Type","application/json");
	 
	  String postJsonData = "{\"Fk_eDocumento\": \"34191\",\"cExpediente\": \"E-00000339-2022/SEDCEN\",\"fFecha\": \"21/03/2022 19:35:00\",\"Fk_eUsuario\": \"1037\",\"EstadoDoc\": \"2\",\"cObservacion\": \"\",\"fFechaRecep\": \"21/03/2022 19:35:00\",\"fFechaRecha\": \"\"\r\n"
	  		+ "}";
	 
	  // Send post request
	  con.setDoOutput(true);
	  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	  wr.writeBytes(postJsonData);
	  wr.flush();
	  wr.close();
	 
	  int responseCode = con.getResponseCode();
	  System.out.println("nSending 'POST' request to URL : " + url);
	  System.out.println("Post Data : " + postJsonData);
	  System.out.println("Response Code : " + responseCode);
	  System.out.println(con.getContentType()); 
	 
	  BufferedReader in = new BufferedReader(
	          new InputStreamReader(con.getInputStream()));
	  String output;
	  StringBuffer response = new StringBuffer();
	 
	  while ((output = in.readLine()) != null) {
	   response.append(output);
	  }
	  in.close();
	 
	  System.out.println("RESPONSE:");
	  //printing result from response
	  System.out.println(response.toString());
	 }

}