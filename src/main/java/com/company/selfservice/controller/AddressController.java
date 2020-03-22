package com.company.selfservice.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.selfservice.domain.Address;
import com.company.selfservice.services.AddressService;

@RestController
@RequestMapping(path="/addressservice")
public class AddressController {
	
	private AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	protected AddressController(){}
	
	@RequestMapping(method=RequestMethod.POST, path="/addresses/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Address> updateAddress(@PathVariable("id") Integer id, @RequestBody @Validated Address inputAddress){
		
		System.out.println("Input Address");
		System.out.println(inputAddress);
		inputAddress.setId(id);
		
		
		Address address = this.addressService.updateAddress(inputAddress);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(address.getId()).toUri();

		//return ResponseEntity.created(location).build();
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/addresses/{id}")
	public Optional<Address> getAddress(@PathVariable("id") Integer id){
		return this.addressService.getAddress(id);
	}

}
