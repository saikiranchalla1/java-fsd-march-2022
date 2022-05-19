package com.dell.simplilearn.phaseone;

public class AccessModifiers {

	// Private
	// Default
	// Protected
	// Public
	
	
	
	public static void main(String[] args) {
		AClass a = new AClass();
		a.msgDefault();
		
		
		a.msgProtected();
	}
	
	
}


class AClass {
	private int data = 40;
	
	void msgDefault() {
		System.out.println("Default msg method");
	}
	
	
	
	private void msg() {
		System.out.println(data);
	}
	
	protected void msgProtected() {
		System.out.println("Protect method");
	}
}

class BClass {
	
}