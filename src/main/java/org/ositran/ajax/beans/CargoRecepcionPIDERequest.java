package org.ositran.ajax.beans;

public class CargoRecepcionPIDERequest {
	public String vrucentrem;
	public String vrucentrec;
	public String vcuo;
	public String vcuoref;
	public String vnumregstd;
	public String vanioregstd;
	public String dfecregstd;
	public String vuniorgstd;
	public String vusuregstd;
	public String bcarstd;
	public String vobs;
	public String cflgest;
	public String vdesanxstdrec;
	
	public CargoRecepcionPIDERequest() {
	}
	
	public String getVrucentrem() {
		return vrucentrem;
	}

	public void setVrucentrem(String vrucentrem) {
		this.vrucentrem = vrucentrem;
	}

	public String getVrucentrec() {
		return vrucentrec;
	}

	public void setVrucentrec(String vrucentrec) {
		this.vrucentrec = vrucentrec;
	}

	public String getVcuo() {
		return vcuo;
	}

	public void setVcuo(String vcuo) {
		this.vcuo = vcuo;
	}

	public String getVcuoref() {
		return vcuoref;
	}

	public void setVcuoref(String vcuoref) {
		this.vcuoref = vcuoref;
	}

	public String getVnumregstd() {
		return vnumregstd;
	}

	public void setVnumregstd(String vnumregstd) {
		this.vnumregstd = vnumregstd;
	}

	public String getVanioregstd() {
		return vanioregstd;
	}

	public void setVanioregstd(String vanioregstd) {
		this.vanioregstd = vanioregstd;
	}

	public String getDfecregstd() {
		return dfecregstd;
	}

	public void setDfecregstd(String dfecregstd) {
		this.dfecregstd = dfecregstd;
	}

	public String getVuniorgstd() {
		return vuniorgstd;
	}

	public void setVuniorgstd(String vuniorgstd) {
		this.vuniorgstd = vuniorgstd;
	}

	public String getVusuregstd() {
		return vusuregstd;
	}

	public void setVusuregstd(String vusuregstd) {
		this.vusuregstd = vusuregstd;
	}

	public String getBcarstd() {
		return bcarstd;
	}

	public void setBcarstd(String bcarstd) {
		this.bcarstd = bcarstd;
	}

	public String getVobs() {
		return vobs;
	}

	public void setVobs(String vobs) {
		this.vobs = vobs;
	}

	public String getCflgest() {
		return cflgest;
	}

	public void setCflgest(String cflgest) {
		this.cflgest = cflgest;
	}

	public String getVdesanxstdrec() {
		return vdesanxstdrec;
	}

	public void setVdesanxstdrec(String vdesanxstdrec) {
		this.vdesanxstdrec = vdesanxstdrec;
	}

	@Override
	public String toString() {
		return "CargoRecepcionPIDERequest [vrucentrem=" + vrucentrem + ", vrucentrec=" + vrucentrec + ", vcuo=" + vcuo
			+ ", vcuoref=" + vcuoref + ", vnumregstd=" + vnumregstd + ", vanioregstd=" + vanioregstd
			+ ", dfecregstd=" + dfecregstd + ", vuniorgstd=" + vuniorgstd + ", vusuregstd=" + vusuregstd
			+ ", bcarstd=" + bcarstd + ", vobs=" + vobs + ", cflgest=" + cflgest + ", vdesanxstdrec="
			+ vdesanxstdrec + "]";
	}
}