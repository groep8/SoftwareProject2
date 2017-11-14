package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOimpl implements LoginDAO{
	private DAOFactory daoFactory;
	public LoginDAOimpl(DAOFactory df) {
		this.daoFactory = df;
	}
	
	@Override
	public Login getLogin(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = daoFactory.getConnection();
			conn.prepareStatement("select username from login where username = ?");
			
		} catch(SQLException e) {
			
		}
		return null;
	}

	@Override
	public List<Login> getAllLogins() {
		Connection conn = null;
		Statement st = null;
		List<Login> logins = new ArrayList<Login>();
		String query = "SELECT * FROM login";
		ResultSet rs = null;
		try {
			conn = daoFactory.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Login logTemp = new Login();
				logTemp.setId(rs.getInt(1));
				logTemp.setPersoneelId(rs.getInt(2));
				logTemp.setUsername(rs.getString(3));
				logTemp.setPassword(rs.getString(4));
				logins.add(logTemp);
			}
			
		} 
		catch (SQLException e) {
			
		} 
		finally {
		       if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       }

		      if(st != null) {
		    	  try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		}
		return logins;
	}
	
	public static void main(String[] args) {
		DAOFactory df = DAOFactory.getInstance();
		LoginDAOimpl la = new LoginDAOimpl(df);
		List<Login> ls = la.getAllLogins();
		for(Login l : ls) {
			System.out.println(l.toString());
		}
	}
}
