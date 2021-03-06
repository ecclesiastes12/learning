package com.kindsonthegenius.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.User;
import com.kindsonthegenius.fleetapp.models.UserPrincipal;
import com.kindsonthegenius.fleetapp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository  userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		//checks if user  exist
		if(user == null) { // throws exception if user not found
			throw new UsernameNotFoundException("User not found!");
		}
 
		return new UserPrincipal(user);
	}

}
