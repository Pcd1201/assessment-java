package com.mendix.shoppingcart_java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.mendix.shoppingcart_java.customers.Address;
import com.mendix.shoppingcart_java.customers.Customer;
import com.mendix.shoppingcart_java.customers.Gender;
import com.mendix.shoppingcart_java.orders.Order;
import com.mendix.shoppingcart_java.products.Product;
import com.mendix.shoppingcart_java.orders.OrderLine;


public class OrderTest{
	
	Customer customer;
	Address address;
	Product product;
	
	
	public OrderTest(){
      
       customer = new Customer("FirstName", "LastName", Gender.Female);
       address = new Address(customer, "street", 0, "1234");
       product = new Product("Product 1", 1, 10.0);
    }

	@Before
	public void customerCanPlaceOneItemInShoopingCart() {
    	
    		Order order = new Order();
    		order.add(product, 1);
    		order.setCustomer(customer);
    		
    		int size = order.orderLines.size();
    		System.out.println("Size of cart: "+size);
    		
    		assertEquals(1, order.orderLines.size());
    }
 
  @Test
    public void It_should_create_an_order_for_customer()
    {
        Order order = new Order(customer);

        assertEquals(customer, order.getCustomer());
    }
	        
    @Test
	public void It_should_have_multiple_items_in_shopping_cart() {
    		
    	Order order = new Order();
        //order.add2(product);
        order.add(product, 2);
        order.setCustomer(customer);

        assertEquals(2, order.orderLines.size());
    }    
    
  /*  @Test
    public void It_should_create_an_order_for_customer()
    {
        Order order = new Order(customer);

        assertEquals(customer, order.getCustomer());
    }*/
            
    @Test
    public void It_should_update_the_amount_of_a_product_in_cart()
    {    	
        Order order = new Order(product);
        order.add(product, 5);
        order.setCustomer(customer);

        assertEquals(6, order.orderLines.stream().filter(line -> line.getProduct() == product).findFirst().get().getAmount());
    }
    
    @Test
    public void It_should_create_an_order_from_a_product()
    {
        Order order = new Order(product, 3);

        assertEquals(3, order.orderLines.get(0).getAmount());
    }
    
    @Test        
	public void It_should_have_an_order_bound_to_a_customer()
	{
	    Order order = new Order();
	    order.add(product);
	    
	    assertNotNull(customer);
	}
            
    @Test(expected = IndexOutOfBoundsException.class)
	public void It_should_fail_after()
    {
        Order order = new Order();
        order.add(product);
        order.remove(product);

        assertEquals(0, order.orderLines.size());
    }

    @Test
    public void It_should_apply_discount_when_order_total_greater_than_20_euros() throws Exception 
    {
        // implement me    	
    	
    	//Create object of order class
    	Order order = new Order();
    	OrderLine orderline = new OrderLine(order);
    	
    	Product product = orderline.getProduct();
    	int amount = orderline.getAmount();
    	
    	double productprice = product.getPrice();
    	    	
    	double total = orderline.subTotal.call();
    	
    	if(total > 20)
    	{
    		double discount = orderline.calculateDiscount(productprice, amount);
    		
    		double idiscount = orderline.discount.call();
    		
    		System.out.println("Discount applied is: "+discount);
    		System.out.println("Discount applied is: "+idiscount);
    	} 
    }

}
