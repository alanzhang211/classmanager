package clsCost;

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

import jdbc.CcDb;
import jdbc.ScDb;

public class DeleteCCInfo extends JFrame implements ActionListener {

	JButton j1 = new JButton("确定");
	JButton j2 = new JButton("清空");
	JButton j3 = new JButton("取消");
	JLabel l1 = new JLabel("输入序号==>>>将序号为");
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField(15);

	public DeleteCCInfo() {
		super("班费信息删除");
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
			CcDb delcc = new CcDb();
			String str = "的数据删除";
			l2.setText(str);
			delcc.ccDel(t1.getText());

		} else if (obj == j2) {
			t1.setText(null);

		} else if (obj == j3) {
			this.dispose();
		}
	}

}
