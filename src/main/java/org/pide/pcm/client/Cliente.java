package org.pide.pcm.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.pide.pcm.client.webservice.PcmCuo;
import org.pide.pcm.client.webservice.PcmCuoLocator;
import org.pide.pcm.client.webservice.PcmCuoPortType;
import org.pide.pcm.client.webservice.PcmCuoSoap11BindingStub;

public class Cliente {
	public static void main(String[] args) throws MalformedURLException, RemoteException {

		PcmCuo pcmCuo = (PcmCuo) new PcmCuoLocator();

		System.out.println("obtener");

		System.out.println(pcmCuo.getPcmCuoHttpsSoap11EndpointAddress());

		
		PcmCuoPortType pcmCuoPortType = new PcmCuoSoap11BindingStub(new URL(pcmCuo.getPcmCuoHttpsSoap11EndpointAddress()), pcmCuo);

		/*BindingProvider  bindingProvider = (BindingProvider) pcmCuoPortType;
		
		bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address", "https://ws3.pide.gob.pe/services/PcmCuo?wsdl");*/
		
		System.out.println(pcmCuoPortType.getCUO("172.27.0.113"));

	}
}
