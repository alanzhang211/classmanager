package com.hikvison.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * <p>数据库工具类</p>
 * @author zhanghanqing 2014-12-22 下午01:06:38
 * @version V1.0   
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2014-12-22
 * @modify by reason:{方法名}:{原因}
 */
public class DatabaseUtil{
	private static String url = "jdbc:mysql://localhost:3306/classmanager";
	private static String user = "root";
	private static String password = "88075998";

	 static  {
		// 注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//TODO读取配置文件
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	 /**
	  * 建立数据库连接
	  * @author zhanghanqing 2014-12-22 下午01:07:24
	  * @return Connection
	  */
	public static Connection getConnection() {
		//建立连接
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	/**
	 * 释放数据库连接
	 * @author zhanghanqing 2014-12-22 下午01:07:44
	 * @param rs 结果集
	 * @param st sql申明
	 * @param conn 数据库连接
	 */
	public static void free(ResultSet rs, Statement st, Connection conn) {
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