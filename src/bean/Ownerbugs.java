package bean;

import util.ConstantUtil;

/**
 * Ownerbugs entity. @author MyEclipse Persistence Tools
 */

public class Ownerbugs implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userInfoId;
	private Integer bugInfoId;
	private Integer status;
	private Integer changed;
	private String newOwner;

	// Constructors

	public String getNewOwner() {
		return newOwner;
	}

	public void setNewOwner(String newOwner) {
		this.newOwner = newOwner;
	}

	public Integer getChanged() {
		return changed;
	}

	public void setChanged(Integer changed) {
		this.changed = changed;
	}

	/** default constructor */
	public Ownerbugs() {
	}

	public Ownerbugs(Integer userInfoId, Integer bugInfoId) {
		this(userInfoId, bugInfoId, ConstantUtil.managedBugsStatus, ConstantUtil.ownerNotChanged);
	}
	

	public Ownerbugs(Integer userInfoId, Integer bugInfoId, Integer status, Integer changed) {
		this.userInfoId = userInfoId;
		this.bugInfoId = bugInfoId;
		this.status = status;
		this.changed = changed;
		this.newOwner = "";
	}
	
	
	/** full constructor */
	public Ownerbugs(Integer userInfoId, Integer bugInfoId, Integer status, Integer changed, String newOwner) {
		this.userInfoId = userInfoId;
		this.bugInfoId = bugInfoId;
		this.status = status;
		this.changed = changed;
		this.newOwner = newOwner;
	}
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Integer getBugInfoId() {
		return this.bugInfoId;
	}

	public void setBugInfoId(Integer bugInfoId) {
		this.bugInfoId = bugInfoId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}