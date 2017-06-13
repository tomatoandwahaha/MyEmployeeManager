package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/*
部门管理： 部门信息查询、管理。
信息查询：查询全部员工信息、条件查询。
员工信息操作：添加员工信息、修改员工信息和删除员工信息
基本信息管理：学历添加，职务添加，职称添加，岗位添加。
系统项：帮助和退出。
 */
public class MainFrame extends JFrame {
	JFrame mainFrame=new JFrame("企业信息管理系统");
	JPanel p=new JPanel();//面板容器
	JLabel label1 =new JLabel("欢迎使用企业员工信息管理系统");
	JLabel label2=new JLabel("copy@whu li");
	JMenuBar jmb=new JMenuBar();//菜单栏
	JMenu jm1=new JMenu();//五个菜单项：部门管理。员工信息查询。基本信息查询，系统项
	JMenu jm2=new JMenu();
	JMenu jm3=new JMenu();
	JMenu jm4=new JMenu();
	JMenu jm5=new JMenu();
	JMenuItem jmi1=new JMenuItem();//12个事件
	JMenuItem jmi2=new JMenuItem();
	JMenuItem jmi3=new JMenuItem();
	JMenuItem jmi4=new JMenuItem();
	JMenuItem jmi5=new JMenuItem();
	JMenuItem jmi6=new JMenuItem();
	JMenuItem jmi7=new JMenuItem();
	JMenuItem jmi8=new JMenuItem();
	JMenuItem jmi9=new JMenuItem();
	JMenuItem jmi10=new JMenuItem();
	JMenuItem jmi11=new JMenuItem();
	JMenuItem jmi12=new JMenuItem();
	private void init(){
		//设置面板容器p处在mainFrame的center位置
		mainFrame.add(p,BorderLayout.CENTER);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		//设置界面大小
		mainFrame.setSize(screenSize.width/2,screenSize.height/2);
		
		//设置容器p的布局
		p.setLayout(new BorderLayout());//borderLayout有north、east、west、south、center五个区域，每个区域最多一个组件
		
		//设置文本框的格式
		
		
		
		label1.setFont(new java.awt.Font("华文新魏",Font.BOLD,50));
		label1.setHorizontalAlignment(SwingConstants.CENTER);//设置文字在水平线上的位置
		label1.setForeground(new Color(50,73,55));//设置前景色
		
		label2.setFont(new java.awt.Font("宋体",Font.BOLD,20));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(50,73,55));
		
		//文本框加入p中
		p.add(label1,BorderLayout.CENTER);
		p.add(label2,BorderLayout.SOUTH);
		
		//设置菜单栏及相应事件
		jm1.setText("部门管理");
		jmi1.setText("部门信息查询与管理");
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeptInfo di=new DeptInfo();
			}
		});
		jm1.add(jmi1);
		
		jm2.setText("信息查询");
		jmi2.setText("全部员工信息");
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi3.setText("条件查询");
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jm2.add(jmi2);
		jm2.add(jmi3);
		
		jm3.setText("员工信息操作");
		jmi4.setText("添加员工信息");
		jmi4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi5.setText("修改员工信息");
		jmi5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi6.setText("删除员工信息");
		jmi6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jm3.add(jmi4);
		jm3.add(jmi5);
		jm3.add(jmi6);
		
		jm4.setText("基本信息管理");
		jmi7.setText("学历添加");
		jmi7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi8.setText("职务添加");
		jmi8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi9.setText("职称添加");
		jmi9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi10.setText("岗位添加");
		jmi10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jm4.add(jmi7);
		jm4.add(jmi8);
		jm4.add(jmi9);
		jm4.add(jmi10);
		
		jm5.setText("系统项");
		jmi11.setText("关于");
		jmi11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi12.setText("退出系统");
		jmi12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jm5.add(jmi11);
		jm5.add(jmi12);
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		mainFrame.setJMenuBar(jmb);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		mainFrame.setVisible(true);
	}
	public static void main(String args[]){
	MainFrame mf=new MainFrame();
	mf.init();
}
}
