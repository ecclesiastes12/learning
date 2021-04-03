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
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.models.VehicleStatus;
import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.services.EmployeeService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;
import com.kindsonthegenius.fleetapp.services.VehicleModelService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import com.kindsonthegenius.fleetapp.services.VehicleStatusService;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;


@Controller
public class VehicleController {

	
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	VehicleModelService vehicleModelService;
	@Autowired
	VehicleStatusService vehicleStatusService;
	@Autowired
	LocationService locationService;
	@Autowired
	EmployeeService employeeService;
	
	//method that displays vehicle page
	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		
		//invokes the method getStates() from the services class
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		//parameter 1 is attribute name 
		//parameter 2 is attribute value which is the list of vehicles we want to display
		model.addAttribute("vehicleTypes", vehicleTypeList);
		
		//for drop down list of countries
		//populates the drop down list with list of countries
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakeList);
		
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);
		
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
		model.addAttribute("vehicleStatuses", vehicleStatusList);
		
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		// for list of vehicles
		List<Vehicle> vehicleList = vehicleService.getAllVehicles();
		model.addAttribute("vehicles", vehicleList);
		
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "Vehicle";
	}
	
	//method that process new data . for submit button
	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle); //method call from VehicleService class
		return "redirect:/vehicles"; //redirect to vehicles page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("vehicles/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<Vehicle> findById(int id) {
		return vehicleService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the vehicle
	@RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	//method for delete button
	@RequestMapping(value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
	
	
}
