package com.practice.java.basic;

class GrandParent {
	void print() {
		System.out.println("GrandParent");
	}
	void gpm1() {
		System.out.println("GrandParent m1()");
	}
}

class Parent extends GrandParent {
	void print() {
		System.out.println("Parent");
	}
	void pm1() {
		System.out.println("Parent m1()");
	}
	static void staticM1() {
		System.out.println("Static method in Parent");
	}
}

class Child extends Parent {
	void print() {
		System.out.println("Child");
	}
	
	static void staticM1() {
		System.out.println("Static method in Child");
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		GrandParent grandParent = new Parent();
		Parent parent = new Parent();
		Parent p = new Child();
		Child c = new Child();
		
		grandParent.print();
		parent.print();
		c.print(); c.pm1(); c.gpm1();
		p.print();
		
		//Even though p has a object of Child class, 
		//and child class has method staticM1(), 
		//it invokes the parent static method, 
		//this is method hiding
		p.staticM1(); 
		c.staticM1();
	}

}
