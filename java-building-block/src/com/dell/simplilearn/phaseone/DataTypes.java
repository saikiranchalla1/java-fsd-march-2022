package com.dell.simplilearn.phaseone;

public class DataTypes {
	
	
	public static void main(String[] args) {
		/**
		 * 1. Primitive data types
		 * 2. Non-primitive data types
		 * 
		 */
		
		// Primitive data types
		boolean bool = true; //false <- Boolean
		
		
		// 1
		
		byte a = 1;
		
		short s = 10000;
		
		int anInt = 10000;
		
		long aLong = 10000L;
		
		float aFloat = 3.14f;
		double aDouble = 3.14;
		
		char aChar = 'a';
		
		
		String aString = "Hello world!";
		
		// Non primitive data types - Classes, interfaces, arrays

		// Casting - Typecasting
		/**
		 * Narrowing vs Widening
		 */
		
		int anotherInt = 10;
		float f = anotherInt;
		
		System.out.println(anotherInt + " vs " + f); // widening
		
		
		f = 10.5f;
		anotherInt = (int) f;
		
		
		System.out.println(anotherInt + " vs " + f); // narrowing
		
		int x = -130;
		byte b = (byte) x;
		
		System.out.println(b); // overflow
		
		// To reverse a number 123 -> 321, 4321 -> 1234 // algorithm
		
		
		/**
		 * 123
		 * 123%10 = 3, 123/10 = 12
		 * 3 * 10 + (12 % 10) 30 + 2 = 32, 12/10 = 1
		 * 
		 * 32 * 10 + 1%10 = 320 + 1 = 321, 1/10 = 0 
		 */
		
		
	}
}
