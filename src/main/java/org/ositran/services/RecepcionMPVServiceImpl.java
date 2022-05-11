package org.ositran.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.jfree.util.Log;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.ositran.ajax.beans.CargoRecepcionMPVRequest;
import org.ositran.ajax.beans.CargoRecepcionMPVResponse;
import org.ositran.daos.RecepcionMPVDAO;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecepcionMPVServiceImpl implements RecepcionMPVService {    
	RecepcionMPVDAO recepcionMPVDAO;

    public RecepcionMPVDAO getRecepcionMPVDAO() {
		return recepcionMPVDAO;
	}

	public void setRecepcionMPVDAO(RecepcionMPVDAO recepcionMPVDAO) {
		this.recepcionMPVDAO = recepcionMPVDAO;
	}

	public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion){
       return recepcionMPVDAO.registrarDocumento(recepcion);
    }
    
    public List<IotdtcRecepcion> getAll(){
        return recepcionMPVDAO.findAll();
    }
    
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV){
        return recepcionMPVDAO.registrarDocumentoMPV(recepcionMPV);
    }
    
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV(){
       return recepcionMPVDAO.consultarDocPendientesAlfrescoMPV();
    }

    @Transactional
	@Override
	public void rechazarDocumentoMPV(Integer idDocumento, String observacion, String estado, Date fecha, String usuario) {
    	recepcionMPVDAO.rechazarDocumentoMPV(idDocumento, observacion, estado, fecha, usuario);
	}
    
    @Override
	public CargoRecepcionMPVResponse enviarCargo(CargoRecepcionMPVRequest cargoRecepcionMPVRequest) {
    	CargoRecepcionMPVResponse cargoRecepcionMPVResponse = null;
    	
    	try {
    		URL url = new URL("http://172.27.0.98:8090/api/WebApiExpediente/ActualizarRecepcionMPV");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		Log.info("conn estado................." + conn.getResponseCode());
    		conn.setDoOutput(true);
    		conn.setRequestMethod("POST");
    		conn.setRequestProperty("Content-Type", "application/json");

    		ObjectMapper ow = new ObjectMapper();
    		String json = ow.writeValueAsString(cargoRecepcionMPVRequest);

      		OutputStream os = conn.getOutputStream();
      		os.write(json.getBytes());
      		os.flush();

      		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	
      		String output = "";
      		
      		while ((output = br.readLine()) != null) {
      			System.out.println(output);
      		}

      		if (output.length() > 0) {
				JSONObject jsonObject = (JSONObject) (new JSONParser()).parse(output);
				cargoRecepcionMPVResponse.setbSuccess(jsonObject.get("bSuccess").toString());
				cargoRecepcionMPVResponse.seteErrorCode(jsonObject.get("eErrorCode").toString());
				cargoRecepcionMPVResponse.setcMessage(jsonObject.get("cMessage").toString());
				cargoRecepcionMPVResponse.setcTraceError(jsonObject.get("cTraceError").toString());
				cargoRecepcionMPVResponse.setcData(jsonObject.get("cData").toString());
      		}
      		
      		br.close();

      	  } catch (MalformedURLException e) {
      		e.printStackTrace();

      	  } catch (IOException e) {
      		e.printStackTrace();
      		
      	  } catch (ParseException e) {
			e.printStackTrace();
		}
    	
        return cargoRecepcionMPVResponse;
     }
}