package com;


import java.sql.*;




public class DAO {
/******************************数据库的连接********************************************/
	private static final String URL ="jdbc:mysql://127.0.0.1:3306/employeemanager?characterEncoding=utf-8";//本机。数据库端口：3306。数据库名：imooc。
	private static final String USER="root";//数据库用户名
	private static final String PASSWORD="1111";//数据库密码
	private static  Connection conn =null;
	
	//静态块:在程序的一次执行过程中，static{}语句块中的内容只被执行一次	
	static{
    	   	try{
    	   		//1-加载驱动程序
    	   		Class.forName("com.mysql.jdbc.Driver");//反射。通过一个类的类名，反向的将类加载到环境中
    	   		conn = DriverManager.getConnection(URL,USER,PASSWORD);
    	   		if(conn!=null){
    	   			System.out.println("mysql数据库连接成功");
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
	/**************************start部门信息查询与管理**************************************/
	//返回所有的部门类型（deptkind-deptKind）
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
	//返回name类型部门的所有的子部门的名称(deptinfo-deptName,deptId作为外键)
	public static ResultSet getDeptName(String name){
		conn=DAO.getConnection();
		Statement stmt1 =null;//可以用来执行静态SQL语句
		Statement stmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
			
			try {
					stmt1=conn.createStatement();
					stmt2=conn.createStatement();
					rs=stmt1.executeQuery("select deptId from tb_deptKind where deptKind='"+name+"'");//deptId是表tb_deptinfo对表deptId的外键
					while(rs.next()){
						int id=rs.getInt("deptId");
						rs2=stmt2.executeQuery("select deptName from tb_deptinfo "
											+ "where deptId="+id+"");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("DAO2:"+e.getMessage());
			}//外键
			return rs2;

		
	}
	//添加新部门
	public static boolean addDept(String name){
		conn=DAO.getConnection();
		ResultSet rs=null;
		Statement stmt=null;
		Statement stmt2=null;
		try {
			stmt=conn.createStatement();
			stmt2=conn.createStatement();
			rs=stmt.executeQuery("select*from tb_deptkind where deptKind='"+name+"'");//查询是否已经存在该部门名称
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
	//删除部门
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
				return false;//部门类型下面存在有子部门，则禁止删除
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
	//修改部门名称
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
	
	/**************************end部门信息查询与管理**************************************/
	public static void main(String[] args){
			ResultSet rs1=DAO.getDeptKind();
			ResultSet rs2=null;
		
				try {
					while(rs1.next()){
						String name=rs1.getString("deptKind");//获取结果集合中的deptKind列的值
						rs2=DAO.getDeptName(name);//获取所有name部门的子部门名称
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
	


