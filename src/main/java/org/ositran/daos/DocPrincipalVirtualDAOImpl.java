package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

public class DocPrincipalVirtualDAOImpl implements  DocPrincipalVirtualDAO{
	@PersistenceContext(unitName="sigedPU")
	private EntityManager em;
     
    public void setEm(EntityManager em){
    	this.em=em;
    }
    
    public List<IotdtdDocPrincipal> buscarPrincipalVirtualId(Integer idDocExterno){
       String sql = "SELECT e FROM IotdtdDocPrincipal e where e.siddocext =" + idDocExterno;
       return em.createQuery(sql).getResultList();
    }
    
    public IotdtdDocPrincipal buscarPrincipaByDocExterno(Integer idDocExterno){
         String  sql = "SELECT vnomdoc from IOTDTD_DOC_PRINCIPAL where siddocext = " + idDocExterno;
         IotdtdDocPrincipal iotdtdDocPrincipal = new IotdtdDocPrincipal();
         try {
             Query q = em.createNativeQuery(sql.toString());
             iotdtdDocPrincipal.setVnomdoc(q.getResultList().get(0).toString());
         } catch(Exception e){
             e.printStackTrace();
         }
            
         return iotdtdDocPrincipal;
    }
    
    public IotdtdDocPrincipal registrarPrincipal(IotdtdDocPrincipal principal){
        if(principal.getSiddocpri() == null){
	    em.persist(principal); 
	    em.flush();
	    em.refresh(principal);
	}
	else{
	    em.merge(principal); 
	    em.flush();
	}
		
       return principal;
    }
    @SuppressWarnings("unchecked")
   	public List<IotdtdDocPrincipal> findAll() {    	 
  	     	 Query query = em.createNamedQuery("IotdtdDocPrincipal.findAll");
  	     	 return query.getResultList();
  	          
    }
}
