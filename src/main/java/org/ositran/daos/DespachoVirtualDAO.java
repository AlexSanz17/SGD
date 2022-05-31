package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcDespacho;

public interface DespachoVirtualDAO {
     public String findByCantidadesDocumentosVirtuales();
     public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho);
     public IotdtcDespacho findByVcuo(String vcuo) ;
 	public List<IotdtcDespacho> findAll();
}
