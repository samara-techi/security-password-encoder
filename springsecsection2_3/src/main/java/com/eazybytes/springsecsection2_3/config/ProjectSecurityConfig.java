package com.eazybytes.springsecsection2_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	/**
	 * Step : 1
	 * Here every resource is protected and must be authenticated
	 * 
	 */
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().anyRequest().authenticated();
//		http.formLogin();
//		http.httpBasic();
//		return http.build();
//	}
	
	/**
	 * Step : 2
	 * Here we provide authentication for few resources
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/v1/api/notice/", "/v1/api/contact/").permitAll()
			.anyRequest().authenticated();
		http.formLogin(); //User login through form
		http.httpBasic(); //User credentials in json format
		return http.build();
	}
	
	/**
	 * Step : 3
	 * Here we are denying every request. Shows access denied. 403
	 * In this case it asks for authentication for every resource. Even after successful
	 * authentication, it shows access denied page
	 * 
	 */
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests()
//			.anyRequest().denyAll();
//		http.formLogin();
//		http.httpBasic();
//		return http.build();
//	}
	
	/**
	 * Step : 4
	 * Here any request is permitted with no authentication.
	 * Now all your apis are exposed without any security
	 * 
	 */
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests()
//			.anyRequest().permitAll();
//		http.formLogin();
//		http.httpBasic();
//		return http.build();
//	}
	
}
