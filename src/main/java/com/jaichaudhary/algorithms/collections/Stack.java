package com.jaichaudhary.algorithms.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Stack<Item> {

	private Item[] arr = (Item[]) new Object[1];
	private int size = 0;

	public void push(Item item) {
		if( size == arr.length) {
			resize(2 * size);
		}
			arr[size++] = item;
	}

	public Item pop() throws IndexOutOfBoundsException{
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else if (size <=  arr.length / 4) {
			resize( size / 2);
		}
		Item item = arr[--size];
		arr[size] = null;
		return item;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void resize(int capacity) {
		Item[] newArr = (Item[]) new Object[capacity];
		for (int i = 0; i < size ; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public static void main(String[] args) {
		Stack sos = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("-")) {
				StdOut.println(sos.pop());
			} else {
				sos.push(item);
			}
		}
	}

}