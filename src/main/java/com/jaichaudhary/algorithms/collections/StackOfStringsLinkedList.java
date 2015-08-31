package com.jaichaudhary.algorithms.collections;


public class StackOfStringsLinkedList {

	private class Node {
		String item;
		Node next;
	}

	private Node first;

	public StackOfStringsLinkedList() {
		Node first = null;
	}

	public void push(String input) {
		Node oldFirst = first;
		first = new Node();
		first.item = input;
		first.next = oldFirst;
	}

	public String pop() {

	}

	public boolean isEmpty() {

	}

	public int size() {

	}

}
