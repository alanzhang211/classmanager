package User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.UserDb;

public class AddUser extends JFrame implements ActionListener {

	JLabel jLabel1 = new JLabel("�û���");
	JLabel jLabel2 = new JLabel("����");
	JTextField Name = new JTextField(15);
	JTextField Passworld = new JTextField(15);

	JButton j1 = new JButton("ȷ��");
	JButton j2 = new JButton("���");
	JButton j3 = new JButton("�˳�");

	public AddUser() {
		super("����û�");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		JPanel Panel1 = new JPanel();
		JPanel Panel2 = new JPanel();
		Panel1.setLayout(new GridLayout(1, 4));
		Panel2.setLayout(new GridLayout(1, 3));

		j1.addActionListener(this);
		j2.addActionListener(this);
		j3.addActionListener(this);

		Panel1.add(jLabel1);
		Panel1.add(Name);
		Panel1.add(jLabel2);
		Panel1.add(Passworld);
		Panel2.add(j1);
		Panel2.add(j2);
		Panel2.add(j3);
		add(Panel1);
		add(Panel2);
		setSize(300, 100);
		setLocation(512, 256);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {//���
			UserDb user=new UserDb();
			user.userAdd(Name.getText(), Passworld.getText());
			
		} else if (obj == j2) {//���
			Name.setText(null);
			Passworld.setText(null);
		}else if (obj==j3) {//�˳�
		this.dispose();	
		}

	}
}
