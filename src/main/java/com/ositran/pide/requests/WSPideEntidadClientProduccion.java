package com.ositran.pide.requests;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidad;
import pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadLocator;
import pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadPortType;
import pe.gob.segdi.wsentidadprod.ws.PcmIMgdEntidadSoap11BindingStub;


	public class WSPideEntidadClientProduccion {

		public String validarEntidad(String vrucent) {

			System.out.println("Validar Entidad");
			
			
			PcmIMgdEntidad entidadservice = new PcmIMgdEntidadLocator();
			System.out.println("obtener");

			System.out.println(entidadservice.getPcmIMgdEntidadHttpsSoap11EndpointAddress());
			//System.out.println(iotramite.get);
			PcmIMgdEntidadPortType entidad;
			String response = "";
			try {
				entidad = new PcmIMgdEntidadSoap11BindingStub(new URL(entidadservice.getPcmIMgdEntidadHttpsSoap11EndpointAddress()), entidadservice);
			
				response = entidad.validarEntidad(vrucent);
			
			
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

//	PcmIMgdEntidad servcio = new PcmIMgdEntidadLocator();
//	PcmIMgdEntidadPortType ws;
//	try {
//		ws = new PcmIMgdEntidadSoap11BindingStub(new URL(servcio.getPcmIMgdEntidadHttpsSoap11EndpointAddress()), servcio);
//		System.out.println("respuesta: " +ws.validarEntidad("1"));
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
