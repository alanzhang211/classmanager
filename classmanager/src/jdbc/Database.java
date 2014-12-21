package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {
	private static String url = "jdbc:mysql://localhost:3306/classmanager";
	private static String user = "root";
	private static String password = "901";

	Database() {
	}

	 static  {
		// ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() {
		//��������
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	


	public static void free(ResultSet rs, java.sql.Statement st, Connection conn) {
		//�ͷ�
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
	}
}