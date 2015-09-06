package com.jaichaudhary.algorithms.Percolation;

import edu.princeton.cs.algs4.StdOut;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private WeightedQuickUnionUF uf;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if (N < 1) {
            throw new IllegalArgumentException();
        }
        grid = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                grid[i][j] = 1;
            }
        }

        // generate union find representation from grid
        uf = new WeightedQuickUnionUF(N * N);
    }

    private boolean indicesInBound(int i, int j) {
        return (i < grid.length && i >= 1) && (j < grid[0].length && j >= 1);
    }

    private int gridToArray(int i, int j) {
        int columns = grid[0].length - 1;
        return columns * (i - 1) + (j - 1);
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        if (indicesInBound(i, j)) {
            if (!isOpen(i, j)) {
                grid[i][j] = 0;
                if (i > 1 && isOpen(i - 1, j))   uf.union(gridToArray(i, j), gridToArray(i - 1, j));
                if (j > 1 && isOpen(i, j - 1))   uf.union(gridToArray(i, j), gridToArray(i, j - 1));
                if (i < grid.length - 1 && isOpen(i + 1, j))   uf.union(gridToArray(i, j), gridToArray(i + 1, j));
                if (j < grid[0].length - 1 && isOpen(i, j + 1))   uf.union(gridToArray(i, j), gridToArray(i, j + 1));
            }
        } else {
            throw new IllegalArgumentException();
        }
        
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (indicesInBound(i, j)) {
            return grid[i][j] == 0;
        } else {
            throw new IllegalArgumentException();
        }
        
    }

    // is site (row i, column j) full?
    // Full site is an open site that can be connected to an open site in the top row 
    // via a chain of neighboring (left, right, up, down) open sites.
    public boolean isFull(int i, int j) {
        if (indicesInBound(i, j)) {
            if (isOpen(i, j)) {
                for (int k = 1; k < grid[0].length; k++) {
                    if (uf.connected(gridToArray(i, j), gridToArray(1, k))) {
                        return true;
                    }
                }
            }                
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // does the system percolate?
    public boolean percolates() {
        // check if the system percolates
        int bottomRow = grid[0].length - 1;
        for (int j = 1; j < grid.length; j++) {
            if (isFull(bottomRow, j)) {
                return true;
            }
        }

        return false;
    }
    
    // test client (optional)
    public static void main(String[] args) {
        Percolation simulation = new Percolation(2);
        StdOut.println(simulation.percolates());
        simulation.open(1, 1);
        StdOut.println(simulation.percolates());
        simulation.open(1, 2);
        StdOut.println(simulation.percolates());
        simulation.open(2, 2);
        StdOut.println(simulation.percolates());
    }
}