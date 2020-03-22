package com.company.selfservice.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.selfservice.controller.dto.RegisterCustomerDTO;
import com.company.selfservice.domain.Address;
import com.company.selfservice.domain.Customer;
import com.company.selfservice.domain.User;
import com.company.selfservice.services.CustomerService;

@RestController
@RequestMapping(path="/customerservice")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	protected CustomerController(){}
	
	@RequestMapping(method=RequestMethod.POST, path="/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createCustomer(@RequestBody Customer inputCustomer){
		
		System.out.println("Input Customer");
		System.out.println(inputCustomer);
		Customer customer = this.customerService.createCustomer(inputCustomer);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(customer.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> registerCustomer(@RequestBody RegisterCustomerDTO registerCustomerObj){
		
		System.out.println("Input Customer");
		System.out.println(registerCustomerObj);
		User user = new User(registerCustomerObj.getPwd(), registerCustomerObj.getEmail());
		Customer inputCustomer = new Customer(registerCustomerObj.getfName(), registerCustomerObj.getlName(), 
				registerCustomerObj.getAddresses(), user);
		Customer customer = this.customerService.createCustomer(inputCustomer);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(customer.getId()).toUri();

		//return ResponseEntity.created(location).build();
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/customers")
	public Iterable<Customer> getCustomers(){
		return this.customerService.getCustomers();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/customers/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") Integer id){
		return this.customerService.getCustomer(id);
	}
}
