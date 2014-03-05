package dao;

import java.util.List;

import bean.Ownerbugs;

public interface IOwnerbugsDAO {
	public void delete(Ownerbugs persistentInstance);
	public Ownerbugs findById(Integer id);
	public List findAll();
	public List findByUserInfoId(Object userInfoId);
}
