package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class StuDb {
	public static String sNum;
	private String sName;
	private String sSex;
	private String sNation;
	private String sDormId;
	private String sBirth;
	private String sDuty;
	private String sCardId;
	private String sPhone;
	private String sHome;

	private String colName;
	private String fromValue;
	private String toValue;

	/**
	 * 添加成员信息
	 * 
	 * @throws SQLException
	 */
	public void ccAdd(String num, String name, String sex, String nation,
			String dorm, String birth, String duty, String card, String phone,
			String home) throws SQLException {

		this.sNum = num;
		this.sName = name;
		this.sSex = sex;
		this.sNation = nation;
		this.sDormId = dorm;
		this.sBirth = birth;
		this.sDuty = duty;
		this.sCardId = card;
		this.sPhone = phone;
		this.sHome = home;

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
				String sql = "insert into stuinfo(sNum,sName,sSex,sBirth,sNation,sDormId,sDuty,sPhone,sCardId,sHome) values(?,?,?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, sNum);
				ps.setString(2, sName);
				ps.setString(3, sSex);
				ps.setString(4, sBirth);
				ps.setString(5, sNation);
				ps.setString(6, sDormId);
				ps.setString(7, sDuty);
				ps.setString(8, sPhone);
				ps.setString(9, sCardId);
				ps.setString(10, sHome);
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
	public void stuModify(String num, String name, String sex, String nation,
			String dorm, String birth, String duty, String card, String phone,
			String home) throws SQLException {

		this.sNum = num;
		this.sName = name;
		this.sSex = sex;
		this.sBirth = birth;
		this.sHome = home;
		this.sNation = nation;
		this.sDormId = dorm;
		this.sDuty = duty;
		this.sPhone = phone;
		this.sCardId = card;

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
				String sql = "update stuinfo set sName='" + sName + "',sNUm='"
						+ sNum + "',sBirth='" + sBirth + "',sCardId='"
						+ sCardId + "',sDormId='" + sDormId + "',sDuty='"
						+ sDuty + "',sHome='" + sHome + "',sPhone='" + sPhone
						+ "',sNation='" + sNation + "',sSex='" + sSex
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
	public void stuDel(String num) {
		this.sNum = num;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = "delete from stuinfo where sNum = "
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

	public String[][] stuAllSearch(String colname, String colvalue,
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
			sql = "select * from stuinfo";
		} else {
			sql = "select * from stuinfo where " + colName + " between "
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
					sn[i][3] = rs.getString("sNation");
					sn[i][4] = rs.getString("sHome");
					sn[i][5] = rs.getString("sBirth");
					sn[i][6] = rs.getString("sDuty");
					sn[i][7] = rs.getString("sCardId");
					sn[i][8] = rs.getString("sDormId");
					sn[i][9] = rs.getString("sPhone");
					i++;
				}
			}
		} finally {
			Database.free(rs, st, conn);
		}
		return sn;
	}
}