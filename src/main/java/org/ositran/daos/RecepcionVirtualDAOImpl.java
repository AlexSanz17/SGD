package org.ositran.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

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
     public IotdtcRecepcion findByIdDoc(Integer iddocumento){
    	 IotdtcRecepcion iotdtcRecepcion = null;
    	 try {
    		 iotdtcRecepcion = (IotdtcRecepcion) em.createNamedQuery("IotdtcRecepcion.findByIdDoc").setParameter("iddocumento", iddocumento).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
         return iotdtcRecepcion;
     }
     
     
    @SuppressWarnings("unchecked")
	public List<IotdtcRecepcion> findAll() {    	 
    	 Query query = em.createNamedQuery("IotdtcRecepcion.findAll");
    	 return query.getResultList();
         
     }
    @Transactional
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
		try {
		return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void rechazarDocumentoMPV(Integer idDocumento, String observacion, String estado, Date fecha, String usuario) {
		String sql = "UPDATE Iotdtc_Recepcion_MPV SET cflgest = :cflgest, vobs = :vobs, dfecmod = :dfecmod, vusumod = :vusumod WHERE sidrecext = :sidrecext";
		Query q = em.createNativeQuery(sql);
		q.setParameter("sidrecext", idDocumento).setParameter("vobs", observacion).setParameter("cflgest", estado)
			.setParameter("dfecmod", fecha).setParameter("vusumod", usuario);
		q.executeUpdate();
	}
}