package service;

import java.util.List;
import java.util.Map;

import bean.Buginfo;
import bean.WarppedBuginfo;

public interface IOwnerbugsService {
	public void deleteById(String username, Integer managedBugId, Integer id);
	public void operateBuginfoByUserName(String username, Integer managedBugId, Integer id, String operate);
	public List<WarppedBuginfo> getHistoryOwnerBuginfoListByUserName(String username);
	
	public List<WarppedBuginfo> getChangedListByUserName(String username);
	
	public List<Buginfo> getOwnerBuginfoListByUserName(String username);
	
	public List<Buginfo> modifyBugCategory(Map<String, String> radio_map, String username);
}
