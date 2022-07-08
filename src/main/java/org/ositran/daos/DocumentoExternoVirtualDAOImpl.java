package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.btg.ositran.siged.domain.TramiteDocumentario;
import com.btg.ositran.siged.domain.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.ositran.dojo.BandejaRecepcionMPVObservados;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentoExternoVirtualDAOImpl implements DocumentoExternoVirtualDAO{
	@PersistenceContext(unitName="sigedPU")
	private EntityManager em;
     
    public void setEm(EntityManager em){
        this.em=em;
    }
    
    public EntityManager getEm() {
        return em;
    }
    @SuppressWarnings("unchecked")
   	public List<IotdtmDocExterno> findAll() {    	 
  	     	 Query query = em.createNamedQuery("IotdtmDocExterno.findAll");
  	     	 return query.getResultList();
  	          
    }
    @SuppressWarnings("unchecked")
    
   	public List<IotdtmDocExterno> findSiddocextToMigrate(Integer siderccext) {    	 
//  	     	 Query query = em.createNamedQuery("IotdtmDocExterno.findAll");
//  	     	 return query.getResultList();
  	   	String sql = " SELECT e FROM IotdtmDocExterno e, IotdtcRecepcion j where e.sidrecext.sidrecext = j.sidrecext and j.sidrecext = :sidrecext";
  	   	
//  	  SELECT i FROM IotdtmDocExternoPIDE i, IotdtcDespachoPIDE j where i.sidemiext.sidemiext = j.sidemiext and j.sidemiext = :sidemiext
				
		Query query = em.createQuery(sql);
		query.setParameter("sidrecext", siderccext);
		return (List<IotdtmDocExterno>) query.getResultList();
		
//		SELECT SIDDOCEXT FROM IOTDTM_DOC_EXTERNO WHERE SIDRECEXT = @SIDRECEXT
    }
  @SuppressWarnings("unchecked")
    
   	public List<IotdtcDespacho> findVcuoRefObs(Integer iddocumento) {    	 
//  	     	 Query query = em.createNamedQuery("IotdtmDocExterno.findAll");
//  	     	 return query.getResultList();
  	   	String sql = " SELECT c FROM Documento a, DocumentoReferencia b, IotdtcDespacho c, IotdtmDocExterno d "
  	   			+ "  where a.iddocumento = b.iddocumentoreferencia and c.sidemiext = d.sidemiext "
  	   			+ " and a.nrovirtual = d.siddocext and b.iddocumento = :iddocumento";
//  	  SELECT NROVIRTUAL ,VCUO, *
//  	 FROM DOCUMENTO A, DOCUMENTOREFERENCIA B , IOTDTC_DESPACHO C , IOTDTM_DOC_EXTERNO D
//  	 WHERE A.IDDOCUMENTO = B.IDDOCUMENTOREFERENCIA
//  	 AND C.SIDEMIEXT = D.SIDEMIEXT
//  	 AND A.NROVIRTUAL = D.SIDDOCEXT
//  	 --AND A.IDDOCUMENTO = 1635
//  	 AND B.IDDOCUMENTO = 1638

				
		Query query = em.createQuery(sql);
		query.setParameter("iddocumento", iddocumento);
		return (List<IotdtcDespacho>) query.getResultList();
		
//		SELECT SIDDOCEXT FROM IOTDTM_DOC_EXTERNO WHERE SIDRECEXT = @SIDRECEXT
    }
    
    
    
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesMigrarCargo(){
        String  sql = " SELECT e FROM IotdtmDocExterno e where e.sidemiext.cflgest in ('R') and e.sidemiext.bcarstdrec is not null and (select count(d.idDocumento) from Documento d, Archivo a where d.idDocumento = e.sidemiext.iddocumento and decode(d.documentoreferencia, null,d.idDocumento, d.documentoreferencia) = a.documento and a.estado = 'A' and a.principal = 'M') = 0 "; 
        return em.createQuery(sql).getResultList();  
    }
    
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesAtencion(){
        String  sql = " SELECT e FROM IotdtmDocExterno e, Documento d where e.sidemiext.cflgest in ('R') and e.sidemiext.bcarstdrec is not null and e.sidemiext.iddocumento = d.idDocumento and d.estado not in ('T') "; 
        return em.createQuery(sql).getResultList();  
    }
    
    public List<IotdtmDocExterno> buscarDocumentosEnviadosPendientesCargo(){
        String  sql = " SELECT e FROM IotdtmDocExterno e where e.sidemiext.cflgest = 'E' ";
        sql = sql + " union  SELECT e FROM IotdtmDocExterno e where e.sidemiext.cflgest = 'P' and e.sidemiext.cflgenv = 'E'";
        return em.createQuery(sql).getResultList();  
    }
    
    public List<IotdtmDocExterno> buscarDocumentosDespachoPendientesSubsanacion(){
        String  sql = " SELECT e FROM IotdtmDocExterno e where e.sidemiext.cflgest in ('E', 'R','O') AND e.sidemiext.vcuoref is not null AND (select count(x.sidemiext.vcuo) from IotdtmDocExterno x where x.sidemiext.vcuo = e.sidemiext.vcuoref and x.sidemiext.cflgest = 'O')>0";
        return em.createQuery(sql).getResultList();  
    }
    
    public List<IotdtmDocExterno> buscarRecepcionVirtual(Usuario objUsuario){
       String sql = "SELECT e FROM IotdtmDocExterno e where e.sidrecext.sidrecext is not null and e.sidrecext.cflgest not in ('X')  order by e.sidrecext.dfecreg desc";
					 
       return em.createQuery(sql).getResultList();
    }
    
    //////////////////////////////////////////////////
    public List<IotdtmDocExterno> buscarDocumentosRecepcionPendientesSubsanacion(){
       String sql = "SELECT e FROM IotdtmDocExterno e where e.sidrecext.sidrecext is not null and e.sidrecext.cflgest = 'O' and e.sidrecext.vcuo in (select x.sidrecext.vcuoref from IotdtmDocExterno x where x.sidrecext.vcuoref is not null) ";
       return em.createQuery(sql).getResultList();
    }
    
    public List<IotdtmDocExterno> buscarDespachoVirtual(Usuario objUsuario){
    	System.out.println("--------despacho virtual---------------");
       try{ 
           String sql = "SELECT e FROM IotdtmDocExterno e where e.sidemiext.sidemiext is not null and e.sidemiext.cflgest not in ('X') order by e.sidemiext.dfecreg desc";
           return em.createQuery(sql).getResultList();
           
       }catch(Exception e){
           e.printStackTrace();
       }
       return null;
       //return em.createQuery(sql).getResultList();
    }
    
    public IotdtmDocExterno buscarDocumentoVirtual(Integer nroVirtual){
       String sql = "SELECT e FROM IotdtmDocExterno e where e.siddocext =" + nroVirtual;
       try{
            return (IotdtmDocExterno)em.createQuery(sql).getSingleResult();
       }catch(EntityNotFoundException e){
           return null;
       }catch(Exception e){
           return null;
       }     
    }
    public IotdtmDocExterno buscarDocumentoVirtualBySidemext(Integer sidemiext){
        String sql = "SELECT e FROM IotdtmDocExterno e where e.sidemiext =" + sidemiext;
        try{
             return (IotdtmDocExterno)em.createQuery(sql).getSingleResult();
        }catch(EntityNotFoundException e){
            return null;
        }catch(Exception e){
            return null;
        }     
     }
    
    public List<IotdtmDocExterno> buscarDocumentoDespachoVirtual(Integer numero){
       String sql = "SELECT e FROM IotdtmDocExterno e where e.sidemiext.vnumregstd =" + numero + " and e.sidemiext.cflgest in ('P','E','S','R') order by e.sidemiext.dfecreg desc ";
       try{				
            return em.createQuery(sql).getResultList();
       }catch(EntityNotFoundException e){
           return null;
       }catch(Exception e){
           return null;
       }     
    }
    
    public List<IotdtmDocExterno> buscarDocumentoProcesadoDespachoVirtual(Integer numero){
       String sql = "SELECT e FROM IotdtmDocExterno e where e.sidemiext.vnumregstd =" + numero + " and e.sidemiext.cflgest in ('R','O','S') order by e.sidemiext.dfecreg desc ";
       try{				
            return em.createQuery(sql).getResultList();
       }catch(EntityNotFoundException e){
           return null;
       }catch(Exception e){
           return null;
       }     
    }
    
    public IotdtmDocExterno registrarDocumento(IotdtmDocExterno docExterno){
		
       if(docExterno.getSidrecext() == null){
	    em.persist(docExterno); 
	    em.flush();
	    em.refresh(docExterno);
	}
	else{
	    em.merge(docExterno); 
	    em.flush();
	}
		
       return docExterno;
    }
    
    public List<String> buscarTramiteVirtual(String nroTramite){
        String sql = " SELECT CAST(E.SIDDOCEXT AS VARCHAR(16)), DP.IDDOCUMENTO FROM IOTDTM_DOC_EXTERNO E, IOTDTC_DESPACHO DP WHERE  ";
        sql = sql + " DP.CFLGEST NOT IN ('X') AND E.SIDEMIEXT= DP.SIDEMIEXT AND DP.VNUMREGSTD = :nroTramite order by DP.dfecreg desc " ;

        Query q = em.createNativeQuery(sql.toString());
        q.setParameter("nroTramite", nroTramite);
        List<Object> res = (List<Object>) q.getResultList();
        List<String> lp = new ArrayList<String>();

        for (Object obj : res) {     
           Object[] objectArray = (Object[]) obj;
           String valor = (objectArray[0]!=null?objectArray[0].toString():"0");
           lp.add(valor);
        }      

        return lp;   
    }
    
    public List<IotdtcRecepcionMPV> buscarRecepcionMPV(){
        String sql = "SELECT e FROM IotdtcRecepcionMPV e where e.cflgest = 'P' order by e.dfecreg desc";
 					 
        return em.createQuery(sql).getResultList();
    }
    
    @Override
    public List<IotdtcRecepcionMPV> buscarObservadosMPV(){
        String sql = "SELECT e FROM IotdtcRecepcionMPV e where e.cflgest = 'O' order by e.dfecreg desc";
 					 
        return em.createQuery(sql).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<BandejaRecepcionMPVObservados> buscarRechazadosMPV(){
    	List<BandejaRecepcionMPVObservados>  lstBandejaRecepcionMPVObservados = null;
    	List<Object> res = null;

    	try {
    		String sql = "SELECT "
            		+ " A.sidrecext "
            		+ ", '' as NROTRAMITE"
            		+ ",   '' as virtual "
            		+ ",  (TD.descripcion + ' - ' + REPLACE(A.numerodocumento,TD.descripcion,'')) as DOCUMENTO "
            		+ ", A.asunto "
            		+ ", (CASE WHEN A.cflgest = 'O' THEN 'Rechazado' END) as estado "
            		+ ",   A.dfecreg  as FECHAREGISTRO "
            		+ ",   (CASE WHEN A.dfecmod IS NOT NULL THEN  A.dfecmod ELSE A.dfecreg END) as FECHARECHAZO "
            		+ ",   '' as CARPETA"
            		+ ",   '' as ASUNTOCARPETA "
            		+ ", (CASE WHEN A.vnomentemi = '' THEN A.desRemitente ELSE A.vnomentemi END) as  CLIENTE "
            		+ ",  '' as CONTRATO"
            		+ ", A.vobs as OBS "
            		+ ", AD.rutaArchivo "
            		+ ", AD.nombreArchivo  "
            		+ " FROM IotdtcRecepcionMPV A , Tipodocumento TD , IotdtdAdjuntoMPV AD "
            		+ " WHERE A.tipodocumento = TD.idtipodocumento "
            		+ " AND A.sidrecext = AD.recepcion "
            		+ " AND A.cflgest = 'O' "
            		+ " AND AD.tipoArchivo = 1 "
            		+ " ORDER BY A.dfecmod DESC";
            Query q = em.createQuery(sql);
//            em.cre(sql)
            
            System.out.println(sql.toString());
     					 
            res =  q.getResultList();
            if(res!= null && res.size() > 0) {
            	lstBandejaRecepcionMPVObservados = new ArrayList<BandejaRecepcionMPVObservados>();
            	for(Object obj: res) {
            		BandejaRecepcionMPVObservados b = new BandejaRecepcionMPVObservados();
            		Object[] objectArray = (Object[]) obj;
            		Object object1 = objectArray[0];
					Object object2 = objectArray[1];
					Object object3 = objectArray[2];
					Object object4 = objectArray[3];
					Object object5 = objectArray[4];
					Object object6 = objectArray[5];
					Object object7 = objectArray[6];
					Object object8 = objectArray[7];
					Object object9 = objectArray[8];
					Object object10 = objectArray[9];
					Object object11 = objectArray[10];
					Object object12 = objectArray[11];
					Object object13 = objectArray[12];
					Object object14 = objectArray[13];
					Object object15 = objectArray[14];
					
					Date fechaCreacion = (Date) object7;
					Date fechaRechazo = (Date) object8;
					b.setSidrecext((Integer) (object1==null?"":Integer.valueOf(object1.toString())));
					b.setNroTramite(object2==null?"":object2.toString());
					b.setVirtual(object3==null?"":object3.toString());
					b.setDocumento(object4==null?"":object4.toString());
					b.setAsunto(object5==null?"":object5.toString());
					b.setEstado(object6==null?"":object6.toString());
					b.setFechaRegistro(fechaCreacion);
					b.setFechaRechazo(fechaRechazo);
					b.setCarpeta(object9==null?"":object9.toString());
					b.setAsuntoCarpeta(object10==null?"":object10.toString());
					b.setCliente(object11==null?"":object11.toString());
					b.setContrato(object12==null?"":object12.toString());
					b.setObs(object13==null?"":object13.toString());
					b.setRutaArchivo(object14==null?"":object14.toString());
					b.setNombreArchivo(object15==null?"":object15.toString());
//					
					lstBandejaRecepcionMPVObservados.add(b);
            	}
            }
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lstBandejaRecepcionMPVObservados = null;
		}
        return lstBandejaRecepcionMPVObservados;
    }
    
    
    @SuppressWarnings("unchecked")
	@Override
    public List<BandejaRecepcionMPVObservados> buscarRechazadosMPVDetalle(Integer sidrecext){
    	List<BandejaRecepcionMPVObservados>  lstBandejaRecepcionMPVObservados = null;
    	List<Object> res = null;

    	try {
    		String sql = "SELECT "
            		+ " A.sidrecext "
            		+ ", '' as NROTRAMITE"
            		+ ",   '' as virtual "
            		+ ",  (TD.descripcion + ' - ' + REPLACE(A.numerodocumento,TD.descripcion,'')) as DOCUMENTO "
            		+ ", A.asunto "
            		+ ", (CASE WHEN A.cflgest = 'O' THEN 'Rechazado' END) as estado "
            		+ ",   A.dfecreg  as FECHAREGISTRO "
            		+ ",   (CASE WHEN A.dfecmod IS NOT NULL THEN  A.dfecmod ELSE A.dfecreg END) as FECHARECHAZO "
            		+ ",   '' as CARPETA"
            		+ ",   '' as ASUNTOCARPETA "
            		+ ", (CASE WHEN A.vnomentemi = '' THEN A.desRemitente ELSE A.vnomentemi END) as  CLIENTE "
            		+ ",  '' as CONTRATO"
            		+ ", A.vobs as OBS "
            		+ ", AD.rutaArchivo "
            		+ ", AD.nombreArchivo  "
            		+ " FROM IotdtcRecepcionMPV A , Tipodocumento TD , IotdtdAdjuntoMPV AD "
            		+ " WHERE A.tipodocumento = TD.idtipodocumento "
            		+ " AND A.sidrecext = AD.recepcion "
            		+ " AND A.cflgest = 'O' "
            		+ " AND AD.tipoArchivo = 1 "
            		+ " AND A.sidrecext = :sidrecext "
            		+ " ORDER BY A.dfecmod DESC";
            Query q = em.createQuery(sql);
//            em.cre(sql)
            q.setParameter("sidrecext", sidrecext);
//            System.out.println(sql.toString());
     					 
            res =  q.getResultList();
            if(res!= null && res.size() > 0) {
            	lstBandejaRecepcionMPVObservados = new ArrayList<BandejaRecepcionMPVObservados>();
            	for(Object obj: res) {
            		BandejaRecepcionMPVObservados b = new BandejaRecepcionMPVObservados();
            		Object[] objectArray = (Object[]) obj;
            		Object object1 = objectArray[0];
					Object object2 = objectArray[1];
					Object object3 = objectArray[2];
					Object object4 = objectArray[3];
					Object object5 = objectArray[4];
					Object object6 = objectArray[5];
					Object object7 = objectArray[6];
					Object object8 = objectArray[7];
					Object object9 = objectArray[8];
					Object object10 = objectArray[9];
					Object object11 = objectArray[10];
					Object object12 = objectArray[11];
					Object object13 = objectArray[12];
					Object object14 = objectArray[13];
					Object object15 = objectArray[14];
					
					Date fechaCreacion = (Date) object7;
					Date fechaRechazo = (Date) object8;
					b.setSidrecext((Integer) (object1==null?"":Integer.valueOf(object1.toString())));
					b.setNroTramite(object2==null?"":object2.toString());
					b.setVirtual(object3==null?"":object3.toString());
					b.setDocumento(object4==null?"":object4.toString());
					b.setAsunto(object5==null?"":object5.toString());
					b.setEstado(object6==null?"":object6.toString());
					b.setFechaRegistro(fechaCreacion);
					b.setFechaRechazo(fechaRechazo);
					b.setCarpeta(object9==null?"":object9.toString());
					b.setAsuntoCarpeta(object10==null?"":object10.toString());
					b.setCliente(object11==null?"":object11.toString());
					b.setContrato(object12==null?"":object12.toString());
					b.setObs(object13==null?"":object13.toString());
					b.setRutaArchivo(object14==null?"":object14.toString());
					b.setNombreArchivo(object15==null?"":object15.toString());
//					
					lstBandejaRecepcionMPVObservados.add(b);
            	}
            }
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lstBandejaRecepcionMPVObservados = null;
		}
        return lstBandejaRecepcionMPVObservados;
    }
    
    public IotdtcRecepcionMPV buscarDocumentoVirtualMPV(Integer nroVirtual){
        String sql = "SELECT e FROM IotdtcRecepcionMPV e where e.sidrecext =" + nroVirtual;
        try{				
             return (IotdtcRecepcionMPV)em.createQuery(sql).getSingleResult(); 
        }catch(EntityNotFoundException e){
            return null;
        }catch(Exception e){
            return null;
        }
     }   
    public IotdtdDocPrincipal buscarDocumentoPrincipalBySiddocext(Integer siddocext){
        String sql = "SELECT e FROM IotdtdDocPrincipal e where e.siddocext =" + siddocext;
        try{
             return (IotdtdDocPrincipal)em.createQuery(sql).getSingleResult();
        }catch(EntityNotFoundException e){
            return null;
        }catch(Exception e){
            return null;
        }     
     }
    public IotdtdAnexo buscarDocumentoAnexoBySiddocext(Integer siddocext){
        String sql = "SELECT e FROM IotdtdAnexo e where e.siddocext =" + siddocext;
        try{
             return (IotdtdAnexo)em.createQuery(sql).getSingleResult();
        }catch(EntityNotFoundException e){
            return null;
        }catch(Exception e){
            return null;
        }     
     }
}