package com.eazybytes.springsecsection4_8.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybytes.springsecsection4_8.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	/**
	 * Derived method name query
	 * -- query is generated at runtime using the method name which is derived based on fields of entity class.
	 */
	List<Customer> findByEmail(String email);
}
