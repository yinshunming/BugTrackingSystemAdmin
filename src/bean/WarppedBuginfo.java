package bean;

public class WarppedBuginfo {
	private Buginfo buginfo;
	private int status;
	private int managedBugId;
	private String newOwner;
	
	public WarppedBuginfo () {
		this.buginfo = null;
		this.status = -1;
		this.managedBugId = -1;
		this.newOwner = "";
	}
	
	public WarppedBuginfo (Buginfo buginfo, int status, int managedBugid) {
		this.buginfo = buginfo;
		this.status = status;
		this.managedBugId = managedBugid;
		this.newOwner = "";
	}
	
	public WarppedBuginfo (Buginfo buginfo, int status, int managedBugid, String newOwner) {
		this.buginfo = buginfo;
		this.status = status;
		this.managedBugId = managedBugid;
		this.newOwner = newOwner;
	}
	
	public String getNewOwner() {
		return newOwner;
	}

	public void setNewOwner(String newOwner) {
		this.newOwner = newOwner;
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

	public int getManagedBugId() {
		return managedBugId;
	}

	public void setManagedBugId(int managedBugId) {
		this.managedBugId = managedBugId;
	}
}
