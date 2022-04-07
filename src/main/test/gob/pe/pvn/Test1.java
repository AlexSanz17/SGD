package gob.pe.pvn;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.ositran.utils.DocumentoDetail;

import com.btg.ositran.siged.domain.Documento;


public class Test1 {	
	public static void main (String[] args) {
		try  {

//			final NotificacionCasillaVirtual notificacion = new NotificacionCasillaVirtual();
//       		Thread servicio1 = new Thread() {
//        	    public void run() {
//              		
//			}};
//			servicio1.start();
//			servicio1.join();
			
			
			NotificacionCasillaVirtual notificacion = new NotificacionCasillaVirtual();
			notificacion.servicio1("https://apigatewaydesa.pvn.gob.pe/api/v1/Notificacion/buscar-casilla-por-documento");	          	    	
	
			DocumentoDetail objDD = new DocumentoDetail();
			final String observacion = "Esto es una prueba";
			final Integer tipoDocumento = 1;
			final String nroDocumento = "123-2022/STD";

				String response = notificacion.servicio2("https://apigatewaydesa.pvn.gob.pe/api/v1/Notificacion/generar-notificacion", 
						"D:\\Frank\\CV\\INCAMAPS\\SGD\\manual\\SignNet - Manual de Usuario Firmante.pdf",
						observacion,tipoDocumento, nroDocumento);	          	    	
				
				JSONObject jsonObject = new JSONObject(response);
				Integer pK_eIdNotificacion = jsonObject.getJSONObject("data").getInt("pK_eIdNotificacion");
				 
				System.out.println(pK_eIdNotificacion);


			
//			Thread servicio3 = new Thread() {
//          	    public void run() {
		        notificacion.servicio3("https://apigatewaydesa.pvn.gob.pe/api/v1/Notificacion/generar-cedula-notificacion", pK_eIdNotificacion);
//          	    	
		        notificacion.servicio4("https://apigatewaydesa.pvn.gob.pe/api/v1/Notificacion/enviar-notificacion", pK_eIdNotificacion);
//			}};
//			servicio3.start();
//			servicio3.join();
//			Thread servicio4 = new Thread() {
//          	    public void run() {
//			}};
//			servicio4.start();
//			servicio4.join();

          	
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
			
		}
	}
}

