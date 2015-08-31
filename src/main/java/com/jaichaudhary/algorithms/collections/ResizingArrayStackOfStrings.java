package com.jaichaudhary.algorithms.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class ResizingArrayStackOfStrings {

	private String[] arr = new String[1];
	private int size = 0;

	public void push(String item) {
		if( size == arr.length) {
			resize(2 * arr.length);
		}
			arr[size++] = item;
	}

	public String pop() throws IndexOutOfBoundsException{
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else if (size <= 1 / 4 * arr.length) {
			resize(1 /4 * arr.length);
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

	private void resize(int capacity) {
		String[] newArr = new String[capacity];
		for (int i = 0; i < size ; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public static void main(String[] args) {
		ResizingArrayStackOfStrings sos = new ResizingArrayStackOfStrings();
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