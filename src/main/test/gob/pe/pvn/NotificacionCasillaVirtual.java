package gob.pe.pvn;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;

import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;

import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.util.EntityUtils;
import org.jfree.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotificacionCasillaVirtual {
	
	public void servicio1(String url) {
		try {
      	  URL url_c = new URL(url);
      		HttpURLConnection conn = (HttpURLConnection) url_c.openConnection();
      		conn.setDoOutput(true);
      		conn.setRequestMethod("POST");
      		conn.setRequestProperty("Content-Type", "application/json");
      		
      		JSONObject jsonObj = new JSONObject();

			jsonObj.put("eIdTipoDocumento", Integer.valueOf(2));
			jsonObj.put("uNroDocumento", "40405068");
      		
			String json = jsonObj.toString();
      	System.out.println("json : "+json);
  		OutputStream os = conn.getOutputStream();
  		os.write(json.getBytes());
  		os.flush();

  		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	
  		String output;
  		
  		while ((output = br.readLine()) != null) {
//  			System.out.println(output);
  		}

  		conn.disconnect();
	  	} catch (IOException e ) {
	  		e.printStackTrace();
	  	}
	}
	
	public String servicio2(String url, String archivo, String observacion, Integer tipodocumento, String nroDocumento)  {
//		@SuppressWarnings("deprecation")
//		HttpClient httpclient = new DefaultHttpClient();
//		HttpPost httpPost = new HttpPost(url);
		System.out.println("Ejecutar segundo servicio");
		String response = "";
		try {
			File f = new File(archivo);
			
//			System.out.println("================0archivo"+f);
			JSONObject notificacion = new JSONObject();
			JSONObject expediente = new JSONObject();
			expediente.put("eIdExpedienteSTD", Integer.valueOf(123456));
			expediente.put("uCodExpedienteSTD", "EXPEDIENTE N° 1234-TEST");
			expediente.put("eOrden", Integer.valueOf(1));

			JSONArray expedienteArray = new JSONArray();
			expedienteArray.put(expediente);

			JSONObject doc = new JSONObject();
			doc.put("FK_eIdTipoDocNotificacion", tipodocumento);
			doc.put("uNumDocNotificacion", nroDocumento);
			doc.put("eIdDocumentoSTD", Integer.valueOf(123343));
			doc.put("Expedientes", expedienteArray);

			notificacion.put("FK_eIdCasilla", Integer.valueOf(117));
			notificacion.put("FK_eIdAplicacion", Integer.valueOf(3));
			notificacion.put("FK_eIdTipoNotificacion", Integer.valueOf(15));
			notificacion.put("uObservacion", observacion);
			notificacion.put("Documento", doc);
			notificacion.put("eUsuarioRegistro", Integer.valueOf(1));
			String notificacionJson = notificacion.toString();
//			System.out.println(notificacionJson);
			response = executeMultiPartRequest(url,f, notificacionJson, null);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
				return response;
	}
	
	public void servicio3(String url, Integer PK_eIdNotificacion) {
		
		try {
	    		URL url_c = new URL(url);
	    		HttpURLConnection conn = (HttpURLConnection) url_c.openConnection();
	    		conn.setDoOutput(true);
	    		conn.setRequestMethod("PUT");
	    		conn.setRequestProperty("Content-Type", "application/json");
	    		
	    		JSONObject jsonObj = new JSONObject();
	    		
	    		jsonObj.put("PK_eIdNotificacion", PK_eIdNotificacion);
	    		jsonObj.put("uUnidadOrganica", "SUBDIRECCIÓN DE OPERACIONES");
	    		jsonObj.put("eUsuarioActualizacion", Integer.valueOf(1));
	    		
	    		String json = jsonObj.toString();
	    		OutputStream os = conn.getOutputStream();
	    		os.write(json.getBytes());
	    		os.flush();
	    		
	    		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	
	    		String output;
	    		
	    		while ((output = br.readLine()) != null) {
//	    			System.out.println(output);
	    			
	    		}
	    		
	    		conn.disconnect();
	    		
	    	} catch (IOException e ) {
	    		e.printStackTrace();
	    	}
		
	}
	public void servicio4(String url, Integer PK_eIdNotificacion) {
		try {
	    		URL url_c = new URL(url);
	    		HttpURLConnection conn = (HttpURLConnection) url_c.openConnection();
	    		conn.setDoOutput(true);
	    		conn.setRequestMethod("PUT");
	    		conn.setRequestProperty("Content-Type", "application/json");
	    		
	    		JSONObject jsonObj = new JSONObject();
	    		jsonObj.put("PK_eIdNotificacion", PK_eIdNotificacion);
	    		jsonObj.put("cCodProcesoFirma", "123456789");
	    		jsonObj.put("eUsuarioActualizacion", Integer.valueOf(1));
	    		
	    		String json = jsonObj.toString();
	    		OutputStream os = conn.getOutputStream();
	    		os.write(json.getBytes());
	    		os.flush();
	    		
	    		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	
	    		String output;
	    		
	    		while ((output = br.readLine()) != null) {
//	    			System.out.println(output);
	    		}
	    		
	    		conn.disconnect();
	    	} catch (IOException e ) {
	    		e.printStackTrace();
	    	}
	}
	
	
	public String executeRequest(HttpRequestBase requestBase){
        String responseString = "" ;
 
        InputStream responseStream = null ;
        @SuppressWarnings("deprecation")
		HttpClient client = new DefaultHttpClient () ;
        try{
            HttpResponse response = client.execute(requestBase) ;
            if (response != null){
                HttpEntity responseEntity = response.getEntity() ;
 
                if (responseEntity != null){
                    responseStream = responseEntity.getContent() ;
                    if (responseStream != null){
                        BufferedReader br = new BufferedReader (new InputStreamReader (responseStream)) ;
                        String responseLine = br.readLine() ;
                        String tempResponseString = "" ;
                        while (responseLine != null){
                            tempResponseString = tempResponseString + responseLine + System.getProperty("line.separator") ;
                            responseLine = br.readLine() ;
                        }
                        br.close() ;
                        if (tempResponseString.length() > 0){
                            responseString = tempResponseString ;
                        }
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (responseStream != null){
                try {
                    responseStream.close() ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        client.getConnectionManager().shutdown() ;
 
//        System.out.println(responseString); 
        
        return responseString ;
    }
 
    /**
     * Method that builds the multi-part form data request
     * @param urlString the urlString to which the file needs to be uploaded
     * @param file the actual file instance that needs to be uploaded
     * @param jsonBody
     * @return server response as <code>String</code>
     * @throws UnsupportedEncodingException 
     */
    @SuppressWarnings("deprecation")
	public String executeMultiPartRequest(String urlString, File file, String jsonBody, Map<String, String>headerMap) throws UnsupportedEncodingException {
 
        HttpPost postRequest = new HttpPost (urlString) ;

        if(headerMap != null) {
	        for(String headerKey : headerMap.keySet()) {
	            postRequest.addHeader(headerKey, headerMap.get(headerKey));
	        }
        }

//        MultipartEntity multiPartEntity = new MultipartEntity ();
        MultipartEntity multipart = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

		// add json body
		StringBody jsonContentStringBody = new  StringBody(jsonBody, "application/json", Charset.forName("UTF-8"));
		multipart.addPart("Notificacion", jsonContentStringBody);

		/*Need to construct a FileBody with the file that needs to be attached and specify the mime type of the file. Add the fileBody to the request as an another part.
		This part will be considered as file part and the rest of them as usual form-data parts*/
		FileBody fileBody = new FileBody(file);
		multipart.addPart("ArchivoDocumento", fileBody);
 
		postRequest.setEntity(multipart) ;
 
        return executeRequest(postRequest) ;
    }}
	
  