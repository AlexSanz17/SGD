/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.ositran.utils.Constantes;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Notificacion;
import com.btg.ositran.siged.domain.Usuario;

@Repository
public class NotificacionDAOImpl implements NotificacionDAO {

   private static Logger _log = Logger.getLogger(NotificacionDAOImpl.class);
   private EntityManager em;

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
   public List<Notificacion> buscarLstPor(Integer iIdUsuario, Integer iTipoNotificacion) {
	   _log.debug("-> [DAO] NotificacionDAO - buscarLstPor():List<Notificacion> ");
	   
	   String sQuery = "SELECT NEW Notificacion(" +
                      "n.idnotificacion," +
                      "n.leido," +
                      "n.asunto," +
                      "n.fechanotificacion," +
                      "n.tiponotificacion," +
                      "d.idDocumento," +
                      "c.razonSocial," +
                      "e.nroexpediente," +
                      "p.nombre," +
                      "ti.nombre," +
                      "cl.razonSocial," +
                      "cl.nombres," +
                      "cl.apellidoPaterno," +
                      "cl.apellidoMaterno" +
                      ") ";
	   sQuery += "FROM Notificacion n ";
	   sQuery += "LEFT JOIN n.iddocumento d ";
	   sQuery += "LEFT JOIN n.idusuario u ";
	   sQuery += "LEFT JOIN d.expediente e ";
	   sQuery += "LEFT JOIN e.concesionario c ";
	   sQuery += "LEFT JOIN e.proceso p ";
	   sQuery += "LEFT JOIN e.cliente cl ";
	   sQuery += "LEFT JOIN cl.tipoIdentificacion ti ";
	   sQuery += "WHERE u.idusuario = :idusuario AND n.tiponotificacion = :tiponotificacion AND n.estado = 'A' ";
      sQuery += "ORDER BY n.fechanotificacion DESC";

      Query qQuery = em.createQuery(sQuery)
                       .setParameter("idusuario", iIdUsuario)
                       .setParameter("tiponotificacion", iTipoNotificacion);

      return qQuery.getResultList();
   }

   public List<Notificacion> buscarLstPor(Usuario usuario, Integer iTipoNotificacion, Character cLeido) {
	   _log.debug("-> [DAO] NotificacionDAO - buscarLstPor():List<Notificacion> ");
	   
	   return em.createNamedQuery("Notificacion.findByUsuarioAndTipoAndLeido")
               .setParameter("idusuario", usuario.getIdUsuarioPerfil())
               .setParameter("tipo", iTipoNotificacion)
               .setParameter("leido", cLeido)
               .setParameter("unidadPropietario", usuario.getIdUnidadPerfil())
               .setParameter("cargoPropietario", usuario.getIdFuncionPerfil())    
               .getResultList();
   }

   @SuppressWarnings("unchecked")
   public List<Notificacion> obtenerNotificacionesxUsuario(Integer iIdUsuario) {
	   _log.debug("-> [DAO] NotificacionDAO - obtenerNotificacionesxUsuario():List<Notificacion> ");
	   
	   String sQuery = "SELECT NEW Notificacion(" +
                      "n.idnotificacion," +
                      "n.leido," +
                      "n.asunto," +
                      "n.fechanotificacion," +
                      "n.tiponotificacion," +
                      "d.idDocumento," +
                      "p.descripcion" +
                      ") ";
	   sQuery += "FROM Notificacion n ";
	   sQuery += "LEFT JOIN n.iddocumento d ";
	   sQuery += "LEFT JOIN n.idusuario u, ";
	   sQuery += "Parametro p ";
	   sQuery += "WHERE p.valor = n.tiponotificacion AND p.tipo = 'tiponotificacion' AND u.idusuario = :idusuario AND n.tiponotificacion NOT IN(666, 669) AND n.estado = 'A' ";
	   sQuery += "ORDER BY n.fechanotificacion DESC";

	   Query qQuery = em.createQuery(sQuery)
                       .setParameter("idusuario", iIdUsuario);

	   return qQuery.getResultList();
   }

   public Integer obtenerCantidadNotificacionesxUsuario(Integer iIdUsuario) {
	   _log.debug("-> [DAO] NotificacionDAO - obtenerCantidadNotificacionesxUsuario():Integer ");
	   String q = " " +
	      " select count(*) from  (  "+
	      "		  select  n.* from notificacion n,documento d,usuario u    "+
	      "		  where (n.iddocumento=d.iddocumento and n.idusuario=u.idusuario)   "+
	      "		  and  (  (n.idusuario='" + iIdUsuario + "' and (n.estado='" + Constantes.ESTADO_ACTIVO + "' and n.leido='" + Constantes.ESTADO_NO_LEIDO + "'))  )  AND n.tiponotificacion NOT IN (666, 667, 668, 669) "+
	      " 	  )  noti  ";
	   
	   _log.debug(" obtenerCantidadNotificacionesxUsuario : "+q);    
         
	   return ((BigDecimal)em.createNativeQuery(q).getSingleResult()).intValue();
   }

   public Notificacion buscarObjPorID(Integer iIdNotificacion) {
	   _log.debug("-> [DAO] NotificacionDAO - buscarObjPorID():Notificacion ");
	   
      Notificacion objNotificacion = null;

      try {
         objNotificacion = em.find(Notificacion.class, iIdNotificacion);
         em.refresh(objNotificacion);
      } catch (EntityNotFoundException e) {
         _log.error(e.getMessage(), e);
      }

      return objNotificacion;
   }

   public Notificacion findObjByIdDocumento(Integer iIdDocumento) {
	   _log.debug("-> [DAO] NotificacionDAO - findObjByIdDocumento():Notificacion ");
	   
      Notificacion objNotificacion = null;

      try {
         return (Notificacion) em.createNamedQuery("Notificacion.findByIdDocumento")
                                 .setParameter("iddocumento", iIdDocumento)
                                 .getSingleResult();
      } catch (EntityNotFoundException e) {
         _log.error(e.getMessage(), e);
      }

      return objNotificacion;
   }

   public List<Notificacion> findLastNotificacionbyUsuario(Integer idDocumento,	Integer idUsuario) {
	   _log.debug("-> [DAO] NotificacionDAO - findLastNotificacionbyUsuario():List<Notificacion> ");
	   
	   List<Notificacion> listaNotificacion = new ArrayList<Notificacion>();
	      try {
	         return em.createNamedQuery("Notificacion.findLastNotificacionbyUsuario")
	                                 .setParameter("iddocumento", idDocumento)
	                                 .setParameter("idusuario", idUsuario)
	                                 .getResultList();
	      } catch (EntityNotFoundException e) {
	         _log.error(e.getMessage(), e);
	      }
	      return null;
   }
   
   public Notificacion saveNotificacion(Notificacion objNotificacion) {
	   _log.debug("-> [DAO] NotificacionDAO - saveNotificacion():Notificacion ");
	   
      if (objNotificacion.getIdnotificacion() == null) {
         em.persist(objNotificacion);
         em.flush();
         em.refresh(objNotificacion);
      } else {
         em.merge(objNotificacion);
         em.flush();
      }

      return objNotificacion;
   }

   /*El estado Activo determina los que aun no han sido leidos*/
   @Override
   public int nroNotificacionesNoLeidas(Usuario usuario) {
	   _log.debug("-> [DAO] NotificacionDAO - nroNotificacionesNoLeidas():int ");
	   
	   String q = 
		  " select distinct n.* from notificacion n,documento d,usuario u  "+
		  " where (n.iddocumento=d.iddocumento and n.idusuario=u.idusuario) and "+
		  "  (  "+
		  "   (n.idusuario='" + usuario.getIdusuario() + "'  and n.estado='" + Constantes.ESTADO_ACTIVO + "' "+
		  "    )) ";  
	   /*"select distinct n.* from notificacion n,documento d,usuario u " +
           "where (n.iddocumento=d.iddocumento and n.idusuario=u.idusuario) and " + // aca cambie el or por un and para unir las tablas px tmr al parecer jala todos los doc de otros usaurios si se pone el or 
           "(  " +
           " (n.idusuario='" + usuario.getIdusuario() + "' and n.estado='" + Constantes.ESTADO_ACTIVO + "')  or " +
           " (" + usuario.getIdusuario() + "=66" + "  and n.estado='" + Constantes.ESTADO_ACTIVO + "'))"; */
   	   return em.createNativeQuery(q, Notificacion.class).getResultList().size();
   }

   public Integer getNotificacionesNoLeidas(Integer iIdUsuario) {
	   _log.debug("-> [DAO] NotificacionDAO - getNotificacionesNoLeidas():Integer ");
	   
      return em.createNamedQuery("Notificacion.buscarNotificacionesNoLeidas")
               .setParameter("idusuario", iIdUsuario)
               .getResultList()
               .size();
   }
   
   @Override
   public List<Notificacion> buscarLastNotificacionesbyDocumento(Integer idDocumento, Integer tipoNotificacion) {
	   _log.debug("-> [DAO] NotificacionDAO - buscarLastNotificacionesbyDocumento():List<Notificacion> ");
	   
       String sQuery = "SELECT NEW Notificacion(" +
   		    "n.idnotificacion," +
   		    "n.fechanotificacion," +
   		    "n.asunto," +
   		    "n.contenido," +
   		    "n.tiponotificacion," +
   		    "n.estado," +
   		    "n.idusuario.nombres" +
   		    ") ";
   		sQuery += "FROM Notificacion n ";
   		sQuery += "LEFT JOIN n.iddocumento d ";
   		sQuery += "LEFT JOIN n.idusuario u ";
   		sQuery += "WHERE n.iddocumento.idDocumento = :idDocumento" +
   				" and n.tiponotificacion = :tiponotificacion " +
   				" and n.iddocumento.idDocumento = " +
   				"	(select MAX(n2.iddocumento.idDocumento) from Notificacion n2 " +
   				"	WHERE n2.iddocumento.idDocumento = :idDocumento" +
   				"	and n2.tiponotificacion = :tiponotificacion)";
   		
   		Query qQuery = em.createQuery(sQuery)
   		     .setParameter("idDocumento", idDocumento)
   			 .setParameter("tiponotificacion", tipoNotificacion);
   		
   		return qQuery.getResultList();
   }

   //////////////////////////////////
   // Getters and Setters          //
   //////////////////////////////////
   public EntityManager getEm() {
      return em;
   }

   @PersistenceContext(unitName="sigedPU")
   public void setEm(EntityManager em) {
      this.em = em;
   }
}
