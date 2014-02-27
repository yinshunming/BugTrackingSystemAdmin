package dao;

import java.util.List;

import bean.Userinfo;

public interface IUserinfoDAO {
	public List findAll();
	
	public void save(Userinfo transientInstance);
	
	public void update(Userinfo instance);
	
	public void delete(Userinfo instance);
	
	public Userinfo findById(Integer id);
}
