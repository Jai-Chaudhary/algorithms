package com.jaichaudhary.algorithms.Sorts;


class MergeSort() {
	private MergeSort() {

	}

	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){

	}

	private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) > 0;
    }

    private static void exch(Object[] a, int u, int v) {
        Object temp = a[u];
        a[u] = a[v];
        a[v] = temp;
    } 
}