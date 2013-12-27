package dao;

import java.util.List;

import bean.Managedbugs;


public interface IManagedbugsDAO {
	public List findByUserInfoId(Object userInfoId);
	
	public void save(Managedbugs transientInstance);
	
	public List findByBugInfoId(Object bugInfoId);
	
	public Managedbugs findById(java.lang.Integer id);
	
	public void delete(Managedbugs persistentInstance);
	
	public void update(Managedbugs instance);
}
