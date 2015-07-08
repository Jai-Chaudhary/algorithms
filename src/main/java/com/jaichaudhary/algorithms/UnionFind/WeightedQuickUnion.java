public class WeightedQuickUnion
	implements UnionFind {
	private int[] id;
	private int[] size;
	private int count;

	public WeightedQuickUnion(int N) {
		id = new int[N];
		size = new int[N];

		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	private int root(int p) {
		int  i = p;
		while(id[i] != i)
		{
			id[i] = id[id[i]];
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
		if(!connected(p,q)) {
			int rootP = root(p);
			int rootQ = root(q);
			if(size[rootP] <= size[rootQ]) {
				id[rootP] = rootQ;
				size[rootQ] += size[rootP];
			} else {
				id[rootQ] = id[rootP];
				size[rootP] += size[rootQ];
			}
			count--;
		}
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFind uf = new WeightedQuickUnion(N);
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