package com.dell.simplilearn.phaseone;

public class SynchronizationDemo {
	public static void main(String[] args) {
		Table obj = new Table();
		
		MyThreadOne t1 = new MyThreadOne(obj);
		MyThreadTwo t2 = new MyThreadTwo(obj);
		
		
//		t1.start();
//		t2.start();
		
//		final String resource1 = "resource one";
//		final String resource2 = "resource two";
//		
//		Thread th1 = new Thread() {
//			public void run() {
//				synchronized (resource1) {
//					System.out.println("Thread 1 : locked resource 1");
//					
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					};
//					
//					synchronized (resource2) {
//						System.out.println("Thread 1: locked resource 2");
//					}
//				}
//			}
//		};
//				
//		
//		Thread th2 = new Thread() {
//			public void run() {
//				synchronized (resource2) {
//					System.out.println("Thread 2: locked resource 2");
//					
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					synchronized (resource1) {
//						System.out.println("Thread 2: locked resource 1");
//					}
//				}
//			}
//		};
//				
//		th1.start();
//		th2.start();
		
//		final Customer c = new Customer();
//		
//		new Thread() {
//			public void run() {
//				c.withdraw(15000);
//			}
//		}.start();
//		
//		
//		new Thread() {
//			public void run() {
//				c.withdraw(10000);
//			}
//		}.start();
//
		
		
		InterruptingThreadDemo interruptingThreadDemo = new InterruptingThreadDemo();
		
		
		interruptingThreadDemo.start();
		
		
		interruptingThreadDemo.interrupt();
	
		InterruptingThreadDemoTwo interruptingThreadDemoTwo = new InterruptingThreadDemoTwo();
		InterruptingThreadDemoTwo interruptingThreadDemoTwo2 = new InterruptingThreadDemoTwo();
		
		interruptingThreadDemoTwo.start();
		interruptingThreadDemoTwo.interrupt();
		
		interruptingThreadDemoTwo2.start();
		
		
	}
}


class Table {
	 void pringTable(int n ) {
		synchronized (this) {
			for (int i = 1; i <=5; i++) {
				System.out.println(n*i);
				
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}


class MyThreadOne extends Thread {
	Table t;
	
	public MyThreadOne(Table t) {
		this.t = t;
	}
	
	
	public void run() {
		t.pringTable(5);
	}
}



class MyThreadTwo extends Thread {
	Table t;
	
	public MyThreadTwo(Table t) {
		this.t = t;
	}
	
	public void run() {
		t.pringTable(100);
	}
}




class Customer {
	int amount = 10000;
	
	
	synchronized void withdraw(int amount) {
		System.out.println("Going to withdraw");
		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit");
			
			try {
				wait();
			} catch (Exception e) {
				
			}
		}
		this.amount -= amount;
		System.out.println("Withdraw completed..");
	}
	
	
	synchronized void deposit(int amount) {
		System.out.println("Going to deposit");
		this.amount += amount;
		System.out.println("Deposit completed...");
		notify();
		
	}
}

class InterruptingThreadDemo extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
//			throw new RuntimeException("Thread interrupted" + e);
			
		}
		
//		if (this.isInterrupted()) {
//			System.out.println("Thread is interrupted...");
//		}
		System.out.println("Thread is running..." + this.isInterrupted());
	}
}

class InterruptingThreadDemoTwo  extends Thread {
	public void run() {
		for (int i = 1; i <=2; i++) {
			if (Thread.interrupted()) {
				System.out.println("Code for interrupted thread");
			} else {
				System.out.println("Code for normal thread");
			}
		}
	}
}















