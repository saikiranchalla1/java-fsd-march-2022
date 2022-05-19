package com.dell.simplilearn.phaseone;

public class Inheritance {
	public static void main(String[] args) {
		DatabaseEngineer de1 = new DatabaseEngineer();
		
		de1.attendAMeeting();
		
		
		
		final String name = "dumy";
		
		
	}
}

class ITEmployee {
	void attendAMeeting() {
		System.out.println("Attending a meeting");
	}
}

class Engineer extends ITEmployee {
	float salary = 50000;
	
	void attendAMeeting() {
		System.out.println("Engineer is attending a meeting!");
	}
}

class DatabaseEngineer extends Engineer {
//	float salary = 50000;
	
	
}

class Animal {
	String color = "White";
	
	void eat() {
		System.out.println("eating....");
	}
	
	public Animal(String color) {
		this.color = color;
	}
}


class Dog extends Animal {
	
	public Dog(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}



	String color = "Black";
	
	
	
	void printColor() {
		System.out.println(color);
		
		System.out.println(super.color);
		
		super.eat();
	}
}


//class A {
//	void msg() {
//		System.out.println("Hello!");
//	}
//	
//	
//}
//
//
//class B {
//	void msg() {
//		System.out.println("Welcome!");
//	}
//}

//class C extends A,B {
//	C obj = new C();
//	obj.msg();
//}

class Adder {
	static int add(int a, int b) {
		return a + b;
	}
	
	static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	static double add(double a, double b) {
		return a + b;
	}
}