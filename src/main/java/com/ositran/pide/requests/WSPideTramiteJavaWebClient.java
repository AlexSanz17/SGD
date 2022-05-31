package com.ositran.pide.requests;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import pe.gob.segdi.wsiopidetramite.ws.CargoTramite;
import pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite;
import pe.gob.segdi.wsiopidetramite.ws.IOTramite;
import pe.gob.segdi.wsiopidetramite.ws.IOTramiteService;
import pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceLocator;
import pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceSoapBindingStub;
import pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite;
import pe.gob.segdi.wsiopidetramite.ws.RespuestaCargoTramite;
import pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite;
import pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite;

public class WSPideTramiteJavaWebClient {

	public RespuestaConsultaTramite consultarTramite(ConsultaTramite request, String co_par) {

		System.out.println("Consultar Tramite");
		
		System.out.println("cuo -> " + request.getVcuo());
		System.out.println("rentrec -> " + request.getVrucentrec());
		System.out.println("centrem -> " + request.getVrucentrem());
		
		IOTramiteService iotramite = new IOTramiteServiceLocator();

		System.out.println("obtener");

		System.out.println(iotramite.getIOTramitePortAddress());

		IOTramite iotramitePortType;
		RespuestaConsultaTramite respuestaConsultaTramite = new RespuestaConsultaTramite();
		try {
			iotramitePortType = new IOTramiteServiceSoapBindingStub(new URL(iotramite.getIOTramitePortAddress()),
					iotramite);
			System.out.println("consultra tramite:");

			respuestaConsultaTramite = iotramitePortType.consultarTramiteResponse(request);

			System.out.println("Resultado");
			System.out.println(respuestaConsultaTramite.getVcodres());
			System.out.println(respuestaConsultaTramite.getVdesres());

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

		return respuestaConsultaTramite;

	}
	
	public RespuestaTramite recepcionarTramite(RecepcionTramite request, String co_par) {

		System.out.println("Recepcionar Tramite");
		
		System.out.println("cuo -> " + request.getVcuo());
		System.out.println("rentrec -> " + request.getVrucentrec());
		System.out.println("centrem -> " + request.getVrucentrem());
		
		IOTramiteService iotramite = new IOTramiteServiceLocator();

		System.out.println("obtener");

		System.out.println(iotramite.getIOTramitePortAddress());

		IOTramite iotramitePortType;
		RespuestaTramite respuestaTramite = new RespuestaTramite();
		try {
			iotramitePortType = new IOTramiteServiceSoapBindingStub(new URL(iotramite.getIOTramitePortAddress()),
					iotramite);


			respuestaTramite = iotramitePortType.recepcionarTramiteResponse(request);

			System.out.println("Resultado");
			System.out.println(respuestaTramite.getVcodres());
			System.out.println(respuestaTramite.getVdesres());

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

		return respuestaTramite;

	}
	
	public RespuestaCargoTramite cargoTramite(CargoTramite request, String co_par) {

		System.out.println("Cargo Tramite");
		
		System.out.println("cuo -> " + request.getVcuo());
		System.out.println("rentrec -> " + request.getVrucentrec());
		System.out.println("centrem -> " + request.getVrucentrem());
		
		IOTramiteService iotramite = new IOTramiteServiceLocator();

		System.out.println("obtener");

		System.out.println(iotramite.getIOTramitePortAddress());

		IOTramite iotramitePortType;
		RespuestaCargoTramite respuestaTramite = new RespuestaCargoTramite();
		try {
			iotramitePortType = new IOTramiteServiceSoapBindingStub(new URL(iotramite.getIOTramitePortAddress()),
					iotramite);


			respuestaTramite = iotramitePortType.cargoResponse(request);

			System.out.println("Resultado");
			System.out.println(respuestaTramite.getVcodres());
			System.out.println(respuestaTramite.getVdesres());

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

		return respuestaTramite;

	}
	
	


}
