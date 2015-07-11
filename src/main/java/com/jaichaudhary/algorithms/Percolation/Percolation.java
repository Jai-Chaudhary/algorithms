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


    // open site (row i, column j) if it is not open already
    public void open(int i, int j) throws IndexOutOfBoundsException {

    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        return false;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }
    
    // test client (optional)
    public static void main(String[] args) {

    }
}