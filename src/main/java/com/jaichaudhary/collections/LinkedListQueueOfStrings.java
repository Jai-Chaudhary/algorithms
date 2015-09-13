package com.jaichaudhary.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedListQueueOfStrings {

	private class Node {
		String item;
		Node next;
	}

	private Node first = null;
	private Node last = null;
	private int size = 0;

	public void enqueue(String item) {
		 Node oldLast = last;
		 last = new Node();
		 last.item = item;
		 last.next = null;
		 if(isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		 size++;
	}

	public String dequeue() {
		String item = first.item;
		first = first.next;
		size--;
		if(isEmpty()) {
			last = null;
		}
		return item;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		LinkedListQueueOfStrings qos = new LinkedListQueueOfStrings();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("-")) {
				StdOut.println(qos.dequeue());
			} else {
				qos.enqueue(item);
			}
		}
	}
}
