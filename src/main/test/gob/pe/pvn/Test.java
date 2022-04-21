package gob.pe.pvn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class Test {

	public static void main() {
//		String variable = "N° 000011-2022-MTC/20.6";
//		int numero = variable.indexOf("/");
//		System.out.println(numero);}
		String sizeFile = String.valueOf(new File("https://mpvirtual.pvn.gob.pe/mpv_ws/10/2022/526/25643/NOTACREDITOE00167.pdf").length());
		System.out.println(sizeFile);
	}
    /**
     * This constructor initializes a new HTTP POST request with content type
     * is set to multipart/form-data
     *
     * @param requestURL
     * @param charset
     * @throws IOException
     */
   
    /**
     * Adds a header field to the request.
     *
     * @param name  - name of the header field
     * @param value - value of the header field
     */
   
  
}