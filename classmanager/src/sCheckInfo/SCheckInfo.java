package sCheckInfo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SCheckInfo extends JFrame {

	Container contentPane;
	JPanel Panel = new JPanel();
	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();

	JTextField sNum = new JTextField(15);
	JTextField sName = new JTextField(15);
	JTextField sSex = new JTextField(15);
	JTextField sUsualScore = new JTextField(15);
	JTextField sAwardName = new JTextField(40);
	JTextField sAwardScore = new JTextField(15);
	JTextField sRank = new JTextField(15);

	JButton j1 = new JButton("确定");
	JButton j2 = new JButton("清空");
	JButton j3 = new JButton("退出");

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public SCheckInfo() {
		// 设置框架的大小
		this.setSize(faceSize);
		// 设置标题
		this.setTitle("学生考评信息");
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

		jLabel1.setText("学	号：");
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
		girdBag.setConstraints(sNum, girdBagCon);
		Panel.add(sNum);

		jLabel2.setText("姓	名：");
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
		girdBag.setConstraints(sName, girdBagCon);
		Panel.add(sName);

		jLabel3.setText("性	别：");
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
		girdBag.setConstraints(sSex, girdBagCon);
		Panel.add(sSex);

		jLabel4.setText("平时考评：");
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
		girdBag.setConstraints(sUsualScore, girdBagCon);
		Panel.add(sUsualScore);

		jLabel5.setText("获奖加分：");
		jLabel5.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10, 10, 10, 1);
		girdBag.setConstraints(jLabel5, girdBagCon);
		Panel.add(jLabel5);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10, 1, 10, 15);
		girdBag.setConstraints(sAwardScore, girdBagCon);
		Panel.add(sAwardScore);

		jLabel6.setText("排	名：");
		jLabel6.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10, 15, 10, 1);
		girdBag.setConstraints(jLabel6, girdBagCon);
		Panel.add(jLabel6);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10, 1, 10, 10);
		girdBag.setConstraints(sRank, girdBagCon);
		Panel.add(sRank);

		jLabel7.setText("获奖名称：");
		jLabel7.setFont(new Font("Dialog", 0, 12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 3;
		girdBagCon.insets = new Insets(10, 10, 10, 1);
		girdBag.setConstraints(jLabel7, girdBagCon);
		Panel.add(jLabel7);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 3;
		girdBagCon.gridwidth = 3;
		girdBagCon.insets = new Insets(10, 1, 10, 10);
		girdBag.setConstraints(sAwardName, girdBagCon);
		Panel.add(sAwardName);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 4;
		girdBag.setConstraints(j1, girdBagCon);
		Panel.add(j1);
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 4;
		girdBag.setConstraints(j2, girdBagCon);
		Panel.add(j2);
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 4;
		girdBag.setConstraints(j3, girdBagCon);
		Panel.add(j3);

		contentPane.add(Panel);

	}

}
