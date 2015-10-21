//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int mGridN;
	private WeightedQuickUnionUF mMatrix;
	private boolean mGridStatus[];
	
	private int indexMapping(int x, int y) {
		/* coordinates to arrays */
		return (x-1) * mGridN + y-1;
	}
	
    public Percolation(int N) {
	   // create N-by-N grid, with all sites blocked
    	if(N <= 0)
    		throw new IllegalArgumentException();
    	mGridN = N;
    	mMatrix = new WeightedQuickUnionUF(N*N);
    	mGridStatus = new boolean[N*N];
    	for(int i = 0; i < N*N; i++) {
    		mGridStatus[i] = false;
    	}
    	
	}
    public void open(int i, int j) {
	   // open site (row i, column j) if it is not open already
    	if(i < 1 || i > mGridN || j < 1 || j > mGridN)
    		throw new IndexOutOfBoundsException();
    	
    	if(!isOpen(i, j)) {
	    	mGridStatus[indexMapping(i, j)] = true;
	    	if(j-1 > 0 && mGridStatus[indexMapping(i, j-1)]) mMatrix.union(indexMapping(i, j), indexMapping(i, j-1));
	    	if(j+1 <= mGridN && mGridStatus[indexMapping(i, j+1)]) mMatrix.union(indexMapping(i, j), indexMapping(i, j+1));
	    	if(i-1 > 0 && mGridStatus[indexMapping(i-1, j)]) mMatrix.union(indexMapping(i, j), indexMapping(i-1, j));
	    	if(i+1 <= mGridN && mGridStatus[indexMapping(i+1, j)]) mMatrix.union(indexMapping(i, j), indexMapping(i+1, j));
    	}
       
    }
    public boolean isOpen(int i, int j) {
	   // is site (row i, column j) open?
    	if(i < 1 || i > mGridN || j < 1 || j > mGridN)
    		throw new IndexOutOfBoundsException();
    	return mGridStatus[indexMapping(i, j)];
    }
    
    public boolean isFull(int i, int j) {
	   // is site (row i, column j) full?, connect to top of row?
    	if(i < 1 || i > mGridN || j < 1 || j > mGridN)
    		throw new IndexOutOfBoundsException();
    	if(!isOpen(i, j)) return false;
    	for(int col = 1; col <= mGridN; col++) {
    		if(mMatrix.connected(indexMapping(i, j), indexMapping(1, col))) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean percolates() {
	   // does the system percolate?
    	for (int col = 1; col <= mGridN; col++) {
    		if(isFull(mGridN, col)) return true;
    	}
	   return false;
    }

    public static void main(String[] args) {
	   // test client (optional)
    	//String x = "123";
    	
    }
}
