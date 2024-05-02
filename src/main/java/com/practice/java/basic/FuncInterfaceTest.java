package com.practice.java.basic;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface A1 {
	void a1();
	default int a2() {return 1;}
	static int a3() {return 1;}
}

@FunctionalInterface
interface B1 {
	void a1();
	default int a2() {return 2;}
	static int a3() {return 2;}
}

public class FuncInterfaceTest implements A1, B1 {
	
	@Override
	public void a1() {
		System.out.println("a1");
	}
	
	@Override
	public int a2() {
		// TODO Auto-generated method stub
		return B1.super.a2();
	}

	public static void main(String a[]) {
		FuncInterfaceTest ft = new FuncInterfaceTest();
		ft.a1();
		System.out.println(ft.a2());
		System.out.println(B1.a3());
		
		System.out.println("Predicate..");
		//Predicate, has test() method, takes 1 input(any type) and returns boolean
		Predicate<Integer> lessThan = i -> i < 5;
		System.out.println(lessThan.test(10));
		System.out.println(lessThan.test(4));
		
		System.out.println("Function..");
		//Function, has apply() method, takes 1 input(any type) and returns 1 (any type)
		Function<Integer, Integer> square = i -> i * i;
		System.out.println(square.apply(10));
		System.out.println(square.apply(4));
		
		System.out.println("Consumer..");
		//Consumer, has accept() method, takes 1 input(any type) and returns void
		Consumer<Integer> takeString = s -> System.out.println("Consuming: " + s);
		takeString.accept(10);
		takeString.accept(4);
		
		System.out.println("Supplier..");
		//Consumer, has get() method, takes NO input and returns multiple output (any type)
		Supplier<Double> getRandom = () -> (double) Math.random() * 10;
		System.out.println(getRandom.get());
		System.out.println(getRandom.get());
		
		System.out.println("BiPredicate..");
		//Predicate, has test() method, takes 2 input(any type) and returns boolean
		BiPredicate<Integer, Integer> lessThanBi = (i, j) -> i < j;
		System.out.println(lessThanBi.test(10, 4));
		System.out.println(lessThanBi.test(4, 10));
		
		System.out.println("BiFunction..");
		//Function, has apply() method, takes 2 input(any type) and returns 1 (any type)
		BiFunction<Integer, Integer, Integer> squareBi = (i, j) -> i * j;
		System.out.println(squareBi.apply(10, 4));
		System.out.println(squareBi.apply(4, 10));
		
		System.out.println("BiConsumer..");
		//Consumer, has accept() method, takes 2 input(any type) and returns void
		BiConsumer<String, Integer> takeStringBi = (s, i) -> System.out.println("Consuming string: " + s + " and integer: " + i);
		takeStringBi.accept("abc", 10);
		takeStringBi.accept("xyz", 4);
	}
	
}
