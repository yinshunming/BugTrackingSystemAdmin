package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;

import bean.Buginfo;
import bean.Managedbugs;
import bean.Userinfo;
import bean.WarppedBuginfo;
import dao.IBuginfoDAO;
import dao.IManagedbugsDAO;
import dao.IUserinfoDAO;
import service.IManagedbugsService;
import util.ConstantUtil;

public class ManagedbugsServiceImpl implements IManagedbugsService{
	private IManagedbugsDAO managedbugsDao;
	private IUserinfoDAO userinfoDao;
	private IBuginfoDAO buginfoDao;

	public IManagedbugsDAO getManagedbugsDao() {
		return managedbugsDao;
	}

	public void setManagedbugsDao(IManagedbugsDAO managedbugsDao) {
		this.managedbugsDao = managedbugsDao;
	}

	@Override
	public List<Buginfo> getManagedBugsByUserName(String username) {
		// TODO Auto-generated method stub
		
		List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
		List<Buginfo> buginfoList = null;
		
		if (userinfoList != null && userinfoList.size() > 0) {
			Userinfo ui = userinfoList.get(0);
			
			List<Managedbugs> managedbugsList = managedbugsDao.findByUserInfoId(ui.getId());
			if (managedbugsList.size() > 0) {
				buginfoList = new ArrayList<Buginfo> ();
			}
			
			for (Managedbugs managedbug : managedbugsList) {
				if (managedbug.getStatus().equals(ConstantUtil.managedBugsStatus)) {
					Buginfo bi = buginfoDao.findById(managedbug.getBugInfoId());
					if (bi != null)
						buginfoList.add(bi);
				}
			}
		}
		
		return buginfoList;
	}

	public IUserinfoDAO getUserinfoDao() {
		return userinfoDao;
	}

	public void setUserinfoDao(IUserinfoDAO userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	public IBuginfoDAO getBuginfoDao() {
		return buginfoDao;
	}

	public void setBuginfoDao(IBuginfoDAO buginfoDao) {
		this.buginfoDao = buginfoDao;
	}


	public List<WarppedBuginfo> getHistroyBugsByUserName(String username) {
		// TODO Auto-generated method stub
		
		List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
		List<WarppedBuginfo> buginfoList = null;
		
		if (userinfoList != null && userinfoList.size() > 0) {
			Userinfo ui = userinfoList.get(0);
			
			List<Managedbugs> managedbugsList = managedbugsDao.findByUserInfoId(ui.getId());
			if (managedbugsList != null && managedbugsList.size() > 0) {
				buginfoList = new ArrayList<WarppedBuginfo>();
				for (Managedbugs managedbug : managedbugsList) {
					Buginfo bi = buginfoDao.findById(managedbug.getBugInfoId());
					if (bi != null) {
						WarppedBuginfo wb = new WarppedBuginfo(bi, managedbug.getStatus(), managedbug.getId());
						buginfoList.add(wb);
					}
				}

			}
		
		}
		
		return buginfoList;
	}

	@Override
	public void deleteBugsByUserName(String username, Integer managedBugId, Integer id) {
		// TODO Auto-generated method stub
		Managedbugs mbgs = managedbugsDao.findById(managedBugId);
		Buginfo bi = buginfoDao.findById(id);
		if (mbgs != null && bi != null && bi.getId().equals(mbgs.getBugInfoId())) {
			Userinfo ui = userinfoDao.findById(mbgs.getUserInfoId());
			if (ui != null && ui.getUsername().equals(username)) {
				managedbugsDao.delete(mbgs);
				buginfoDao.delete(bi);
			}
		}
		
	}

	@Override
	public void operateBugsByUserName(String username, Integer managedBugId,
			Integer id, String operate) {
		// TODO Auto-generated method stub
		Managedbugs mbgs = managedbugsDao.findById(managedBugId);
		Buginfo bi = buginfoDao.findById(id);
		if (mbgs != null && bi != null && bi.getId().equals(mbgs.getBugInfoId())) {
			Userinfo ui = userinfoDao.findById(mbgs.getUserInfoId());
			if (ui != null && ui.getUsername().equals(username)) {
				if (operate.equals(ConstantUtil.ingoreCmd)) {
					mbgs.setStatus(ConstantUtil.ingoredBugsStatus);
					managedbugsDao.update(mbgs);
				} else if (operate.equals(ConstantUtil.resotoreCmd)) {
					mbgs.setStatus(ConstantUtil.managedBugsStatus);
					managedbugsDao.update(mbgs);
				}
			}
		}
	}


}
