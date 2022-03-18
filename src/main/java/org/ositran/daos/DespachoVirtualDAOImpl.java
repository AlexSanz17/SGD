package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcDespacho;

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
        String sQuery = "SELECT FN_DOCUMENTOS_VIRTUALES('D') FROM DUAL";
        Query qQuery = em.createNativeQuery(sQuery);

        return qQuery.getResultList().get(0).toString();
     }
    
     public IotdtcDespacho findByVcuo(String vcuo){
         return (IotdtcDespacho)em.createNamedQuery("IotdtcDespacho.findByVcuo")
				.setParameter("vcuo", vcuo).getSingleResult();
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
}
