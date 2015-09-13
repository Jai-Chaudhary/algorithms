package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {

	private InsertionSort() {
	}

	public static void sort(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = i ; j >= 0 && less(a[i], a[j]) ; j--) {
				exch(a, j, i);
			}
		}
	}

	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

    private static void display(Comparable[] a){
        for(int  i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

	public static void main(String[] args) {
        String[] input = StdIn.readAllStrings();
        InsertionSort.sort(input);
        display(input);
	}
}