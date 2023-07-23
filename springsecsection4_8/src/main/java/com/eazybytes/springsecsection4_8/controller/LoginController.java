package com.eazybytes.springsecsection4_8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.springsecsection4_8.model.Customer;
import com.eazybytes.springsecsection4_8.repository.CustomerRepository;

@RestController
@RequestMapping("/v1/api/login")
public class LoginController {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		Customer dbCustomer = null;
		ResponseEntity<String> response = null;
		try {
			//Password is encoded using BcryptPasswordEncoder.
			String hashPassword = passwordEncoder.encode(customer.getPassword());
			customer.setPassword(hashPassword);
			dbCustomer = customerRepository.save(customer);
			
			if(dbCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED)
							.body("Given user details are successfully registered");
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to " + e.getMessage());
		}
		
		return response;
	}

}
