package com.jaichaudhary.algorithms.collections;


public class StackOfStringsLinkedList {

	private class Node {
		String item;
		Node next;
	}

	private Node first;
	private int size;

	public StackOfStringsLinkedList() {
		first = null;
		size = 0;
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
		return size == 0;
	}

	public int size() {

	}

}
