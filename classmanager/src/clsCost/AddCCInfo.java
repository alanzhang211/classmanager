package clsCost;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import jdbc.CcDb;
import jdbc.StuDb;

public class AddCCInfo extends ClsCostInfo implements ActionListener {

	public AddCCInfo() {

		this.setTitle("添加班费信息");
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			CcDb addStu = new CcDb();
			addStu.ccAdd( cName.getText(), cDate.getText(),
					cIn.getText(), cOut.getText());

		}  else if (obj == j2) {
			cIn.setText(null);
			cName.setText(null);
			cOut.setText(null);
			cDate.setText(null);
		}else if (obj == j3) { // 退出
			this.dispose();
		}
	}
}
