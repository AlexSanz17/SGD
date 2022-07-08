package org.ositran.siged.jobs;

import java.util.List;

import org.jfree.util.Log;
import org.ositran.daos.DespachoVirtualDAO;
import org.ositran.daos.DocumentoPIDEDAOjdbc;
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
	private DespachoVirtualDAO despachoVirtualDAO;
	private DocumentoPIDEDAOjdbc documentoPIDEDAOjdbc;

	public DocumentoPIDEDAOjdbc getDocumentoPIDEDAOjdbc() {
		return documentoPIDEDAOjdbc;
	}

	public void setDocumentoPIDEDAOjdbc(DocumentoPIDEDAOjdbc documentoPIDEDAOjdbc) {
		this.documentoPIDEDAOjdbc = documentoPIDEDAOjdbc;
	}

	public DespachoVirtualDAO getDespachoVirtualDAO() {
		return despachoVirtualDAO;
	}

	public void setDespachoVirtualDAO(DespachoVirtualDAO despachoVirtualDAO) {
		this.despachoVirtualDAO = despachoVirtualDAO;
	}

	public DespachoVirtualService getDespachoVirtualService() {
		return despachoVirtualService;
	}

	public void setDespachoVirtualService(DespachoVirtualService despachoVirtualService) {
		this.despachoVirtualService = despachoVirtualService;
	}
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
//			List<IotdtcRecepcionPIDE> listIotdtcRecepcionPIDE = documentoPIDEService.getAllRecepcion();
//	
//			System.out.println("listIotdtcRecepcionPIDE.size()............" + listIotdtcRecepcionPIDE.size());
//			String cflgest = "P";
//			for (int i = 0; i < listIotdtcRecepcionPIDE.size(); i++) {
//				IotdtcRecepcionPIDE iotdtcRecepcionPIDE = listIotdtcRecepcionPIDE.get(i);
////				System.out.println("=====iotdtcRecepcionPIDE===" + listIotdtcRecepcionPIDE.get(i).getCflgest());
//				
//				if (iotdtcRecepcionPIDE.getCflgest().toString().equals("P") && iotdtcRecepcionPIDE.getFlginsert() == null) {
//							
//					IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
//					iotdtcRecepcion.setSidrecext(iotdtcRecepcionPIDE.getSidrecext());
//					iotdtcRecepcion.setCflgenvcar(iotdtcRecepcionPIDE.getCflgenvcar());
//					iotdtcRecepcion.setCflgest(iotdtcRecepcionPIDE.getCflgest());
//					iotdtcRecepcion.setCflgestobs(iotdtcRecepcionPIDE.getCflgestobs());
//					iotdtcRecepcion.setCtipdociderem(iotdtcRecepcionPIDE.getCtipdociderem());
//					iotdtcRecepcion.setDfecmod(iotdtcRecepcionPIDE.getDfecmod());
//					iotdtcRecepcion.setDfecreg(iotdtcRecepcionPIDE.getDfecreg());
//					iotdtcRecepcion.setDfecregstd(iotdtcRecepcionPIDE.getDfecregstd());
//					iotdtcRecepcion.setVanioregstd(iotdtcRecepcionPIDE.getVanioregstd());
//					iotdtcRecepcion.setVcuo(iotdtcRecepcionPIDE.getVcuo());
//					iotdtcRecepcion.setVcuoref(iotdtcRecepcionPIDE.getVcuoref());
//					iotdtcRecepcion.setVdesanxstd(iotdtcRecepcionPIDE.getVdesanxstd());
//					iotdtcRecepcion.setVnumdociderem(iotdtcRecepcionPIDE.getVnumdociderem());
//					iotdtcRecepcion.setVnumregstd(iotdtcRecepcionPIDE.getVnumregstd());
//					iotdtcRecepcion.setVobs(iotdtcRecepcionPIDE.getVobs());
//					iotdtcRecepcion.setVrucentrem(iotdtcRecepcionPIDE.getVrucentrem());
//					iotdtcRecepcion.setVuniorgrem(iotdtcRecepcionPIDE.getVuniorgrem());
//					iotdtcRecepcion.setVuniorgstd(iotdtcRecepcionPIDE.getVuniorgstd());
//					iotdtcRecepcion.setVusumod(iotdtcRecepcionPIDE.getVusumod());
//					iotdtcRecepcion.setVusuregstd(iotdtcRecepcionPIDE.getVusuregstd());
//					
//					
//					IotdtcRecepcion iotdtcRecepcionInserted = recepcionVirtualService.registrarDocumento(iotdtcRecepcion);
//					System.out.println("----------------------------inserto doc Recepcion-----------------------------");
//				}
//			}
//	
//			List<IotdtmDocExternoPIDE> listIotdtcDocExternoPIDE = documentoPIDEService.getAllDocExterno();
//	
//			System.out.println("listIotdtcDocExternoPIDE.size()................" + listIotdtcDocExternoPIDE.size());
//	
//		
//					for(int j = 0; j < listIotdtcRecepcionPIDE.size(); j++) {
//					
//						if(listIotdtcRecepcionPIDE.get(j).getCflgest().toString().equals("P") && listIotdtcRecepcionPIDE.get(j).getFlginsert() == null) {
//							for (int i = 0; i < listIotdtcDocExternoPIDE.size(); i++) {
//								IotdtmDocExternoPIDE iotdtcDocExternoPIDE = listIotdtcDocExternoPIDE.get(i);
////								System.out.println("--------------iotdtcDocExternoPIDE.getSidrecext()----------------" +iotdtcDocExternoPIDE.getSidrecext());
//								if(iotdtcDocExternoPIDE.getSidrecext() != null && 
//										iotdtcDocExternoPIDE.getSidrecext().getSidrecext().equals(listIotdtcRecepcionPIDE.get(j).getSidrecext())) {
//								
//									System.out.println("--------" +iotdtcDocExternoPIDE.getSiddocext());
//								
//	//							System.out.println("------------ingreso al a tabla docexter db13---------");
//									IotdtmDocExterno iotdtcDocExterno = new IotdtmDocExterno();
//									iotdtcDocExterno.setSiddocext(iotdtcDocExternoPIDE.getSiddocext());
//									iotdtcDocExterno.setCcodtipdoc(iotdtcDocExternoPIDE.getCcodtipdoc());
//									iotdtcDocExterno.setCindtup(iotdtcDocExternoPIDE.getCindtup());
//									iotdtcDocExterno.setDfecdoc(iotdtcDocExternoPIDE.getDfecdoc());
//									iotdtcDocExterno.setSnumanx(iotdtcDocExternoPIDE.getSnumanx());
//									iotdtcDocExterno.setSnumfol(iotdtcDocExternoPIDE.getSnumfol());
//									iotdtcDocExterno.setVasu(iotdtcDocExternoPIDE.getVasu());
//									iotdtcDocExterno.setVnomcardst(iotdtcDocExternoPIDE.getVnomcardst());
//									iotdtcDocExterno.setVnomdst(iotdtcDocExternoPIDE.getVnomdst());
//									iotdtcDocExterno.setVnomentemi(iotdtcDocExternoPIDE.getVnomentemi());
//									iotdtcDocExterno.setVnumdoc(iotdtcDocExternoPIDE.getVnumdoc());
//									
//									iotdtcDocExterno.setVuniorgdst(iotdtcDocExternoPIDE.getVuniorgdst());
//									iotdtcDocExterno.setVurldocanx(iotdtcDocExternoPIDE.getVurldocanx());
//									
//									IotdtcDespacho iotdtcDespacho = new IotdtcDespacho();
//									
//									if (iotdtcDocExternoPIDE.getSidemiext() != null) {
//										System.out.println("iotdtcDocExternoPIDE.getSidemiext().getSidemiext()" +iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
//										iotdtcDespacho.setSidemiext(iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
//										iotdtcDocExterno.setSidemiext(iotdtcDespacho); 
//									}
//									
//									IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
//									
//									if(iotdtcDocExternoPIDE.getSidrecext() != null) {
//										System.out.println("===iotdtcDocExternoPIDE.getSidrecext().getSidrecext()== "+iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
//										iotdtcRecepcion.setSidrecext(iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
//										
//										iotdtcDocExterno.setSidrecext(iotdtcRecepcion); 
//									}
//									System.out.println("----------------iotdtcDocExterno-----------------" +iotdtcDocExterno);
//									
//									IotdtmDocExterno iotdtcDocExternoInserted = docExternoVirtualService.registrarDocumento(iotdtcDocExterno);
//							}
//						}
//
//						
//					}
//				}
//			
//			System.out.println("----------------------------inserto doc externo-----------------------------");
//			
//			List<IotdtdDocPrincipalPIDE> listIotdtcDocPrincipalPIDE = documentoPIDEService.getAllDocPrincipal();
//			List<IotdtmDocExterno> listIotdtcDocExterno = docExternoVirtualService.getAll();
//			
//			System.out.println("listIotdtcDocPrincipalPIDE.size()................" + listIotdtcDocPrincipalPIDE.size());
//	
//					
//				for(int j = 0; j < listIotdtcRecepcionPIDE.size(); j++) {
//					
//					if(listIotdtcRecepcionPIDE.get(j).getCflgest().toString().equals("P") && listIotdtcRecepcionPIDE.get(j).getFlginsert() == null) {
//						for(int k = 0; k < listIotdtcDocExternoPIDE.size(); k++) {
//							
//							if(listIotdtcDocExternoPIDE.get(k).getSidrecext() != null && 
//									listIotdtcDocExternoPIDE.get(k).getSidrecext().getSidrecext().equals(listIotdtcRecepcionPIDE.get(j).getSidrecext()) ) {
//								for (int i = 0; i < listIotdtcDocPrincipalPIDE.size(); i++) {	
//									IotdtdDocPrincipalPIDE iotdtcDocPrincipalPIDE = listIotdtcDocPrincipalPIDE.get(i);
//									
//									if(iotdtcDocPrincipalPIDE.getSiddocext().getSiddocext().equals(listIotdtcDocExternoPIDE.get(k).getSiddocext())) {
//										
//										for( int l = 0; l < listIotdtcDocExterno.size(); l++) {
//											if(listIotdtcDocExternoPIDE.get(k).getSidrecext() != null && 
//													listIotdtcDocExternoPIDE.get(k).getSidrecext().getSidrecext().equals(listIotdtcDocExterno.get(l).getSidrecext().getSidrecext())) {
//												
//												IotdtdDocPrincipal iotdtcDocPrincipal = new IotdtdDocPrincipal();
//												iotdtcDocPrincipal.setSiddocpri(iotdtcDocPrincipalPIDE.getSiddocpri());
//												iotdtcDocPrincipal.setBpdfdoc(iotdtcDocPrincipalPIDE.getBpdfdoc());
//												iotdtcDocPrincipal.setCcodest(iotdtcDocPrincipalPIDE.getCcodest());
//												iotdtcDocPrincipal.setDfecreg(iotdtcDocPrincipalPIDE.getDfecreg());
//												iotdtcDocPrincipal.setVnomdoc(iotdtcDocPrincipalPIDE.getVnomdoc());
//												
//												IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
//												
//												if(iotdtcDocPrincipalPIDE.getSiddocext() != null) {
//													iotdtmDocExterno.setSiddocext(iotdtcDocPrincipalPIDE.getSiddocext().getSiddocext()); 
//													iotdtcDocPrincipal.setSiddocext(iotdtmDocExterno); 
//												}
//												
//												IotdtdDocPrincipal iotdtcDocPrincipalInserted = docPrincipalVirtualService.registrarPrincipal(iotdtcDocPrincipal);
//											}
//											
//										}
//									}
//								}
//							}
//						}
//						
//						
//						
//					}
//				}
//				System.out.println("----------------------------inserto principal-----------------------------");
//			
//			
//			List<IotdtdAnexoPIDE> listIotdtcDocAnexoPIDE = documentoPIDEService.getAllAnexo();
//	
//			System.out.println("listIotdtcDocAnexoPIDE.size()..........." + listIotdtcDocAnexoPIDE.size());
//			
//	
//		
//				
//				for(int j= 0; j< listIotdtcRecepcionPIDE.size(); j++) {
//					
//					if(listIotdtcRecepcionPIDE.get(j).getCflgest().toString().equals("P") && listIotdtcRecepcionPIDE.get(j).getFlginsert() == null) {
//						for(int k = 0; k< listIotdtcDocExternoPIDE.size(); k++) {
//							if(listIotdtcDocExternoPIDE.get(k).getSidrecext() != null) {
//								
//								if(listIotdtcDocExternoPIDE.get(k).getSidrecext().getSidrecext().equals(listIotdtcRecepcionPIDE.get(j).getSidrecext()) ) {
//									for (int i = 0; i < listIotdtcDocAnexoPIDE.size(); i++) {			
//										IotdtdAnexoPIDE iotdtcDocAnexoPIDE = listIotdtcDocAnexoPIDE.get(i);
//										if(iotdtcDocAnexoPIDE.getSiddocext().getSiddocext().equals(listIotdtcDocExternoPIDE.get(k).getSiddocext())) {
//											
//											IotdtdAnexo iotdtcDocAnexo = new IotdtdAnexo();
//											iotdtcDocAnexo.setSiddocanx(iotdtcDocAnexoPIDE.getSiddocanx());	
//											iotdtcDocAnexo.setDfecreg(iotdtcDocAnexoPIDE.getDfecreg());
//											iotdtcDocAnexo.setVnomdoc(iotdtcDocAnexoPIDE.getVnomdoc());
//											
//											IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
//											
//											if(iotdtcDocAnexoPIDE.getSiddocext() != null) {
//												iotdtmDocExterno.setSiddocext(iotdtcDocAnexoPIDE.getSiddocext().getSiddocext()); 
//												iotdtcDocAnexo.setSiddocext(iotdtmDocExterno); 
//											}
//											
//											IotdtdAnexo iotdtcDocPrincipalInserted = docAnexoVirtualService.registrarAnexo(iotdtcDocAnexo);
//										}
//								}
//							}
//						}
//						
//					}
//				}
//			}
				
			
			
				
//				documentoPIDEDAOjdbc.updateRecepcionPIDEJOB(iotdtcRecepcionPIDE);
//			TRAER DATOS DE DESPACHO_PIDE A DESPACHO
			
//			List<IotdtcDespachoPIDE> listIotdtcDespachoPIDE = documentoPIDEService.getAllDespacho();
//			List<IotdtcDespacho> listIotdtcDespacho = despachoVirtualDAO.findAll();
//			System.out.println("listIotdtcDespachoPIDE.size()..........." + listIotdtcDespachoPIDE.size());
////			IotdtcDespacho obtenerDespacho = despachoVirtualDAO.findByVcuo(iotdtcDespacho.getVcuo());
//	
//			for (int i = 0; i < listIotdtcDespachoPIDE.size(); i++) {			
//				IotdtcDespachoPIDE iotdtcDespachoPIDE = listIotdtcDespachoPIDE.get(i);
//				
//				if(listIotdtcDespachoPIDE.get(i).getCflgest().toString().equals("R") ||  listIotdtcDespachoPIDE.get(i).getCflgest().toString().equals("O")) {
////					System.out.println("listIotdtcDespachoPIDE.get(i).toString()------------- " +listIotdtcDespachoPIDE.get(i).toString());
//					
//					for(int j = 0; j<listIotdtcDespacho.size(); j++) {
////						System.out.println("-----------listIotdtcDespacho.get(j).getVcuo()----------" +listIotdtcDespacho.get(j).getVcuo());
//						if(listIotdtcDespacho.get(j).getVcuo() != null && listIotdtcDespacho.get(j).getVcuo().equals(iotdtcDespachoPIDE.getVcuo())) {
//							
//							IotdtcDespacho iotdtcDespacho = new IotdtcDespacho();
//							iotdtcDespacho.setSidemiext(iotdtcDespachoPIDE.getSidemiext());;
//							iotdtcDespacho.setVnumregstd(iotdtcDespachoPIDE.getVnumregstd());
//							iotdtcDespacho.setVanioregstd(iotdtcDespachoPIDE.getVanioregstd());
//							iotdtcDespacho.setCtipdociderem(iotdtcDespachoPIDE.getCtipdociderem());
//							iotdtcDespacho.setVnumdociderem(iotdtcDespachoPIDE.getVnumdociderem());
//							iotdtcDespacho.setVcoduniorgrem(iotdtcDespachoPIDE.getVcoduniorgrem());
//							iotdtcDespacho.setVuniorgrem(iotdtcDespachoPIDE.getVuniorgrem());
//							iotdtcDespacho.setVcuo(iotdtcDespachoPIDE.getVcuo());
//							iotdtcDespacho.setVrucentrec(iotdtcDespachoPIDE.getVrucentrec());
//							iotdtcDespacho.setVnomentrec(iotdtcDespachoPIDE.getVnomentrec());
//							iotdtcDespacho.setVnumregstdrec(iotdtcDespachoPIDE.getVnumregstdrec());;
//							iotdtcDespacho.setVanioregstdrec(iotdtcDespachoPIDE.getVanioregstdrec());
//							iotdtcDespacho.setVdesanxstdrec(iotdtcDespachoPIDE.getVdesanxstdrec());
//							iotdtcDespacho.setDfecregstdrec(iotdtcDespachoPIDE.getDfecregstdrec());
//							iotdtcDespacho.setVusuregstdrec(iotdtcDespachoPIDE.getVusuregstdrec());
//							iotdtcDespacho.setBcarstdrec(iotdtcDespachoPIDE.getBcarstdrec());
//							iotdtcDespacho.setVobs(iotdtcDespachoPIDE.getVobs());
//							iotdtcDespacho.setVcuoref(iotdtcDespachoPIDE.getVcuoref());
//							iotdtcDespacho.setCflgest(iotdtcDespachoPIDE.getCflgest());
//							iotdtcDespacho.setDfecenv(iotdtcDespachoPIDE.getDfecenv());
//							iotdtcDespacho.setVusureg(iotdtcDespachoPIDE.getVusureg());
//							iotdtcDespacho.setDfecreg(iotdtcDespachoPIDE.getDfecreg());
//							iotdtcDespacho.setVusumod(iotdtcDespachoPIDE.getVusumod());
//							iotdtcDespacho.setDfecmod(iotdtcDespachoPIDE.getDfecmod());
//							iotdtcDespacho.setCflgenv('S');
//							iotdtcDespacho.setIddocumento(listIotdtcDespacho.get(j).getIddocumento());
//							
//							despachoVirtualService.registrarDocumento(iotdtcDespacho);
//							
//						}
//					}
//			
//						}
//					}
//				System.out.println("----------------------------inserto depacho-----------------------------");
					
			
				//--------------------------------------------------ACTUALIZAR FLAG INSERT EN RECEPCIONPIDE ----------------------------------------------------------
//				for (int i = 0; i < listIotdtcRecepcionPIDE.size(); i++) {
//					if(listIotdtcRecepcionPIDE.get(i).getCflgest().toString().equals("P") && listIotdtcRecepcionPIDE.get(i).getFlginsert() == null) {
//						documentoPIDEDAOjdbc.updateRecepcionPIDEJOB(listIotdtcRecepcionPIDE.get(i));
//						System.out.println("----------se actulizo flag de insert pide -----------------------------");
//					}
//				}
			
			
			///-------------------------TRAER INFROMACON DEL SERVIDOR PIDE ----RECEPCION------------
			List<IotdtcRecepcionPIDE> listIotdtcRecepcionPIDE = documentoPIDEService.getAllRecepcionToMigrate();
			List<IotdtmDocExternoPIDE> listIotdtmDocExternoPIDE = documentoPIDEService.getAllDocExternoToMigrate();
			List<IotdtdDocPrincipalPIDE> listIotdtdDocPrincipalPIDE = documentoPIDEService.getAllDocPrincipalToMigrate();
			List<IotdtdAnexoPIDE> listIotdtdAnexoPIDE = documentoPIDEService.getAllAnexoToMigrate();
	
			
			for(int i = 0; i< listIotdtcRecepcionPIDE.size(); i++) {
				System.out.println("------------------IotdtcRecepcionPIDE------------------------" +listIotdtcRecepcionPIDE.get(i).getSidrecext());
				IotdtcRecepcionPIDE iotdtcRecepcionPIDE = listIotdtcRecepcionPIDE.get(i);
				
//				IotdtmDocExterno  lstIotdtmDocExterno = docExternoVirtualService.findSiddocextToMigrate(iotdtcRecepcionPIDE.getSidrecext());
//				System.out.println("-----------------lstIotdtmDocExterno---------------" +lstIotdtmDocExterno.get(i));
//		----------------------		insertando a recepcion
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
				IotdtcRecepcion IotdtcRecepcionInserted = recepcionVirtualService.registrarDocumento(iotdtcRecepcion);
//				
				
				
				//INSERTAR AL DOCEXTERNO-------------------------------------------------
				
				System.out.println("--------------------------------listIotdtmDocExternoPIDE---------------" + listIotdtmDocExternoPIDE.get(i).getSiddocext());
				IotdtmDocExternoPIDE iotdtcDocExternoPIDE = listIotdtmDocExternoPIDE.get(i);
				
				if(iotdtcDocExternoPIDE.getSidrecext() != null && iotdtcRecepcionPIDE.getSidrecext().equals(iotdtcDocExternoPIDE.getSidrecext().getSidrecext())) {
					IotdtmDocExterno iotdtcDocExterno = new IotdtmDocExterno();
//					iotdtcDocExterno.setSiddocext(iotdtcDocExternoPIDE.getSiddocext());
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
						System.out.println("iotdtcDocExternoPIDE.getSidemiext().getSidemiext()" +iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
						iotdtcDespacho.setSidemiext(iotdtcDocExternoPIDE.getSidemiext().getSidemiext());
						iotdtcDocExterno.setSidemiext(iotdtcDespacho); 
					}
					
					IotdtcRecepcion iotdtcRecepcionFound = new IotdtcRecepcion();
					
					if(iotdtcDocExternoPIDE.getSidrecext() != null) {
						System.out.println("===iotdtcDocExternoPIDE.getSidrecext().getSidrecext()== "+iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
						iotdtcRecepcionFound.setSidrecext(iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
						
						iotdtcDocExterno.setSidrecext(iotdtcRecepcionFound); 
					}
					
					
					docExternoVirtualService.registrarDocumento(iotdtcDocExterno);
				}
				
////					List<IotdtmDocExterno>  lstIotdtmDocExterno = docExternoVirtualService.findSiddocextToMigrate(iotdtcRecepcionPIDE.getSidrecext());
				List<IotdtmDocExterno>  lstIotdtmDocExterno = docExternoVirtualService.findSiddocextToMigrate(iotdtcRecepcionPIDE.getSidrecext());
				System.out.println("lstIotdtmDocExterno---------------: " +lstIotdtmDocExterno.get(0));
				IotdtdDocPrincipalPIDE iotdtdDocPrincipalPIDE = listIotdtdDocPrincipalPIDE.get(i);
				if(iotdtdDocPrincipalPIDE != null && iotdtdDocPrincipalPIDE.getSiddocext().getSiddocext().equals(iotdtcDocExternoPIDE.getSiddocext())) {
					System.out.println("--------------------------------listIotdtdDocPrincipalPIDE---------------" + listIotdtdDocPrincipalPIDE.get(i).getSiddocext().getSiddocext());
					
//					IotdtmDocExterno  lstIotdtmDocExternoSidex = docExternoVirtualService.findSiddocextToMigrate(iotdtcRecepcionPIDE.getSidrecext());
					IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
					IotdtdDocPrincipal iotdtcDocPrincipal = new IotdtdDocPrincipal();
//					iotdtcDocPrincipal.setSiddocpri(iotdtdDocPrincipalPIDE.getSiddocpri());
					iotdtcDocPrincipal.setBpdfdoc(iotdtdDocPrincipalPIDE.getBpdfdoc());
					iotdtcDocPrincipal.setCcodest(iotdtdDocPrincipalPIDE.getCcodest());
					iotdtcDocPrincipal.setDfecreg(iotdtdDocPrincipalPIDE.getDfecreg());
					iotdtcDocPrincipal.setVnomdoc(iotdtdDocPrincipalPIDE.getVnomdoc());
//					iotdtcDocPrincipal.setSiddocext(iotdtmDocExterno);
					
					
					if(iotdtdDocPrincipalPIDE.getSiddocext() != null) {
						iotdtmDocExterno.setSiddocext(lstIotdtmDocExterno.get(0).getSiddocext()); 
						iotdtcDocPrincipal.setSiddocext(iotdtmDocExterno); 
					}
					
				docPrincipalVirtualService.registrarPrincipal(iotdtcDocPrincipal);
				}
//				System.out.println("--------------------------------listIotdtdAnexoPIDE---------------" + listIotdtdAnexoPIDE.get(i).getSiddocext());
				for(int j = 0; j < listIotdtdAnexoPIDE.size(); j++) {
					IotdtdAnexoPIDE iotdtdAnexoPIDE = listIotdtdAnexoPIDE.get(j);
					if(iotdtdAnexoPIDE != null && iotdtdAnexoPIDE.getSiddocext().getSiddocext().equals(iotdtcDocExternoPIDE.getSiddocext())) {
						IotdtdAnexo iotdtcDocAnexo = new IotdtdAnexo();
//						iotdtcDocAnexo.setSiddocanx(iotdtdAnexoPIDE.getSiddocanx());	
						iotdtcDocAnexo.setDfecreg(iotdtdAnexoPIDE.getDfecreg());
						iotdtcDocAnexo.setVnomdoc(iotdtdAnexoPIDE.getVnomdoc());
						
						IotdtmDocExterno iotdtmDocExterno = new IotdtmDocExterno();
						
						if(iotdtdAnexoPIDE.getSiddocext() != null) {
							iotdtmDocExterno.setSiddocext(lstIotdtmDocExterno.get(0).getSiddocext()); 
							iotdtcDocAnexo.setSiddocext(iotdtmDocExterno); 
						}
						
						docAnexoVirtualService.registrarAnexo(iotdtcDocAnexo);
					}
				}
				
				//Actualizar Recepcion
//				System.out.println("------------------------iotdtcRecepcionPIDE ----------------------" +iotdtcRecepcionPIDE);
				if(IotdtcRecepcionInserted.getVcuo().equals(iotdtcRecepcionPIDE.getVcuo())) {
					
					documentoPIDEDAOjdbc.updateRecepcionPIDEJOB(iotdtcRecepcionPIDE);
				}
			}
			
			
			//--------------------------TRAER DATOS DE DESPACHO_PIDE A DESPACHO
			
			List<IotdtcDespachoPIDE> listIotdtcDespachoPIDE = documentoPIDEService.getAllDespachoToMigrate();
			List<IotdtcDespacho> listIotdtcDespacho = despachoVirtualDAO.findAll();
			System.out.println("listIotdtcDespachoPIDE.size()..........." + listIotdtcDespachoPIDE.size());
			
			if(listIotdtcDespachoPIDE.size() > 0 && listIotdtcDespachoPIDE != null) {
				
				for (int k = 0; k < listIotdtcDespachoPIDE.size(); k++) {			
					IotdtcDespachoPIDE iotdtcDespachoPIDE = listIotdtcDespachoPIDE.get(k);
					
					for(int m = 0; m<listIotdtcDespacho.size(); m++) {
						
						if(iotdtcDespachoPIDE.getVcuo() != null && listIotdtcDespacho.get(m).getVcuo() != null && listIotdtcDespacho.get(m).getVcuo().equals(iotdtcDespachoPIDE.getVcuo())) {
//							System.out.println("-------------------iotdtcDespachoPIDE.getVcuo()---------------" +iotdtcDespachoPIDE.getVcuo());
							IotdtcDespacho iotdtcDespacho = new IotdtcDespacho();
							iotdtcDespacho.setSidemiext(iotdtcDespachoPIDE.getSidemiext());;
							iotdtcDespacho.setVnumregstd(iotdtcDespachoPIDE.getVnumregstd());
							iotdtcDespacho.setVanioregstd(iotdtcDespachoPIDE.getVanioregstd());
							iotdtcDespacho.setCtipdociderem(iotdtcDespachoPIDE.getCtipdociderem());
							iotdtcDespacho.setVnumdociderem(iotdtcDespachoPIDE.getVnumdociderem());
							iotdtcDespacho.setVcoduniorgrem(iotdtcDespachoPIDE.getVcoduniorgrem());
							iotdtcDespacho.setVuniorgrem(iotdtcDespachoPIDE.getVuniorgrem());
							iotdtcDespacho.setVcuo(iotdtcDespachoPIDE.getVcuo());
							iotdtcDespacho.setVrucentrec(iotdtcDespachoPIDE.getVrucentrec());
							iotdtcDespacho.setVnomentrec(iotdtcDespachoPIDE.getVnomentrec());
							iotdtcDespacho.setVnumregstdrec(iotdtcDespachoPIDE.getVnumregstdrec());;
							iotdtcDespacho.setVanioregstdrec(iotdtcDespachoPIDE.getVanioregstdrec());
							iotdtcDespacho.setVdesanxstdrec(iotdtcDespachoPIDE.getVdesanxstdrec());
							iotdtcDespacho.setDfecregstdrec(iotdtcDespachoPIDE.getDfecregstdrec());
							iotdtcDespacho.setVusuregstdrec(iotdtcDespachoPIDE.getVusuregstdrec());
							iotdtcDespacho.setBcarstdrec(iotdtcDespachoPIDE.getBcarstdrec());
							iotdtcDespacho.setVobs(iotdtcDespachoPIDE.getVobs());
							iotdtcDespacho.setVcuoref(iotdtcDespachoPIDE.getVcuoref());
							iotdtcDespacho.setCflgest(iotdtcDespachoPIDE.getCflgest());
							iotdtcDespacho.setDfecenv(iotdtcDespachoPIDE.getDfecenv());
							iotdtcDespacho.setVusureg(iotdtcDespachoPIDE.getVusureg());
							iotdtcDespacho.setDfecreg(iotdtcDespachoPIDE.getDfecreg());
							iotdtcDespacho.setVusumod(iotdtcDespachoPIDE.getVusumod());
							iotdtcDespacho.setDfecmod(iotdtcDespachoPIDE.getDfecmod());
							iotdtcDespacho.setCflgenv('S');
							iotdtcDespacho.setVuniorgstdrec(iotdtcDespachoPIDE.getVuniorgstdrec());
							iotdtcDespacho.setIddocumento(listIotdtcDespacho.get(m).getIddocumento());
							
							documentoPIDEDAOjdbc.updateDespachoJOB(iotdtcDespacho);
							
							//Actualizar Despacho
//							System.out.println("------------------------iotdtcRecepcionPIDE ----------------------" +iotdtcRecepcionPIDE);
							documentoPIDEDAOjdbc.updateDespachoPIDEJOB(iotdtcDespachoPIDE);
							
						}
					}
					
				}
			}

				
					
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR EN LOS INSERT");
			System.out.println(e.getMessage()); 
		}
	}
	
}