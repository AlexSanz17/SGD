package pe.gob.pvn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.json.simple.parser.ParseException;

public class Test {
	public static void main(String[] args) throws ParseException {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\User\\Downloads\\test.pdf"));
			String encodedString = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("C:\\Users\\User\\Downloads\\principal_01.pdf")));
//			System.out.println(bytes);
			
			byte[] encodedBytes = Base64.getEncoder().encode(bytes);
//			System.out.println(encodedBytes);
			System.out.println(new String(encodedBytes, "UTF-8"));
			
			byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
//			System.out.println(decodedBytes);
//			System.out.println("decodedBytes " + new String(decodedBytes, "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}