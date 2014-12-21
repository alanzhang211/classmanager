package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CcDb {

	String cDate;
	String cNum;
	String cName;
	String cIn;
	String cOut;
	double  cTotal;
	private String colName;
	private String fromValue;
	private String toValue;

	public void ccAdd(String name, String date, String in, String out) {
		cName = name;
		cDate = date;
		cIn = in;
		cOut = out;
		cTotal=(Double.parseDouble(cIn)-Double.parseDouble(cOut));
		if (cDate == null ||cDate.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入日期", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			java.sql.Connection conn = null;
			java.sql.PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				// 建立连接
				conn = Database.getConnection();
				// 创建语句
				String sql = "insert into ccostinfo(cName,cDate,cIn,cOut,cTotal) values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cName);
				ps.setString(2, cDate);
				ps.setString(3, cIn);
				ps.setString(4, cOut);
				ps.setDouble(5, cTotal);
				int i = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "成功添加" + i + "条新的纪录！");

			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败", "错误",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				Database.free(rs, ps, conn);
			}
		}
	}

	public void ccModify(String num, String name, String date, String in,
			String out) {
		cNum = num;
		cName = name;
		cDate = date;
		cIn = in;
		cOut = out;
		if (cDate == null || cDate.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入日期", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			java.sql.Connection conn = null;
			java.sql.Statement st = null;
			ResultSet rs = null;
			try {
				// 建立连接
				conn = Database.getConnection();
				// 创建语句
				st = conn.createStatement();
				String sql = "update ccostinfo set cName='" + cName + "',cIn='"
						+ cIn + "',cOut='" + cOut + "',cDate='" + cDate
						+ "',cTotal='"
						+ (Integer.parseInt(cIn) - Integer.parseInt(cOut))
						+ "' where cNum=" + Integer.parseInt(cNum) + "";

				// 执行语句
				int i = st.executeUpdate(sql);

				JOptionPane.showMessageDialog(null, "成功修改" + i + "条新的纪录！");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "更新失败", "错误",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				Database.free(rs, st, conn);
			}
		}
	}

	public void ccDel(String num) {
		this.cNum = num;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = "delete from ccostinfo where cNum = "
				+ Integer.parseInt(cNum) + "";
		try {
			conn = Database.getConnection();
			st = conn.createStatement();
			int i = st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "成功删除" + i + "条新的纪录！");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "删除失败", "错误",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			Database.free(rs, st, conn);
		}
	}

	public String[][] ccAllSearch(String colname, String colvalue,
			String colvalue2) throws SQLException {
		colName = colname;
		fromValue = colvalue;
		toValue = colvalue2;
		String[][] sn = null;
		int row = 0;
		int i = 0;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = null;

		if (fromValue == null || fromValue.equals("") || toValue == null
				|| toValue.equals("")) {
			sql = "select * from ccostinfo";
		} else {
			sql = "select * from ccostinfo where " + colName + " between "
					+ fromValue + " and " + toValue + "";
		}
		try {
			conn = Database.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.last()) {
				row = rs.getRow();
			}

			if (row == 0) {
				sn = null;
			} else {
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("cNum");
					sn[i][1] = rs.getString("cName");
					sn[i][2] = rs.getString("cDate");
					sn[i][3] = rs.getString("cIn");
					sn[i][4] = rs.getString("cOut");
					sn[i][5] = rs.getString("cTotal");
					i++;
				}
			}
		} finally {
			Database.free(rs, st, conn);
		}
		return sn;
	}

	public String ccbalance() throws SQLException {
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = null;
		String balance=null;
		try {
			// 建立连接
			conn = Database.getConnection();
			// 创建语句
			st = conn.createStatement();

			// 执行语句
			rs = st.executeQuery("select sum(cTotal) from ccostinfo");
			 while (rs.next()) {
				 balance=rs.getString(1);
			 }
		} finally {
			Database.free(rs, st, conn);
		} 
		 return balance;
		
	}

}
