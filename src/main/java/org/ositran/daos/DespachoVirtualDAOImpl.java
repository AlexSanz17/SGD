package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcRecepcion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DespachoVirtualDAOImpl implements DespachoVirtualDAO{
	@PersistenceContext(unitName="sigedPU")
	private EntityManager em;
    
    public void setEm(EntityManager em){
    	this.em=em;
    }
    
    public String findByCantidadesDocumentosVirtuales(){
        String sQuery = "SELECT [dbo].[FN_DOCUMENTOS_VIRTUALES]('D')";
        Query qQuery = em.createNativeQuery(sQuery);

        return qQuery.getResultList().get(0).toString();
     }
    
     public IotdtcDespacho findByVcuo(String vcuo){
         return (IotdtcDespacho)em.createNamedQuery("IotdtcDespacho.findByVcuo")
				.setParameter("vcuo", vcuo).getSingleResult();
     }
     
     public IotdtcDespacho findByIdDocumento(Integer iddocumento){
         return (IotdtcDespacho)em.createNamedQuery("IotdtcDespacho.findByIdDocumento")
				.setParameter("iddocumento", iddocumento).getSingleResult();
     }
    
    
     public IotdtcDespacho registrarDocumento(IotdtcDespacho despacho){
		
       if(despacho.getSidemiext() == null){
	    em.persist(despacho); 
	    em.flush();
	    em.refresh(despacho);
	}
	else{
	    em.merge(despacho); 
	    em.flush();
	}
		
       return despacho;
    }  
     
     public IotdtcDespacho actualizarDespacho(IotdtcDespacho despacho){
 		
         if(despacho.getVcuo() != null){
        	  em.merge(despacho); 
        	    em.flush();
  	}
  		
         return despacho;
      }   
     @SuppressWarnings("unchecked")
 	public List<IotdtcDespacho> findAll() {    	 
     	 Query query = em.createNamedQuery("IotdtcDespacho.findAll");
     	 return query.getResultList();
          
      }
     
     @SuppressWarnings("unchecked")
     
    	public List<IotdtcDespacho> findVcuoRefObs(Integer iddocumento) {    	 
   	   	String sql = " SELECT c FROM Documento a, DocumentoReferencia b, IotdtcDespacho c, IotdtmDocExterno d "
   	   			+ "  where a.idDocumento = b.idDocumentoReferencia and c.sidemiext = d.sidemiext "
   	   			+ " and a.nroVirtual = d.siddocext and b.idDocumento = :iddocumento";
	
 		Query query = em.createQuery(sql);
 		query.setParameter("iddocumento", iddocumento);
 		return (List<IotdtcDespacho>) query.getResultList();
 		

     }
}
