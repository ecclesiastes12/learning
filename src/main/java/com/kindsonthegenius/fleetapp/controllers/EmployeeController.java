package com.kindsonthegenius.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Employee;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.EmployeeService;
import com.kindsonthegenius.fleetapp.services.EmployeeTypeService;
import com.kindsonthegenius.fleetapp.services.JobTitleService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	CountryService countryService;
	@Autowired
	EmployeeTypeService employeeTypeService;
	@Autowired
	StateService stateService;
	@Autowired
	JobTitleService jobTitleService;
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		model.addAttribute("countries", countryService.getCountries());
		return "Employee";
	}

	@PostMapping("/employees/addNew")
	public String addEmployee(Employee employee) {
		employeeService.addEmployees(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("employees/findById/")
	@ResponseBody
	public Optional<Employee> findEmployeeById(int id) {
	return	employeeService.findEmployeeById(id);
		
	}
	
	@RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployee(Employee employee) {
		employeeService.addEmployees(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	public String deleteEmployee(Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
	
}
