package com.jaichaudhary.algorithms.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class QuickFind 
	implements UnionFind {
	private int[] id;
	private int count;

	public QuickFind(int N){
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++) id[i] = i;
	}

	public int count(){
		return count;
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public int find(int p){
		return id[p];
	}

	public void union(int p,int q) {
		int pid = id[p];
		int qid = id[q];
		if(pid != qid) {
			for(int i = 0; i < id.length; i++) {
				if (id[i] == pid) {
					id[i] = qid;
				}
			}
			count--;			
		}

	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFind uf = new QuickFind(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q)) {
				 uf.union(p, q);
				 StdOut.println(p + " " + q);
			}
		}
	}
}