package service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.i18n.client.Constants;

import dao.IBuginfoDAO;
import dao.IManagedbugsDAO;
import dao.IOwnerbugsDAO;
import dao.IUserinfoDAO;
import dao.impl.BuginfoDAOImpl;
import database.DataMartAccess;
import bean.Buginfo;
import bean.Managedbugs;
import bean.Ownerbugs;
import bean.Userinfo;
import bean.WarppedBuginfo;
import service.IBuginfoService;
import util.ConstantUtil;

public class BuginfoServiceImpl implements IBuginfoService{
	private IBuginfoDAO buginfoDao;
	private IUserinfoDAO userinfoDao;
	private IManagedbugsDAO managedBugsDao;
	private IOwnerbugsDAO ownerBugsDao;
	
	public IOwnerbugsDAO getOwnerBugsDao() {
		return ownerBugsDao;
	}
	public void setOwnerBugsDao(IOwnerbugsDAO ownerBugsDao) {
		this.ownerBugsDao = ownerBugsDao;
	}
	public IUserinfoDAO getUserinfoDao() {
		return userinfoDao;
	}
	public void setUserinfoDao(IUserinfoDAO userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	
	
	@Override
	public Buginfo getBuginfoById(String bugId) {
		// TODO Auto-generated method stub
		Buginfo bf = DataMartAccess.getBugInfoByBugId(bugId);
		return bf;
	}
	public IBuginfoDAO getBuginfoDao() {
		return buginfoDao;
	}
	
	public void setBuginfoDao(IBuginfoDAO buginfoDao) {
		this.buginfoDao = buginfoDao;
	}
	
	@Override
	public void saveBuginfo(String username, String bugId, String component, String title,
			String project, String type, String status, String description, String owner,
			String submitter, String sumitterData, String severity,
			String tags, String regression) {
		// TODO Auto-generated method stub
		
		
	
			Buginfo bg = new Buginfo(bugId, title, project, type, status,
					description,  owner, submitter,
					Timestamp.valueOf(sumitterData), severity,  tags,
					 regression,  component);
			
 			buginfoDao.save(bg);
			
			List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
			
			if (userinfoList != null && userinfoList.size() > 0) {
				Userinfo ui = userinfoList.get(0);
				if (ui.getOneBugFullName().equals(owner)) {
					Ownerbugs ob = new Ownerbugs(ui.getId(), bg.getId());
					ownerBugsDao.save(ob);
					
				} else {  //needs to add to one's managed list
					Managedbugs mb = new Managedbugs(ui.getId(), bg.getId());
					
					managedBugsDao.save(mb);
				
				}
			}
		
	}
	
	@Override
	public List<Buginfo> getBuginfoListByUserName(String username) {
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
	public Buginfo getBuginfoByBugId(String bugId) {
		// TODO Auto-generated method stub
		List<Buginfo> buginfoList = buginfoDao.findByBugId(bugId);
		if (buginfoList != null && buginfoList.size() > 0) {
			return buginfoList.get(0);
		}
		
		return null;
	}
	
	@Override
	public List<Buginfo> refreshBuginfo(List<Buginfo> ownerBuginfoList) {
		// TODO Auto-generated method stub
		List<Buginfo> retList = DataMartAccess.getDifferentBugId(ownerBuginfoList);
		
		if (retList.size()>0)
			return retList;
		
		return null;
	}
	
	@Override
	public List<Buginfo> modifyBugCategory(Map<String, String> radio_map,
			String username) {
		// TODO Auto-generated method stub
		
		for (String key : radio_map.keySet()) {
			String value = radio_map.get(key);
			String [] idArray = key.split(ConstantUtil.prefix);
			
			String id = idArray[1];
			System.out.println("bugId: " + id);
			
			if (value.equals(ConstantUtil.manageStr)) {
 				Buginfo oldBuginfo = buginfoDao.findById(Integer.valueOf(id));
 				Buginfo newBuginfo = null;
 				if (oldBuginfo != null) {
 					newBuginfo = DataMartAccess.getBugInfoByBugId(oldBuginfo.getBugId());
					newBuginfo.setId(oldBuginfo.getId());
				}
				
 				
 				/*
				List<Userinfo> ui = userinfoDao.findByUsername(username);
				
				if (ui != null && ui.size() > 0 && newBuginfo != null) {
					Managedbugs mb = new Managedbugs(ui.get(0).getId(), newBuginfo.getId());
					
					managedBugsDao.save(mb);
				
					buginfoDao.update(newBuginfo);
				}
				*/
			} else if (value.equals(ConstantUtil.ingoreStr)) {
				
				/*
				Buginfo deleteBuginfo = buginfoDao.findById(Integer.valueOf(id));
				
				if (deleteBuginfo != null ) {
					deleteBuginfo.setManagedStatus(ConstantUtil.ingoredBugsStatus);
					buginfoDao.update(deleteBuginfo);
				}
				*/
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
	
	@Override
	public Buginfo getBuginfoFromLocalById(Integer id) {
		// TODO Auto-generated method stub
		return buginfoDao.findById(id);
	}
	@Override
	public void updateStatus(Integer id, String bugId, String status) {
		// TODO Auto-generated method stub
		Buginfo bi = buginfoDao.findById(id);
		if (bi != null) {
			bi.setStatus(status);
			buginfoDao.update(bi);
		}
	}
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

	

	

	
}
