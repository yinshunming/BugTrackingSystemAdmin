package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.IBuginfoDAO;
import dao.IManagedbugsDAO;
import dao.IOwnerbugsDAO;
import dao.IUserinfoDAO;

import bean.Managedbugs;
import bean.Ownerbugs;
import bean.Userinfo;
import bean.Buginfo;
import service.IUserinfoService;

public class UserinfoServiceImpl implements IUserinfoService{
	
	private IUserinfoDAO userinfoDAO;
	private IManagedbugsDAO managedbugsDAO;
	private IOwnerbugsDAO ownerbugsDAO;
	private IBuginfoDAO buginfoDAO;
	
	public IManagedbugsDAO getManagedbugsDAO() {
		return managedbugsDAO;
	}

	public void setManagedbugsDAO(IManagedbugsDAO managedbugsDAO) {
		this.managedbugsDAO = managedbugsDAO;
	}

	public IOwnerbugsDAO getOwnerbugsDAO() {
		return ownerbugsDAO;
	}

	public void setOwnerbugsDAO(IOwnerbugsDAO ownerbugsDAO) {
		this.ownerbugsDAO = ownerbugsDAO;
	}

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
	public Integer addUserinfo(String username, String password,
			String oneBugFullName, String email) {
		// TODO Auto-generated method stub
		
		Userinfo ui = new Userinfo(username, password, oneBugFullName, email);
		userinfoDAO.save(ui);
		return ui.getId();
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
			List<Managedbugs> managedbugsList = managedbugsDAO.findByUserInfoId(id);
			
			for (Managedbugs managedbugs : managedbugsList) {
				
				Buginfo bi = buginfoDAO.findById(managedbugs.getBugInfoId());
				if (bi != null) {
					buginfoDAO.delete(bi);
				}
				
				managedbugsDAO.delete(managedbugs);
			}
			
			List<Ownerbugs> ownerbugsList = ownerbugsDAO.findByUserInfoId(id);
			for (Ownerbugs ownerbugs : ownerbugsList) {
				ownerbugsDAO.delete(ownerbugs);
				Buginfo bi = buginfoDAO.findById(ownerbugs.getBugInfoId());
				if (bi != null) {
					buginfoDAO.delete(bi);
				}
				
				ownerbugsDAO.delete(ownerbugs);
			}
		
		}
	}

	public IBuginfoDAO getBuginfoDAO() {
		return buginfoDAO;
	}

	public void setBuginfoDAO(IBuginfoDAO buginfoDAO) {
		this.buginfoDAO = buginfoDAO;
	}
	
	

}
