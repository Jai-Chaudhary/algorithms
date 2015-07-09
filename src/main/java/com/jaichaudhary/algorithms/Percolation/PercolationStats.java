public class PercolationStats {
   public PercolationStats(int N, int T)     // perform T independent experiments on an N-by-N grid
   public double mean()                      // sample mean of percolation threshold
   public double stddev()                    // sample standard deviation of percolation threshold
   public double confidenceLo()              // low  endpoint of 95% confidence interval
   public double confidenceHi()              // high endpoint of 95% confidence interval

   public static void main(String[] args)    // test client (described below)
}