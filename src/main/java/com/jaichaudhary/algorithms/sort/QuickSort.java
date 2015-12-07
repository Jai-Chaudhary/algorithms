package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    private QuickSort(){
        
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while(hi > lo) {
            int pivotIdx = partition(a, lo, hi);
            if (pivotIdx > k)   hi = pivotIdx - 1;
            else if (pivotIdx < k)  lo = pivotIdx + 1;
            else break;
        }
        return a[k];
    } 

    public static void sort3Way(Comparable[] a) {
        StdRandom.shuffle(a);
        sort3Way(a, 0, a.length - 1);
    }

    private static void sort3Way(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;

        Comparable partition = a[lo];
        int lt = lo;
        int i = lo;
        int gt = hi;

        while(gt >= i) {
            if(less(a[i], partition)) {
                swap(a, i, lt);
                lt++;
                i++;
            } else if (less(partition, a[i])) {
                swap(a, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        sort3Way(a, lo, lt - 1);
        sort3Way(a, gt + 1, hi);

        assert(isSorted(a, lo, hi));

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(lo < hi) {
            int pivotIdx = partition(a, lo, hi);
            sort(a, lo, pivotIdx - 1);
            sort(a, pivotIdx + 1, hi);
        }
        assert(isSorted(a, lo, hi));
    }

    private static int partition(Comparable[] a, int lo, int hi) {

        assert(lo < hi);

        int i = lo + 1;
        int j = hi;
        
        while(true) {
            while(i < hi && less(a[i], a[lo])) {
                i++;
            }

            while(j > lo && less(a[lo], a[j])) {
                j--;
            }

            if(i >= j) {
                break;
            }
            swap(a, i, j);

        }
        swap(a, lo, j);
        return j;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        if(lo >= hi)    return true;
        int mid = (lo + hi) / 2;
        return less(a[mid], a[mid+1]) && isSorted(a, lo, mid) && isSorted(a, mid+1, hi);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    private static void swap(Object[]a, int i, int j) {
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
        QuickSort.sort3Way(input);
        display(input);
    }
}