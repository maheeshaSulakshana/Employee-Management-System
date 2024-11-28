package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Employee;

public class EmployeeDb implements IDao<Employee>{

	@Override
	public List<Employee> getAll() {
		try {
			Connection con = MySqlConnection.connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employees");
			List<Employee> employeeList = new ArrayList<>();
			
			while (rs.next()) {
				Employee employee = new Employee();
				
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setTelephoneNo(rs.getInt(4));
				employee.setDOB(rs.getString(5));
				employee.setGender(rs.getString(6));
				employee.setDesignation(rs.getString(7));
				
				employeeList.add(employee);
			}
			
			return employeeList;
		}
		catch (Exception ex) {
			System.out.println("Error from DAO_Employee:- " +ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean insert(Employee employee) {
		try {
			Connection con = MySqlConnection.connect();
			PreparedStatement pstmt = con.prepareStatement("Insert into Employees(Name, Address, TelephoneNo, DOB, Gender, Designation)"
														 	+ "values(? ,? ,? ,? ,? ,? )");
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getAddress());
			pstmt.setInt(3, employee.getTelephoneNo());
			pstmt.setString(4, employee.getDOB());
			pstmt.setString(5, employee.getGender());
			pstmt.setString(6, employee.getDesignation());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception ex) {
			System.out.println("Error from DAO_Employee:- " +ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Employee employee) {
		try {
			Connection con = MySqlConnection.connect();
			PreparedStatement pstmt = con.prepareStatement("Update Employees set Name = ?, Address = ?, TelephoneNo = ?, DOB = ?,"
																			 + " Gender = ?, Designation = ? where ID = ?");
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getAddress());
			pstmt.setInt(3, employee.getTelephoneNo());
			pstmt.setString(4, employee.getDOB());
			pstmt.setString(5, employee.getGender());
			pstmt.setString(6, employee.getDesignation());
			pstmt.setInt(7, employee.getId());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception ex) {
			System.out.println("Error from DAO_Employee:- " +ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			Connection con = MySqlConnection.connect();
			PreparedStatement pstmt = con.prepareStatement("Delete from Employees where ID = ?");

			pstmt.setInt(1, id);
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception ex) {
			System.out.println("Error from DAO_Employee:- " +ex.getMessage());
			return false;
		}
	}

	@Override
	public Employee getbyID(int id) {
		try {
			Connection con = MySqlConnection.connect();
			PreparedStatement pstmt = con.prepareStatement("Select * from Employees where ID = ?");

			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Employee employee = new Employee();
				
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setTelephoneNo(rs.getInt(4));
				employee.setDOB(rs.getString(5));
				employee.setGender(rs.getString(6));
				employee.setDesignation(rs.getString(7));
				
				return employee;			
			}
			return null;
		}
		catch (Exception ex) {
			System.out.println("Error from DAO_Employee:- " +ex.getMessage());
			return null;
		}
	}

	public List<Integer> getIds(){
		try {
			Connection con = MySqlConnection.connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select ID from Employees");
			List<Integer> IDs = new ArrayList<>();
			
			while (rs.next()) {
				IDs.add(rs.getInt(1));
			}
			
			return IDs;
		}
		catch (Exception ex) {
			System.out.println("Error from EmployeeDb:- " +ex.getMessage());
			return null;
		}
		
	}
}
