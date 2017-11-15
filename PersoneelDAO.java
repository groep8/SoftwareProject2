package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PersoneelDAO extends BaseDAO {

	public PersoneelDAO() {

	}

	// andere manier van werken
	public PersoneelDAO(Connection con) {
		setConnection(con);
	}

	public int insert(Personeel p) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO boeken VALUES(?,?,?)";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			//ps.setLong(1, ());
			//ps.setString(2, ());
			//ps.setString(3, ());
			return ps.executeUpdate();
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

	}

	public ArrayList<Personeel> selectAll() {
		ArrayList<Personeel> list = null;

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM boeken";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			rs = ps.executeQuery();
			list = new ArrayList<Personeel>();

			//while (rs.next()) {
			//	list.add(fillVO(rs));
			//}

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

	public Personeel selectOne(long isbn) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM boeken WHERE isbn=?";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

			ps.setLong(1, isbn);
			rs = ps.executeQuery();
			if (rs.next()) {
				return fillVO(rs);
			}
			else {
				return null;
			}
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

	private Personeel fillVO(ResultSet rs) throws SQLException {
		Personeel personeel = new Personeel();
		//boekVO.setIsbn(rs.getLong(1));
		//boekVO.setAuteur(rs.getString("auteur"));
		//boekVO.setTitel(rs.getString("titel"));
		return personeel;
	}

	public int delete(Personeel personeel) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int resultaat = 0;
		String sql = "DELETE FROM boeken WHERE isbn=?";

		try {

			if (getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getConnection().prepareStatement(sql);

		//	ps.setLong(1, personeel.getIsbn());
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
}
