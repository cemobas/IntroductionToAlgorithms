package alg.nonrecursive.vonneumann;

import java.util.Iterator;

public class VonNeumannBoard {
	
	private VonNeumannSet vonNeuSet;
	private int n;
	private	int[][] board;
	
	public VonNeumannBoard(int n) {
		this.n = n;
		this.vonNeuSet = new VonNeumannSet();
	}
	
	public void build() {
		vonNeuSet.addNewDot(0, 0);
		for(int a=0; a<n+1; ++a) {
			for(int x=0; x<a; ++x) {
				vonNeuSet.addNewDot(x, a-x);
				vonNeuSet.addNewDot(-x, x-a);
				vonNeuSet.addNewDot(a-x, -x);
				vonNeuSet.addNewDot(x-a, x);
			}
		}
	}

	public void printBoard() {
		initializeBoard(n);
		VonNeumannDot dot;
		Iterator<VonNeumannDot> vonNeuIte = vonNeuSet.iterator();
		while(vonNeuIte.hasNext()) {
			dot = (VonNeumannDot) vonNeuIte.next();
			board[dot.x+n+1][dot.y+n+1] = 1;
		}
		for(int i=0; i<2*n+3; ++i) {
			for(int j=0; j<2*n+3; ++j) {
				if(board[i][j]!=1){
					board[i][j] = 0;
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	private void initializeBoard(int n) {
		this.board = new int[2*n+3][2*n+3];
	}
}
