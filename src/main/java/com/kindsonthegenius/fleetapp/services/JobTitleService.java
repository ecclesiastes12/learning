package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//return list of states
	public List<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
	}
	
	//method to add new state
	public void save(JobTitle jobTitle) { //parameter takes the object of the entity you are dealing with
		jobTitleRepository.save(jobTitle);
	}
	
	//method to search state by id
	//Optional<State> is used so that it will not crash in case no id is found
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	//method to delete state by id
	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
		
	}
	
}
