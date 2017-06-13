package com;


import java.sql.*;




public class DAO {
/******************************���ݿ������********************************************/
	private static final String URL ="jdbc:mysql://127.0.0.1:3306/employeemanager?characterEncoding=utf-8";//���������ݿ�˿ڣ�3306�����ݿ�����imooc��
	private static final String USER="root";//���ݿ��û���
	private static final String PASSWORD="1111";//���ݿ�����
	private static  Connection conn =null;
	
	//��̬��:�ڳ����һ��ִ�й����У�static{}�����е�����ֻ��ִ��һ��	
	static{
    	   	try{
    	   		//1-������������
    	   		Class.forName("com.mysql.jdbc.Driver");//���䡣ͨ��һ���������������Ľ�����ص�������
    	   		conn = DriverManager.getConnection(URL,USER,PASSWORD);
    	   		if(conn!=null){
    	   			System.out.println("mysql���ݿ����ӳɹ�");
    	   		}
    	   	} catch (ClassNotFoundException e1) {
    	   		// TODO Auto-generated catch block
    	   		e1.printStackTrace();
    	   		System.out.println(e1.getMessage());
    	   	} catch (SQLException e1) {
    	   		// TODO Auto-generated catch block
    	   		e1.printStackTrace();
    	   		System.out.println(e1.getMessage());
    	   	}
      	}
	
	public static  Connection getConnection(){
		return conn;
	}
	/**************************start������Ϣ��ѯ�����**************************************/
	//�������еĲ������ͣ�deptkind-deptKind��
	public static ResultSet getDeptKind(){
		conn=DAO.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select deptKind from tb_deptkind");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DAO1: "+e.getMessage());
		}
		return rs;
	}
	//����name���Ͳ��ŵ����е��Ӳ��ŵ�����(deptinfo-deptName,deptId��Ϊ���)
	public static ResultSet getDeptName(String name){
		conn=DAO.getConnection();
		Statement stmt1 =null;//��������ִ�о�̬SQL���
		Statement stmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
			
			try {
					stmt1=conn.createStatement();
					stmt2=conn.createStatement();
					rs=stmt1.executeQuery("select deptId from tb_deptKind where deptKind='"+name+"'");//deptId�Ǳ�tb_deptinfo�Ա�deptId�����
					while(rs.next()){
						int id=rs.getInt("deptId");
						rs2=stmt2.executeQuery("select deptName from tb_deptinfo "
											+ "where deptId="+id+"");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("DAO2:"+e.getMessage());
			}//���
			return rs2;

		
	}
	//����²���
	public static boolean addDept(String name){
		conn=DAO.getConnection();
		ResultSet rs=null;
		Statement stmt=null;
		Statement stmt2=null;
		try {
			stmt=conn.createStatement();
			stmt2=conn.createStatement();
			rs=stmt.executeQuery("select*from tb_deptkind where deptKind='"+name+"'");//��ѯ�Ƿ��Ѿ����ڸò�������
			if(!rs.next()){
				int count=stmt2.executeUpdate("insert  into tb_deptkind values(5,'"+name+"')");
				if(count>0){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}	
	}
	//ɾ������
	public static boolean deleteDept(String name){
		conn = DAO.getConnection();
		int id=0;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select deptId from tb_deptkind where deptKind='"+name+"'");
			if(rs.next()){
				id=rs.getInt("deptId");
			}else{
				return false;
			}
			rs2=stmt.executeQuery("select deptName from tb_deptinfo where deptId='"+id+"'");
			if(rs2.next()){
				return false;//������������������Ӳ��ţ����ֹɾ��
			}else{
				int count=stmt.executeUpdate("delete from tb_deptKind where deptKind='"+name+"'");
				if(count>0){
					return true;
				}else{
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//�޸Ĳ�������
	public static boolean updateDept(String oldName,String newName){
		conn=DAO.getConnection();
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
			int count=stmt.executeUpdate("update tb_deptkind set deptKind='"+newName+"'where deptKind='"+oldName+"'");
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**************************end������Ϣ��ѯ�����**************************************/
	public static void main(String[] args){
			ResultSet rs1=DAO.getDeptKind();
			ResultSet rs2=null;
		
				try {
					while(rs1.next()){
						String name=rs1.getString("deptKind");//��ȡ��������е�deptKind�е�ֵ
						rs2=DAO.getDeptName(name);//��ȡ����name���ŵ��Ӳ�������
						while(rs2.next()){
							System.out.println(rs2.getString("deptName"));
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}


}
	


