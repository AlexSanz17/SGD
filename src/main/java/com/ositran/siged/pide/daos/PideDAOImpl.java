package com.ositran.siged.pide.daos;

import com.btg.ositran.pide.domain.PideIotdtcRecepcion;
import com.btg.ositran.pide.domain.PideIotdtdAnexo;
import com.btg.ositran.pide.domain.PideIotdtdDocPrincipal;
import com.btg.ositran.pide.domain.PideIotdtmDocExterno;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vcupe
 */

public class PideDAOImpl implements PideDAO{
    
    private EntityManager em;
     
    @PersistenceContext(unitName="pidePU")
    public void setEm(EntityManager em){
	this.em=em;
    }
    
    @SuppressWarnings("unchecked")
	public List<PideIotdtcRecepcion> findRecepcionByEstado(String estado) {
        
        String sql = "SELECT e FROM PideIotdtcRecepcion e WHERE e.cflgest = :estado " +
					 " ORDER BY e.dfecreg ASC";

        return em.createQuery(sql).setParameter("estado", estado)
			          .getResultList();
    }
    

    @SuppressWarnings("unchecked")
	public List<PideIotdtmDocExterno> findDocExternosByIdRecepcion(Integer sidrecext) {
        
        String sql = "SELECT e FROM PideIotdtmDocExterno e WHERE e.sidrecext.sidrecext = :sidrecext ";

        return em.createQuery(sql).setParameter("sidrecext", sidrecext)
			          .getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
   	public List<PideIotdtdDocPrincipal> findDocPrincipalByIdExterno(Integer siddocext) {
           
           String sql = "SELECT e FROM PideIotdtdDocPrincipal e WHERE e.siddocext.siddocext = :siddocext ";

           return em.createQuery(sql).setParameter("siddocext", siddocext)
   			          .getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
   	public List<PideIotdtdAnexo> findAnexoByIdExterno(Integer siddocext) {
           
           String sql = "SELECT e FROM PideIotdtdAnexo e WHERE e.siddocext.siddocext = :siddocext ";

           return em.createQuery(sql).setParameter("siddocext", siddocext)
   			          .getResultList();
    }
    
    
    
    /*
    public SeguimientoXFirma guardarSeguimiento(SeguimientoXFirma seguimiento) {
          	
        if(seguimiento.getIdSeguimientoFirma() == null){
            em.persist(seguimiento);
	    em.flush();
	    em.refresh(seguimiento);
        }else{
	    em.merge(seguimiento);
	    em.flush();
	    em.refresh(seguimiento);
	}
	
        return seguimiento;
    }
    */
}
