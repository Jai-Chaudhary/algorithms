package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {

	private ShellSort() {
	}

	public static void sort(Comparable[] a) {
		int h = 1;
		while(h < a.length) h = 3 * h + 1;
		while(h >= 1) {
			for(int i = h; i < a.length; i++) {
				for(int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h/3;
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

        // Test Client
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Double[] input = new Double[N];
        for(int i = 0; i < N; i++) {
            input[i] = StdRandom.uniform();
        }
        ShellSort.sort(input);
        display(input);
    }
}