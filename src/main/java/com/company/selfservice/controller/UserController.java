package com.company.selfservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.selfservice.domain.Customer;
import com.company.selfservice.domain.User;
import com.company.selfservice.repo.UserRepository;

@RestController
@RequestMapping(path="/userservice")
public class UserController {
	
	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> validateUserCredential(@RequestBody User user){
		User existingUser = this.userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd()); 
		if(null != existingUser && null != existingUser.getId()){
			Customer customer = existingUser.getCustomer();
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		else
			return new ResponseEntity<User>(existingUser, HttpStatus.NOT_FOUND);
	}

}
