/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.actions;

import com.opensymphony.xwork2.Action;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import org.apache.struts2.ServletActionContext;
import org.ositran.services.ExpedientestorService;
import org.ositran.utils.ExpedientebusStor;

public class ExpedientestorAction {

   //private static Logger log = Logger.getLogger("org.ositran.actions.CarpetabusquedaAction");
   
   private ExpedientestorService SvrEs;
   private List<ExpedientebusStor> lisEs;
   private ExpedientebusStor objEbs;


   //////////////////////////////////
   // Constructors                 //
   //////////////////////////////////

    public ExpedientestorAction() {

    }

    public ExpedientestorAction(ExpedientestorService SvrEs) {

        setSvrEs(SvrEs);

    }

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
    
    public String findbuscarpeta() throws IOException, ServletException {

      //String Strnomexp=ServletActionContext.getRequest().getParameter("");
      String NrDoc = getObjEbs().getExp_referencia();
      List<ExpedientebusStor> data = SvrEs.findSimple(NrDoc);

      setLisEs(data);
      
      RequestDispatcher rd = ServletActionContext.getServletContext().getRequestDispatcher("/pages/tramite/docBussimplestor.jsp");
      ServletActionContext.getRequest().setAttribute("data", rd);
      rd.forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());

      return Action.NONE;
   }

    public String findbusavanzada() throws IOException, ServletException {

      String Strnomexp=ServletActionContext.getRequest().getParameter("expediente");
      String sele1 =ServletActionContext.getRequest().getParameter("select1");
      String Strsumi =ServletActionContext.getRequest().getParameter("sumnistro");
      String sele2 =ServletActionContext.getRequest().getParameter("select4");
      String Strproce =ServletActionContext.getRequest().getParameter("proceso");
      String sele3 =ServletActionContext.getRequest().getParameter("select5");
      String Strconce =ServletActionContext.getRequest().getParameter("concesionaria");
      


      List<ExpedientebusStor> data = SvrEs.finavanzada(Strnomexp, sele1, Strsumi, sele2, Strproce, sele3, Strconce);

      setLisEs(data);

      RequestDispatcher rd = ServletActionContext.getServletContext().getRequestDispatcher("/pages/tramite/docBusqadvanstor.jsp");
      ServletActionContext.getRequest().setAttribute("data", rd);
      rd.forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());

      return Action.NONE;
   }

    //getter and setter
   
    public ExpedientestorService getSvrEs() {
        return SvrEs;
    }

   
    public void setSvrEs(ExpedientestorService SvrEs) {
        this.SvrEs = SvrEs;
    }

    
  

    /**
     * @return the objEbs
     */
    public ExpedientebusStor getObjEbs() {
        return objEbs;
    }

    /**
     * @param objEbs the objEbs to set
     */
    public void setObjEbs(ExpedientebusStor objEbs) {
        this.objEbs = objEbs;
    }

    /**
     * @return the lisEs
     */
    public List<ExpedientebusStor> getLisEs() {
        return lisEs;
    }

    /**
     * @param lisEs the lisEs to set
     */
    public void setLisEs(List<ExpedientebusStor> lisEs) {
        this.lisEs = lisEs;
    }
   
}
