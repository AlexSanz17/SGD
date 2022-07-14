package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtcDespacho;

public interface DespachoVirtualDAO {
     public String findByCantidadesDocumentosVirtuales();
     public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho);
     public IotdtcDespacho findByVcuo(String vcuo) ;
     public List<IotdtcDespacho> findAll();
    IotdtcDespacho actualizarDespacho(IotdtcDespacho despacho);
    public IotdtcDespacho findByIdDocumento(Integer iddocumento);
    public List<IotdtcDespacho> findVcuoRefObs(Integer iddocumento) ;
}
