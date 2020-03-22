package com.company.selfservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.company.selfservice.services.AddressService;
import com.company.selfservice.services.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//customerService.createCustomer("Puneet", "Kankane", "pk@gmail.com", "Number 1", "Queensbury Mansion", "Bournemouth", "UK", "BH12QA", "pwd");
		//addressService.createAddress("Number 1", "Queensbury Mansion", "Bournemouth", "UK", "BH12QA");
		//addressService.createAddress("Number 2", "Some Apartment", "Bournemouth", "UK", "BH12AB");
		System.out.println(customerService.createCustomer("Puneet", "Kankane", "pk@gmail.com", "Number 1", "Queensbury Mansion", "Bournemouth", "UK", "BH12QA", "pwd"));
	}

	@Bean
	public CorsFilter corsFilter() {

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true); 
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
}
