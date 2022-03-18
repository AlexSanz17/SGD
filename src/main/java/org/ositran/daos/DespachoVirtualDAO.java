package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcDespacho;

public interface DespachoVirtualDAO {
     public String findByCantidadesDocumentosVirtuales();
     public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho);
     public IotdtcDespacho findByVcuo(String vcuo) ;
}
