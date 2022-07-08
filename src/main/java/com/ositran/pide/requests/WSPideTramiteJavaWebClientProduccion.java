package com.ositran.pide.requests;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.ositran.ws.RespuestaConsultaTramite;

import pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite;
import pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramite;
import pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteLocator;
import pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramitePortType;
import pe.gob.segdi.wsiopidetramiteprod.ws.PcmIMgdTramiteSoap11BindingStub;


public class WSPideTramiteJavaWebClientProduccion {

	public pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite consultarTramite(pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite request) {

		System.out.println("Consultar Tramite");
		
		System.out.println("cuo -> " + request.getVcuo());
		System.out.println("rentrec -> " + request.getVrucentrec());
		System.out.println("centrem -> " + request.getVrucentrem());
		
		PcmIMgdTramite iotramite = new PcmIMgdTramiteLocator();

		System.out.println("obtener");

		System.out.println(iotramite.getPcmIMgdTramiteHttpsSoap11EndpointAddress());

		PcmIMgdTramitePortType iotramitePortType;
		pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite respuestaConsultaTramite = new pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite();
		try {
		
				iotramitePortType = new PcmIMgdTramiteSoap11BindingStub(new URL(iotramite.getPcmIMgdTramiteHttpsSoap11EndpointAddress()),
						iotramite);
//				System.out.println(iotramite.getIOTramitePortAddress());
		
//			iotramitePortType = new IOTramiteServiceSoapBindingStub(new URL(iotramite.getIOTramitePortAddress()),
//					iotramite);
//			System.out.println("consultra tramite:");

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
	
	public pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite recepcionarTramite(pe.gob.segdi.wsiopidetramite.ws.RecepcionTramite request) {

		System.out.println("Recepcionar Tramite");
		
		System.out.println("cuo -> " + request.getVcuo());
		System.out.println("rentrec -> " + request.getVrucentrec());
		System.out.println("centrem -> " + request.getVrucentrem());
		
		PcmIMgdTramite iotramite = new PcmIMgdTramiteLocator();

		System.out.println("obtener");


		PcmIMgdTramitePortType iotramitePortType;
		pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite respuestaTramite = new pe.gob.segdi.wsiopidetramite.ws.RespuestaTramite();
		try {
		
				iotramitePortType = new PcmIMgdTramiteSoap11BindingStub(new URL(iotramite.getPcmIMgdTramiteHttpsSoap11EndpointAddress()),
						iotramite);
				System.out.println(iotramite.getPcmIMgdTramiteHttpsSoap11EndpointAddress());
			
			


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
	
	public pe.gob.segdi.wsiopidetramiteprod.ws.RespuestaCargoTramite cargoTramite(pe.gob.segdi.wsiopidetramiteprod.ws.CargoTramite request) {

		System.out.println("Cargo Tramite");
		
		System.out.println("cuo -> " + request.getVcuo());
		System.out.println("rentrec -> " + request.getVrucentrec());
		System.out.println("centrem -> " + request.getVrucentrem());
		
		PcmIMgdTramite iotramite = new PcmIMgdTramiteLocator();

		System.out.println("obtener");

		System.out.println(iotramite.getPcmIMgdTramiteHttpsSoap11EndpointAddress());

		PcmIMgdTramitePortType iotramitePortType = null;
		pe.gob.segdi.wsiopidetramiteprod.ws.RespuestaCargoTramite respuestaTramite = new pe.gob.segdi.wsiopidetramiteprod.ws.RespuestaCargoTramite();
		try {
		
				iotramitePortType = new PcmIMgdTramiteSoap11BindingStub(new URL(iotramite.getPcmIMgdTramiteHttpsSoap11EndpointAddress()),
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