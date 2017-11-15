package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAOFactory {
	public String url, username, password;
	public DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	public static DAOFactory getInstance() {
		try {
			Class.forName("com.jdbc.mysql.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		DAOFactory instance = new DAOFactory("jdbc:mysql://dt5.ehb.be/SP2Team08","SP2Team08","aqwzsxedc123");
		return instance; 
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	//return this to impl of login
	
	public LoginDAOimpl getLoginDAO() {
		return new LoginDAOimpl(this);
	}
}
