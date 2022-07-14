package org.ositran.utils;

import java.util.Date;


public class InformeObraDetail {
	
	private Integer idInformeObra;
	private String contrato;
	private String razonSocial;
	private String ruc;
	private String tipoObra;
    private Date fechaInicio;
	private Date fechatermino;
	private Integer monto;
	private Integer beneficiarios;
	private String descripcion;
	private Date fechaCreacion; 
	private Date fechaModificacion;

	public Integer getIdInformeObra() {
		return idInformeObra;
	}

	public void setIdInformeObra(Integer idInformeObra) {
		this.idInformeObra = idInformeObra;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechatermino() {
		return fechatermino;
	}

	public void setFechatermino(Date fechatermino) {
		this.fechatermino = fechatermino;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Integer beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	@Override
	public String toString() {
		return "InformeObraDetail [idInformeObra=" + idInformeObra + ", contrato=" + contrato + ", razonSocial="
				+ razonSocial + ", ruc=" + ruc + ", tipoObra=" + tipoObra + ", fechaInicio=" + fechaInicio
				+ ", fechatermino=" + fechatermino + ", monto=" + monto + ", beneficiarios=" + beneficiarios
				+ ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion="
				+ fechaModificacion + "]";
	}
	
}
