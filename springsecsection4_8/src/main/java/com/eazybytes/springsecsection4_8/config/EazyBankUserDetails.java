package com.eazybytes.springsecsection4_8.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.eazybytes.springsecsection4_8.model.Customer;
import com.eazybytes.springsecsection4_8.repository.CustomerRepository;

/**
 * Spring security handovers the authentication to the DaoAuthenticationProvider
 * And DaoAuthenticationProvider looks for the implementation classes for UserDetailsService
 * But DaoAuthenticationProvider finds the two beans of type UserDetailsService
 * 1. EazyBankUserDetails
 * 2. JdbcUserDetailsManager
 *
 */
@Service
public class EazyBankUserDetails implements UserDetailsService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password = null;
		List<GrantedAuthority> authorities = null;
		List<Customer> customers = customerRepository.findByEmail(username);
		if(CollectionUtils.isEmpty(customers)) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		} else {
			userName = customers.get(0).getEmail();
			password = customers.get(0).getPassword();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
		}
		return new User(username, password, authorities);
	}

}
