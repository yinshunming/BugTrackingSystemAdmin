package bean;

import util.ConstantUtil;

/**
 * Managedbugs entity. @author MyEclipse Persistence Tools
 */

public class Managedbugs implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userInfoId;
	private Integer bugInfoId;
	private Integer status;

	// Constructors

	/** default constructor */
	public Managedbugs() {
	}

	/** full constructor */
	public Managedbugs(Integer userInfoId, Integer bugInfoId) {
		this.userInfoId = userInfoId;
		this.bugInfoId = bugInfoId;
		this.status = ConstantUtil.managedBugsStatus;
	}
	
	
	public Managedbugs(Integer userInfoId, Integer bugInfoId, Integer status) {
		this.userInfoId = userInfoId;
		this.bugInfoId = bugInfoId;
		this.status = status;
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
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}