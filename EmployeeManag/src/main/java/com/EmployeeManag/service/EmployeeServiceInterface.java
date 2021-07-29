package com.EmployeeManag.service;

import java.util.List;

import com.EmployeeManag.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployee(int id);

	Employee editEmployee(Employee employee);

	String deleteEmployee(int id);



}
