package com.jaichaudhary.algorithms.Sorts;


class MergeSort() {
	private MergeSort() {

	}

	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		for(int i = 0; i < a.length; i++){
			aux[i] = a[i];
		}

		int mid = (lo + hi) / 2;
		sort(a, aux, mid, hi);
		sort(a, aux, lo, mid);
		return merge(a, aux, lo, hi);

	}

	private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) > 0;
    }

    private static void exch(Object[] a, int u, int v) {
        Object temp = a[u];
        a[u] = a[v];
        a[v] = temp;
    } 

    public static void main(String[] args) {

    }
}