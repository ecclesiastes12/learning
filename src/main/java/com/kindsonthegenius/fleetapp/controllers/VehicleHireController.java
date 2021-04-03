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

import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.services.ClientService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleHireService;
import com.kindsonthegenius.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {

	@Autowired
	VehicleHireService vehicleHireService;
	@Autowired
	LocationService locationService;
	@Autowired
	ClientService clientService;
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/vehicleHires")
	public String getVehicleHires(Model model) {
		
		List<VehicleHire> vehicleHireList = vehicleHireService.getAllVehicleHires();
		model.addAttribute("vehicleHires", vehicleHireList);
		
		List<Location> getLocationList = locationService.getLocations();
		model.addAttribute("locations", getLocationList);
		
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("vehicles", vehicleService.getAllVehicles());
		
		return "VehicleHire";
	}
	
	@PostMapping("/vehicleHires/addNew")
	public String addVehicleHired(VehicleHire vehicleHire) {
		vehicleHireService.addVehicleHire(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleHired(VehicleHire vehicleHire) {
		vehicleHireService.addVehicleHire(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@GetMapping("vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> searchVehicleHiredById(int id) {
		return vehicleHireService.searchVehicleHire(id);
		
	}
	
	@RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleHire(Integer id) {
		 vehicleHireService.deleteVehicleHire(id);
		return "redirect:/vehicleHires";
	}
	
}
