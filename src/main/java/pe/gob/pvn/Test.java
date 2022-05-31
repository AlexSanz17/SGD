package pe.gob.pvn;

import java.util.Date;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
			Date date = new Date();
			System.out.println(date.toString().substring(date.toString().length() - 4 ).trim());
	}

}
