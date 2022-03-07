package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;

public class RecepcionVirtualDAOImpl implements RecepcionVirtualDAO {
	@PersistenceContext(unitName="sigedPU")
	private EntityManager em;
    
    public void setEm(EntityManager em){
    	this.em=em;
    }
    
    public String findByCantidadesDocumentosVirtuales(){
        String sQuery = "SELECT dbo.FN_DOCUMENTOS_VIRTUALES('R')";
        Query qQuery = em.createNativeQuery(sQuery);

        return qQuery.getResultList().get(0).toString();
     }

     public IotdtcRecepcion findByVcuo(String vcuo){
         return (IotdtcRecepcion)em.createNamedQuery("IotdtcRecepcion.findByVcuo")
			.setParameter("vcuo", vcuo).getSingleResult();
     }
     
     @SuppressWarnings("unchecked")
	public List<IotdtcRecepcion> findAll() {    	 
    	 Query query = em.createNamedQuery("IotdtcRecepcion.findAll");
    	 return query.getResultList();
         
     }
  
    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion){		
    	if(recepcion.getSidrecext() == null){
		    em.persist(recepcion); 
		    em.flush();
		    em.refresh(recepcion);
		}else{
		    em.merge(recepcion); 
		    em.flush();
		}
		
       return recepcion;
    }
    
    public IotdtcRecepcionMPV registrarDocumentoMPV(IotdtcRecepcionMPV recepcionMPV){
		
    	if(recepcionMPV == null){
		    em.persist(recepcionMPV); 
		    em.flush();
		    em.refresh(recepcionMPV);
		}else{
		    em.merge(recepcionMPV); 
		    em.flush();
		}
		
       return recepcionMPV;
    }  

	public List<IotdtcRecepcionMPV> consultarDocPendientesAlfrescoMPV() {
		String sql = "SELECT c FROM IotdtcRecepcionMPV c where c.iddocumento is not null and c.flagalfresco = 'P' order by c.dfecreg asc ";
		Query q = em.createQuery(sql);
		
		return q.getResultList();
	}
}
