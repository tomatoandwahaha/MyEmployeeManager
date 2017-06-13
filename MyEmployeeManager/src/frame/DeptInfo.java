package frame;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.tree.*;

import com.DAO;

/*ʵ�ֲ��ŵ�������ʾ��ͬʱ���������ŵ���ӣ��޸ĺ�ɾ��������������Ҫ�������ݿ��ѯ���ű��еĲ���������Ϊ���Ľڵ㡣*/
/*ʵ�ֲ�����Ϣ��ѯ������¼�*/
public class DeptInfo {
	public DeptInfo(){
		init();
	}
	JFrame deptFrame=new JFrame("���Ź���");//�½�һ������
	JPanel p=new JPanel();//�ܵĽ�������
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JTree tree;//����һ�����νṹ
	//���������
	JTextField txtdname = new JTextField(20);
	JTextField txtyname = new JTextField(20);
	JTextField txtnname = new JTextField(20);
	JComboBox cbo=new JComboBox();
	public void init(){
		deptFrame.add(p,BorderLayout.CENTER);
		//���ڼ�����
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
		//��������Ĵ�С��λ��
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
		
		//�����ұߵĲ���
		 p.add(p1,BorderLayout.CENTER);
		 p1.setLayout(new GridLayout(3,1));
		 p1.add(p2);
		 
		 //��Ӳ���
		 p2.setLayout(new FlowLayout());
		 p2.add(new JLabel("���벿�����ƣ�"));
		 p2.add(txtdname);
		 JButton btnadd=new JButton("���");
		 p2.add(btnadd);
		 btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtdname.getText().equals("")){
					JOptionPane.showMessageDialog(null, "��������Ӳ������ƣ�","����",JOptionPane.WARNING_MESSAGE);
				}
				boolean flag = DAO.addDept(txtdname.getText().trim());
				if(flag){
					deptFrame.dispose();
					DeptInfo di= new DeptInfo();
					JOptionPane.showMessageDialog(null,"��Ӳ��ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"��Ӳ���ʧ�ܣ�������ٲ���!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		//�޸Ĳ���
			p1.add(p3);
			p3.setLayout(new FlowLayout());
			p3.add(new JLabel("����ԭ��������:"));
			p3.add(txtyname);
			p3.add(new JLabel("�����²�������:"));
			p3.add(txtnname);
			JButton btnupdate = new JButton("�޸�");
			btnupdate.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					boolean flag = DAO.updateDept(txtyname.getText().trim(), txtnname.getText().trim());
					if(flag){
						deptFrame.dispose();
						DeptInfo di = new DeptInfo();
						JOptionPane.showMessageDialog(null,"�޸Ĳ��ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null,"�޸Ĳ���ʧ�ܣ�������ٲ���!","��������",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			});
		//ɾ������
			p3.add(btnupdate);
			p1.add(p4);
			p4.setLayout(new FlowLayout());
			p4.add(new JLabel("ѡ���ţ�"));
			p4.add(cbo);
			JButton btndele = new JButton("ɾ��");
			btndele.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					boolean flag = DAO.deleteDept(cbo.getSelectedItem().toString());
					if(flag){
						deptFrame.dispose();
						
						JOptionPane.showMessageDialog(null,"ɾ�����ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null,"ɾ������ʧ�ܣ�������ٲ���!","��������",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			});
			p4.add(btndele);	
		deptFrame.setVisible(true);
	}
	//�������νṹ
	public void initTree(){
		//�������ڵ�--��˾��������
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("��˾��������");
		//��ȡ�ӽڵ�--��������
		ResultSet rs1=DAO.getDeptKind();
		ResultSet rs2=null;
			try {
				while(rs1.next()){
					String kind=rs1.getString("deptKind");
					DefaultMutableTreeNode banch=new DefaultMutableTreeNode(kind);
					root.add(banch);
					//��ȡ���ж����ӽڵ�---����
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
			tree=new JTree(root);//�������ṹ
			tree.setEditable(true);
			p.add(tree,BorderLayout.WEST);//�������ṹ�ڽ����λ��
		
		
	}
	
}
