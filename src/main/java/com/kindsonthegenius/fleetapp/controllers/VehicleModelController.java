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
import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {


	@Autowired
	private VehicleModelService vehicleModelService;
	
	
	//method that displays vehicleModel page
	@GetMapping("/vehicleModels")
	public String getVehicleModels(Model model) {
	
		
		// for list of vehicleModels
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);
		
		return "VehicleModel";
	}
	
	//method that process new data . for submit button
	@PostMapping("/vehicleModels/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel); //method call from VehicleModelService class
		return "redirect:/vehicleModels"; //redirect to vehicleModels page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("vehicleModels/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the vehicleModel
	@RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}
	
	//method for delete button
	@RequestMapping(value = "/vehicleModels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/vehicleModels";
	}
	
}
