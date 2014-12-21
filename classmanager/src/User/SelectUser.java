package User;

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

import jdbc.UserDb;

public class SelectUser extends JFrame implements ActionListener{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel label1 = new JLabel("按用户名查找");
	JTextField tField = new JTextField(15);
	JButton button1 = new JButton("确定");
	JButton button2 = new JButton("退出");
	String colName=null;
	String[] Stu = { "用户名", "密码" };
	String[][] UserInfo = null;
	
	public SelectUser(){
		
		super("用户信息");
		setLayout(new GridLayout(2, 1));
		button1.addActionListener(this);
		button2.addActionListener(this);

		panel2.add(label1);
		panel2.add(tField);
		panel2.add(button1);
		panel2.add(button2);
		add(panel1);
		add(panel2);
		setLocation(512, 256);
		setSize(600, 300);
		setVisible(true);
		this.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == button1) {

			try {
				UserDb user = new UserDb();
				colName=tField.getText();
				UserInfo = user.userAllSearch(colName);
				if (UserInfo == null) {
					this.dispose();
					JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				} else {
					JTable table = new JTable(UserInfo, Stu);
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
