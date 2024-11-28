package models;

import java.io.Serializable;

public class Employee implements Serializable{
	private int id;
	private String name;
	private String address;
	private int telephoneNo;
	private String DOB;
	private String gender;
	private String designation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(int telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Employee() {
		this.id = 0;
		this.name = "";
		this.address = "";
		this.telephoneNo = 0;
		this.DOB = "";
		this.gender = "";
		this.designation = "";
	}
	
	public Employee(String name, String address, int telephoneNo, String dob, String gender, String designation) {
		this.id = 0;
		this.name = name;
		this.address = address;
		this.telephoneNo = telephoneNo;
		this.DOB = dob;
		this.gender = gender;
		this.designation = designation;
	}
	
	public Employee(int id, String name, String address, int telephoneNo, String dob, String gender, String designation) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephoneNo = telephoneNo;
		this.DOB = dob;
		this.gender = gender;
		this.designation = designation;
	}
}
