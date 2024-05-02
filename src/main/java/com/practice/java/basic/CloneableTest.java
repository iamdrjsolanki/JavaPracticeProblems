package com.practice.java.basic;

public class CloneableTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		DoClone dc = new DoClone();
		System.out.println(dc.hashCode());
		System.out.println(dc.clone().hashCode());
		

		DoClone dc1 = (DoClone) dc.clone();
		System.out.println(dc.inner.hashCode());
		System.out.println(dc1.inner.hashCode());
		System.out.println(dc.inner1.hashCode());
		System.out.println(dc1.inner1.hashCode());
	}

}

class DoClone implements Cloneable {
	public int a = 5;
	public InnerClone inner = new InnerClone();
	public InnerClone1 inner1 = new InnerClone1();
	
	protected Object clone() throws CloneNotSupportedException {
		DoClone dc = (DoClone) super.clone();
		dc.inner1 = (InnerClone1) this.inner1.clone();
		return dc;
	}
	
}

class InnerClone {
	public int a = 10;
}

class InnerClone1 implements Cloneable {
	public int a = 10;
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

