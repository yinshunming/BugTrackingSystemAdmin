package service;
import java.util.List;

import  bean.Userinfo;

public interface IUserinfoService {
	public List<Userinfo> getUserinfoList();
	public Integer addUserinfo(String username, String password, String oneBugFullName, String email);
	public void updateUserinfo(Integer id, String username, String password, String oneBugFullName, String email);
	public void deleteUserinfo(Integer id);
}
