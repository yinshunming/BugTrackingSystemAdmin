package service.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Buginfo;
import bean.Ownerbugs;
import bean.Userinfo;
import bean.WarppedManagedbugs;
import bean.WarppedOwnerbugs;
import dao.IBuginfoDAO;
import dao.IOwnerbugsDAO;
import dao.IUserinfoDAO;
import service.IOwnerbugsService;

public class OwnerbugsServiceImpl implements IOwnerbugsService{
	private IOwnerbugsDAO ownerbugsDAO;
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

	@Override
	public void deleteOwnerbugs(int id) {
		// TODO Auto-generated method stub
		Ownerbugs ob =  ownerbugsDAO.findById(id);
		if (ob != null)
			ownerbugsDAO.delete(ob);
	}

	public IOwnerbugsDAO getOwnerbugsDAO() {
		return ownerbugsDAO;
	}

	public void setOwnerbugsDAO(IOwnerbugsDAO ownerbugsDAO) {
		this.ownerbugsDAO = ownerbugsDAO;
	}

	@Override
	public List<WarppedOwnerbugs> getOwnerbugs() {
		// TODO Auto-generated method stub
		List<Ownerbugs> ownerbugsList = ownerbugsDAO.findAll();
		List<WarppedOwnerbugs> wmList = new ArrayList<WarppedOwnerbugs> ();
		
		
		for (Ownerbugs ownerbug : ownerbugsList) {
			int buginfoId = ownerbug.getBugInfoId();
			int userinfoId = ownerbug.getUserInfoId();
			
			Buginfo bi = buginfoDAO.findById(buginfoId);
			Userinfo ui = userinfoDAO.findById(userinfoId);
			
			if (bi != null && ui != null) {
				WarppedOwnerbugs wmb = new WarppedOwnerbugs(ui, bi, ownerbug.getStatus(), ownerbug.getId(), ownerbug.getChanged(), ownerbug.getNewOwner());
				wmList.add(wmb);
			}
		}
		
		return wmList;
	}

}
