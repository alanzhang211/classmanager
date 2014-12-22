package sCheckInfo;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import jdbc.ScDb;
import jdbc.StuDb;
import stuInfo.EditSInfo;

public class EditSCInfo extends SCheckInfo implements ActionListener {

	public EditSCInfo() {
		this.setTitle("修改信息");
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			ScDb addStu = new ScDb();
			addStu.scModify(sNum.getText(), sName.getText(),
					sSex.getText(), sRank.getText(), sAwardName.getText(),
					sUsualScore.getText(), sAwardScore.getText());

		} else if (obj == j2) {
			sNum.setText(null);
			sAwardName.setText(null);
			sAwardScore.setText(null);
			sRank.setText(null);
			sUsualScore.setText(null);
			sName.setText(null);
			sSex.setText(null);
		}else if (obj == j3) { // 退出
			this.dispose();
		} 
		
	}
}
