/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.ajax.beans;

import org.apache.commons.lang.builder.ToStringBuilder;

public class sala {

   private String idsala;
   private String sala;

   public String toString() {
      return new ToStringBuilder(this).append("idsala", getIdsala()).append("sala", getSala()).toString();
   }

   public String getIdsala() {
      return idsala;
   }

   public void setIdsala(String idsala) {
      this.idsala = idsala;
   }

   public String getSala() {
      return sala;
   }

   public void setSala(String sala) {
      this.sala = sala;
   }
}
