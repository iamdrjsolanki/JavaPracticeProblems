package com.practice.java.basic;

public class ExceptionHandling {
	
	public static void main(String a[]) {
		try {
			Employee e = null;
			//compile time error for uninitialized e 
		    if(e.getName().isEmpty()) {
		    	System.out.println("Employee Name");
		    }
		    try {
		    	System.out.println("Inner try");
		    	
		    } finally {
		    	System.out.println("Inner");
		    }
		} 
		catch (Exception e) { 
			System.out.println("Exception e");
		}
		//Compile time if the hierarchy is not proper
//		catch (NullPointerException ne) {
//			System.out.println("Null pointer Exception e");
//		}
		finally {
			System.out.println("Outer");
		}
	}

}

class Employee {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
