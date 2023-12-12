package com.jsp.spring_mvc_crud_operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.spring_mvc_crud_operation.dao.EmployeeDao;
import com.jsp.spring_mvc_crud_operation.dto.Employee;

public class EmployeeService {
	
	private EmployeeDao dao;

	 static EmployeeDao employeeDao = new EmployeeDao();
		public Employee saveemployeeService(Employee employee) {

			return employeeDao.saveEmployeeDao(employee);	
		}

		//====================================here is using the delete data========================================= 

		public void deleteEmployeeService(int employeeId) {
			employeeDao.deleteEmployeeDao(employeeId);
		}

		
		
		public Employee updateEmployeeServices(int employeeId, String employeeName) { 
			return employeeDao.updateEmployeeDao(employeeId, employeeName);

		}
		
		//====================================here is using Display the data==========================================

			public Employee getEmployeeByIdService(int employeeId) {
				return employeeDao.getEmployeeById(employeeId);
			}
			
			public List<Employee> displayAllEmployeeService(){
				return employeeDao.getAllEmployeeDao();
			}
			
}
