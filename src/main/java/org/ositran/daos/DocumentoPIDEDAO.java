/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*LICENCIA DE USO DEL SGD .TXT*/
package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

public interface DocumentoPIDEDAO {
	List<IotdtcRecepcionPIDE> findAllRecepcion();
	IotdtcRecepcionPIDE findRecepcionByVcuo(String vcuo);
	IotdtcRecepcionPIDE updateIotdtcRecepcionPIDE(IotdtcRecepcionPIDE objIotdtcRecepcionPIDE);
	List<IotdtcDespachoPIDE> findAllDespacho();
	IotdtcDespachoPIDE getDespachoByVcuo(String vcuo);
	IotdtcDespachoPIDE updateIotdtcDespachoPIDE(IotdtcDespachoPIDE objIotdtcDespachoPIDE);
	List<IotdtmDocExternoPIDE> findAllDocExterno();
	IotdtmDocExternoPIDE getDocExternoByCuo(String vcuo);
	IotdtmDocExternoPIDE getDocExternoBySidemext(Integer sidemiext) ;
	IotdtmDocExternoPIDE updateIotdtmDocExternoPIDE(IotdtmDocExternoPIDE objIotdtmDocExternoPIDE);
	List<IotdtdDocPrincipalPIDE> findAllDocPrincipal();
	IotdtdDocPrincipalPIDE getDocPrincipalByCuo(String vcuo);
	IotdtdDocPrincipalPIDE updateIotdtdDocPrincipalPIDE(IotdtdDocPrincipalPIDE objIotdtdDocPrincipalPIDE);
	List<IotdtdAnexoPIDE> findAllAnexo();
	IotdtdAnexoPIDE getAnexoByCuo(String vcuo);
	IotdtdAnexoPIDE updateIotdtdAnexoPIDE(IotdtdAnexoPIDE objIotdtdAnexoPIDE);
}
