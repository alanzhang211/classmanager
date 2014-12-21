package stuInfo;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import jdbc.StuDb;

@SuppressWarnings({ "serial", "unused" })
public class AddSInfo extends StuInfo implements ActionListener {
	public AddSInfo() {
		this.setTitle("班级成员添加");
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			StuDb addStu = new StuDb();
			try {
				addStu.ccAdd(sNum.getText(), sName.getText(), sSex.getText(),
						sNation.getText(), sDormId.getText(), sBirth.getText(),
						sDuty.getText(), sCardId.getText(), sPhone.getText(),
						sHome.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			

		} else if (obj == j2) { // 退出
			this.dispose();
		} else if (obj == j3) {
			sNum.setText(null);
			sBirth.setText(null);
			sCardId.setText(null);
			sDormId.setText(null);
			sDuty.setText(null);
			sHome.setText(null);
			sName.setText(null);
			sNation.setText(null);
			sPhone.setText(null);
			sSex.setText(null);
		}

	}
}
