package com.jsp.spring_mvc_crud_operation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.spring_mvc_crud_operation.dto.Employee;

public class EmployeeDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springmvc");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	//	==============================here is insert the data =============================================== 
	public Employee saveEmployeeDao(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	// ====================================here is using the delete data========================================= 

	public boolean deleteEmployeeDao(int employeeId) {
		Employee employee = getEmployeeById(employeeId);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
//  ====================================here is using Update data==============================================

	public Employee updateEmployeeDao(int employeeId, String employeeName) {
		Employee employee = getEmployeeById(employeeId);
		if(employee!=null) {
		    employee.setName(employeeName);
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			return employee;
		}else {
			return employee;
		}
			
	}
	
	// ====================================here is using Display the data by id==========================================

	public Employee getEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	
	// ====================================here is using Display All the data ==========================================

public List<Employee> getAllEmployeeDao(){
		
		String displayQuery = "From Employee";
		
	Query query=entityManager.createQuery(displayQuery);
		
		return query.getResultList();
	}
 

}
