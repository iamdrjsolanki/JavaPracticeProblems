package com.practice.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIProblems {

	public static void main(String[] args) {
		
		List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product(1,"HP Laptop",25000));  
        productsList.add(new Product(2,"Dell Laptop",30000));  
        productsList.add(new Product(3,"Lenevo Laptop",28000));  
        productsList.add(new Product(4,"Sony Laptop",28000));  
        productsList.add(new Product(5,"Apple Laptop",90000));
        //productsList.add(new Product(2,"Dell Laptop",30000)); 
        
        List<String> stringList = new ArrayList<String>(10);
        stringList.add("HP Laptop");  
        stringList.add("Dell Laptop");  
        stringList.add("Lenevo Laptop");  
        stringList.add("Sony Laptop");  
        stringList.add("Apple Laptop");
        stringList.add("");
        stringList.add("");
        stringList.add("");
        stringList.add("");
		
        //filter
		System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(x -> x>=2 && x<=5).collect(Collectors.toList()));
		
		//filter with Predicate
		Predicate<Integer> predicate = x -> { return x>=2 && x<=5;};
		System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(x -> predicate.test(x)).collect(Collectors.toList()));
		
		//forEach
		Emp emp = new Emp();
		Stream.of(1, 2, 3, 4).forEach(x -> emp.test(x));
		
		//filtering data and collecting data in list
		System.out.println(productsList.stream().filter(product -> product.price > 30000)
												.map(product -> product.price)
												.collect(Collectors.toList()));
		
		//filtering data and collecting data in list using Method Reference
				System.out.println(productsList.stream().filter(product -> product.price > 30000)
														.map(Product::getPrice)
														.collect(Collectors.toList()));
		
		//forEach on filtered data
		productsList.stream().filter(product -> product.price == 30000)
												.forEach(product -> System.out.println(product.name));
		
		//reduce data to get sum -> first mapped only price to create new stream to pass to reduce function
		System.out.println(productsList.stream().map(product -> product.price)
												.reduce(0, (sum, price) -> sum + price));
		
		//Sum by using Collectors Methods
		System.out.println(productsList.stream().collect(Collectors.summingDouble(product -> product.price)));
		
		//Find Max and Min
		System.out.println(productsList.stream().max((p1, p2) -> p1.price > p2.price ? 1 : -1).get().price);
		System.out.println(productsList.stream().min((p1, p2) -> p1.price > p2.price ? 1 : -1).get().price);
		
		//count() Method in Collection
		System.out.println(productsList.stream().count());
		System.out.println(productsList.stream().filter(product -> product.price > 30000).count());
		
		//convert list to set
		System.out.println(productsList.stream().collect(Collectors.toSet()));
		
		//Convert List into Map -> if the key is same it will throw an error saying duplicate key in map
		System.out.println(productsList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name)));
		//System.out.println(productsList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name, (p.id, p1.id) -> p1.id)));	
		
		//Average of price
		System.out.println(productsList.stream().collect(Collectors.averagingDouble(p -> p.price)));
		
		//Name starts with S & price >=28k
		productsList.stream().filter(product -> product.name.startsWith("S") && product.price >= 28000)
								.map(product -> product.name)
								.forEach(productNames ->  System.out.println((productNames)));
		
		//Sort by Name
		productsList.stream().sorted((p1, p2) -> p1.name.compareTo(p2.name))
								.forEach(p -> System.out.print(p.name + " & " + p.price + ", "));
		System.out.println();
		//Top 3 price desc order
		List<Product> newList = productsList.stream().sorted((p1, p2) -> (int)p1.price - p2.price)
								.limit(3)
								.collect(Collectors.toList());
								
		newList.stream().forEach(p -> System.out.print(p.name + " & " + p.price + ", "));
		System.out.println();
		//less than 3rd highest price desc order
		productsList.stream().sorted((p1, p2) -> (int)p1.price - p2.price)
								.skip(3)
								.forEach(p -> System.out.print(p.name + " & " + p.price + ", "));
		
		System.out.println();
		//remove empty elements from the list
		System.out.println(stringList.stream().filter(x -> x==null).collect(Collectors.toList()).size());
		
		//Grouping
		List<String> words = Arrays.asList("The", "Welcome", "the", "to", "the", "too", "java", "the", "together", "world");
		System.out.println(words.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
		System.out.println(words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		
		//findFirst
		System.out.println(words.stream().filter(x -> x.contains("to")).findFirst().get());
		
		//findAny
		System.out.println(words.stream().filter(x -> x.contains("to")).findAny().get());
		System.out.println(words.stream().parallel().filter(x -> x.contains("to")).findAny().get());
		
	}

}

class Emp {
	void test(int x) {
		System.out.println("from employee test" + x);
	}
}

class Product{  
    int id;  
    String name;  
    int price;  
    public Product(int id, String name, int price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}  
} 
