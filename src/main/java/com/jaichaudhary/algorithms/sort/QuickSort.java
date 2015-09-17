package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

class QuickSort {
	private QuickSort(){
		
	}

	public static void sort(Comparable[] a) {
		
	}

	   // Test Client
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Double[] input = new Double[N];
        for(int i = 0; i < N; i++) {
            input[i] = StdRandom.uniform();
        }
        QuickSort.sort(input);
        display(input);
    }
}