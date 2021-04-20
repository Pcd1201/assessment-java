package com.mendix.shoppingcart_java.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import com.mendix.shoppingcart_java.customers.Customer;
import com.mendix.shoppingcart_java.products.Product;

public class Order {

	private Customer customer;
	public List<OrderLine> orderLines;
	Total total = new Total();
	
	public Order() {
		super();
		
		orderLines = new ArrayList<OrderLine>();
	}

	public Order(Customer customer) {
		super();
		this.customer = customer;
	}
	
	public Order(Product product) {
		add(product, 1);
	}
	
	public Order(Product product, int amount) {
		add(product, amount);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void add(Product product) {
		add(product, 1);
	}

	public void add(Product product, int amount) {
		
		Optional<OrderLine> orderLine = orderLines
			.stream()
			.filter(l -> l.getProduct().getName().equals(product.getName()))
			.findFirst();
		
		if(orderLine.isPresent()) {
			orderLine.get().setAmount(orderLine.get().getAmount() + 1);
			return;
		}
		
		orderLines.add(new OrderLine(this, product, amount));
	}
	
	public void add2(Product product) {
	
		int amount = 1;
		
		Optional<OrderLine> orderLine = orderLines
				.stream()
				.filter(l -> l.getProduct().getName().equals(product.getName()))
				.findFirst();
			
			if(orderLine.isPresent()) {
				orderLine.get().setAmount(orderLine.get().getAmount() + 1);
				return;
			}
			
			orderLines.add(new OrderLine(this, product, amount));
	}
	
	public void remove(Product product) {
		
		orderLines = orderLines
						.stream()
						.filter(l -> !l.getProduct().getName().equals(product.getName()))
						.collect(Collectors.toList());
	}
	
	double TotalPrice() {
		throw new UnsupportedOperationException();
	}
	
	class Total implements Callable<Double> {

		public Double call() throws Exception {
			throw new UnsupportedOperationException();
		}		
	}
}
