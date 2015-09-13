package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class SelectionSort {
    
    private SelectionSort(){

    }

    public static void sort(Comparable[] a) {
        for(int i = 0; i < a.length; i++) {
            int minIdx = i;
            for(int j = i + 1; j < a.length; j++) {
                if(less(a[j], a[minIdx])) minIdx = j;
            }
            exch(a, i, minIdx);
        }
    }

    private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }

    private static void exch(Object[] a, int u, int v) {
        Object temp = a[u];
        a[u] = a[v];
        a[v] = temp;
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
        SelectionSort.sort(input);
        display(input);
    }

}