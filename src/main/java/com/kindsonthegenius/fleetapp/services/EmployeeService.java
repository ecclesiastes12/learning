package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Employee;
import com.kindsonthegenius.fleetapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	// method that returns list of employees
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	// method that adds new employee
	public void addEmployees(Employee employee) {
		
		employeeRepository.save(employee);
	}
	
	// method that search employee by id
	public Optional<Employee> findEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	//method that delete employee by id
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	
	
}
