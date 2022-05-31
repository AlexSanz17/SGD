package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcDespacho;

public interface DespachoVirtualService {
     public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho);
     public List<IotdtcDespacho> getAll();
}
