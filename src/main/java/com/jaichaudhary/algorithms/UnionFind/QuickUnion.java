public class QuickUnion
	implements UnionFind {
	private int[] id;
	private int count;

	public QuickUnion(int N){
		id = new int[N];
		count = N;
		for (int i = 0; i < N; i++) id[i] = i;
	}

	private int root(int p) {
		int i = p;
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}

	public int find(int p) {
		return root(p);
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int count(){
		return count;
	}

	public void union(int p, int q) {
		if(!connected(p, q)) {
			id[p] = id[q];
			count--;
		}

	}


	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFind uf = new QuickUnion(N);
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