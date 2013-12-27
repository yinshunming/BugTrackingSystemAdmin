package service;

import bean.Userinfo;

public interface IUserinfoSerivce {
	public Userinfo getUserinfoByUsername(String username);
	
	public void save(String username, String password, String oneBugFullName, String email);
}	
