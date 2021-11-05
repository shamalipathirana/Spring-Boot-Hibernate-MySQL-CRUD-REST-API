package com.example.demo.service.impl;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	private EmployeeRepository employeeRepository;
	private EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository=employeeRepository;
	}

	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		/*Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return Employee.get();
			
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		*/
		return employeeRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Employee", "Id", id));
		
	}
	
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id is exist in DB or not
				Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Employee", "Id", id)); 
				
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setEmail(employee.getEmail());
				// save existing employee to DB
				employeeRepository.save(existingEmployee);
				return existingEmployee;
	}
   
	@Override
	public void deleteEmployee(long id) {
			// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
	
	
	
}
