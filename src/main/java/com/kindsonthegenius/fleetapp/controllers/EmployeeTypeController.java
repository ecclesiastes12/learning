package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.EmployeeTypeService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class EmployeeTypeController {

	
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	
	//method that displays employeeType page
	@GetMapping("/employeeTypes")
	public String getEmployeeTypes(Model model) {
		
		// for list of employeeTypes
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypeList);
		
		return "EmployeeType";
	}
	
	//method that process new data . for submit button
	@PostMapping("/employeeTypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType); //method call from EmployeeTypeService class
		return "redirect:/employeeTypes"; //redirect to employeeTypes page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("employeeTypes/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the employeeType
	@RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	
	//method for delete button
	@RequestMapping(value = "/employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	}
	
}
