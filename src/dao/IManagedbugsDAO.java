package dao;

import java.util.List;

import bean.Managedbugs;


public interface IManagedbugsDAO {
	public List findAll();
	
	public Managedbugs findById(Integer id);

	public void save(Managedbugs mb);
	
	public void update(Managedbugs mb);
	
	public void delete(Managedbugs mb);
}
