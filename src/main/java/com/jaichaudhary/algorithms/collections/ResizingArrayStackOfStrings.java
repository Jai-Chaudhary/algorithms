package com.jaichaudhary.algorithms.collections;

public class FixedCapacityStackOfStrings {

	private String[] arr = new String[1];
	private int size = 0;

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

	}

}