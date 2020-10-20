package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.util.ConnectionUtil;

public class EmployeeDao {

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}

	private static EmployeeDao employeeDao=null;
	public static EmployeeDao getEmpDao(){
		if(employeeDao==null){
			
			employeeDao=new EmployeeDao();
		}
		return employeeDao;
		
	}
	
	

	public int deleteEmpDetails(int id) throws SQLException{
		
		int flag=0;
		String query="delete from employee where id=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		//
		 //start
		 connection.setAutoCommit(false);
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		
		flag=preparedStatement.executeUpdate();
		
		connection.commit();
		//end transaction
		System.out.println("deleted="+flag);
		
		
		
		
		}finally{
			
			
			try {
		
				if(connection!=null){				
				connection.close();
				}
				if(preparedStatement!=null){				
					preparedStatement.close();
				}
				if(resultSet!=null){				
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error while closing");
			// rollback transaction
			connection.rollback();
			
			}
			
		}
		
		
			
			
			
		
		
		
		
		
		
		
		
		return flag;
	}
	
	

	
	
	public int updateEmpDetails(EmployeeDetails employeeDetails) throws SQLException{
		
		int flag=0;
		String query="update employee set phone=? ,salary=? where id=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setString(1, employeeDetails.getPhone());
		preparedStatement.setFloat(2, employeeDetails.getSalary());
		preparedStatement.setInt(3, employeeDetails.getId());
		
		flag=preparedStatement.executeUpdate();
		
		
		System.out.println("updated="+flag);
		
		
		
		
		}finally{
			
			
			try {
		
				if(connection!=null){				
				connection.close();
				}
				if(preparedStatement!=null){				
					preparedStatement.close();
				}
				if(resultSet!=null){				
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error while closing");
			}
			
		}
		
		
			
			
			
		
		
		
		
		
		
		
		
		return flag;
	}
	
	
	
	public List<EmployeeDetails> getEmpDetails() throws SQLException{
		
		List<EmployeeDetails > emmpList=new ArrayList<EmployeeDetails>();
		int status=0;
		String query="select * from employee";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{	
			 connection=	ConnectionUtil.getConnection();
			 preparedStatement=	   connection.prepareStatement(query);
			
			//preparedStatement.setString(1, username);
			//preparedStatement.setString(2, password);
// execute select qury
			
			 resultSet= preparedStatement.executeQuery();
			//select qury is retutn only 1 recored becuse username is unique
			// if query returns multiplle records
			 //then while loop comes other wise if stmt comes
			 //above select return 2 column username and password
			 while(resultSet.next()){
				//getting user name db given after select executed
				int id= resultSet.getInt("id");
				String name=resultSet.getString("name");
				float salary=resultSet.getFloat("salary");

				String phone=resultSet.getString("phone");
				char gender=resultSet.getString("gender").charAt(0)  ;
				String company=resultSet.getString("company");
				EmployeeDetails details=new EmployeeDetails(id, name, salary, phone, gender, company);
				emmpList.add(details);
				
				
				// we dont need user andm passwird we dont want to share
				// we return 0 or 1
				 
				// status=1;
				
				
				
				
				
				
			}
			 
			 
			
			//System.out.println("inserted="+flag);
			
			
			
			
			
			}finally{
				
				
				try {
			
					if(connection!=null){				
					connection.close();
					}
					if(preparedStatement!=null){				
						preparedStatement.close();
					}
					if(resultSet!=null){				
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("error while closing");
				}
				
			}
			
			
				
				
				
				
		
		
		
		
		
		return emmpList;
	}
	
	
	
	
	public int validateUserDetails(String username,String password) throws SQLException{
		int status=0;
		String query="select username,password from login where username=? and password=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{	
			 connection=	ConnectionUtil.getConnection();
			 preparedStatement=	   connection.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
// execute select qury
			
			 resultSet= preparedStatement.executeQuery();
			//select qury is retutn only 1 recored becuse username is unique
			// if query returns multiplle records
			 //then while loop comes other wise if stmt comes
			 //above select return 2 column username and password
			 if(resultSet.next()){
				//getting user name db given after select executed
				//String name=resultSet.getString("ussername");
				//String password=resultSet.getString("password");
				  // we dont need user andm passwird we dont want to share
				// we return 0 or 1
				 
				 status=1;
				
				
				
				
				
				
			}
			 
			 
			
			//System.out.println("inserted="+flag);
			
			
			
			
			
			}finally{
				
				
				try {
			
					if(connection!=null){				
					connection.close();
					}
					if(preparedStatement!=null){				
						preparedStatement.close();
					}
					if(resultSet!=null){				
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("error while closing");
				}
				
			}
			
			
				
				
				
				
				
				
		
		
		
		
		
		return status;
		
		
	}
	
	
	
	public int saveEmpDetails(EmployeeDetails employeeDetails) throws SQLException{
		int flag=0;
		String query="insert into employee(name,salary,phone,gender,company) values(?,?,?,?,?)";
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
		try{	
	 connection=	ConnectionUtil.getConnection();
	 preparedStatement=	   connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	preparedStatement.setString(1, employeeDetails.getName());
	preparedStatement.setFloat(2, employeeDetails.getSalary());
	preparedStatement.setString(3, employeeDetails.getPhone());
	preparedStatement.setString(4, ""+employeeDetails.getGender());
	preparedStatement.setString(5, employeeDetails.getCompany());
	
	flag=preparedStatement.executeUpdate();
	
	 resultSet=preparedStatement.getGeneratedKeys();
	
	System.out.println("inserted="+flag);
	
	if(resultSet.next()){
		
	flag=	resultSet.getInt(1);
		
	}
	
	
	
	
	}finally{
		
		
		try {
	
			if(connection!=null){				
			connection.close();
			}
			if(preparedStatement!=null){				
				preparedStatement.close();
			}
			if(resultSet!=null){				
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error while closing");
		}
		
	}
	
	
		
		
		
		
		return flag;
		
		
	}
	
	
}
