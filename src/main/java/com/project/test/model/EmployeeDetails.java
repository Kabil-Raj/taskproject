package com.project.test.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employeedetails")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String employeeName;
	
	private Date employeeDateOfJoining;
	
	private String employeeDepartment;
	
	private int employeeId;
	
	private String employeePlace;

	
	public void employeeDetails (String name, Date date, String department, int id, String place) {
		this.setEmployeeName(name);
		this.setEmployeeDateOfJoining(date);
		this.setEmployeeDepartment(department);
		this.setEmployeeId(id);
		this.setEmployeePlace(place);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Date getEmployeeDateOfJoining() {
		return employeeDateOfJoining;
	}


	public void setEmployeeDateOfJoining(Date employeeDateOfJoining) {
		this.employeeDateOfJoining = employeeDateOfJoining;
	}


	public String getEmployeeDepartment() {
		return employeeDepartment;
	}


	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeePlace() {
		return employeePlace;
	}


	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	
	
}
