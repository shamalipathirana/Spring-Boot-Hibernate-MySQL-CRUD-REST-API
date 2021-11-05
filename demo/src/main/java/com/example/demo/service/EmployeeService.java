package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;


//import net.sf.jasperreports.engine.JRException;

//import antlr.collections.List;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	//List<Employee> getAllEmployees();
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	//Employee updateEmployee(Employee employee, long id);
	Employee updateEmployee(Employee employee, long id);
	//Employee updateEmployee1(Employee employee, long id);
	//void deleteEmployee(long id);
	void deleteEmployee(long id);
	
	//String exportReport(String reportFormat);
	//String generateReport();
	
	

}
