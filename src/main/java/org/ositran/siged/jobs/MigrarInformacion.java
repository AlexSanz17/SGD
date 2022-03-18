package org.ositran.siged.jobs;

import java.util.List;

import org.ositran.services.DocAnexoVirtualService;
import org.ositran.services.DocExternoVirtualService;
import org.ositran.services.DocPrincipalVirtualService;
import org.ositran.services.DocumentoPIDEService;
import org.ositran.services.RecepcionVirtualService;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.IotdtcDespacho;
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
	
	@Transactional
	public void migrar() {
		System.out.println("============================");
		System.out.println("Job migracion");
		System.out.println("============================");

		try {
			
		
		
		// tabla de datos IOTDTC_RECEPCION
		List<IotdtcRecepcionPIDE> listIotdtcRecepcionPIDE = documentoPIDEService.getAllRecepcion();

		System.out.println(listIotdtcRecepcionPIDE.size());

		for (int i = 0; i < listIotdtcRecepcionPIDE.size(); i++) {

			IotdtcRecepcionPIDE iotdtcRecepcionPIDE = listIotdtcRecepcionPIDE.get(i);
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

			System.out.println("**********");
			System.out.println("INSERT");
			System.out.println("**********");
			IotdtcRecepcion iotdtcRecepcionInserted = recepcionVirtualService.registrarDocumento(iotdtcRecepcion);

			System.out.println("resultado: " + iotdtcRecepcionInserted);
		}

		System.out.println("Total de datos");
		List<IotdtcRecepcion> ipIotdtcRecepcions = recepcionVirtualService.getAll();
		System.out.println(ipIotdtcRecepcions.size());

		// TABLA DE DATOS [IOTDTM_DOC_EXTERNO]
		List<IotdtmDocExternoPIDE> listIotdtcDocExternoPIDE = documentoPIDEService.getAllDocExterno();

		System.out.println(listIotdtcDocExternoPIDE.size());
		

		IotdtmDocExterno iotdtcDocExterno = null;
		
		for (int i = 0; i < listIotdtcDocExternoPIDE.size(); i++) {			
			IotdtmDocExternoPIDE iotdtcDocExternoPIDE = listIotdtcDocExternoPIDE.get(i);
			iotdtcDocExterno = new IotdtmDocExterno();
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
			if(iotdtcDocExternoPIDE.getSidrecext() != null) {
				iotdtcRecepcion.setSidrecext(iotdtcDocExternoPIDE.getSidrecext().getSidrecext());
				iotdtcDocExterno.setSidrecext(iotdtcRecepcion); 
			}
			
			
			
			System.out.println("**********");
			System.out.println("iotdtcDocExternoPIDE");
			System.out.println(iotdtcDocExternoPIDE);
			
			IotdtmDocExterno iotdtcDocExternoInserted = docExternoVirtualService.registrarDocumento(iotdtcDocExterno);
		}

		System.out.println("leer datos de schema getAllSchemaIdosgd");


		
		List<IotdtdDocPrincipalPIDE> listIotdtcDocPrincipalPIDE = documentoPIDEService.getAllDocPrincipal();

		System.out.println(listIotdtcDocPrincipalPIDE.size());

		for (int i = 0; i < listIotdtcDocPrincipalPIDE.size(); i++) {			
			IotdtdDocPrincipalPIDE iotdtcDocPrincipalPIDE = listIotdtcDocPrincipalPIDE.get(i);
			IotdtdDocPrincipal iotdtcDocPrincipal = new IotdtdDocPrincipal();
			iotdtcDocPrincipal.setSiddocpri(iotdtcDocPrincipalPIDE.getSiddocpri());
			iotdtcDocPrincipal.setBpdfdoc(iotdtcDocPrincipalPIDE.getBpdfdoc());
			iotdtcDocPrincipal.setCcodest(iotdtcDocPrincipalPIDE.getCcodest());
			iotdtcDocPrincipal.setDfecreg(iotdtcDocPrincipalPIDE.getDfecreg());
			iotdtcDocPrincipal.setVnomdoc(iotdtcDocPrincipalPIDE.getVnomdoc());
			iotdtcDocPrincipal.setSsiddocext(iotdtcDocPrincipalPIDE.getSsiddocext());
			iotdtcDocPrincipal.setSiddocext(iotdtcDocExterno);
			
			System.out.println("**********");
			System.out.println("iotdtcDocPrincipalPIDE");
			System.out.println(iotdtcDocPrincipalPIDE);
			
			IotdtdDocPrincipal iotdtcDocPrincipalInserted = docPrincipalVirtualService.registrarPrincipal(iotdtcDocPrincipal);
		}
		
		
		List<IotdtdAnexoPIDE> listIotdtcDocAnexoPIDE = documentoPIDEService.getAllAnexo();

		System.out.println(listIotdtcDocAnexoPIDE.size());

		for (int i = 0; i < listIotdtcDocAnexoPIDE.size(); i++) {			
			IotdtdAnexoPIDE iotdtcDocAnexoPIDE = listIotdtcDocAnexoPIDE.get(i);
			IotdtdAnexo iotdtcDocAnexo = new IotdtdAnexo();
			iotdtcDocAnexo.setSiddocanx(iotdtcDocAnexoPIDE.getSiddocanx());	
			iotdtcDocAnexo.setDfecreg(iotdtcDocAnexoPIDE.getDfecreg());
			iotdtcDocAnexo.setVnomdoc(iotdtcDocAnexoPIDE.getVnomdoc());
			iotdtcDocAnexo.setSsiddocext(iotdtcDocAnexoPIDE.getSsiddocext());
			iotdtcDocAnexo.setSiddocext(iotdtcDocExterno);
			
			System.out.println("**********");
			System.out.println("iotdtcDocAnexoPIDE");
			System.out.println(iotdtcDocAnexoPIDE);
			
			IotdtdAnexo iotdtcDocPrincipalInserted = docAnexoVirtualService.registrarAnexo(iotdtcDocAnexo);
		}
		
		} catch (Exception e) {
			System.out.println("ERROR EN LOS INSERT");
			System.out.println(e.getMessage()); 
			// TODO: handle exception
		}
		
	}

}
