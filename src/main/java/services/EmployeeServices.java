package services;

import java.util.List;

import dao.EmployeeDb;
import models.Employee;

public class EmployeeServices {
	
	public List<Employee> getAll(){
		EmployeeDb employeeDb = new EmployeeDb();
		
		return employeeDb.getAll();
	}
	
	public boolean save(Employee employee) {
		EmployeeDb employeeDb = new EmployeeDb();
		
		return employeeDb.insert(employee);
	}
	
	public boolean update(Employee employee) {
		EmployeeDb employeeDb = new EmployeeDb();
		
		return employeeDb.update(employee);
	}
	
	public boolean delete(int id) {
		EmployeeDb employeeDb = new EmployeeDb();
		
		return employeeDb.delete(id);
	}
	
	public Employee findByID(int id) {
		EmployeeDb employeeDb = new EmployeeDb();
		
		return employeeDb.getbyID(id);
	}
	
	public List<Integer> getAllIds(){
		EmployeeDb employeeDb = new EmployeeDb();
		
		return employeeDb.getIds();
	}
}
