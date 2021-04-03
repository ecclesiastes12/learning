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
import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {

	
	
	@Autowired
	private JobTitleService jobTitleService;
	
	
	//method that displays jobTitle page
	@GetMapping("/jobTitles")
	public String getJobTitles(Model model) {
		
		// for list of jobTitles
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitleList);
		
		return "JobTitle";
	}
	
	//method that process new data . for submit button
	@PostMapping("/jobTitles/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle); //method call from JobTitleService class
		return "redirect:/jobTitles"; //redirect to jobTitles page
		
	}
	
	//method that display searched data in the modal
	@RequestMapping("jobTitles/findById")
	@ResponseBody  //optional. for display the search result in a json format
	public Optional<JobTitle> findById(int id) {
		return jobTitleService.findById(id);
	}
	
	//NB RequestMethod.PUT, RequestMethod.GET is used because to upate a record you first have 
	//to fetch record and update it
	//method to update the jobTitle
	@RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}
	
	//method for delete button
	@RequestMapping(value = "/jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitles";
	}
	
}
