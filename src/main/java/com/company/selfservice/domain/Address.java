package com.company.selfservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable{

	private static final long serialVersionUID = -5006559315589806994L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String line1;
	
	@Column
	private String line2;
	
	@Column
	private String county;
	
	@Column
	private String country;
	
	@Column
	private String postcode;
	
	public Address() {}

	public Address(String line1, String line2, String county, String country, String postcode) {
		this.line1 = line1;
		this.line2 = line2;
		this.county = county;
		this.country = country;
		this.postcode = postcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", line1=");
		builder.append(line1);
		builder.append(", line2=");
		builder.append(line2);
		builder.append(", county=");
		builder.append(county);
		builder.append(", country=");
		builder.append(country);
		builder.append(", postcode=");
		builder.append(postcode);
		builder.append("]");
		return builder.toString();
	}

}
