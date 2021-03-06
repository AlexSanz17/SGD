/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.ajax.dwr;

import java.util.HashSet;
import java.util.Set;

public class SuministroSet {

   private Set<Suministro> setsuministro = new HashSet<Suministro>();
   private static int nextId = 1;

   //////////////////////////////////
   // Methods                      //
   //////////////////////////////////
   public Set<Suministro> getAllSuministro() {
      return getSetsuministro();
   }

   private static synchronized int getNextId() {
      return nextId++;
   }

   public void addSuministro(Suministro suministro) {
      if (suministro.getId() == -1) {
         suministro.setId(getNextId());
      }

      getSetsuministro().remove(suministro);
      getSetsuministro().add(suministro);
   }

   public void deleteSuministro(Suministro suministro) {
      getSetsuministro().remove(suministro);
   }

   //////////////////////////////////
   // Getters and Setters          //
   //////////////////////////////////
   public Set<Suministro> getSetsuministro() {
      return setsuministro;
   }

   public void setSetsuministro(Set<Suministro> setsuministro) {
      this.setsuministro = setsuministro;
   }
}
