package org.pide.pcm.client.webservice;

public interface PcmCuo extends javax.xml.rpc.Service {
    public java.lang.String getPcmCuoHttpsSoap11EndpointAddress();

    public org.pide.pcm.client.webservice.PcmCuoPortType getPcmCuoHttpsSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public org.pide.pcm.client.webservice.PcmCuoPortType getPcmCuoHttpsSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
