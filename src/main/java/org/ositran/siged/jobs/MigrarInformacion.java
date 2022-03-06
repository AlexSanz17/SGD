package org.ositran.siged.jobs;

import java.util.List;

import org.ositran.services.RecepcionVirtualService;
import org.ositran.services.RecepcionVirtualServiceMpv;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionSchemaIdsgd;

public class MigrarInformacion {

	private RecepcionVirtualService recepcionVirtualService;
	private RecepcionVirtualServiceMpv recepcionVirtualServiceMpv;

	@Transactional
	public void migrar() {
		System.out.println("============================");
		System.out.println("Job migracion");
		System.out.println("============================");

		System.out.println("*************************************");
		System.out.println("leer datos de interoperabilidad ");
		System.out.println("*************************************");

		
		// tabla de datos IOTDTC_RECEPCION
		List<IotdtcRecepcionSchemaIdsgd> iotdtcRecepcionSchemaIdsgds = recepcionVirtualServiceMpv.getAll();
		System.out.println(iotdtcRecepcionSchemaIdsgds.size());

		for (int i = 0; i < iotdtcRecepcionSchemaIdsgds.size(); i++) {

			IotdtcRecepcionSchemaIdsgd iotdtcRecepcionSchemaIdsgd = iotdtcRecepcionSchemaIdsgds.get(i);
			IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
			iotdtcRecepcion.setSidrecext(iotdtcRecepcionSchemaIdsgd.getSidrecext()); 
			iotdtcRecepcion.setCflgenvcar(iotdtcRecepcionSchemaIdsgd.getCflgenvcar());
			iotdtcRecepcion.setCflgest(iotdtcRecepcionSchemaIdsgd.getCflgest());
			iotdtcRecepcion.setCflgestobs(iotdtcRecepcionSchemaIdsgd.getCflgestobs());
			iotdtcRecepcion.setCtipdociderem(iotdtcRecepcionSchemaIdsgd.getCtipdociderem());
			iotdtcRecepcion.setDfecmod(iotdtcRecepcionSchemaIdsgd.getDfecmod());
			iotdtcRecepcion.setDfecreg(iotdtcRecepcionSchemaIdsgd.getDfecreg());
			iotdtcRecepcion.setDfecregstd(iotdtcRecepcionSchemaIdsgd.getDfecregstd());
			iotdtcRecepcion.setVanioregstd(iotdtcRecepcionSchemaIdsgd.getVanioregstd());
			iotdtcRecepcion.setVcuo(iotdtcRecepcionSchemaIdsgd.getVcuo());
			iotdtcRecepcion.setVcuoref(iotdtcRecepcionSchemaIdsgd.getVcuoref());
			iotdtcRecepcion.setVdesanxstd(iotdtcRecepcionSchemaIdsgd.getVdesanxstd());
			iotdtcRecepcion.setVnumdociderem(iotdtcRecepcionSchemaIdsgd.getVnumdociderem());
			iotdtcRecepcion.setVnumregstd(iotdtcRecepcionSchemaIdsgd.getVnumregstd());
			iotdtcRecepcion.setVobs(iotdtcRecepcionSchemaIdsgd.getVobs());
			iotdtcRecepcion.setVrucentrem(iotdtcRecepcionSchemaIdsgd.getVrucentrem());
			iotdtcRecepcion.setVuniorgrem(iotdtcRecepcionSchemaIdsgd.getVuniorgrem());
			iotdtcRecepcion.setVuniorgstd(iotdtcRecepcionSchemaIdsgd.getVuniorgstd());
			iotdtcRecepcion.setVusumod(iotdtcRecepcionSchemaIdsgd.getVusumod());
			iotdtcRecepcion.setVusuregstd(iotdtcRecepcionSchemaIdsgd.getVusuregstd());

			System.out.println("**********");
			System.out.println("INSERT");
			System.out.println("**********");
			IotdtcRecepcion iotdtcRecepcionInserted = recepcionVirtualService.registrarDocumento(iotdtcRecepcion);

			System.out.println("resultado: " + iotdtcRecepcionInserted);
		}

		System.out.println("Total de datos");
		List<IotdtcRecepcion> ipIotdtcRecepcions = recepcionVirtualService.getAll();
		System.out.println(ipIotdtcRecepcions.size());
		
		
		// TABLA DE DATOS 
		

	}

	public RecepcionVirtualService getRecepcionVirtualService() {
		return recepcionVirtualService;
	}

	public void setRecepcionVirtualService(RecepcionVirtualService recepcionVirtualService) {
		this.recepcionVirtualService = recepcionVirtualService;
	}

	public RecepcionVirtualServiceMpv getRecepcionVirtualServiceMpv() {
		return recepcionVirtualServiceMpv;
	}

	public void setRecepcionVirtualServiceMpv(RecepcionVirtualServiceMpv recepcionVirtualServiceMpv) {
		this.recepcionVirtualServiceMpv = recepcionVirtualServiceMpv;
	}

}
