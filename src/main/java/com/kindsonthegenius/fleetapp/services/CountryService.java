package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	//return list of countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
	//method to add new country
	public void save(Country country) { //parameter takes the object of the entity you are dealing with
		countryRepository.save(country);
	}
	
	//method to search country by id
	//Optional<Country> is used so that it will not crash in case no id is found
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}

	//method to delete country by id
	public void delete(Integer id) {
		countryRepository.deleteById(id);
		
	}

	
}
