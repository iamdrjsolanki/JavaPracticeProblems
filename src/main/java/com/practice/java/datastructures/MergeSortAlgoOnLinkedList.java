package com.practice.java.datastructures;

import com.practice.java.datastructures.PracticeLinkedList.Node;

/*
 * Merge sort is often preferred for sorting a linked list. 
 * The slow random-access performance of a linked list makes 
	some other algorithms (such as quicksort) perform poorly, 
	and others (such as heapsort) completely impossible. 
*/

public class MergeSortAlgoOnLinkedList {
	
	//MergeAndSortLinkedList mergeSorted;
	
	public MergeSortAlgoOnLinkedList() {
		//this.mergeSorted = new MergeAndSortLinkedList();
	}
	
	Node mergeSort(Node h) {
		if(h == null || h.next == null)
			return h;
		
		Node mid = getMiddle(h);
		Node nextofmid = mid.next;
		
		mid.next = null;
		
		Node left = mergeSort(mid);
		Node right = mergeSort(nextofmid);
		
		Node sortedList = sortedMerge(left, right);
		return sortedList;
	}
	
	public static Node getMiddle(Node head)
    {
        if (head == null)
            return head;
 
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if(a == null)
            return b;
        if(b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if(a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
	
	void printList(Node headref)
    {
        while (headref != null) {
            System.out.print(headref.data + " ");
            headref = headref.next;
        }
    }
	
	public static void main(String args[]) {
		PracticeLinkedList list = new PracticeLinkedList();
		list.add(6); list.add(3); list.add(1); list.add(4); list.add(5); list.add(2);
		System.out.println("Original list: ");
		list.printLinkedList();
		
		MergeSortAlgoOnLinkedList obj = new MergeSortAlgoOnLinkedList();
		Node head = obj.mergeSort(list.head);
		System.out.println("Sorted list: ");
		obj.printList(head);
	}

}
