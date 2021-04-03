package com.kindsonthegenius.fleetapp.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String firstname;
	String lastname;
	String othername;
	String title;
	String initials;
	String socialSecurityNumber;
	String gender;
	String maritalStatus;
	
	@ManyToOne
	@JoinColumn(name = "countryid",insertable = false, updatable = false)
	Country country;
	Integer countryid;
	
	@ManyToOne
	@JoinColumn(name = "stateid", insertable = false, updatable = false)
	State state;
	Integer stateid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dateOfBirth;
	String city;
	String address;
	String phone;
	String mobile;
	String email;
	String photo;
	
}
