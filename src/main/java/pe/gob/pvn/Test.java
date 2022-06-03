package pe.gob.pvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		
		 String connectionUrl =
	                "jdbc:sqlserver://DBD9:1433;"
	                + "database=BD_PCM_INTEROPERABILIDAD;"
	                + "user=u_sgd;"
	                + "password=xyz456*;"
	                + "encrypt=true;"
	                + "trustServerCertificate=false;"
	                + "loginTimeout=30;";
//		 jdbc:sqlserver://DBD9:1433;database=BD_PCM_INTEROPERABILIDAD;integratedSecurity=false
	        ResultSet resultSet = null;

	
//		String SQL = "";
//		stmt = con.prepareStatement(SQL);
//		Int SIDEMIEXT = 14;
//		String VCUO = "0000002778";
//		stmt.setString(1,SIDEMIEXT);
//		stmt.setInt(2,VCUO);
//		stmt.executeUpdate();
	}

}
