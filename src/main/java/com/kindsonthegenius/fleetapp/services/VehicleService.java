package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Vehicle;

import com.kindsonthegenius.fleetapp.repositories.VehicleRepository;


@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	//return list of Vehicle
	public List<Vehicle> getAllVehicles(){
		return vehicleRepository.findAll();
	}
	
	//method to add new Vehicle
	public void save(Vehicle location) { //parameter takes the object of the entity you are dealing with
		vehicleRepository.save(location);
	}
	
	//method to search Vehicle by id
	//Optional<Vehicle> is used so that it will not crash in case no id is found
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	//method to delete Vehicle by id
	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
		
	}

}
