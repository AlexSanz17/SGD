package gob.ositran.siged.afresco.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class AlfrescoDownloadTest {
	public static void main(String[] args) {
//		downloadDocumentByID("http://cmd1:8080/alfresco/cmisatom", "admin", "alfresco", "6722bef4-ba1d-49e6-b32c-6aeb7468c2fa",
//			"alfresco_download_test.pdf", "\\\\WWWD4\\Documentos\\PorFirmar\\");
	}
	
	public static void downloadDocumentByID(String serverUrl, String username, String password ,String documentID,String fileName,String destinationFolder){
	  // default factory implementation
	  SessionFactory factory = SessionFactoryImpl.newInstance();
	  Map<String, String> parameter = new HashMap<String, String>();
	
	  // user credentials
	  parameter.put(SessionParameter.USER, username);
	  parameter.put(SessionParameter.PASSWORD, password);
	
	  // connection settings
	  parameter.put(SessionParameter.ATOMPUB_URL, serverUrl);
	  parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
	
	  // create session
	  Session session = factory.getRepositories(parameter).get(0).createSession();
//	  Folder root = session.getRootFolder();
       String    fullPath= destinationFolder + fileName;
       Document newDocument =  (Document) session.getObject(documentID);
       System.out.println(newDocument.getId());
       try {
    	System.out.println(newDocument.getContentStream());
        ContentStream cs = newDocument.getContentStream();
            BufferedInputStream in =new BufferedInputStream(cs.getStream());
                    FileOutputStream fos = new FileOutputStream(fullPath);
                    OutputStream bufferedOutputStream = new BufferedOutputStream(fos);
                    byte[] buf = new byte[1024];
                    int n=0;
                    while ((n=in.read(buf))>0)
                    {
                        bufferedOutputStream.write(buf,0,n);
                    }
        bufferedOutputStream.close();
                    fos.close();
                    in.close();
        }
       catch (Exception e) {
    	  e.printStackTrace(); 
       }
	}
}