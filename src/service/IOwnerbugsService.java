package service;
import java.util.List;

import bean.WarppedOwnerbugs;


public interface IOwnerbugsService {
	public void deleteOwnerbugs(int id);
	public List<WarppedOwnerbugs> getOwnerbugs();
}
