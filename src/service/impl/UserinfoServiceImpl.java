package service.impl;

import java.util.List;

import bean.Userinfo;
import dao.IUserinfoDAO;
import service.IUserinfoSerivce;

public class UserinfoServiceImpl implements IUserinfoSerivce {
	private IUserinfoDAO userinfoDao;

	public IUserinfoDAO getUserinfoDao() {
		return userinfoDao;
	}

	public void setUserinfoDao(IUserinfoDAO userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	@Override
	public Userinfo getUserinfoByUsername(String username) {
		// TODO Auto-generated method stub
		List<Userinfo> userInfoList = userinfoDao.findByUsername(username);
		if (userInfoList != null && userInfoList.size() > 0)
			return userInfoList.get(0);
		
		return null;
	}

	@Override
	public void save(String username, String password, String oneBugFullName,
			String email) {
		// TODO Auto-generated method stub
		Userinfo userInfo = new Userinfo(username, password, oneBugFullName, email);
		userinfoDao.save(userInfo);
	}
	
	
}
