/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionMPV;
import com.btg.ositran.siged.domain.IotdtcRecepcionSchemaIdsgd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Juan Bengoa
 */
public class RecepcionVirtualDAOImpl implements RecepcionVirtualDAO{
    private EntityManager em;
    
    public String findByCantidadesDocumentosVirtuales(){
        String sQuery = "SELECT dbo.FN_DOCUMENTOS_VIRTUALES('R')";
        Query qQuery = em.createNativeQuery(sQuery);

        return qQuery.getResultList().get(0).toString();
     }
     
    @PersistenceContext(unitName="sigedPU")
    public void setEm(EntityManager em){
	this.em=em;
    }
    
     public IotdtcRecepcion findByVcuo(String vcuo){
         return (IotdtcRecepcion)em.createNamedQuery("IotdtcRecepcion.findByVcuo")
				.setParameter("vcuo", vcuo).getSingleResult();
     }
     
     @SuppressWarnings("unchecked")
	public List<IotdtcRecepcion> findAll(){
    	 
    	 Query query = em.createNamedQuery("IotdtcRecepcion.findAll");
    	 return query.getResultList();
         
     }
     
    /*public int insertByInteroperabilidad(IotdtcRecepcionSchemaIdsgd iotdtcRecepcionSchemaIdsgd) {
    	 int result  = em.createNativeQuery("INSERT INTO IotdtcRecepcion ("
    	 		+ " SIDRECEXT	,	\r\n"
    	 		+ " BCARSTD	,	\r\n"
    	 		+ " CCODUNIORGSTD	,	\r\n"
    	 		+ " CFLGENVCAR	,	\r\n"
    	 		+ " CFLGEST	,	\r\n"
    	 		+ " CFLGESTOBS	,	\r\n"
    	 		+ " CTIPDOCIDEREM	,	\r\n"
    	 		+ " DFECMOD	,	\r\n"
    	 		+ " DFECREG ,	\r\n"
    	 		+ " DFECREGSTD	,	\r\n"
    	 		+ " VANIOREGSTD	,	\r\n"
    	 		+ " VCUO		,	\r\n"
    	 		+ " VCUOREF	,	\r\n"
    	 		+ " VDESANXSTD	,	\r\n"
    	 		+ " VNUMDOCIDEREM	,	\r\n"
    	 		+ " VNUMREGSTD	,	\r\n"
    	 		+ " VOBS,	\r\n"
    	 		+ " VRUCENTREM	,	\r\n"
    	 		+ " VUNIORGREM	,	\r\n"
    	 		+ " VUNIORGSTD	,	\r\n"
    	 		+ " VUSUMOD	,	\r\n"
    	 		+ " VUSUREGSTD) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
         .setParameter(1, iotdtcRecepcionSchemaIdsgd.getSidrecext())
         .setParameter(2, iotdtcRecepcionSchemaIdsgd.getBcarstd())
         .setParameter(3, iotdtcRecepcionSchemaIdsgd.getCcoduniorgstd())
         .setParameter(4, iotdtcRecepcionSchemaIdsgd.getCflgenvcar() )
         .setParameter(5, iotdtcRecepcionSchemaIdsgd.getCflgest())
         .setParameter(6, iotdtcRecepcionSchemaIdsgd.getCflgestobs())
         .setParameter(7, iotdtcRecepcionSchemaIdsgd.getCtipdociderem())
         .setParameter(8, iotdtcRecepcionSchemaIdsgd.getDfecmod())
         .setParameter(9, iotdtcRecepcionSchemaIdsgd.getDfecreg())
         .setParameter(10, iotdtcRecepcionSchemaIdsgd.getDfecregstd())
         .setParameter(11, iotdtcRecepcionSchemaIdsgd.getVanioregstd())
         .setParameter(12, iotdtcRecepcionSchemaIdsgd.getVcuo())
         .setParameter(13, iotdtcRecepcionSchemaIdsgd.getVcuoref())
         .setParameter(14, iotdtcRecepcionSchemaIdsgd.getVdesanxstd())
         .setParameter(15, iotdtcRecepcionSchemaIdsgd.getVnumdociderem())
         .setParameter(16, iotdtcRecepcionSchemaIdsgd.getVnumregstd())
         .setParameter(17, iotdtcRecepcionSchemaIdsgd.getVobs())
         .setParameter(18, iotdtcRecepcionSchemaIdsgd.getVrucentrem())
         .setParameter(19, iotdtcRecepcionSchemaIdsgd.getVuniorgrem())
         .setParameter(20, iotdtcRecepcionSchemaIdsgd.getVuniorgstd())
         .setParameter(21, iotdtcRecepcionSchemaIdsgd.getVusumod())
         .setParameter(22, iotdtcRecepcionSchemaIdsgd.getVusuregstd())
         .executeUpdate();
    	
    	 return result;
    }*/
  
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
