package com.jaichaudhary.algorithms.collections;


public class LinkedListQueueOfStrings {

	private class Node {
		String item;
		Node next;
		Node prev;
	}

	private Node first = null;
	private Node last = null;
	private int size = 0;

	public void enqueue(String item) {
		 Node oldLast = last;
		 Node last = new Node();
		 last.item = item;
		 last.prev = oldLast;
		 last.next = null;
		 size++;
	}

	public String dequeue() {
		String item = first.item;
		first = first.next;
		size--;
		return item;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	
}
