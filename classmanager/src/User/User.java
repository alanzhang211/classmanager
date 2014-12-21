package User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class User extends JFrame implements ActionListener{
	JButton j1=new JButton("�鿴");
	JButton j2=new JButton("���");
	JButton j3=new JButton("�޸�");
	JButton j4=new JButton("ɾ��");
	
	public User() { 
		super("�û���������");
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
		if (obj == j1) { // �鿴�û�
			new SelectUser();
			
		} else if (obj == j2) { //����û�
			new AddUser();
			
		} else if (obj == j3) { //�޸��û���Ϣ
			new ModifyUser();
			
		} else if (obj == j4) { // ɾ���û�
			new DelUser();
		}
		
	}
}
