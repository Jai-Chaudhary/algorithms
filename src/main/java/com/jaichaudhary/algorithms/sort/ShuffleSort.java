package com.jaichaudhary.algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShuffleSort{
	private ShuffleSort() {};

	public static void shuffle(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			int randomIndex = StdRandom.uniform(i + 1);
			exch(a, i, randomIndex);
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

    private static void display(Comparable[] a){
        StdOut.println("Shuffled: ");
        for(int  i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

	public static void main(String[] args) {
		int N = StdIn.readInt();
		String[] input = new String[N];
		for(int i = 0; i < N; i++)	input[i] =  StdIn.readString();
		ShuffleSort.shuffle(input);
		display(input);
	}
}