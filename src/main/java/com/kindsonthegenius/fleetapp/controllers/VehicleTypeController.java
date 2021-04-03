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

import com.kindsonthegenius.fleetapp.models.VehicleType;


import com.kindsonthegenius.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	
	@Autowired
	private VehicleTypeService vehicleTypeService;

	
	//method that displays vehicleType page
	@GetMapping("/vehicleTypes")
	public String getVehicleTypes(Model model) {
		
		// for list of vehicleTypes
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypeList);
		
		return "VehicleType";
	}
	
	//method that process new data . for submit button
	@PostMapping("/vehicleTypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType); //method call from VehicleTypeService class
		return "redirect:/vehicleTypes"; //redirect to vehicleTypes page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("vehicleTypes/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the vehicleType
	@RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	//method for delete button
	@RequestMapping(value = "/vehicleTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}
}
