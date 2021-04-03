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
import com.kindsonthegenius.fleetapp.models.InvoiceStatus;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	
	//method that displays invoiceStatus page
	@GetMapping("/invoiceStatuses")
	public String InvoiceStatus(Model model) {
		
		// for list of invoiceStatuses
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		
		return "InvoiceStatus";
	}
	
	//method that process new data . for submit button
	@PostMapping("/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus); //method call from InvoiceStatusService class
		return "redirect:/invoiceStatuses"; //redirect to invoiceStatuses page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("invoiceStatuses/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the invoiceStatus
	@RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	//method for delete button
	@RequestMapping(value = "/invoiceStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
