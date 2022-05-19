package com.dell.simplilearn.phaseone;

public class ExceptionHandlingDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		try {
			int data = 10/0;
			Thread.sleep(1000);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Division by 0 is illegal.");
			
			throw new InvalidInputException("Invalid input given.");
			
		} catch (InterruptedException e) {
			
		}
		finally {
			System.out.println("Finally closing connection to the database");
		}
		
		System.out.println("Rest of the code...");
	}

}
