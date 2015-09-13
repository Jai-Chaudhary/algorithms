package com.jaichaudhary.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class LinkedListStackOfStrings {

	private class Node {
		String item;
		Node next;
	}

	private Node first = null;
	private int size = 0;


	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}

	public String pop() {
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

	public static void main(String[] args) {
		LinkedListStackOfStrings sos = new LinkedListStackOfStrings();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("-")) {
				StdOut.println(sos.pop());
			} else {
				sos.push(item);
			}
		}

	}

}
