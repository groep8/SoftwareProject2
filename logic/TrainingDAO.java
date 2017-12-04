package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TrainingDAO  {

	
	
	
	public static boolean addTraining(Training t) throws SQLException {
		
		
		Connection con=null;
		try {
			 con = DatabaseSingleton.getConnection();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
	if (t == null) {
		return false;
	}
	
	String sql ="INSERT INTO Training (idTraining, trainingNaam, idLeerkracht,idAdres) VALUES (null,?,?,?)";
	con.setAutoCommit(false);
	PreparedStatement prepstmt;

		
	prepstmt = con.prepareStatement(sql);
	int idTraining= 0;
		try {
			
			prepstmt.setString(1, t.getNaamTraining());
			prepstmt.setInt(2, t.getIdLeerkracht().getIdleerkracht());
			prepstmt.setInt(3, t.getIdPlaats().getIdAdres());
			prepstmt.executeUpdate();
			con.commit();
			ResultSet rs=null;
			
			rs = prepstmt.executeQuery();
			if(rs.next()) {
				idTraining= rs.getInt(1);
			}
		
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			String sql2 ="INSERT INTO TrainingDetail (idTrainingDetail, idTraining, idPersoneel,datum) VALUES (null,?,?,?)";
			con.setAutoCommit(false);
			PreparedStatement prepstmt2;
			
				
				
				try {
					prepstmt2 = con.prepareStatement(sql2);
					prepstmt2.setInt(1, idTraining);
					prepstmt2.setInt(2, t.getIdPersoneel().getIdPersoneel());
					prepstmt2.setString(3, t.getStartdate());
					prepstmt2.executeUpdate();
					con.commit();
				
			
				} catch (SQLException e) {
					
					e.printStackTrace();
				
		
	

	
	}
		return true;
		
}
	}

	


	