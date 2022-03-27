package gob.pe.pvn;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jfree.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotificacionCasillaVirtual {
	@SuppressWarnings("deprecation")
	public void servicio2(String url, String archivo)  {
		@SuppressWarnings("deprecation")
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
	try  {
			File f = new File(archivo);
//			httpPost.addHeader("content-type", "multipart/form-data");

			JSONObject notificacion = new JSONObject();

			JSONObject expedienteJson = new JSONObject();
			expedienteJson.put("eIdExpedienteSTD", Integer.valueOf(123456));
			expedienteJson.put("uCodExpedienteSTD", "EXPEDIENTE N° 1234-TEST");
			expedienteJson.put("eOrden", Integer.valueOf(1));

			JSONArray expedienteArray = new JSONArray();
			expedienteArray.put(expedienteJson);

			JSONObject doc = new JSONObject();
			doc.put("FK_eIdTipoDocNotificacion", Integer.valueOf(1));
			doc.put("uNumDocNotificacion", "123-2022/STD");
			doc.put("FK_eIdTipoDocNotificacion", Integer.valueOf(123343));
			doc.put("Expedientes", expedienteArray);

			notificacion.put("FK_eIdCasilla", Integer.valueOf(117));
			notificacion.put("FK_eIdAplicacion", Integer.valueOf(3));
			notificacion.put("FK_eIdTipoNotificacion", Integer.valueOf(1));
			notificacion.put("uObservacion", "ESTO ES UNA PRUEBA");
			notificacion.put("Documento", doc);
			notificacion.put("eUsuarioRegistro", Integer.valueOf(1));

			String notificacionJson = notificacion.toString();

			System.out.println(notificacionJson);
			
//			StringBody userBody = new StringBody(notificacionJson);
//			System.out.println(userBody);
//			Log.info("--------------------" +userBody);
//			FileBody fileBody = new FileBody(f);
			MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
			entityBuilder.addPart("Notificacion", new StringBody(notificacionJson));
			entityBuilder.addPart("ArchivoDocumento", new FileBody(f));
//			HttpEntity entity = entityBuilder.build();
			httpPost.setEntity(entityBuilder.build());

	
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("responseBody : " + responseBody);
			
			
//			System.out.println("Resultado posterior a la devolución" + sResponse);
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			e.printStackTrace();
			
		}
	}
}
