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
	public String saveBuginfo(String username, String bugId, String component, String title,
			String project, String type, String status, String description, String owner,
			String submitter, String sumitterData, String severity,
			String tags, String regression) {
		// TODO Auto-generated method stub
			List<Buginfo> biList = buginfoDao.findByBugId(bugId);
			Buginfo bg = null;
			
			if (biList != null && biList.size() != 0) {
				bg = biList.get(0);
			} else {
				bg = new Buginfo(bugId, title, project, type, status,
						description,  owner, submitter,
						Timestamp.valueOf(sumitterData), severity,  tags,
						 regression,  component);
				buginfoDao.save(bg);
			}

			List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
			
			if (userinfoList != null && userinfoList.size() > 0) {
				Userinfo ui = userinfoList.get(0);
				if (ui.getOneBugFullName().equals(owner)) {
					Ownerbugs ob = new Ownerbugs(ui.getId(), bg.getId());
					try {
						ownerBugsDao.save(ob);
					} catch (Exception ex) {
						System.out.println("*****************************************************");
						return ConstantUtil.addFailure;
					}
				} else {  //needs to add to one's managed list
					Managedbugs mb = new Managedbugs(ui.getId(), bg.getId());
					try {
						managedBugsDao.save(mb);
					} catch (Exception ex) {
						System.out.println("*****************************************************");
						return ConstantUtil.addFailure;
					}
				
				}
			}
			
			return ConstantUtil.addOK;
		
	}
	
	public void addOwnerBuginfoList(String oneBugFullName, String username) {
		List<Buginfo> returnList = DataMartAccess.getOwnerBuginfoList(oneBugFullName);
		
		for (Buginfo bi : returnList) {
			buginfoDao.save(bi);
			
			List<Userinfo> userinfoList = userinfoDao.findByUsername(username);
			
			if (userinfoList != null && userinfoList.size() > 0) {
				Userinfo ui = userinfoList.get(0);
				Ownerbugs ob = new Ownerbugs(ui.getId(), bi.getId());
				ownerBugsDao.save(ob);
			}
		}
		
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
	
	/*
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
				
 			
				List<Userinfo> ui = userinfoDao.findByUsername(username);
				
				if (ui != null && ui.size() > 0 && newBuginfo != null) {
					Managedbugs mb = new Managedbugs(ui.get(0).getId(), newBuginfo.getId());
					
					managedBugsDao.save(mb);
				
					buginfoDao.update(newBuginfo);
				}
				
			} else if (value.equals(ConstantUtil.ingoreStr)) {
				
			

				Buginfo deleteBuginfo = buginfoDao.findById(Integer.valueOf(id));
				
				if (deleteBuginfo != null ) {
					deleteBuginfo.setManagedStatus(ConstantUtil.ingoredBugsStatus);
					buginfoDao.update(deleteBuginfo);
				}
				
			}
			
		}
		
		return null;
	}
	*/
	
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
	public void updateComponent(Integer id, String bugId, String component) {
		// TODO Auto-generated method stub
		Buginfo bi = buginfoDao.findById(id);
		if (bi != null) {
			bi.setComponent(component);
			buginfoDao.update(bi);
		}
	}
	
	
}
