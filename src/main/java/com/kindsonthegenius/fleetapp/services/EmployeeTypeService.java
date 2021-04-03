package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//return list of states
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}
	
	//method to add new state
	public void save(EmployeeType employeeType) { //parameter takes the object of the entity you are dealing with
		employeeTypeRepository.save(employeeType);
	}
	
	//method to search state by id
	//Optional<State> is used so that it will not crash in case no id is found
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	//method to delete state by id
	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
		
	}

	

	
	
}
