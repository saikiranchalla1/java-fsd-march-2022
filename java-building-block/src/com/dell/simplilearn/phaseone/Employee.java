package com.dell.simplilearn.phaseone;

public class Employee {
	//fields
	//methods
	//constructors
	// blocks
	// nested classes and interfaces

	int id; //field
	
	String name;
	
	public static void main(String args[]) {
//		Employee e1 = new Employee(1, "Dell"); // newInstace, clone, deserialization
//		System.out.println(e1.id);
//		System.out.println(e1.name);
//		
//		new Employee();
//		
//		Calculator c = new Calculator();
//		
//		c.factorial(10);
//		
//		new Calculator().factorial(1);
//		
//		
//		Calculator c1 = new Calculator(), c2 = new Calculator(), c3 = new Calculator();
//		
		System.out.println(Calculator.model);
		
		Calculator c1 = new Calculator();
		
//		Calculator.factorial(10);
		
	}
	
	public Employee() {
		
	}
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Object is garbage collected");
	}
}


class Calculator {
	{
		// instance block
		System.out.println("Instance block");
	}
	
	static {
		// static block
		System.out.println("Static Block");
	}
	
	static String model = "CASIO 1000";
	
	static void factorial (int n) {
		int fact = 1;
		
		for (int i = 1; i <=n; i++) {
			fact = fact * i;
		}
		
		System.out.println(fact);
	}
}

class A {
	void m() {
		System.out.println("m");
	}
	
	void n() {
		this.m();
	}
	
	int temp;
	
	public A() {
		
	}
	
	public A(int temp) {
		this();
		this.temp = temp;
	}
}

















