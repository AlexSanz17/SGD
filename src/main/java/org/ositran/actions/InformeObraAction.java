package org.ositran.actions;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import org.ositran.services.InformeObraService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.btg.ositran.siged.domain.InformeObra;

import com.opensymphony.xwork2.ActionSupport;

public class InformeObraAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
//	private InformeObra informeObra;
	private InformeObraService informeObraService;
	
	private String contrato;
	private String razonSocial;
	private String ruc;
	private String tipoObra;
	private String fechaInicio;
	private String fechaTermino;
	private String monto;
	private String beneficiarios;
	private String descripcion;
	private String fechaCreacion;
	private String fechaModificacion;
	
//	private final Logger log = LoggerFactory.getLogger(DocumentoAction.class);
    
	@Override
	public void setServletResponse(HttpServletResponse response) {
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
	}
	
//	public InformeObra getInformeObra() {
//		return informeObra;
//	}
//
//	public void setInformeObra(InformeObra informeObra) {
//		this.informeObra = informeObra;
//	}

	public InformeObraService getInformeObraService() {
		return informeObraService;
	}

	public void setInformeObraService(InformeObraService informeObraService) {
		this.informeObraService = informeObraService;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTipoObra() {
		return tipoObra;
	}

	public void setTipoObra(String tipoObra) {
		this.tipoObra = tipoObra;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(String beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	public String mostrarInformeObra() throws Exception {
        return "mostrarInformeObra";
    }

	public String registrarInformeObra() throws Exception {
		System.out.println("CONTRATO-.---------------" +contrato);
		System.out.println("razonSocial-.---------------" +razonSocial);
		System.out.println("ruc-.---------------" +ruc);
		System.out.println("tipoObra-.---------------" +tipoObra);
		System.out.println("fechaTermino-.---------------" +fechaTermino);
		System.out.println("fechaInicio-.---------------" +fechaInicio);
		System.out.println("-----------------ingreso");
		InformeObra informeObra = new InformeObra();
		System.out.println("-----------------ingreso");
		informeObra.setContrato(contrato);
		informeObra.setRazonSocial(razonSocial);
		informeObra.setRuc(ruc);
		informeObra.setTipoObra(tipoObra);
		informeObra.setFechaInicio(Date.valueOf(fechaInicio));
        informeObra.setFechatermino(Date.valueOf(fechaTermino));
		informeObra.setMonto(Integer.valueOf(monto));
	 	informeObra.setBeneficiarios(Integer.valueOf(beneficiarios));
		informeObra.setDescripcion(descripcion);
		informeObra.setFechaCreacion(Date.valueOf("2022-01-31"));
		informeObra.setFechaModificacion(Date.valueOf("2022-01-31"));
		System.out.println("-----------------informeObra" +informeObra);
		informeObraService.create(informeObra);
		System.out.println("-----------------guardo");

//		log.debug("InformeObraAction::registrarInformeObra()");
//		log.info("contrato " + informeObra.getContrato() + "razonSocial " + informeObra.getRazonSocial());
	    
		return "registrarInformeObra";
	}
	
	 public String mostrarVistaInformeObra() throws Exception { 
//	        log.debug("InformeObraAction::mostrarVistaInformeObra()");
//	  log.info("contrato " + contrato + "razonSocial " +
//	razonSocial); 
	        return "nuevoInforme";
	    }

	
}