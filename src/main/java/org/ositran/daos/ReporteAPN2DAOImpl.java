/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.btg.ositran.siged.domain.ExpedientesPendientesStor;
import com.btg.ositran.siged.domain.FilaReporteAPN2;

public class ReporteAPN2DAOImpl implements ReporteAPN2DAO{
	private static Logger log = Logger.getLogger(ReporteAPN2DAOImpl.class);
	private EntityManager em;
	
	
	@PersistenceContext(unitName = "sigedPU")
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FilaReporteAPN2> getListaReporteAPN2(String area,
			String tipodocumento, String prioridad) {
		
		Integer area_=0;
		Integer prioridad_=0;
		Integer tipodocumento_ =0;	
		
		String sQuery = "SELECT f FROM FilaReporteAPN2 f ";
		boolean flagWhere = false;
		
		
		if(!((area.toString().trim()).equals("Todos"))){
			area_= Integer.parseInt(area.toString().trim());
			sQuery += "WHERE f.idUnidad like :area ";
			flagWhere=true;
		}
		
		if(!((tipodocumento.toString().trim()).equals("Todos"))){
			tipodocumento_= Integer.parseInt(tipodocumento.toString().trim());
			if(flagWhere){
				sQuery +="AND f.idTipoDocumento like :tipodocumento ";
			}else{
				sQuery +="WHERE f.idTipoDocumento like :tipodocumento ";
				flagWhere = true;
			}
		}

		if(!((prioridad.toString().trim()).equals("Todos"))){
			prioridad_= Integer.parseInt(prioridad.toString().trim());
			if(flagWhere){
				sQuery +="AND f.prioridad like :prioridad ";
			}else{
				sQuery +="WHERE f.prioridad like :prioridad ";
				flagWhere = true;
			}
		}
		
		
		//-----------------------------------------------------
		Query obj = em.createQuery(sQuery);
		//-----------------------------------------------------
		
		if(!((area.toString().trim()).equals("Todos"))){
			obj.setParameter("area", area_);
		}
		if(!((tipodocumento.toString().trim()).equals("Todos"))){
			obj.setParameter("tipodocumento", tipodocumento_);
		}
		if(!((prioridad.toString().trim()).equals("Todos"))){
			obj.setParameter("prioridad", prioridad_);
		}
		
		return obj.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FilaReporteAPN2> getListaReporteAPN3(String area,
			String tipodocumento, String fechaDesde, String fechaHasta) {
		Integer area_=0;
		Integer tipodocumento_ =0;	
		Date fechaDesde_ = null;
		Date fechaHasta_ = null;
		SimpleDateFormat fechita = new SimpleDateFormat("dd/MM/yyyy");
		String sQuery = "SELECT f FROM FilaReporteAPN2 f ";
		boolean flagWhere = false;
		
		
		if(!((area.toString().trim()).equals("Todos"))){
			area_= Integer.parseInt(area.toString().trim());
			sQuery += "WHERE f.idUnidad like :area ";
			flagWhere=true;
		}
		
		if(!((tipodocumento.toString().trim()).equals("Todos"))){
			tipodocumento_= Integer.parseInt(tipodocumento.toString().trim());
			if(flagWhere){
				sQuery +="AND f.idTipoDocumento like :tipodocumento ";
			}else{
				sQuery +="WHERE f.idTipoDocumento like :tipodocumento ";
				flagWhere = true;
			}
		}
		if(!((fechaDesde.toString().trim()).equals("Todos"))){
			try {
				fechaDesde_= fechita.parse(fechaDesde);
				
				fechaHasta_= fechita.parse(fechaHasta);
				fechaHasta_.setHours(24);
				fechaHasta_.setMinutes(0);
				fechaHasta_.setSeconds(0);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(flagWhere){
				sQuery +="AND f.fechaCreacion >= :fechaDesde AND f.fechaCreacion <= :fechaHasta ";
			}else{
				sQuery +="WHERE f.fechaCreacion >= :fechaDesde AND f.fechaCreacion <= :fechaHasta ";
				flagWhere = true;
			}
		}		
		
		//-----------------------------------------------------
		Query obj = em.createQuery(sQuery);
		//-----------------------------------------------------
		
		if(!((area.toString().trim()).equals("Todos"))){
			obj.setParameter("area", area_);
		}
		if(!((tipodocumento.toString().trim()).equals("Todos"))){
			obj.setParameter("tipodocumento", tipodocumento_);
		}
		if(!((fechaDesde.toString().trim()).equals("Todos"))){
			obj.setParameter("fechaDesde", fechaDesde_);
		}
		if(!((fechaHasta.toString().trim()).equals("Todos"))){
			obj.setParameter("fechaHasta", fechaHasta_);
		}
		return obj.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<ExpedientesPendientesStor> getListaReporteAPN4(String estado,
			String usuario) {
		//Integer estado_=0;
		//Integer usuario_ =0;	
		
		String sQuery = "SELECT f FROM ExpedientesPendientesStor f ";
		/*boolean flagWhere = false;
		
		
		if(!((estado.toString().trim()).equals("Todos"))){
			estado_= Integer.parseInt(estado.toString().trim());
			sQuery += "WHERE f.estado like :estado ";
			flagWhere=true;
		}
		
		if(!((usuario.toString().trim()).equals("Todos"))){
			usuario_ = Integer.parseInt(usuario.toString().trim());
			if(flagWhere){
				sQuery +="AND f.idTipoDocumento like :tipodocumento ";
			}else{
				sQuery +="WHERE f.idTipoDocumento like :tipodocumento ";
				flagWhere = true;
			}
		}
		*/
		
		//-----------------------------------------------------
		Query obj = em.createQuery(sQuery);
		//-----------------------------------------------------
		/*
		if(!((estado.toString().trim()).equals("Todos"))){
			obj.setParameter("area", estado_);
		}
		if(!((usuario.toString().trim()).equals("Todos"))){
			obj.setParameter("tipodocumento", usuario_);
		}
        */
		return obj.getResultList();
	}

}
