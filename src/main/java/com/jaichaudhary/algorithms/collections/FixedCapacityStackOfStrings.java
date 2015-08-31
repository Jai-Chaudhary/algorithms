package com.jaichaudhary.algorithms.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

	private String[] arr;
	private int size;

	public FixedCapacityStackOfStrings(int maxSize) {
		arr = new String[maxSize];
		size = 0;
	}

	public void push(String item) {
		arr[size++] = item;
	}

	public String pop() throws IndexOutOfBoundsException{
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		String item = arr[--size];
		arr[size] = null;
		return item;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		FixedCapacityStackOfStrings sos = new FixedCapacityStackOfStrings(N);
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