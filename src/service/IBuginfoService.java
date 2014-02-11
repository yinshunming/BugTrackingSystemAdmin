package service;

import java.util.List;
import java.util.Map;

import bean.Buginfo;
import bean.WarppedBuginfo;

public interface IBuginfoService {
	public Buginfo getBuginfoById(String bugId); //from datamart
	
	public void addOwnerBuginfoList(String oneBugFullName, String username); //from datamart
	
	public Buginfo getBuginfoFromLocalById(Integer id);
	
	public String saveBuginfo(String username, String bugId, String component, String title, String project, String type, String status, String description, String owner,
			String submitter, String sumitterData, String severity, String tags, String regression);
	
	
	public Buginfo getBuginfoByBugId(String bugId); //from local database
	
	public List<Buginfo> refreshBuginfo(List<Buginfo> ownerBuginfoList);
	
	//public List<Buginfo> modifyBugCategory(Map<String, String> modifies, String username);
	
	public void updateStatus(Integer id, String bugId, String status);
	
}
