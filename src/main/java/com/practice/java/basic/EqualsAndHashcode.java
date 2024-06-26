package com.practice.java.basic;

public class EqualsAndHashcode {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.setId(1);
		p1.setName("Dhiraj");
		p2.setId(1);
		p2.setName("Dhirajs");
		System.out.println("hashcode:"+p1.hashCode());
		System.out.println("hashcode:"+p2.hashCode());
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p1));
	}
}

class Person {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
		//return 1;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}


