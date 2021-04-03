package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//return list of VehicleMake
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}
	
	//method to add new VehicleMake
	public void save(VehicleMake vehicleMake) { //parameter takes the object of the entity you are dealing with
		vehicleMakeRepository.save(vehicleMake);
	}
	
	//method to search VehicleMake by id
	//Optional<VehicleMake> is used so that it will not crash in case no id is found
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	//method to delete VehicleMake by id
	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
		
	}
	
}
