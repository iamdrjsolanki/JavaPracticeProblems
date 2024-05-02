package com.practice.java.basic;

public class TestJavaOOP {

	public static void main(String[] args) {
		ABC obj=null;
		obj.test();
		ABC.test();
		
		DEF def = new DEF();
		System.out.println(def.test());
		System.out.println(def.test("2"));
		System.out.println(def.test(2));
		System.out.println(def.test("2", 2));
		System.out.println(def.test(2, "2"));
	}

}

interface XYZ {
	public void m1();
	
	default void defaultMethod() {
		System.out.println("Default Method in Interface.");
	}
	
	static void staticMethod() {
		System.out.println("Static Method in interface.");
	}
}

class ABC { 
	public static void test() {
		System.out.println("Hello");
	}
}

class DEF { 
	public int test() {
		return 1;
	}
	protected String test(String a) {
		return a;
	}

	/* difference in parameters while overloading is must
	 * public Long test(String a) { return Long.parseLong(a); }
	 */
	Long test(long a) {
		return a;
	}
	/* difference in parameters while overloading is must
	 * public Long test(String a) { return Long.parseLong(a); }
	 */
	//String test(long a) {
	//	return "a";
	//}
	public String test(String a, long b) {
		return a + b;
	}
	public Long test(long a, String b) {
		return a + Long.parseLong(b);
	}
}