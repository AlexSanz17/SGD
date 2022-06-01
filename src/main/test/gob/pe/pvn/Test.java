package gob.pe.pvn;

import org.apache.commons.codec.binary.Base64;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import org.pide.pcm.client.webservice.PcmCuo;
import org.pide.pcm.client.webservice.PcmCuoLocator;
import org.pide.pcm.client.webservice.PcmCuoPortType;
import org.pide.pcm.client.webservice.PcmCuoSoap11BindingStub;
import org.jfree.util.Log;

//import org.ositran.ajax.beans.CargoRecepcionPIDERequest;
//import org.ositran.ajax.beans.CargoRecepcionPIDEResponse;
public class Test {

	public static void main(String[] args) throws MalformedURLException, RemoteException {

		String titulo = "REPORTE DE ";
		String tipodocumento  = " ";
		String tipodoc = "OFICIO - N° 000008-2022-MTC/20.6";
		
		
		if(tipodocumento == null || tipodocumento.equals("")) {
			titulo += "DOCUMENTOS ";
		}else if(tipodocumento != null && !tipodocumento.equals("")) {
			String[] parte = tipodoc.split(" ");
			tipodocumento =  parte[0];
			titulo += tipodocumento +"S";
		}
		System.out.println(titulo);
		

	}
}

