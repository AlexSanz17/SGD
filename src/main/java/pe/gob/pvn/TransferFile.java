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
import java.net.InetSocketAddress;
public class TransferFile {
	private String PROXY_HOST = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_HOST);
	private String PROXY_PORT = SigedProperties
			.getProperty(SigedProperties.SigedPropertyEnum.PROXY_PORT);
	FTPHTTPClient ftp = null;
	
	public TransferFile(String host, String user, String pwd) throws Exception{
//		ftp = new FTPClient();
		ftp = new FTPHTTPClient(PROXY_HOST, Integer.valueOf(PROXY_PORT));
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
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
		System.out.println("-----------reply-------------" +reply);
	}
	public void uploadFile(String localFileFullName, String fileName, String hostDir)
			throws Exception {
		try(InputStream input = new FileInputStream(new File(localFileFullName))){
		this.ftp.storeFile(hostDir + fileName, input);
		}
	}

	public void disconnect(){
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				f.printStackTrace();
				// do nothing as file is already saved to server
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println("Start");
		TransferFile1 ftpUploader = new TransferFile1("www.sofisisperu.com", "sofisisp", "6nFd24adT0");
		//FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload 
		// files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
		ftpUploader.uploadFile("\\\\\\\\WWWD4\\\\Documentos\\\\Firmados\\\\2022001313_ANX_PRUEBA.01.pdf", "prueba_01.pdf", "/public_html/sgd/");
		ftpUploader.disconnect();
		System.out.println("Done");
	}


}
