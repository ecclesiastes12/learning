package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.repositories.ClientRepository;


@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	//method to return list of clients
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	//method to add client
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	//method to search client by id
	public Optional<Client> findById(int id){
		return clientRepository.findById(id);
	}
	
	//method to delete client by id
	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}
	
	
}
