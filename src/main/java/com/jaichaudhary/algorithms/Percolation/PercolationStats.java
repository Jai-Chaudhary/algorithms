package com.jaichaudhary.algorithms.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

	private double[] fractionOfOpenSites;
	private int experimentCount;
	// monte carlo experiment to estimate the percolation threshold
	// perform T independent experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		experimentCount = T;
		fractionOfOpenSites = new double[T];


		for (int experiment =0; experiment < T; experiment++) {
			Percolation simulation = new Percolation(N);
			int countOpen = 0;
			while(!simulation.percolates()) {
				int i,j;
				do {
					i = StdRandom.uniform(N);
					j = StdRandom.uniform(N);
				} while(simulation.isOpen(i, j));
				simulation.open(i,j);
				countOpen++;
			}
			fractionOfOpenSites[experiment] = ((double) countOpen )/ (N * N);
		}
	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(fractionOfOpenSites);
	}
	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(fractionOfOpenSites);
	}
	// low  endpoint of 95% confidence interval
	public double confidenceLo() {
		return mean() - (1.96 * stddev() / experimentCount);
	}
	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return mean() + (1.96 * stddev() / experimentCount);
	}
	// test client (described below)
	public static void main(String[] args) {
		PercolationStats stats= new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		StdOut.println("mean                    = " + stats.mean());
		StdOut.println("stddev                  = " + stats.stddev());
		StdOut.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
	}
}