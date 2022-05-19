package com.dell.simplilearn.phasetwo;

public class DIDemo {
	public static void main(String[] args) {
		// A obj = new A(); new AImpl();
		// A obj = A.getA();
		
		
	}
	
	
	
}



class Employee {
	Address address;
	
	// constructor
	public Employee(Address address) {
		this.address = address;
	}
	
	
	//setter DI
	public void setAddress(Address address) {
		this.address = address;
	}
}

class Address {
	
}