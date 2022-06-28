package pe.gob.pvn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.json.simple.parser.ParseException;

import com.btg.ositran.siged.domain.utils.File;
import com.btg.ositran.siged.domain.utils.FileInputStream;
import com.btg.ositran.siged.domain.utils.FileOutputStream;
import com.btg.ositran.siged.domain.utils.InputStream;
import com.btg.ositran.siged.domain.utils.OutputStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

//package com.mkyong.io.file;

import java.io.IOException;
import java.nio.file.*;

public class Test {
	
	private static final String REMOTE_HOST = "https://www.sofisisperu.com";
    private static final String USERNAME = "sofisisp";
    private static final String PASSWORD = "6nFd24adT0";
    private static final int REMOTE_PORT = 22;
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;

    public static void main(String[] args) {

//        // local
//        String localFile = "\\\\Wwwd4\\d\\Documentos\\Firmados\\2022001313_ANX_PRUEBA.01.pdf";
//
//        // remote server
//        String remoteFile = "https://www.sofisisperu.com/sgd/";
//        File file = null;
//        Session jschSession = null;
//        System.out.println("Inicio del try");
//        try {
//
//            JSch jsch = new JSch();
//            jsch.setKnownHosts("/home/mkyong/.ssh/known_hosts");
//            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);
//
//            // authenticate using private key
//            // jsch.addIdentity("/home/mkyong/.ssh/id_rsa");
//
//            // authenticate using password
//            jschSession.setPassword(PASSWORD);
//
//            // 10 seconds session timeout
//            jschSession.connect(SESSION_TIMEOUT);
//
//            Channel sftp = jschSession.openChannel("sftp");
//
//            // 5 seconds timeout
//            sftp.connect(CHANNEL_TIMEOUT);
//
//            ChannelSftp channelSftp = (ChannelSftp) sftp;
//
//            // transfer file from local to remote server
//            channelSftp.put(localFile, remoteFile);
//
//            // download file from remote server to local
//            // channelSftp.get(remoteFile, localFile);
//
//            channelSftp.exit();
//            System.out.println("se guardo el archivo");
//
//        } catch (JSchException | SftpException e) {
//
//            e.printStackTrace();
//
//        } finally {
//            if (jschSession != null) {
//                jschSession.disconnect();
//            }
//        }
    	
    	InputStream in = new FileInputStream(new File(
                "C:\\Users\\Jainesh_Trivedi\\Desktop\\WAR\\AutohostDemo1_1145.war"));

        File f = new File("10.87.74.191\\C$\\IVS_Code\\tomcat\\apache-tomcat-7.0.57\\webapps\\AutohostDemo1_1145.war");
        f.createNewFile();
        OutputStream out = new FileOutputStream(f);
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);



        }
        in.close();
        out.close();



    }
}