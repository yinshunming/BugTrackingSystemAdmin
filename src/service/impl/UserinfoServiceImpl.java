package service.impl;

import java.util.List;

import dao.IUserinfoDAO;

import bean.Userinfo;
import service.IUserinfoService;

public class UserinfoServiceImpl implements IUserinfoService{
	
	private IUserinfoDAO userinfoDAO;
	
	@Override
	public List<Userinfo> getUserinfoList() {
		// TODO Auto-generated method stub
		List<Userinfo> userinfoList = userinfoDAO.findAll();
		return userinfoList;
	}

	public IUserinfoDAO getUserinfoDAO() {
		return userinfoDAO;
	}

	public void setUserinfoDAO(IUserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}


	@Override
	public void addUserinfo(String username, String password,
			String oneBugFullName, String email) {
		// TODO Auto-generated method stub
		
		Userinfo ui = new Userinfo(username, password, oneBugFullName, email);
		userinfoDAO.save(ui);
	}

	@Override
	public void updateUserinfo(Integer id, String username, String password,
			String oneBugFullName, String email) {
		// TODO Auto-generated method stub
		Userinfo ui = new Userinfo(username, password, oneBugFullName, email);
		ui.setId(id);
		userinfoDAO.update(ui);
	}

	@Override
	public void deleteUserinfo(Integer id) {
		// TODO Auto-generated method stub
		Userinfo ui = userinfoDAO.findById(id);
		if (ui != null) {
			userinfoDAO.delete(ui);
		}
	}
	
	

}
