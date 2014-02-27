package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DataMartAccess {
	
	private static String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private static String DatabaseIP = "FTLPOBUGSQLCL01";

	private static String DatabaseName = "OneBugDatamart";
	
	private static String IntegratedSecurity = "true";
	
	private static String DatabaseUrl = "jdbc:sqlserver://" + DatabaseIP + ":1433;DatabaseName=" + DatabaseName + ";integratedSecurity=" + IntegratedSecurity;
	
	
}
