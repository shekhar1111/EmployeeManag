package com.EmployeeManag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManag.entity.Employee;
import com.EmployeeManag.repository.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepo employeerepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee employee1=employeerepo.save(employee);
		return employee1;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> list=employeerepo.findAll();
		return list;
	}

	

	@Override
	public Employee editEmployee(Employee employee) {
			employeerepo.save(employee);
			return employee;
	}

	@Override
	public String deleteEmployee(int id) {
          employeerepo.deleteById(id);
          return "deleted";
	}

	@Override
	public Employee getEmployee(int id) {
		return employeerepo.findById(id).get();
	}

	


	

}
