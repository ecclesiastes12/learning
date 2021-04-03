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
import com.kindsonthegenius.fleetapp.models.VehicleStatus;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	
	//method that displays vehicleStatus page
	@GetMapping("/vehicleStatuses")
	public String getVehicleStatus(Model model) {
		
		// for list of vehicleStatuss
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
		model.addAttribute("vehicleStatuses", vehicleStatusList);
		
		return "VehicleStatus";
	}
	
	//method that process new data . for submit button
	@PostMapping("/vehicleStatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus); //method call from VehicleStatusService class
		return "redirect:/vehicleStatuses"; //redirect to vehicleStatuss page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("vehicleStatuses/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the vehicleStatus
	@RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	//method for delete button
	@RequestMapping(value = "/vehicleStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	}
	
}
