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

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleMovementService;

@Controller
public class VehicleMovementController {
	
	@Autowired
	VehicleMovementService vehicleMovementService;
	@Autowired
	LocationService locationService;

	@GetMapping("/vehicleMovements")
	public String getVehicleMovements(Model model) {
		
		model.addAttribute("vehicleMovements", vehicleMovementService.getAllVehicleMovements());
		model.addAttribute("locations", locationService.getLocations());
		
		return "VehicleMovement";
	}
	
	@PostMapping("/vehicleMovements/addNew")
	public String addVehicleMovements(VehicleMovement vehicleMovement) {
		vehicleMovementService.addVehicleMovement(vehicleMovement);
		
		return "redirect:/vehicleMovements";
	}
	
	@GetMapping("vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> searchVehicleMovementById(int id) {
		return vehicleMovementService.searchVehicleMovementById(id);
	}
	
	@RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.addVehicleMovement(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping(value = "/vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public void deleteVehicleMovement(Integer id) {
		vehicleMovementService.deleteVehicleMovement(id);
	}
	
}
