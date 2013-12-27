package service;

import java.util.List;
import java.util.Map;

import bean.Buginfo;
import bean.WarppedBuginfo;

public interface IManagedbugsService {
	public List<Buginfo> getManagedBugsByUserName(String username);
	
	public List<WarppedBuginfo>	getHistroyBugsByUserName(String username);
	
	public void deleteBugsByUserName(String username, Integer managedBugId, Integer id);
	
	public void operateBugsByUserName(String username, Integer managedBugId, Integer id, String operate);
}
