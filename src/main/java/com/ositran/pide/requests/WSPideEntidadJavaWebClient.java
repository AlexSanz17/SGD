package com.ositran.pide.requests;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import pe.gob.segdi.wsentidad.ws.Entidad;
import pe.gob.segdi.wsentidad.ws.EntidadService;
import pe.gob.segdi.wsentidad.ws.EntidadServiceLocator;
import pe.gob.segdi.wsentidad.ws.EntidadServiceSoapBindingStub;


public class WSPideEntidadJavaWebClient {

	public String validarEntidad(String vrucent) {

		System.out.println("Validar Entidad");
		
		
		EntidadService entidadservice = new EntidadServiceLocator();
		System.out.println("obtener");

		System.out.println(entidadservice.getEntidadPortAddress());
		//System.out.println(iotramite.get);
		Entidad entidad;
		String response = "";
		try {
			entidad = new EntidadServiceSoapBindingStub(new URL(entidadservice.getEntidadPortAddress()), entidadservice);
		
			response = entidad.validarEntidad("20131370726");
		
		
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;

	}

}
