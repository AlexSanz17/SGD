package org.ositran.ajax.beans;

public class CargoRecepcionMPVRequest {
	public String Fk_eDocumento;
	public String cExpediente;
	public String fFecha;
	public String Fk_eUsuario;
	public String EstadoDoc;
	public String cObservacion;
	public String fFechaRecep;
	public String fFechaRecha;
	
	public CargoRecepcionMPVRequest() {
	}
	
	public String getFk_eDocumento() {
		return Fk_eDocumento;
	}

	public void setFk_eDocumento(String fk_eDocumento) {
		Fk_eDocumento = fk_eDocumento;
	}
	
	public String getcExpediente() {
		return cExpediente;
	}
	
	public void setcExpediente(String cExpediente) {
		this.cExpediente = cExpediente;
	}
	
	public String getfFecha() {
		return fFecha;
	}
	
	public void setfFecha(String fFecha) {
		this.fFecha = fFecha;
	}
	
	public String getEstadoDoc() {
		return EstadoDoc;
	}

	public void setEstadoDoc(String estadoDoc) {
		EstadoDoc = estadoDoc;
	}

	public String getFk_eUsuario() {
		return Fk_eUsuario;
	}

	public void setFk_eUsuario(String fk_eUsuario) {
		Fk_eUsuario = fk_eUsuario;
	}

	public String getcObservacion() {
		return cObservacion;
	}

	public void setcObservacion(String cObservacion) {
		this.cObservacion = cObservacion;
	}
	
	public String getfFechaRecep() {
		return fFechaRecep;
	}
	
	public void setfFechaRecep(String fFechaRecep) {
		this.fFechaRecep = fFechaRecep;
	}
	
	public String getfFechaRecha() {
		return fFechaRecha;
	}
	
	public void setfFechaRecha(String fFechaRecha) {
		this.fFechaRecha = fFechaRecha;
	}

	@Override
	public String toString() {
		return "CargoRecepcionMPVRequest [Fk_eDocumento=" + Fk_eDocumento + ", cExpediente=" + cExpediente + ", fFecha="
			+ fFecha + ", Fk_eUsuario=" + Fk_eUsuario + ", EstadoDoc=" + EstadoDoc + ", cObservacion="
			+ cObservacion + ", fFechaRecep=" + fFechaRecep + ", fFechaRecha=" + fFechaRecha + "]";
	}
}