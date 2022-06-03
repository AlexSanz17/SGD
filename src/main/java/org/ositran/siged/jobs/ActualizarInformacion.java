package org.ositran.siged.jobs;

import java.util.List;

import org.ositran.services.DespachoVirtualService;
import org.ositran.services.DocAnexoVirtualService;
import org.ositran.services.DocExternoVirtualService;
import org.ositran.services.DocPrincipalVirtualService;
import org.ositran.services.DocumentoPIDEService;
import org.ositran.services.RecepcionVirtualService;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

public class ActualizarInformacion {
	private RecepcionVirtualService recepcionVirtualService;
	private DespachoVirtualService despachoVirtualService;
	private DocExternoVirtualService docExternoVirtualService;
	private DocPrincipalVirtualService docPrincipalVirtualService;
	private DocAnexoVirtualService docAnexoVirtualService;	
	private DocumentoPIDEService documentoPIDEService;
	public void jobActualizar() {
		System.out.println("================Job actualización================");

		try {
			//	================		RECEPCION    ================
			
			List<IotdtcRecepcionPIDE> listIotdtcRecepcionPIDE = documentoPIDEService.getAllRecepcion();
			List<IotdtcRecepcion> listIotdtcRecepcion = recepcionVirtualService.getAll();
	
			System.out.println("listIotdtcRecepcion.size()............" + listIotdtcRecepcion.size());
			String cflgest = "R";
			for (int i = 0; i < listIotdtcRecepcion.size(); i++) {
				IotdtcRecepcion iotdtcRecepcion = listIotdtcRecepcion.get(i);
				IotdtcRecepcionPIDE iotdtcRecepcionPIDE = listIotdtcRecepcionPIDE.get(i);
//				System.out.println("=====iotdtcRecepcionPIDE===" + listIotdtcRecepcionPIDE.get(i).getCflgest());
				
				if(iotdtcRecepcion.getCflgest().toString().equals("R")) {
					
					if (iotdtcRecepcion.getVcuo() ==  iotdtcRecepcionPIDE.getVcuo()){
						
						iotdtcRecepcionPIDE = new IotdtcRecepcionPIDE();
						iotdtcRecepcionPIDE.setSidrecext(iotdtcRecepcion.getSidrecext());
						iotdtcRecepcionPIDE.setCflgenvcar(iotdtcRecepcion.getCflgenvcar());
						iotdtcRecepcionPIDE.setCflgest(iotdtcRecepcion.getCflgest());
						iotdtcRecepcionPIDE.setCflgestobs(iotdtcRecepcion.getCflgestobs());
						iotdtcRecepcionPIDE.setCtipdociderem(iotdtcRecepcion.getCtipdociderem());
						iotdtcRecepcionPIDE.setDfecmod(iotdtcRecepcion.getDfecmod());
						iotdtcRecepcionPIDE.setDfecreg(iotdtcRecepcion.getDfecreg());
						iotdtcRecepcionPIDE.setDfecregstd(iotdtcRecepcion.getDfecregstd());
						iotdtcRecepcionPIDE.setVanioregstd(iotdtcRecepcion.getVanioregstd());
						iotdtcRecepcionPIDE.setVcuo(iotdtcRecepcion.getVcuo());
						iotdtcRecepcionPIDE.setVcuoref(iotdtcRecepcion.getVcuoref());
						iotdtcRecepcionPIDE.setVdesanxstd(iotdtcRecepcion.getVdesanxstd());
						iotdtcRecepcionPIDE.setVnumdociderem(iotdtcRecepcion.getVnumdociderem());
						iotdtcRecepcionPIDE.setVnumregstd(iotdtcRecepcion.getVnumregstd());
						iotdtcRecepcionPIDE.setVobs(iotdtcRecepcion.getVobs());
						iotdtcRecepcionPIDE.setVrucentrem(iotdtcRecepcion.getVrucentrem());
						iotdtcRecepcionPIDE.setVuniorgrem(iotdtcRecepcion.getVuniorgrem());
						iotdtcRecepcionPIDE.setVuniorgstd(iotdtcRecepcion.getVuniorgstd());
						iotdtcRecepcionPIDE.setVusumod(iotdtcRecepcion.getVusumod());
						iotdtcRecepcionPIDE.setVusuregstd(iotdtcRecepcion.getVusuregstd());
						
						documentoPIDEService.updateIotdtcRecepcionPIDE(iotdtcRecepcionPIDE);
					}
				}
				
			}
			//			================		DESPACHO    ================
			List<IotdtcDespacho> listIotdtcDespacho = despachoVirtualService.getAll();
	
			System.out.println("listIotdtcDespacho.size()................" + listIotdtcDespacho.size());
			
			for (int i = 0; i < listIotdtcDespacho.size(); i++) {			
				IotdtcDespacho iotdtcDespacho = listIotdtcDespacho.get(i);
				
				if(iotdtcDespacho.getCflgest().toString().equals("E") && iotdtcDespacho.getCflmigrado().toString() == null) {
					IotdtcDespachoPIDE iotdtcDespachoPIDE =  new IotdtcDespachoPIDE();
		              iotdtcDespachoPIDE.setBcarstdrec(iotdtcDespacho.getBcarstdrec());
		              iotdtcDespachoPIDE.setCflgest(iotdtcDespacho.getCflgest());
		              iotdtcDespachoPIDE.setCtipdociderem(iotdtcDespacho.getCtipdociderem());
		              iotdtcDespachoPIDE.setDfecenv(iotdtcDespacho.getDfecenv());
		              iotdtcDespachoPIDE.setDfecmod(iotdtcDespacho.getDfecmod());
		              iotdtcDespachoPIDE.setDfecreg(iotdtcDespacho.getDfecreg());
		              iotdtcDespachoPIDE.setDfecregstdrec(iotdtcDespacho.getDfecregstdrec());
		              iotdtcDespachoPIDE.setSidemiext(iotdtcDespacho.getSidemiext());
		              iotdtcDespachoPIDE.setVanioregstd(iotdtcDespacho.getVanioregstd());
		              iotdtcDespachoPIDE.setVanioregstdrec(iotdtcDespacho.getVanioregstdrec());
		              iotdtcDespachoPIDE.setVcoduniorgrem(iotdtcDespacho.getVcoduniorgrem());
		              iotdtcDespachoPIDE.setVcuo(iotdtcDespacho.getVcuo());
		              iotdtcDespachoPIDE.setVcuoref(iotdtcDespacho.getVcuoref());
		              iotdtcDespachoPIDE.setVdesanxstdrec(iotdtcDespacho.getVdesanxstdrec());
		              iotdtcDespachoPIDE.setVnomentrec(iotdtcDespacho.getVnomentrec());
		              iotdtcDespachoPIDE.setVnumdociderem(iotdtcDespacho.getVnumdociderem());
		              iotdtcDespachoPIDE.setVnumregstd(iotdtcDespacho.getVnumregstd());
		              iotdtcDespachoPIDE.setVnumregstdrec(iotdtcDespacho.getVnumregstdrec());
		              iotdtcDespachoPIDE.setVobs(iotdtcDespacho.getVobs());
		              iotdtcDespachoPIDE.setVrucentrec(iotdtcDespacho.getVrucentrec());
		              iotdtcDespachoPIDE.setVuniorgrem(iotdtcDespacho.getVuniorgrem());
		              iotdtcDespachoPIDE.setVuniorgstdrec(iotdtcDespacho.getVuniorgstdrec());
		              iotdtcDespachoPIDE.setVusumod(iotdtcDespacho.getVusumod());
		              iotdtcDespachoPIDE.setVusureg(iotdtcDespacho.getVusureg());
		              iotdtcDespachoPIDE.setVusuregstdrec(iotdtcDespacho.getVusuregstdrec());
		             
		              System.out.println("Actulizar iotdtcDespachoPIDE");           
		              documentoPIDEService.updateIotdtcDespachoPIDE(iotdtcDespachoPIDE);
		              
		              
		              //Actualizar Despacho
		              String cflmigrado = "S";
		              iotdtcDespacho.setCflmigrado(cflmigrado.charAt(0));
		              despachoVirtualService.registrarDocumento(iotdtcDespacho);
				}
				
						
			}
			//		................	DOCEXTERNO.  ...............
			List<IotdtmDocExterno> listIotdtcDocExterno = docExternoVirtualService.getAll();
			
			System.out.println("listIotdtcDocExterno.size()................" + listIotdtcDocExterno.size());
	
			for (int i = 0; i < listIotdtcDocExterno.size(); i++) {			
				IotdtmDocExterno iotdtcDocExterno = listIotdtcDocExterno.get(i);
				
				if(listIotdtcDespacho.get(i).getCflgest().toString().equals("E")) {
					
					if(iotdtcDocExterno.getSidemiext().getSidemiext() == listIotdtcDespacho.get(i).getSidemiext() ) {
						
						IotdtmDocExternoPIDE iotdtcDocExternoPIDE = new IotdtmDocExternoPIDE();
						iotdtcDocExternoPIDE.setSiddocext(iotdtcDocExterno.getSiddocext());
						iotdtcDocExternoPIDE.setCcodtipdoc(iotdtcDocExterno.getCcodtipdoc());
						iotdtcDocExternoPIDE.setCindtup(iotdtcDocExterno.getCindtup());
						iotdtcDocExternoPIDE.setDfecdoc(iotdtcDocExterno.getDfecdoc());
						iotdtcDocExternoPIDE.setSnumanx(iotdtcDocExterno.getSnumanx());
						iotdtcDocExternoPIDE.setSnumfol(iotdtcDocExterno.getSnumfol());
						iotdtcDocExternoPIDE.setVasu(iotdtcDocExterno.getVasu());
						iotdtcDocExternoPIDE.setVnomcardst(iotdtcDocExterno.getVnomcardst());
						iotdtcDocExternoPIDE.setVnomdst(iotdtcDocExterno.getVnomdst());
						iotdtcDocExternoPIDE.setVnomentemi(iotdtcDocExterno.getVnomentemi());
						iotdtcDocExternoPIDE.setVnumdoc(iotdtcDocExterno.getVnumdoc());
						
						iotdtcDocExternoPIDE.setVuniorgdst(iotdtcDocExterno.getVuniorgdst());
						iotdtcDocExternoPIDE.setVurldocanx(iotdtcDocExterno.getVurldocanx());
						
						IotdtcDespachoPIDE iotdtcDespachoPIDE = new IotdtcDespachoPIDE();
						
						if (iotdtcDocExterno.getSidemiext() != null) {
							iotdtcDespachoPIDE.setSidemiext(iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
							iotdtcDocExternoPIDE.setSidemiext(iotdtcDespachoPIDE); 
						}
						
						IotdtcRecepcionPIDE iotdtcRecepcionPIDE = new IotdtcRecepcionPIDE();
//						System.out.println("===iotdtcDocExternoPIDE.getSidrecext().getSidrecext()== "+iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
						
						if(iotdtcDocExternoPIDE.getSidrecext() != null) {
							iotdtcRecepcionPIDE.setSidrecext(iotdtcDocExterno.getSidrecext().getSidrecext());
							
							iotdtcDocExternoPIDE.setSidrecext(iotdtcRecepcionPIDE); 
						}
						
						documentoPIDEService.updateIotdtmDocExternoPIDE(iotdtcDocExternoPIDE);
					}
					
				}
			}
			//.............DOC PRINCIPAL.............
			
			List<IotdtdDocPrincipal> listIotdtcDocPrincipal = docPrincipalVirtualService.getAll();
	
			System.out.println("listIotdtcDocPrincipal.size()................" + listIotdtcDocPrincipal.size());
	
			for (int i = 0; i < listIotdtcDocPrincipal.size(); i++) {			
				IotdtdDocPrincipal iotdtcDocPrincipal = listIotdtcDocPrincipal.get(i);
				if(listIotdtcDespacho.get(i).getCflgest().toString().equals("E")) {
					
					if(listIotdtcDocExterno.get(i).getSidemiext().getSidemiext() == listIotdtcDespacho.get(i).getSidemiext() ) {
						if(iotdtcDocPrincipal.getSiddocext().getSiddocext() == listIotdtcDocExterno.get(i).getSiddocext()) {
							IotdtdDocPrincipalPIDE iotdtcDocPrincipalPIDE = new IotdtdDocPrincipalPIDE();
							iotdtcDocPrincipalPIDE.setSiddocpri(iotdtcDocPrincipal.getSiddocpri());
							iotdtcDocPrincipalPIDE.setBpdfdoc(iotdtcDocPrincipal.getBpdfdoc());
							iotdtcDocPrincipalPIDE.setCcodest(iotdtcDocPrincipal.getCcodest());
							iotdtcDocPrincipalPIDE.setDfecreg(iotdtcDocPrincipal.getDfecreg());
							iotdtcDocPrincipalPIDE.setVnomdoc(iotdtcDocPrincipal.getVnomdoc());
							
							IotdtmDocExternoPIDE iotdtmDocExternoPIDE = new IotdtmDocExternoPIDE();
							
							if(iotdtcDocPrincipal.getSiddocext() != null) {
								iotdtmDocExternoPIDE.setSiddocext(iotdtcDocPrincipal.getSiddocext().getSiddocext()); 
								iotdtcDocPrincipalPIDE.setSiddocext(iotdtmDocExternoPIDE); 
							}
							
							documentoPIDEService.updateIotdtdDocPrincipalPIDE(iotdtcDocPrincipalPIDE);
						}
					}
					
					
				}
			}
			//.............ANEXO.............
			List<IotdtdAnexo> listIotdtcDocAnexo = docAnexoVirtualService.getAll();
	
			System.out.println("listIotdtcDocAnexo.size()..........." + listIotdtcDocAnexo.size());
			
	
			for (int i = 0; i < listIotdtcDocAnexo.size(); i++) {			
				IotdtdAnexo iotdtcDocAnexo = listIotdtcDocAnexo.get(i);
				
				if(listIotdtcDespacho.get(i).getCflgest().toString().equals("E")) {
					if(listIotdtcDocExterno.get(i).getSidemiext().getSidemiext() == listIotdtcDespacho.get(i).getSidemiext() ) {
						if(iotdtcDocAnexo.getSiddocext().getSiddocext() == listIotdtcDocExterno.get(i).getSiddocext()) {
							
							IotdtdAnexoPIDE iotdtcDocAnexoPIDE = new IotdtdAnexoPIDE();
							iotdtcDocAnexoPIDE.setSiddocanx(iotdtcDocAnexo.getSiddocanx());	
							iotdtcDocAnexoPIDE.setDfecreg(iotdtcDocAnexo.getDfecreg());
							iotdtcDocAnexoPIDE.setVnomdoc(iotdtcDocAnexo.getVnomdoc());
							
							IotdtmDocExternoPIDE iotdtmDocExternoPIDE = new IotdtmDocExternoPIDE();
							
							if(iotdtcDocAnexo.getSiddocext() != null) {
								iotdtmDocExternoPIDE.setSiddocext(iotdtcDocAnexo.getSiddocext().getSiddocext()); 
								iotdtcDocAnexoPIDE.setSiddocext(iotdtmDocExternoPIDE); 
							}
							
							documentoPIDEService.updateIotdtdAnexoPIDE(iotdtcDocAnexoPIDE);
						}
					}
					
				}
			}
		
		} catch (Exception e) {
			System.out.println("ERROR EN LOS INSERT");
			System.out.println(e.getMessage()); 
		}
	}
}
