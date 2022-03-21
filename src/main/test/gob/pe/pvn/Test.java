package gob.pe.pvn;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date fechaAccion = Date.valueOf("2022-03-19 17:45:42.007");
		Date fechaAccion = new Date(2022,3,19);
		String fechaForService = DATE_FORMAT.format(fechaAccion);
		System.out.println(fechaForService);
	}

}
