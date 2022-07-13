package pe.gob.pvn;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPReply;

import gob.ositran.siged.config.SigedProperties;

import java.net.Proxy;
import java.net.SocketException;
import java.net.InetSocketAddress;

public class TransferFile {
//	private String PROXY_HOST = SigedProperties
//			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST);
//	private String PROXY_PORT = SigedProperties
//			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT);
	
	private static FTPClient ftp = null;
	
	public static void test(String infile, String outfile) throws Exception {
		System.out.println("Start");
		Integer connection = connection("www.sofisisperu.com", "sofisisp", "6nFd24adT0");
		System.out.println(connection);
		//FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload 
		// files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
		Boolean uploadFile = uploadFile("\\\\\\\\WWWD4\\\\Documentos\\\\Firmados\\\\" + infile, outfile, "/public_html/sgd/");
		System.out.println(uploadFile);
		disconnect();
		System.out.println("Done");
	}
	
	public static Integer connection(String host, String user, String pwd) throws Exception {
		ftp = new FTPClient();
//		ftp = new FTPHTTPClient(PROXY_HOST, Integer.valueOf(PROXY_PORT));
		try {
			ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int reply;
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, Integer.valueOf(PROXY_PORT)));
		
//		HTTPTunnelConnector connector = new HTTPTunnelConnector(proxyHost,proxyPort);
		
//		ftp.setProxy(proxy);
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(user, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		
		return reply;
	}
	
	public static Boolean uploadFile(String localFileFullName, String fileName, String hostDir)
			throws Exception {
		Boolean storeFile = null;
		
		try(InputStream input = new FileInputStream(new File(localFileFullName))){
			storeFile = ftp.storeFile(hostDir + fileName, input);
		}
		
		return storeFile;
	}

	public static void disconnect(){
		if (ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (IOException f) {
				f.printStackTrace();
				// do nothing as file is already saved to server
			}
		}
	}
}