package dao;

import java.util.List;

import bean.Managedbugs;
import bean.Ownerbugs;

public interface IOwnerbugsDAO {
	public void save(Ownerbugs transientInstance);
	public List findByUserInfoId(Object userInfoId);
	public Ownerbugs findById(java.lang.Integer id);
	public void delete(Ownerbugs persistentInstance);
	public void update(Ownerbugs instance);
}
