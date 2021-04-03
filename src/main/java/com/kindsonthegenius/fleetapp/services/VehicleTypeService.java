package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	//return list of VehicleType
	public List<VehicleType> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
	}
	
	//method to add new VehicleType
	public void save(VehicleType vehicleType) { //parameter takes the object of the entity you are dealing with
		vehicleTypeRepository.save(vehicleType);
	}
	
	//method to search VehicleType by id
	//Optional<VehicleType> is used so that it will not crash in case no id is found
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	//method to delete VehicleType by id
	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
		
	}
	
	
}
