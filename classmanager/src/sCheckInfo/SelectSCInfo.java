package sCheckInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import jdbc.ScDb;

public class SelectSCInfo extends JFrame implements ActionListener {
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel label1 = new JLabel("按学号查找");
	JLabel label2 = new JLabel("至");
	JTextField tField1 = new JTextField(10);
	JTextField tField2 = new JTextField(10);
	JButton button1 = new JButton("确定");
	JButton button2 = new JButton("退出");
	String fromValue = null;
	String toValue = null;
	String[] Sc = { "学号", "姓名", "性别", "平时考评", "获奖名称", "获奖加分", "排名", "总分" };
	String[][] SCheckInfo = null;

	public SelectSCInfo() {
		super();
		setLayout(new GridLayout(2, 1));
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel2.add(label1);
		panel2.add(tField1);
		panel2.add(label2);
		panel2.add(tField2);
		panel2.add(button1);
		panel2.add(button2);
		add(panel1);
		add(panel2);
		setTitle("学生考评信息");
		setLocation(400, 256);
		setSize(600, 300);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == button1) {

			try {
				ScDb rsc = new ScDb();
				fromValue = tField1.getText();
				toValue = tField2.getText();
				SCheckInfo = rsc.scAllSearch("sNum", fromValue, toValue);
				if (SCheckInfo == null) {
					this.dispose();
					JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				} else {
					JTable table = new JTable(SCheckInfo, Sc);
					table.setPreferredScrollableViewportSize(new Dimension(550,
							100));
					JScrollPane scrollpane = new JScrollPane(table);
					panel1.add(scrollpane, BorderLayout.CENTER);
					this.pack();
					this.setVisible(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (obj == button2) {
			this.dispose();
		}
	}

}
