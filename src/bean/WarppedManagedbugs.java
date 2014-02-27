package bean;

public class WarppedManagedbugs {
	private Userinfo userinfo;
	private Buginfo buginfo;
	private int status;
	private int id;

	
	public WarppedManagedbugs(Userinfo userinfo, Buginfo buginfo, int status) {
		this.userinfo = userinfo;
		this.buginfo = buginfo;
		this.status = status;
	}
	
	public WarppedManagedbugs(Userinfo userinfo, Buginfo buginfo, int status, int id) {
		this.userinfo = userinfo;
		this.buginfo = buginfo;
		this.status = status;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WarppedManagedbugs() {
		
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
}
