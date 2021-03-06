/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.actions;

import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.Expediente;
import com.btg.ositran.siged.domain.Supervisor;
import com.btg.ositran.siged.domain.Usuario;
import com.opensymphony.xwork2.Action;
import java.util.List;

import org.apache.log4j.Logger;
import org.ositran.services.SupervisorService;
import org.ositran.utils.Constantes;

public class SupervisorAction {

   private static Logger log = Logger.getLogger(SupervisorAction.class);
   private SupervisorService supervisorService;
   private List<Supervisor> list;
   private Supervisor supervisor;
   private Integer iIdDocumento;
   private Integer iIdUsuario;
   private Integer iIdExpediente;
   private String sNroCaja;

   public String enviarSolicitud() throws Exception {

      log.debug("org.ositran.actions.SupervisorAction::::enviarSolicitud");
//		String Striddoc = ServletActionContext.getRequest().getParameter("paran1");
//		String Stridusu = ServletActionContext.getRequest().getParameter("paran2");
//		String Stridpro = ServletActionContext.getRequest().getParameter("paran3");
//		String Strnrocaja = ServletActionContext.getRequest().getParameter("nrocaja");
//		int intiddoc = Integer.parseInt(Striddoc);
//		int intidusu = Integer.parseInt(Stridusu);
//		int intidpro = Integer.parseInt(Stridpro);

      Supervisor supervisor = new Supervisor();

      Expediente expediente = new Expediente();
      Documento documento = new Documento();
      Usuario usuario = new Usuario();

      log.debug("Documento con ID [" + iIdDocumento + "]");
      log.debug("Usuario con ID [" + iIdUsuario + "]");
      log.debug("Expediente con ID [" + iIdExpediente + "]");
      log.debug("Nro Caja [" + sNroCaja + "]");

      expediente.setIdexpediente(iIdExpediente);
      supervisor.setExpediente(expediente);
      documento.setIdDocumento(iIdDocumento);
      supervisor.setDocumento(documento);
      usuario.setIdusuario(iIdUsuario);
      supervisor.setUsuario(usuario);
      supervisor.setCaja(sNroCaja);
      setSupervisor(supervisor);

      return "solicitar";
   }

   public String save() throws Exception {

      log.debug("org.ositran.actions.SupervisorAction::::save");
      try {

//			String Striddoc = ServletActionContext.getRequest().getParameter("paran1");
//			String Stridusu = ServletActionContext.getRequest().getParameter("paran2");
//			String Stridpro = ServletActionContext.getRequest().getParameter("paran3");
//			String Strnrocaja = ServletActionContext.getRequest().getParameter("nrocaja");
//			int intiddoc = Integer.parseInt(Striddoc);
//			int intidusu = Integer.parseInt(Stridusu);
//			int intidpro = Integer.parseInt(Stridpro);

         log.debug("Documento con ID [" + iIdDocumento + "]");
         log.debug("Usuario con ID [" + iIdUsuario + "]");
         log.debug("Expediente con ID [" + iIdExpediente + "]");
         log.debug("Nro Caja [" + sNroCaja + "]");

         Supervisor supervisor = new Supervisor();

         Expediente expediente = new Expediente();
         Documento documento = new Documento();
         Usuario usuario = new Usuario();

         expediente.setIdexpediente(iIdExpediente);
         supervisor.setExpediente(expediente);
         documento.setIdDocumento(iIdDocumento);
         supervisor.setDocumento(documento);
         usuario.setIdusuario(iIdUsuario);
         supervisor.setUsuario(usuario);
         supervisor.setCaja(sNroCaja);
         supervisor.setEstado(Constantes.ESTADO_ACTIVO);

         getSupervisorService().saveSupervisor(supervisor);

         return "solicitar";

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         return Action.ERROR;
      }
   //return "solicitar";

   }

   public SupervisorService getSupervisorService() {
      return supervisorService;
   }

   public void setSupervisorService(SupervisorService supervisorService) {
      this.supervisorService = supervisorService;
   }

   public List<Supervisor> getList() {
      return list;
   }

   public void setList(List<Supervisor> list) {
      this.list = list;
   }

   public Supervisor getSupervisor() {
      return supervisor;
   }

   public void setSupervisor(Supervisor supervisor) {
      this.supervisor = supervisor;
   }

   public Integer getIIdDocumento() {
      return iIdDocumento;
   }

   public void setIIdDocumento(Integer iIdDocumento) {
      this.iIdDocumento = iIdDocumento;
   }

   public Integer getIIdUsuario() {
      return iIdUsuario;
   }

   public void setIIdUsuario(Integer iIdUsuario) {
      this.iIdUsuario = iIdUsuario;
   }

   public Integer getIIdExpediente() {
      return iIdExpediente;
   }

   public void setIIdExpediente(Integer iIdExpediente) {
      this.iIdExpediente = iIdExpediente;
   }

   public String getSNroCaja() {
      return sNroCaja;
   }

   public void setSNroCaja(String sNroCaja) {
      this.sNroCaja = sNroCaja;
   }
}
