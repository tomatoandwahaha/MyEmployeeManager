package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/*
���Ź��� ������Ϣ��ѯ������
��Ϣ��ѯ����ѯȫ��Ա����Ϣ��������ѯ��
Ա����Ϣ���������Ա����Ϣ���޸�Ա����Ϣ��ɾ��Ա����Ϣ
������Ϣ����ѧ����ӣ�ְ����ӣ�ְ����ӣ���λ��ӡ�
ϵͳ��������˳���
 */
public class MainFrame extends JFrame {
	JFrame mainFrame=new JFrame("��ҵ��Ϣ����ϵͳ");
	JPanel p=new JPanel();//�������
	JLabel label1 =new JLabel("��ӭʹ����ҵԱ����Ϣ����ϵͳ");
	JLabel label2=new JLabel("copy@whu li");
	JMenuBar jmb=new JMenuBar();//�˵���
	JMenu jm1=new JMenu();//����˵�����Ź���Ա����Ϣ��ѯ��������Ϣ��ѯ��ϵͳ��
	JMenu jm2=new JMenu();
	JMenu jm3=new JMenu();
	JMenu jm4=new JMenu();
	JMenu jm5=new JMenu();
	JMenuItem jmi1=new JMenuItem();//12���¼�
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
		//�����������p����mainFrame��centerλ��
		mainFrame.add(p,BorderLayout.CENTER);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		//���ý����С
		mainFrame.setSize(screenSize.width/2,screenSize.height/2);
		
		//��������p�Ĳ���
		p.setLayout(new BorderLayout());//borderLayout��north��east��west��south��center�������ÿ���������һ�����
		
		//�����ı���ĸ�ʽ
		
		
		
		label1.setFont(new java.awt.Font("������κ",Font.BOLD,50));
		label1.setHorizontalAlignment(SwingConstants.CENTER);//����������ˮƽ���ϵ�λ��
		label1.setForeground(new Color(50,73,55));//����ǰ��ɫ
		
		label2.setFont(new java.awt.Font("����",Font.BOLD,20));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(50,73,55));
		
		//�ı������p��
		p.add(label1,BorderLayout.CENTER);
		p.add(label2,BorderLayout.SOUTH);
		
		//���ò˵�������Ӧ�¼�
		jm1.setText("���Ź���");
		jmi1.setText("������Ϣ��ѯ�����");
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeptInfo di=new DeptInfo();
			}
		});
		jm1.add(jmi1);
		
		jm2.setText("��Ϣ��ѯ");
		jmi2.setText("ȫ��Ա����Ϣ");
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi3.setText("������ѯ");
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jm2.add(jmi2);
		jm2.add(jmi3);
		
		jm3.setText("Ա����Ϣ����");
		jmi4.setText("���Ա����Ϣ");
		jmi4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi5.setText("�޸�Ա����Ϣ");
		jmi5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi6.setText("ɾ��Ա����Ϣ");
		jmi6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jm3.add(jmi4);
		jm3.add(jmi5);
		jm3.add(jmi6);
		
		jm4.setText("������Ϣ����");
		jmi7.setText("ѧ�����");
		jmi7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi8.setText("ְ�����");
		jmi8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi9.setText("ְ�����");
		jmi9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi10.setText("��λ���");
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
		
		jm5.setText("ϵͳ��");
		jmi11.setText("����");
		jmi11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jmi12.setText("�˳�ϵͳ");
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
