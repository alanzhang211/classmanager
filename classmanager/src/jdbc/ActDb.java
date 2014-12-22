package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActDb {
	public static String sNum;
	private String sName;
	private String sSex;
	private String date;
	private String activity;
	private String meeting;
	private String sport;
	private String details;
	private String colName;
	private String fromValue;
	private String toValue;

	/**
	 * 添加成员信息
	 * 
	 * @throws SQLException
	 */
	public void ActAdd(String num, String name, String sex, String nation,
			String dorm, String birth, String duty, String card) throws SQLException {

		this.sNum = num;
		this.sName = name;
		this.sSex = sex;
		this.date = nation;
		this.activity = dorm;
		this.meeting = birth;
		this.sport = duty;
		this.details = card;
		
		if (sName == null || sName.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入学生姓名", "错误",
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
				String sql = "insert into sactive(sNum,sName,sSex,date,meeting,activity,sport,details) values(?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, sNum);
				ps.setString(2, sName);
				ps.setString(3, sSex);
				ps.setString(4, meeting);
				ps.setString(5, date);
				ps.setString(6, activity);
				ps.setString(7, sport);
				ps.setString(8, details);
				
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

	/**
	 * 修改学生信息
	 * 
	 * @throws SQLException
	 */
	public void ActModify(String num, String name, String sex, String date,
			String activity, String meeting, String sport, String details) throws SQLException {

		this.sNum = num;
		this.sName = name;
		this.sSex = sex;
		this.meeting = meeting;
		this.date = date;
		this.activity = activity;
		this.sport = sport;
		this.details = details;

		if (sNum == null || sNum.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入学号", "错误",
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
				String sql = "update sactive set sName='" + sName + "',sNUm='"
						+ sNum + "',meeting='" + meeting + "',details='"
						+ details + "',activity='" + activity + "',sport='"
						+ sport + "',date='" + date + "',sSex='" + sSex
						+ "'where sNum=" + Integer.parseInt(sNum) + "";

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

	/**
	 * 删除学生信息
	 */
	public void ActDel(String num) {
		this.sNum = num;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = "delete from sactive where sNum = "
				+ Integer.parseInt(sNum) + "";
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

	/**
	 * 根据学号查询学生信息
	 * 
	 * @throws SQLException
	 */

	public String[][] ActAllSearch(String colname, String colvalue,
			String colvalue2) throws SQLException {

		this.colName = colname;
		this.fromValue = colvalue;
		this.toValue = colvalue2;
		String[][] sn = null;
		int row = 0;
		int i = 0;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = null;
		

		if (fromValue == null || fromValue.equals("") || toValue == null
				|| toValue.equals("")) {
			sql = "select * from sactive";
		} else {
			sql = "select * from sactive where " + colName + " between "
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
				sn = new String[row][10];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("sNum");
					sn[i][1] = rs.getString("sName");
					sn[i][2] = rs.getString("sSex");
					sn[i][3] = rs.getString("date");
					sn[i][4] = rs.getString("activity");
					sn[i][5] = rs.getString("meeting");
					sn[i][6] = rs.getString("sport");
					sn[i][7] = rs.getString("details");
					i++;
				}
			}
		} finally {
			Database.free(rs, st, conn);
		}
		return sn;
	}
}