package com.practice.java.designpatterns;

public class SingletonPattern {
	
	//Eager Loading
	private static SingletonPattern obj = new SingletonPattern();
	public static SingletonPattern getObjInstance() {
		return obj;
	}
	
	//Lazy loading
	static SingletonPattern object = null;
	public static SingletonPattern getObjectInstance() {
		if(object != null)
			return object;
		object = new SingletonPattern();
		return object;
	}
	
	//private constructor is must to prevent explicit creation of object
	private SingletonPattern() {}

	public static void main(String[] args) {
		System.out.println("Object hashcode: " + SingletonPattern.getObjectInstance().hashCode());
		System.out.println("Object hashcode: " + SingletonPattern.getObjectInstance().hashCode());
		System.out.println("Obj hashcode: " + SingletonPattern.getObjInstance().hashCode());
		System.out.println("Obj hashcode: " + SingletonPattern.getObjInstance().hashCode());
	}

}
