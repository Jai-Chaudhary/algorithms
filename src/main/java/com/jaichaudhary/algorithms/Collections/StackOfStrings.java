package com.jaichaudhary.algorithms.Collections;

import edu.princeton.cs.StdIn;
import edu.princeton.cs.StdOut;

public class StackOfStrings {
	
	private Stirng[] arr;
	private int size;

	public StackOfStrings(int maxSize) {
		arr = new Stirng[maxSize];
		size = 0;
	}

	public void push(String item) {
		arr[size++] = item;
	}

	public String pop() {
		return arr[size--];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		StackOfStrings sos = new StackOfStrings(N);
		while (!StdIn.isEmpty()) {
			int item = StdIn.readString();
			if (item == "-") {
				StdOut.println(sos.pop());
			} else {
				sos.push(item);
			}
		}
	}

}