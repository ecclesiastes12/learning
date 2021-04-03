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
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	//method that displays state page
	@GetMapping("/states")
	public String getStates(Model model) {
		
		//invokes the method getStates() from the services class
		List<State> stateList = stateService.getStates();
		//parameter 1 is attribute name 
		//parameter 2 is attribute value which is the list of states we want to display
		model.addAttribute("states", stateList);
		
		//for drop down list of countries
		//populates the drop down list with list of countries
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		return "State";
	}
	
	//method that process new data . for submit button
	@PostMapping("/states/addNew")
	public String addNew(State state) {
		stateService.save(state); //method call from StateService class
		return "redirect:/states"; //redirect to states page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("states/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<State> findById(int id) {
		return stateService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the state
	@RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
	//method for delete button
	@RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		stateService.delete(id);
		return "redirect:/states";
	}
	
}
