/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.ositran.utils.Constantes;

import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.NotificacionxEnumerar;

public class NotificacionxEnumerarDAOImpl implements NotificacionxEnumerarDAO{

	private EntityManager em;
	
	public void guardar(NotificacionxEnumerar notificacionxEnumerar){
            em.persist(notificacionxEnumerar);
            em.flush();
            em.refresh(notificacionxEnumerar);
	}

	public List<NotificacionxEnumerar> findByDocumento(Documento objDocumento, Integer tn){
		
		 List<NotificacionxEnumerar> data = em.createNamedQuery("NotificacionxEnumerar.findByAll")
		 .setParameter("iddocumento", objDocumento.getIdDocumento()) 
         .setParameter("tiponotificacion", tn)
         .getResultList();
		 return data;
	}
	

	   @Override
	   public List<NotificacionxEnumerar> buscarLastNotificacionesbyDocumento(Integer idDocumento, Integer tipoNotificacion) {
	  // "SELECT n FROM NotificacionxEnumerar n WHERE n.notificacionxenumerarPK.idusuario = :idusuario"),
		   
		   
		   String sQuery = "SELECT NEW NotificacionxEnumerar(" +   		 
	   		    "n.tiponotificacion," +
	   		    "n.usuario.nombres" +
	   		    ") ";
	   		sQuery += "FROM NotificacionxEnumerar n ";
	   		sQuery += "LEFT JOIN n.documento d ";
	   		sQuery += "LEFT JOIN n.usuario u ";
	   		sQuery += "WHERE n.notificacionxenumerarPK.iddocumento = :idDocumento" +
	   				
	   				" and n.notificacionxenumerarPK.iddocumento = " +
	   				"	(select MAX(n2.notificacionxenumerarPK.iddocumento) from NotificacionxEnumerar n2 " +
	   				"	WHERE n2.notificacionxenumerarPK.iddocumento = :idDocumento" +
	   				"	and n2.tiponotificacion = :tiponotificacion)";
	   		
	   		Query qQuery = em.createQuery(sQuery)
	   		     .setParameter("idDocumento", idDocumento)
	   			 .setParameter("tiponotificacion", tipoNotificacion);
	   		
	   		return qQuery.getResultList();
	   }
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
}
