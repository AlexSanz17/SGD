package org.ositran.controllers;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.ositran.services.DocumentoService;
import org.ositran.utils.Constantes;
import org.ositran.utils.DocumentoDetail;

import com.btg.ositran.siged.domain.Cliente;
import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.Expediente;
import com.btg.ositran.siged.domain.Proceso;
import com.btg.ositran.siged.domain.Usuario;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/mesapartes")
public class IntegracionMesaVirtualController implements ModelDriven<Documento> {

	private static Logger log = Logger.getLogger(IntegracionMesaVirtualController.class);
	
	// Services
	private DocumentoService documentoService;

	/*
	 * Methods
	 */
	
	// POST /expediente
	public HttpHeaders create() {
		if (log.isDebugEnabled()) {
			log.debug("ingreso a crear [ proceso de mesa partes  ]");
		}

		try {
			
			documentoService.saveNuevoDocumentoUserFinal(null, null, null, null, null, false, null, null, null);

			return new DefaultHttpHeaders("success").setLocationId("");
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return new DefaultHttpHeaders("error");
		}
	}

	@Override
	public Documento getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
