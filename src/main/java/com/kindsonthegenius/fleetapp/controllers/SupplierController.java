package com.kindsonthegenius.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;
import com.kindsonthegenius.fleetapp.services.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	@Autowired
	CountryService countryService;
	@Autowired
	StateService stateService;
	
	
	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {
		
		model.addAttribute("suppliers", supplierService.getAllSuppliers());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		
		return "Supplier";
	}
	
	@PostMapping("/suppliers/addNew")
	public String addSupplier(Supplier supplier) {
		supplierService.addSupplier(supplier);
		
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT,RequestMethod.GET})
	public String updateSupplier(Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "redirect:/suppliers";
	}
	
	@GetMapping("suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findSupplierById(int id){
		return supplierService.searchById(id);
	}
	
	@RequestMapping(value = "/suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteSupplier(Integer id) {
		supplierService.deleteSupplier(id);
		return "redirect:/suppliers";
	}
	
	
}
