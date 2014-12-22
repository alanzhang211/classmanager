package clsCost;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClsCostInfo extends JFrame {
	Container contentPane;
	JPanel Panel = new JPanel();

	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	JTextField cDate = new JTextField(15);
	JTextField cName = new JTextField(37);
	JTextField cIn = new JTextField(15);
	JTextField cOut = new JTextField(15);
	JTextField cNum = new JTextField(15);

	JButton j1 = new JButton("确定");
	JButton j2 = new JButton("清空");
	JButton j3 = new JButton("退出");

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public ClsCostInfo() {
		// 设置框架的大小
		this.setSize(faceSize);
		// 设置标题
		this.setTitle("班费管理");
		setLocation(256, 128);
		this.setResizable(false);
		this.setVisible(true);

		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// 中部面板的布局
		Panel.setLayout(girdBag);

		jLabel1.setText("日	期：");
		jLabel1.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10, 10, 10, 1);
		girdBag.setConstraints(jLabel1, girdBagCon);
		Panel.add(jLabel1);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10, 1, 10, 15);
		girdBag.setConstraints(cDate, girdBagCon);
		Panel.add(cDate);

		jLabel2.setText("序	号：");
		jLabel2.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10, 15, 10, 1);
		girdBag.setConstraints(jLabel2, girdBagCon);
		Panel.add(jLabel2);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10, 1, 10, 10);
		girdBag.setConstraints(cNum, girdBagCon);
		Panel.add(cNum);

		jLabel3.setText("收	入：");
		jLabel3.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10, 10, 10, 1);
		girdBag.setConstraints(jLabel3, girdBagCon);
		Panel.add(jLabel3);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10, 1, 10, 15);
		girdBag.setConstraints(cIn, girdBagCon);
		Panel.add(cIn);

		jLabel4.setText("支	出：");
		jLabel4.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10, 15, 10, 1);
		girdBag.setConstraints(jLabel4, girdBagCon);
		Panel.add(jLabel4);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10, 1, 10, 10);
		girdBag.setConstraints(cOut, girdBagCon);
		Panel.add(cOut);

		jLabel6.setText("项	目：");
		jLabel6.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10, 15, 10, 1);
		girdBag.setConstraints(jLabel6, girdBagCon);
		Panel.add(jLabel6);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 2;
		girdBagCon.gridwidth = 3;
		girdBagCon.insets = new Insets(10, 1, 10, 10);
		girdBag.setConstraints(cName, girdBagCon);
		Panel.add(cName);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 3;
		girdBag.setConstraints(j1, girdBagCon);
		Panel.add(j1);
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 3;
		girdBag.setConstraints(j2, girdBagCon);
		Panel.add(j2);
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 3;
		girdBag.setConstraints(j3, girdBagCon);
		Panel.add(j3);

		contentPane.add(Panel);
		cNum.setEditable(false);
	}

}
