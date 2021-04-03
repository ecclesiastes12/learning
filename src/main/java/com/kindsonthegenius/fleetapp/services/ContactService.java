package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	//method that returns all contacts
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	//method to add new contact
	public void addContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	//method to search contact by id
	public Optional<Contact> searchContact(int id){
		return contactRepository.findById(id);
	}
	
	//method to delete contact by id
	public void deleteContact(Integer id) {
		 contactRepository.deleteById(id);
	}
	
	
	
}
