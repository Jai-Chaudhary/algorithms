package com.jaichaudhary.algorithms.sort;


class MergeSort() {
	private MergeSort() {

	}

	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, mid, hi);
		sort(a, aux, lo, mid)
		return merge(a, aux, lo, hi);

	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for(int k = lo; k < hi; k++) {
			aux[k] = a[k];
		}

		int i;
		int j = mid;
		for(int k = lo; k < hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(a[i], a[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
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