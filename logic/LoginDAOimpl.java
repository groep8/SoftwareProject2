package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;

public class LoginDAOimpl implements LoginDAO{
	private DAOFactory daoFactory;
	public LoginDAOimpl(DAOFactory df) {
		this.daoFactory = df;
	}
	//-------------------------------------------------------------------
	@Override
	public Login getLogin(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "SELECT username, password from Login where username = ?";
		//when the username is entered, it must already be hashed through SHA512, never send a package wiht clear text
		Login log = null;
		ResultSet rs = null;
		try {
			conn = daoFactory.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				 log = new Login(rs.getString("username"), rs.getString("password"));
				 //password here must also already be hashed in the database so the send pakages won't be in clear text and make them unsiffable
			} 
			rs.close();
			conn.close();
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return log;
	}
	//-----------------------------------------------------------------------
	@Override
	public List<Login> getAllLogins() {
		Connection conn = null;
		Statement st = null;
		List<Login> logins = new ArrayList<Login>();
		String query = "SELECT * FROM Login";
		ResultSet rs = null;
		try {
			conn = daoFactory.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Login logTemp = new Login();
				logTemp.setId(rs.getInt("idLogin"));
				logTemp.setPersoneelId(rs.getInt("idPersoneel"));
				logTemp.setUsername(rs.getString(3));
				logTemp.setPassword(rs.getString("password"));
				logins.add(logTemp);
			}
			conn.close();
			st.close();
			rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Er is duidelijk iets fout gelopen");
		} 
		return logins;
	}
	//-------------------------------------------------------------------------  
	@Override
	public List<String> getUsers() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<String> usernames = new ArrayList<String>();
		String query = "SELECT username from Login";
		try {
			conn = daoFactory.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				usernames.add(rs.getString("username"));
			}
			conn.close();
			st.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return usernames;
	}

	@Override
	public List<String> getPass() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		DAOFactory df = DAOFactory.getInstance();
		LoginDAOimpl la = df.getLoginDAO();
		Login log = la.getLogin("jonas");
		System.out.println(log.toString());
	}
}
