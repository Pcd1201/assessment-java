package com.mendix.shoppingcart_java.customers;

public class Customer {
	
	private String name;
	private String surname;
	Gender gender;
	public Address address;
	
	public Customer(String name, String surname, Gender gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Gender getGender() {
		return gender;
	}
	public Address getAddress() {
		return address;
	}

}
