package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	//method that displays country page
	@GetMapping("/countries")
	public String getCountries(Model model) {
		
		//invokes the method getCountries() from the services class
		List<Country> countryList = countryService.getCountries();
		//parameter 1 is attribute name 
		//parameter 2 is attribute value which is the list of countries we want to display
		model.addAttribute("countries", countryList);
		return "country";
	}
	
	//method that process new data . for submit button
	@PostMapping("/countries/addNew")
	public String addNew(Country country) {
		countryService.save(country); //method call from CountryService class
		return "redirect:/countries"; //redirect to countries page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("countries/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<Country> findById(int id) {
		return countryService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the country
	@RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}
	
	//method for delete button
	@RequestMapping(value = "/countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
}
