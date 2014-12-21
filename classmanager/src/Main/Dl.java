package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jdbc.Database;

public class Dl {	
	private  URL url=ClasMain.class.getClassLoader().getResource("images/����.jpg");

	public Dl() {
		final JFrame f = new JFrame("�����½����");
		f.setLocation(512, 256);
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		final JButton button = new JButton("��½");
		p1.setLayout(new GridLayout(2, 2));
		p1.setBorder(BorderFactory.createTitledBorder("���������ĵ�¼��Ϣ"));
		JLabel l1 = new JLabel("�������룺");
		JLabel l2 = new JLabel("����󣬰���½��ť");
		final JPasswordField t1 = new JPasswordField();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str, sqlString;
				Object obj = e.getSource();
				str = new String(t1.getPassword()).trim();
				try {
					if (obj == button) {
						if (str.equals("")) {
							JOptionPane.showMessageDialog(f, "���벻��Ϊ��");
							return;
						}
						java.sql.Connection conn = null;
						java.sql.Statement st = null;
						ResultSet rs = null;
						sqlString = "select passworld from Admin where passworld='"
								+ str + "'";
						conn = Database.getConnection();
						st = conn.createStatement();
						rs = st.executeQuery(sqlString);

						if (rs.next() != false) {
							JOptionPane.showMessageDialog(f, "��½�ɹ�");
							new ClasMain(url);
							f.dispose();
							conn.close();  

						} else {
							JOptionPane.showMessageDialog(f, "�������");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(button);
		contentPane.add(p1);
		f.pack();
		f.setVisible(true);
	}
}
