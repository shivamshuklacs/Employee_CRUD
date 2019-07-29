package com.zensar.dao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class EmplyeeDAO {

	private static Connection connection=null;
	
	public static Connection createConnection() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			System.out.println("Driver Loaded"); 
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","root");  
			//here sonoo is database name, root is username and password  
			if (connection!=null) {
				System.out.println("CONNECTION DONE");
			}
			}catch(Exception e){ System.out.println(e);}  
		return connection;
	}
	public int addEmployee(Employee employee) throws Exception{ 
	connection = createConnection();
			String sql="insert into employee values (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmpid());
			preparedStatement.setString(2, employee.getEmpname());
			preparedStatement.setDouble(3, employee.getSalary());
			
			int result = preparedStatement.executeUpdate();
			
			return result;
	}
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> listofAllEmployees = new ArrayList<Employee>();
		Connection connection= createConnection();
		String sql="select *from employee";
		PreparedStatement pStatement=connection.prepareStatement(sql);
		ResultSet rSet=pStatement.executeQuery();
		while (rSet.next()) {
			int empid= rSet.getInt("empid");
			String empname= rSet.getString("empname");
			int salary= rSet.getInt("salary");
			Employee employee = new Employee(empid, empname, salary);
			listofAllEmployees.add(employee);
		}
		return listofAllEmployees;
		
	}
}

