package org.ositran.siged.jobs;

import com.btg.ositran.pide.domain.PideIotdtcRecepcion;
import com.btg.ositran.pide.domain.PideIotdtdAnexo;
import com.btg.ositran.pide.domain.PideIotdtdDocPrincipal;
import com.btg.ositran.pide.domain.PideIotdtmDocExterno;
import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.ositran.siged.pide.daos.PideDAO;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ositran.daos.RecepcionPideDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vcupe
 */

public class IntegracionPIDESingleton {
	
    private PideDAO pideDAO;
    private RecepcionPideDAO recepcionPideDAO;
    
    private static Log log=LogFactory.getLog(IntegracionPIDESingleton.class);
    
      
    public PideDAO getPideDAO() {
		return pideDAO;
	}

	public void setPideDAO(PideDAO pideDAO) {
		this.pideDAO = pideDAO;
	}
	
	public RecepcionPideDAO getRecepcionPideDAO() {
		return recepcionPideDAO;
	}

	public void setRecepcionPideDAO(RecepcionPideDAO recepcionPideDAO) {
		this.recepcionPideDAO = recepcionPideDAO;
	}

	@Transactional
    public  void procesarRecepcionDespacho() {
        
        try{
        	log.info("..............INICIANDO PROCESO INTEGRACION PIDE...............=" + new Date());        

            Date fecha = new Date();
           
            List<PideIotdtcRecepcion> listaRecepcionPide = pideDAO.findRecepcionByEstado("P");
            
            for(PideIotdtcRecepcion recepcionPide: listaRecepcionPide){
            	log.info("sidrecext:"+recepcionPide.getSidrecext()+",vrucentrem:"+recepcionPide.getVrucentrem());
            	
            	try{
            	
	            	if(recepcionPideDAO.findBySidrecext(recepcionPide.getSidrecext()) == null){
	            		
	            		log.info("Nuevo documento pide recepcion"+"(sidrecext):"+recepcionPide.getSidrecext());
	            		
	            		IotdtcRecepcion iotdtcRecepcion = new IotdtcRecepcion();
	            		iotdtcRecepcion.setSidrecext(recepcionPide.getSidrecext());
	            		iotdtcRecepcion.setVrucentrem(recepcionPide.getVrucentrem());
	            		iotdtcRecepcion.setVuniorgrem(recepcionPide.getVuniorgrem());
	            		iotdtcRecepcion.setCtipdociderem(recepcionPide.getCtipdociderem());
	            		iotdtcRecepcion.setVnumdociderem(recepcionPide.getVnumdociderem());
	            		iotdtcRecepcion.setVnumregstd(recepcionPide.getVnumregstd()); //bytes
	            		iotdtcRecepcion.setVanioregstd(recepcionPide.getVanioregstd());
	            		iotdtcRecepcion.setVuniorgstd(recepcionPide.getVuniorgstd());
	            		iotdtcRecepcion.setCcoduniorgstd(recepcionPide.getCcoduniorgstd());
	            		iotdtcRecepcion.setVdesanxstd(recepcionPide.getVdesanxstd());
	            		iotdtcRecepcion.setDfecregstd(recepcionPide.getDfecregstd());
	            		iotdtcRecepcion.setVusuregstd(recepcionPide.getVusuregstd());
	            		iotdtcRecepcion.setBcarstd(recepcionPide.getBcarstd()); //bytes
	            		iotdtcRecepcion.setVcuo(recepcionPide.getVcuo());
	            		iotdtcRecepcion.setVcuoref(recepcionPide.getVcuoref());
	            		iotdtcRecepcion.setVobs(recepcionPide.getVobs());
	            		iotdtcRecepcion.setCflgestobs(recepcionPide.getCflgestobs());
	            		iotdtcRecepcion.setCflgest(recepcionPide.getCflgest());
	            		//iotdtcRecepcion.setCflganu((recepcionPide.getCflganu());
	            		iotdtcRecepcion.setDfecreg(recepcionPide.getDfecreg());
	            		iotdtcRecepcion.setVusumod(recepcionPide.getVusumod());
	            		iotdtcRecepcion.setDfecmod(recepcionPide.getDfecmod());
	            		iotdtcRecepcion.setCflgenvcar(recepcionPide.getCflgenvcar());
	            		iotdtcRecepcion.setIddocumento(null); 
	            		
	            		recepcionPideDAO.registrarDocumento(iotdtcRecepcion);
	            		
	            		List<PideIotdtmDocExterno> listDocExternos = pideDAO.findDocExternosByIdRecepcion(recepcionPide.getSidrecext());
	            		
	            		log.info("Total doc externos a integrar:"+(listDocExternos == null?0:listDocExternos.size()));
	            		
	            		
	            		if(listDocExternos != null && listDocExternos.size() > 0){
	            			
	            			IotdtmDocExterno iotdtmDocExterno = null;	            			
	            			for(PideIotdtmDocExterno pideIotdtmDocExterno:listDocExternos){
	            				
	            				log.info("Nuevo documento externo pide recepcion"+"(siddocext):"+pideIotdtmDocExterno.getSiddocext());	            				
	            				
	            				iotdtmDocExterno = new IotdtmDocExterno();
	            				//iotdtmDocExterno.setSiddocext(pideIotdtmDocExterno.getSiddocext());
	            				iotdtmDocExterno.setVnomentemi(pideIotdtmDocExterno.getVnomentemi());
	            				iotdtmDocExterno.setCcodtipdoc(pideIotdtmDocExterno.getCcodtipdoc());
	            				iotdtmDocExterno.setVnumdoc(pideIotdtmDocExterno.getVnumdoc());
	            				iotdtmDocExterno.setDfecdoc(pideIotdtmDocExterno.getDfecdoc());
	            				iotdtmDocExterno.setVuniorgdst(pideIotdtmDocExterno.getVuniorgdst());
	            				iotdtmDocExterno.setVnomdst(pideIotdtmDocExterno.getVnomdst());
	            				iotdtmDocExterno.setVnomcardst(pideIotdtmDocExterno.getVnomcardst());
	            				iotdtmDocExterno.setVasu(pideIotdtmDocExterno.getVasu());
	            				iotdtmDocExterno.setCindtup(pideIotdtmDocExterno.getCindtup());
	            				iotdtmDocExterno.setSnumanx(pideIotdtmDocExterno.getSnumanx());
	            				iotdtmDocExterno.setSnumfol(pideIotdtmDocExterno.getSnumfol());
	            				iotdtmDocExterno.setVurldocanx(pideIotdtmDocExterno.getVurldocanx());
	            				iotdtmDocExterno.setSidrecext(iotdtcRecepcion);
	            				
	            				recepcionPideDAO.registrarDocExterno(iotdtmDocExterno);
	            				
	            				
	            				
	            				List<PideIotdtdDocPrincipal> listDocPrincipales = pideDAO.findDocPrincipalByIdExterno(pideIotdtmDocExterno.getSiddocext());
	    	            		
	    	            		log.info("Total doc principal a integrar:"+(listDocPrincipales == null?0:listDocPrincipales.size()));
	    	            			    	            		
	    	            		if(listDocPrincipales != null && listDocPrincipales.size() > 0){
	    	            			
	    	            			IotdtdDocPrincipal iotdtdDocPrincipal = null;	            			
	    	            			for(PideIotdtdDocPrincipal pideIotdtdDocPrincipal:listDocPrincipales){
	    	            				
	    	            				log.info("Nuevo documento principal pide recepcion"+"(siddocpri):"+pideIotdtdDocPrincipal.getSiddocpri());	            				
	    	            				
	    	            				iotdtdDocPrincipal = new IotdtdDocPrincipal();
	    	            				iotdtdDocPrincipal.setSiddocext(iotdtmDocExterno);
	    	            				iotdtdDocPrincipal.setVnomdoc(pideIotdtdDocPrincipal.getVnomdoc());
	    	            				iotdtdDocPrincipal.setBpdfdoc(pideIotdtdDocPrincipal.getBpdfdoc());
	    	            				iotdtdDocPrincipal.setCcodest(pideIotdtdDocPrincipal.getCcodest());
	    	            				iotdtdDocPrincipal.setDfecreg(pideIotdtdDocPrincipal.getDfecreg());
	    	            				
	    	            				recepcionPideDAO.registrarDocPrincipal(iotdtdDocPrincipal);	    	            				
	    	            			}
	    	            		}
	    	            		
	    	            		
	    	            		List<PideIotdtdAnexo> listAnexos = pideDAO.findAnexoByIdExterno(pideIotdtmDocExterno.getSiddocext());
	    	            		
	    	            		log.info("Total anexos a integrar:"+(listAnexos == null?0:listAnexos.size()));
	    	            			    	            		
	    	            		if(listAnexos != null && listAnexos.size() > 0){
	    	            			
	    	            			IotdtdAnexo iotdtdAnexo = null;	            			
	    	            			for(PideIotdtdAnexo pideIotdtdAnexo:listAnexos){
	    	            				
	    	            				log.info("Nuevo documento anexo pide recepcion"+"(siddocanx):"+pideIotdtdAnexo.getSiddocanx());	            				
	    	            				
	    	            				iotdtdAnexo = new IotdtdAnexo();
	    	            				iotdtdAnexo.setSiddocext(iotdtmDocExterno);
	    	            				iotdtdAnexo.setVnomdoc(pideIotdtdAnexo.getVnomdoc());
	    	            				iotdtdAnexo.setDfecreg(pideIotdtdAnexo.getDfecreg());
	    	            				
	    	            				recepcionPideDAO.registrarAnexo(iotdtdAnexo);	    	            				
	    	            			}
	    	            		}
	            				
	            				
	            				
	            			}
	            			

	            		}
	            		
	            		
	            	}
            	
                }catch(Exception e){
                	log.error("Error al registrar Pide recepcion, Sidrecex: "+recepcionPide.getSidrecext()+", Error:"+e.getMessage());
                    e.printStackTrace();
                }
            	
            }
            
            
        }catch(Exception e){
           e.printStackTrace();
        }    
    }
    
}
