package sActiveInfo;

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

import sCheckInfo.AddSCInfo;

import jdbc.StuDb;

/**
 * 
 * 学生信息表
 * 
 */

@SuppressWarnings("serial")
public class ActInfo extends JFrame {
	Container contentPane;
	JPanel Panel = new JPanel();

	// 框架的大小
	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	

	JTextField sNum = new JTextField(15);
	JTextField sName = new JTextField(15);
	JTextField sSex = new JTextField(15);
	JTextField date = new JTextField(15);
	JTextField activity = new JTextField(15);
	JTextField meeting = new JTextField(15);
	JTextField sport = new JTextField(15);
	JTextField details = new JTextField(15);
	

	JButton j1 = new JButton("确定");
	JButton j2 = new JButton("退出");
	JButton j3 = new JButton("清空");

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;
	int gridx, gridy, gridwidth = 1, gridheight = 1,
			anchor = GridBagConstraints.CENTER, fill = GridBagConstraints.NONE,
			ipadx = 0, ipady = 0;
	double weightx, weighty;
	Insets insets;

	public ActInfo() {
		// 设置框架的大小
		this.setSize(faceSize);
		// 设置标题
		this.setTitle("学生平时信息管理");
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
		gridx = 0;
		gridy = 0;
		insets = new Insets(10, 10, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel1, girdBagCon);
		Panel.add(jLabel1);

		gridx = 1;
		gridy = 0;
		insets = new Insets(10, 1, 10, 15);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(sNum, girdBagCon);
		Panel.add(sNum);

		jLabel2.setText("姓	名：");
		jLabel2.setFont(new Font("Dialog", 0, 12));
		gridx = 2;
		gridy = 0;
		insets = new Insets(10, 15, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel2, girdBagCon);
		Panel.add(jLabel2);

		gridx = 3;
		gridy = 0;
		insets = new Insets(10, 1, 10, 10);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(sName, girdBagCon);
		Panel.add(sName);

		jLabel3.setText("日期：");
		jLabel3.setFont(new Font("Dialog", 0, 12));
		gridx = 0;
		gridy = 1;
		insets = new Insets(10, 10, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel3, girdBagCon);
		Panel.add(jLabel3);

		gridx = 1;
		gridy = 1;
		insets = new Insets(10, 1, 10, 15);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(date, girdBagCon);
		Panel.add(date);

		jLabel4.setText("性	别：");
		jLabel4.setFont(new Font("Dialog", 0, 12));
		gridx = 2;
		gridy = 1;
		insets = new Insets(10, 15, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel4, girdBagCon);
		Panel.add(jLabel4);

		gridx = 3;
		gridy = 1;
		insets = new Insets(10, 1, 10, 10);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(sSex, girdBagCon);
		Panel.add(sSex);

		jLabel5.setText("参加会议情况：");
		jLabel5.setFont(new Font("Dialog", 0, 12));
		gridx = 0;
		gridy = 2;
		insets = new Insets(10, 10, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel5, girdBagCon);
		Panel.add(jLabel5);

		gridx = 1;
		gridy = 2;
		insets = new Insets(10, 1, 10, 15);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(meeting, girdBagCon);
		Panel.add(meeting);

		jLabel6.setText("出操情况：");
		jLabel6.setFont(new Font("Dialog", 0, 12));
		gridx = 2;
		gridy = 2;
		insets = new Insets(10, 15, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel6, girdBagCon);
		Panel.add(jLabel6);

		gridx = 3;
		gridy = 2;
		insets = new Insets(10, 1, 10, 10);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(sport, girdBagCon);
		Panel.add(sport);

		

		jLabel7.setText("参加活动情况：");
		jLabel7.setFont(new Font("Dialog", 0, 12));
		gridx = 0;
		gridy = 3;
		insets = new Insets(10, 10, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel7, girdBagCon);
		Panel.add(jLabel7);

		gridx = 1;
		gridy = 3;
		insets = new Insets(10, 1, 10, 15);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(activity, girdBagCon);
		Panel.add(activity);

		jLabel8.setText("备注：");
		jLabel8.setFont(new Font("Dialog", 0, 12));
		gridx = 2;
		gridy = 3;
		insets = new Insets(10, 15, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel8, girdBagCon);
		Panel.add(jLabel8);

		gridx = 3;
		gridy = 3;
		insets = new Insets(10, 1, 10, 10);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(details, girdBagCon);
		Panel.add(details);

		

		gridx = 1;
		gridy = 5;
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(j1, girdBagCon);
		Panel.add(j1);

		gridx = 2;
		gridy = 5;
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(j2, girdBagCon);
		Panel.add(j2);

		gridx = 3;
		gridy = 5;
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(j3, girdBagCon);
		Panel.add(j3);

		contentPane.add(Panel);
	}

}
