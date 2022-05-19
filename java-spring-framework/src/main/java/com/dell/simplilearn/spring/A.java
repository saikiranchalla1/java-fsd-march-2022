package com.dell.simplilearn.spring;

public class A {
	B b;
	
	public A() {
		System.out.println("Hello A!!");
	}
	
	
	public void setB(B b) {
		this.b = b;
	}
	
	void print() {
		System.out.println("Hey there from A");
	}
	
	public void diplay() {
		print();
		b.print();
		
	}
}
