package User;

import java.awt.BorderLayout;
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

public class DelUser extends JFrame implements ActionListener {
	JButton j1 = new JButton("确定");
	JButton j2 = new JButton("清空");
	JButton j3 = new JButton("取消");
	JLabel l1 = new JLabel("输入用户名==>将");
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField(15);
	public DelUser() {
		super("删除用户信息");
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 3));
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		con.add(p);
		setSize(350, 100);
		setLocation(512, 256);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			UserDb user=new UserDb();
			String str="删除";
			l2.setText(str);
			user.userDel(t1.getText());
			
		} else if (obj == j2) {
			t1.setText(null);

		} else if (obj == j3) {
			this.dispose();
		}
	}

}
