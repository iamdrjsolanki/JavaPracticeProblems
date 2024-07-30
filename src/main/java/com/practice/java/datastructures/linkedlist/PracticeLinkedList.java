package com.practice.java.datastructures.linkedlist;

/**
 * Following operations are done on the linkedlist created class
 * addAtFront(10);
 * addAtAPosition(11, 2);
 * remove(1);
 * removeAtAPosition(2);
 * reverse(list.head);
 */

public class PracticeLinkedList {
	
	Node head;
	Node tail;
	Node current;
	
	static class Node{
		int data;
		Node next;
		Node(int d, Node n) {
			this.data = d; this.next = n;
		}
	}
	
	void add(int ele) {
		Node node = new Node(ele, null);
		if(size() == 0) {
			this.head = node;
		} else {
			this.current.next = node;
		}
		this.current = node;
		this.tail = node;
	}
	
	void addAtFront(int ele) {
		Node n = null;
		if(head != null) {
			n = new Node(ele, this.head);
			this.head = n;
		} else {
			n = new Node(ele, null);
			this.head = n;
			this.current = n;
			this.tail = n;
		}
	}
	
	void addAtAPosition(int ele, int pos) {
		if(size() < pos || pos == 0)
			System.out.println("Position value out of bound. The size of the linked list is: "+ size());
		else if(pos == 1)
			addAtFront(ele);
		else {
			int count = 1;
			Node node = new Node(ele, null);
			Node c = this.head;
			Node p = null;
			while(count != pos) {
				p = c;
				c = c.next;
				count++;
			}
			p.next = node;
			node.next = c;
		}
	}
	
	void remove(int ele) {
		Node c = this.head;
		Node p = null;
		while(c != null) {
			if(c.data == ele) {
				p.next = c.next;
			}
			p = c;
			c = c.next;
		}
	}
	
	void removeAtAPosition(int pos) {
		if(size() < pos || pos == 0)
			System.out.println("Position value out of bound. The size of the linked list is: "+ size());
		else {
			int count = 1;
			Node c = this.head;
			Node p = null;
			while(count != pos) {
				p = c;
				c = c.next;
				count++;
			}
			p.next = c.next;
		}
	}
	
	void swap(int ele1, int ele2) {
		if(ele1 == ele2)
			return;
		if(head == null)
			return;
			
		Node c1 = this.head, c2 = this.head;
		Node p1 = null, p2 = null;
		
		while(c1 != null && c1.data != ele1) {
			p1 = c1;
			c1 = c1.next;
		}
		
		while(c2 != null && c2.data != ele2) {
			p2 = c2;
			c2 = c2.next;
		}
		
		if(c1 != null && c2 != null) {
			if(p1 != null)
				p1.next = c2;
			else
				head = c2;
			
			if(p2 != null)
				p2.next = c1;
			else
				head = c1;
			
			Node temp = c1.next;
			c1.next = c2.next;
			p2.next = temp;
		}
	}
	
	Node reverse(Node node) {
		Node p = null, c = node, next = null;
		while(c != null) {
			next = c.next;
			c.next = p;
			p = c;
			c = next;
		}
		node = p;
		return node;
	}
	
	public int size() {
		int count = 0;
		Node n = this.head;
		while(n != null) {
			n = n.next;
			count++;
		}
		return count;
	}
	
	void printLinkedList() {
		Node n = this.head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	void printLinkedListWithPointer(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

	public static void main(String[] args) {
		PracticeLinkedList list = new PracticeLinkedList();
		
		list.add(1); list.add(2); list.add(3); list.add(4); list.add(1);
		System.out.println("Size:"+list.size());
		list.printLinkedList();
		
		list.addAtFront(10);
		System.out.println("Size:"+list.size());
		list.printLinkedList();

		list.addAtAPosition(11, 2);
		System.out.println("Size:"+list.size());
		list.printLinkedList();

		list.remove(1);
		System.out.println("Size:"+list.size());
		list.printLinkedList();

		list.removeAtAPosition(2);
		System.out.println("Size:"+list.size());
		list.printLinkedList();
		
		System.out.println("Size: "+list.size());
		Node head = list.reverse(list.head);
		list.printLinkedListWithPointer(head);
	}

}
