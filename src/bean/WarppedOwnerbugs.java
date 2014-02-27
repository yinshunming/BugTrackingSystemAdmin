package bean;

public class WarppedOwnerbugs {
	private Userinfo userinfo;
	private Buginfo buginfo;
	private int status;
	private int id;
	private int changed;
	private String newOwner;
	
	public WarppedOwnerbugs (Userinfo userinfo, Buginfo buginfo, int status, int id, int changed, String newOwner) {
		this.userinfo = userinfo;
		this.buginfo = buginfo;
		this.status = status;
		this.id = id;
		this.changed = changed;
		this.newOwner = newOwner;
	}
	
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Buginfo getBuginfo() {
		return buginfo;
	}
	public void setBuginfo(Buginfo buginfo) {
		this.buginfo = buginfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChanged() {
		return changed;
	}
	public void setChanged(int changed) {
		this.changed = changed;
	}
	public String getNewOwner() {
		return newOwner;
	}
	public void setNewOwner(String newOwner) {
		this.newOwner = newOwner;
	}
}
