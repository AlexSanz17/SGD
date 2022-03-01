package org.ositran.ajax.beans;

public class CargoRecepcionMPVRequest {
	public String Fk_eDocumento;
	public String cExpediente;
	public String fFecha;
	public String Fk_eUsuario;
	public String EstadoDoc;
	public String fFechaRecep;
	public String fFechaRecha;
	
	public String geteDocumento() {
		return Fk_eDocumento;
	}
	
	public void seteDocumento(String Fk_eDocumento) {
		this.Fk_eDocumento = Fk_eDocumento;
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
	
	public String geteUsuario() {
		return Fk_eUsuario;
	}
	
	public void seteUsuario(String Fk_eUsuario) {
		this.Fk_eUsuario = Fk_eUsuario;
	}
	
	public String geteEstadoDoc() {
		return EstadoDoc;
	}
	
	public void seteEstadoDoc(String EstadoDoc) {
		this.EstadoDoc = EstadoDoc;
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

	public CargoRecepcionMPVRequest() {
	}

	@Override
	public String toString() {
		return "CargoRecepcionVirtualRequest [Fk_eDocumento=" + Fk_eDocumento + ", cExpediente=" + cExpediente + ", fFecha=" + fFecha
			+ ", Fk_eUsuario=" + Fk_eUsuario + ", EstadoDoc=" + EstadoDoc + ", fFechaRecep=" + fFechaRecep
			+ ", fFechaRecha=" + fFechaRecha + "]";
	}
}
