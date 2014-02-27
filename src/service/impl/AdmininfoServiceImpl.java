package service.impl;

import java.util.List;

import dao.IAdmininfoDAO;
import bean.Admininfo;
import service.IAdmininfoService;

public class AdmininfoServiceImpl implements IAdmininfoService{
	
	public IAdmininfoDAO getAdmininfoDAO() {
		return admininfoDAO;
	}

	public void setAdmininfoDAO(IAdmininfoDAO admininfoDAO) {
		this.admininfoDAO = admininfoDAO;
	}

	private IAdmininfoDAO admininfoDAO;

	@Override
	public Admininfo getAdmininfoByUsername(String username) {
		// TODO Auto-generated method stub
		List<Admininfo> admininfoList = admininfoDAO.findByUsername(username);
		if (admininfoList != null && admininfoList.size() > 0)
			return admininfoList.get(0);
		return null;
	}

}
