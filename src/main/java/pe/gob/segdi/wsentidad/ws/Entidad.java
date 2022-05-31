/**
 * Entidad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsentidad.ws;

public interface Entidad extends java.rmi.Remote {
    public pe.gob.segdi.wsentidad.ws.EntidadBean[] getListaEntidad(int sidcatent) throws java.rmi.RemoteException;
    public java.lang.String validarEntidad(java.lang.String vrucent) throws java.rmi.RemoteException;
    public pe.gob.segdi.wsentidad.ws.EntidadBean2[] getListaEntidad2() throws java.rmi.RemoteException;
}
