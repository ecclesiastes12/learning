package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMaintenance;
import com.kindsonthegenius.fleetapp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintananceService {

	@Autowired
	VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	//method that returns all vehicle maintenance
	public List<VehicleMaintenance> getAllVehicleMaintenances(){
		return vehicleMaintenanceRepository.findAll();
	}
	
	//method that add new vehicle Maintenace
	public void addVehicleMaintenace(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	//method that search for vehicle maintenance by id
	public Optional<VehicleMaintenance> searchVehicleMaintenanceById(int id){
		return vehicleMaintenanceRepository.findById(id);
	}
	
	//method to delete vehicle maintenance by id
	public void deleteVehicleMaintenance(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	
}
