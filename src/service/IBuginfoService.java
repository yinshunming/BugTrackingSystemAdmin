package service;

import java.util.List;
import java.util.Map;

import bean.Buginfo;

public interface IBuginfoService {
	public Buginfo getBuginfoById(String bugId); //from datamart
	
	public Buginfo getBuginfoFromLocalById(Integer id);
	
	public void saveBuginfo(String username, String bugId, String component, String title, String project, String type, String status, String description, String owner,
			String submitter, String sumitterData, String severity, String tags, String regression);
	
	public List<Buginfo> getBuginfoListByUserName(String username, boolean managed);
	
	public Buginfo getBuginfoByBugId(String bugId); //from local database
	
	public List<Buginfo> refreshBuginfo(List<Buginfo> ownerBuginfoList);
	
	public List<Buginfo> modifyBugCategory(Map<String, String> modifies, String username);
	
	public void updateStatus(Integer id, String bugId, String status);
	
	public void deleteById(String username, Integer id);

	public void operateBuginfoByUserName(String username, Integer id, String operate);
}
