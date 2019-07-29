package com.zensar.view;

import java.awt.List;
import java.util.ArrayList;

import com.zensar.dao.Employee;
import com.zensar.dao.EmplyeeDAO;

public class Test {
			
	public static void main(String[] args) throws Exception {
	
//		EmplyeeDAO.createConnection();
		EmplyeeDAO emplyeeDAO= new EmplyeeDAO();
		/*Employee employee = new Employee(2,"Adarsh",86000);
		int num=emplyeeDAO.addEmployee(employee);
		
		System.out.println(num + " rows inserted");*/
		
		ArrayList<Employee> list= (ArrayList<Employee>) emplyeeDAO.getAllEmployees();
		for (Employee employee : list) {
			System.out.println(employee.toString());
		}
	}
}
