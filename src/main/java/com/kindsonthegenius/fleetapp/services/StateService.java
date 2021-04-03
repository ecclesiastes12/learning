package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//return list of states
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
	//method to add new state
	public void save(State state) { //parameter takes the object of the entity you are dealing with
		stateRepository.save(state);
	}
	
	//method to search state by id
	//Optional<State> is used so that it will not crash in case no id is found
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	//method to delete state by id
	public void delete(Integer id) {
		stateRepository.deleteById(id);
		
	}
	
}
