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

public class Test1 {	
	public static void main (String[] args) {
		try  {
		  	
          	NotificacionCasillaVirtual notificacion = new NotificacionCasillaVirtual();
          	notificacion.servicio2("https://apigatewaydesa.pvn.gob.pe/api/v1/Notificacion/generar-notificacion", "D:\\\\Frank\\\\CV\\\\INCAMAPS\\\\SGD\\\\SGD\\\\Informe de Servicio de Notificación Electrónica V3.pdf");
          	
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
			
		}
	}
}
