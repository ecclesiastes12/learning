package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	//method to add new supplier
	public void addSupplier(Supplier supplier) {
		
		supplierRepository.save(supplier);
	}

	//method to get all supplier
	public List<Supplier> getAllSuppliers(){
		return supplierRepository.findAll();
	}
	
	//method to find supplier by id
	
	public Optional<Supplier> searchById(int id){
		return supplierRepository.findById(id);
	}
	
	//method to delete supplier by id
	
	public void deleteSupplier(Integer id) {
		supplierRepository.deleteById(id);
	}
}
