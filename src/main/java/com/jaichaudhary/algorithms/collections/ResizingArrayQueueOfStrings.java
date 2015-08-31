package com.jaichaudhary.algorithms.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {

	private String[] arr = new String[1];
	private int size = 0;
	private int first = 0;
	private int last = 0;

	public void enqueue(String item) {
		if(size == arr.length) {
			resize(2 * size);
		}
		arr[last++] = item;
		size++;
		if( last == arr.length) last = 0;
	}

	public String dequeue() throws NoSuchElementException{
		if(isEmpty())	throw new NoSuchElementException("Queue underflow");
		String item = arr[first];
		arr[first] = null;
		size--;
		first++;
		if( first == arr.length)	first = 0;
 		if(arr.length <=  size / 4) {
			resize(size / 2);
		}
		return item;
	}

	private void resize(int capacity){
		String[] copy = new String[capacity];
		for( int i = 0; i <= size; i++) {
			copy[i] = arr[(first + i) % arr.length];
		}
		arr = copy;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		ResizingArrayQueueOfStrings qos = new ResizingArrayQueueOfStrings();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("-")) {
				StdOut.println(qos.dequeue());
			} else {
				qos.enqueue(item);
			}
		}
	}


}