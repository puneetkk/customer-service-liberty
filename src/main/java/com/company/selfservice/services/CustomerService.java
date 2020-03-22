package com.company.selfservice.services;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selfservice.domain.Address;
import com.company.selfservice.domain.Customer;
import com.company.selfservice.domain.User;
import com.company.selfservice.repo.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer createCustomer(String fName, String lName, String email, String line1, String line2,
			String county, String country, String postcode, String pwd){
		Set<Address> addresses = new LinkedHashSet<Address>();
		addresses.add(new Address(line1, line2, county, country, postcode));
		
		User user = new User(pwd, email, null);
		
		return this.customerRepository.save(new Customer(fName, lName, addresses, user));
		
	}
	
	public Iterable<Customer> getCustomers(){
		return this.customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomer(Integer id){
		return this.customerRepository.findById(id);
	}
	
	public Customer createCustomer(Customer customer){
		return this.customerRepository.save(customer);
	}
}
