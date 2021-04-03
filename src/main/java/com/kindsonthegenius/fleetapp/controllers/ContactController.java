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

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService contactService;
	
	//displays list of all contacts
	@GetMapping("/contacts")
	public String getContacts(Model model) {
		
		model.addAttribute("contacts", contactService.getAllContacts());
		
		return "Contact";
	}
	
	//display contact by id
	@GetMapping("contacts/findById")
	@ResponseBody
	public Optional<Contact> findContactById(int id) {
		return contactService.searchContact(id);
	}
	
	@PostMapping("/contacts/addNew")
	public String addContact(Contact contact) {
		
		contactService.addContact(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateContact(Contact contact) {
		
		contactService.addContact(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value = "/contacts/delete", method = {RequestMethod.PUT, RequestMethod.GET})
	public String deleteContact(Integer id) {
		contactService.deleteContact(id);
		
		return "redirect:/contacts";
		
	}
	
	
	
	
	
	
}
