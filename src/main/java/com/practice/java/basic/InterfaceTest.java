package com.practice.java.basic;

interface A {
	void m();
	default void defaultMethod() {
		System.out.println("Default Method in Interface.");
	}
	
	static void staticMethod() {
		System.out.println("Static Method in interface.");
	}
}

interface B {
	void m();
}

interface C {
	void m();
}

public class InterfaceTest implements A, B, C {
	
	public void m() {
		System.out.println("Hi");
	}
	
	/* Cannot override static method of Interface
	 * @Override static void staticMethod() {
	 * System.out.println("Static method trying to override."); }
	 */
	
	public static void main(String a[]) {
		InterfaceTest it = new InterfaceTest();
		it.m();
		//InterfaceTest.staticMethod();
	}
}

