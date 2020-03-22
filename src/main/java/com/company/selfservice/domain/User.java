package com.company.selfservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "User.findByEmailAndPwd",
query = "select u from User u where u.email = ?1 and u.pwd = ?2")
public class User implements Serializable {

	private static final long serialVersionUID = 1776247368275543818L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String pwd;
	
	@Column
	private String email;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	protected User(){}

	public User(String pwd, String email, Customer customer) {
		this.pwd = pwd;
		this.email = email;
		this.customer = customer;
	}
	
	public User(String pwd, String email) {
		this.pwd = pwd;
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", pwd=");
		builder.append(pwd);
		builder.append(", email=");
		builder.append(email);
		return builder.toString();
	}

}
