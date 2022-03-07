/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import java.util.List;

import org.ositran.daos.RecepcionVirtualDAO;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public class RecepcionVirtualServiceImpl implements RecepcionVirtualService {    
	RecepcionVirtualDAO recepcionVirtualDAO;

    public RecepcionVirtualDAO getRecepcionVirtualDAO() {
        return recepcionVirtualDAO;
    }

    public void setRecepcionVirtualDAO(RecepcionVirtualDAO recepcionVirtualDAO) {
        this.recepcionVirtualDAO = recepcionVirtualDAO;
    }

    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion){
       return recepcionVirtualDAO.registrarDocumento(recepcion);
    }
    
<<<<<<< HEAD
    public List<IotdtcRecepcion> getAll(){
        return recepcionVirtualDAO.findAll();
=======
    public CargoRecepcionMPVResponse enviarCargoRecepcion(CargoRecepcionMPVRequest cargoRecepcionVirtualRequest){
    	CargoRecepcionMPVResponse cargoRecepcionVirtualResponse = null;
    	
    	try {
    		URL url = new URL("http://172.27.0.98:8090/api/WebApiExpediente/ActualizarRecepcionMPV");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setDoOutput(true);
    		conn.setRequestMethod("POST");
    		conn.setRequestProperty("Content-Type", "application/json");

    		cargoRecepcionVirtualRequest.seteDocumento("15909");
    		cargoRecepcionVirtualRequest.setcExpediente("23041983ABC123");
    		cargoRecepcionVirtualRequest.setfFecha("22/02/2022 19:35:00");
    		cargoRecepcionVirtualRequest.seteUsuario("2");
    		cargoRecepcionVirtualRequest.seteEstadoDoc("2");
    		cargoRecepcionVirtualRequest.setfFechaRecep("22/02/2022 19:35:00");
    		cargoRecepcionVirtualRequest.setfFechaRecha("22/02/2022 19:35:00");
    		
    		String input = String.valueOf(cargoRecepcionVirtualRequest);

    		OutputStream os = conn.getOutputStream();
    		os.write(input.getBytes());
    		os.flush();

    		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
    			throw new RuntimeException("Failed : HTTP error code : "
    				+ conn.getResponseCode());
    		}

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
    	
        return cargoRecepcionVirtualResponse;
>>>>>>> bca7b4a1670d733328abeb3b883511101426ded6
     }
    
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV){
        return recepcionVirtualDAO.registrarDocumentoMPV(recepcionMPV);
    }
    
    public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV(){
       return recepcionVirtualDAO.consultarDocPendientesAlfrescoMPV();
    }
}
