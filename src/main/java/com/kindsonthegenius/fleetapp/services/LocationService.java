package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {


	@Autowired
	private LocationRepository locationRepository;
	
	//return list of Location
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	//method to add new Location
	public void save(Location location) { //parameter takes the object of the entity you are dealing with
		locationRepository.save(location);
	}
	
	//method to search Location by id
	//Optional<Location> is used so that it will not crash in case no id is found
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	//method to delete Location by id
	public void delete(Integer id) {
		locationRepository.deleteById(id);
		
	}

	
}
