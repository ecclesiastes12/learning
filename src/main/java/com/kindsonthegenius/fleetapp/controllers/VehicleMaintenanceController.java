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

import com.kindsonthegenius.fleetapp.models.VehicleMaintenance;
import com.kindsonthegenius.fleetapp.services.SupplierService;
import com.kindsonthegenius.fleetapp.services.VehicleMaintananceService;
import com.kindsonthegenius.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	VehicleMaintananceService vehicleMaintenanceService;
	@Autowired
	VehicleService vehicleService;
	@Autowired
	SupplierService supplierService;
	
	@GetMapping("/vehicleMaintainances")
	public String getVehicleMaintainances(Model model) {
		
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getAllVehicleMaintenances());
		model.addAttribute("vehicles", vehicleService.getAllVehicles());
		model.addAttribute("suppliers", supplierService.getAllSuppliers());
		
		return "VehicleMaintainance";
	}
	
	
	@PostMapping("/vehicleMaintainances")
	public String addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.addVehicleMaintenace(vehicleMaintenance);
		return "redirect:/vehicleMaintainance";
	}
	
	@GetMapping("vehicleMaintainance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> searchVehicleMaintenace(int id){
		
		return vehicleMaintenanceService.searchVehicleMaintenanceById(id);
	}
	
	
	@RequestMapping(value = "/vehicleMaintainance/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.addVehicleMaintenace(vehicleMaintenance);
		return "redirect:/vehicleMaintainance";
	}
	
	@RequestMapping(value = "/vehicleMaintainance/delete", method = {RequestMethod.PUT, RequestMethod.GET})
	public void deleteVehicleMaintenace(Integer id) {
		vehicleMaintenanceService.deleteVehicleMaintenance(id);
	}
	
}
