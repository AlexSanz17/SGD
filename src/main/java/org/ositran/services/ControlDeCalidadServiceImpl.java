/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.stream.XMLStreamException;
import org.ositran.daos.AccionDAO;
import org.ositran.daos.DocumentoDAO;
import org.ositran.daos.DocumentostorDAO;
import org.ositran.daos.ProcesoDAO;
import org.ositran.daos.SubmotivoDAO;
import org.ositran.daos.SuministroDAO;
import org.ositran.daos.TipodocumentoDAO;
import org.ositran.utils.Constantes;
import org.ositran.utils.DocumentoDetail;
import org.ositran.webservice.clientes.intalio.InvalidInputMessageFaultException;
import org.ositran.webservice.clientes.intalio.InvalidParticipantTokenFaultException;
import org.ositran.webservice.clientes.intalio.UnavailableTaskFaultException;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Accion;
import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.Cliente;
import com.btg.ositran.siged.domain.Concesionario;
import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.DocumentoStor;
import com.btg.ositran.siged.domain.Expediente;
import com.btg.ositran.siged.domain.Proceso;
import com.btg.ositran.siged.domain.Submotivo;
import com.btg.ositran.siged.domain.Suministro;
import com.btg.ositran.siged.domain.Tipodocumento;
import com.btg.ositran.siged.domain.Trazabilidadcopia;
import com.btg.ositran.siged.domain.Trazabilidaddocumento;
import com.btg.ositran.siged.domain.Usuario;

public class ControlDeCalidadServiceImpl implements ControlDeCalidadService {

    private static Logger log = LoggerFactory.getLogger(ControlDeCalidadServiceImpl.class);
    private AccionDAO accionDAO;
    private ArchivoService archivoService;
    private DocumentoDAO documentoDao;
    private DocumentostorDAO documentoStorDao;
    private ProcesoDAO procesoDao;
    private SubmotivoDAO submotivoDao;
    private SuministroDAO suministroDao;
    private TipodocumentoDAO tipoDocumentoDao;
    private ClienteService clienteService;
    private ConcesionarioService concesionarioService;
    private ExpedienteService expedienteService;
    private IntalioService intalioService;
    private NotificacionService notificacionService;
    private RepositorioService repositorioService;
    private TrazabilidaddocumentoService trazabilidadDocumentoService;
    private TrazabilidadexpedienteService trazabilidadExpedienteService;
    private TrazabilidadcopiaService trazabilidadCopiaService;

    /**
     * Aprueba un documento desde QAS, actualiza los datos que puedan haber sido modificados segun
     * estas reglas:<br>
     * <ol>
     * <li>No se puede modificar el expediente</li>
     * <li>El proceso puede ser modificado solo si el documento es el que da origen al expediente</li>
     * <li>Actualiza la informacion del cliente tanto en el mismo cliente como en el expediente</li>
     * <li>El asunto del expediente solo puede ser modificado si el documento es el que da origen al expediente</li>
     * <li>Una vez que se ha modificado el documento y su expediente, se suben los archivos a Alfresco</li>
     * </ol>
     *
     * @param documentoDetail valores ingresados en el formulario
     * @param calidad el usuario de control de calidad
     *
     * @author German Enriquez
     * @throws UnavailableTaskFaultException
     * @throws InvalidParticipantTokenFaultException
     * @throws InvalidInputMessageFaultException
     * @throws RemoteException
     * @throws XMLStreamException
     */
    @Transactional
    @Override
    public boolean aprobarDocumento(DocumentoDetail documentoDetail, Usuario calidad, Map<String, Object> sesion) throws RemoteException, InvalidInputMessageFaultException, InvalidParticipantTokenFaultException, UnavailableTaskFaultException, XMLStreamException {
        Documento documento = documentoDao.findByIdDocumento(documentoDetail.getIIdDocumento());
        String nombrePC = (String)sesion.get("nombrePC");
        if (documento != null) {
            Expediente expediente = documento.getExpediente();
            if (expediente != null) {
                // QAS no puede modificar el expediente
                if (expediente.getIdexpediente().intValue() != documentoDetail.getIIdExpediente().intValue()) {
                    log.error("No esta permitido que el usuario de Control de Calidad modifique el expediente de un documento.");
                    return false;
                }
                Proceso proceso = null;//expediente.getProceso();
                if (proceso != null) {
                    Integer idProceso = documentoDetail.getIIdProceso();
                    if (idProceso != null && idProceso > 0) {
                        // Verificamos si el el proceso ha cambiado
                        if (proceso.getIdproceso().intValue() != idProceso.intValue()) {
                            // Solo si el documento es de un expediente nuevo se puede cambiar el proceso
                            proceso = procesoDao.findByIdProceso(idProceso);
                            if (documento.isCreadorExpediente()) {
                                //expediente.setProceso(proceso);
                                expediente.setIdpropietario(proceso.getResponsable());
                            } else {
                                log.warn("Se intento modificar el proceso para un documento referenciado. La operacion no sera tomada en cuenta.");
                            }
                        }
                    } else {
                        log.error("No se selecciono ningun proceso.");
                        return false;
                    }
                    // guardamos la data del documento que no representa una carga en procesamiento
                    documento.setNumeroDocumento(documentoDetail.getStrNroDocumento());
                    documento.setNumeroFolios(documentoDetail.getINroFolios());
                    documento.setAsunto(documentoDetail.getStrAsunto());
                    documento.setUltimoAsunto(documentoDetail.getStrAsunto());
                    documento.setRemitente(calidad.getNombres() + " " + calidad.getApellidos());
                    documento.setFechaDocumento(documentoDetail.getStrFecha());
                    documento.setNumeroCaja(documentoDetail.getStrNroCaja());
                    documento.setEnumerarDocumento(true);
                    // Cambiamos el tipo de documento si es que ha sido modificado
                    Integer tipoDocumento = documentoDetail.getIIdTipoDocumento();
                    if (tipoDocumento != null && tipoDocumento > 0) {
                        // Solo si el tipo de documento ha cambiado, buscaremos el nuevo tipo de documetno
                        if (!documento.getTipoDocumento().getIdtipodocumento().equals(tipoDocumento)) {
                            Tipodocumento tipo = tipoDocumentoDao.findByIdTipoDocumento(tipoDocumento);
                            if (tipo != null) {
                                documento.setTipoDocumento(tipo);
                            }
                        }
                    } else {
                        log.error("No se especifico ningun tipo de documento, no se puede aprobar el documento.");
                        return false;
                    }
                    // Actualizamos la data del cliente
                    Cliente cliente = clienteService.updateInfoCliente(documentoDetail);
                    if (cliente != null) {
                        // Actualizamos la informacion del cliente en el expediente si todo salio bien
                        expediente.setCliente(cliente);
                        if (cliente.getTipoIdentificacion().getNombre().equals("DNI")) {
                            expediente.setClientenombres(documentoDetail.getClientenombres());
                            expediente.setClienteapellidopaterno(documentoDetail.getClienteapellidopaterno());
                            expediente.setClienteapellidomaterno(documentoDetail.getClienteapellidomaterno());
                            expediente.setClienterazonsocial(null);
                        } else if (cliente.getTipoIdentificacion().getNombre().equals("RUC")){
                            expediente.setClientenombres(null);
                            expediente.setClienteapellidopaterno(null);
                            expediente.setClienteapellidomaterno(null);
                            expediente.setClienterazonsocial(documentoDetail.getClienterazonsocial());
                        } else {
                            expediente.setClientenombres(documentoDetail.getClientenombres());
                            expediente.setClienteapellidopaterno(documentoDetail.getClienteapellidopaterno());
                            expediente.setClienteapellidomaterno(documentoDetail.getClienteapellidomaterno());
                            expediente.setClienterazonsocial(null);
                        }

                        expediente.setClienterepresentantelegal(documentoDetail.getClienterepresentantelegal());
                        expediente.setClientedireccionprincipal(documentoDetail.getClientedireccionprincipal());
//						if(cliente.getUbigeoPrincipal()!=null){
                        expediente.setClienteubigeoprincipal(documentoDetail.getClienteubigeoprincipal());
//						}
                        expediente.setClientedireccionalternativa(documentoDetail.getClientedireccionalternativa());
//                        if (cliente.getUbigeoAlternativo() != null) {
                        expediente.setClienteubigeoalternativo(documentoDetail.getClienteubigeoalternativo());
//                        }
                        expediente.setClientetelefono(documentoDetail.getClientetelefono());
                        expediente.setClientecorreo(documentoDetail.getClientecorreo());
                    }
                    // Continuamos modificando la data del expediente
                    if (documento.isCreadorExpediente()) {
                        // Solo si es el primer documento del expediente se puede cambiar el asunto del expediente
                        expediente.setAsunto(documento.getAsunto());
                    }
                    expediente.setSumilla(documentoDetail.getsSumilla());
                    expediente.setEstaenflujo(Constantes.ESTAENFLUJO_S);
                    expediente.setHistorico(documentoDetail.getHistorico());
                    // Le ponemos un concesionario si es que ha sido seleccionado alguno
                    Integer idConcesionario = documentoDetail.getIIdCorrentista();
                    if (idConcesionario != null && idConcesionario > 0) {
                        // Solo si es que ha sido modificado
                        if (expediente.getConcesionario().getIdConcesionario() != idConcesionario) {
                            Concesionario concesionario = concesionarioService.findByIdConcesionario(idConcesionario);
                            if (concesionario != null) {
                                expediente.setConcesionario(concesionario);
                            }
                        }
                    }
                    // Aplicamos la numeracion al expediente
                    expedienteService.aplicarNumeracionInternaExpediente(expediente.getIdexpediente());
                    // Ubicamos al propietario del documento y posiblemente del expediente
                    Usuario propietario = proceso.getResponsable();
                    if (documento.isCreadorExpediente() && propietario != null) {
                        // Solo si se trata del documento que crea el expediente se puede setear el responsable del expediente
                        //expediente.setIdpropietario(propietario);
                    }
                    // Finalmente guardamos el expediente
                    expediente = expedienteService.saveExpediente(expediente);
                    if (expediente != null) {
                        // Si todo salio bien, le asignamos el expediente al documento
                        documento.setExpediente(expediente);
                        // Derivamos el documento (y tambien el expediente)
                        //documento.setPropietario(propietario);
                        if (documento.isCreadorExpediente()) {
                            documento.setPropietario(expediente.getIdpropietario());
                        } else {
                            documento.setPropietario(documentoDao.findDocumentoPrincipal(expediente.getIdexpediente()).getPropietario());
                        }

                        // Guardamos el documento
                        Accion accion = accionDAO.findByNombre(Constantes.ACCION_APROBAR_QAS);
                        documento.setAccion(accion);
                        documento.setEstaEnFlujo(Constantes.ESTAENFLUJO_S);
                        documento = documentoDao.saveDocumento(documento);
                        if (documento != null) {
                            // Si todo salio bien, guardamos la trazabilidad para el documento y para el expediente
                            Trazabilidaddocumento trazabilidadDocumento = trazabilidadDocumentoService.guardarTrazabilidad(documento, calidad, null, Constantes.ACCION_APROBAR_QAS, documento.getAsunto(), documento.getContenido(), nombrePC);
                            trazabilidadExpedienteService.guardarTrazabilidad(expediente, calidad, expediente.getIdpropietario(), Constantes.ACCION_APROBAR_QAS, "Aprobacion de expediente en QAS.");
                            List<Trazabilidadcopia> lstTrazabilidadCopia = trazabilidadCopiaService.findLstByIdDocumento(documento.getIdDocumento());

                            if (lstTrazabilidadCopia != null && lstTrazabilidadCopia.size() > 0) {
                               for (Trazabilidadcopia trazabilidadCopia : lstTrazabilidadCopia) {
                                  log.debug("Actualizando la trazabilidadCopia {}, remitente actual {}, nuevo remitente {}", new Object[]{trazabilidadCopia.getIdtrazabilidadcopia(), trazabilidadCopia.getRemitente().getIdusuario(), calidad.getIdusuario()});
                                  trazabilidadCopia.setRemitente(calidad);
                                  trazabilidadCopia.setIdorigen(trazabilidadDocumento);
                                  trazabilidadCopiaService.saveObject(trazabilidadCopia);
                               }
                            }

                            // Una vez que todo haya culminado con exito, subimos los archivos a alfresco
                            List<Archivo> archivos = documento.getArchivos();
                           if (archivos != null) {
                              for (Archivo archivo : archivos) {
                                 if (archivo.getEstadoDigitalizacion() == Constantes.ESTADO_RECHAZADO) {
                                    archivoService.updateEstadoByArchivo(archivo.getIdArchivo(), Constantes.ARCHIVO_ESTADO_DIGITALIZACION_YES);
                                 }
                              }
                           }
                            int subidos = 0;//repositorioService.subirArchivosTransformadosARepositorio(documento.getIdDocumento(), true);
                            if (archivos.size() > 0 && subidos == 0) {
                                throw new RuntimeException("No se subio ningun archivo a alfresco a pesar de que habian archivos por subir.");
                            }
                            String nombreProceso = proceso.getTipoproceso().getNombre();
                            // Si el proceso es de tipo "Intalio", entonces iniciamos el proceso en Intalio
                            if (nombreProceso.equals(Constantes.TIPO_PROCESO_INTALIO)) {
                                if (!intalioService.iniciarProceso(calidad, propietario, proceso.getNombreIntalio(), expediente.getIdexpediente())) {
                                    throw new RuntimeException("No se pudo iniciar el proceso en Intalio");
                                }
                                log.info("Se inicio satisfactoriamente el proceso " + proceso.getNombreIntalio() + " en Intalio");
                            } else if (nombreProceso.equals(Constantes.TIPO_PROCESO_STOR)) {
                                // Guardamos los datos para un documento Stor
                                Integer[] idSuministros = documentoDetail.getIdSuministros();
                                Integer[] idSubmotivos = documentoDetail.getIdSubmotivos();
                                String textoMonto = documentoDetail.getStrMontoReclamo();
                                if ((idSuministros != null && idSuministros.length > 0) || (idSubmotivos != null && idSubmotivos.length > 0) || textoMonto != null) {
                                    DocumentoStor documentoStor = documento.getDocumentoStor();
                                    if (documentoStor != null) {
                                        List<Suministro> suministros = new ArrayList<Suministro>();
                                        for (Integer idSuministro : idSuministros) {
                                            Suministro suministro = suministroDao.getSuministro(idSuministro);
                                            if (suministro != null) {
                                                suministros.add(suministro);
                                            }
                                        }
                                        //TODO crear los nuevos suministros que se ingresen (si es que QAS puede ingresar nuevos suministros)
                                        documentoStor.setSuministros(suministros);
                                        List<Submotivo> submotivos = new ArrayList<Submotivo>();
                                        for (Integer idSubmotivo : idSubmotivos) {
                                            Submotivo submotivo = submotivoDao.findByIdSubmotivo(idSubmotivo);
                                            if (submotivo != null) {
                                                submotivos.add(submotivo);
                                            }
                                        }
                                        documentoStor.setSubmotivos(submotivos);
                                        double monto = 0D;
                                        if (!textoMonto.equals("")) {
                                            try {
                                                monto = Double.parseDouble(textoMonto);
                                            } catch (NumberFormatException e) {
                                            }
                                        }
                                        documentoStor.setMonto(monto);
                                        documentoStorDao.saveDocumentoStor(documentoStor);
                                    } else {
                                        log.warn("Se intento ingresar datos de un documento Stor a un documento que no es Stor.");
                                    }
                                }
                            }
                            log.info("El documento " + documento.getNumeroDocumento() + " fue aprobado satisfactoriamente por el usuario " + calidad.getUsuario() + " y fue enviado al usuario " + propietario.getUsuario());
                            /*Si el documento es principal el documento creo el documento*/
//                            if (documento.getPrincipal() == Constantes.DOCUMENTO_PRINCIPAL) {
//                                notificacionService.informarViaNotifAndMail(calidad, documento, Constantes.CONFIGNOTIFMAIL_CREACION_EXPEDIENTE, Constantes.TIPO_NOTIFICACION_APROBACION_QAS);
//                            }/*Si el documento no es principal el documento ha sido referenciado a otro expediente*/ else if (documento.getPrincipal() == Constantes.DOCUMENTO_NO_PRINCIPAL) {
//                                notificacionService.informarViaNotifAndMail(calidad, documento, Constantes.CONFIGNOTIFMAIL_INGRESO_DOCUMENTO_QAS, Constantes.TIPO_NOTIFICACION_APROBACION_QAS);
//                            }

                            Set informed = null;//notificacionService.informarViaNotifAndMail(calidad, documento, Constantes.CONFIGNOTIFMAIL_CREACION_EXPEDIENTE, Constantes.TIPO_NOTIFICACION_APROBACION_QAS, nombrePC);
                            documentoDao.sendNotificacionXEnumerar(documento, calidad, informed);
                            return true;
                        }
                    }
                    return false;
                }
                log.error("No se selecciono ningun proceso, no se puede aprobar el documento");
                return false;
            }
            log.error("El documento no pertenece a un expediente.");
            return false;
        }
        log.error("No se ha seleccionado ningun documento, no se puede aprobar");
        return false;
    }

    @Override
    public boolean rechazarDocumento() {
        // TODO hacer este metodo
        return false;
    }

    public void setDocumentoDao(DocumentoDAO documentoDao) {
        this.documentoDao = documentoDao;
    }

    public void setDocumentoStorDao(DocumentostorDAO documentoStorDao) {
        this.documentoStorDao = documentoStorDao;
    }

    public void setProcesoDao(ProcesoDAO procesoDao) {
        this.procesoDao = procesoDao;
    }

    public void setSubmotivoDao(SubmotivoDAO submotivoDao) {
        this.submotivoDao = submotivoDao;
    }

    public void setSuministroDao(SuministroDAO suministroDao) {
        this.suministroDao = suministroDao;
    }

    public void setTipoDocumentoDao(TipodocumentoDAO tipoDocumentoDao) {
        this.tipoDocumentoDao = tipoDocumentoDao;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void setConcesionarioService(ConcesionarioService concesionarioService) {
        this.concesionarioService = concesionarioService;
    }

    public void setExpedienteService(ExpedienteService expedienteService) {
        this.expedienteService = expedienteService;
    }

    public void setIntalioService(IntalioService intalioService) {
        this.intalioService = intalioService;
    }

    public void setRepositorioService(RepositorioService repositorioService) {
        this.repositorioService = repositorioService;
    }

    public void setTrazabilidadDocumentoService(TrazabilidaddocumentoService trazabilidadDocumentoService) {
        this.trazabilidadDocumentoService = trazabilidadDocumentoService;
    }

    public void setTrazabilidadExpedienteService(TrazabilidadexpedienteService trazabilidadExpedienteService) {
        this.trazabilidadExpedienteService = trazabilidadExpedienteService;
    }

   public void setTrazabilidadCopiaService(TrazabilidadcopiaService trazabilidadCopiaService) {
      this.trazabilidadCopiaService = trazabilidadCopiaService;
   }

    public NotificacionService getNotificacionService() {
        return notificacionService;
    }

    public void setNotificacionService(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    public AccionDAO getAccionDAO() {
        return accionDAO;
    }

    public void setAccionDAO(AccionDAO accionDAO) {
        this.accionDAO = accionDAO;
    }

   public void setArchivoService(ArchivoService archivoService) {
      this.archivoService = archivoService;
   }
}
