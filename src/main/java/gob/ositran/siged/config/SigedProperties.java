package gob.ositran.siged.config;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.ositran.utils.PropertyFileUtils;

public class SigedProperties {   
    private static final Logger log = Logger.getLogger(SigedProperties.class);
    private static final Properties properties;
    private static final String SIGED_PROPERTIES = "siged/siged.properties";
    private static final String SIGED_INTERNO_PROPERTIES = "siged_interno.properties";

    public enum SigedPropertyEnum {   
        // propiedades de modificacion externa al WAR
        DIRECTORIO_ENTRANTE("pdfTransformer.folder.in"),
        DIRECTORIO_SALIENTE("pdfTransformer.folder.out"),
        DIRECTORIO_TEMPORAL("folder.tempo"),
        DIRECTORIO_TEMPORAL_ALFRESCO("folder.temporal"),
        INTALIO_HOST("intalio.host"),
        INTALIO_PORT("intalio.port"),
        USUARIO_PROCESO_STOR_TRAM_DOC("intalio.proceso.stor.usuario.tramite.documentario"),
        USUARIO_PROCESO_STOR_SEC_GEN("intalio.proceso.stor.usuario.secretario.general"),
        INTALIO_PROCESO_STOR_TIPOEXP_APELACION("intalio.proceso.stor.tipo.expediente.apelacion"),
        INTALIO_PROCESO_STOR_TIPOEXP_QUEJA("intalio.proceso.stor.tipo.expediente.queja"),
        INTALIO_PROCESO_STOR_TIPOEXP_CAUTELAR("intalio.proceso.stor.tipo.expediente.cautelar"),
        UPLOAD_CARPETA_TEMPO("upload.carpeta.tempo"),
        CARPETA_HISTORIAL("folder.historial"),
        OPENOFFICE_RUTA("openoffice.ruta"),
        SMTP_HOST("smtp.host"),
        SIGED_HOST("siged.host"),
        SIGED_CORREO("siged.correo"),
        VARIABLE_SESION_MANTENIMIENTO("sesion.mantenimiento"),
        
        ALFRESCO_HOST("alfresco.host"),
        ALFRESCO_HOST_PUBLICO("alfresco.host.publico"),
        ALFRESCO_PORT("alfresco.port"),
        ALFRESCO_USER("alfresco.user"),
        ALFRESCO_PASSWORD("alfresco.password"),
        ALFRESCO_VALID_DURATION_IN_MINUTES("alfresco.ticket.validDurationInMinutes"),
        ALFRESCO_ROOT("alfresco.root"),
        ALFRESCO_SPACE("alfresco.space"),
   
        //DATOS BD
        BD_URL_SGD("bd.url"),
        BD_USUARIO_SGD("bd.usuario"),
        BD_PASSWORD_SGD("bd.password"),
        
      //DATOS BD_PIDE
        BD_URL_PIDE("bd.pide.url"),
        BD_USUARIO_PIDE("bd.pide.usuario"),
        BD_PASSWORD_PIDE("bd.pide.password"),
        
        FOLDER_MAIL("folder.mail"),
        DIRECTORIO_PLANTILLAS("folder.templates"),
        WEB_SERVICE_SUNAT("webservice.sunat.url"),
        BIRT_LOG_DIR("birt.logDirectory"),
        BIRT_LOG_LEVEL("birt.logLevel"),
        
        // propiedades de modificacion interna al WAR
        ACCION_DERIVAR_ID("accion.derivar.id"),
        ACCION_RECHAZAR_ID("accion.rechazar.id"),
        PENTAHO_URL("pentaho.url"),
        IP_PUBLICA("ip.publica.servidor"),
        DOMINIO_PUBLICO("dominio.publico.servidor"),
        ALFRESCOFIRMA_HOST("alfrescofirma.host"),
        ALFRESCOFIRMA_PORT("alfrescofirma.port"),
        ALFRESCO_ROOTID("alfresco.REPOSITORIO_ID"),
        ALFRESCO_USUARIOEXTERNOQR("alfresco.USUARIOEXTERNOQR"),
        ALFRESCO_USUARIOEXTERNOQR_CLAVE("alfresco.USUARIOEXTERNOQR_CLAVE"),
        ALFRESCO_USUARIOCREADOR("alfresco.USUARIOCREADOR"),
        ALFRESCO_USUARIOCREADOR_CLAVE("alfresco.USUARIOCREADOR_CLAVE"),
        ALFRESCO_USUARIOEXTERNO("alfresco.USUARIOEXTERNO"),
        ALFRESCO_USUARIOEXTERNO_CLAVE("alfresco.USUARIOEXTERNO_CLAVE"),
        ALFRESCO_PROTOCOLO("alfresco.protocolo"),
        ALFRESCO_GESTOR("alfresco.gestor"),
        ALFRESCO_USUARIOADMIN("alfresco.USUARIOADMIN"),
        ALFRESCO_USUARIOADMIN_CLAVE("alfresco.USUARIOADMIN_CLAVE"),
        ALFRESCO_CMIS("alfresco.cmis"),
        
        
        
//        DIRECTORIO ACTIVO
        DIRECTORIO_ACTIVO_URL("directorio_activo.url"),
        DIRECTORIO_ACTIVO_DOMINIO("directorio_activo.dominio"),
        
//        CASILLA VIRTUAL
        CASILLA_ELECTRONICA_BUSCAR_CASILLA("casilla_electronica.buscar_casilla"),
        CASILLA_ELECTRONICA_GENERAR_NOTIFICACION("casilla_electronica.generar_notificacion"),
        CASILLA_GENERAR_CEDULA("casilla_electronica.generar_cedula"),
        CASILLA_ENVIAR_NOTIFIACION_ELECTRONICA("casilla_electronica.enviar_notificacion"),
        
        //SERVICIO MESA DE PARTES VIRTUAL
        SERVICIO_RECEPCION_MPV("servcio_recepcion_mpv.url"),
        
        //CONFIGURACION PROXY
        PROXY_ACTIVE("proxy.active"),
        PROXY_HOST("proxy.host"),
        PROXY_PORT("proxy.port"),

        //TAMAÑO MAXIMO DE DOCUMENTOS PIDE
        TAMANO__MAX_PIDE("pide.max_size"),
        
        
        //URL PARA MOSTRAR ANEXO
        RUTA_ANEXO_PIDE("pide.ruta_anexo"),
        USUARIO_ANEXO_PIDE("pide.usuario_ruta_anexo"),
        PASSWORD_ANEXO_PIDE("pide.password_ruta_anexo"),
        PATH_DIRECTORIO_ANEXO("pide.ruta_anexo_directorio"),
        
        SIGED_INFOPUBLICA("siged.infopublica"),
        SIGED_LIBRORECLAMACION("siged.libroreclamacion"),
        
        ALFRESCO_USUARIOCONSULTA("alfresco.USUARIOCONSULTA"),
        ALFRESCO_USUARIOCONSULTA_CLAVE("alfresco.USUARIOCONSULTA_CLAVE"),
    	
        FIRMAS_RUTA_PORFIRMAR("firmas.RUTAPORFIRMAR"),
        FIRMAS_RUTA_QR("firmas.RUTAQR"),
        FIRMAS_RUTA_FIRMADOS("firmas.RUTAFIRMADOS"),
    	
        FIRMAS_PARAMETROS_RUTAORIGEN("firmas.parametros.rutaOrigen"),
        FIRMAS_PARAMETROS_RUTADESTINO("firmas.parametros.rutaDestino"),
        FIRMAS_PARAMETROS_RUTAIMAGEN("firmas.parametros.rutaImagen"),
        FIRMAS_PARAMETROS_IMAGEN("firmas.parametros.imagen"),
        FIRMAS_PARAMETROS_USARPERSONALIZADO("firmas.parametros.usarPersonalizado"),
        FIRMAS_PARAMETROS_TIPOFIRMA("firmas.parametros.tipoFirma"),
        FIRMAS_PARAMETROS_INVISIBLE("firmas.parametros.invisible"),
        FIRMAS_PARAMETROS_POSICIONFIRMA("firmas.parametros.posicionFirma"),
        FIRMAS_PARAMETROS_UBICACIONPAGINA("firmas.parametros.ubicacionPagina"),
        FIRMAS_PARAMETROS_NUMEROPAGINA("firmas.parametros.numeroPagina"),
        FIRMAS_PARAMETROS_ESTILOFIRMA("firmas.parametros.estiloFirma"),
        FIRMAS_PARAMETROS_APLICARIMAGEN("firmas.parametros.aplicarImagen"),
        FIRMAS_PARAMETROS_CHKTSA("firmas.parametros.chkTSA"),
        FIRMAS_PARAMETROS_RUTASTSA("firmas.parametros.rutasTSA"),

        //CONFIGURACION SERVICIOS PIDE
        URL_PIDE_TRAMITE_DESARROLLO("pide.url_tramite_desarrollo"),
        URL_PIDE_TRAMITE_PRODUCCION("pide.url_tramite_produccion"),
        
        URL_PIDE_ENTIDAD_DESARROLLO("pide.url_entidad_desarrollo"),
        URL_PIDE_ENTIDAD_PRODUCCION("pide.url_entidad_produccion"),
        
        PIDE_ENTORNO_PRODUCCION("pide.entorno_produccion"),

        
        PIDE_FILE_SIZE("pide.file_size"),
        
    	MPV_RUTA_ARCHIVO("mpv.rutaArchivo");
    	
    	
    	
    	
    	
        private String key;

        SigedPropertyEnum(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key;
        }
    }

    static {
        properties = new Properties();
        try {
            properties.putAll(PropertyFileUtils.load(SIGED_INTERNO_PROPERTIES));
        } catch (Exception e) {
            log.error("No se encuentra el archivo '" + SIGED_INTERNO_PROPERTIES + "' en el classpath.", e);
        }
        try {
            properties.putAll(PropertyFileUtils.load(SIGED_PROPERTIES));
        } catch (Exception e) {
            log.error("No se encuentra el archivo '" + SIGED_PROPERTIES + "' en el classpath.", e);
        }
    }

    private SigedProperties() {
    }

    public static String getProperty(SigedPropertyEnum sigedProperty) {
        return properties.getProperty(sigedProperty.getKey());
    }

    public static int getIntProperty(SigedPropertyEnum sigedProperty) {
        return Integer.valueOf( properties.getProperty(sigedProperty.getKey()) ).intValue();
    }

    public static long getLongProperty(SigedPropertyEnum sigedProperty) {
        return Long.valueOf(properties.getProperty(sigedProperty.getKey())).longValue();
    }

    public static String getPropertyByKey(String key) {
        return properties.getProperty(key);
    }
}