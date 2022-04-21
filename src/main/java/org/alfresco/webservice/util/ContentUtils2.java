package org.alfresco.webservice.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.alfresco.webservice.content.Content;
import org.springframework.util.FileCopyUtils;

public class ContentUtils2 {   
    public static final int BUFFER_SIZE = 4096;

    public static byte[] convertToByteArray(InputStream inputStream) throws Exception
    {
        byte[] result = null;
        
        if (inputStream.available() > 0)
        {
            result = new byte[inputStream.available()];        
            inputStream.read(result);;
        }     
        
        return result;
    }

    public static String getContentAsString(Content content) {
        // Get the url and the ticket
        String ticket = AuthenticationUtils.getTicket();
        String strUrl = content.getUrl() + "?ticket=" + ticket;
        
        StringBuilder readContent = new StringBuilder();
        try
        {
            // Connect to donwload servlet            
            URL url = new URL(strUrl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            int read = is.read();
            while (read != -1)
            {
               readContent.append((char)read);
               read = is.read();
            }
        }
        catch (Exception exception)
        {
            throw new WebServiceException("Unable to get content as string.", exception);
        }
        
        // return content as a string
        return readContent.toString();
    }

    public static InputStream getContentAsInputStream(Content content) {
        // Get the url and the ticket
        String ticket = AuthenticationUtils.getTicket();
        String strUrl = content.getUrl() + "?ticket=" + ticket;
 
        try
        {
            // Create the url connection to the download servlet            
            URL url = new URL(strUrl);
            URLConnection conn = url.openConnection();
            
            // Set the cookie information
            conn.setRequestProperty("Cookie", "JSESSIONID=" + AuthenticationUtils.getAuthenticationDetails().getSessionId() + ";");
            
            // Return the input stream
            return conn.getInputStream();
        }
        catch (Exception exception)
        {
            throw new WebServiceException("Unable to get content as inputStream.", exception);
        }
    }

    public static String putContent(File file) {
        return putContent(file, WebServiceFactory.getHost(), WebServiceFactory.getPort(), null, null);
    }

    public static String putContent(File file, String host, int port) {
        return putContent(file, host, port, null, null);
    }

    @SuppressWarnings("deprecation")
    public static String putContent(File file, String host, int port, String mimetype, String encoding) {      
        String result = null;
        
        try 
        {
            String url = "/alfresco/upload/" + 
                         URLEncoder.encode(file.getName(), "UTF-8") + 
                         "?ticket=" + AuthenticationUtils.getTicket();
            if (mimetype != null)
            {
                url = url + "&mimetype=" + mimetype;
            }
            if (encoding != null)
            {
                url += "&encoding=" + encoding;
            }
            
            String request = "PUT " + url + " HTTP/1.1\n" +
                          "Cookie: JSESSIONID=" + AuthenticationUtils.getAuthenticationDetails().getSessionId() + ";\n" + 
                          "Content-Length: " + file.length() + "\n" +
                          "Host: " + host + ":" + port + "\n" +
                          "Connection: Keep-Alive\n" +
                          "\n";
            
            // Open sockets and streams
            Socket socket = new Socket(host, port);
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            DataInputStream is = new DataInputStream(socket.getInputStream());
            InputStream fileInputStream = new FileInputStream(file);
            try {
                // Write the request header
                os.write(request.getBytes());        
                // Stream the content onto the server
//                int byteCount = 0;
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) 
                {
                    os.write(buffer, 0, bytesRead);
//                    byteCount += bytesRead;
                }
                os.flush();
            
                // Read the response and deal with any errors that might occur
                boolean firstLine = true;
                String responseLine;
                while ((responseLine = is.readLine()) != null) 
                {
                    if (firstLine == true)
                    {
                        if (responseLine.contains("200") == true)
                        {
                            firstLine = false;
                        }
                        else if (responseLine.contains("401") == true)
                        {
                            throw new RuntimeException("Content could not be uploaded because invalid credentials have been supplied.");
                        }
                        else if (responseLine.contains("403") == true)
                        {
                            throw new RuntimeException("Content could not be uploaded because user does not have sufficient priveledges.");
                        }
                        else
                        {
                            throw new RuntimeException("Error returned from upload servlet (" + responseLine + ")");
                        }
                    }
                    else if (responseLine.contains("contentUrl") == true)
                    {
                        result = responseLine;
                        break;
                    }
                }      
            } finally {       
                fileInputStream.close();
                os.close();
                is.close();
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error writing content to repository server", e);
        } 
        
        return result;
    }

    public static void copyContentToFile(Content content, File file) {
        try {
            FileOutputStream os = new FileOutputStream(file);
            FileCopyUtils.copy(getContentAsInputStream(content), os);
        }
        catch (IOException exception) {
            throw new WebServiceException("Unable to copy content into file.", exception);
        }
    }

    public static int copy(InputStream in, OutputStream out) throws IOException {
        try {
            int byteCount = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) 
            {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            out.flush();
            return byteCount;
        }
        finally {
            try {
                in.close();
            }
            catch (IOException ex) {
                // Could not close input stream
            }
            try {
                out.close();
            }
            catch (IOException ex) {
                // Could not close output stream
            }
        }
    }
}