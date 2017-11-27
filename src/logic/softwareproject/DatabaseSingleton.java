package softwareproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton ref;

	private static Connection connection;

	private DatabaseSingleton() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseSingleton getDatabaseSingleton() {
		if (ref == null)
			ref = new DatabaseSingleton();
		return ref;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {

			try {
				String url = "jdbc:mysql://dt5.ehb.be/SP2Team08"; 
		      connection = DriverManager.getConnection(url,"SP2Team08","aqwzsxedc123"); 
				

			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		return connection;
	}

}
