package com.jaichaudhary.algorithms.collections;

public class Queue<Item> {

	private Item[] newArr = (Item[]) new Object[1];
	private int size = 0;
	private int first = 0;
	private int last = 0;

	public void enqueue(Item item) {
		if(size == arr.length) {
			resize(2 * size);
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
		if(arr.length <=  size / 4) {
			resize(size / 2);
		}
		return item;
	}

	private void resize(int capacity){
		Item[] newArr = (Item[]) new Object[capacity];
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

}