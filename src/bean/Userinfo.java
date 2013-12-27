package bean;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String oneBugFullName;
	private String email;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String username, String password, String oneBugFullName,
			String email) {
		this.username = username;
		this.password = password;
		this.oneBugFullName = oneBugFullName;
		this.email = email;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOneBugFullName() {
		return this.oneBugFullName;
	}

	public void setOneBugFullName(String oneBugFullName) {
		this.oneBugFullName = oneBugFullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}