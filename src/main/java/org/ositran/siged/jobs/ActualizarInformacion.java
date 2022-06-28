//package org.ositran.siged.jobs;
//
//
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Base64;
//
//import org.json.simple.parser.ParseException;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//
////package com.mkyong.io.file;
//
//import java.io.IOException;
//import java.nio.file.*;
//
//public class ActualizarInformacion {
//
//	private static final String REMOTE_HOST = "https://www.sofisisperu.com";
//    private static final String USERNAME = "sofisisp";
//    private static final String PASSWORD = "6nFd24adT0";
//    private static final int REMOTE_PORT = 22;
//    private static final int SESSION_TIMEOUT = 10000;
//    private static final int CHANNEL_TIMEOUT = 5000;
//
//    public static void main(String[] args) {
//
//        // local
//        String localFile = "\\\\Wwwd4\\d\\Documentos\\Firmados\\2022001313_ANX_PRUEBA.01.pdf";
//
//        // remote server
//        String remoteFile = "https://www.sofisisperu.com/sgd/";
//
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
//
//    }
//}