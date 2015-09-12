package com.jaichaudhary.algorithms.Sorts;

public class ShellSort {

	private ShellSort() {
	}

	public static void sort(Comparable[] a) {
	
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
}