package com.cedrata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	private String alpha2code;
	private String capital;
	private String name;
	private String region;
	
	@Transient //proprietà non del db
	private String flag;
	
	
	public String getAlpha2code() {
		return alpha2code;
	}
	public void setAlpha2code(String alpha2Code) {
		this.alpha2code = alpha2Code;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getFlag() {
		
		return "./flags/" + this.alpha2code.toLowerCase() + ".png";
		
	}
	
}
