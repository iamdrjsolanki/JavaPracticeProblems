package com.practice.java.datastructures;

import com.practice.datastructures.PracticeLinkedList.Node;

public class MergeAndSortLinkedList {
	
	Node mergeAndSortSortedLinkedList(Node h1, Node h2) {
		Node dummy = new Node(0, null);
		Node tail = dummy;
		while(true) {
			if(h1 == null) {
				tail.next = h2;
				break;
			}
			if(h2 == null) {
				tail.next = h1;
				break;
			}
			
			if(h1.data <= h2.data) {
				tail.next = h1;
				h1 = h1.next;
			} else {
				tail.next = h2;
				h2 = h2.next;
			}
			tail = tail.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		PracticeLinkedList list1 = new PracticeLinkedList();
		list1.add(1); list1.add(3); list1.add(5); list1.add(7);
		System.out.println("Size of list 1:"+list1.size());
		list1.printLinkedList();
		
		PracticeLinkedList list2 = new PracticeLinkedList();
		list2.add(2); list2.add(3); list2.add(4); list2.add(6);
		System.out.println("Size of list 2:"+list2.size());
		list2.printLinkedList();
		
		MergeAndSortLinkedList obj = new MergeAndSortLinkedList();
		Node head = obj.mergeAndSortSortedLinkedList(list1.head, list2.head);
		System.out.println("Merged & Sorted linked list: ");
		list1.printLinkedListWithPointer(head);		
	}

}
