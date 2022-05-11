package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class RecepcionPIDEDAOImpl implements RecepcionPIDEDAO {
    private EntityManager em;
     
    @PersistenceContext(unitName="sigedPU")
    public void setEm(EntityManager em){
	this.em=em;
    }
    
    @SuppressWarnings("rawtypes")
	public IotdtcRecepcion findBySidrecext(Integer sidrecext){
    	Query query = em.createNamedQuery("IotdtcRecepcion.findBySidrecext")
			.setParameter("sidrecext", sidrecext);
    	
    	List results = query.getResultList();
    	if (!results.isEmpty()){
    	   return (IotdtcRecepcion) results.get(0);
    	}
    	
    	return null;
    }

    public IotdtcRecepcion registrarDocumento(IotdtcRecepcion recepcion){
	    em.persist(recepcion); 
	    em.flush();
	    em.refresh(recepcion);
		
       return recepcion;
    }
    
    public IotdtmDocExterno registrarDocExterno(IotdtmDocExterno docExterno){
	    em.persist(docExterno); 
	    em.flush();
	    em.refresh(docExterno);

       return docExterno;
    }
    
    public IotdtdDocPrincipal registrarDocPrincipal(IotdtdDocPrincipal docPrincipal){
	    em.persist(docPrincipal); 
	    em.flush();
	    em.refresh(docPrincipal);

       return docPrincipal;
    }
    
    public IotdtdAnexo registrarAnexo(IotdtdAnexo docAnexo){
		
	    em.persist(docAnexo); 
	    em.flush();
	    em.refresh(docAnexo);

       return docAnexo;
    }
}