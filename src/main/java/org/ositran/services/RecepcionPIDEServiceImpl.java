package org.ositran.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jfree.util.Log;
import org.ositran.ajax.beans.CargoRecepcionPIDERequest;
import org.ositran.ajax.beans.CargoRecepcionPIDEResponse;
import org.ositran.daos.RecepcionPIDEDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

@Service
public class RecepcionPIDEServiceImpl implements RecepcionPIDEService {
	@Autowired(required=false)
	RecepcionPIDEDAO recepcionPIDEDAO;
    
	public RecepcionPIDEDAO getRecepcionPIDEDAO() {
		return recepcionPIDEDAO;
	}

	public void setRecepcionPIDEDAO(RecepcionPIDEDAO recepcionPIDEDAO) {
		this.recepcionPIDEDAO = recepcionPIDEDAO;
	}

	@Override
	public IotdtcRecepcion findBySidrecext(Integer sidrecext){
    	return recepcionPIDEDAO.findBySidrecext(sidrecext);
    }

	@Override
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion){
       return recepcionPIDEDAO.registrarDocumento(recepcion);
    }
    
	@Override
    public IotdtmDocExterno registrarDocExterno(IotdtmDocExterno docExterno){
       return recepcionPIDEDAO.registrarDocExterno(docExterno);
    }
    
	@Override
    public IotdtdDocPrincipal registrarDocPrincipal(IotdtdDocPrincipal docPrincipal){
       return recepcionPIDEDAO.registrarDocPrincipal(docPrincipal);
    }
    
	@Override
    public IotdtdAnexo registrarAnexo(IotdtdAnexo docAnexo){
       return recepcionPIDEDAO.registrarAnexo(docAnexo);
    }
    
	@Override
	public CargoRecepcionPIDEResponse enviarCargo(CargoRecepcionPIDERequest cargoRecepcionPIDERequest) {
    	CargoRecepcionPIDEResponse cargoRecepcionPIDEResponse = null;
    	
    	try {
    		URL url = new URL("http://200.48.76.125/wsiopidetramite/IOTramite?wsdl");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//    		Log.info("conn estado................." + conn.getResponseCode());
    		conn.setDoOutput(true);
    		conn.setRequestMethod("POST");
    		conn.setRequestProperty("Content-Type", "application/xml");

    		String json = "";

      		OutputStream os = conn.getOutputStream();
      		os.write(json.getBytes());
      		os.flush();

      		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	
      		String output = "";
      		
      		while ((output = br.readLine()) != null) {
      			System.out.println(output);
      		}

      		if (output.length() > 0) {
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
    	
        return cargoRecepcionPIDEResponse;
     }
}