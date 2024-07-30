package com.practice.java.datastructures.stacks;

import java.util.Stack;

public class ImplementQueueIn2Stacks {
  
    static class Queue {
        // Two inbuilt queues 
        static Stack<Integer> q1 = new Stack<>();
        static Stack<Integer> q2 = new Stack<>();
  
        // To maintain current number of 
        // elements 
        static int curr_size; 
  
        Queue()
        { 
            curr_size = 0; 
        } 
  
        static void enqueue(int x)
        { 
            curr_size++;
  
            // move all items from q1 to q2
            while (!q1.isEmpty()) { 
               q2.push(q1.pop());
            }
            // add new element in q1
            q1.push(x);

            // move everything back to q1
            while (!q2.isEmpty()) {
                q1.push(q2.pop());
            }
        }
  
        static int dequeue()
        {
            // if no elements are there in q1 
            if (q1.isEmpty())
                return -1;
            int x = q1.peek();
            q1.pop();
            curr_size--;
            return x;
        }

    } 
  
    // driver code 
    public static void main(String[] args) 
    {
        Queue s = new Queue();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
  
        System.out.println("current size: " + s.curr_size);
        s.dequeue();
        s.dequeue();
  
        System.out.println("current size: " + s.curr_size);
    }
}
