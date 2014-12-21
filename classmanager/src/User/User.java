package User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class User extends JFrame implements ActionListener{
	JButton j1=new JButton("查看");
	JButton j2=new JButton("添加");
	JButton j3=new JButton("修改");
	JButton j4=new JButton("删除");
	
	public User() { 
		super("用户操作界面");
		setLayout(new GridLayout(2, 2));
		setSize(250, 100);
		setLocation(512, 256);
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);
		j4.addActionListener(this);
		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) { // 查看用户
			new SelectUser();
			
		} else if (obj == j2) { //添加用户
			new AddUser();
			
		} else if (obj == j3) { //修改用户信息
			new ModifyUser();
			
		} else if (obj == j4) { // 删除用户
			new DelUser();
		}
		
	}
}
