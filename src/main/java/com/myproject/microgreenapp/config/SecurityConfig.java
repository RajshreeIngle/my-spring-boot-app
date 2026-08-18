package com.myproject.microgreenapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.myproject.microgreenapp.security.CustomerDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration configuration) 
			throws Exception {
		return configuration.getAuthenticationManager();		
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http) throws Exception{
		http.csrf(csrf-> csrf.disable())
			.authorizeHttpRequests(auth-> auth
//					.requestMatchers(
//							"/auth/**",
//		                    "/products",
//		                    "/products/{productId}")
					.anyRequest()
					.permitAll()
//					.authenticated()
					).userDetailsService(customerDetailsService)
			.formLogin(form->form.disable())
			.httpBasic(basic->basic.disable());
			
		return http.build();
	}

}
