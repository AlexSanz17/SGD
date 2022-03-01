package org.ositran.ajax.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) {
		CargoRecepcionMPVRequest cargoRecepcionVirtualRequest = new CargoRecepcionMPVRequest();

	  try {

		URL url = new URL("http://172.27.0.98:8090/api/WebApiExpediente/ActualizarRecepcionMPV");
  		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  		conn.setDoOutput(true);
  		conn.setRequestMethod("POST");
  		conn.setRequestProperty("Content-Type", "application/json");
  		
  		cargoRecepcionVirtualRequest.seteDocumento("15909");
  		cargoRecepcionVirtualRequest.setcExpediente("23041983ABC123*");
  		cargoRecepcionVirtualRequest.setfFecha("22/02/2022 19:35:00");
  		cargoRecepcionVirtualRequest.seteUsuario("2");
  		cargoRecepcionVirtualRequest.seteEstadoDoc("2");
  		cargoRecepcionVirtualRequest.setfFechaRecep("22/02/2022 19:35:00");
  		cargoRecepcionVirtualRequest.setfFechaRecha("22/02/2022 19:35:00");
  		
//  		cargoRecepcionVirtualRequest.seteDocumento("151");
//  		cargoRecepcionVirtualRequest.setcExpediente("202200000100");
//  		cargoRecepcionVirtualRequest.setfFecha("2022/02/21 11:08:26");
//  		cargoRecepcionVirtualRequest.seteUsuario("1037");
//  		cargoRecepcionVirtualRequest.seteEstadoDoc("R");
//  		cargoRecepcionVirtualRequest.setfFechaRecep("2022/02/21 11:08:26");
//  		cargoRecepcionVirtualRequest.setfFechaRecha("");

  		ObjectMapper ow = new ObjectMapper();
  		String json = ow.writeValueAsString(cargoRecepcionVirtualRequest);

		OutputStream os = conn.getOutputStream();
		os.write(json.getBytes());
		os.flush();

//		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//			throw new RuntimeException("Failed : HTTP error code : "
//				+ conn.getResponseCode());
//		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }

	}

}
