package com.jaichaudhary.algorithms.UnionFind;

public interface UnionFind {
	public void union(int p, int q);
	public boolean connected(int p, int q);
	public int find(int p);
	public int count();
}