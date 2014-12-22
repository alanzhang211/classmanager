package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserDb {
	String name;
	String passworld;
	private String colName;
	private String toValue;

	public void userAdd(String name, String passworld) {
		this.name = name;
		this.passworld = passworld;

		if (name == null || name.equals("")) {
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
				String sql = "insert into admin(Name,Passworld) values(?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, passworld);
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

	public void userModify(String name, String passworld) {
		this.name = name;
		this.passworld = passworld;

		if (name == null || name.equals("")) {
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
				String sql = "update admin set Passworld='" + passworld
						+ "',Name='" + name + "' where Name='" + name + "'";

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

	public void userDel(String name) {
		this.name = name;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = "delete from admin where Name = '" + name + "'";
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

	public String[][] userAllSearch(String colname) throws SQLException {
		colName = colname;
		String[][] sn = null;
		int row = 0;
		int i = 0;
		java.sql.Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String sql = null;

		if (colName == null || colName.equals("")) {
			sql = "select * from admin";
		} else {
			sql = "select * from admin where Name='" + colName + "'";
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
				sn = new String[row][2];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("Name");
					sn[i][1] = rs.getString("Passworld");
					i++;
				}
			}
		} finally {
			Database.free(rs, st, conn);
		}
		return sn;
	}
}
