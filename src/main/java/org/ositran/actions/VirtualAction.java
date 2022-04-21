package org.ositran.actions;

import com.btg.ositran.siged.domain.Cliente;
import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtdAdjuntoMPV;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.btg.ositran.siged.domain.Tipodocumento;
import com.btg.ositran.siged.domain.Usuario;
import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.ArchivoAdjunto;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import com.ositran.pide.WSPideTramite;
import com.ositran.ws.ConsultaTramite;
import com.ositran.ws.RespuestaConsultaTramite;

import java.util.ArrayList;
import org.ositran.daos.DocumentoExternoVirtualDAO;
import org.ositran.daos.TipodocumentoDAO;
import org.ositran.services.ClienteService;
import org.ositran.utils.DocumentoDetail;
import org.ositran.utils.FileVirtual;

import java.util.List;
import java.util.Map;

import org.ositran.daos.DespachoVirtualDAO;
import org.ositran.daos.DocPrincipalVirtualDAO;
import org.ositran.daos.DocumentoDAO;
import org.ositran.daos.ParametroDAO;
import org.ositran.daos.RecepcionVirtualDAO;
import org.ositran.services.ArchivoService;
import org.ositran.services.DocumentoService;
import org.ositran.utils.Constantes;

public class VirtualAction {
    private DocumentoExternoVirtualDAO documentoExternoVirtualDAO;
    private RecepcionVirtualDAO recepcionVirtualDAO;
    private DespachoVirtualDAO despachoVirtualDAO;
    private DocumentoDetail objDD;
    private ParametroDAO parametroDao;
    private Integer idRecepcion;
    private Integer idDespacho;
    private ClienteService clienteService;
    private TipodocumentoDAO tipoDocumentoDAO;
    private Documento documento;
    private Integer iIdDoc;
    private DocumentoService documentoService;
    private Map<String, Object> mapSession;
    private ArchivoService archivoService;
    private DocumentoDAO documentoDAO;
    private DocPrincipalVirtualDAO docPrincipalVirtualDAO;
    
    public VirtualAction() {
    }
    
    public ParametroDAO getParametroDao() {
        return parametroDao;
    }

    public void setParametroDao(ParametroDAO parametroDao) {
        this.parametroDao = parametroDao;
    }

    public DocPrincipalVirtualDAO getDocPrincipalVirtualDAO() {
        return docPrincipalVirtualDAO;
    }

    public void setDocPrincipalVirtualDAO(DocPrincipalVirtualDAO docPrincipalVirtualDAO) {
        this.docPrincipalVirtualDAO = docPrincipalVirtualDAO;
    }
    
    public Integer getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(Integer idDespacho) {
        this.idDespacho = idDespacho;
    }
    
    public RecepcionVirtualDAO getRecepcionVirtualDAO() {
        return recepcionVirtualDAO;
    }

    public void setRecepcionVirtualDAO(RecepcionVirtualDAO recepcionVirtualDAO) {
        this.recepcionVirtualDAO = recepcionVirtualDAO;
    }

    public DocumentoDAO getDocumentoDAO() {
        return documentoDAO;
    }

    public void setDocumentoDAO(DocumentoDAO documentoDAO) {
        this.documentoDAO = documentoDAO;
    }

    public ArchivoService getArchivoService() {
        return archivoService;
    }

    public void setArchivoService(ArchivoService archivoService) {
        this.archivoService = archivoService;
    }

    public Map<String, Object> getMapSession() {
        return mapSession;
    }

    public void setMapSession(Map<String, Object> mapSession) {
        this.mapSession = mapSession;
    }

    public DocumentoService getDocumentoService() {
        return documentoService;
    }

    public void setDocumentoService(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    public Integer getiIdDoc() {
        return iIdDoc;
    }

    public void setiIdDoc(Integer iIdDoc) {
        this.iIdDoc = iIdDoc;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public DocumentoExternoVirtualDAO getDocumentoExternoVirtualDAO() {
        return documentoExternoVirtualDAO;
    }

    public void setDocumentoExternoVirtualDAO(DocumentoExternoVirtualDAO documentoExternoVirtualDAO) {
        this.documentoExternoVirtualDAO = documentoExternoVirtualDAO;
    }
     
    public TipodocumentoDAO getTipoDocumentoDAO() {
        return tipoDocumentoDAO;
    }

    public void setTipoDocumentoDAO(TipodocumentoDAO tipoDocumentoDAO) {
        this.tipoDocumentoDAO = tipoDocumentoDAO;
    }
   
    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Integer getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(Integer idRecepcion) {
        this.idRecepcion = idRecepcion;
    }
    
    public DespachoVirtualDAO getDespachoVirtualDAO() {
        return despachoVirtualDAO;
    }

    public void setDespachoVirtualDAO(DespachoVirtualDAO despachoVirtualDAO) {
        this.despachoVirtualDAO = despachoVirtualDAO;
    }
    
    public DocumentoDetail getObjDD() {
        return objDD;
    }

    public void setObjDD(DocumentoDetail objDD) {
        this.objDD = objDD;
    }
    
    public String viewDocDespachoVirtual() {
    	try {
	        IotdtmDocExterno despacho = documentoExternoVirtualDAO.buscarDocumentoVirtual(idDespacho);
	        Documento d = documentoDAO.findByIdDocumento(despacho.getSidemiext().getIddocumento());
	        Cliente cliente =clienteService.findObjectBy(despacho.getSidemiext().getVrucentrec(), 'A');
	        Tipodocumento tipoDocumento = tipoDocumentoDAO.findByIdTipoDocumentoPIDE(despacho.getCcodtipdoc());
	        mapSession = ActionContext.getContext().getSession();
	        Usuario usuario = (Usuario) mapSession.get(Constantes.SESSION_USUARIO);
	        objDD = new DocumentoDetail();
	        objDD.setStrAsunto(despacho.getVasu());
	        objDD.setArchivoCargo("");
	        
	        if (despacho.getSidemiext().getBcarstdrec()!=null){
	            objDD.setArchivoCargo(d.getID_CODIGO() + "_CARGO_VIRTUAL_" + d.getTipoDocumento().getNombre() + ".pdf");  
	        }
	        
	        objDD.setStrRazonSocial(cliente==null?"":cliente.getRazonSocial());
	        objDD.setStrNroDocumento(tipoDocumento.getNombre() + " - " + despacho.getVnumdoc());
	        objDD.setStrFecha(despacho.getSidemiext().getDfecreg());
	        objDD.setIdCodigo(Integer.valueOf(despacho.getSiddocext().intValue()));
	        objDD.setArchivoPrincipal(docPrincipalVirtualDAO.buscarPrincipaByDocExterno(idDespacho).getVnomdoc());
	        objDD.setArchivoAnexo(despacho.getVurldocanx()==null?"":despacho.getVurldocanx());
	        objDD.setCantAnexos(despacho.getSnumanx() == null ? 0 : despacho.getSnumanx().intValue());
	        objDD.setNroTramite(despacho.getSidemiext().getVnumregstd());
	        objDD.setCEstado(despacho.getSidemiext().getCflgest());
	        objDD.setCuo(despacho.getSidemiext().getVcuo());
	        objDD.setIIdDocumento(despacho.getSidemiext().getIddocumento());
	        objDD.setiIdDocumentoReferencia(d.getDocumentoreferencia());
	        
            List<ArchivoAdjunto> list = new ArrayList<ArchivoAdjunto>();

	        if (despacho.getIotdtdAnexoList() != null && despacho.getIotdtdAnexoList().size() > 0){
	            for (IotdtdAnexo anexo : despacho.getIotdtdAnexoList()){
	            	ArchivoAdjunto archivoAdjunto = new ArchivoAdjunto();
		            archivoAdjunto.setNombreArchivo(anexo.getVnomdoc());
		            archivoAdjunto.setRutaArchivo("");
		            archivoAdjunto.setTamanoArchivo("");
	                list.add(archivoAdjunto);
	            }
	        }
	        
            objDD.setListAnexos(list);

	        if (despacho.getSidemiext().getCflgest() == 'P') {
	           if (despacho.getSidemiext().getCflgenv() == 'E') {
	              try { 
                    WSPideTramite wsPideTramite = new WSPideTramite();
                    ConsultaTramite consultaTramite = new ConsultaTramite();
                    consultaTramite.setVcuo(despacho.getSidemiext().getVcuo());
                    consultaTramite.setVrucentrec(despacho.getSidemiext().getVrucentrec());
                    consultaTramite.setVrucentrem(parametroDao.findByTipoUnico("RUC_OSITRAN").getValor());
                    RespuestaConsultaTramite respuestaConsultaTramite =  wsPideTramite.consultarTramite(consultaTramite, Constantes.AMBIENTE_WS_PIDE_TRAMIE);
                    
                    if (respuestaConsultaTramite.getVcodres().equals("0000")) {
                       objDD.setFlagCodigoVirtual('3');
                    } else {
                      if(respuestaConsultaTramite.getVcodres().equals("0001")) {
                           objDD.setFlagCodigoVirtual('1'); 
                      } else {
                           objDD.setFlagCodigoVirtual('4');
                      }
                    }
	                    
	              } catch(Exception e) {
	                 objDD.setFlagCodigoVirtual('5'); 
	              }      
	           } else {  
	              objDD.setFlagCodigoVirtual('1');
	           }  
	        }  
	        
	        if (despacho.getSidemiext().getCflgest() == 'E')
	          objDD.setFlagCodigoVirtual('0');
	        if (despacho.getSidemiext().getCflgest() == 'R')
	          objDD.setFlagCodigoVirtual('0');
	        if (despacho.getSidemiext().getCflgest() == 'S')
	          objDD.setFlagCodigoVirtual('0');
	        if (despacho.getSidemiext().getCflgest() == 'O'){
	            //JC-RUC ANALIZAR ES IMPORTANTE  
	            List<String> lst = documentoExternoVirtualDAO.buscarTramiteVirtual(d.getID_CODIGO().toString());
	            /////
	            if (lst!=null && lst.size()>0 && lst.get(0)!=null && !lst.get(0).equals("") && lst.get(0).equals(idDespacho.toString())){
	               despacho = documentoExternoVirtualDAO.buscarDocumentoVirtual(new Integer(lst.get(0))); 
	               d = documentoDAO.findByIdDocumento(despacho.getSidemiext().getIddocumento());
	
	               if (d.getPropietario().getIdusuario().toString().equals(usuario.getIdUsuarioPerfil().toString()) && d.getUnidadpropietario().toString().equals(usuario.getIdUnidadPerfil().toString()) && d.getFlagMultiple()==null)
	                 objDD.setFlagCodigoVirtual('2');
	               else
	                 objDD.setFlagCodigoVirtual('0');
	            }else{
	               objDD.setFlagCodigoVirtual('0');
	            }   
	        }
	        
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        
        return Action.SUCCESS;
    }
    
    public String viewDocRecepcionVirtual() {
        List<Archivo> lst = null;
        Documento d = null;
        
        try {
	        IotdtmDocExterno recepcion = documentoExternoVirtualDAO.buscarDocumentoVirtual(idRecepcion);
	        
	        // Si es documento pide
	        if (recepcion != null) {
		        if (recepcion.getSidrecext().getIddocumento()!=null){
		            d = documentoDAO.findByIdDocumento(recepcion.getSidrecext().getIddocumento());            
		            lst = archivoService.findLstByIdDocumento(d.getDocumentoreferencia()==null?d.getIdDocumento():d.getDocumentoreferencia());
		        }
		        
		        objDD = new DocumentoDetail();
		        objDD.setStrAsunto(recepcion.getVasu());
		        
		        try{
		            objDD.setStrRazonSocial(recepcion.getVnomentemi());
		        }catch(Exception e){
		            e.printStackTrace();
		            objDD.setStrRazonSocial("");
		        }
		        
		        try{
		            Tipodocumento tipoDocumento = tipoDocumentoDAO.findByIdTipoDocumentoPIDE(recepcion.getCcodtipdoc());
		            objDD.setStrNroDocumento(tipoDocumento.getNombre() + " - " + recepcion.getVnumdoc());
		        }catch(Exception e){
		            e.printStackTrace();
		            objDD.setStrNroDocumento("");
		        }
		        
		        objDD.setStrFecha(recepcion.getSidrecext().getDfecreg());
		        objDD.setIdCodigo(Integer.valueOf(recepcion.getSiddocext().intValue()));
		        objDD.setArchivoPrincipal(docPrincipalVirtualDAO.buscarPrincipaByDocExterno(idRecepcion).getVnomdoc());
		        objDD.setArchivoAnexo(recepcion.getVurldocanx()==null?"":recepcion.getVurldocanx());
		        objDD.setCantAnexos(recepcion.getSnumanx() == null ? 0 : recepcion.getSnumanx().intValue());
		        objDD.setNroTramite(recepcion.getSidrecext().getVnumregstd());
		        objDD.setCEstado(recepcion.getSidrecext().getCflgest());
		        objDD.setCuo(recepcion.getSidrecext().getVcuo());
		        objDD.setIIdTipoIdentificacion(Integer.valueOf(recepcion.getCcodtipdoc()));
		        objDD.setRuc(recepcion.getSidrecext().getVrucentrem());
		        objDD.setFlagCodigoVirtual('1');
		       
		        try{
		             objDD.setTamanoPrincipal(objDD.getTamanoFormateado(String.valueOf(recepcion.getIotdtdDocPrincipalList().get(0).getBpdfdoc().length)));
		        }catch(Exception e){
		             objDD.setTamanoPrincipal("");
		        }
		        
		        try{
		             objDD.setTamanoCargo(objDD.getTamanoFormateado(String.valueOf(recepcion.getSidrecext().getBcarstd().length)));
		        }catch(Exception e){
		             objDD.setTamanoCargo("");
		        }
		        
		        if (lst!=null && lst.size()>0){
		            for(int i=0;i<lst.size();i++){
		                if (lst.get(i).getPrincipal() == 'M'){
		                    if (recepcion.getSidrecext().getBcarstd()!=null){
		                        objDD.setArchivoCargo(lst.get(i).getNombreReal());
		                        break;
		                    }
		                }
		            }
		        }
		        
		        if (recepcion.getSidrecext().getIddocumento()==null){
		            objDD.setFlagCodigoVirtual('0');
		        }else{
		            if (objDD.getNroTramite()==null || objDD.getNroTramite().equals("")){
		                objDD.setFlagCodigoVirtual('1');
		            }else{
		                if (recepcion.getSidrecext().getCflgenvcar()=='S'){
		                  objDD.setFlagCodigoVirtual('2');
		                }else{
		                  objDD.setFlagCodigoVirtual('3');
		                }  
		            }
		        }
		        
	            List<ArchivoAdjunto> list = new ArrayList<ArchivoAdjunto>();

		        if (recepcion.getIotdtdAnexoList() != null && recepcion.getIotdtdAnexoList().size() > 0) {
		            for (IotdtdAnexo anexo : recepcion.getIotdtdAnexoList()){
		            	ArchivoAdjunto archivoAdjunto = new ArchivoAdjunto();
		            	archivoAdjunto.setNombreArchivo(anexo.getVnomdoc());
		            	archivoAdjunto.setRutaArchivo("");
		            	archivoAdjunto.setTamanoArchivo("");
		                list.add(archivoAdjunto);
		            }
		        }
		        
	            objDD.setListAnexos(list);
	            
		    // Si es documento mpv
	        } else {
	        	IotdtcRecepcionMPV recepcionMPV = documentoExternoVirtualDAO.buscarDocumentoVirtualMPV(idRecepcion);
	        
		        objDD = new DocumentoDetail();
		        objDD.setStrAsunto(recepcionMPV.getAsunto());
		        objDD.setStrRazonSocial(recepcionMPV.getVnomentemi());
		        objDD.setStrFecha(recepcionMPV.getFechadocumento());
		        objDD.setIdCodigo(recepcionMPV.getSidrecext());
		        
	        	Tipodocumento tipoDocumento = tipoDocumentoDAO.findByIdTipoDocumento(Integer.parseInt(recepcionMPV.getTipodocumento()));
	            objDD.setStrNroDocumento(tipoDocumento.getNombre() + " - " + recepcionMPV.getNumerodocumento());

		        String archivoPrincipal = "";
		        String rutaArchivoPrincipal  = "";
	            List<ArchivoAdjunto> listAnexos = new ArrayList<ArchivoAdjunto>();

		        if (recepcionMPV.getArchivos() != null && recepcionMPV.getArchivos().size() > 0) {
		            for (IotdtdAdjuntoMPV adjunto : recepcionMPV.getArchivos()){
		            	if(adjunto.getTipoArchivo().equals(1)){
			        		archivoPrincipal = adjunto.getNombreArchivo();	
			        		rutaArchivoPrincipal = adjunto.getRutaArchivo() + archivoPrincipal;
			        	}
		            	
		            	if (adjunto.getTipoArchivo().equals(2)) {
		            		ArchivoAdjunto archivoAdjunto = new ArchivoAdjunto();
		            		archivoAdjunto.setNombreArchivo(adjunto.getNombreArchivo());
		            		archivoAdjunto.setRutaArchivo(adjunto.getRutaArchivo());
		            		archivoAdjunto.setTamanoArchivo(FileVirtual.readableFileSize(FileVirtual.getFileSize(adjunto.getRutaArchivo() + adjunto.getNombreArchivo())));
		            		listAnexos.add(archivoAdjunto);
		            	}
		            }
		        }
		        
		        objDD.setArchivoPrincipal(archivoPrincipal);
		        objDD.setRutaArchivoPrincipal(rutaArchivoPrincipal);
		        objDD.setTamanoPrincipal(FileVirtual.readableFileSize(FileVirtual.getFileSize(rutaArchivoPrincipal)));
		        objDD.setCantAnexos(listAnexos.size());
		        objDD.setListAnexos(listAnexos);
		        objDD.setNroTramite(recepcionMPV.getVnumregstd());
		        objDD.setCEstado(recepcionMPV.getCflgest());
		        objDD.setIIdTipoIdentificacion(Integer.valueOf(recepcionMPV.getCtipdociderem().toString()));
		        objDD.setRuc(recepcionMPV.getVrucentrem());
		        objDD.setStrNroIdentificacion(recepcionMPV.getVnumdociderem());
		        objDD.setStrRemitente(recepcionMPV.getDesRemitente());
		        
	        	if (recepcionMPV.getIddocumento() != null){
		            d = documentoDAO.findByIdDocumento(recepcionMPV.getIddocumento());            
		            lst = archivoService.findLstByIdDocumento(d.getDocumentoreferencia() == null ? d.getIdDocumento() : d.getDocumentoreferencia());
		        }
	        	
		        if (lst != null && lst.size() > 0){
		            for(int i=0; i < lst.size(); i++){
		                if (lst.get(i).getPrincipal() == 'M'){
		                    if (recepcionMPV.getBcarstd() != null){
		                        objDD.setArchivoCargo(lst.get(i).getNombreReal());
		                        objDD.setTamanoCargo(lst.get(i).getTamanoFormateado());
		                        break;
		                    }
		                }
		            }
		        }
		        
		        if (recepcionMPV.getIddocumento() == null){
		            objDD.setFlagCodigoVirtual('0');
		        } else {
		            if (objDD.getNroTramite()==null || objDD.getNroTramite().equals("")){
		                objDD.setFlagCodigoVirtual('1');
		            }else{
		                if (recepcionMPV.getCflgenvcar()=='S'){
		                  objDD.setFlagCodigoVirtual('2');
		                }else{
		                  objDD.setFlagCodigoVirtual('3');
		                }  
		            }
		        }
	        }
        
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return Action.SUCCESS;
    }
}