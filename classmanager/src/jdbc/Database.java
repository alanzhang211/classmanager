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
		// 注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() {
		//建立连接
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	


	public static void free(ResultSet rs, java.sql.Statement st, Connection conn) {
		//释放
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