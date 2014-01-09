package bean;

import java.sql.Timestamp;

/**
 * Buginfo entity. @author MyEclipse Persistence Tools
 */

public class Buginfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bugId;
	private String title;
	private String project;
	private String type;
	private String status;
	private String description;
	private String owner;
	private String submitter;
	private Timestamp submitData;
	private String severity;
	private String tags;
	private String regression;
	private String component;


	// Constructors


	/** default constructor */
	public Buginfo() {
	}



	/** full constructor */
	public Buginfo(String bugId, String title, String project, String type, String status,
			String description, String owner, String submitter,
			Timestamp submitData, String severity, String tags,
			String regression, String component) {
		this.bugId = bugId;
		this.title = title;
		this.project = project;
		this.type = type;
		this.status = status;
		this.description = description;
		this.owner = owner;
		this.submitter = submitter;
		this.submitData = submitData;
		this.severity = severity;
		this.tags = tags;
		this.regression = regression;
		this.component = component;

	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBugId() {
		return this.bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSubmitter() {
		return this.submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public Timestamp getSubmitData() {
		return this.submitData;
	}

	public void setSubmitData(Timestamp submitData) {
		this.submitData = submitData;
	}

	public String getSeverity() {
		return this.severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getRegression() {
		return this.regression;
	}

	public void setRegression(String regression) {
		this.regression = regression;
	}

	public String getComponent() {
		return this.component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

}