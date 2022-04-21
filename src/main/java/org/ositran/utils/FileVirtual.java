package org.ositran.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class FileVirtual {
	public static long getFileSize(String filePath) {
	  HttpURLConnection conn = null;
	  try {
		URL url = new URL(filePath);
	    conn = (HttpURLConnection) url.openConnection();
	    return conn.getContentLengthLong();
	  } catch (IOException e) {
		  throw new RuntimeException(e);
	  } finally {
	    if (conn != null) {
	      conn.disconnect();
	    }
	  }
	}
		
	public static String readableFileSize(long size) {
	    if (size <= 0) {
	    	return "0";
	    }
	    
	    String[] units = new String[]{"B", "kB", "MB", "GB", "TB", "EB"};
	    int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
	    
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
}