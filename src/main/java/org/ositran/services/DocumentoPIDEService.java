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
	List<IotdtcDespachoPIDE> getAllDespacho();
	List<IotdtmDocExternoPIDE> getAllDocExterno();
	List<IotdtdDocPrincipalPIDE> getAllDocPrincipal();
	List<IotdtdAnexoPIDE> getAllAnexo();
}
