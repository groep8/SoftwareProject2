package logic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AdresDAO{	
	public AdresDAO() {

		}

		// andere manier van werken
		public AdresDAO(Connection con) {
		
		}

		public static boolean insert(Adres adresVO) throws SQLException {
	
			Connection con=null;
			try {
				 con = DatabaseSingleton.getConnection();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			
		if (adresVO == null) {
			return false;
		}
		
			String sql = "INSERT INTO Adres(idAdres,straat,huisnum,postcode,stad,land) VALUES(NULL,?,?,?,?,?)";
			con.setAutoCommit(false);
			PreparedStatement ps;
			ps= con.prepareStatement(sql);
			try {

				ps.setString(1, adresVO.getStraat());
				ps.setInt(2, adresVO.getNummer());
				ps.setInt(3, adresVO.getPostcode());
				ps.setString(4, adresVO.getLand());
				ps.setString(5, adresVO.getLand());
				ps.executeUpdate();
				con.commit();
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					if (ps != null)
						ps.close();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					throw new RuntimeException("error.unexpected");
				}
			}
			return true;

		}
/*
		public ArrayList<Adres> selectAll() {
			ArrayList<Adres> list = null;

			PreparedStatement ps = null;
			ResultSet rs = null;

			String sql = "SELECT * FROM Adres";

			try {

				if (getConnection().isClosed()) {
					throw new IllegalStateException("error unexpected");
				}
				ps = getConnection().prepareStatement(sql);

				rs = ps.executeQuery();
				list = new ArrayList<Adres>();

				while (rs.next()) {
					list.add(fillVO(rs));
				}

				return list;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					if (ps != null)
						ps.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					throw new RuntimeException("error.unexpected");
				}
			}

		}

		public Adres selectOne(String straat) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			String sql = "SELECT * FROM Adres WHERE straat=?";

			try {

				if (getConnection().isClosed()) {
					throw new IllegalStateException("error unexpected");
				}
				ps = getConnection().prepareStatement(sql);

				ps.setString(1, straat);
				rs = ps.executeQuery();
				if (rs.next())
					return fillVO(rs);
				else
					return null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					if (ps != null)
						ps.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					throw new RuntimeException("error.unexpected");
				}
			}
		}

		private Adres fillVO(ResultSet rs) throws SQLException {
			Adres adresVO = new Adres();
			adresVO.setStraat(rs.getString("Laan"));
			adresVO.setNummer(rs.getInt(16));
			adresVO.setPostcode(rs.getInt(3));
			adresVO.setGemeente(rs.getString("Anderlecht"));
			adresVO.setLand(rs.getString("België"));
			return adresVO;
		}

		public int delete(Adres adresVO) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			int resultaat = 0;
			String sql = "DELETE FROM Adres WHERE straat=?";

			try {

				if (getConnection().isClosed()) {
					throw new IllegalStateException("error unexpected");
				}
				ps = getConnection().prepareStatement(sql);

				ps.setString(1, adresVO.getStraat());
				resultaat = ps.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					if (ps != null)
						ps.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					throw new RuntimeException("error.unexpected");
				}
			}
			return resultaat;
		
	}
*/
}
