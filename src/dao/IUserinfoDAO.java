package dao;

import java.util.List;

import bean.Userinfo;

public interface IUserinfoDAO {
	public List findByUsername(Object username);
	
	public Userinfo findById(java.lang.Integer id);
	
	public void save(Userinfo transientInstance);
}
