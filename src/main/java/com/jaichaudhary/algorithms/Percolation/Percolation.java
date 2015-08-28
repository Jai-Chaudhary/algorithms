package com.jaichaudhary.algorithms.Percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import com.jaichaudhary.algorithms.UnionFind.*;

public class Percolation {
    private int[][] grid;
    private WeightedQuickUnionUF uf;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        grid = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = 1;
            }
        }

        // generate union find representation from grid
        uf = new WeightedQuickUnionUF(N * N);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(isOpen(i, j)) {
                    if(i < (N - 1) && isOpen(i + 1, j))    uf.union(gridToArray(i, j), gridToArray(i + 1, j));
                    if (j < (N - 1) && isOpen(i, j + 1))   uf.union(gridToArray(i, j), gridToArray(i, j + 1));
                }
            }
        }
    }

    private boolean indicesInBound(int i, int j) {
        return ( i < grid.length && i >= 0) && ( j < grid[0].length && j >= 0);
    }

    private int gridToArray(int i, int j) {
        int columns = grid[0].length;
        return columns * i + j;
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) throws IndexOutOfBoundsException {
        if (indicesInBound(i, j)) {
            if (!isOpen(i, j)) {
                grid[i][j] = 0;
                if(i > 0 && isOpen(i - 1, j))   uf.union(gridToArray(i, j), gridToArray(i - 1, j));
                if(j > 0 && isOpen(i, j - 1))   uf.union(gridToArray(i, j), gridToArray(i, j - 1));
                if(i < grid.length - 1 && isOpen(i + 1, j))   uf.union(gridToArray(i, j), gridToArray(i + 1, j));
                if(j < grid[0].length - 1 && isOpen(i, j + 1))   uf.union(gridToArray(i, j), gridToArray(i, j + 1));
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        if (indicesInBound(i, j)) {
            return grid[i][j] == 0;
        } else {
            throw new IndexOutOfBoundsException();
        }
        
    }

    // is site (row i, column j) full?
    // Full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites.
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        if (indicesInBound(i, j)) {
            for(int k = 0; k < grid[0].length; k++) {
                if(uf.connected(gridToArray(i,j), gridToArray(0, k))) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // does the system percolate?
    public boolean percolates() {
        // check if the system percolates
        int bottomRow = grid[0].length - 1;
        for(int j = 0; j < grid.length; j++) {
            if(isFull(bottomRow, j)) {
                return true;
            }
        }

        return false;
    }
    
    // test client (optional)
    public static void main(String[] args) {
        Percolation simulation = new Percolation(2);
        StdOut.println(simulation.percolates());
        simulation.open(0,0);
        StdOut.println(simulation.percolates());
        simulation.open(0,1);
        StdOut.println(simulation.percolates());
        simulation.open(1,1);
        StdOut.println(simulation.percolates());
    }
}