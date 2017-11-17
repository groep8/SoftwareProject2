

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PersoneelDAO  {

	
	
	
	public static boolean addPersoneel(Personeel t) throws SQLException {
		
		
		Connection con=null;
		try {
			 con = DatabaseSingleton.getConnection();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
	if (t == null) {
		return false;
	}
	
	String sql ="INSERT INTO Personeel (idPersoneel, voornaam, familienaam,idAdres, afdeling, functie, fire) VALUES (null,?,?,?,?,?,?)";
	con.setAutoCommit(false);
	PreparedStatement prepstmt;

		
	prepstmt = con.prepareStatement(sql);
	int idPersoneel= 0;
		try {
			
			prepstmt.setString(1, t.getVoornaam());
			prepstmt.setString(2, t.getFamilienaam());
			prepstmt.setInt(3, t.getIdAdres());
			prepstmt.setString(4, t.getAfdeling());
			prepstmt.setString(5, t.getFunctie());
			prepstmt.setBoolean(6, t.getFire());
			prepstmt.executeUpdate();
			con.commit();
			
	
		
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
		
	

	
	
		return true;
		
}
	}

	


	