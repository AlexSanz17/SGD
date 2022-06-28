package pe.gob.pvn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class Test2 {
	public static void main(String[] args) {
		String ruta = "[1448_20220607124124_1]2022001165_OFICIO_000125-2022-MTC-20.6.pdf";
		String p1[]  = ruta.split("]");
		System.out.println(p1[1]);
	}
	
}