package com.jaichaudhary.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

	private Item[] arr = (Item[]) new Object[2];
	private int size = 0;

	public void push(Item item) {
		if( size == arr.length) {
			resize(2 * arr.length);
		}
			arr[size++] = item;
	}

	public Item pop() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException("Stack Underflow");
		} else if (size <=  arr.length / 4) {
			resize( arr.length / 2);
		}
		Item item = arr[--size];
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
		Item[] newArr = (Item[]) new Object[capacity];
		for (int i = 0; i < size ; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int current = size - 1;

		public boolean hasNext() {
			return current >= 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			return arr[current--];
		}

	}

	public static void main(String[] args) {
		Stack<String> sos = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("-")) {
				StdOut.println(sos.pop());
			} else if (item.equals("--")) {
				for(String s: sos) {
					StdOut.println(sos.pop());
				}
			} else {
				sos.push(item);
			}
		}
	}

}