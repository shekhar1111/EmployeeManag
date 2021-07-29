package com.EmployeeManag.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {
	@Id
	private int employeeId;
	private String employeeName;
	private int salary;
	private String departmentName;
	private Date bdupdatedate;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public java.util.Date getBdupdatedate() {
		return bdupdatedate;
	}
	public void setBdupdatedate(java.util.Date bdupdatedate) {
		this.bdupdatedate = bdupdatedate;
	}
	public Employee() {
		super();
	}
	public Employee(int employeeId, String employeeName, int salary, String departmentName, Date bdupdatedate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.departmentName = departmentName;
		this.bdupdatedate = bdupdatedate;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", departmentName=" + departmentName + ", bdupdatedate=" + bdupdatedate + "]";
	}
	
	
	
	

}
