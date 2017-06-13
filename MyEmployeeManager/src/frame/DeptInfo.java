package frame;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.tree.*;

import com.DAO;

/*实现部门的树形显示，同时还包括部门的添加，修改和删除操作。这里需要连接数据库查询部门表中的部门名称作为树的节点。*/
/*实现部门信息查询与管理事件*/
public class DeptInfo {
	public DeptInfo(){
		init();
	}
	JFrame deptFrame=new JFrame("部门管理");//新建一个界面
	JPanel p=new JPanel();//总的界面容器
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JTree tree;//构建一个树形结构
	//三个输入框
	JTextField txtdname = new JTextField(20);
	JTextField txtyname = new JTextField(20);
	JTextField txtnname = new JTextField(20);
	JComboBox cbo=new JComboBox();
	public void init(){
		deptFrame.add(p,BorderLayout.CENTER);
		//窗口监听器
		deptFrame.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				ResultSet rs=DAO.getDeptKind();
				try {
					while(rs.next()){
						cbo.addItem(rs.getString("deptKind"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//调整界面的大小和位置
		deptFrame.setSize(new Dimension(500,400));
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=deptFrame.getSize();
		if(frameSize.height>screenSize.height){
			frameSize.height=screenSize.height;
		}
		if(frameSize.width>screenSize.width){
			frameSize.width=screenSize.width;
		}
		deptFrame.setLocation((screenSize.width-frameSize.width)/2,
								(screenSize.height-frameSize.height)/2);
		p.setLayout(new BorderLayout());
		initTree();
		
		//界面右边的布局
		 p.add(p1,BorderLayout.CENTER);
		 p1.setLayout(new GridLayout(3,1));
		 p1.add(p2);
		 
		 //添加部门
		 p2.setLayout(new FlowLayout());
		 p2.add(new JLabel("输入部门名称："));
		 p2.add(txtdname);
		 JButton btnadd=new JButton("添加");
		 p2.add(btnadd);
		 btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtdname.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入添加部门名称！","警告",JOptionPane.WARNING_MESSAGE);
				}
				boolean flag = DAO.addDept(txtdname.getText().trim());
				if(flag){
					deptFrame.dispose();
					DeptInfo di= new DeptInfo();
					JOptionPane.showMessageDialog(null,"添加部门成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"添加部门失败，请检查后再操作!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		//修改部门
			p1.add(p3);
			p3.setLayout(new FlowLayout());
			p3.add(new JLabel("输入原部门名称:"));
			p3.add(txtyname);
			p3.add(new JLabel("输入新部门名称:"));
			p3.add(txtnname);
			JButton btnupdate = new JButton("修改");
			btnupdate.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					boolean flag = DAO.updateDept(txtyname.getText().trim(), txtnname.getText().trim());
					if(flag){
						deptFrame.dispose();
						DeptInfo di = new DeptInfo();
						JOptionPane.showMessageDialog(null,"修改部门成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null,"修改部门失败，请检查后再操作!","发生错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			});
		//删除部门
			p3.add(btnupdate);
			p1.add(p4);
			p4.setLayout(new FlowLayout());
			p4.add(new JLabel("选择部门："));
			p4.add(cbo);
			JButton btndele = new JButton("删除");
			btndele.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					boolean flag = DAO.deleteDept(cbo.getSelectedItem().toString());
					if(flag){
						deptFrame.dispose();
						
						JOptionPane.showMessageDialog(null,"删除部门成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null,"删除部门失败，请检查后再操作!","发生错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			});
			p4.add(btndele);	
		deptFrame.setVisible(true);
	}
	//建立树形结构
	public void initTree(){
		//创建根节点--公司部门名称
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("公司部门名称");
		//获取子节点--部门类型
		ResultSet rs1=DAO.getDeptKind();
		ResultSet rs2=null;
			try {
				while(rs1.next()){
					String kind=rs1.getString("deptKind");
					DefaultMutableTreeNode banch=new DefaultMutableTreeNode(kind);
					root.add(banch);
					//获取所有二级子节点---部门
					rs2=DAO.getDeptName(kind);
					while(rs2.next()){
						DefaultMutableTreeNode node=new DefaultMutableTreeNode(rs2.getString("deptName"));
						banch.add(node);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			tree=new JTree(root);//创建树结构
			tree.setEditable(true);
			p.add(tree,BorderLayout.WEST);//设置树结构在界面的位置
		
		
	}
	
}
