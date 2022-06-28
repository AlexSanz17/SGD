package com.ositran.ws;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.*;
import java.util.*;

import gob.ositran.siged.config.SigedProperties;

public class MyProxySelector extends ProxySelector {
	private String PROXY_HOST = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST);
	private String PROXY_ACTIVE = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_ACTIVE);
	private String PROXY_PORT = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT);
    @Override
    public List<Proxy> select(URI uri) 
    {
        System.out.println("select for " + uri.toString());
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, Integer.parseInt(PROXY_PORT)));
        ArrayList<Proxy> list = new ArrayList<Proxy>();
        list.add(proxy);
        return list;   
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.err.println("Connection to " + uri + " failed.");
    }
}
