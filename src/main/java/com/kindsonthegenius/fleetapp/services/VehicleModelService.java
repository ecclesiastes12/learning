package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//return list of states
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
	}
	
	//method to add new state
	public void save(VehicleModel vehicleModel) { //parameter takes the object of the entity you are dealing with
		vehicleModelRepository.save(vehicleModel);
	}
	
	//method to search state by id
	//Optional<State> is used so that it will not crash in case no id is found
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	//method to delete state by id
	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
		
	}
	
}
