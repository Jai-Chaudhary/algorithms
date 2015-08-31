package com.jaichaudhary.algorithms.collections;

public class ResizingArrayStackOfStrings {

	private String[] arr = new String[1];
	private int size = 0;

	public void push(String item) {
		if( size == arr.length) {
			String[] newArr = new String[arr.length * 2];
			for (int i = 0; i < arr.length ; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
			arr[size++] = item;
	}

	public String pop() throws IndexOutOfBoundsException{
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else if (size <= 1 / 4 * arr.length) {
			String[] newArr = new String[arr.length / 4];
			for (int i = 0; i < arr.length ; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
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