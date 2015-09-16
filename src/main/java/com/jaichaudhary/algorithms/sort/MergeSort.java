package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSort {
	private MergeSort() {

	}

	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, mid + 1, hi);
		sort(a, aux, lo, mid);
		merge(a, aux, lo, mid, hi);

	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[i], aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}

	private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
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
        MergeSort.sort(input);
        display(input);
    }
}