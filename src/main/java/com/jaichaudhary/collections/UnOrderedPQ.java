package com.jaichaudhary.collections;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class UnOrderedPQ<Item extends Comparable<Item>> {
	private int size;
	private Item[] unordered;
    
    // set inititial size of heap to hold size elements
    public UnOrderedPQ(int capacity) {
        unordered = (Item[]) new Comparable[capacity];
        size = 0;
    }

	public void insert(Item k) {
		if(size == unordered.length) {
			resizeArray(2 * unordered.length);
		}
		unordered[size] = k;
		size++;
	}

	public Item removeMax() {
		if(size > 0) {
			int maxIdx = 0;
			for(int i = 1; i < size; i++) {
				if(less(unordered[maxIdx], unordered[i])) {
					maxIdx = i;
				}
			}
			Item max = unordered[maxIdx];
			unordered[maxIdx] = unordered[size-1];
			size--;
			if(size <= unordered.length / 4) {
				resizeArray(unordered.length / 2);
			}
			return max;
		}
		return null;
	}

	public int size() {
		return size;
	}

	private boolean less(Item a, Item b) {
		return a.compareTo(b) < 0;
	}

	private void resizeArray(int newSize) {
		Item[] copy = (Item[]) new Comparable[newSize];
		for(int i = 0; i < size; i++) {
			copy[i] = unordered[i];
		}
		unordered = copy;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnOrderedPQ<Integer> pq = new UnOrderedPQ<Integer>(2);
        for(int i = 0; i < N; i++) {
        	int item = StdRandom.uniform(10);
            StdOut.printf("Inserted %d\n", item);
            pq.insert(item);
            if(i % 2 == 0) {
            	StdOut.printf("Removed Max %d\n", pq.removeMax());
            }
        }
	}
}