package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	//method that returns list of invoices
	public List<Invoice> getInvoicesList(){
		return invoiceRepository.findAll();
	}
	
	//method that add new invoice
	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	//method to find invoice by id
	public Optional<Invoice> findById(int id){
		return invoiceRepository.findById(id);
	}
	
	//method to delete invoice by id
	public void deleteInvoice(Integer id) {
		invoiceRepository.deleteById(id);
	}
}
