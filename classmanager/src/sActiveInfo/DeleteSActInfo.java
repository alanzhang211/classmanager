package sActiveInfo;

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

import jdbc.ActDb; 

@SuppressWarnings("serial")
public class DeleteSActInfo extends JFrame implements ActionListener {
	JButton j1 = new JButton("ȷ��");
	JButton j2 = new JButton("���");
	JButton j3 = new JButton("ȡ��");
	JLabel l1 = new JLabel("����ѧ��===>>>��ѧ��Ϊ");
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField(15);
	
	public DeleteSActInfo() {
		 super("ѧ��ƽʱ��Ϣɾ��");
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
		setLocation(512, 256);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == j1) {
			ActDb delAct=new ActDb();
			String str="����Ϣɾ��";
			l2.setText(str);
			delAct.ActDel(t1.getText());
			 
		} else if (obj == j2) {
			t1.setText(null);

		} else if (obj == j3) {
			this.dispose();
		}
	}
}