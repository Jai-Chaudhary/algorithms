package com.jaichaudhary.algorithms.collections;


public class ResizingArrayQueueOfStrings {

	private String[] arr;
	private int size;
	private int first = 0;
	private int last = 0;

	public void enqueue(String item) {
		if(size == arr.length) {
			resize(2 * arr.length);
		}
		last = (last + 1) % arr.length;
		arr[last] = item;
		size++;
	}

	public String dequeue() {
		String item = arr[first];
		first = (first + 1) % arr.length;
		size--;
		if(isEmpty()) {
			first = 0;
			last = 0;
		} else if(arr.length <= 1 / 4 * size) {
			resize(1 / 4 * size);
		}
		return item;
	}

	private void resize(int capacity){
		String[] newArr = new String[capacity];
		int count = 0;
		for( int i = first; i % arr.length != last; i++) {
			newArr[count] = arr[i % arr.length];
			count++;
		}
		arr = newArr;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}



}