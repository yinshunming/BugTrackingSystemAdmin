package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.IBuginfoDAO;
import dao.IManagedbugsDAO;
import dao.IUserinfoDAO;

import bean.Buginfo;
import bean.Managedbugs;
import bean.Userinfo;
import bean.WarppedManagedbugs;
import service.IManagedbugsService;

public class ManagedbugsServiceImpl implements IManagedbugsService{
	private IManagedbugsDAO managedbugsDAO;
	private IBuginfoDAO buginfoDAO;
	private IUserinfoDAO userinfoDAO;
	
	public IBuginfoDAO getBuginfoDAO() {
		return buginfoDAO;
	}
	public void setBuginfoDAO(IBuginfoDAO buginfoDAO) {
		this.buginfoDAO = buginfoDAO;
	}
	public IUserinfoDAO getUserinfoDAO() {
		return userinfoDAO;
	}
	public void setUserinfoDAO(IUserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}
	public IManagedbugsDAO getManagedbugsDAO() {
		return managedbugsDAO;
	}
	public void setManagedbugsDAO(IManagedbugsDAO managedbugsDAO) {
		this.managedbugsDAO = managedbugsDAO;
	}
	
	@Override
	public List<WarppedManagedbugs> getManagedbugsList() {
		// TODO Auto-generated method stub
		List<Managedbugs> managedBugsList = managedbugsDAO.findAll();
		List<WarppedManagedbugs> wmList = new ArrayList<WarppedManagedbugs>();
	
		for (Managedbugs managedbug : managedBugsList) {
			int buginfoId = managedbug.getBugInfoId();
			int userinfoId = managedbug.getUserInfoId();
			Buginfo bi = buginfoDAO.findById(buginfoId);
			Userinfo ui = userinfoDAO.findById(userinfoId);
			if (bi != null && ui != null) {
				WarppedManagedbugs wmb = new WarppedManagedbugs(ui, bi , managedbug.getStatus(), managedbug.getId());
				wmList.add(wmb);
			}
		}
		
		return wmList;
	}
	@Override
	public void addManagedbug(int userinfoId, int buginfoId) {
		// TODO Auto-generated method stub
		Managedbugs mb = new Managedbugs(userinfoId, buginfoId);
		if (mb != null)
			managedbugsDAO.save(mb);
		
	}
	@Override
	public void updateManagedbug(int id, int userinfoId, int buginfoId) {
		// TODO Auto-generated method stub
		Managedbugs mb = new Managedbugs(userinfoId, buginfoId);
		mb.setId(id);
		managedbugsDAO.update(mb);
	}
	@Override
	public void deleteManagedbug(int id) {
		// TODO Auto-generated method stub
		Managedbugs mb = managedbugsDAO.findById(id);
		if (mb != null) {
			managedbugsDAO.delete(mb);
		}
	}

}
