package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ScDb {

	String sNum;
	String sName;
	String sSex;
	String sUsualScore;
	String sAwardName;
	String sAwardScore;
	String sRank;
	double sTotal;
	private String colName;
	private String fromValue;
	private String toValue;

	public void scAdd(String num, String name, String sex, String usualScore,
			String awardName, String awardscore, String rank) {
		sNum = num;
		sName = name;
		sSex = sex;
		sUsualScore = usualScore;
		sAwardName = awardName;
		sAwardScore = awardscore;
		sRank = rank;
		sTotal = (Double.parseDouble(sUsualScore) + Double
				.parseDouble(sAwardScore));
		if (sNum == null || sNum.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入学生学号", "错误",
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
				String sql = "insert into scheckinfo(sNum,sName,sSex,sUsualScore,sAwardName,sAwardScore,sRank,sTotal) values(?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, sNum);
				ps.setString(2, sName);
				ps.setString(3, sSex);
				ps.setString(4, sUsualScore);
				ps.setString(5, sAwardName);
				ps.setString(6, sAwardScore);
				ps.setString(7, sRank);
				ps.setDouble(8, sTotal);
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

	public void scModify(String num, String name, String sex,
			String usualScore, String awardName, String awardscore, String rank) {
		sNum = num;
		sName = name;
		sSex = sex;
		sUsualScore = usualScore;
		sAwardName = awardName;
		sAwardScore = awardscore;
		sRank = rank;

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
				String sql = "update scheckinfo set sName='"
						+ sName
						+ "',sNUm='"
						+ sNum
						+ "',sUsualScore='"
						+ sUsualScore
						+ "',sAwardName='"
						+ sAwardName
						+ "',sAwardScore='"
						+ sAwardScore
						+ "',sRank='"
						+ sRank
						+ "',sSex='"
						+ sSex
						+ "',sTotal='"
						+ (Double.parseDouble(sUsualScore) + Double
								.parseDouble(sUsualScore)) + "' where sNum="
						+ Integer.parseInt(sNum) + "";

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

	public void scDel(String num) {
		this.sNum = num;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = "delete from scheckinfo where sNum = "
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

	public String[][] scAllSearch(String colname, String colvalue,
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
			sql = "select *from scheckinfo";
		} else {
			sql = "select *from scheckinfo where " + colName + " between "
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
				sn = new String[row][8];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("sNum");
					sn[i][1] = rs.getString("sName");
					sn[i][2] = rs.getString("sSex");
					sn[i][3] = rs.getString("sUsualScore");
					sn[i][4] = rs.getString("sAwardName");
					sn[i][5] = rs.getString("sAwardScore");
					sn[i][6] = rs.getString("sRank");
					sn[i][7] = rs.getString("sTotal");
					i++;

				}
			}
		} finally {
			Database.free(rs, st, conn);
		}
		return sn;
	}

}
