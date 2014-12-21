package clsCost;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import jdbc.CcDb;

public class SelectCCInfo extends JFrame implements ActionListener {
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel label1 = new JLabel("按序号查找");
	JLabel label2 = new JLabel("至");
	JTextField tField1 = new JTextField(15);
	JTextField tField2 = new JTextField(15);
	JButton button1 = new JButton("确定");
	JButton button2 = new JButton("退出");
	JButton button3 = new JButton("班费余额");
	String fromValue = null;
	String toValue = null;
	String[] Stu = { "序号", "项目名", "日期", "收入", "支出", "合计" };
	String[][] ClsCostInfo = null;

	public SelectCCInfo() {
		super();
		setLayout(new GridLayout(2, 1));
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		panel2.add(label1);
		panel2.add(tField1);
		panel2.add(label2);
		panel2.add(tField2);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		add(panel1);
		add(panel2);
		setTitle("班费收支信息");
		setLocation(400, 256);
		setSize(600, 300);
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == button1) {

			try {
				CcDb rcc = new CcDb();
				fromValue = tField1.getText();
				toValue = tField2.getText();
				ClsCostInfo = rcc.ccAllSearch("cNum", fromValue, toValue);
				if (ClsCostInfo == null) {
					this.dispose();
					JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				} else {
					JTable table = new JTable(ClsCostInfo, Stu);
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
		} else if (obj == button3) {
			JFrame jFrame = new JFrame("班费余额");
			JTextField jTextField = new JTextField();
			CcDb cost = new CcDb();
			String ccbalance = null;
			try {
				ccbalance = cost.ccbalance();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			jTextField.setText(ccbalance);
			jFrame.add(jTextField);
			double i=Double.parseDouble(ccbalance);
			if (i >=50) {
				jTextField.setBackground(Color.green);
				JOptionPane.showMessageDialog(null, "班费还有余额！");
			} else if(i<5&&i>=0){
				jTextField.setBackground(Color.yellow);
				JOptionPane.showMessageDialog(null, "班费所剩不多！");
			}else if(i<0){
				jTextField.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "班费已无余额！");
			}
			jFrame.setLocation(512, 256);
			jFrame.setSize(200, 100);
			jFrame.setVisible(true);
		}
	}
}
