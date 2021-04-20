package com.mendix.shoppingcart_java.customers;

public enum Gender {
    None(0),
    Male(1),
    Female(2);

    private int value;
    Gender(int i) {
    		value = i;
    }
    
    public int getValue() {
    		return value;
    }
}
