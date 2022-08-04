package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.btg.ositran.siged.domain.Usuario;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.ositran.dojo.BandejaRecepcionMPVObservados;

public interface DocumentoExternoVirtualDAO {
	public List<IotdtmDocExterno> findAll() ;
    public List<IotdtmDocExterno> buscarRecepcionVirtual(Usuario objUsuario);
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesCargo();
    public List<IotdtmDocExterno> buscarDespachoVirtual(Usuario objUsuario);
    public IotdtmDocExterno buscarDocumentoVirtual(Integer idDocumento);
    public IotdtmDocExterno buscarDocumentoVirtualBySidemext(Integer sidemiext);
    public IotdtmDocExterno registrarDocumento(IotdtmDocExterno docExterno);
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesMigrarCargo();
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesAtencion();
    public List<IotdtmDocExterno> buscarDocumentoProcesadoDespachoVirtual(String numero);
    public List<IotdtmDocExterno> buscarDocumentosRecepcionPendientesSubsanacion();
    public List<IotdtmDocExterno> buscarDocumentosDespachoPendientesSubsanacion();
    public List<IotdtmDocExterno> buscarDocumentoDespachoVirtual(String numero);
    public List<String> buscarTramiteVirtual(String nroTramite);
    public List<IotdtcRecepcionMPV> buscarRecepcionMPV();
    public IotdtcRecepcionMPV buscarDocumentoVirtualMPV(Integer nroVirtual);
	public List<IotdtcRecepcionMPV> buscarObservadosMPV();
	public IotdtdDocPrincipal buscarDocumentoPrincipalBySiddocext(Integer siddocext);     
	public IotdtdAnexo buscarDocumentoAnexoBySiddocext(Integer siddocext);
	public List<IotdtmDocExterno> findSiddocextToMigrate(Integer sidreccext) ;
	public List<IotdtcDespacho> findVcuoRefObs(Integer iddocumento) ;
	  public List<BandejaRecepcionMPVObservados> buscarRechazadosMPV();
	  public List<BandejaRecepcionMPVObservados> buscarRechazadosMPVDetalle(Integer sidrecext);
}