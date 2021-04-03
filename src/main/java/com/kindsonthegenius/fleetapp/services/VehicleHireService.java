package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	VehicleHireRepository vehicleHireRepository;
	
	//method that adds new vehicle hired
	public void addVehicleHire(VehicleHire vehicleHire) {
		 vehicleHireRepository.save(vehicleHire);
	}
	
	//method that return all vehicle hired
	public List<VehicleHire> getAllVehicleHires(){
		return vehicleHireRepository.findAll();
	}
	
	//method to search veicle hired by id
	public Optional<VehicleHire> searchVehicleHire(int id){
		return vehicleHireRepository.findById(id);
	}
	
	//method to delete vehicle hired
	public void deleteVehicleHire(Integer id) {
		 vehicleHireRepository.deleteById(id);
	}
}
