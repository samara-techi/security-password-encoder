package com.eazybytes.springsecsection4_8.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	/**
	 * Here we provide authentication for few resources
	 * By default spring security enables CSRF tokens. 
	 * Let's disable the CSRF tokens for now. We'll discuss more about CSRF in detail
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() //Disabling the csrf tokens
			.authorizeHttpRequests()
			.antMatchers("/v1/api/notice/", "/v1/api/contact/", "/v1/api/login/register").permitAll()
			.anyRequest().authenticated();
		http.formLogin(); //User login through form
		http.httpBasic(); //User credentials in json format
		return http.build();
	}
	
	/**
	 * For JDBC authentication
	 * security checks the user credentials in the database using spring jdbc
	 * 
	 * But commented because we have our custom UserDetailsService class.
	 */
//	@Bean
//	UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	/**
	 * Since we have to use BCryptPasswordEncoder, we are commenting below function
	 */
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
