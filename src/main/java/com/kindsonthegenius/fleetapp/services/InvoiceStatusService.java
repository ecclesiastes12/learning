package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.InvoiceStatus;
import com.kindsonthegenius.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//return list of states
	public List<InvoiceStatus> getInvoiceStatuss(){
		return invoiceStatusRepository.findAll();
	}
	
	//method to add new state
	public void save(InvoiceStatus invoiceStatus) { //parameter takes the object of the entity you are dealing with
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//method to search state by id
	//Optional<State> is used so that it will not crash in case no id is found
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	//method to delete state by id
	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
		
	}
	
}
