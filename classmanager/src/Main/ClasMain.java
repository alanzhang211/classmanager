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

	// 框架的大小
	Dimension faceSize = new Dimension(600, 400);

	// 建立菜单栏
	JMenuBar mainMenu = new JMenuBar();
	// 建立“系统管理”菜单组
	JMenu menuSystem = new JMenu();
	JMenuItem user = new JMenuItem();
	JMenuItem itemExit = new JMenuItem();

	// 建立“班级成员信息管理”菜单组
	JMenu menuStu = new JMenu();
	JMenuItem itemAddS = new JMenuItem();
	JMenuItem itemEditS = new JMenuItem();
	JMenuItem itemDeleteS = new JMenuItem();
	JMenuItem itemSelectS = new JMenuItem();
	

	// 建立“学生考评信息”菜单组
	JMenu menuTst = new JMenu();
	JMenuItem itemAddT = new JMenuItem();
	JMenuItem itemEditT = new JMenuItem();
	JMenuItem itemDeleteT = new JMenuItem();
	JMenuItem itemSelectT = new JMenuItem();

	// 建立“班费管理”菜单组
	JMenu menuSal = new JMenu();
	JMenuItem itemAddSa = new JMenuItem();
	JMenuItem itemEditSa = new JMenuItem();
	JMenuItem itemDeleteSa = new JMenuItem();
	JMenuItem itemSelectSa = new JMenuItem();
	
	// 建立“学生平时信息”菜单组
	JMenu menuAct = new JMenu();
	JMenuItem itemAddAct = new JMenuItem();
	JMenuItem itemEditAct = new JMenuItem();
	JMenuItem itemDeleteAct = new JMenuItem();
	JMenuItem itemSelectAct = new JMenuItem();


	/**
	 * 程序初始化函数
	 */
	public ClasMain(URL url) {
		
		// 设置框架的大小
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
	 * 程序初始化函数
	 */
	private void Init(final URL url) throws Exception {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		menuSystem.setText("系统管理");
		user.setText("用户管理");
		user.setFont(new Font("Dialog", 0, 12));
		itemExit.setText("退出");
		itemExit.setFont(new Font("Dialog", 0, 12));
		menuSystem.add(user);
		menuSystem.add(itemExit);

		menuStu.setText("班级成员信息管理");
		itemAddS.setText("添加");
		itemAddS.setFont(new Font("Dialog", 0, 12));
		itemEditS.setText("修改");
		itemEditS.setFont(new Font("Dialog", 0, 12));
		itemDeleteS.setText("删除");
		itemDeleteS.setFont(new Font("Dialog", 0, 12));
		itemSelectS.setText("查询");
		itemSelectS.setFont(new Font("Dialog", 0, 12));
		menuStu.add(itemAddS);
		menuStu.add(itemEditS);
		menuStu.add(itemDeleteS);
		menuStu.add(itemSelectS);

		menuTst.setText("学生考评信息");
		itemAddT.setText("添加");
		itemAddT.setFont(new Font("Dialog", 0, 12));
		itemEditT.setText("修改");
		itemEditT.setFont(new Font("Dialog", 0, 12));
		itemDeleteT.setText("删除");
		itemDeleteT.setFont(new Font("Dialog", 0, 12));
		itemSelectT.setText("查询");
		itemSelectT.setFont(new Font("Dialog", 0, 12));
		menuTst.add(itemAddT);
		menuTst.add(itemEditT);
		menuTst.add(itemDeleteT);
		menuTst.add(itemSelectT);
		
		menuAct.setText("学生平时信息");
		itemAddAct.setText("添加");
		itemAddAct.setFont(new Font("Dialog", 0, 12));
		itemEditAct.setText("修改");
		itemEditAct.setFont(new Font("Dialog", 0, 12));
		itemDeleteAct.setText("删除");
		itemDeleteAct.setFont(new Font("Dialog", 0, 12));
		itemSelectAct.setText("查询");
		itemSelectAct.setFont(new Font("Dialog", 0, 12));
		menuAct.add(itemAddAct);
		menuAct.add(itemEditAct);
		menuAct.add(itemDeleteAct);
		menuAct.add(itemSelectAct);

		menuSal.setText("班费管理");
		itemAddSa.setText("添加");
		itemAddSa.setFont(new Font("Dialog", 0, 12));
		itemEditSa.setText("修改");
		itemEditSa.setFont(new Font("Dialog", 0, 12));
		itemDeleteSa.setText("删除");
		itemDeleteSa.setFont(new Font("Dialog", 0, 12));
		itemSelectSa.setText("查询");
		itemSelectSa.setFont(new Font("Dialog", 0, 12));
		menuSal.add(itemAddSa);
		menuSal.add(itemEditSa);
		menuSal.add(itemDeleteSa);
		menuSal.add(itemSelectSa);

		// 添加所有的菜单组
		mainMenu.add(menuSystem);
		mainMenu.add(menuStu);
		mainMenu.add(menuTst);
		mainMenu.add(menuSal);
		mainMenu.add(menuAct);
		this.setJMenuBar(mainMenu);

		// 添加监听器
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
		
		JLabel jLabel=new JLabel("欢迎登陆班级管理系统",JLabel.CENTER);
		jLabel.setFont(new Font("Dialog", 0, 30));
		jLabel.setForeground(Color.blue);
	
		JPanel panel = new JPanel() {
		     public void paintComponent(Graphics g) {
		         ImageIcon icon =
		                 new ImageIcon(url);
		         // 图片随窗体大小而变化
		         g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
		     }
		 };
		 
		 panel.add(jLabel);
		 this.add(panel);
		// 关闭程序时的操作
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 事件处理
	public void actionPerformed(final ActionEvent e) {
		final Object obj = e.getSource();
		if (obj == user) { // 用户管理
			new User();
		} else if (obj == itemExit) { // 退出
			System.exit(0);
		}

		// 建立“班级成员信息管理”
		else if (obj == itemAddS) { // 添加
			new AddSInfo();
			
		} else if (obj == itemEditS) { // 修改
			new EditSInfo();

		} else if (obj == itemDeleteS) { // 删除
			new DeleteSInfo();

		} else if (obj == itemSelectS) { // 查询
			new SelectSInfo();
		}

		// 建立“学生考评信息”
		else if (obj == itemAddT) { // 添加
			new AddSCInfo();

		} else if (obj == itemEditT) { // 修改
			new EditSCInfo();

		} else if (obj == itemDeleteT) { // 删除
			new DeleteSCInfo();

		} else if (obj == itemSelectT) { // 查询
			new SelectSCInfo();

		}
		
		// 建立“学生平时信息”
		else if (obj == itemAddAct) { // 添加
			new AddSActInfo();

		} else if (obj == itemEditAct) { // 修改
			new EditSActInfo();

		} else if (obj == itemDeleteAct) { // 删除
			new DeleteSActInfo();

		} else if (obj == itemSelectAct) { // 查询
			new SelectSActInfo();

		}

		// 建立“班费管理”
		else if (obj == itemAddSa) { // 添加
			new AddCCInfo();

		} else if (obj == itemEditSa) { // 修改
			new EditCCInfo();

		} else if (obj == itemDeleteSa) { // 删除
			new DeleteCCInfo();

		} else if (obj == itemSelectSa) { // 查询
			new SelectCCInfo();
		}

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
