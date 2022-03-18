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
	List<IotdtcDespachoPIDE> findAllDespacho();
	List<IotdtmDocExternoPIDE> findAllDocExterno();
	List<IotdtdDocPrincipalPIDE> findAllDocPrincipal();
	List<IotdtdAnexoPIDE> findAllAnexo();
}
