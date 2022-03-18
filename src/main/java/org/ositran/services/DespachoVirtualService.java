package org.ositran.services;

import com.btg.ositran.siged.domain.IotdtcDespacho;

public interface DespachoVirtualService {
     public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho);
}
