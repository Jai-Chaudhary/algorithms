package com.jaichaudhary.applications;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class CountInversionsSlow {

	private CountInversionsSlow() {
	}

	public static int count(Comparable[] a) {
		int numOfInversions = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j > 0 && less(a[j], a[j-1]) ; j--) {
				exch(a, j, j-1);				
				numOfInversions++;
			}
		}
		return numOfInversions;
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
        int N = StdIn.readInt();
        Double[] input = new Double[N];
        for(int i = 0; i < N; i++) {
            input[i] = StdRandom.uniform();
        }
        display(input);
        StdOut.println("Inversions:" + CountInversionsSlow.count(input));
	}
}