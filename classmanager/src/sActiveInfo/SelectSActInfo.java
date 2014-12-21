package sActiveInfo;

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

import jdbc.ActDb;
 
public class SelectSActInfo extends JFrame implements ActionListener {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel label1 = new JLabel("��ѧ�Ų���");
	JLabel label2 = new JLabel("��");
	JTextField tField1 = new JTextField(15);
	JTextField tField2 = new JTextField(15);
	JButton button1 = new JButton("ȷ��");
	JButton button2 = new JButton("�˳�");
	String fromValue = null;
	String toValue = null;
	String[] Stu = { "ѧ��", "����", "�Ա�", "�μӻ������", "�μӻ���", "����", "�������", "��ע" };
	String[][] StuInfo = null;

	public SelectSActInfo() {
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
		setTitle("ѧ��ƽʱ��Ϣ");
		setLocation(400, 256);
		setSize(600, 300);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == button1) {
			 
			try {
				ActDb rAct = new ActDb();
				fromValue=tField1.getText(); 
				toValue=tField2.getText();
				StuInfo = rAct.ActAllSearch("sNum", fromValue, toValue);
				if (StuInfo == null) {
					this.dispose();
					JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");
				} else {
					JTable table = new JTable(StuInfo, Stu);
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
