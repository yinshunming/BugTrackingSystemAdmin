package service;

import java.util.List;

import bean.WarppedManagedbugs;


public interface IManagedbugsService {
	public List<WarppedManagedbugs> getManagedbugsList();
	public void addManagedbug(int userInfoId, String buginfoId);
	public void updateManagedbug(int id, int userInfoId, int buginfoId);
	public void deleteManagedbug(int id);
}
