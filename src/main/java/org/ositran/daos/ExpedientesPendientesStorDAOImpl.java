/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.btg.ositran.siged.domain.ExpedientesPendientesStor;

public class ExpedientesPendientesStorDAOImpl implements
		ExpedientesPendientesStorDAO {
	    private EntityManager em;

	@PersistenceContext(unitName="sigedPU")
	public void setEm(EntityManager em) {
		   this.em = em;
	}

	private static Logger _log  =  Logger.getLogger(ExpedientesPendientesStorDAOImpl.class);
	
	@Override
	public List<ExpedientesPendientesStor> listarTodo() {
		// TODO Auto-generated method stub
		String sQuery = "SELECT f FROM ExpedientesPendientesStor f order by f.expediente";
		Query obj = em.createQuery(sQuery);
		return obj.getResultList();
	}

	public List<ExpedientesPendientesStor> generarLista(String fechaDesde, String fechaHasta){
		
		String sQuery = "SELECT f FROM ExpedientesPendientesStor f ";
		SimpleDateFormat fechita = new SimpleDateFormat("dd/MM/yyyy");
		/**FLAG PARA VER SI SE COLOCA EL WHERE**/
		boolean where = false;
		//----FECHAS-------------------------------------------------------------
		if(!fechaDesde.equals("")){
			sQuery += "WHERE f.fechaUltimoMovimiento >= :campofechadesde ";
			where = true;	
		}
		if(!fechaHasta.equals("")){
			if(!where){
				sQuery += "WHERE (f.fechaUltimoMovimiento <= :campofechahasta ";
				where = true;	
			}else{
				sQuery += "AND f.fechaUltimoMovimiento <= :campofechahasta) OR f.fechaUltimoMovimiento is null";
			}
		}
		//-----------------------------------------------------------------------
		Query obj = em.createQuery(sQuery);
		//----FECHAS-------------------------------------------------------------
		if(!fechaDesde.equals("")){
			try{
				Date datFecha=fechita.parse(fechaDesde);
				_log.debug("Fecha Desde ["+datFecha+"]");
				obj.setParameter("campofechadesde",datFecha);
			}catch(Exception ex){
				_log.error(ex.getMessage(),ex);
			}
		}
		if(!fechaHasta.equals("")){
			try{
				Date datFecha=fechita.parse(fechaHasta);
				datFecha.setHours(24);
				datFecha.setMinutes(0);
				datFecha.setSeconds(0);
				_log.debug("Fecha Hasta ["+datFecha+"]");
				obj.setParameter("campofechahasta",datFecha);
			}catch(Exception ex){
				_log.error(ex.getMessage(),ex);
			}
		}
		return obj.getResultList();
	}
}
