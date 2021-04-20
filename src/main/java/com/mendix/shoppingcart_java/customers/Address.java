package com.mendix.shoppingcart_java.customers;

public class Address {
	
	private String adressee;
	private String street;
	private int number;
	private String NumberAdd;
	private String zipcode;
	private String country;

	public Address(Customer customer, String street, int number, String zipcode) {
		this(customer, street, number, zipcode, "Netherlands");
	}
	
	public Address(Customer customer, String street, int number, String zipcode, String country) {
		super();
		
		if (customer == null) {
			throw new IllegalArgumentException(customer.getName());
		}
		
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.country = country;
	}
	
	
	public Address(Customer customer) {
		customer.setAddress(this);
	}

	public String getAdressee() {
		return adressee;
	}

	public void setAdressee(String adressee) {
		this.adressee = adressee;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getNumberAdd() {
		return NumberAdd;
	}

	public void setNumberAdd(String numberAdd) {
		NumberAdd = numberAdd;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
