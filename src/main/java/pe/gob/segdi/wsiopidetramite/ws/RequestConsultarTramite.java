package pe.gob.segdi.wsiopidetramite.ws;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.axis.AxisFault;

import pe.gob.segdi.wsiopidetramite.ws.ConsultaTramite;
import pe.gob.segdi.wsiopidetramite.ws.IOTramite;
import pe.gob.segdi.wsiopidetramite.ws.IOTramiteService;
import pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceLocator;
import pe.gob.segdi.wsiopidetramite.ws.IOTramiteServiceSoapBindingStub;
import pe.gob.segdi.wsiopidetramite.ws.RespuestaConsultaTramite;

public class RequestConsultarTramite {

	public static void main(String[] args) throws IOException {
		IOTramiteService iotramite = new IOTramiteServiceLocator();

		System.out.println("obtener");

		System.out.println(iotramite.getIOTramitePortAddress());
		//System.out.println(iotramite.get);

		
		IOTramite iotramitePortType;
		try {
			iotramitePortType = new IOTramiteServiceSoapBindingStub(new URL(iotramite.getIOTramitePortAddress()), iotramite);
			
		              
		    ConsultaTramite consultaTramite = new ConsultaTramite();
		    consultaTramite.setVcuo("0000002846");
		    consultaTramite.setVrucentrec("20503503639");
		    consultaTramite.setVrucentrem("20168999926");
			
			System.out.println("consultra tramite:"); 
			
			RespuestaConsultaTramite respuestaConsultaTramite= iotramitePortType.consultarTramiteResponse(consultaTramite);
			
			System.out.println("Resultado");
			System.out.println(respuestaConsultaTramite.getVcodres());
			System.out.println(respuestaConsultaTramite.getVdesres());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*BindingProvider  bindingProvider = (BindingProvider) pcmCuoPortType;
		
		bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address", "https://ws3.pide.gob.pe/services/PcmCuo?wsdl");*/
		

	}
	
}
