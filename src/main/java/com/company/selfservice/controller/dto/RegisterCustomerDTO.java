package com.company.selfservice.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.company.selfservice.domain.Address;

public class RegisterCustomerDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fName;
	
	private String lName;
	
	private String email;
	
	Set<Address> addresses = new LinkedHashSet<Address>();
	
	private String pwd;
	
	public RegisterCustomerDTO(){}
	
	public RegisterCustomerDTO(String fName, String lName, String email, Set<Address> addresses,
			String pwd) {
		this.pwd = pwd;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.addresses = addresses;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterCustomerDTO [fName=").append(fName).append(", lName=").append(lName).append(", email=")
				.append(email).append(", addresses=").append(addresses).append(", pwd=").append(pwd).append("]");
		return builder.toString();
	}
}
