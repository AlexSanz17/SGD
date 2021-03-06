/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.dojo;

public class NumeracionJSON {

   private Character tipo;
   private Character firmante;
   private Character destinatario;

   /*
    * Constructors
    */
   
   public NumeracionJSON() {
	   	
	}
   
   public NumeracionJSON(Character sTipo, Character sFirmante, Character sDestinatario) {
      this.tipo = sTipo;
      this.firmante = sFirmante;
      this.destinatario = sDestinatario;
   }

   /*
    * Getters & Setters
    */
   public Character getTipo() {
      return tipo;
   }

   public void setTipo(Character tipo) {
      this.tipo = tipo;
   }

   public Character getFirmante() {
      return firmante;
   }

   public void setFirmante(Character firmante) {
      this.firmante = firmante;
   }

   public Character getDestinatario() {
      return destinatario;
   }

   public void setDestinatario(Character destinatario) {
      this.destinatario = destinatario;
   }
}
