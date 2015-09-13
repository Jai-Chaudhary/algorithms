package com.jaichaudhary.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

	private Item[] arr = (Item[]) new Object[2];
	private int size = 0;
	private int first = 0;
	private int last = 0;

	public void enqueue(Item item) {
		if(size == arr.length) {
			resize(2 * arr.length);
		}
		arr[last++] = item;
		size++;
		if( last == arr.length) last = 0;
	}

	public Item dequeue() throws NoSuchElementException{
		if(isEmpty())	throw new NoSuchElementException("Queue underflow");
		Item item = arr[first];
		arr[first] = null;
		size--;
		first++;
		if( first == arr.length)	first = 0;
		if(size > 0 && size == arr.length / 4) {
			resize(arr.length / 2);
		}
		return item;
	}

	private void resize(int capacity){
		Item[] copy = (Item[]) new Object[capacity];
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

	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;

		public boolean hasNext() {
			return  i < size  ;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = arr[(i + first) % arr.length];
			i++;
			return item;
		}

	}


	public static void main(String[] args) {
		Queue<String> qos = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("-")) {
				StdOut.println(qos.dequeue());
			} else if (item.equals("--")) {
				for(String s: qos) {
					StdOut.println(qos.dequeue());
				}
			} else {
				qos.enqueue(item);
			}
		}
	}
}