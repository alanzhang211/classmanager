package sActiveInfo;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import jdbc.ActDb; 

@SuppressWarnings({ "serial", "unused" })
public class AddSActInfo extends ActInfo implements ActionListener {
	public AddSActInfo() {
		this.setTitle("学生平时信息添加");
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) { 
			ActDb addAct = new ActDb();
			try {
				addAct.ActAdd(sNum.getText(), sName.getText(),
						sSex.getText(), date.getText(), activity.getText(),
						meeting.getText(), sport.getText(), details.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			

		} else if (obj == j2) { // 退出
			this.dispose();
		} else if (obj == j3) {
			sNum.setText(null);
			meeting.setText(null);
			details.setText(null);
			activity.setText(null);
			sport.setText(null);
			sName.setText(null);
			date.setText(null);
			sSex.setText(null);
		}

	}
}
