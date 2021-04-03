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

import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.services.ClientService;
import com.kindsonthegenius.fleetapp.services.InvoiceService;
import com.kindsonthegenius.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	ClientService clientService;
	@Autowired
	InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoices")
	public String getInvoices(Model model) {
		
		model.addAttribute("invoices", invoiceService.getInvoicesList());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuss());
		
		return "Invoice";
	}
	
	@PostMapping("/invoices/addNew")
	public String addInvoice(Invoice invoice) {
		
		invoiceService.addInvoice(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value="/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoice(Invoice invoice) {
		invoiceService.addInvoice(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value = "/invoices/deleteInvoice",method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteInvoice(Integer id) {
		invoiceService.deleteInvoice(id);
		return "redirect:/invoices";
	}
}
