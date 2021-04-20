package com.mendix.shoppingcart_java.orders;

import java.util.concurrent.Callable;

import com.mendix.shoppingcart_java.products.Product;

public class OrderLine {

	private Product product;
	private int amount;
	Order order;
	public SubTotal subTotal = new SubTotal();
	public Discount discount = new Discount();
	
	public OrderLine(Order order) {
		super();
		this.order = order;
	}

	public OrderLine(Order order, Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
		this.order = order;
	}

	public OrderLine(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public double calculateDiscount(double productPrice, int amount) {
		return productPrice * amount * 100 / (100 -5);
	}
	
	public class SubTotal implements Callable<Double>{

		public Double call() throws Exception {
			return product.getPrice() * amount * (100 / (100-discount.call()));
		}
	}
	
	public class Discount implements Callable<Double>{

		public Double call() throws Exception {
			return amount > 10 ? calculateDiscount(product.getPrice(), amount) : 0;
		}
	}
}


