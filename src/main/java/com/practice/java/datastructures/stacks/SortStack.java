package com.practice.java.datastructures.stacks;

import java.util.Stack;

public class SortStack {

    /**
     * Looping through the stack is not allowed.
     * You need to return a stack that is sorted in descending order.
     *
     * Given stack S = 1 3 2
     * The output will be 3 2 1 since it is the sorted order.
     */

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2); stack.push(1); stack.push(-12); stack.push(-3); stack.push(0);
        sortTheStack(stack);
        stack.forEach(System.out::println);
    }

    public static void sortTheStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int x = stack.pop();
            sortTheStack(stack);
            sortedInsert(stack, x);
        }
    }

    public static void sortedInsert(Stack<Integer> stack, int x) {
        if(stack.isEmpty() || stack.peek() > x) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        sortedInsert(stack, x);
        stack.push(temp);
    }

}
