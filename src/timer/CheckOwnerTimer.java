package timer;

import dao.IBuginfoDAO;
import dao.IOwnerbugsDAO;
import database.DataMartAccess;
import util.ConstantUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Buginfo;
import bean.Ownerbugs;
import bean.WarppedBuginfo;

public class CheckOwnerTimer {
	private IOwnerbugsDAO ownerbugsDao;
	private IBuginfoDAO buginfoDao;
	
	public IOwnerbugsDAO getOwnerbugsDao() {
		return ownerbugsDao;
	}

	public void setOwnerbugsDao(IOwnerbugsDAO ownerbugsDao) {
		this.ownerbugsDao = ownerbugsDao;
	}

	public void check() {
		Timestamp tt = new Timestamp(System.currentTimeMillis());  
        System.out.println(tt.toString());  
		List<Ownerbugs> ownerBugsList = ownerbugsDao.findAll();
		
		List<WarppedBuginfo> oldBugList = new ArrayList<WarppedBuginfo>();

		for (Ownerbugs ownerBug : ownerBugsList) {
			if (ownerBug.getStatus().equals(ConstantUtil.managedBugsStatus) && ownerBug.getChanged().equals(ConstantUtil.ownerNotChanged)) {
				Buginfo bugInfo = buginfoDao.findById(ownerBug.getBugInfoId());
				if (bugInfo != null) {
					WarppedBuginfo wb = new WarppedBuginfo(bugInfo, ownerBug.getStatus(), ownerBug.getId());
					oldBugList.add(wb);
				}
			}	
		}
		
		List<WarppedBuginfo> differentBugInfoList = DataMartAccess.getDifferentBugByOldList(oldBugList);
		
		for (WarppedBuginfo differentBuginfo : differentBugInfoList) {
			Ownerbugs ob = ownerbugsDao.findById(differentBuginfo.getManagedBugId());
			if (ob != null) {
				ob.setChanged(ConstantUtil.ownerChanged);
				ownerbugsDao.update(ob);
			}
		}
		
	}

	public IBuginfoDAO getBuginfoDao() {
		return buginfoDao;
	}

	public void setBuginfoDao(IBuginfoDAO buginfoDao) {
		this.buginfoDao = buginfoDao;
	}
}
