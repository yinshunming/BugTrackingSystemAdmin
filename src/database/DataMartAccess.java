package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import bean.Buginfo;
import bean.WarppedBuginfo;

public class DataMartAccess {
	
	private static String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private static String DatabaseIP = "FTLPOBUGSQLCL01";

	private static String DatabaseName = "OneBugDatamart";
	
	private static String IntegratedSecurity = "true";
	
	private static String DatabaseUrl = "jdbc:sqlserver://" + DatabaseIP + ":1433;DatabaseName=" + DatabaseName + ";integratedSecurity=" + IntegratedSecurity;
	
	
	public static List<WarppedBuginfo> getDifferentBugByOldList (List<WarppedBuginfo> oldList) {
		
		PreparedStatement ps = null;
    	Connection ct = null;
    	ResultSet rs = null;
    	Buginfo bi = null;
    	List<WarppedBuginfo> returnList = new ArrayList<WarppedBuginfo>();
    	
    	try {
    		Class.forName(DriverName);
    		ct = DriverManager.getConnection(DatabaseUrl);
    		
    		for (WarppedBuginfo warppedBuginfo : oldList) {
    			Buginfo oldBuginfo = warppedBuginfo.getBuginfo();
	    		ps = ct.prepareStatement("select * from OB_Bugs where BUGID=? and OwnerNm!=?");
	    		ps.setString(1, oldBuginfo.getBugId());
	    		ps.setString(2, oldBuginfo.getOwner());
    		
	    		rs = ps.executeQuery();
	    		
	    		if(rs.next()) {
	    			bi = new Buginfo();
	    			bi.setId(oldBuginfo.getId());
	    			bi.setBugId(oldBuginfo.getBugId());
	    			bi.setTitle(rs.getString("Title"));
	    			bi.setType(rs.getString("DefectType"));
	    			bi.setStatus(rs.getString("State"));
	    			bi.setDescription(rs.getString("Description"));
	    			bi.setOwner(rs.getString("OwnerNm"));
	    			bi.setSubmitter(rs.getString("SubmitterNm"));
	    			bi.setProject(rs.getString("Project"));
	    			bi.setSubmitData(Timestamp.valueOf(rs.getString("SubmitDate")));
	    			bi.setSeverity(rs.getString("Severity"));
	    			bi.setTags(rs.getString("Tags"));
	    			bi.setRegression(rs.getString("Regression"));
	    			WarppedBuginfo wb = new WarppedBuginfo(bi, warppedBuginfo.getStatus(), warppedBuginfo.getManagedBugId());
	    			returnList.add(wb);
	    		}
    		}
    		
    		if (oldList != null && oldList.size() > 0) {
	    		rs.close();
	    		ps.close();
	    		ct.close();
    		}
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
		return returnList;
	}
	
	public static List<Buginfo> getDifferentBugId (List<Buginfo> oldBuginfoList) {
		PreparedStatement ps = null;
    	Connection ct = null;
    	ResultSet rs = null;
    	Buginfo bi = null;
    	List<Buginfo> returnList = new ArrayList<Buginfo>();
    	
    	try {
    		Class.forName(DriverName);
    		ct = DriverManager.getConnection(DatabaseUrl);
    		
    		for (Buginfo oldBuginfo : oldBuginfoList) {
	    		ps = ct.prepareStatement("select * from OB_Bugs where BUGID=? and OwnerNm!=?");
	    		ps.setString(1, oldBuginfo.getBugId());
	    		ps.setString(2, oldBuginfo.getOwner());
    		
	    		rs = ps.executeQuery();
	    		
	    		if(rs.next()) {
	    			bi = new Buginfo();
	    			bi.setId(oldBuginfo.getId());
	    			bi.setBugId(oldBuginfo.getBugId());
	    			bi.setTitle(rs.getString("Title"));
	    			bi.setType(rs.getString("DefectType"));
	    			bi.setStatus(rs.getString("State"));
	    			bi.setDescription(rs.getString("Description"));
	    			bi.setOwner(rs.getString("OwnerNm"));
	    			bi.setSubmitter(rs.getString("SubmitterNm"));
	    			bi.setProject(rs.getString("Project"));
	    			bi.setSubmitData(Timestamp.valueOf(rs.getString("SubmitDate")));
	    			bi.setSeverity(rs.getString("Severity"));
	    			bi.setTags(rs.getString("Tags"));
	    			bi.setRegression(rs.getString("Regression"));
	    			returnList.add(bi);
	    		}
    		}
    		
    		if (oldBuginfoList != null && oldBuginfoList.size() > 0) {
	    		rs.close();
	    		ps.close();
	    		ct.close();
    		}
    		
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
		return returnList;
	}
	
    public static Buginfo getBugInfoByBugId(String bugId) {
    	
    	PreparedStatement ps = null;
    	Connection ct = null;
    	ResultSet rs = null;
    	Buginfo bi = null;
    	try {
    		Class.forName(DriverName);
    		ct = DriverManager.getConnection(DatabaseUrl);
    		ps = ct.prepareStatement("select * from OB_Bugs where BUGID=?");
    		ps.setString(1, bugId);
    		
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			bi = new Buginfo();
    			bi.setBugId(bugId);
    			bi.setTitle(rs.getString("Title"));
    			bi.setType(rs.getString("DefectType"));
    			bi.setStatus(rs.getString("State"));
    			bi.setDescription(rs.getString("Description"));
    			bi.setOwner(rs.getString("OwnerNm"));
    			bi.setSubmitter(rs.getString("SubmitterNm"));
    			bi.setProject(rs.getString("Project"));
    			bi.setSubmitData(Timestamp.valueOf(rs.getString("SubmitDate")));
    			bi.setSeverity(rs.getString("Severity"));
    			bi.setTags(rs.getString("Tags"));
    			bi.setRegression(rs.getString("Regression"));
    		}
    		rs.close();
    		ps.close();
    		ct.close();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
		return bi;
    }
    
}
