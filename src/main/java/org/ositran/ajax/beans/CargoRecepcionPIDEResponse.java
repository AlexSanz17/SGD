package org.ositran.ajax.beans;

public class CargoRecepcionPIDEResponse {
	String bSuccess;
	String eErrorCode;
	String cMessage;
	String cTraceError;
	String cData;

	public String getbSuccess() {
		return bSuccess;
	}

	public void setbSuccess(String bSuccess) {
		this.bSuccess = bSuccess;
	}

	public String geteErrorCode() {
		return eErrorCode;
	}
	
	public void seteErrorCode(String eErrorCode) {
		this.eErrorCode = eErrorCode;
	}
	
	public String getcMessage() {
		return cMessage;
	}
	
	public void setcMessage(String cMessage) {
		this.cMessage = cMessage;
	}
	
	public String getcTraceError() {
		return cTraceError;
	}
	
	public void setcTraceError(String cTraceError) {
		this.cTraceError = cTraceError;
	}
	
	public String getcData() {
		return cData;
	}
	
	public void setcData(String cData) {
		this.cData = cData;
	}

	public CargoRecepcionPIDEResponse() {
	}

	@Override
	public String toString() {
		return "CargoRecepcionVirtualResponse [bSuccess=" + bSuccess + ", eErrorCode=" + eErrorCode + ", cMessage="
			+ cMessage + ", cTraceError=" + cTraceError + ", cData=" + cData + "]";
	}
}