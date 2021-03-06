/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ositran.utils.Buscarpeta;
import org.ositran.utils.Expedienfindadvance;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.CarpetaBusqueda;

@Repository
public class CarpetabusquedaDAOImpl implements CarpetabusquedaDAO {

   private EntityManager em;
   private static Log log=LogFactory.getLog(CarpetabusquedaDAOImpl.class);

   public List<CarpetaBusqueda> findAll() {
      return getEm().createNamedQuery("Carpetabusqueda.findAll").getResultList();
   }

   public CarpetaBusqueda findByIdcarpetabusqueda(int IdCarpetabusqueda) {

      return getEm().find(CarpetaBusqueda.class, IdCarpetabusqueda);

   }

   public CarpetaBusqueda saveCarpetaBuqueda(CarpetaBusqueda objCB) {
      if (objCB.getIdCarpetaBusqueda() == null) {
         getEm().persist(objCB);//Nuevo
         //getEm().flush();
         //getEm().refresh(objCB);
      } else {
         getEm().merge(objCB); //Actualizacion
         getEm().flush();
      }

      return objCB;
   }

   public List<Expedienfindadvance> findbycondicion(String condicion, java.util.Date fechainidoc, java.util.Date fechafindoc, java.util.Date fechainiexp, java.util.Date fechafinexp) {
      List<Expedienfindadvance> data = new ArrayList<Expedienfindadvance>();
      data = null;
      if (condicion.equals("")) {
      } else {
         String sql = "SELECT distinct NEW org.ositran.utils.Expedienfindadvance(" +
               "un.idunidad," +
               "un.nombre," +
               "u.idusuario," +
               "u.nombres," +
               "u.apellidos," +
               "p.idproceso," +
               "p.nombre," +
               "p.descripcion," +
               "ex.id," +
               "ex.nroexpediente," +
               "ex.fechacreacion," +
               "ex.asunto," +
               "ex.estado," +
               "ex.cliente.idCliente," +
               "ex.cliente.numeroIdentificacion," +
               "ex.cliente.razonSocial," +
               "ex.cliente.direccionPrincipal," +
               "ex.cliente.direccionAlternativa," +
               "ex.cliente.nombres," +
               "ex.cliente.apellidoPaterno," +
               "ex.cliente.apellidoMaterno," +
               "c.idConcesionario," +
               "c.razonSocial," +
               "c.direccion," +
               "d.idDocumento," +
               "d.numeroDocumento," +
               "d.asunto," +
               "d.numeroFolios," +
               "d.fechaCreacion," +
               "d.tipoDocumento.idtipodocumento," +
               "d.tipoDocumento.nombre," +
               "ex.cliente.tipoIdentificacion.nombre)" +
               " FROM Unidad un" +
               //" LEFT JOIN un.rolList r  " +
               " LEFT JOIN un.usuarios u  " +
               " LEFT JOIN u.procesosParticipante p " +
               " LEFT JOIN p.responsable res " +
               " LEFT JOIN res.unidad uni " +
               " LEFT JOIN p.expedienteList ex " +
               " LEFT JOIN ex.concesionario c  " +
               " LEFT JOIN ex.documentoList d  " +
               //" LEFT JOIN d.trazabilidaddocumentoList td  " +
               " WHERE  " + condicion;

         log.debug(" hql generated " + sql);
         log.debug(" condicion " + condicion);


         Query q = em.createQuery(sql);
         if (fechainidoc != null) {
            log.debug("Fecha Documento Inicio [" + fechainidoc + "]");
            log.debug("Fecha Documento Final [" + fechafindoc + "]");
            q.setParameter("fechainidoc", fechainidoc);
            q.setParameter("fechafindoc", fechafindoc);
         }
         if (fechainiexp != null) {
            log.debug("Fecha Expediente Inicio [" + fechainiexp + "]");
            log.debug("Fecha Expediente Final [" + fechafinexp + "]");
            q.setParameter("fechainiexp", fechainiexp);
            q.setParameter("fechafinexp", fechafinexp);
         }

         data = (List<Expedienfindadvance>) q.getResultList();

      }
      return data;
   }

   public List<Buscarpeta> findbycondicion2(String condicion) {
      List<Buscarpeta> data = new ArrayList<Buscarpeta>();
      data = null;
      if (condicion.equals("")) {
      } else {
         String sql = "SELECT NEW org.ositran.utils.Buscarpeta(" +
               "d.iddocumento," +
               "d.tipodocumento.nombre," +
               "d.nrodocumento," +
               "d.asunto," +
               "td.destinatario.nombres," +
               "d.fechacreacion)" +
               " FROM " +
               " Documento d  " +
               " JOIN d.trazabilidaddocumentoList td " +
               " WHERE " + condicion;

         data = (List<Buscarpeta>) em.createQuery(sql).getResultList();
      }
      return data;
   }

   public void deleteCarpetabusqueda(CarpetaBusqueda objcarbusq) {

      objcarbusq = getEm().getReference(CarpetaBusqueda.class, objcarbusq.getIdCarpetaBusqueda());
      getEm().remove(objcarbusq);

   }

   public List<CarpetaBusqueda> buscarLstPor(Integer iIdUsuario) {
    
      return em.createNamedQuery("Carpetabusqueda.findByIdUsuario")
               .setParameter("idusuario", iIdUsuario)
               .getResultList();
   }

   ////////////////////////
   // Getters and Setters
   ////////////////////////

   public EntityManager getEm() {
      return em;
   }

   @PersistenceContext(unitName="sigedPU")
   public void setEm(EntityManager em) {
      this.em = em;
   }
}
