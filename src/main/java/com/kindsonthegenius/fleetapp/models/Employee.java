package com.kindsonthegenius.fleetapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person{

	@ManyToOne
	@JoinColumn(name = "employeetypeid", insertable = false, updatable = false)
	EmployeeType employeeType;
	Integer employeetypeid;
	String photo;
	
	@ManyToOne
	@JoinColumn(name = "jobtitleid", insertable = false, updatable = false)
	JobTitle jobTitle;
	Integer jobtitleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	
}
