package by.htp.ahremenko.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMySQL {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/rentcar", "root","111111");
			st = con.createStatement();
			rs = st.executeQuery("SELECT user_id, user_name, user_login, is_admin FROM RC_USERS");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
