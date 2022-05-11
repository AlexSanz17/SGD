package org.pide.pcm.client.webservice;


public interface PcmCuoPortType extends java.rmi.Remote {

    /**
     * Retorna string CUO
     */
    public java.lang.String getCUOEntidad(java.lang.String ruc, java.lang.String servicio) throws java.rmi.RemoteException;

    /**
     * Retorna string CUO
     */
    public java.lang.String getCUO(java.lang.String ip) throws java.rmi.RemoteException;
}

