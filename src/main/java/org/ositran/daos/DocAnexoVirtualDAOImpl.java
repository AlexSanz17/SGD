package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtdAnexo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class DocAnexoVirtualDAOImpl implements DocAnexoVirtualDAO{
	@PersistenceContext(unitName="sigedPU")
	private EntityManager em;
     
    public void setEm(EntityManager em){
    	this.em=em;
    }
    
    public List<IotdtdAnexo> buscarAnexoVirtualId(Integer idDocExterno){
       String sql = "SELECT e FROM IotdtdAnexo e where e.siddocext =" + idDocExterno;
					 
       return em.createQuery(sql).getResultList(); 
    }
    
    public IotdtdAnexo registrarAnexo(IotdtdAnexo anexo){
		
       if(anexo.getSiddocanx() == null){
	    em.persist(anexo); 
	    em.flush();
	    em.refresh(anexo);
	}
	else{
	    em.merge(anexo); 
	    em.flush();
	}
		
       return anexo;
    }
}
