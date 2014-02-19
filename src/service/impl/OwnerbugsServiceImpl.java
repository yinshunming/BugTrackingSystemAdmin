package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.IBuginfoDAO;
import dao.IManagedbugsDAO;
import dao.IOwnerbugsDAO;
import dao.IUserinfoDAO;
import database.DataMartAccess;

import bean.Buginfo;
import bean.Managedbugs;
import bean.Ownerbugs;
import bean.Userinfo;
import bean.WarppedBuginfo;
import service.IOwnerbugsService;
import util.ConstantUtil;

public class OwnerbugsServiceImpl implements IOwnerbugsService{
	
	private IBuginfoDAO buginfoDao;
	private IUserinfoDAO userinfoDao;
	private IManagedbugsDAO managedBugsDao;
	private IOwnerbugsDAO ownerBugsDao;
	
	@Override
	public void deleteById(String username, Integer managedBugId, Integer id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Ownerbugs mbgs = ownerBugsDao.findById(managedBugId);
		Buginfo bi = buginfoDao.findById(id);
		if (mbgs != null && bi != null && bi.getId().equals(mbgs.getBugInfoId())) {
			Userinfo ui = userinfoDao.findById(mbgs.getUserInfoId());
			if (ui != null && ui.getUsername().equals(username)) {
				ownerBugsDao.delete(mbgs);
				buginfoDao.delete(bi);
			}
		}
	}
	
	public IBuginfoDAO getBuginfoDao() {
		return buginfoDao;
	}

	public void setBuginfoDao(IBuginfoDAO buginfoDao) {
		this.buginfoDao = buginfoDao;
	}

	public IUserinfoDAO getUserinfoDao() {
		return userinfoDao;
	}

	public void setUserinfoDao(IUserinfoDAO userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	public IOwnerbugsDAO getOwnerBugsDao() {
		return ownerBugsDao;
	}

	public void setOwnerBugsDao(IOwnerbugsDAO ownerBugsDao) {
		this.ownerBugsDao = ownerBugsDao;
	}

	@Override
	public void operateBuginfoByUserName(String username, Integer managedBugId, Integer id, String operate) {
		// TODO Auto-generated method stub
		Ownerbugs mbgs = ownerBugsDao.findById(managedBugId);
		Buginfo bi = buginfoDao.findById(id);
		if (mbgs != null && bi != null && bi.getId().equals(mbgs.getBugInfoId())) {
			Userinfo ui = userinfoDao.findById(mbgs.getUserInfoId());
			if (ui != null && ui.getUsername().equals(username)) {
				if (operate.equals(ConstantUtil.ingoreCmd)) {
					mbgs.setStatus(ConstantUtil.ingoredBugsStatus);
					 ownerBugsDao.update(mbgs);
				} else if (operate.equals(ConstantUtil.resotoreCmd)) {
					mbgs.setStatus(ConstantUtil.managedBugsStatus);
					 ownerBugsDao.update(mbgs);
				}
			}
		}
	}
	@Override
	public List<WarppedBuginfo> getHistoryOwnerBuginfoListByUserName(String username) {
		// TODO Auto-generated method stub
		List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
		List<WarppedBuginfo> buginfoList = null;
		
		if (userinfoList != null && userinfoList.size() > 0) {
			Userinfo ui = userinfoList.get(0);
			
			List<Ownerbugs> ownerbugsList = ownerBugsDao.findByUserInfoId(ui.getId());
			if (ownerbugsList != null && ownerbugsList.size() > 0) {
				buginfoList = new ArrayList<WarppedBuginfo>();
				for (Ownerbugs ownerbug : ownerbugsList) {
					Buginfo bi = buginfoDao.findById(ownerbug.getBugInfoId());
					if (bi != null) {
						WarppedBuginfo wb = new WarppedBuginfo(bi, ownerbug.getStatus(), ownerbug.getId());
						buginfoList.add(wb);
					}
				}

			}
		
		}
		
		return buginfoList;

	}
	
	@Override
	public List<Buginfo> getOwnerBuginfoListByUserName(String username) {
		// TODO Auto-generated method stub
		List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
		List<Buginfo> buginfoList = null;
		
		if (userinfoList != null && userinfoList.size() > 0) {
			Userinfo ui = userinfoList.get(0);
			
			List<Ownerbugs> ownerbugsList = ownerBugsDao.findByUserInfoId(ui.getId());
			if (ownerbugsList.size() > 0) {
				buginfoList = new ArrayList<Buginfo> ();
			}
		
			for (Ownerbugs ownerbug : ownerbugsList) {
				if (ownerbug.getStatus().equals(ConstantUtil.managedBugsStatus)) {
					Buginfo bi = buginfoDao.findById(ownerbug.getBugInfoId());
					if (bi != null)
						buginfoList.add(bi);
				}
			}

		}
		
		return buginfoList;
	}

	@Override
	public List<WarppedBuginfo> getChangedListByUserName(String username) {
		// TODO Auto-generated method stub
		List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
		List<WarppedBuginfo> buginfoList = null;
		
		if (userinfoList != null && userinfoList.size() > 0) {
			Userinfo ui = userinfoList.get(0);
			
			List<Ownerbugs> ownerbugsList = ownerBugsDao.findByUserInfoId(ui.getId());
			if (ownerbugsList != null && ownerbugsList.size() > 0) {
				buginfoList = new ArrayList<WarppedBuginfo>();
				for (Ownerbugs ownerbug : ownerbugsList) {
					if (ownerbug.getStatus().equals(ConstantUtil.managedBugsStatus) && ownerbug.getChanged().equals(ConstantUtil.ownerChanged)) {
						Buginfo bi = buginfoDao.findById(ownerbug.getBugInfoId());
						if (bi != null) {
							WarppedBuginfo wb = new WarppedBuginfo(bi, ownerbug.getStatus(), ownerbug.getId(), ownerbug.getNewOwner());
							buginfoList.add(wb);
						}
				}

			}
		  }
		}
		
		return buginfoList;
	}

	@Override
	public List<Buginfo> modifyBugCategory(Map<String, String> radio_map, String username) {
		// TODO Auto-generated method stub
		for (String key : radio_map.keySet()) {
			String value = radio_map.get(key);
			String [] idArray = key.split(ConstantUtil.separator);
			
			String id = idArray[1];
			String ownerId = idArray[2];
			System.out.println("bugId: " + id  + " " + ownerId);

			Ownerbugs ob = ownerBugsDao.findById(Integer.valueOf(ownerId));
			Buginfo oldBuginfo = buginfoDao.findById(Integer.valueOf(id));
			Userinfo ui = userinfoDao.findById(ob.getUserInfoId());
			if (ui != null && ui.getUsername().equals(username)) {
				if (ob != null && oldBuginfo != null && ob.getBugInfoId().equals(oldBuginfo.getId())) {
					if (value.equals(ConstantUtil.manageStr)) {
	 					Buginfo newBuginfo = null;
		 				if (oldBuginfo != null) {
		 					newBuginfo = DataMartAccess.getBugInfoByBugId(oldBuginfo.getBugId());
							newBuginfo.setId(oldBuginfo.getId());
						}
		 				
		 				Managedbugs mb = new Managedbugs(ui.getId(), newBuginfo.getId());
						managedBugsDao.save(mb);
						
						ownerBugsDao.delete(ob);
					
						buginfoDao.update(newBuginfo);
	
					} else if (value.equals(ConstantUtil.ingoreStr)) {
						ob.setStatus(ConstantUtil.ingoredBugsStatus);
						ownerBugsDao.update(ob);
					}
				}
			}
		}

		return null;
	}

	public IManagedbugsDAO getManagedBugsDao() {
		return managedBugsDao;
	}

	public void setManagedBugsDao(IManagedbugsDAO managedBugsDao) {
		this.managedBugsDao = managedBugsDao;
	}


}
