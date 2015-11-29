package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    private QuickSort(){
        
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(lo < hi) {
            int pivotIdx = partition(a, lo, hi);
            sort(a, lo, pivotIdx - 1);
            sort(a, pivotIdx + 1, hi);
        }
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
        QuickSort.sort(input);
        display(input);
    }
}