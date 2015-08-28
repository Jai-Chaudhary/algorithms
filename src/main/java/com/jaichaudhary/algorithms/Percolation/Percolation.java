package com.jaichaudhary.algorithms.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.UF;

import com.jaichaudhary.algorithms.UnionFind.*;

public class Percolation {
    private int[][] grid;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; i < N; i++) {
                grid[i][j] = 1;
            }   
        }
    } 

    private boolean indicesInBound(int i, int j) {
        return ( i < grid.length && i >= 0) && ( j < grid[0].length && j >= 0);
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) throws IndexOutOfBoundsException {
        if (indicesInBound(i, j)) {
            if (isFull(i, j)) {
                grid[i][j] = 1;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        if (indicesInBound(i, j)) {
            return grid[i][j] == 1;
        } else {
            throw new IndexOutOfBoundsException();
        }
        
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        if (indicesInBound(i, j)) {
            return grid[i][j] == 0;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // does the system percolate?
    public boolean percolates() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(1);
        return false;
    }
    
    // test client (optional)
    public static void main(String[] args) {

    }
}