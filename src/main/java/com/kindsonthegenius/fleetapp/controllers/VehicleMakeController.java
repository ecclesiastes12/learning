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
import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {


	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	
	//method that displays vehicleMake page
	@GetMapping("/vehicleMakes")
	public String getVehicleMakes(Model model) {

		
		// for list of vehicleMakes
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakeList);
		
		return "VehicleMake";
	}
	
	//method that process new data . for submit button
	@PostMapping("/vehicleMakes/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake); //method call from VehicleMakeService class
		return "redirect:/vehicleMakes"; //redirect to vehicleMakes page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("vehicleMakes/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the vehicleMake
	@RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}
	
	//method for delete button
	@RequestMapping(value = "/vehicleMakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehicleMakes";
	}
	
}
