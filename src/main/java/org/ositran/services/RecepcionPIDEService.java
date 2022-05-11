package org.ositran.services;

import org.ositran.ajax.beans.CargoRecepcionPIDERequest;
import org.ositran.ajax.beans.CargoRecepcionPIDEResponse;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

public interface RecepcionPIDEService {
	public IotdtcRecepcion findBySidrecext(Integer sidrecext);
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion);
    public IotdtmDocExterno registrarDocExterno(IotdtmDocExterno docExterno);
    public IotdtdDocPrincipal registrarDocPrincipal(IotdtdDocPrincipal docPrincipal);
    public IotdtdAnexo registrarAnexo(IotdtdAnexo docAnexo);
	public CargoRecepcionPIDEResponse enviarCargo(CargoRecepcionPIDERequest cargoRecepcionPIDERequest);
}