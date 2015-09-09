package com.jaichaudhary.algorithms.Sorts;


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

}