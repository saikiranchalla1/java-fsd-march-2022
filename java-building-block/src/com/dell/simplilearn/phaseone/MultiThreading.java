package com.dell.simplilearn.phaseone;

import java.io.IOException;

public class MultiThreading {
	public static void main(String[] args) throws IOException {
//		MyThread m1 = new MyThread();
//		
//		Thread t1 = new  Thread(m1);
//		
//		t1.start();
//		
//		
//		
//		MyThread2 m2 = new MyThread2();
//		
//		m2.start();
//		
//		
//		Thread t2 = new Thread("My first thread");
//		t2.start();
//		
//		System.out.println(t2.getName());
//		
//		Runnable r1 = new MyThread();
//		
//		Thread t3 = new Thread(r1, "My New thread");
//		t3.start();
//		t3.start();
		
		
		TestCallRun tr1 = new TestCallRun();
		TestCallRun tr2 = new TestCallRun();
		
//		tr1.run();
//		tr2.run();
		
		tr1.start();
		tr2.start();
		
		ThreadPriorityExample tp1 = new ThreadPriorityExample();
		ThreadPriorityExample tp2 = new ThreadPriorityExample();
		ThreadPriorityExample tp3 = new ThreadPriorityExample();
		
		System.out.println("Thread 1 priority: " + tp1.getPriority());
		System.out.println("Thread 2 priority: " + tp2.getPriority());
		System.out.println("Thread 3 priority: " + tp3.getPriority());
		
		tp1.setPriority(6);
		
		tp2.setPriority(9);
		
		tp3.setPriority(3);
		
		System.out.println("Thread 1 priority: " + tp1.getPriority());
		System.out.println("Thread 2 priority: " + tp2.getPriority());
		System.out.println("Thread 3 priority: " + tp3.getPriority());
		
		
		System.out.println("Current thread:" + Thread.currentThread().getName());
		System.out.println("Current thread priority: " + Thread.currentThread().getPriority());
		
		
		TestDaemonThread td1 = new TestDaemonThread();
		TestDaemonThread td2 = new TestDaemonThread();
		
		td1.setDaemon(true);
		
		td1.start();
		
		td2.start();
		
		Runtime r = Runtime.getRuntime();
		
		// r.addShutdownHook(new ShutDownThread());
		
		
		r.addShutdownHook(new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Shut down hook called");
			}
		});
		
		System.out.println("Now main sleeping...press ctrl + c to exit");
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Employee e = new Employee();
		e = null;
		
		Employee e1 = new Employee();
		e1 = e;
		
		new Employee();
		
		
		
		System.gc();
		
		
		// Runtime.getRuntime().exec("shudown");
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		
	}
}

class MyThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			System.out.println("Thread is running");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}


class MyThread2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread is running");
	}
	
}

class TestCallRun extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(i);
		}
	}
}


class ThreadPriorityExample extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inside the run() method");
	}
}

class TestDaemonThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (Thread.currentThread().isDaemon()) {
			System.out.println("Daemon thread");
		} else {
			System.out.println("User thread");
		}
	}
}

class ShutDownThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Shut down hook task completed");
	}
}



