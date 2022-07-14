package org.ositran.daos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.ositran.services.DocumentoPIDEService;

import com.btg.ositran.siged.domain.IotdtcDespacho;
import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcion;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexo;
import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import com.btg.ositran.siged.domain.IotdtmDocExterno;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;

import gob.ositran.siged.config.SigedProperties;

public class DocumentoPIDEDAOjdbc {
	private DocumentoPIDEService documentoPIDEService;
	private String BD_URL_SGD = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.BD_URL_SGD);
	private String BD_USUARIO_SGD = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.BD_USUARIO_SGD);
	private String BD_PASSWORD_SGD = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.BD_PASSWORD_SGD);
	
	//Conexio PIDE
	private String BD_URL_PIDE = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.BD_URL_PIDE);
	private String BD_USUARIO_PIDE = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.BD_USUARIO_PIDE);
	private String BD_PASSWORD_PIDE = SigedProperties.getProperty(SigedProperties.SigedPropertyEnum.BD_PASSWORD_PIDE);
	public DocumentoPIDEService getDocumentoPIDEService() {
		return documentoPIDEService;
	}

	public void setDocumentoPIDEService(DocumentoPIDEService documentoPIDEService) {
		this.documentoPIDEService = documentoPIDEService;
	}

	public void insertDespachoPIDE(IotdtcDespachoPIDE iotdtcDespachoPIDE) {
		
		
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		
		System.out.println("realizar el insert");
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	             System.out.println("Driver name: " + dm.getDriverName());
	             System.out.println("Driver version: " + dm.getDriverVersion());
	             System.out.println("Product name: " + dm.getDatabaseProductName());
	             System.out.println("Product version: " + dm.getDatabaseProductVersion());
			
			String sql = 
//					"SET IDENTITY_INSERT [IDOSGD].[IOTDTC_DESPACHO] ON;\r\n"  , [SIDEMIEXT]
					 " INSERT INTO [IDOSGD].[IOTDTC_DESPACHO] "
					+ "           ([VNUMREGSTD] ,[VANIOREGSTD] ,[CTIPDOCIDEREM],[VNUMDOCIDEREM],[VCODUNIORGREM],[VUNIORGREM],[VCUO],[VRUCENTREC],[VNOMENTREC]"
					+ "           ,[VNUMREGSTDREC] ,[VANIOREGSTDREC],[VUNIORGSTDREC],[VDESANXSTDREC],[VUSUREGSTDREC]"
					+ "           ,[BCARSTDREC],[VOBS],[VCUOREF],[CFLGEST],[DFECENV] ,[VUSUREG],[DFECREG],[VUSUMOD],[DFECMOD])"
					+ "     VALUES\r\n"
					+ "           (?,? ,? ,? ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?, ? ,?)  ";
//					+ "SET IDENTITY_INSERT [IDOSGD].[IOTDTC_DESPACHO] OFF;";
			
			System.out.println("asignar variables");
//			System.out.println(sql); 
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setInt(1, iotdtcDespachoPIDE.getSidemiext() != null ? iotdtcDespachoPIDE.getSidemiext(): null); 
			
//			System.out.println(iotdtcDespachoPIDE.getVnumregstd());
			statement.setString(1, iotdtcDespachoPIDE.getVnumregstd() != null ? iotdtcDespachoPIDE.getVnumregstd(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVanioregstd());
			statement.setString(2, iotdtcDespachoPIDE.getVanioregstd() != null ? iotdtcDespachoPIDE.getVanioregstd(): null);
			
//			System.out.println(String.valueOf(iotdtcDespachoPIDE.getCtipdociderem()));
			statement.setString(3, iotdtcDespachoPIDE.getCtipdociderem() != null ? String.valueOf(iotdtcDespachoPIDE.getCtipdociderem()): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVnumdociderem());
			statement.setString(4, iotdtcDespachoPIDE.getVnumdociderem() != null ? iotdtcDespachoPIDE.getVnumdociderem(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVcoduniorgrem());
			statement.setString(5, iotdtcDespachoPIDE.getVcoduniorgrem() != null ? iotdtcDespachoPIDE.getVcoduniorgrem(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVuniorgrem());
			statement.setString(6, iotdtcDespachoPIDE.getVuniorgrem() != null ? iotdtcDespachoPIDE.getVuniorgrem(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVcuo());
			statement.setString(7, iotdtcDespachoPIDE.getVcuo() != null ? iotdtcDespachoPIDE.getVcuo(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVrucentrec());
			statement.setString(8, iotdtcDespachoPIDE.getVrucentrec() != null ? iotdtcDespachoPIDE.getVrucentrec(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVnomentrec());
			statement.setString(9, iotdtcDespachoPIDE.getVnomentrec() != null ? iotdtcDespachoPIDE.getVnomentrec(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVnumregstdrec());
			statement.setString(10, iotdtcDespachoPIDE.getVnumregstdrec() != null ? iotdtcDespachoPIDE.getVnumregstdrec(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVanioregstdrec());
			statement.setString(11, iotdtcDespachoPIDE.getVanioregstdrec() != null ? iotdtcDespachoPIDE.getVanioregstdrec(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVuniorgstdrec());
			statement.setString(12, iotdtcDespachoPIDE.getVuniorgstdrec() != null ? iotdtcDespachoPIDE.getVuniorgstdrec(): null);
			
//			System.out.println(iotdtcDespachoPIDE.getVdesanxstdrec());
			statement.setString(13, iotdtcDespachoPIDE.getVdesanxstdrec() != null ? iotdtcDespachoPIDE.getVdesanxstdrec(): null);
			

			statement.setString(14, iotdtcDespachoPIDE.getVusuregstdrec() != null ? iotdtcDespachoPIDE.getVusuregstdrec(): null);
			
//			System.out.println("getBcarstdrec " +iotdtcDespachoPIDE.getBcarstdrec());
			statement.setBytes(15, iotdtcDespachoPIDE.getBcarstdrec() != null ? iotdtcDespachoPIDE.getBcarstdrec(): null);
			
//			System.out.println("getVobs " +iotdtcDespachoPIDE.getVobs() );
			statement.setString(16, iotdtcDespachoPIDE.getVobs() != null ? iotdtcDespachoPIDE.getVobs(): null);
			
			System.out.println("getVcuoref " +iotdtcDespachoPIDE.getVcuoref());
			statement.setString(17, iotdtcDespachoPIDE.getVcuoref() != null ? iotdtcDespachoPIDE.getVcuoref(): null);
			
//			System.out.println("getCflgest " +iotdtcDespachoPIDE.getCflgest());		
			statement.setString(18, iotdtcDespachoPIDE.getCflgest() != null ? String.valueOf(iotdtcDespachoPIDE.getCflgest()): null);
			
//			System.out.println("getDfecenv " +iotdtcDespachoPIDE.getDfecenv().getTime());
//			java.util.Date getDfecenvUtil = iotdtcDespachoPIDE.getDfecenv() ;
//			java.sql.Date getDfecenv = new java.sql.Date(getDfecenvUtil.getTime());
			String getDfecenv = DATE_FORMAT.format(iotdtcDespachoPIDE.getDfecenv());	
			statement.setString(19,  getDfecenv != null ?  getDfecenv: null);
			
//			System.out.println("getVusureg " +iotdtcDespachoPIDE.getVusureg());
			statement.setString(20, iotdtcDespachoPIDE.getVusureg() != null ? iotdtcDespachoPIDE.getVusureg(): null);
			
//			System.out.println("getDfecreg " +iotdtcDespachoPIDE.getDfecreg().getTime());
//			java.util.Date getDfecregUtil = iotdtcDespachoPIDE.getDfecreg() ;
//			java.sql.Date getDfecreg = new java.sql.Date(getDfecregUtil.getTime());
			String getDfecreg = DATE_FORMAT.format(iotdtcDespachoPIDE.getDfecreg());	
			System.out.println("fecha a ingresar  getDfecreg--------- " +getDfecreg);
			statement.setString(21, getDfecreg != null ? getDfecreg : null );
			
			
//			System.out.println("getVusumod " +iotdtcDespachoPIDE.getVusumod());
			statement.setString(22, iotdtcDespachoPIDE.getVusumod());
		
			

//			java.util.Date getDfecmodUtil = iotdtcDespachoPIDE.getDfecmod() ;
//			java.sql.Date getDfecmod = new java.sql.Date(getDfecmodUtil.getTime());
//			Date datetoday = new Date();
			String getDfecmod = DATE_FORMAT.format(iotdtcDespachoPIDE.getDfecmod());	
			System.out.println("fecha a ingresar  getDfecmod--------- " +getDfecmod);
			statement.setString(23,  getDfecmod != null ? getDfecmod : null);
			
			
			
			System.out.println("ejecutar ");   
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("insert IOTDTC_DESPACHO_PIDE successfully!");
			}
			 }
			
		} catch (SQLException ex) {
			System.out.println("error en el insert"); 
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }	
		
   }
	public void updateDespachoJOB(IotdtcDespacho iotdtcDespacho) {
		String dbURL = BD_URL_SGD;
		String username = BD_USUARIO_SGD;
		String password = BD_PASSWORD_SGD;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			String sql =  "UPDATE [dbo].[IOTDTC_DESPACHO] SET BCARSTDREC = ?, CFLGENV = ? , CFLGEST = ?, CTIPDOCIDEREM = ?,"
					+ " DFECENV = ?, DFECMOD = ? , DFECREG = ?, DFECREGSTDREC = ?, IDDOCUMENTO = ?, VANIOREGSTD = ?, VANIOREGSTDREC = ? , "
					+ "VCODUNIORGREM = ?, VCUOREF = ?, VDESANXSTDREC = ? , VNOMENTREC =  ? , VNUMDOCIDEREM = ?, VNUMREGSTD = ?, VNUMREGSTDREC = ? , VOBS = ?, "
					+ "VRUCENTREC = ?, VUNIORGREM = ?, VUNIORGSTDREC = ? , VUSUMOD = ? , VUSUREG = ?, VUSUREGSTDREC = ?  "
					+ "WHERE VCUO = ?"  ;
					
			
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setBytes(1, iotdtcDespacho.getBcarstdrec() != null ? iotdtcDespacho.getBcarstdrec() : null); 
			statement.setString(2, iotdtcDespacho.getCflgenv() != null ? String.valueOf(iotdtcDespacho.getCflgenv()) : null); 
			statement.setString(3, iotdtcDespacho.getCflgest() != null ? String.valueOf(iotdtcDespacho.getCflgest()) : null); 
			statement.setString(4, iotdtcDespacho.getCtipdociderem() != null ? String.valueOf(iotdtcDespacho.getCtipdociderem()) : null); 
			String getDfecenv = DATE_FORMAT.format(iotdtcDespacho.getDfecenv());	
			statement.setString(5, getDfecenv != null ? getDfecenv : null); 
			String getDfecmod = DATE_FORMAT.format(iotdtcDespacho.getDfecmod());	
			statement.setString(6, getDfecmod != null ? getDfecmod : null); 
			String getDfecreg = DATE_FORMAT.format(iotdtcDespacho.getDfecreg());	
			statement.setString(7, getDfecreg != null ? getDfecreg : null); 
			String getDfecregstdrec = DATE_FORMAT.format(iotdtcDespacho.getDfecregstdrec());	
			statement.setString(8, getDfecregstdrec != null ? getDfecregstdrec : null); 
			statement.setInt(9, iotdtcDespacho.getIddocumento() != null ? iotdtcDespacho.getIddocumento() : null); 
			statement.setString(10, iotdtcDespacho.getVanioregstd() != null ? iotdtcDespacho.getVanioregstd()  : null); 
			statement.setString(11, iotdtcDespacho.getVanioregstdrec() != null ? iotdtcDespacho.getVanioregstdrec()  : null); 
			statement.setString(12, iotdtcDespacho.getVcoduniorgrem() != null ? iotdtcDespacho.getVcoduniorgrem()  : null); 
			statement.setString(13, iotdtcDespacho.getVcuoref() != null ? iotdtcDespacho.getVcuoref()  : null); 
			statement.setString(14, iotdtcDespacho.getVdesanxstdrec() != null ? iotdtcDespacho.getVdesanxstdrec()  : null);
			statement.setString(15, iotdtcDespacho.getVnomentrec() != null ? iotdtcDespacho.getVnomentrec()  : null); 
			statement.setString(16, iotdtcDespacho.getVnumdociderem() != null ? iotdtcDespacho.getVnumdociderem()  : null); 
			statement.setString(17, iotdtcDespacho.getVnumregstd() != null ? iotdtcDespacho.getVnumregstd()  : null); 
			statement.setString(18, iotdtcDespacho.getVnumregstdrec() != null ? iotdtcDespacho.getVnumregstdrec()  : null); 
			statement.setString(19, iotdtcDespacho.getVobs() != null ? iotdtcDespacho.getVobs()  : null); 
			statement.setString(20, iotdtcDespacho.getVrucentrec() != null ? iotdtcDespacho.getVrucentrec()  : null); 
			statement.setString(21, iotdtcDespacho.getVuniorgrem() != null ? iotdtcDespacho.getVuniorgrem()  : null); 
			statement.setString(22, iotdtcDespacho.getVuniorgstdrec() != null ? iotdtcDespacho.getVuniorgstdrec()  : null); 
			statement.setString(23, iotdtcDespacho.getVusumod() != null ? iotdtcDespacho.getVusumod()  : null); 
			statement.setString(24, iotdtcDespacho.getVusureg() != null ? iotdtcDespacho.getVusureg()  : null); 
			statement.setString(25, iotdtcDespacho.getVusuregstdrec() != null ? iotdtcDespacho.getVusuregstdrec()  : null); 
		
			statement.setString(26, iotdtcDespacho.getVcuo() != null ? iotdtcDespacho.getVcuo() : null);  
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Se actualizo IOTDTC_DESPACHO_JOB ");
			}
			 }
			
		} catch (SQLException ex) {
			System.out.println("error en el insert"); 
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }	
	}
	
	
	public void updateRecepcionPIDEJOB(IotdtcRecepcionPIDE iotdtcRecepcion) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		
		System.out.println("realizar el update");
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			String sql =  "UPDATE [IDOSGD].[IOTDTC_RECEPCION] SET FLGINSERT = 1 WHERE VCUO = ?"  ;
					
			
			System.out.println("asignar variables");
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, iotdtcRecepcion.getVcuo() != null ? iotdtcRecepcion.getVcuo() : null); 
			System.out.println("ejecutar ");   
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Se actualizo IOTDTC_RECEPCION_PIDE_JOB en RECEPCION");
			}
			 }
			
		} catch (SQLException ex) {
			System.out.println("error en el insert"); 
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }	
	}
	
	public void updateDespachoPIDEJOB(IotdtcDespachoPIDE iotdtcDespachoPIDE) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			String sql =  "UPDATE [IDOSGD].[IOTDTC_DESPACHO] SET FLGINSERT = 1 WHERE VCUO = ?"  ;
					
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, iotdtcDespachoPIDE.getVcuo() != null ? iotdtcDespachoPIDE.getVcuo() : null); 
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Se actualizo IOTDTC_DESPACHO_PIDE_JOB ");
			}
			 }
			
		} catch (SQLException ex) {
			System.out.println("error en el insert"); 
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }	
	}
	public void updateRecepcionPIDE(IotdtcRecepcion iotdtcRecepcion) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		
		System.out.println("realizar el update");
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			String sql =  "UPDATE [IDOSGD].[IOTDTC_RECEPCION] SET CFLGEST = 'R' WHERE VCUO = ?"  ;
					
			
			System.out.println("asignar variables");
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, iotdtcRecepcion.getVcuo() != null ? iotdtcRecepcion.getVcuo() : null); 
			System.out.println("ejecutar ");   
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Se actualizo IOTDTC_RECEPCION_PIDE en RECEPCION");
			}
			 }
			
		} catch (SQLException ex) {
			System.out.println("error en el insert"); 
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }	
	}
	
	public void updateRecepcionEnvioCargoPIDE(IotdtcRecepcion iotdtcRecepcion) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		
		System.out.println("realizar el update");
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			String sql =  "UPDATE [IDOSGD].[IOTDTC_RECEPCION] SET  VNUMREGSTD = ? , VANIOREGSTD = ? , VUNIORGSTD = ? , VDESANXSTD = ?, "
					+ "DFECREGSTD = ?, VUSUREGSTD = ?, BCARSTD = ?, DFECMOD = ?, CFLGENVCAR = 'S' , CFLGEST = ?  WHERE VCUO = ?"  ;
					
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println("asignar variables");
			PreparedStatement statement = conn.prepareStatement(sql);
			
			
			statement.setString(1, iotdtcRecepcion.getVnumregstd() != null ? iotdtcRecepcion.getVnumregstd()  : null); 
			statement.setString(2, iotdtcRecepcion.getVanioregstd() != null ? iotdtcRecepcion.getVanioregstd()  : null); 
			statement.setString(3, iotdtcRecepcion.getVuniorgstd() != null ? iotdtcRecepcion.getVuniorgstd()  : null); 
			statement.setString(4, iotdtcRecepcion.getVdesanxstd() != null ? iotdtcRecepcion.getVdesanxstd()  : null); 
			String getDfecregstd = DATE_FORMAT.format(iotdtcRecepcion.getDfecregstd());	
			System.out.println("fecha a ingresar  getDfecmod--------- " +getDfecregstd);
			statement.setString(5, getDfecregstd != null ? getDfecregstd : null); 
			statement.setString(6, iotdtcRecepcion.getVusuregstd() != null ? iotdtcRecepcion.getVusuregstd() : null); 
			statement.setBytes(7, iotdtcRecepcion.getBcarstd() != null ? iotdtcRecepcion.getBcarstd() : null); 
			
			String getDfecmod = DATE_FORMAT.format(iotdtcRecepcion.getDfecmod());	
//			System.out.println("fecha a ingresar  getDfecmod--------- " +getDfecregstd);
			statement.setString(8, getDfecmod != null ? getDfecmod : null); 
			statement.setString(9, iotdtcRecepcion.getCflgest().toString() != null ? iotdtcRecepcion.getCflgest().toString()  : null); 
			statement.setString(10, iotdtcRecepcion.getVcuo() != null ? iotdtcRecepcion.getVcuo() : null); 
			System.out.println("ejecutar ");   
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Se actualizo IOTDTC_RECEPCION_PIDE!");
			}
			 }
			
		} catch (SQLException ex) {
			System.out.println("error en el insert"); 
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }	
	}
	public void insertIotdtcDocExternoPIDE( String vcuo , IotdtmDocExterno  iotdtmDocExterno) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		IotdtcRecepcionPIDE iotdtcRecepcionPIDE = null;
		IotdtcDespachoPIDE iotdtcDesachoPIDE = null;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("asignar variables");
		
		Connection conn = null;
		try {
		
			conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	         	if(vcuo != null && !vcuo.equals("")) {
					
					iotdtcDesachoPIDE = documentoPIDEService.getDespachoByVcuo(vcuo);
//					System.out.println("Objecto DESPACHO " +iotdtcDesachoPIDE);
				}
				
			
				String sql = 
//						"SET IDENTITY_INSERT [IDOSGD].[IOTDTM_DOC_EXTERNO] ON;\r\n" , [SIDDOCEXT]
						"INSERT INTO [IDOSGD].[IOTDTM_DOC_EXTERNO] (\r\n"
						+ "      [VNOMENTEMI]\r\n"
						+ "      ,[CCODTIPDOC]\r\n"
						+ "      ,[VNUMDOC]\r\n"
						+ "      ,[DFECDOC]\r\n"
						+ "      ,[VUNIORGDST]\r\n"
						+ "      ,[VNOMDST]\r\n"
						+ "      ,[VNOMCARDST]\r\n"
						+ "      ,[VASU]\r\n"
//						+ "      ,[CINDTUP]\r\n"
						+ "      ,[SNUMANX]\r\n"
						+ "      ,[SNUMFOL]\r\n"
						+ "      ,[VURLDOCANX]\r\n"
						+ "      ,[SIDEMIEXT])\r\n"
//						+ "      ,[SIDRECEXT])\r\n"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
					
//						+ "SET IDENTITY_INSERT [IDOSGD].[IOTDTM_DOC_EXTERNO] OFF;";
				
				System.out.println("insertar variables");  
				
				
				PreparedStatement statement = conn.prepareStatement(sql);
//				statement.setInt(1, iotdtmDocExterno.getSiddocext()); 
				statement.setString(1, iotdtmDocExterno.getVnomentemi() != null ? iotdtmDocExterno.getVnomentemi() : null);
				statement.setString(2, iotdtmDocExterno.getCcodtipdoc() != null ? iotdtmDocExterno.getCcodtipdoc(): null);
				statement.setString(3, iotdtmDocExterno.getVnumdoc() != null ? iotdtmDocExterno.getVnumdoc() : null);
				
//				java.util.Date getDfecdocUtil = iotdtmDocExterno.getDfecdoc() ;
//				java.sql.Date getDfecdoc = new java.sql.Date(getDfecdocUtil.getTime());
				String getDfecdoc = DATE_FORMAT.format(iotdtmDocExterno.getDfecdoc());	
				statement.setString(4, getDfecdoc != null ? getDfecdoc : null);
				
				statement.setString(5, iotdtmDocExterno.getVuniorgdst() != null ? iotdtmDocExterno.getVuniorgdst() : null);
				statement.setString(6, iotdtmDocExterno.getVnomdst() != null ? iotdtmDocExterno.getVnomdst(): null);
				statement.setString(7, iotdtmDocExterno.getVnomcardst() != null ? iotdtmDocExterno.getVnomcardst() : null);
				statement.setString(8, iotdtmDocExterno.getVasu() != null ? iotdtmDocExterno.getVasu(): null);
//				statement.setString(10, iotdtmDocExterno.getCindtup().toString()!= null ?  iotdtmDocExterno.getCindtup().toString(): null);
				statement.setInt(9, iotdtmDocExterno.getSnumanx().intValue());
				statement.setInt(10, iotdtmDocExterno.getSnumfol().intValue());
				statement.setString(11, iotdtmDocExterno.getVurldocanx() != null ?  iotdtmDocExterno.getVurldocanx(): null);
				statement.setInt(12,  iotdtcDesachoPIDE.getSidemiext() != null ?  iotdtcDesachoPIDE.getSidemiext()  : null);

				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("insert IOTDTM_DOC_EXTERNO_PIDE successfully!");
				}
			 }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         
         
	}
	public void insertIotdtcDocPrincipalPIDE( String vcuo , IotdtdDocPrincipal  iotdtmDocPrincipal) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		IotdtcRecepcionPIDE iotdtcRecepcionPIDE = null;
		IotdtcDespachoPIDE iotdtcDesachoPIDE = null;
		IotdtmDocExternoPIDE iotdtmDocExternoPIDE = null;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("asignar variables");
		
		Connection conn = null;
		try {
		
			conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	         	if(vcuo != null && !vcuo.equals("")) {
					iotdtcDesachoPIDE = documentoPIDEService.getDespachoByVcuo(vcuo);
//					System.out.println("Objecto DESPACHO " +iotdtcDesachoPIDE);
				}
	         	
	         	iotdtmDocExternoPIDE = documentoPIDEService.getDocExternoBySidemext(iotdtcDesachoPIDE.getSidemiext());
//	         	System.out.println("------------iotdtmDocExternoPIDE---------------"+iotdtmDocExternoPIDE);
//	         		List<IotdtmDocExternoPIDE> lstIotdtmDocExternoPIDE = documentoPIDEService.getAllDocExterno();
//	         		System.out.println("---------tamaño ----------- lstIotdtmDocExternoPIDE-------------" +lstIotdtmDocExternoPIDE.size());
//	         		System.out.println("--------iotdtcDesachoPIDE.getSidemiext()--------" +iotdtcDesachoPIDE.getSidemiext());
//	         		
//	         		for(int i = 0; i< lstIotdtmDocExternoPIDE.size() ; i++) {
//	         	   		System.out.println("--------lstIotdtmDocExternoPIDE--------" +lstIotdtmDocExternoPIDE.get(i).getSidemiext().toString());
//	         			if(lstIotdtmDocExternoPIDE.get(i).getSidemiext().getSidemiext() == iotdtcDesachoPIDE.getSidemiext()) {
//	         				iotdtmDocExternoPIDE = lstIotdtmDocExternoPIDE.get(i);
//	         			}
//	         		}
				
			
				String sql = 
//						"SET IDENTITY_INSERT [IDOSGD].[IOTDTD_DOC_PRINCIPAL] ON;\r\n", [SIDDOCPRI]
						"INSERT INTO [IDOSGD].[IOTDTD_DOC_PRINCIPAL] (\r\n"
						+ "      [SIDDOCEXT]\r\n"
						+ "      ,[VNOMDOC]\r\n"
						+ "      ,[BPDFDOC]\r\n"
						+ "      ,[CCODEST]\r\n"
						+ "      ,[DFECREG])\r\n"
						+ "VALUES (?,?,?,?,?)";
					
//						+ "SET IDENTITY_INSERT [IDOSGD].[IOTDTD_DOC_PRINCIPAL] OFF;";
				
				System.out.println("insertar variables");  
		
				PreparedStatement statement = conn.prepareStatement(sql);
//				statement.setInt(1, iotdtmDocPrincipal.getSiddocpri()); 
				statement.setInt(1, iotdtmDocExternoPIDE.getSiddocext() != null ? iotdtmDocExternoPIDE.getSiddocext() : null);
				statement.setString(2, iotdtmDocPrincipal.getVnomdoc() != null ? iotdtmDocPrincipal.getVnomdoc(): null);
				statement.setBytes(3, iotdtmDocPrincipal.getBpdfdoc() != null ? iotdtmDocPrincipal.getBpdfdoc(): null);
				statement.setString(4, String.valueOf(iotdtmDocPrincipal.getCcodest()) != null ? String.valueOf(iotdtmDocPrincipal.getCcodest())  : null);
//				
//				java.util.Date getDfecregUtil = iotdtmDocPrincipal.getDfecreg() ;
//				java.sql.Date getDfecreg = new java.sql.Date(getDfecregUtil.getTime());
				String getDfecreg = DATE_FORMAT.format(iotdtmDocPrincipal.getDfecreg());	
				statement.setString(5, getDfecreg != null ? getDfecreg  : null );
					
				

				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("insert IOTDTD_DOC_PRINCIPAL_PIDE successfully!");
				}
			 }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         
         
	}
	public void insertIotdtcDocAnexoPIDE( String vcuo , IotdtdAnexo  iotdtdAnexo) {
		String dbURL = BD_URL_PIDE;
		String username = BD_USUARIO_PIDE;
		String password = BD_PASSWORD_PIDE;
		IotdtcRecepcionPIDE iotdtcRecepcionPIDE = null;
		IotdtcDespachoPIDE iotdtcDesachoPIDE = null;
		IotdtmDocExternoPIDE iotdtmDocExternoPIDE = null;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("asignar variables");
		
		Connection conn = null;
		try {
		
			conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	         	if(vcuo != null && !vcuo.equals("")) {
					iotdtcDesachoPIDE = documentoPIDEService.getDespachoByVcuo(vcuo);
				}
	         	
//	         		List<IotdtmDocExternoPIDE> lstIotdtmDocExternoPIDE = documentoPIDEService.getAllDocExterno();
//	         		for(int i = 0; i< lstIotdtmDocExternoPIDE.size() ; i++) {
//	         			if(lstIotdtmDocExternoPIDE.get(i).getSidemiext().getSidemiext() == iotdtcDesachoPIDE.getSidemiext()) {
//	         				iotdtmDocExternoPIDE = lstIotdtmDocExternoPIDE.get(i);
//	         			}
//	         		}
				iotdtmDocExternoPIDE = documentoPIDEService.getDocExternoBySidemext(iotdtcDesachoPIDE.getSidemiext());
//	         	System.out.println("------------iotdtmDocExternoPIDE---------------"+iotdtmDocExternoPIDE);
			
				String sql = 
//						"SET IDENTITY_INSERT [IDOSGD].[IOTDTD_ANEXO] ON;\r\n", [SIDDOCANX]
						 "INSERT INTO [IDOSGD].[IOTDTD_ANEXO](\r\n"
						+ "      [VNOMDOC]\r\n"
						+ "      ,[SIDDOCEXT]\r\n"
						+ "      ,[DFECREG])\r\n"
						+ "VALUES (?,?,?)";
					
//						+ "SET IDENTITY_INSERT [IDOSGD].[IOTDTD_ANEXO] OFF;";
				
				System.out.println("insertar variables");  
				
				PreparedStatement statement = conn.prepareStatement(sql);
//				if(iotdtdAnexo != null) {
					
//					statement.setInt(1, iotdtdAnexo.getSiddocanx() != null ? iotdtdAnexo.getSiddocanx(): null); 
					statement.setString(1, iotdtdAnexo.getVnomdoc() != null ? iotdtdAnexo.getVnomdoc(): null);
					statement.setInt(2, iotdtmDocExternoPIDE.getSiddocext() != null ? iotdtmDocExternoPIDE.getSiddocext() : null);
//					java.util.Date getDfecregUtil = iotdtdAnexo.getDfecreg() ;
//					java.sql.Date getDfecreg = new java.sql.Date(getDfecregUtil.getTime());
					String getDfecreg = DATE_FORMAT.format(iotdtdAnexo.getDfecreg());
					statement.setString(3, getDfecreg != null ? getDfecreg : null);
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("insert IOTDTD_ANEXO_PIDE successfully!");
					}
				}
//			 }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         
         
	}
	
	public void insertDefault() {
		
		String dbURL = "jdbc:sqlserver://DBD9:1433;database=BD_PCM_INTEROPERABILIDAD;integratedSecurity=false";
		String username = "u_sgd";
		String password = "xyz456*";
		
		System.out.println("asignar variables");
		
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	             System.out.println("Driver name: " + dm.getDriverName());
	             System.out.println("Driver version: " + dm.getDriverVersion());
	             System.out.println("Product name: " + dm.getDatabaseProductName());
	             System.out.println("Product version: " + dm.getDatabaseProductVersion());
			
			
				String sql = "SET IDENTITY_INSERT [IDOSGD].[IOTDTC_DESPACHO] ON;\r\n"
						+ "INSERT INTO [IDOSGD].[IOTDTC_DESPACHO] (SIDEMIEXT, \r\n"
						+ "VNUMREGSTD, VANIOREGSTD, CTIPDOCIDEREM, VNUMDOCIDEREM, VCODUNIORGREM, VUNIORGREM, VCUO\r\n"
						+ "														, VRUCENTREC, VNOMENTREC, VNUMREGSTDREC, \r\n"
						+ "														VANIOREGSTDREC, VUNIORGSTDREC, VDESANXSTDREC, DFECREGSTDREC\r\n"
						+ "														, VUSUREGSTDREC, BCARSTDREC, VOBS, VCUOREF, \r\n"
						+ "														CFLGEST, DFECENV, VUSUREG, DFECREG, VUSUMOD, DFECMOD)\r\n"
						+ "VALUES (61,'2022001103','2022','1','42178438','455','OFICINA DE TECNOLOGIA DE LA INFORMACION (OTI)',\r\n"
						+ "'0000004769','20168999926','MINISTERIO DE LA PRESIDENCIA DEL CONSEJO DE MINISTROS', NULL, NULL , NULL, NULL,\r\n"
						+ " NULL , NULL, NULL , NULL, NULL,'E','02-06-2022 08:59:37','MCOELLO','31-05-2022 09:34:16','MENSAJERIA','02-06-2022 08:59:48')\r\n"
						+ "SET IDENTITY_INSERT [IDOSGD].[IOTDTC_DESPACHO] OFF;";
				
				System.out.println("insertar variables");  
				
				PreparedStatement statement = conn.prepareStatement(sql);

				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("A new user was inserted successfully!");
				}
			 }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		
	}
	
	
	public void insertDespachoPIDEaa() {
		
		
		String dbURL = "jdbc:sqlserver://DBD9:1433;database=BD_PCM_INTEROPERABILIDAD;integratedSecurity=false";
		String username = "u_sgd";
		String password = "xyz456*";
		
		System.out.println("asignar variables");
		
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(dbURL, username, password);

			 if (conn != null) {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	             System.out.println("Driver name: " + dm.getDriverName());
	             System.out.println("Driver version: " + dm.getDriverVersion());
	             System.out.println("Product name: " + dm.getDatabaseProductName());
	             System.out.println("Product version: " + dm.getDatabaseProductVersion());
			
			
				String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
				
				System.out.println("insertar variables");  
				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, "bill");
				statement.setString(2, "secretpass");
				statement.setString(3, "Bill Gates");
				statement.setString(4, "bill.gates@microsoft.com");
				
				
				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("A new user was inserted successfully!");
				}
			 }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
   }


}