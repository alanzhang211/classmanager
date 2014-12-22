package clsCost;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jdbc.CcDb;
import jdbc.ScDb;

import sCheckInfo.EditSCInfo;

public class EditCCInfo extends ClsCostInfo implements ActionListener {

	public EditCCInfo() {
		this.setTitle("修改班费信息");
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
		cNum.setEditable(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			CcDb addStu = new CcDb();
			addStu.ccModify(cNum.getText(), cName.getText(), cDate.getText(),
					cIn.getText(), cOut.getText());

		}  else if (obj == j2) {
			cDate.setText(null);
			cNum.setText(null);
			cOut.setText(null);
			cName.setText(null);
			cIn.setText(null);
		}else if (obj == j3) { // 退出
			this.dispose();
		}

	}
}
