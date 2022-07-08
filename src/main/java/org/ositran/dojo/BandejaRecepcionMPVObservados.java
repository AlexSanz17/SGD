package org.ositran.dojo;

import java.util.Date;

public class BandejaRecepcionMPVObservados {
	private Integer sidrecext;
	private String nroTramite;
	private String virtual;
	private String documento;
	private String asunto;
	private String estado;
	private Date fechaRegistro;
	private Date fechaRechazo;
	private String carpeta;
	private String asuntoCarpeta;
	private String cliente;
	private String contrato;
	private String obs;
	private String rutaArchivo;
	private String nombreArchivo;
	public Integer getSidrecext() {
		return sidrecext;
	}
	public void setSidrecext(Integer sidrecext) {
		this.sidrecext = sidrecext;
	}
	public String getVirtual() {
		return virtual;
	}
	public void setVirtual(String virtual) {
		this.virtual = virtual;
	}
	public String getNroTramite() {
		return nroTramite;
	}
	public void setNroTramite(String nroTramite) {
		this.nroTramite = nroTramite;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaRechazo() {
		return fechaRechazo;
	}
	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}
	public String getCarpeta() {
		return carpeta;
	}
	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}
	public String getAsuntoCarpeta() {
		return asuntoCarpeta;
	}
	public void setAsuntoCarpeta(String asuntoCarpeta) {
		this.asuntoCarpeta = asuntoCarpeta;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	@Override
	public String toString() {
		return "BandejaRecepcionMPVObservados [sidrecext=" + sidrecext + ", nroTramite=" + nroTramite + ", virtual="
				+ virtual + ", documento=" + documento + ", asunto=" + asunto + ", estado=" + estado
				+ ", fechaRegistro=" + fechaRegistro + ", fechaRechazo=" + fechaRechazo + ", carpeta=" + carpeta
				+ ", asuntoCarpeta=" + asuntoCarpeta + ", cliente=" + cliente + ", contrato=" + contrato + ", obs="
				+ obs + ", rutaArchivo=" + rutaArchivo + ", nombreArchivo=" + nombreArchivo + "]";
	}
	
}
