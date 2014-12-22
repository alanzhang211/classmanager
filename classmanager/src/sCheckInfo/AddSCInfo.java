package sCheckInfo;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import jdbc.ScDb;
import jdbc.StuDb;

public class AddSCInfo extends SCheckInfo implements ActionListener {
	public AddSCInfo() {

		this.setTitle("考评信息添加");
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			ScDb addStu = new ScDb();
			addStu.scAdd(sNum.getText(), sName.getText(), sSex.getText(),
					sUsualScore.getText(), sAwardName.getText(),
					sAwardScore.getText(), sRank.getText());
			

		} else if (obj == j2) {
			sNum.setText(null);
			sName.setText(null);
			sAwardName.setText(null);
			sAwardScore.setText(null);
			sUsualScore.setText(null);
			sRank.setText(null);
			sSex.setText(null);
		} else if (obj == j3) { // 退出
			this.dispose();
		}
	}
}
