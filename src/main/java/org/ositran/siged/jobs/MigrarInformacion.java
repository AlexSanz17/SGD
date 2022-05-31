package org.ositran.siged.jobs;

import java.util.List;

import org.jfree.util.Log;
import org.ositran.services.DespachoVirtualService;
import org.ositran.services.DocAnexoVirtualService;
import org.ositran.services.DocExternoVirtualService;
import org.ositran.services.DocPrincipalVirtualService;
import org.ositran.services.DocumentoPIDEService;
import org.ositran.services.RecepcionVirtualService;
import org.springframework.transaction.annotation.Transactional;

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

public class MigrarInformacion {
	private RecepcionVirtualService recepcionVirtualService;
	private DespachoVirtualService despachoVirtualService;
	private DocExternoVirtualService docExternoVirtualService;
	private DocPrincipalVirtualService docPrincipalVirtualService;
	private DocAnexoVirtualService docAnexoVirtualService;	
	private DocumentoPIDEService documentoPIDEService;

	public RecepcionVirtualService getRecepcionVirtualService() {
		return recepcionVirtualService;
	}

	public void setRecepcionVirtualService(RecepcionVirtualService recepcionVirtualService) {
		this.recepcionVirtualService = recepcionVirtualService;
	}

	public DocExternoVirtualService getDocExternoVirtualService() {
		return docExternoVirtualService;
	}

	public void setDocExternoVirtualService(DocExternoVirtualService docExternoVirtualService) {
		this.docExternoVirtualService = docExternoVirtualService;
	}

	public DocPrincipalVirtualService getDocPrincipalVirtualService() {
		return docPrincipalVirtualService;
	}

	public void setDocPrincipalVirtualService(DocPrincipalVirtualService docPrincipalVirtualService) {
		this.docPrincipalVirtualService = docPrincipalVirtualService;
	}

	public DocAnexoVirtualService getDocAnexoVirtualService() {
		return docAnexoVirtualService;
	}

	public void setDocAnexoVirtualService(DocAnexoVirtualService docAnexoVirtualService) {
		this.docAnexoVirtualService = docAnexoVirtualService;
	}

	public DocumentoPIDEService getDocumentoPIDEService() {
		return documentoPIDEService;
	}

	public void setDocumentoPIDEService(DocumentoPIDEService documentoPIDEService) {
		this.documentoPIDEService = documentoPIDEService;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Transactional
	public void migrar() { 
		System.out.println("================Job migracion================");

		try {
			List<IotdtcRecepcionPIDE> listIotdtcRecepcionPIDE = documentoPIDEService.getAllRecepcion();
	
			String cflgest = "P";
			for (int i = 0; i < listIotdtcRecepcionPIDE.size(); i++) {
				IotdtcRecepcionPIDE iotdtcRecepcionPIDE = listIotdtcRecepcionPIDE.get(i);
				
				if (iotdtcRecepcionPIDE.getCflgest().toString().equals("P")) {
					System.out.println("listIotdtcRecepcionPIDE.size()............" + listIotdtcRecepcionPIDE.size());
			
							
					IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
					iotdtcRecepcion.setSidrecext(iotdtcRecepcionPIDE.getSidrecext());
					iotdtcRecepcion.setCflgenvcar(iotdtcRecepcionPIDE.getCflgenvcar());
					iotdtcRecepcion.setCflgest(iotdtcRecepcionPIDE.getCflgest());
					iotdtcRecepcion.setCflgestobs(iotdtcRecepcionPIDE.getCflgestobs());
					iotdtcRecepcion.setCtipdociderem(iotdtcRecepcionPIDE.getCtipdociderem());
					iotdtcRecepcion.setDfecmod(iotdtcRecepcionPIDE.getDfecmod());
					iotdtcRecepcion.setDfecreg(iotdtcRecepcionPIDE.getDfecreg());
					iotdtcRecepcion.setDfecregstd(iotdtcRecepcionPIDE.getDfecregstd());
					iotdtcRecepcion.setVanioregstd(iotdtcRecepcionPIDE.getVanioregstd());
					iotdtcRecepcion.setVcuo(iotdtcRecepcionPIDE.getVcuo());
					iotdtcRecepcion.setVcuoref(iotdtcRecepcionPIDE.getVcuoref());
					iotdtcRecepcion.setVdesanxstd(iotdtcRecepcionPIDE.getVdesanxstd());
					iotdtcRecepcion.setVnumdociderem(iotdtcRecepcionPIDE.getVnumdociderem());
					iotdtcRecepcion.setVnumregstd(iotdtcRecepcionPIDE.getVnumregstd());
					iotdtcRecepcion.setVobs(iotdtcRecepcionPIDE.getVobs());
					iotdtcRecepcion.setVrucentrem(iotdtcRecepcionPIDE.getVrucentrem());
					iotdtcRecepcion.setVuniorgrem(iotdtcRecepcionPIDE.getVuniorgrem());
					iotdtcRecepcion.setVuniorgstd(iotdtcRecepcionPIDE.getVuniorgstd());
					iotdtcRecepcion.setVusumod(iotdtcRecepcionPIDE.getVusumod());
					iotdtcRecepcion.setVusuregstd(iotdtcRecepcionPIDE.getVusuregstd());
					
					IotdtcRecepcion iotdtcRecepcionInserted = recepcionVirtualService.registrarDocumento(iotdtcRecepcion);
				}
			}
	
			List<IotdtmDocExternoPIDE> listIotdtcDocExternoPIDE = documentoPIDEService.getAllDocExterno();
	
			System.out.println("listIotdtcDocExternoPIDE.size()................" + listIotdtcDocExternoPIDE.size());
	
			for (int i = 0; i < listIotdtcDocExternoPIDE.size(); i++) {			
				IotdtmDocExternoPIDE iotdtcDocExternoPIDE = listIotdtcDocExternoPIDE.get(i);
				
				if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P")) {
					
					if(iotdtcDocExternoPIDE.getSidrecext().getSidrecext() == listIotdtcRecepcionPIDE.get(i).getSidrecext() ) {
						
						IotdtmDocExterno iotdtcDocExterno = new IotdtmDocExterno();
						iotdtcDocExterno.setSiddocext(iotdtcDocExternoPIDE.getSiddocext());
						iotdtcDocExterno.setCcodtipdoc(iotdtcDocExternoPIDE.getCcodtipdoc());
						iotdtcDocExterno.setCindtup(iotdtcDocExternoPIDE.getCindtup());
						iotdtcDocExterno.setDfecdoc(iotdtcDocExternoPIDE.getDfecdoc());
						iotdtcDocExterno.setSnumanx(iotdtcDocExternoPIDE.getSnumanx());
						iotdtcDocExterno.setSnumfol(iotdtcDocExternoPIDE.getSnumfol());
						iotdtcDocExterno.setVasu(iotdtcDocExternoPIDE.getVasu());
						iotdtcDocExterno.setVnomcardst(iotdtcDocExternoPIDE.getVnomcardst());
						iotdtcDocExterno.setVnomdst(iotdtcDocExternoPIDE.getVnomdst());
						iotdtcDocExterno.setVnomentemi(iotdtcDocExternoPIDE.getVnomentemi());
						iotdtcDocExterno.setVnumdoc(iotdtcDocExternoPIDE.getVnumdoc());
						
						iotdtcDocExterno.setVuniorgdst(iotdtcDocExternoPIDE.getVuniorgdst());
						iotdtcDocExterno.setVurldocanx(iotdtcDocExternoPIDE.getVurldocanx());
						
						IotdtcDespacho iotdtcDespacho = new IotdtcDespacho();
						
						if (iotdtcDocExternoPIDE.getSidemiext() != null) {
							iotdtcDespacho.setSidemiext(iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
							iotdtcDocExterno.setSidemiext(iotdtcDespacho); 
						}
						
						IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
						System.out.println("===iotdtcDocExternoPIDE.getSidrecext().getSidrecext()== "+iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
						
						if(iotdtcDocExternoPIDE.getSidrecext() != null) {
							iotdtcRecepcion.setSidrecext(iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
							
							iotdtcDocExterno.setSidrecext(iotdtcRecepcion); 
						}
						
						IotdtmDocExterno iotdtcDocExternoInserted = docExternoVirtualService.registrarDocumento(iotdtcDocExterno);
					}
					
				}
			}
			
			List<IotdtdDocPrincipalPIDE> listIotdtcDocPrincipalPIDE = documentoPIDEService.getAllDocPrincipal();
	
			System.out.println("listIotdtcDocPrincipalPIDE.size()................" + listIotdtcDocPrincipalPIDE.size());
	
			for (int i = 0; i < listIotdtcDocPrincipalPIDE.size(); i++) {			
				IotdtdDocPrincipalPIDE iotdtcDocPrincipalPIDE = listIotdtcDocPrincipalPIDE.get(i);
				if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P")) {
					
					if(listIotdtcDocExternoPIDE.get(i).getSidrecext().getSidrecext() == listIotdtcRecepcionPIDE.get(i).getSidrecext() ) {
						if(iotdtcDocPrincipalPIDE.getSiddocext().getSiddocext() == listIotdtcDocExternoPIDE.get(i).getSiddocext()) {
							IotdtdDocPrincipal iotdtcDocPrincipal = new IotdtdDocPrincipal();
							iotdtcDocPrincipal.setSiddocpri(iotdtcDocPrincipalPIDE.getSiddocpri());
							iotdtcDocPrincipal.setBpdfdoc(iotdtcDocPrincipalPIDE.getBpdfdoc());
							iotdtcDocPrincipal.setCcodest(iotdtcDocPrincipalPIDE.getCcodest());
							iotdtcDocPrincipal.setDfecreg(iotdtcDocPrincipalPIDE.getDfecreg());
							iotdtcDocPrincipal.setVnomdoc(iotdtcDocPrincipalPIDE.getVnomdoc());
							
							IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
							
							if(iotdtcDocPrincipalPIDE.getSiddocext() != null) {
								iotdtmDocExterno.setSiddocext(iotdtcDocPrincipalPIDE.getSiddocext().getSiddocext()); 
								iotdtcDocPrincipal.setSiddocext(iotdtmDocExterno); 
							}
							
							IotdtdDocPrincipal iotdtcDocPrincipalInserted = docPrincipalVirtualService.registrarPrincipal(iotdtcDocPrincipal);
						}
					}
					
					
				}
			}
			
			List<IotdtdAnexoPIDE> listIotdtcDocAnexoPIDE = documentoPIDEService.getAllAnexo();
	
			System.out.println("listIotdtcDocAnexoPIDE.size()..........." + listIotdtcDocAnexoPIDE.size());
			
	
			for (int i = 0; i < listIotdtcDocAnexoPIDE.size(); i++) {			
				IotdtdAnexoPIDE iotdtcDocAnexoPIDE = listIotdtcDocAnexoPIDE.get(i);
				
				if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P")) {
					if(listIotdtcDocExternoPIDE.get(i).getSidrecext().getSidrecext() == listIotdtcRecepcionPIDE.get(i).getSidrecext() ) {
						if(iotdtcDocAnexoPIDE.getSiddocext().getSiddocext() == listIotdtcDocExternoPIDE.get(i).getSiddocext()) {
							
							IotdtdAnexo iotdtcDocAnexo = new IotdtdAnexo();
							iotdtcDocAnexo.setSiddocanx(iotdtcDocAnexoPIDE.getSiddocanx());	
							iotdtcDocAnexo.setDfecreg(iotdtcDocAnexoPIDE.getDfecreg());
							iotdtcDocAnexo.setVnomdoc(iotdtcDocAnexoPIDE.getVnomdoc());
							
							IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
							
							if(iotdtcDocAnexoPIDE.getSiddocext() != null) {
								iotdtmDocExterno.setSiddocext(iotdtcDocAnexoPIDE.getSiddocext().getSiddocext()); 
								iotdtcDocAnexo.setSiddocext(iotdtmDocExterno); 
							}
							
							IotdtdAnexo iotdtcDocPrincipalInserted = docAnexoVirtualService.registrarAnexo(iotdtcDocAnexo);
						}
					}
					
				}
			}
		
		} catch (Exception e) {
			System.out.println("ERROR EN LOS INSERT");
			System.out.println(e.getMessage()); 
		}
	}
	
	
//	@SuppressWarnings("unlikely-arg-type")
//	@Transactional
//	public void actualizarInformacion() { 
//		System.out.println("================Job actualizar migracion================");
//
//		try {
//			List<IotdtcRecepcion> listIotdtcRecepcion = recepcionVirtualService.getAll();
//			String cflgest = "R";
//			for (int i = 0; i < listIotdtcRecepcion.size(); i++) {
//				IotdtcRecepcion iotdtcRecepcion = listIotdtcRecepcion.get(i);
//				
//				if (iotdtcRecepcion.getCflgest().toString().equals("S")) {
//					System.out.println("listIotdtcRecepcion.size()............" + listIotdtcRecepcion.size());
//			
//							
//					IotdtcRecepcionPIDE iotdtcRecepcionPIDE = new IotdtcRecepcionPIDE();
//					iotdtcRecepcionPIDE.setSidrecext(iotdtcRecepcion.getSidrecext());
//					iotdtcRecepcionPIDE.setCflgenvcar(iotdtcRecepcion.getCflgenvcar());
//					iotdtcRecepcionPIDE.setCflgest(cflgest.charAt(0));
//					iotdtcRecepcionPIDE.setCflgestobs(iotdtcRecepcion.getCflgestobs());
//					iotdtcRecepcionPIDE.setCtipdociderem(iotdtcRecepcion.getCtipdociderem());
//					iotdtcRecepcionPIDE.setDfecmod(iotdtcRecepcion.getDfecmod());
//					iotdtcRecepcionPIDE.setDfecreg(iotdtcRecepcion.getDfecreg());
//					iotdtcRecepcionPIDE.setDfecregstd(iotdtcRecepcion.getDfecregstd());
//					iotdtcRecepcionPIDE.setVanioregstd(iotdtcRecepcion.getVanioregstd());
//					iotdtcRecepcionPIDE.setVcuo(iotdtcRecepcion.getVcuo());
//					iotdtcRecepcionPIDE.setVcuoref(iotdtcRecepcion.getVcuoref());
//					iotdtcRecepcionPIDE.setVdesanxstd(iotdtcRecepcion.getVdesanxstd());
//					iotdtcRecepcionPIDE.setVnumdociderem(iotdtcRecepcion.getVnumdociderem());
//					iotdtcRecepcionPIDE.setVnumregstd(iotdtcRecepcion.getVnumregstd());
//					iotdtcRecepcionPIDE.setVobs(iotdtcRecepcion.getVobs());
//					iotdtcRecepcionPIDE.setVrucentrem(iotdtcRecepcion.getVrucentrem());
//					iotdtcRecepcionPIDE.setVuniorgrem(iotdtcRecepcion.getVuniorgrem());
//					iotdtcRecepcionPIDE.setVuniorgstd(iotdtcRecepcion.getVuniorgstd());
//					iotdtcRecepcionPIDE.setVusumod(iotdtcRecepcion.getVusumod());
//					iotdtcRecepcionPIDE.setVusuregstd(iotdtcRecepcion.getVusuregstd());
//					
//					documentoPIDEService.updateIotdtcRecepcionPIDE(iotdtcRecepcionPIDE);
//				}
//			}
//				//Desapacho
//			List<IotdtcDespacho> listIotdtcDespacho = despachoVirtualService.getAll();
//			
//			System.out.println("IotdtcDespacho.size()................" + listIotdtcDespacho.size());
//	
//			for (int i = 0; i < listIotdtcDespacho.size(); i++) {			
//				IotdtcDespacho iotdtcDespacho = listIotdtcDespacho.get(i);
//				
//				if(listIotdtcDespacho.get(i).getCflgest().toString().equals("E")) {
//					
//						IotdtcDespachoPIDE iotdtcDespachoPIDE =  new IotdtcDespachoPIDE();
//                      iotdtcDespachoPIDE.setBcarstdrec(iotdtcDespacho.getBcarstdrec());
//                      iotdtcDespachoPIDE.setCflgest(iotdtcDespacho.getCflgest());
//                      iotdtcDespachoPIDE.setCtipdociderem(iotdtcDespacho.getCtipdociderem());
//                      iotdtcDespachoPIDE.setDfecenv(iotdtcDespacho.getDfecenv());
//                      iotdtcDespachoPIDE.setDfecmod(iotdtcDespacho.getDfecmod());
//                      iotdtcDespachoPIDE.setDfecreg(iotdtcDespacho.getDfecreg());
//                      iotdtcDespachoPIDE.setDfecregstdrec(iotdtcDespacho.getDfecregstdrec());
//                      iotdtcDespachoPIDE.setSidemiext(iotdtcDespacho.getSidemiext());
//                      iotdtcDespachoPIDE.setVanioregstd(iotdtcDespacho.getVanioregstd());
//                      iotdtcDespachoPIDE.setVanioregstdrec(iotdtcDespacho.getVanioregstdrec());
//                      iotdtcDespachoPIDE.setVcoduniorgrem(iotdtcDespacho.getVcoduniorgrem());
//                      iotdtcDespachoPIDE.setVcuo(iotdtcDespacho.getVcuo());
//                      iotdtcDespachoPIDE.setVcuoref(iotdtcDespacho.getVcuoref());
//                      iotdtcDespachoPIDE.setVdesanxstdrec(iotdtcDespacho.getVdesanxstdrec());
//                      iotdtcDespachoPIDE.setVnomentrec(iotdtcDespacho.getVnomentrec());
//                      iotdtcDespachoPIDE.setVnumdociderem(iotdtcDespacho.getVnumdociderem());
//                      iotdtcDespachoPIDE.setVnumregstd(iotdtcDespacho.getVnumregstd());
//                      iotdtcDespachoPIDE.setVnumregstdrec(iotdtcDespacho.getVnumregstdrec());
//                      iotdtcDespachoPIDE.setVobs(iotdtcDespacho.getVobs());
//                      iotdtcDespachoPIDE.setVrucentrec(iotdtcDespacho.getVrucentrec());
//                      iotdtcDespachoPIDE.setVuniorgrem(iotdtcDespacho.getVuniorgrem());
//                      iotdtcDespachoPIDE.setVuniorgstdrec(iotdtcDespacho.getVuniorgstdrec());
//                      iotdtcDespachoPIDE.setVusumod(iotdtcDespacho.getVusumod());
//                      iotdtcDespachoPIDE.setVusureg(iotdtcDespacho.getVusureg());
//                      iotdtcDespachoPIDE.setVusuregstdrec(iotdtcDespacho.getVusuregstdrec());
//                     
//                      System.out.println("Actulizar iotdtcDespachoPIDE");
////                    System.out.println(iotdtcDespachoPIDE);
////                    //                    
//                      documentoPIDEService.updateIotdtcDespachoPIDE(iotdtcDespachoPIDE);
//						
//					
//					
//					
//				}
			
			
//			List<IotdtcDespacho> listIotdtmDocExterno = despachoVirtualService();
//	
//			System.out.println("listIotdtcDocExternoPIDE.size()................" + listIotdtcDocExternoPIDE.size());
//	
//			for (int i = 0; i < listIotdtcDocExternoPIDE.size(); i++) {			
//				IotdtmDocExternoPIDE iotdtcDocExternoPIDE = listIotdtcDocExternoPIDE.get(i);
//				
//				if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P")) {
//					
//					if(iotdtcDocExternoPIDE.getSidrecext().getSidrecext() == listIotdtcRecepcionPIDE.get(i).getSidrecext() ) {
//						
//						IotdtmDocExterno iotdtcDocExterno = new IotdtmDocExterno();
//						iotdtcDocExterno.setSiddocext(iotdtcDocExternoPIDE.getSiddocext());
//						iotdtcDocExterno.setCcodtipdoc(iotdtcDocExternoPIDE.getCcodtipdoc());
//						iotdtcDocExterno.setCindtup(iotdtcDocExternoPIDE.getCindtup());
//						iotdtcDocExterno.setDfecdoc(iotdtcDocExternoPIDE.getDfecdoc());
//						iotdtcDocExterno.setSnumanx(iotdtcDocExternoPIDE.getSnumanx());
//						iotdtcDocExterno.setSnumfol(iotdtcDocExternoPIDE.getSnumfol());
//						iotdtcDocExterno.setVasu(iotdtcDocExternoPIDE.getVasu());
//						iotdtcDocExterno.setVnomcardst(iotdtcDocExternoPIDE.getVnomcardst());
//						iotdtcDocExterno.setVnomdst(iotdtcDocExternoPIDE.getVnomdst());
//						iotdtcDocExterno.setVnomentemi(iotdtcDocExternoPIDE.getVnomentemi());
//						iotdtcDocExterno.setVnumdoc(iotdtcDocExternoPIDE.getVnumdoc());
//						
//						iotdtcDocExterno.setVuniorgdst(iotdtcDocExternoPIDE.getVuniorgdst());
//						iotdtcDocExterno.setVurldocanx(iotdtcDocExternoPIDE.getVurldocanx());
//						
//						IotdtcDespacho iotdtcDespacho = new IotdtcDespacho();
//						
//						if (iotdtcDocExternoPIDE.getSidemiext() != null) {
//							iotdtcDespacho.setSidemiext(iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
//							iotdtcDocExterno.setSidemiext(iotdtcDespacho); 
//						}
//						
//						IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
//						System.out.println("===iotdtcDocExternoPIDE.getSidrecext().getSidrecext()== "+iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
//						
//						if(iotdtcDocExternoPIDE.getSidrecext() != null) {
//							iotdtcRecepcion.setSidrecext(iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
//							
//							iotdtcDocExterno.setSidrecext(iotdtcRecepcion); 
//						}
//						
//						IotdtmDocExterno iotdtcDocExternoInserted = docExternoVirtualService.registrarDocumento(iotdtcDocExterno);
//					}
//					
//				}
//			}
//			
//			List<IotdtdDocPrincipalPIDE> listIotdtcDocPrincipalPIDE = documentoPIDEService.getAllDocPrincipal();
//	
//			System.out.println("listIotdtcDocPrincipalPIDE.size()................" + listIotdtcDocPrincipalPIDE.size());
//	
//			for (int i = 0; i < listIotdtcDocPrincipalPIDE.size(); i++) {			
//				IotdtdDocPrincipalPIDE iotdtcDocPrincipalPIDE = listIotdtcDocPrincipalPIDE.get(i);
//				if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P")) {
//					
//					if(listIotdtcDocExternoPIDE.get(i).getSidrecext().getSidrecext() == listIotdtcRecepcionPIDE.get(i).getSidrecext() ) {
//						if(iotdtcDocPrincipalPIDE.getSiddocext().getSiddocext() == listIotdtcDocExternoPIDE.get(i).getSiddocext()) {
//							IotdtdDocPrincipal iotdtcDocPrincipal = new IotdtdDocPrincipal();
//							iotdtcDocPrincipal.setSiddocpri(iotdtcDocPrincipalPIDE.getSiddocpri());
//							iotdtcDocPrincipal.setBpdfdoc(iotdtcDocPrincipalPIDE.getBpdfdoc());
//							iotdtcDocPrincipal.setCcodest(iotdtcDocPrincipalPIDE.getCcodest());
//							iotdtcDocPrincipal.setDfecreg(iotdtcDocPrincipalPIDE.getDfecreg());
//							iotdtcDocPrincipal.setVnomdoc(iotdtcDocPrincipalPIDE.getVnomdoc());
//							
//							IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
//							
//							if(iotdtcDocPrincipalPIDE.getSiddocext() != null) {
//								iotdtmDocExterno.setSiddocext(iotdtcDocPrincipalPIDE.getSiddocext().getSiddocext()); 
//								iotdtcDocPrincipal.setSiddocext(iotdtmDocExterno); 
//							}
//							
//							IotdtdDocPrincipal iotdtcDocPrincipalInserted = docPrincipalVirtualService.registrarPrincipal(iotdtcDocPrincipal);
//						}
//					}
//					
//					
//				}
//			}
//			
//			List<IotdtdAnexoPIDE> listIotdtcDocAnexoPIDE = documentoPIDEService.getAllAnexo();
//	
//			System.out.println("listIotdtcDocAnexoPIDE.size()..........." + listIotdtcDocAnexoPIDE.size());
//			
//	
//			for (int i = 0; i < listIotdtcDocAnexoPIDE.size(); i++) {			
//				IotdtdAnexoPIDE iotdtcDocAnexoPIDE = listIotdtcDocAnexoPIDE.get(i);
//				
//				if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P")) {
//					if(listIotdtcDocExternoPIDE.get(i).getSidrecext().getSidrecext() == listIotdtcRecepcionPIDE.get(i).getSidrecext() ) {
//						if(iotdtcDocAnexoPIDE.getSiddocext().getSiddocext() == listIotdtcDocExternoPIDE.get(i).getSiddocext()) {
//							
//							IotdtdAnexo iotdtcDocAnexo = new IotdtdAnexo();
//							iotdtcDocAnexo.setSiddocanx(iotdtcDocAnexoPIDE.getSiddocanx());	
//							iotdtcDocAnexo.setDfecreg(iotdtcDocAnexoPIDE.getDfecreg());
//							iotdtcDocAnexo.setVnomdoc(iotdtcDocAnexoPIDE.getVnomdoc());
//							
//							IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
//							
//							if(iotdtcDocAnexoPIDE.getSiddocext() != null) {
//								iotdtmDocExterno.setSiddocext(iotdtcDocAnexoPIDE.getSiddocext().getSiddocext()); 
//								iotdtcDocAnexo.setSiddocext(iotdtmDocExterno); 
//							}
//							
//							IotdtdAnexo iotdtcDocPrincipalInserted = docAnexoVirtualService.registrarAnexo(iotdtcDocAnexo);
//						}
//					}
//					
//				}
//			}
//		
//		} catch (Exception e) {
//			System.out.println("ERROR EN LOS INSERT");
//			System.out.println(e.getMessage()); 
//		}
}
	
