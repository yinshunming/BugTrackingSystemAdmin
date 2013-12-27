package dao;

import java.util.List;

import bean.Buginfo;

public interface IBuginfoDAO {
	public void save(Buginfo transientInstance);
	
	public List findByOwner(Object owner);
	
	public Buginfo findById(Integer id);
	
	public List findByBugId(Object bugId);
	
	public void delete(Buginfo persistentInstance);
	
	public void update(Buginfo instance);
	
}
