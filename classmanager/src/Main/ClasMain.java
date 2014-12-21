package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import User.User;

import clsCost.AddCCInfo;
import clsCost.DeleteCCInfo;
import clsCost.EditCCInfo;
import clsCost.SelectCCInfo;

import sActiveInfo.AddSActInfo;
import sActiveInfo.DeleteSActInfo;
import sActiveInfo.EditSActInfo;
import sActiveInfo.SelectSActInfo;
import sCheckInfo.AddSCInfo;
import sCheckInfo.DeleteSCInfo;
import sCheckInfo.EditSCInfo;
import sCheckInfo.SelectSCInfo;
import stuInfo.AddSInfo;
import stuInfo.DeleteSInfo;
import stuInfo.EditSInfo;
import stuInfo.SelectSInfo;

public class ClasMain extends JFrame implements ActionListener {

	// ��ܵĴ�С
	Dimension faceSize = new Dimension(600, 400);

	// �����˵���
	JMenuBar mainMenu = new JMenuBar();
	// ������ϵͳ�����˵���
	JMenu menuSystem = new JMenu();
	JMenuItem user = new JMenuItem();
	JMenuItem itemExit = new JMenuItem();

	// �������༶��Ա��Ϣ�����˵���
	JMenu menuStu = new JMenu();
	JMenuItem itemAddS = new JMenuItem();
	JMenuItem itemEditS = new JMenuItem();
	JMenuItem itemDeleteS = new JMenuItem();
	JMenuItem itemSelectS = new JMenuItem();
	

	// ������ѧ��������Ϣ���˵���
	JMenu menuTst = new JMenu();
	JMenuItem itemAddT = new JMenuItem();
	JMenuItem itemEditT = new JMenuItem();
	JMenuItem itemDeleteT = new JMenuItem();
	JMenuItem itemSelectT = new JMenuItem();

	// ��������ѹ����˵���
	JMenu menuSal = new JMenu();
	JMenuItem itemAddSa = new JMenuItem();
	JMenuItem itemEditSa = new JMenuItem();
	JMenuItem itemDeleteSa = new JMenuItem();
	JMenuItem itemSelectSa = new JMenuItem();
	
	// ������ѧ��ƽʱ��Ϣ���˵���
	JMenu menuAct = new JMenu();
	JMenuItem itemAddAct = new JMenuItem();
	JMenuItem itemEditAct = new JMenuItem();
	JMenuItem itemDeleteAct = new JMenuItem();
	JMenuItem itemSelectAct = new JMenuItem();


	/**
	 * �����ʼ������
	 */
	public ClasMain(URL url) {
		
		// ���ÿ�ܵĴ�С
		this.setSize(faceSize);
		this.setLocation(350, 200);
		this.setVisible(true);
		try {
			Init(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ʼ������
	 */
	private void Init(final URL url) throws Exception {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		menuSystem.setText("ϵͳ����");
		user.setText("�û�����");
		user.setFont(new Font("Dialog", 0, 12));
		itemExit.setText("�˳�");
		itemExit.setFont(new Font("Dialog", 0, 12));
		menuSystem.add(user);
		menuSystem.add(itemExit);

		menuStu.setText("�༶��Ա��Ϣ����");
		itemAddS.setText("���");
		itemAddS.setFont(new Font("Dialog", 0, 12));
		itemEditS.setText("�޸�");
		itemEditS.setFont(new Font("Dialog", 0, 12));
		itemDeleteS.setText("ɾ��");
		itemDeleteS.setFont(new Font("Dialog", 0, 12));
		itemSelectS.setText("��ѯ");
		itemSelectS.setFont(new Font("Dialog", 0, 12));
		menuStu.add(itemAddS);
		menuStu.add(itemEditS);
		menuStu.add(itemDeleteS);
		menuStu.add(itemSelectS);

		menuTst.setText("ѧ��������Ϣ");
		itemAddT.setText("���");
		itemAddT.setFont(new Font("Dialog", 0, 12));
		itemEditT.setText("�޸�");
		itemEditT.setFont(new Font("Dialog", 0, 12));
		itemDeleteT.setText("ɾ��");
		itemDeleteT.setFont(new Font("Dialog", 0, 12));
		itemSelectT.setText("��ѯ");
		itemSelectT.setFont(new Font("Dialog", 0, 12));
		menuTst.add(itemAddT);
		menuTst.add(itemEditT);
		menuTst.add(itemDeleteT);
		menuTst.add(itemSelectT);
		
		menuAct.setText("ѧ��ƽʱ��Ϣ");
		itemAddAct.setText("���");
		itemAddAct.setFont(new Font("Dialog", 0, 12));
		itemEditAct.setText("�޸�");
		itemEditAct.setFont(new Font("Dialog", 0, 12));
		itemDeleteAct.setText("ɾ��");
		itemDeleteAct.setFont(new Font("Dialog", 0, 12));
		itemSelectAct.setText("��ѯ");
		itemSelectAct.setFont(new Font("Dialog", 0, 12));
		menuAct.add(itemAddAct);
		menuAct.add(itemEditAct);
		menuAct.add(itemDeleteAct);
		menuAct.add(itemSelectAct);

		menuSal.setText("��ѹ���");
		itemAddSa.setText("���");
		itemAddSa.setFont(new Font("Dialog", 0, 12));
		itemEditSa.setText("�޸�");
		itemEditSa.setFont(new Font("Dialog", 0, 12));
		itemDeleteSa.setText("ɾ��");
		itemDeleteSa.setFont(new Font("Dialog", 0, 12));
		itemSelectSa.setText("��ѯ");
		itemSelectSa.setFont(new Font("Dialog", 0, 12));
		menuSal.add(itemAddSa);
		menuSal.add(itemEditSa);
		menuSal.add(itemDeleteSa);
		menuSal.add(itemSelectSa);

		// ������еĲ˵���
		mainMenu.add(menuSystem);
		mainMenu.add(menuStu);
		mainMenu.add(menuTst);
		mainMenu.add(menuSal);
		mainMenu.add(menuAct);
		this.setJMenuBar(mainMenu);

		// ��Ӽ�����
		itemExit.addActionListener(this);
		user.addActionListener(this);
		itemAddS.addActionListener(this);
		itemEditS.addActionListener(this);
		itemDeleteS.addActionListener(this);
		itemSelectS.addActionListener(this);
		itemAddT.addActionListener(this);
		itemEditT.addActionListener(this);
		itemDeleteT.addActionListener(this);
		itemSelectT.addActionListener(this);
		itemAddAct.addActionListener(this);
		itemEditAct.addActionListener(this);
		itemDeleteAct.addActionListener(this);
		itemSelectAct.addActionListener(this);
		itemAddSa.addActionListener(this);
		itemEditSa.addActionListener(this);
		itemDeleteSa.addActionListener(this);
		itemSelectSa.addActionListener(this);
		
		JLabel jLabel=new JLabel("��ӭ��½�༶����ϵͳ",JLabel.CENTER);
		jLabel.setFont(new Font("Dialog", 0, 30));
		jLabel.setForeground(Color.blue);
	
		JPanel panel = new JPanel() {
		     public void paintComponent(Graphics g) {
		         ImageIcon icon =
		                 new ImageIcon(url);
		         // ͼƬ�洰���С���仯
		         g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
		     }
		 };
		 
		 panel.add(jLabel);
		 this.add(panel);
		// �رճ���ʱ�Ĳ���
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// �¼�����
	public void actionPerformed(final ActionEvent e) {
		final Object obj = e.getSource();
		if (obj == user) { // �û�����
			new User();
		} else if (obj == itemExit) { // �˳�
			System.exit(0);
		}

		// �������༶��Ա��Ϣ����
		else if (obj == itemAddS) { // ���
			new AddSInfo();
			
		} else if (obj == itemEditS) { // �޸�
			new EditSInfo();

		} else if (obj == itemDeleteS) { // ɾ��
			new DeleteSInfo();

		} else if (obj == itemSelectS) { // ��ѯ
			new SelectSInfo();
		}

		// ������ѧ��������Ϣ��
		else if (obj == itemAddT) { // ���
			new AddSCInfo();

		} else if (obj == itemEditT) { // �޸�
			new EditSCInfo();

		} else if (obj == itemDeleteT) { // ɾ��
			new DeleteSCInfo();

		} else if (obj == itemSelectT) { // ��ѯ
			new SelectSCInfo();

		}
		
		// ������ѧ��ƽʱ��Ϣ��
		else if (obj == itemAddAct) { // ���
			new AddSActInfo();

		} else if (obj == itemEditAct) { // �޸�
			new EditSActInfo();

		} else if (obj == itemDeleteAct) { // ɾ��
			new DeleteSActInfo();

		} else if (obj == itemSelectAct) { // ��ѯ
			new SelectSActInfo();

		}

		// ��������ѹ���
		else if (obj == itemAddSa) { // ���
			new AddCCInfo();

		} else if (obj == itemEditSa) { // �޸�
			new EditCCInfo();

		} else if (obj == itemDeleteSa) { // ɾ��
			new DeleteCCInfo();

		} else if (obj == itemSelectSa) { // ��ѯ
			new SelectCCInfo();
		}

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
