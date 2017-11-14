package logic;

public class Login {
	private int id;
	private int personeelId;
	public int getPersoneelId() {
		return personeelId;
	}
	public void setPersoneelId(int personeelId) {
		this.personeelId = personeelId;
	}
	private String username;
	private String password;
	public Login() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", personeelId=" + personeelId + ", username=" + username + ", password=" + password
				+ "]";
	}
	
}
