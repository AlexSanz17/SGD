/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.ajax.ubigeo.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.ositran.ajax.beans.AnalistaStor;
import org.ositran.ajax.beans.RevisorLegalStor;
import org.ositran.ajax.beans.RevisorTecnicoStor;
import org.ositran.ajax.beans.analista;
import org.ositran.ajax.beans.carpeta;
import org.ositran.ajax.beans.concesionario;
import org.ositran.ajax.beans.departamento;
import org.ositran.ajax.beans.destinatario;
import org.ositran.ajax.beans.distrito;
import org.ositran.ajax.beans.estadocargo;
import org.ositran.ajax.beans.motivo;
import org.ositran.ajax.beans.proceso;
import org.ositran.ajax.beans.provincia;
import org.ositran.ajax.beans.sala;
import org.ositran.ajax.beans.solicitante;
import org.ositran.ajax.beans.submotivo;
import org.ositran.ajax.beans.tipodocumento;
import org.ositran.ajax.beans.tipoidentificacion;
import org.ositran.ajax.beans.unidadpeso;
import org.ositran.ajax.beans.unidad;
import org.ositran.ajax.beans.region;
import org.ositran.ajax.beans.anio;
import org.ositran.ajax.beans.mes;
import org.ositran.utils.UsuarioStor;

import com.btg.ositran.siged.domain.Anio;
import com.btg.ositran.siged.domain.Carpeta;
import com.btg.ositran.siged.domain.Cliente;
import com.btg.ositran.siged.domain.Concesionario;
import com.btg.ositran.siged.domain.Departamento;
import com.btg.ositran.siged.domain.Distrito;
import com.btg.ositran.siged.domain.Estadocargo;
import com.btg.ositran.siged.domain.Mes;
import com.btg.ositran.siged.domain.Motivo;
import com.btg.ositran.siged.domain.Proceso;
import com.btg.ositran.siged.domain.Provincia;
import com.btg.ositran.siged.domain.Sala;
import com.btg.ositran.siged.domain.Submotivo;
import com.btg.ositran.siged.domain.Tipodocumento;
import com.btg.ositran.siged.domain.Tipoidentificacion;
import com.btg.ositran.siged.domain.Unidad;
import com.btg.ositran.siged.domain.Unidadpeso;
import com.btg.ositran.siged.domain.Usuario;

public class DAOMapeo {

   private static Logger log = Logger.getLogger(DAOMapeo.class);

   public static List ObtenerSalas(List<Sala> lstS) throws Exception {
      List lista = new ArrayList();

      for (Sala objS : lstS) {
         sala objs = new sala();
         objs.setIdsala(String.valueOf(objS.getIdsala()));
         objs.setSala(objS.getNombre());
         lista.add(objs);
      }

      return lista;
   }

   public static List ObtenerMotivos(List<Motivo> lstM) throws Exception {
      List lista = new ArrayList();

      for (Motivo objM : lstM) {
         motivo objm = new motivo();
         objm.setIdmotivo(String.valueOf(objM.getIdmotivo()));
         objm.setNmotivo(objM.getDescripcion());
         lista.add(objm);
      }

      return lista;
   }

   public static List ObtenerSubmotivos(List<Submotivo> lstSM) throws Exception {
      List lista = new ArrayList();

      for (Submotivo objSM : lstSM) {
         submotivo objsm = new submotivo();
         objsm.setIdsubmotivo(String.valueOf(objSM.getIdsubmotivo()));
         objsm.setNsubmotivo(objSM.getDescripcion());
         lista.add(objsm);
      }

      return lista;
   }

   public static List ObtenerDepartamentos(List<Departamento> lstD) throws Exception {
      List lista = new ArrayList();

      for (Departamento objD : lstD) {
         departamento objd = new departamento();
         objd.setIddepartamento(String.valueOf(objD.getIddepartamento()));
         objd.setDepartamento(objD.getNombre());
         lista.add(objd);
      }

      return lista;
   }

   public static List ObtenerProvincias(List<Provincia> lstP) throws Exception {
      List lista = new ArrayList();

      for (Provincia objP : lstP) {
         provincia objp = new provincia();
         objp.setIdprovincia(String.valueOf(objP.getIdprovincia()));
         objp.setProvincia(objP.getNombre());
         lista.add(objp);
      }

      return lista;
   }

   public static List ObtenerDistritos(List<Distrito> lstD) throws Exception {
      List lista = new ArrayList();

      for (Distrito objD : lstD) {
         distrito objd = new distrito();
         objd.setIddistrito(String.valueOf(objD.getIddistrito()));
         objd.setDistrito(objD.getNombre());
         lista.add(objd);
      }

      return lista;
   }

   public static List ObtenerProcesos(List<Proceso> lstP) throws Exception {
      List lista = new ArrayList();

      for (Proceso objP : lstP) {
         proceso objp = new proceso();
         objp.setIdproceso(String.valueOf(objP.getIdproceso()));
         objp.setproceso(objP.getNombre());
         lista.add(objp);
      }

      return lista;
   }

   public static List ObtenerConcesionarios(List<Concesionario> lstC) throws Exception {
      List lista = new ArrayList();

      for (Concesionario objC : lstC) {
         concesionario objc = new concesionario();
         objc.setIdconcesionario(String.valueOf(objC.getIdConcesionario()));
         objc.setConcesionario(objC.getRazonSocial());
         lista.add(objc);
      }

      return lista;
   }

   public static List ObtenerTipoDocumentos(List<Tipodocumento> lstTD) throws Exception {
      List lista = new ArrayList();

      for (Tipodocumento objTD : lstTD) {
         tipodocumento objtd = new tipodocumento();
         objtd.setIdtipodocumento(String.valueOf(objTD.getIdtipodocumento()));
         objtd.settipodocumento(objTD.getNombre());
         lista.add(objtd);
      }

      return lista;
   }

   public static List ObtenerTipoIdentificacion(List<Tipoidentificacion> lstTI) throws Exception {
      List lista = new ArrayList();

      for (Tipoidentificacion objTI : lstTI) {
         tipoidentificacion objti = new tipoidentificacion();
         objti.setIdtipoidentificacion(String.valueOf(objTI.getIdtipoidentificacion()));
         objti.settipoidentificacion(objTI.getNombre());
         lista.add(objti);
      }

      return lista;
   }

   public static List ObtenerNroIdentificacion(List<Cliente> lstS) throws Exception {
      List lista = new ArrayList();

      for (Cliente objS : lstS) {
         solicitante objs = new solicitante();
         objs.setNroidentificacion(objS.getNumeroIdentificacion());
         lista.add(objs);
      }

      return lista;
   }

   public static List ObtenerDestinatario(List<Usuario> lstU) throws Exception {
      List lista = new ArrayList();

      for (Usuario objU : lstU) {
         destinatario obju = new destinatario();
         obju.setIddestinatario(objU.getIdusuario().toString());
         obju.setdestinatario(objU.getNombres() + " " + objU.getApellidos());
         lista.add(obju);
      }

      return lista;
   }

   public static List ObtenerCCDestinatario(List<Usuario> lstU) throws Exception {
      List lista = new ArrayList();

      for (Usuario objU : lstU) {
         destinatario obju = new destinatario();
         obju.setIdccdestinatario(objU.getIdusuario().toString());
         obju.setCcdestinatario(objU.getNombres() + " " + objU.getApellidos());
         lista.add(obju);
      }

      return lista;
   }

   public static List AutocompletarAnalista(String name, List list) {
      List l = new ArrayList();

      for (Iterator iter = list.iterator(); iter.hasNext();) {
         analista u = (analista) iter.next();

         if (u.getAnalista().toLowerCase().startsWith(name.toLowerCase())) {
            l.add(u);
         }
      }

      return l;
   }

   public static List ObtenerAnalista(List<Usuario> lstU) throws Exception {
      List lista = new ArrayList();

      for (Usuario objU : lstU) {
         analista obju = new analista();
         obju.setIdanalista(objU.getIdusuario().toString());
         obju.setAnalista(objU.getNombres() + " " + objU.getApellidos());
         lista.add(obju);
      }

      return lista;
   }

   public static List obtenerUnidad(List<Unidad> unidadesList) {
      List lista = new ArrayList();

      for (Unidad unidadOb : unidadesList) {
         unidad obunidadAjax = new unidad();
         obunidadAjax.setIdUnidad(String.valueOf(unidadOb.getIdunidad()));
         obunidadAjax.setUnidad(unidadOb.getNombre());

         lista.add(obunidadAjax);
      }

      return lista;
   }

   public static List ObtenerRegion(List<Departamento> lstR) throws Exception {
      List lista = new ArrayList();

      for (Departamento objR : lstR) {
         region objr = new region();
         objr.setIdregion(String.valueOf(objR.getIddepartamento()));
         objr.setRegion(objR.getNombre());  
         lista.add(objr);
      }

      return lista;
   }

   public static List ObtenerAnio(List<Anio> lstA) throws Exception {
      List lista = new ArrayList();

      for (Anio objA : lstA) {
         anio obja = new anio();
         obja.setIdanio(String.valueOf(objA.getIdAnio()));
         obja.setAnio(String.valueOf(objA.getAnioferiado()));
         lista.add(obja);
      }

      return lista;
   }

   public static List ObtenerUnidadpeso(List<Unidadpeso> lstUn) throws Exception {
      List lista = new ArrayList();

      for (Unidadpeso objUn : lstUn) {
         unidadpeso objU = new unidadpeso();
         objU.setIdunidadpeso(String.valueOf(objUn.getIdunidadpeso()));
         objU.setNombreunidad(String.valueOf(objUn.getNombrepeso()));
         lista.add(objU);
      }

      return lista;
   }

   public static List ObtenerMes(List<Mes> lstM) throws Exception {
      List lista = new ArrayList();

      for (Mes objM : lstM) {
         mes objm = new mes();
         objm.setIdmes(String.valueOf(objM.getIdmes()));
         objm.setMes(objM.getMesferiado());
         lista.add(objm);
      }
      return lista;
   }

   public static List obtenerAnalistaStor(List<UsuarioStor> lstUS) throws Exception {
      List lista = new ArrayList();

      for (UsuarioStor objUS : lstUS) {
         /*UsuarioStorBeanAjax analistaStor1 = new UsuarioStorBeanAjax();
         analistaStor1.setIdUsuarioStor(String.valueOf(objUS.getIdusuario().intValue()));
         analistaStor1.setDescripcionUsuarioStor(objUS.getNombres()+" "+objUS.getApellidos());*/

         AnalistaStor analistaStor = new AnalistaStor();
         analistaStor.setIdanalista(String.valueOf(objUS.getIdusuario().intValue()));
         analistaStor.setAnalista(objUS.getNombres() + " " + objUS.getApellidos());

         lista.add(analistaStor);
      }
      return lista;
   }

   public static List obtenerRevisorTecnicoStor(List<Usuario> lstU) throws Exception {
      List lista = new ArrayList();
      for (Usuario objU : lstU) {
         /*UsuarioStorBeanAjax revisorTecnico1 = new UsuarioStorBeanAjax();
         revisorTecnico1.setIdUsuarioStor(objU.getIdusuario().toString());
         revisorTecnico1.setDescripcionUsuarioStor(objU.getNombres()+" "+objU.getApellidos());*/

         RevisorTecnicoStor revisorTecnicoStor = new RevisorTecnicoStor();
         revisorTecnicoStor.setIdrevisortecnico(objU.getIdusuario().toString());
         revisorTecnicoStor.setRevisortecnico(objU.getNombres() + " " + objU.getApellidos());
         lista.add(revisorTecnicoStor);
      }
      return lista;
   }

   public static List obtenerRevisorLegalStor(List<Usuario> lstU) throws Exception {
      List lista = new ArrayList();
      for (Usuario objU : lstU) {
         RevisorLegalStor revisorLegalStor = new RevisorLegalStor();
         revisorLegalStor.setIdrevisorlegal(objU.getIdusuario().toString());
         revisorLegalStor.setRevisorlegal(objU.getNombres() + " " + objU.getApellidos());
         lista.add(revisorLegalStor);
      }
      return lista;
   }

   public static List ObtenerEstadocargo(List<Estadocargo> lstEc) throws Exception {
      List lista = new ArrayList();

      for (Estadocargo objEc : lstEc) {
         estadocargo obec = new estadocargo();
         obec.setIdestadocargo(String.valueOf(objEc.getIdestadocargo()));
         obec.setEstadocargo(objEc.getNombreestado());
         lista.add(obec);
      }
      return lista;
   }
   public static List ObtenerCarpetas(List<Carpeta> lstEc) throws Exception {
	     
	   List lista = new ArrayList();

	      for (Carpeta objEc : lstEc) {
	    	 carpeta  obec = new carpeta();
	         obec.setIdcarpeta(String.valueOf(objEc.getIdcarpeta())); 
	         obec.setNombre(objEc.getNombre());  
	         lista.add(obec);    
	      }
	     
	      return lista;
	   }
   
}
