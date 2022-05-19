package com.dell.simplilearn.phaseone.demo;

import com.dell.simplilearn.phaseone.DummyClass;

public class AccessModifiersDemo {
	public static void main(String[] args) {
		DummyClass dc = new DummyClass();
		
		
	}
}

class SubClass extends DummyClass {
	void msg() {
		super.msgProtected();
	}
}
// multiprocessing
// multithreading


// New -> Runnable/Running -> Waiting, Blocked, Timed waiting -> Terminated