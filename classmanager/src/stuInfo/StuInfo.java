package stuInfo;

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
 * ѧ����Ϣ��
 * 
 */

@SuppressWarnings("serial")
public class StuInfo extends JFrame {
	Container contentPane;
	JPanel Panel = new JPanel();

	// ��ܵĴ�С
	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();
	JLabel jLabel10 = new JLabel();

	JTextField sNum = new JTextField(15);
	JTextField sName = new JTextField(15);
	JTextField sSex = new JTextField(15);
	JTextField sNation = new JTextField(15);
	JTextField sDormId = new JTextField(15);
	JTextField sBirth = new JTextField(15);
	JTextField sDuty = new JTextField(15);
	JTextField sCardId = new JTextField(15);
	JTextField sPhone = new JTextField(15);
	JTextField sHome = new JTextField(15);

	JButton j1 = new JButton("ȷ��");
	JButton j2 = new JButton("�˳�");
	JButton j3 = new JButton("���");

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;
	int gridx, gridy, gridwidth = 1, gridheight = 1,
			anchor = GridBagConstraints.CENTER, fill = GridBagConstraints.NONE,
			ipadx = 0, ipady = 0;
	double weightx, weighty;
	Insets insets;

	public StuInfo() {
		// ���ÿ�ܵĴ�С
		this.setSize(faceSize);
		// ���ñ���
		this.setTitle("ѧ���ۺ���Ϣ����");
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

		// �в����Ĳ���
		Panel.setLayout(girdBag);

		jLabel1.setText("ѧ	�ţ�");
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

		jLabel2.setText("��	����");
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

		jLabel3.setText("��	��");
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
		girdBag.setConstraints(sNation, girdBagCon);
		Panel.add(sNation);

		jLabel4.setText("��	�壺");
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

		jLabel5.setText("�������£�");
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
		girdBag.setConstraints(sBirth, girdBagCon);
		Panel.add(sBirth);

		jLabel6.setText("ְ	��");
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
		girdBag.setConstraints(sDuty, girdBagCon);
		Panel.add(sDuty);

		jLabel7.setText("��	�᣺");
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
		girdBag.setConstraints(sHome, girdBagCon);
		Panel.add(sHome);

		jLabel8.setText("����ţ�");
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
		girdBag.setConstraints(sDormId, girdBagCon);
		Panel.add(sDormId);

		jLabel9.setText("���֤�ţ�");
		jLabel9.setFont(new Font("Dialog", 0, 12));
		gridx = 0;
		gridy = 4;
		insets = new Insets(10, 10, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel9, girdBagCon);
		Panel.add(jLabel9);

		gridx = 1;
		gridy = 4;
		insets = new Insets(10, 1, 10, 10);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(sCardId, girdBagCon);
		Panel.add(sCardId);

		jLabel10.setText("��	����");
		jLabel10.setFont(new Font("Dialog", 0, 12));
		gridx = 2;
		gridy = 4;
		insets = new Insets(10, 10, 10, 1);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(jLabel10, girdBagCon);
		Panel.add(jLabel10);

		gridx = 3;
		gridy = 4;
		insets = new Insets(10, 1, 10, 10);
		girdBagCon = new GridBagConstraints(gridx, gridy, gridwidth,
				gridheight, weightx, weighty, anchor, fill, insets, ipadx,
				ipady);
		girdBag.setConstraints(sPhone, girdBagCon);
		Panel.add(sPhone);

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
