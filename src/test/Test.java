package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import crawl.CrawlOneBugDelegate;
import crawl.CrawlOneBugService;

public class Test {
	
	public void loginSqlServer2000() {
		String driverName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";  
		String dbURL = "jdbc:microsoft:sqlserver://FTLPOBUGSQLCL01:1433;DatabaseName=OneBugDatamart;user=svcacct_gsnkg;password=7eyuchXx"; //���ӷ���������ݿ�sample 

		Connection dbConn; 

		try { 
			Class.forName(driverName); 
			dbConn = DriverManager.getConnection(dbURL); 
			System.out.println( "Connection Successful! "); 
			} catch (Exception e) { 
			e.printStackTrace(); 
			} 
	}
	
	public void loginSqlServer2005() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
		String dbURL = "jdbc:sqlserver://FTLPOBUGSQLCL01:1433;DatabaseName=OneBugDatamart;integratedSecurity=true"; 

		Connection dbConn; 

		try { 
			Class.forName(driverName); 
			dbConn = DriverManager.getConnection(dbURL); 
			System.out.println( "Connection Successful! "); 
			} catch (Exception e) { 
			e.printStackTrace(); 
			} 
	}
	
	public static void main(String args[]) {
//		String request = "1";
//		String response = null;
//		CrawlOneBugService cos = new CrawlOneBugService();
//		CrawlOneBugDelegate cod = cos.getCrawlOneBugPort();
//		response = cod.crawlFromOneBug(request);
//		System.out.println(response);

	} 
}
