package org.ositran.siged.jobs;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ositran.services.ArchivoService;
import org.ositran.services.DocumentoService;
import org.ositran.services.RecepcionVirtualService;
import org.ositran.services.RepositorioService;
import org.ositran.services.UnidadService;
import org.ositran.services.UsuarioService;
import org.ositran.utils.Constantes;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtdAdjuntoMPV;
import com.btg.ositran.siged.domain.Usuario;

import gob.ositran.siged.config.SigedProperties;


public class CompletarAdjuntosMPVSingleton {

	private RecepcionVirtualService recepcionVirtualService;

	private RepositorioService repositorioService;
	
	private DocumentoService documentoService;
	
	private UnidadService unidadService;
	
	private ArchivoService archivoService;
	
	private UsuarioService usuarioService;

	private static Log log = LogFactory.getLog(CompletarAdjuntosMPVSingleton.class);
	
	private static final String TIPO_ADJUNTO_ANEXO = "2";
	
	private static final Character ESTADO_PROCESO_EJECUCION = 'R';
	private static final Character ESTADO_PROCESO_TERMINADO = 'T';
	private static final Character ESTADO_PROCESO_ERROR = 'E';
	private static final String USUARIO_BANDEJA_MESAPARTES = "MESAPARTES";
	
	@Transactional
	public void subirAlfrescoAdjuntosMPV() {

		try {
			Date fecha = new Date();
			Documento doc = null;
			log.info("..............INICIANDO PROCESO SUBIR ALFRESCO ARCHIVOS ANEXOS MPV...............=" + fecha);
			Usuario usuario = usuarioService.findByUsuario(USUARIO_BANDEJA_MESAPARTES);
			String rutaSite = usuario.getUnidad().getRutaSite();
									 			
			if(usuario != null && rutaSite != null){
				String resultadoalfresco = "";	
				List<IotdtcRecepcionMPV> listaMPVPendientes = recepcionVirtualService.consultarDocPendientesAlfrescoMPV();	
				
				for(IotdtcRecepcionMPV recepcionMPV:listaMPVPendientes){
					List<Archivo> archivosSubidos = new ArrayList<Archivo>();
									
					log.info("Procesando Documento MPV (idRecepcion):"+recepcionMPV.getSidrecext());
					
					recepcionMPV.setFlagalfresco(ESTADO_PROCESO_EJECUCION);
					recepcionVirtualService.registrarDocumentoMPV(recepcionMPV);
					
					
					doc = documentoService.findByIdDocumento(recepcionMPV.getIddocumento());
					
					for(IotdtdAdjuntoMPV adjunto:recepcionMPV.getArchivos()){
																
						if(adjunto.getTipoarchivo().equals(TIPO_ADJUNTO_ANEXO)){
							
							try{						
								log.info("Subiendo archivo adjunto (idAdjuntompv):"+adjunto.getIdadjuntompv());	
															
	                            int pos = adjunto.getNombrearchivo().lastIndexOf(".");
	                            String extension = adjunto.getNombrearchivo().substring(pos+1, adjunto.getNombrearchivo().length());
	
	                            String sNuevoNombreAnexo="["+doc.getIdDocumento()+"_"+DateFormatUtils.format(fecha,"yyyyMMddHHmmss")+"_"+"2"+"]"+doc.getID_CODIGO() + "_ANX_" + adjunto.getNombrearchivo();
	                            String rutaDig=SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.DIRECTORIO_TEMPORAL_ALFRESCO);
	                            	                           	
	                            //Bajar documento de MPV y copiar en carpeta temporal	                            
	                            String urlMPV = adjunto.getRutaarchivo()+adjunto.getNombrearchivo();
	                            log.debug("Bajar documento de MPV y copiar en carpeta temporal:"+urlMPV);
	                            
	                            
	                            InputStream inAnexo = new URL(urlMPV).openStream();
	                            Files.copy(inAnexo, Paths.get(rutaDig + "/"+ sNuevoNombreAnexo), StandardCopyOption.REPLACE_EXISTING);
	                            log.debug("Copiando a ruta temporal:"+rutaDig + "/"+ sNuevoNombreAnexo);
	                            
	                            
	                            File f=new File(rutaDig,sNuevoNombreAnexo);
	                            log.debug("Generando archivo para subir a alfresco:"+sNuevoNombreAnexo);
	                            Archivo objArchivo = new Archivo();
	                            objArchivo.setDocumento(doc);
	                            objArchivo.setNombre(sNuevoNombreAnexo);
	                            objArchivo.setPrincipal('N');
	                            objArchivo.setEstadoDigitalizacion(Constantes.ARCHIVO_ESTADO_DIGITALIZACION_YES);
	                            objArchivo.setFechaCreacion(new Date());
	                            objArchivo.setRutaArchivoPdf(rutaDig + "/"+ sNuevoNombreAnexo);
	                            String rutaAlfresco = repositorioService.obtenerRutaDocumento(doc, rutaSite, doc.getTipoDocumento().getCodigo())+ doc.getID_CODIGO() + "_" + doc.getTipoDocumento().getNombre() + "." + extension;
	                            log.info("rutaAlfresco:"+rutaAlfresco);
	                            objArchivo.setRutaAlfresco(rutaAlfresco);
	                            objArchivo.setAutor(new Usuario(usuario.getIdusuario()));
	                            objArchivo.setUnidadAutor(usuario.getUnidad().getIdunidad());
	                            objArchivo.setUsuariocreacion(usuario.getIdusuario());
	                            objArchivo.setUsuariomodificacion(usuario.getIdusuario());
	                            objArchivo.setClave(null);
	                            try{
	                                objArchivo.setTamano(Integer.valueOf((int)f.length()));
	                            }catch(Exception e){
	                                e.printStackTrace();
	                                objArchivo.setTamano(null);
	                            }
	                            objArchivo.setEstado(Constantes.ESTADO_ACTIVO);
	                            objArchivo = archivoService.saveArchivo(objArchivo);
	                            
	                            archivosSubidos.add(objArchivo);
								
	                            
								repositorioService.subirArchivosTransformadosARepositorio(doc, archivosSubidos, false, usuario, rutaSite, doc.getTipoDocumento().getCodigo());
								
							}catch(Exception ex){
								ex.printStackTrace();
								
								resultadoalfresco+="Error subiendo archivo adjunto (idAdjuntompv):"+adjunto.getIdadjuntompv();
								log.error("Error subiendo archivo adjunto (idAdjuntompv):"+adjunto.getIdadjuntompv());
							}
							
						}
						
					}
					
					
					
					recepcionMPV.setFlagalfresco(ESTADO_PROCESO_TERMINADO);
					recepcionMPV.setResultadoalfresco(resultadoalfresco.equals("")?"OK":resultadoalfresco);
					recepcionVirtualService.registrarDocumentoMPV(recepcionMPV);								
				}
			
			}else{
				log.error("No existe usuario para bandeja:"+USUARIO_BANDEJA_MESAPARTES);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public RecepcionVirtualService getRecepcionVirtualService() {
		return recepcionVirtualService;
	}

	public void setRecepcionVirtualService(RecepcionVirtualService recepcionVirtualService) {
		this.recepcionVirtualService = recepcionVirtualService;
	}

	public RepositorioService getRepositorioService() {
		return repositorioService;
	}

	public void setRepositorioService(RepositorioService repositorioService) {
		this.repositorioService = repositorioService;
	}

	public DocumentoService getDocumentoService() {
		return documentoService;
	}

	public void setDocumentoService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	public UnidadService getUnidadService() {
		return unidadService;
	}

	public void setUnidadService(UnidadService unidadService) {
		this.unidadService = unidadService;
	}

	public ArchivoService getArchivoService() {
		return archivoService;
	}

	public void setArchivoService(ArchivoService archivoService) {
		this.archivoService = archivoService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
