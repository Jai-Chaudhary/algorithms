package com.jaichaudhary.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {

	private String[] arr = new String[2];
	private int size = 0;
	private int first = 0;
	private int last = 0;

	public void enqueue(String item) {
		if(size == arr.length) {
			resize(2 * arr.length);
		}
		arr[last++] = item;
		size++;
		if( last == arr.length) last = 0;
	}

	public String dequeue() throws IndexOutOfBoundsException{
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("Queue underflow");
		}
		String item = arr[first];
		arr[first] = null;
		size--;
		first++;
		if( first == arr.length)	first = 0;
		if(size <=  arr.length / 4)	resize(arr.length / 2);
		return item;
	}

	private void resize(int capacity){
		String[] copy = new String[capacity];
		for( int i = 0; i <= size; i++) {
			copy[i] = arr[(first + i) % arr.length];
		}
		arr = copy;
		first = 0;
		last = size;
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
			} else if (item.equals("--")) {
				while(!qos.isEmpty()){
					StdOut.println(qos.dequeue());
				}
			} else {
				qos.enqueue(item);
			}
		}
	}


}