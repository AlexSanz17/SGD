package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.btg.ositran.siged.domain.Usuario;

import java.util.List;

public interface DocumentoExternoVirtualDAO {
    public List<IotdtmDocExterno> buscarRecepcionVirtual(Usuario objUsuario);
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesCargo();
    public List<IotdtmDocExterno> buscarDespachoVirtual(Usuario objUsuario);
    public IotdtmDocExterno buscarDocumentoVirtual(Integer idDocumento);
    public IotdtmDocExterno registrarDocumento(IotdtmDocExterno docExterno);
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesMigrarCargo();
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesAtencion();
    public List<IotdtmDocExterno> buscarDocumentoProcesadoDespachoVirtual(Integer numero);
    public List<IotdtmDocExterno> buscarDocumentosRecepcionPendientesSubsanacion();
    public List<IotdtmDocExterno> buscarDocumentosDespachoPendientesSubsanacion();
    public List<IotdtmDocExterno> buscarDocumentoDespachoVirtual(Integer numero);
    public List<String> buscarTramiteVirtual(String nroTramite);
    public List<IotdtcRecepcionMPV> buscarRecepcionMPV();
    public IotdtcRecepcionMPV buscarDocumentoVirtualMPV(Integer nroVirtual);
}
