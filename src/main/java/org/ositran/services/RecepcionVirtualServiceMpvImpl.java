/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ositran.services;

import com.btg.ositran.siged.domain.IotdtcRecepcionSchemaIdsgd;

import java.util.List;
import org.ositran.daos.RecepcionVirtualMpvDAO;

public class RecepcionVirtualServiceMpvImpl implements RecepcionVirtualServiceMpv{
	
	RecepcionVirtualMpvDAO recepcionVirtualMpvDAO;

	public RecepcionVirtualMpvDAO getRecepcionVirtualMpvDAO() {
		return recepcionVirtualMpvDAO;
	}

	public void setRecepcionVirtualMpvDAO(RecepcionVirtualMpvDAO recepcionVirtualMpvDAO) {
		this.recepcionVirtualMpvDAO = recepcionVirtualMpvDAO;
	}

	public List<IotdtcRecepcionSchemaIdsgd> getAll() {
		return recepcionVirtualMpvDAO.findAll();
	}

}
