package com.dell.simplilearn.phaseone;


public class FirstClass {
	int instanceVar = 10;
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// Java variables name = DELL EMC x0123 Embedded Systems RTOS
		
		int data = 50;
		
		VariablesDemo demo = new VariablesDemo();
		
		System.out.println(demo.instanceVar);
		
		System.out.println(demo.staticVar);
		
		System.out.println(VariablesDemo.staticVar);
		
		/**
		 * Local variable
		 * Instance Variable
		 * Static variable
		 */
	}
	
	public void add() {
		instanceVar = 10;
		
	}
}
