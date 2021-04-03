package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	VehicleMovementRepository vehicleMovementRepository;

	//method that returns all vehicle movement
	public List<VehicleMovement> getAllVehicleMovements(){
		return vehicleMovementRepository.findAll();
	}
	
	//method that add vehicle movement
	public void addVehicleMovement(VehicleMovement vehicleMovement) {
		 vehicleMovementRepository.save(vehicleMovement);
	}
	
	//method that searches for vehicle movement by id
	public Optional<VehicleMovement> searchVehicleMovementById(int id){
		return vehicleMovementRepository.findById(id);
	}
	
	//method that delete vehicle movement
	public void deleteVehicleMovement(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
	
}
