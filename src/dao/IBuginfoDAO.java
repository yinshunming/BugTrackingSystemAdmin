package dao;

import bean.Buginfo;

public interface IBuginfoDAO {
	public Buginfo findById(java.lang.Integer id);
	public void delete(Buginfo persistentInstance);
	public void save(Buginfo persistentInstance);
}
