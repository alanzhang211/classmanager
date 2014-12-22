package User;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.UserDb;

public class ModifyUser extends JFrame implements ActionListener {
	JButton j1 = new JButton("确定");
	JButton j2 = new JButton("清空");
	JButton j3 = new JButton("取消");
	JLabel l1 = new JLabel("用户名：");
	JLabel l2 = new JLabel("密码：");
	JTextField name = new JTextField();
	JTextField passworld = new JTextField();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	public ModifyUser() {
		super("修改用户");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		p1.setLayout(new GridLayout(2, 2));
		p2.setLayout(new GridLayout(1, 3));
		add(p1);
		add(p2);
		p1.add(l1);
		p1.add(name);
		p1.add(l2);
		p1.add(passworld);
		p2.add(j1);
		p2.add(j2);
		p2.add(j3);
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
		setSize(100, 300);
		setLocation(512, 256);
		pack();
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			UserDb user = new UserDb();
			user.userModify( name.getText(),passworld.getText());

		} else if (obj == j2) {
			name.setText(null);
			passworld.setText(null);
			
		} else if (obj == j3) { // 退出
			this.dispose();
		}

	}
}
