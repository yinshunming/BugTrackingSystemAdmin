package service.impl;

import database.DataMartAccess;
import bean.Buginfo;
import service.IBuginfoService;

public class BuginfoServiceImpl implements IBuginfoService{

	@Override
	public Buginfo getBuginfoById(String bugId) {
		// TODO Auto-generated method stub
		return DataMartAccess.getBugInfoByBugId(bugId);
	}

}
