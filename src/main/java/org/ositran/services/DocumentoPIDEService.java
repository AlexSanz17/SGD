/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

public interface DocumentoPIDEService {
	List<IotdtcRecepcionPIDE> getAllRecepcion();
	IotdtcRecepcionPIDE getRecepcionByVcuo(String vcuo);
	IotdtcRecepcionPIDE updateIotdtcRecepcionPIDE(IotdtcRecepcionPIDE objIotdtcRecepcionPIDE) ;
	List<IotdtcDespachoPIDE> getAllDespacho();
	IotdtcDespachoPIDE getDespachoByVcuo(String vcuo);
	List<IotdtcDespachoPIDE> getDespachoByVcuo1(String vcuo);
	IotdtcDespachoPIDE updateIotdtcDespachoPIDE(IotdtcDespachoPIDE iotdtcDespachoPIDE);
	List<IotdtmDocExternoPIDE> getAllDocExterno();
	IotdtmDocExternoPIDE getDocExternoByCuo(String vcuo);
	IotdtmDocExternoPIDE updateIotdtmDocExternoPIDE(IotdtmDocExternoPIDE objIotdtmDocExternoPIDE);
	List<IotdtdDocPrincipalPIDE> getAllDocPrincipal();
	IotdtdDocPrincipalPIDE getDocPrincipalByCuo(String vcuo);
	IotdtdDocPrincipalPIDE updateIotdtdDocPrincipalPIDE(IotdtdDocPrincipalPIDE objIotdtdDocPrincipalPIDE);
	List<IotdtdAnexoPIDE> getAllAnexo();
	IotdtdAnexoPIDE getAnexoByCuo(String vcuo);
	IotdtdAnexoPIDE updateIotdtdAnexoPIDE(IotdtdAnexoPIDE objIotdtdAnexoPIDE);

	
	
		
}
